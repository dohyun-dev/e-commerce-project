import type { To } from "react-router-dom";

type AdminBaseNavItem = {
  title: string;
  badge?: string;
  icon?: React.ElementType;
};

type AdminNavLink = AdminBaseNavItem & {
  url: To;
  items?: never;
};

type AdminNavCollapsible = AdminBaseNavItem & {
  items: (AdminBaseNavItem & { url: To })[];
  url?: never;
};

type AdminNavItem = AdminNavCollapsible | AdminNavLink;

type AdminNavGroup = {
  title: string;
  items: AdminNavItem[];
};

export type { AdminNavGroup, AdminNavItem, AdminNavCollapsible, AdminNavLink };
