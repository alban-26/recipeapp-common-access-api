package com.my.common.api.pagination;

import java.util.Objects;


public class PageRequestImpl implements PageRequest {

    private final int page;
    private final int size;
    private final String searchQuery;

    public PageRequestImpl(int page, int size, String searchQuery) {   // 1. Konstruktorname
        if (page < 0) {
            throw new IllegalArgumentException("Page must not be negative");
        }
        if (size <= 0 || size > 100) {
            throw new IllegalArgumentException("Size must be between 1 and 100");
        }
        this.page = page;
        this.size = size;
        this.searchQuery = searchQuery;
    }

    @Override
    public int page() {
        return page;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String searchQuery() {
        return searchQuery;
    }

    @Override
    public int offset() {
        return page * size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageRequestImpl other)) return false;   // 2. instanceof-Typ
        return page == other.page
                && size == other.size
                && Objects.equals(searchQuery, other.searchQuery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size, searchQuery);
    }

    @Override
    public String toString() {
        return "PageRequestImpl[page=" + page + ", size=" + size    // 3. optional, Konsistenz
                + ", searchQuery=" + searchQuery + "]";
    }
}