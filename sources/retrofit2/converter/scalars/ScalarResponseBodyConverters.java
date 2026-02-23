package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class ScalarResponseBodyConverters {

    public static final class BooleanResponseBodyConverter implements Converter {
        static final BooleanResponseBodyConverter INSTANCE = new BooleanResponseBodyConverter();

        public Boolean convert(ResponseBody responseBody) throws IOException {
            return Boolean.valueOf(responseBody.string());
        }
    }

    public static final class ByteResponseBodyConverter implements Converter {
        static final ByteResponseBodyConverter INSTANCE = new ByteResponseBodyConverter();

        public Byte convert(ResponseBody responseBody) throws IOException {
            return Byte.valueOf(responseBody.string());
        }
    }

    public static final class CharacterResponseBodyConverter implements Converter {
        static final CharacterResponseBodyConverter INSTANCE = new CharacterResponseBodyConverter();

        public Character convert(ResponseBody responseBody) throws IOException {
            String string = responseBody.string();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new IOException("Expected body of length 1 for Character conversion but was " + string.length());
        }
    }

    public static final class DoubleResponseBodyConverter implements Converter {
        static final DoubleResponseBodyConverter INSTANCE = new DoubleResponseBodyConverter();

        public Double convert(ResponseBody responseBody) throws IOException {
            return Double.valueOf(responseBody.string());
        }
    }

    public static final class FloatResponseBodyConverter implements Converter {
        static final FloatResponseBodyConverter INSTANCE = new FloatResponseBodyConverter();

        public Float convert(ResponseBody responseBody) throws IOException {
            return Float.valueOf(responseBody.string());
        }
    }

    public static final class IntegerResponseBodyConverter implements Converter {
        static final IntegerResponseBodyConverter INSTANCE = new IntegerResponseBodyConverter();

        public Integer convert(ResponseBody responseBody) throws IOException {
            return Integer.valueOf(responseBody.string());
        }
    }

    public static final class LongResponseBodyConverter implements Converter {
        static final LongResponseBodyConverter INSTANCE = new LongResponseBodyConverter();

        public Long convert(ResponseBody responseBody) throws IOException {
            return Long.valueOf(responseBody.string());
        }
    }

    public static final class ShortResponseBodyConverter implements Converter {
        static final ShortResponseBodyConverter INSTANCE = new ShortResponseBodyConverter();

        public Short convert(ResponseBody responseBody) throws IOException {
            return Short.valueOf(responseBody.string());
        }
    }

    public static final class StringResponseBodyConverter implements Converter {
        static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();

        public String convert(ResponseBody responseBody) throws IOException {
            return responseBody.string();
        }
    }

    private ScalarResponseBodyConverters() {
    }
}
