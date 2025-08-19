import { useMutation } from "@tanstack/react-query";
import axiosInstance from "@/lib/axiosInstance.ts";
import { useAuthStore } from "@/stores/AuthStore.ts";

interface LoginRequest {
  username: string;
  password: string;
}

async function login(payload: LoginRequest): Promise<{ accessToken: string }> {
  const response = await axiosInstance.post("/login", payload); // baseURL: /api/v1 이므로 경로는 /login
  return response.data;
}

export function useAdminLoginMutation() {
  const setAccessToken = useAuthStore((state) => state.setAccessToken);
  const setUser = useAuthStore((state) => state.setUser);

  return useMutation({
    mutationFn: login,
    onSuccess: (data) => {
      setAccessToken(data.accessToken);

      // 옵션: 토큰에서 사용자 정보 디코드 후 저장
      const decoded = JSON.parse(atob(data.accessToken.split(".")[1]));
      setUser({
        id: decoded.sub,
        name: decoded.name,
        role: decoded.role,
        exp: decoded.exp,
      });
    },
    onError: (error) => {
      console.error("로그인 실패:", error);
    },
  });
}
