package com.amplifyframework;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AmplifyException extends Exception {
    public static final String REPORT_BUG_TO_AWS_SUGGESTION = "There is a possibility that there is a bug if this error persists. Please take a look at \nhttps://github.com/aws-amplify/amplify-android/issues to see if there are any existing issues that \nmatch your scenario, and file an issue with the details of the bug if there isn't.";
    public static final String TODO_RECOVERY_SUGGESTION = "Sorry, we don't have a suggested fix for this error yet.";
    private static final long serialVersionUID = 1;
    private final String recoverySuggestion;

    public AmplifyException(String str, String str2) {
        super(str);
        Objects.requireNonNull(str2);
        this.recoverySuggestion = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AmplifyException)) {
            return false;
        }
        AmplifyException amplifyException = (AmplifyException) obj;
        return c.a(getRecoverySuggestion(), amplifyException.getRecoverySuggestion()) && c.a(getMessage(), amplifyException.getMessage()) && c.a(getCause(), amplifyException.getCause());
    }

    public final String getRecoverySuggestion() {
        return this.recoverySuggestion;
    }

    public int hashCode() {
        return c.b(getRecoverySuggestion(), getMessage(), getCause());
    }

    public String toString() {
        return getClass().getSimpleName() + "{message=" + getMessage() + ", cause=" + getCause() + ", recoverySuggestion=" + getRecoverySuggestion() + '}';
    }

    public AmplifyException(String str, Throwable th, String str2) {
        super(str, th);
        Objects.requireNonNull(str2);
        this.recoverySuggestion = str2;
    }
}
