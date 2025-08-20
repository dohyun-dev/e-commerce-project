import { BrowserRouter, Route, Routes } from "react-router-dom";
import MainLayout from "@/components/layout/main/MainLayout.tsx";
import HomePage from "@/pages/Home.tsx";
import { AdminLayout } from "@/pages/admin/(authenticated)/AdminLayout.tsx";
import AdminPage from "@/pages/admin/Admin.tsx";
import { AdminSignInPage } from "@/pages/admin/(auth)/sign-in";
import { ShopApplicationEntries } from "@/pages/admin/(authenticated)/shop-application-entries/ShopApplicationEntries.tsx";

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
            <Route
              path="shop-application-entries"
              element={<ShopApplicationEntries />}
            />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
