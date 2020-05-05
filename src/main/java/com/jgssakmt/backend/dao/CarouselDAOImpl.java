package com.jgssakmt.backend.dao;

import com.jgssakmt.backend.entity.CarouselEntity;
import com.jgssakmt.backend.model.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "carouselDAO")
public class CarouselDAOImpl implements CarouselDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Carousel> getCarousels() throws Exception {
        Query query = entityManager.createQuery("select c from CarouselEntity c");
        List<CarouselEntity> entities = query.getResultList();

        List<Carousel> carousels = null;

        if (entities != null && !entities.isEmpty()) {
            carousels = new ArrayList<>();
            Carousel carousel;

            for (CarouselEntity entity:entities) {
                carousel = new Carousel();
                carousel.setId(entity.getId());
                carousel.setBody(entity.getBody());
                carousel.setImage(entity.getImage());
                carousel.setLabel(entity.getImage());

                carousels.add(carousel);
            }
        }
        return carousels;
    }

    @Override
    public Integer addCarousel(Carousel carousel) throws Exception {
        CarouselEntity entity = new CarouselEntity();
        entity.setBody(carousel.getBody());
        entity.setImage(carousel.getImage());
        entity.setLabel(carousel.getLabel());

        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public Integer deleteCarousel(Integer id) throws Exception {
        CarouselEntity entity = entityManager.find(CarouselEntity.class, id);
        Integer carousel = null;

        if (entity != null) {
            entityManager.remove(entity);
            carousel = entity.getId();
        }
        return carousel;
    }
}
