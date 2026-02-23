package org.apache.http.util;

import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static CharSequence containsNoBlanks(CharSequence charSequence, String str) {
        if (charSequence == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (charSequence.length() == 0) {
            throw new IllegalArgumentException(str + " may not be empty");
        }
        if (!TextUtils.containsBlanks(charSequence)) {
            return charSequence;
        }
        throw new IllegalArgumentException(str + " may not contain blanks");
    }

    public static CharSequence notBlank(CharSequence charSequence, String str) {
        if (charSequence == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!TextUtils.isBlank(charSequence)) {
            return charSequence;
        }
        throw new IllegalArgumentException(str + " may not be blank");
    }

    public static CharSequence notEmpty(CharSequence charSequence, String str) {
        if (charSequence == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    public static int notNegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static Object notNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int positive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, new Object[]{obj}));
        }
    }

    public static Collection notEmpty(Collection collection, String str) {
        if (collection == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!collection.isEmpty()) {
            return collection;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    public static long notNegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static long positive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
