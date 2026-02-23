package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ToNumberPolicy implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES;
    public static final ToNumberPolicy BIG_DECIMAL;
    public static final ToNumberPolicy DOUBLE;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER;
    public static final ToNumberPolicy LONG_OR_DOUBLE;

    public enum 1 extends ToNumberPolicy {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    }

    public enum 2 extends ToNumberPolicy {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    }

    public enum 3 extends ToNumberPolicy {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public Number readNumber(JsonReader jsonReader) throws IOException, JsonParseException {
            String nextString = jsonReader.nextString();
            try {
                try {
                    return Long.valueOf(Long.parseLong(nextString));
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(nextString);
                    if (valueOf.isInfinite() || valueOf.isNaN()) {
                        if (!jsonReader.isLenient()) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPath());
                        }
                    }
                    return valueOf;
                }
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPath(), e);
            }
        }
    }

    public enum 4 extends ToNumberPolicy {
        public 4(String str, int i) {
            super(str, i, null);
        }

        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPath(), e);
            }
        }
    }

    static {
        1 r0 = new 1("DOUBLE", 0);
        DOUBLE = r0;
        2 r1 = new 2("LAZILY_PARSED_NUMBER", 1);
        LAZILY_PARSED_NUMBER = r1;
        3 r3 = new 3("LONG_OR_DOUBLE", 2);
        LONG_OR_DOUBLE = r3;
        4 r5 = new 4("BIG_DECIMAL", 3);
        BIG_DECIMAL = r5;
        $VALUES = new ToNumberPolicy[]{r0, r1, r3, r5};
    }

    private ToNumberPolicy(String str, int i) {
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ ToNumberPolicy(String str, int i, 1 r3) {
        this(str, i);
    }
}
