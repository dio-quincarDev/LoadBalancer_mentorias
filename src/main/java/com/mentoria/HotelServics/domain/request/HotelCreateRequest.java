package com.mentoria.HotelServics.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HotelCreateRequest {
    @NotNull
    private String hotelName;
}
