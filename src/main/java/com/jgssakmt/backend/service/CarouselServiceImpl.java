package com.jgssakmt.backend.service;

import com.jgssakmt.backend.dao.CarouselDAO;
import com.jgssakmt.backend.exeptions.CarouselException;
import com.jgssakmt.backend.model.Carousel;
import com.jgssakmt.backend.validator.CarouselValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "carouselService")
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    CarouselDAO carouselDAO;

    @Override
    public List<Carousel> getCarousels() throws Exception {
        List<Carousel> carousels = carouselDAO.getCarousels();

        if (carousels == null || carousels.isEmpty())
            throw new CarouselException();
        return carousels;
    }

    @Override
    public Integer addCarousel(Carousel carousel) throws Exception {
        CarouselValidator.validate(carousel);
        Integer i = carouselDAO.addCarousel(carousel);

        if (i == null)
            throw new CarouselException("Error in adding new Carousel");
        return i;
    }

    @Override
    public Integer deleteCarousel(Integer id) throws Exception {
        if (id == null)
            throw new CarouselException("Error in deleting carousel");

        Integer i = carouselDAO.deleteCarousel(id);
        if (i == null)
            throw new CarouselException("Error in deleting carousel");
        return i;
    }
}
