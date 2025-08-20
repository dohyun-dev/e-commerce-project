import { type ReactNode } from "react";
import { ChevronRight } from "lucide-react";
import {
  Collapsible,
  CollapsibleContent,
  CollapsibleTrigger,
} from "@/components/ui/collapsible";
import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarMenuSub,
  SidebarMenuSubButton,
  SidebarMenuSubItem,
  useSidebar,
} from "@/components/ui/sidebar";
import { Link, useLocation, type To } from "react-router-dom";
import { Badge } from "@/components/ui/badge.tsx";
import {
  AdminNavCollapsible,
  AdminNavGroup as AdminNavGroupType,
  AdminNavItem,
  AdminNavLink,
} from "@/components/layout/admin/types.ts";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu.tsx";

export function AdminNavGroup({ title, items }: AdminNavGroupType) {
  const { state, isMobile } = useSidebar();
  const location = useLocation();
  const href = currentHref(location);

  return (
    <SidebarGroup>
      <SidebarGroupLabel>{title}</SidebarGroupLabel>
      <SidebarMenu>
        {items.map((item) => {
          const key = `${item.title}-${("url" in item && toPathString(item.url)) ?? "group"}`;

          if (!("items" in item) || item.items == null) {
            return (
              <AdminSidebarMenuLink
                key={key}
                item={item as AdminNavLink}
                href={href}
              />
            );
          }

          if (state === "collapsed" && !isMobile) {
            return (
              <AdminSidebarMenuCollapsedDropdown
                key={key}
                item={item as AdminNavCollapsible}
                href={href}
              />
            );
          }

          return (
            <AdminSidebarMenuCollapsible
              key={key}
              item={item as AdminNavCollapsible}
              href={href}
            />
          );
        })}
      </SidebarMenu>
    </SidebarGroup>
  );
}

function AdminNavBadge({ children }: { children: ReactNode }) {
  return <Badge className="rounded-full px-1 py-0 text-xs">{children}</Badge>;
}

function AdminSidebarMenuLink({
  item,
  href,
}: {
  item: AdminNavLink;
  href: string;
}) {
  const { setOpenMobile } = useSidebar();
  return (
    <SidebarMenuItem>
      <SidebarMenuButton
        asChild
        isActive={checkIsActive(href, item)}
        tooltip={item.title}
      >
        <Link to={item.url} onClick={() => setOpenMobile(false)}>
          {item.icon && <item.icon />}
          <span>{item.title}</span>
          {item.badge && <AdminNavBadge>{item.badge}</AdminNavBadge>}
        </Link>
      </SidebarMenuButton>
    </SidebarMenuItem>
  );
}

function AdminSidebarMenuCollapsible({
  item,
  href,
}: {
  item: AdminNavCollapsible;
  href: string;
}) {
  const { setOpenMobile } = useSidebar();
  return (
    <Collapsible
      asChild
      defaultOpen={checkIsActive(href, item, true)}
      className="group/collapsible"
    >
      <SidebarMenuItem>
        <CollapsibleTrigger asChild>
          <SidebarMenuButton tooltip={item.title}>
            {item.icon && <item.icon />}
            <span>{item.title}</span>
            {item.badge && <AdminNavBadge>{item.badge}</AdminNavBadge>}
            <ChevronRight className="ms-auto transition-transform duration-200 group-data-[state=open]/collapsible:rotate-90" />
          </SidebarMenuButton>
        </CollapsibleTrigger>
        <CollapsibleContent className="CollapsibleContent">
          <SidebarMenuSub>
            {item.items.map((subItem) => (
              <SidebarMenuSubItem
                key={`${subItem.title}-${toPathString(subItem.url)}`}
              >
                <SidebarMenuSubButton
                  asChild
                  isActive={checkIsActive(href, subItem)}
                >
                  <Link to={subItem.url} onClick={() => setOpenMobile(false)}>
                    {subItem.icon && <subItem.icon />}
                    <span>{subItem.title}</span>
                    {subItem.badge && (
                      <AdminNavBadge>{subItem.badge}</AdminNavBadge>
                    )}
                  </Link>
                </SidebarMenuSubButton>
              </SidebarMenuSubItem>
            ))}
          </SidebarMenuSub>
        </CollapsibleContent>
      </SidebarMenuItem>
    </Collapsible>
  );
}

function AdminSidebarMenuCollapsedDropdown({
  item,
  href,
}: {
  item: AdminNavCollapsible;
  href: string;
}) {
  return (
    <SidebarMenuItem>
      <DropdownMenu>
        <DropdownMenuTrigger asChild>
          <SidebarMenuButton
            tooltip={item.title}
            isActive={checkIsActive(href, item)}
          >
            {item.icon && <item.icon />}
            <span>{item.title}</span>
            {item.badge && <AdminNavBadge>{item.badge}</AdminNavBadge>}
            <ChevronRight className="ms-auto transition-transform duration-200 group-data-[state=open]/collapsible:rotate-90" />
          </SidebarMenuButton>
        </DropdownMenuTrigger>
        <DropdownMenuContent side="right" align="start" sideOffset={4}>
          <DropdownMenuLabel>
            {item.title} {item.badge ? `(${item.badge})` : ""}
          </DropdownMenuLabel>
          <DropdownMenuSeparator />
          {item.items.map((sub) => (
            <DropdownMenuItem
              key={`${sub.title}-${toPathString(sub.url)}`}
              asChild
            >
              <Link
                to={sub.url}
                className={`${checkIsActive(href, sub) ? "bg-secondary" : ""}`}
              >
                {sub.icon && <sub.icon />}
                <span className="max-w-52 text-wrap">{sub.title}</span>
                {sub.badge && (
                  <span className="ms-auto text-xs">{sub.badge}</span>
                )}
              </Link>
            </DropdownMenuItem>
          ))}
        </DropdownMenuContent>
      </DropdownMenu>
    </SidebarMenuItem>
  );
}

function toPathString(to?: To): string | undefined {
  if (to == null) return undefined;
  if (typeof to === "string") return to;
  // Partial<Path>
  const pathname = to.pathname ?? "";
  const search = to.search ?? "";
  const hash = to.hash ?? "";
  return `${pathname}${search}${hash}`;
}

function currentHref(loc: ReturnType<typeof useLocation>): string {
  return `${loc.pathname}${loc.search}${loc.hash}`;
}

function firstSeg(path: string): string {
  const noQuery = path.split("?")[0] ?? "";
  const p = noQuery.startsWith("/") ? noQuery.slice(1) : noQuery;
  return p.split("/")[0] ?? "";
}

function checkIsActive(
  href: string,
  item: AdminNavItem,
  mainNav = false,
): boolean {
  const hrefNoQuery = href.split("?")[0] ?? "";

  const selfUrl = "url" in item ? toPathString(item.url) : undefined;
  const selfMatch = !!selfUrl && (href === selfUrl || hrefNoQuery === selfUrl);

  const childMatch =
    "items" in item &&
    item.items?.some((i) => {
      const childUrl = toPathString(i.url);
      return !!childUrl && (href === childUrl || hrefNoQuery === childUrl);
    });

  const segMatch =
    mainNav &&
    !!selfUrl &&
    firstSeg(hrefNoQuery) !== "" &&
    firstSeg(hrefNoQuery) === firstSeg(selfUrl);

  return Boolean(selfMatch || childMatch || segMatch);
}
