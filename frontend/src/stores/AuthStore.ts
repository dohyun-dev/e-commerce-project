import { create } from "zustand";
import { createJSONStorage, persist } from "zustand/middleware";
import { immer } from "zustand/middleware/immer";

export interface AuthUser {
  id: string;
  name: string;
  role: string[];
  exp: number;
}

export interface AuthState {
  user: AuthUser | null;
  accessToken: string;

  setUser: (user: AuthUser | null) => void;
  setAccessToken: (accessToken: string) => void;
  resetAccessToken: () => void;
  reset: () => void;
}

export const useAuthStore = create<AuthState>()(
  persist(
    immer((set) => ({
      user: null,
      accessToken: "",

      setUser: (user) =>
        set((state) => {
          state.user = user;
        }),

      setAccessToken: (accessToken: string) =>
        set((state) => {
          state.accessToken = accessToken;
        }),

      resetAccessToken: () =>
        set((state) => {
          state.accessToken = "";
        }),

      reset: () =>
        set((state) => {
          state.user = null;
          state.accessToken = "";
        }),
    })),
    {
      name: "auth-store",
      version: 1,
      storage: createJSONStorage(() => localStorage),
    },
  ),
);
