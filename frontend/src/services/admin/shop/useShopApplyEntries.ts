import axiosInstance from "@/lib/axiosInstance.ts";
import {ShopApplicationEntry} from "@/types/admin/shop/ShopApplicationEntry.ts";
import {useQuery} from "@tanstack/react-query";

type Params = {
    page?: number;
    size?: number;
};

export const useShopApplicationEntriesQuery = ({ page = 0, size = 10 }: Params) => {
    return useQuery({
        queryKey: ['shop-application-entries', page, size],
        queryFn: async () => {
            const res = await axiosInstance.get<ShopApplicationEntry>(
                `/api/v1/shop-application-entries`,
                { params: { page, size } }
            );
            return res.data;
        },
    });
};