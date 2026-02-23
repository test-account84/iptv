package com.amplifyframework.util;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Wrap {
    private Wrap() {
    }

    public static String inBackticks(String str) {
        if (Empty.check(str)) {
            return str;
        }
        return "`" + str + "`";
    }

    public static String inBraces(String str) {
        if (str == null) {
            return null;
        }
        return "{" + str + "}";
    }

    public static String inDoubleQuotes(String str) {
        if (str == null) {
            return null;
        }
        return "\"" + str + "\"";
    }

    public static String inParentheses(String str) {
        if (str == null) {
            return null;
        }
        return "(" + str + ")";
    }

    public static String inPrettyBraces(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        return " " + inBraces("\n" + str2 + str3 + str + "\n" + str2);
    }

    public static String inSingleQuotes(String str) {
        if (str == null) {
            return null;
        }
        return "'" + str + "'";
    }
}
