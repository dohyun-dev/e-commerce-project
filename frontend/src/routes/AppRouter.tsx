import { BrowserRouter, Route, Routes } from "react-router-dom";
import MainLayout from "@/layouts/MainLayout.tsx";
import HomePage from "@/pages/Home.tsx";
import AdminLayout from "@/layouts/AdminLayout.tsx";
import AdminPage from "@/pages/admin/Admin.tsx";
import { AdminSignInPage } from "@/pages/admin/(auth)/sign-in";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route index element={<HomePage />} />
        </Route>
        <Route path="/admin">
          <Route path="sign-in" element={<AdminSignInPage />} />
          <Route element={<AdminLayout />}>
            <Route index element={<AdminPage />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
