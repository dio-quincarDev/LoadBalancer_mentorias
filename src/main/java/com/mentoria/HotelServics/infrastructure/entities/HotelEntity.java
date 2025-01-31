package com.mentoria.HotelServics.infrastructure.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@RedisHash("hotel")
public class HotelEntity {
    @Id
    private String id;
    private String hotelName;

}
