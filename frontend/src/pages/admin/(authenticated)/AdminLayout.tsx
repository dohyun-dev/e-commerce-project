import { Outlet } from "react-router-dom";
import { getCookie } from "@/lib/cookies";
import { cn } from "@/lib/utils";
import {
  AdminSidebarProvider,
  SidebarContent,
  SidebarFooter,
  SidebarHeader,
  SidebarInset,
  SidebarRail,
} from "@/components/ui/sidebar";
import { AdminNavGroup } from "@/components/layout/admin/AdminNavGroup.tsx";
import { AdminLayoutProvider } from "@/contexts/AdminLayoutProvider.tsx";
import { AdminSidebar } from "@/components/layout/admin/AdminSidebar.tsx";
import { adminSidebarData } from "@/components/layout/admin/data/AdminSideBarData.ts";
import { ThemeSwitch } from "@/components/ThemeSwitch.tsx";
import { AdminHeader } from "@/components/layout/admin/AdminHeader.tsx";
import { ProfileDropdown } from "@/components/layout/admin/ProfileDropDown.tsx";

type AuthenticatedLayoutProps = {
  children?: React.ReactNode;
};

export function AdminLayout({ children }: AuthenticatedLayoutProps) {
  const defaultOpen = getCookie("sidebar_state") !== "false";
  return (
    <AdminSidebarProvider defaultOpen={defaultOpen}>
      <AdminLayoutProvider>
        <AdminSidebar>
          <SidebarHeader></SidebarHeader>
          <SidebarContent>
            {adminSidebarData.navGroups.map((props) => (
              <AdminNavGroup key={props.title} {...props} />
            ))}
          </SidebarContent>
          <SidebarFooter></SidebarFooter>
          <SidebarRail />
        </AdminSidebar>
        <SidebarInset
          className={cn(
            "has-[[data-layout=fixed]]:h-svh",
            "peer-data-[variant=inset]:has-[[data-layout=fixed]]:h-[calc(100svh-(var(--spacing)*4))]",
            "@container/content",
          )}
        >
          <AdminHeader>
            <div className="ms-auto flex items-center space-x-4">
              <ThemeSwitch />
              <ProfileDropdown />
            </div>
          </AdminHeader>
          {children ?? <Outlet />}
        </SidebarInset>
      </AdminLayoutProvider>
    </AdminSidebarProvider>
  );
}
