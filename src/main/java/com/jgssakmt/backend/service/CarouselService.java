package com.jgssakmt.backend.service;

import com.jgssakmt.backend.model.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * Service to retrieve all carousels
     * @return list of persisted carousels
     * @throws Exception Unable to retrieve
     */
    List<Carousel> getCarousels () throws Exception;

    /**
     * Service to add carousel
     * @param carousel carousel body
     * @return persisted id
     * @throws Exception Unable to persist
     */
    Integer addCarousel (Carousel carousel) throws Exception;

    /**
     * Service to delete persisted entity
     * @param id entity id
     * @return persisted id
     * @throws Exception Unable to delete
     */
    Integer deleteCarousel (Integer id) throws Exception;
}
