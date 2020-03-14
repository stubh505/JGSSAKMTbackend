package com.jgssakmt.backend.validator;

import com.jgssakmt.backend.exeptions.BlogsException;
import com.jgssakmt.backend.model.Blogs;

public class BlogsValidator {
    public static void validate(Blogs b) throws BlogsException {
        if (b.getTitle() == null || b.getTitle().length() > 50 || b.getTitle().equals(""))
            throw new BlogsException("Invalid blog title format.");
        if (b.getContent() == null || b.getContent().length() > 2000 || b.getContent().equals(""))
            throw new BlogsException("Invalid blog content.");
        if (b.getExcerpt() == null || b.getExcerpt().length() > 120 || b.getExcerpt().equals(""))
            throw new BlogsException("Invalid blog excerpt format.");
        if (b.getImgUrl() != null) {
            if (b.getImgUrl().length() > 200 || !b.getImgUrl().matches("(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?"))
                throw new BlogsException("Invalid blog image url format.");
        }
    }
}
