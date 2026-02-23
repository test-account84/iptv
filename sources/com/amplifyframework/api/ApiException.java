package com.amplifyframework.api;

import com.amplifyframework.AmplifyException;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiException extends AmplifyException {
    private static final long serialVersionUID = 1;

    public static final class ApiAuthException extends ApiException {
        private static final long serialVersionUID = 1;

        public ApiAuthException(String str, String str2) {
            super(str, str2);
        }

        public ApiAuthException(String str, Throwable th, String str2) {
            super(str, th, str2);
        }
    }

    public static final class NonRetryableException extends ApiException {
        private static final long serialVersionUID = 1;

        public NonRetryableException(@NotNull String str, @NotNull String str2) {
            super(str, str2);
        }
    }

    public ApiException(String str, String str2) {
        super(str, str2);
    }

    public ApiException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }
}
