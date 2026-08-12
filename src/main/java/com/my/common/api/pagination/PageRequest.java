package com.my.common.api.pagination;

public interface PageRequest {

    int page();

    int size();

    String searchQuery();

    default int offset() {
        return page() * size();
    }
}