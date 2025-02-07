package com.mentoria.HotelServics.application.service.impl;

import com.mentoria.HotelServics.domain.request.HotelCreateRequest;
import com.mentoria.HotelServics.application.service.HotelService;
import com.mentoria.HotelServics.infrastructure.entities.HotelEntity;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final StreamBridge streamBridge;

    @Override
    public Mono<Long> createHotel(HotelCreateRequest request) {
        return Mono.just(request)
                .map(this::mapToEntity)
                .flatMap(this::publishHotel);
    }

    @Override
    public Mono<List<HotelEntity>> getHotels() {
        return null;
    }

    private HotelEntity mapToEntity(HotelCreateRequest request) {
        return HotelEntity.builder()
                .hotelName(request.getHotelName())
                .build();
    }

    private Mono<Long> publishHotel(HotelEntity hotelEntity) {
        return Mono.just(hotelEntity)
                .doOnNext(hotel -> streamBridge.send("writeCache-out-o", hotel))
                .flatMap(hotel -> Mono.just(1L))
                .switchIfEmpty(Mono.just(0L));
    }
}
