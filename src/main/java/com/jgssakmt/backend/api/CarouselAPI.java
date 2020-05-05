package com.jgssakmt.backend.api;

import com.jgssakmt.backend.model.Carousel;
import com.jgssakmt.backend.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("CarouselAPI")
public class CarouselAPI {

    @Autowired
    CarouselService carouselService;

    @GetMapping("/getCarousels")
    public ResponseEntity<List<Carousel>> getCarousels () throws Exception {
        try {
            List<Carousel> carousels = carouselService.getCarousels();
            return new ResponseEntity<>(carousels, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deleteCarousel/{id}")
    public ResponseEntity<Integer> deleteCarousel (@PathVariable Integer id) throws Exception {
        try {
            Integer carousels = carouselService.deleteCarousel(id);
            return new ResponseEntity<>(carousels, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/addCarousel")
    public ResponseEntity<Integer> addCarousel (@RequestBody Carousel id) throws Exception {
        try {
            Integer carousels = carouselService.addCarousel(id);
            return new ResponseEntity<>(carousels, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
