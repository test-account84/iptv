package com.amazonaws.mobile.client.internal.oauth2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class OAuth2Constants {
    public static final String GRANT_TYPE = "grant_type";
    public static final String SCOPES = "scopes";

    public enum GrantTypes {
        AUTHORIZATION_CODE("authorization_code"),
        REFRESH_TOKEN("refresh_token");

        private final String value;

        GrantTypes(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum TokenRequestFields {
        ACCESS_TOKEN("access_token"),
        ID_TOKEN("id_token");

        private final String value;

        TokenRequestFields(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum TokenResponseFields {
        ACCESS_TOKEN("access_token"),
        ID_TOKEN("id_token"),
        REFRESH_TOKEN("refresh_token"),
        TOKEN_TYPE("token_type"),
        EXPIRES_IN("expires_in"),
        SCOPES("scopes"),
        ERROR("error"),
        ERROR_DESCRIPTION("error_description"),
        ERROR_URI("error_uri");

        private final String value;

        TokenResponseFields(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }
}
