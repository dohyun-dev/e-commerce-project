export type PageResponse<T> = {
    currentPage: number;
    totalPages: number;
    totalElements: number;
    items: T[];
    hasPrevious: boolean;
    hasNext: boolean;
};