package com.jgssakmt.backend.validator;

import com.jgssakmt.backend.exeptions.PagesException;
import com.jgssakmt.backend.model.Pages;
import com.jgssakmt.backend.model.Paragraph;

import java.util.List;

public class PagesValidator {
    public static void validate(Pages b) throws PagesException {
        if (b.getHeader() == null || b.getHeader().length() > 50 || b.getHeader().equals(""))
            throw new PagesException("Invalid page header format.");
        if (b.getExcerpt() == null || b.getExcerpt().length() > 120 || b.getExcerpt().equals(""))
            throw new PagesException("Invalid page excerpt format.");
        if (b.getName() == null || !b.getName().matches("([\\w.?:;]+[ ]*)+"))
            throw new PagesException("Invalid page name format.");
        if (b.getParagraphs() != null && !b.getParagraphs().isEmpty()) {
            if (!validateParagraphs(b.getParagraphs()))
                throw new PagesException("Invalid page paragraph format.");
        }
        if (b.getParagraphs() == null || b.getParagraphs().isEmpty())
            throw new PagesException("Page should have at least 1 paragraph");
    }

    private static Boolean validateParagraphs(List<Paragraph> paragraphs) {
        for (Paragraph b:paragraphs) {
            if (b.getImgUrl() != null && !b.getImgUrl().equals("")) {
                if (b.getImgUrl().length() > 200 || !b.getImgUrl().matches("(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?"))
                    return false;
            }
            if (b.getBody() == null || b.getBody().length() > 2000 || b.getBody().equals(""))
                return false;
            if (b.getHeader() == null || b.getHeader().length() > 50 || b.getHeader().equals(""))
                return false;
        }

        return true;
    }
}
