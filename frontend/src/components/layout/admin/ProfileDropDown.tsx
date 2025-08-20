import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import { useAuthStore } from "@/stores/AuthStore.ts";

export function ProfileDropdown() {
  const user = useAuthStore().user;
  return (
    <DropdownMenu modal={false}>
      <DropdownMenuTrigger asChild>
        <Button variant="ghost" className="relative h-8 w-8 rounded-full">
          <Avatar className="h-8 w-8">
            {/*<AvatarImage src="/avatars/01.png" alt="@shadcn" />*/}
            <AvatarFallback>{user?.name}</AvatarFallback>
          </Avatar>
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent className="w-56" align="end" forceMount>
        <DropdownMenuLabel className="font-normal">
          <div className="flex flex-col gap-1.5">
            <p className="text-sm leading-none font-medium">{user?.name}</p>
            <p className="text-muted-foreground text-xs leading-none">
              {user?.role}
            </p>
          </div>
        </DropdownMenuLabel>
        {/*<DropdownMenuSeparator />*/}
        {/*<DropdownMenuGroup>*/}
        {/*  <DropdownMenuItem asChild>*/}
        {/*    <Link to="/settings">*/}
        {/*      Profile*/}
        {/*      <DropdownMenuShortcut>⇧⌘P</DropdownMenuShortcut>*/}
        {/*    </Link>*/}
        {/*  </DropdownMenuItem>*/}
        {/*  <DropdownMenuItem asChild>*/}
        {/*    <Link to="/settings">*/}
        {/*      Billing*/}
        {/*      <DropdownMenuShortcut>⌘B</DropdownMenuShortcut>*/}
        {/*    </Link>*/}
        {/*  </DropdownMenuItem>*/}
        {/*  <DropdownMenuItem asChild>*/}
        {/*    <Link to="/settings">*/}
        {/*      Settings*/}
        {/*      <DropdownMenuShortcut>⌘S</DropdownMenuShortcut>*/}
        {/*    </Link>*/}
        {/*  </DropdownMenuItem>*/}
        {/*  <DropdownMenuItem>New Team</DropdownMenuItem>*/}
        {/*</DropdownMenuGroup>*/}
        <DropdownMenuSeparator />
        <DropdownMenuItem>로그아웃</DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
}
