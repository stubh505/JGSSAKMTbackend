package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.model.Carousel;

import java.util.List;

public interface CarouselDAO {
    List<Carousel> getCarousels () throws Exception;
    Integer addCarousel (Carousel carousel) throws Exception;
    Integer deleteCarousel (Integer id) throws Exception;
}
