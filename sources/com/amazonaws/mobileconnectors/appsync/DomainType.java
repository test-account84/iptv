package com.amazonaws.mobileconnectors.appsync;

import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
enum DomainType {
    STANDARD,
    CUSTOM;

    private static final String STANDARD_ENDPOINT_REGEX = "^https://\\w{26}\\.appsync-api\\.\\w{2}(?:(?:-\\w{2,})+)-\\d\\.amazonaws.com/graphql$";

    public static DomainType from(String str) {
        return isRegexMatch(str) ? STANDARD : CUSTOM;
    }

    private static boolean isRegexMatch(String str) {
        return Pattern.compile("^https://\\w{26}\\.appsync-api\\.\\w{2}(?:(?:-\\w{2,})+)-\\d\\.amazonaws.com/graphql$", 2).matcher(str).matches();
    }
}
