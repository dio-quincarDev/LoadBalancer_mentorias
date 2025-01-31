package com.mentoria.HotelServics.domain.service.impl;

import com.mentoria.HotelServics.domain.request.HotelCreateRequest;
import com.mentoria.HotelServics.domain.service.HotelService;
import com.mentoria.HotelServics.infrastructure.entities.HotelEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Override
    public Mono<Long> createHotel(HotelCreateRequest request) {
        return null;
    }

    @Override
    public Mono<List<HotelEntity>> getHotels() {
        return null;
    }
}
