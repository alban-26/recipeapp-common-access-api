package com.my.common.api.pagination;

public record PageRequest(
        int page,
        int size,
        String searchQuery
) {
    public PageRequest {
        if (page < 0) {
            throw new IllegalArgumentException("Page must not be negative");
        }

        if (size <= 0 || size > 100) {
            throw new IllegalArgumentException("Size must be between 1 and 100");
        }
    }

    public int offset() {
        return page * size;
    }
}