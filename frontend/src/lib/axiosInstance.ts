import axios from "axios";
import { useAuthStore } from "@/stores/AuthStore.ts";

const axiosInstance = axios.create({
  baseURL: "/api/v1", // API 기본 경로
  headers: {
    "Content-Type": "application/json",
  },
});

axiosInstance.interceptors.request.use(
  (config) => {
    const token = useAuthStore.getState().auth.accessToken;
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error),
);

export default axiosInstance;
