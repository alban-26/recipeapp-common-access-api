package com.my.common.api.pagination;

import com.my.common.api.UserId;

public interface PagedRepository <T, PR extends PageRequest> {
    PageResult<T> findAllByUser(UserId userId, PR pageRequest);
}
