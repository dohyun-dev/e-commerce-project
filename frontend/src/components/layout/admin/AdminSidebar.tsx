import { Sidebar } from "@/components/ui/sidebar.tsx";
import { useLayout } from "@/contexts/AdminLayoutProvider.tsx";

export function AdminSidebar({
  ...props
}: React.ComponentProps<typeof Sidebar>) {
  const { collapsible, variant } = useLayout();
  return <Sidebar {...props} collapsible={collapsible} variant={variant} />;
}
