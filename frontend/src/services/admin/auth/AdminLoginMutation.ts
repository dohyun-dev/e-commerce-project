import { useMutation } from "@tanstack/react-query";
import axiosInstance from "@/lib/axiosInstance.ts";
import { useAuthStore } from "@/stores/AuthStore.ts";

export interface LoginRequest {
  username: string;
  password: string;
}

async function login(payload: LoginRequest): Promise<string> {
  const response = await axiosInstance.post("/api/v1/auth/login", payload);
  return response.data;
}

export function useAdminLoginMutation() {
  const setAccessToken = useAuthStore((state) => state.setAccessToken);
  const setUser = useAuthStore((state) => state.setUser);

  return useMutation({
    mutationFn: login,
    onSuccess: (accessToken: string) => {
      setAccessToken(accessToken);

      const decoded = JSON.parse(atob(accessToken.split(".")[1]));
      setUser({
        id: decoded.sub,
        name: decoded.name,
        role: decoded.role,
        exp: decoded.exp,
      });
    },
  });
}
