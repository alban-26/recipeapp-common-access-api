package com.my.common.api;

import java.util.List;

public record PageResult<T>(
    List<T> content,
    long totalElements,
    int page,
    int size
) {}