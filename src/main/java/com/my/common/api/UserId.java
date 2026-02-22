package com.my.common.api;

import lombok.NonNull;

public record UserId(String value) {
    public static UserId of(@NonNull String value) {
        return new UserId(value);
    }

}