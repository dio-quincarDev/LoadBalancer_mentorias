package com.mentoria.HotelServics.domain.service;

import com.mentoria.HotelServics.domain.request.HotelCreateRequest;
import com.mentoria.HotelServics.infrastructure.entities.HotelEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface HotelService {
    Mono<Long> createHotel(HotelCreateRequest request);

    Mono<List<HotelEntity>>getHotels();
}
