package ru.ourloc.tgtaxi.domain.util;

import ru.ourloc.tgtaxi.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
