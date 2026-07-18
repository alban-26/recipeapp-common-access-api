package com.my.common.api.pagination;

import java.util.List;

public record PageResult<T>(
    List<T> content,
    long totalElements,
    int totalPages,
    int page,
    int size,
    boolean last
) {}