package com.jgssakmt.backend.validator;

import com.jgssakmt.backend.exeptions.EventsException;
import com.jgssakmt.backend.model.Events;

public class EventsValidator {
    public static void validate(Events b) throws EventsException {
        if (b.getName() == null || b.getName().length() > 50 || b.getName().equals(""))
            throw new EventsException("Invalid event name format.");
        if (b.getDescription() == null || b.getDescription().length() > 2000 || b.getDescription().equals(""))
            throw new EventsException("Invalid event content.");
        if (b.getExcerpt() == null || b.getExcerpt().length() > 120 || b.getExcerpt().equals(""))
            throw new EventsException("Invalid event excerpt format.");
        if (b.getEndTime().isBefore(b.getStartTime()))
            throw new EventsException("Invalid event time duration.");
        if (b.getImgUrl() != null) {
            if (b.getImgUrl().length() > 200 || !b.getImgUrl().matches("(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?"))
                throw new EventsException("Invalid event image url format.");
        }
    }
}
