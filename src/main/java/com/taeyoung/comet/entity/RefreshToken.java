package com.taeyoung.comet.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "RefreshToken", timeToLive = 14 * 24 * 60 * 60 * 1000L )
public class RefreshToken {

    @Id
    private String token;

    private String userId;

    @Builder
    public RefreshToken(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
