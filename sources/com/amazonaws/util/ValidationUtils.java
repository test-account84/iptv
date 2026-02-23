package com.amazonaws.util;

import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ValidationUtils {
    public static void assertAllAreNull(String str, Object... objArr) {
        for (Object obj : objArr) {
            if (obj != null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static int assertIsPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("%s must be positive", new Object[]{str}));
    }

    public static Collection assertNotEmpty(Collection collection, String str) {
        assertNotNull(collection, str);
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str}));
        }
        return collection;
    }

    public static Object assertNotNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", new Object[]{str}));
    }

    public static void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String assertStringNotEmpty(String str, String str2) {
        assertNotNull(str, str2);
        if (str.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str2}));
        }
        return str;
    }

    public static Object[] assertNotEmpty(Object[] objArr, String str) {
        assertNotNull(objArr, str);
        if (objArr.length != 0) {
            return objArr;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str}));
    }
}
