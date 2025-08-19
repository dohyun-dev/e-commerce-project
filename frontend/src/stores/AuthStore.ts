import { create } from "zustand";
import { persist, createJSONStorage } from "zustand/middleware";
import { immer } from "zustand/middleware/immer";

interface AuthUser {
  id: string;
  name: string;
  role: string[];
  exp: number;
}

interface AuthSlice {
  user: AuthUser | null;
  setUser: (user: AuthUser | null) => void;
  accessToken: string;
  setAccessToken: (accessToken: string) => void;
  resetAccessToken: () => void;
  reset: () => void;
}

interface AuthState {
  auth: AuthSlice;
}

export const useAuthStore = create<AuthState>()(
  immer(
    persist(
      (set) => ({
        auth: {
          user: null,
          accessToken: "",
          setUser: (user) =>
            set((state) => {
              state.auth.user = user;
            }),
          setAccessToken: (accessToken) =>
            set((state) => {
              state.auth.accessToken = accessToken;
            }),
          resetAccessToken: () =>
            set((state) => {
              state.auth.accessToken = "";
            }),
          reset: () =>
            set((state) => {
              state.auth.user = null;
              state.auth.accessToken = "";
            }),
        },
      }),
      {
        name: "auth-store",
        version: 1,
        storage: createJSONStorage(() => sessionStorage),
        partialize: (state) => ({
          auth: {
            user: state.auth.user,
            accessToken: state.auth.accessToken,
          },
        }),
      },
    ),
  ),
);

export const useAuth = () => useAuthStore((state) => state.auth);
