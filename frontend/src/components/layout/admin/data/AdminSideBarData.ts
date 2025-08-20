import { StoreIcon } from "lucide-react";
import { AdminNavGroup } from "@/components/layout/admin/types.ts";

export type AdminSidebarData = {
  navGroups: AdminNavGroup[];
};

export const adminSidebarData: AdminSidebarData = {
  navGroups: [
    {
      title: "상점관리",
      items: [
        {
          title: "상점관리",
          icon: StoreIcon,
          items: [
            {
              title: "입점 신청 목록",
              url: "/admin/shop-apply-entries/list",
            },
            {
              title: "상점 목록",
              url: "/admin/shops/list",
            },
          ],
        },
      ],
    },
    //   {
    //     title: "General",
    //     items: [
    //       {
    //         title: "Dashboard",
    //         url: "/",
    //         icon: LayoutDashboard,
    //       },
    //       {
    //         title: "Tasks",
    //         url: "/tasks",
    //         icon: ListTodo,
    //       },
    //       {
    //         title: "Apps",
    //         url: "/apps",
    //         icon: Package,
    //       },
    //       {
    //         title: "Chats",
    //         url: "/chats",
    //         badge: "3",
    //         icon: MessagesSquare,
    //       },
    //       {
    //         title: "Users",
    //         url: "/users",
    //         icon: Users,
    //       },
    //       {
    //         title: "Secured by Clerk",
    //         items: [
    //           {
    //             title: "Sign In",
    //             url: "/clerk/sign-in",
    //           },
    //           {
    //             title: "Sign Up",
    //             url: "/clerk/sign-up",
    //           },
    //           {
    //             title: "User Management",
    //             url: "/clerk/user-management",
    //           },
    //         ],
    //       },
    //     ],
    //   },
    //   {
    //     title: "Pages",
    //     items: [
    //       {
    //         title: "Auth",
    //         icon: ShieldCheck,
    //         items: [
    //           {
    //             title: "Sign In",
    //             url: "/sign-in",
    //           },
    //           {
    //             title: "Sign In (2 Col)",
    //             url: "/sign-in-2",
    //           },
    //           {
    //             title: "Sign Up",
    //             url: "/sign-up",
    //           },
    //           {
    //             title: "Forgot Password",
    //             url: "/forgot-password",
    //           },
    //           {
    //             title: "OTP",
    //             url: "/otp",
    //           },
    //         ],
    //       },
    //       {
    //         title: "Errors",
    //         icon: Bug,
    //         items: [
    //           {
    //             title: "Unauthorized",
    //             url: "/errors/unauthorized",
    //             icon: Lock,
    //           },
    //           {
    //             title: "Forbidden",
    //             url: "/errors/forbidden",
    //             icon: UserX,
    //           },
    //           {
    //             title: "Not Found",
    //             url: "/errors/not-found",
    //             icon: FileX,
    //           },
    //           {
    //             title: "Internal Server Error",
    //             url: "/errors/internal-server-error",
    //             icon: ServerOff,
    //           },
    //           {
    //             title: "Maintenance Error",
    //             url: "/errors/maintenance-error",
    //             icon: Construction,
    //           },
    //         ],
    //       },
    //     ],
    //   },
    //   {
    //     title: "Other",
    //     items: [
    //       {
    //         title: "Settings",
    //         icon: Settings,
    //         items: [
    //           {
    //             title: "Profile",
    //             url: "/settings",
    //             icon: UserCog,
    //           },
    //           {
    //             title: "Account",
    //             url: "/settings/account",
    //             icon: Wrench,
    //           },
    //           {
    //             title: "Appearance",
    //             url: "/settings/appearance",
    //             icon: Palette,
    //           },
    //           {
    //             title: "Notifications",
    //             url: "/settings/notifications",
    //             icon: Bell,
    //           },
    //           {
    //             title: "Display",
    //             url: "/settings/display",
    //             icon: Monitor,
    //           },
    //         ],
    //       },
    //       {
    //         title: "Help Center",
    //         url: "/help-center",
    //         icon: HelpCircle,
    //       },
    //     ],
    //   },
  ],
};
