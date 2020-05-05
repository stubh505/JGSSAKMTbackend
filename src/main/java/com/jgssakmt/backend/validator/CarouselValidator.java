package com.jgssakmt.backend.validator;

import com.jgssakmt.backend.exeptions.CarouselException;
import com.jgssakmt.backend.model.Carousel;

public class CarouselValidator {
    public static void validate(Carousel b) throws CarouselException {
        if (b.getBody() != null && b.getBody().length() > 200)
            throw new CarouselException("Invalid carousel body format.");
        if (b.getLabel() != null && b.getLabel().length() > 50)
            throw new CarouselException("Invalid carousel label.");
        if (b.getImage() == null || b.getImage().length() > 200 || !b.getImage().matches("(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?"))
            throw new CarouselException("Invalid carousel image url format.");
    }
}
