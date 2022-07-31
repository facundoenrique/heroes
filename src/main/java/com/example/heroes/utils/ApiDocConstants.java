package com.example.heroes.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiDocConstants {

    public static final String HERO_SAVE =
            "{" +
                "\"name\":\"superman\"" +
            "}";

    public static final String HERO_UPDATE =
            "{" +
                "\"id\":\"1\"" +
                "\"name\":\"superman\"" +
            "}";
}
