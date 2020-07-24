package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Carousel;

import java.util.List;

public interface CarouselDAO {

    /**
     * Function to retrieve all carousels
     * @return list of persisted carousels
     * @throws Exception Unable to retrieve
     */
    List<Carousel> getCarousels () throws Exception;

    /**
     * Function to add carousel
     * @param carousel carousel body
     * @return persisted id
     * @throws Exception Unable to persist
     */
    Integer addCarousel (Carousel carousel) throws Exception;

    /**
     * Function to delete persisted entity
     * @param id entity id
     * @return persisted id
     * @throws Exception Unable to delete
     */
    Integer deleteCarousel (Integer id) throws Exception;
}
