package com.amplifyframework.auth;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthUserAttributeKey {
    private static final String ADDRESS = "address";
    private static final String BIRTHDATE = "birthdate";
    private static final String EMAIL = "email";
    private static final String FAMILY_NAME = "family_name";
    private static final String GENDER = "gender";
    private static final String GIVEN_NAME = "given_name";
    private static final String LOCALE = "locale";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String NAME = "name";
    private static final String NICKNAME = "nickname";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String PICTURE = "picture";
    private static final String PREFERRED_USERNAME = "preferred_username";
    private static final String PROFILE = "profile";
    private static final String UPDATED_AT = "updated_at";
    private static final String WEBSITE = "website";
    private static final String ZONE_INFO = "zoneinfo";
    private final String attributeKey;

    public AuthUserAttributeKey(String str) {
        this.attributeKey = str;
    }

    public static AuthUserAttributeKey address() {
        return new AuthUserAttributeKey("address");
    }

    public static AuthUserAttributeKey birthdate() {
        return new AuthUserAttributeKey("birthdate");
    }

    public static AuthUserAttributeKey custom(String str) {
        return new AuthUserAttributeKey(str);
    }

    public static AuthUserAttributeKey email() {
        return new AuthUserAttributeKey("email");
    }

    public static AuthUserAttributeKey familyName() {
        return new AuthUserAttributeKey("family_name");
    }

    public static AuthUserAttributeKey gender() {
        return new AuthUserAttributeKey("gender");
    }

    public static AuthUserAttributeKey givenName() {
        return new AuthUserAttributeKey("given_name");
    }

    public static AuthUserAttributeKey locale() {
        return new AuthUserAttributeKey("locale");
    }

    public static AuthUserAttributeKey middleName() {
        return new AuthUserAttributeKey("middle_name");
    }

    public static AuthUserAttributeKey name() {
        return new AuthUserAttributeKey("name");
    }

    public static AuthUserAttributeKey nickname() {
        return new AuthUserAttributeKey("nickname");
    }

    public static AuthUserAttributeKey phoneNumber() {
        return new AuthUserAttributeKey("phone_number");
    }

    public static AuthUserAttributeKey picture() {
        return new AuthUserAttributeKey("picture");
    }

    public static AuthUserAttributeKey preferredUsername() {
        return new AuthUserAttributeKey("preferred_username");
    }

    public static AuthUserAttributeKey profile() {
        return new AuthUserAttributeKey("profile");
    }

    public static AuthUserAttributeKey updatedAt() {
        return new AuthUserAttributeKey("updated_at");
    }

    public static AuthUserAttributeKey website() {
        return new AuthUserAttributeKey("website");
    }

    public static AuthUserAttributeKey zoneInfo() {
        return new AuthUserAttributeKey("zoneinfo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUserAttributeKey.class != obj.getClass()) {
            return false;
        }
        return c.a(getKeyString(), ((AuthUserAttributeKey) obj).getKeyString());
    }

    public String getKeyString() {
        return this.attributeKey;
    }

    public int hashCode() {
        return c.b(getKeyString());
    }

    public String toString() {
        return "AuthUserAttributeKey {attributeKey=" + this.attributeKey + '}';
    }
}
