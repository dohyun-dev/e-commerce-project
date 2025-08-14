import "./App.css";
import AppRouter from "@/routes/AppRouter.tsx";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <AppRouter />
    </QueryClientProvider>
  );
}

const queryClient = new QueryClient({});

export default App;
