package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES;
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    public enum 1 extends FieldNamingPolicy {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return field.getName();
        }
    }

    public enum 2 extends FieldNamingPolicy {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }

    public enum 3 extends FieldNamingPolicy {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    }

    public enum 4 extends FieldNamingPolicy {
        public 4(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }

    public enum 5 extends FieldNamingPolicy {
        public 5(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }

    public enum 6 extends FieldNamingPolicy {
        public 6(String str, int i) {
            super(str, i, null);
        }

        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }

    static {
        1 r0 = new 1("IDENTITY", 0);
        IDENTITY = r0;
        2 r1 = new 2("UPPER_CAMEL_CASE", 1);
        UPPER_CAMEL_CASE = r1;
        3 r3 = new 3("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        UPPER_CAMEL_CASE_WITH_SPACES = r3;
        4 r5 = new 4("LOWER_CASE_WITH_UNDERSCORES", 3);
        LOWER_CASE_WITH_UNDERSCORES = r5;
        5 r7 = new 5("LOWER_CASE_WITH_DASHES", 4);
        LOWER_CASE_WITH_DASHES = r7;
        6 r9 = new 6("LOWER_CASE_WITH_DOTS", 5);
        LOWER_CASE_WITH_DOTS = r9;
        $VALUES = new FieldNamingPolicy[]{r0, r1, r3, r5, r7, r9};
    }

    private FieldNamingPolicy(String str, int i) {
    }

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ FieldNamingPolicy(String str, int i, 1 r3) {
        this(str, i);
    }
}
