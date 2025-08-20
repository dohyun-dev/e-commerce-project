import { useForm } from "react-hook-form";
import { cn } from "@/lib/utils.ts";
import { Button } from "@/components/ui/button.tsx";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form.tsx";
import { Input } from "@/components/ui/input.tsx";
import { PasswordInput } from "@/components/ui/password-input.tsx";
import {
  LoginRequest,
  useAdminLoginMutation,
} from "@/services/admin/auth/AdminLoginMutation.ts";
import { useNavigate } from "react-router-dom";

export function AdminSignInForm({
  className,
  ...props
}: React.HTMLAttributes<HTMLFormElement>) {
  const navigate = useNavigate();

  const adminLoginMutation = useAdminLoginMutation();

  const form = useForm({
    defaultValues: {
      username: "",
      password: "",
    },
  });

  function onSubmit(data: object) {
    return adminLoginMutation.mutate(data as LoginRequest, {
      onSuccess: () => {
        navigate("/admin");
      },
    });
  }

  return (
    <Form {...form}>
      <form
        onSubmit={form.handleSubmit(onSubmit)}
        className={cn("grid gap-3", className)}
        {...props}
      >
        <FormField
          control={form.control}
          name="username"
          render={({ field }) => (
            <FormItem>
              <FormLabel>아이디</FormLabel>
              <FormControl>
                <Input placeholder="name@example.com" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <FormItem className="relative">
              <FormLabel>비밀번호</FormLabel>
              <FormControl>
                <PasswordInput placeholder="********" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <Button className="mt-2" disabled={adminLoginMutation.isPending}>
          로그인
        </Button>
      </form>
    </Form>
  );
}
