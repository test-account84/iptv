package com.amplifyframework.util;

import j$.util.Objects;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Casing {

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amplifyframework$util$Casing$CaseType;

        static {
            int[] iArr = new int[CaseType.values().length];
            $SwitchMap$com$amplifyframework$util$Casing$CaseType = iArr;
            try {
                iArr[CaseType.SCREAMING_SNAKE_CASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amplifyframework$util$Casing$CaseType[CaseType.CAMEL_CASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amplifyframework$util$Casing$CaseType[CaseType.PASCAL_CASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum CaseType {
        SCREAMING_SNAKE_CASE,
        CAMEL_CASE,
        PASCAL_CASE
    }

    public static final class CasingSource {
        private final CaseType sourceCasing;

        private CasingSource(CaseType caseType) {
            this.sourceCasing = caseType;
        }

        public CasingTarget to(CaseType caseType) {
            return new CasingTarget(this.sourceCasing, caseType, null);
        }

        public /* synthetic */ CasingSource(CaseType caseType, 1 r2) {
            this(caseType);
        }
    }

    public static final class CasingTarget {
        private CaseType sourceCasing;
        private CaseType targetCasing;

        private CasingTarget(CaseType caseType, CaseType caseType2) {
            this.sourceCasing = caseType;
            this.targetCasing = caseType2;
        }

        public String convert(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            int i = 1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[this.sourceCasing.ordinal()];
            if (i == 1) {
                return Casing.access$400(str, this.targetCasing);
            }
            if (i == 2) {
                return Casing.access$200(str, this.targetCasing);
            }
            if (i == 3) {
                return Casing.access$300(str, this.targetCasing);
            }
            throw new IllegalStateException("Unknown source casing = " + this.sourceCasing);
        }

        public /* synthetic */ CasingTarget(CaseType caseType, CaseType caseType2, 1 r3) {
            this(caseType, caseType2);
        }
    }

    private Casing() {
    }

    public static /* synthetic */ String access$200(String str, CaseType caseType) {
        return fromCamelCase(str, caseType);
    }

    public static /* synthetic */ String access$300(String str, CaseType caseType) {
        return fromPascalCase(str, caseType);
    }

    public static /* synthetic */ String access$400(String str, CaseType caseType) {
        return fromScreamingSnakeCase(str, caseType);
    }

    private static String camelToPascal(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1);
    }

    public static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1).toLowerCase(Locale.getDefault());
    }

    public static String capitalizeFirst(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1);
    }

    public static CasingSource from(CaseType caseType) {
        Objects.requireNonNull(caseType);
        return new CasingSource(caseType, null);
    }

    private static String fromCamelCase(String str, CaseType caseType) {
        Objects.requireNonNull(caseType);
        if (str == null) {
            return null;
        }
        int i = 1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()];
        if (i == 1) {
            return toScreamingSnake(str);
        }
        if (i == 2) {
            return str;
        }
        if (i == 3) {
            return camelToPascal(str);
        }
        throw new IllegalStateException("No such casing = " + caseType);
    }

    private static String fromPascalCase(String str, CaseType caseType) {
        Objects.requireNonNull(caseType);
        if (str == null) {
            return null;
        }
        int i = 1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()];
        if (i == 1) {
            return toScreamingSnake(str);
        }
        if (i == 2) {
            return pascalToCamel(str);
        }
        if (i == 3) {
            return str;
        }
        throw new IllegalStateException("No such casing = " + caseType);
    }

    private static String fromScreamingSnakeCase(String str, CaseType caseType) {
        int i;
        Objects.requireNonNull(caseType);
        if (str == null || str.length() == 0 || (i = 1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()]) == 1) {
            return str;
        }
        if (i == 2) {
            return screamingSnakeToCamel(str);
        }
        if (i == 3) {
            return screamingSnakeToPascal(str);
        }
        throw new IllegalStateException("Unknown target casing = " + caseType);
    }

    private static String pascalToCamel(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toLowerCase(Locale.getDefault()) + str.substring(1);
    }

    private static String screamingSnakeToCamel(String str) {
        return (str == null || str.length() == 0) ? str : pascalToCamel(screamingSnakeToPascal(str));
    }

    private static String screamingSnakeToPascal(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] split = str.split("_");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            sb.append(capitalize(str2));
        }
        return sb.toString();
    }

    private static String toScreamingSnake(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLowerCase(c)) {
                    c = Character.toUpperCase(c);
                } else if (i != 0) {
                    sb.append("_");
                }
                sb.append(c);
            } else {
                sb.append("_");
            }
        }
        return sb.toString();
    }
}
