import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card.tsx";
import { AdminSignInForm } from "@/pages/admin/(auth)/sign-in/components/AdminSignInForm.tsx";
import { AdminAuthLayout } from "@/pages/admin/(auth)/AdminAuthLayout.tsx";

export function AdminSignInPage() {
  return (
    <AdminAuthLayout>
      <Card className="gap-4">
        <CardHeader>
          <CardTitle className="text-lg tracking-tight">
            관리자 로그인
          </CardTitle>
          <CardDescription>
            이메일과 비밀번호를 입력해 <br />
            관리자 계정으로 로그인하세요.
          </CardDescription>
        </CardHeader>
        <CardContent>
          <AdminSignInForm />
        </CardContent>
        <CardFooter />
      </Card>
    </AdminAuthLayout>
  );
}
