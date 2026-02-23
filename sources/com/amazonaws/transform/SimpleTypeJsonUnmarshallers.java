package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SimpleTypeJsonUnmarshallers {

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$transform$TimestampFormat;

        static {
            int[] iArr = new int[TimestampFormat.values().length];
            $SwitchMap$com$amazonaws$transform$TimestampFormat = iArr;
            try {
                iArr[TimestampFormat.ISO_8601.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$transform$TimestampFormat[TimestampFormat.RFC_822.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$transform$TimestampFormat[TimestampFormat.UNIX_TIMESTAMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class BigDecimalJsonUnmarshaller implements Unmarshaller {
        private static BigDecimalJsonUnmarshaller instance;

        public static BigDecimalJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalJsonUnmarshaller();
            }
            return instance;
        }

        public BigDecimal unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigDecimal(nextString);
        }
    }

    public static class BigIntegerJsonUnmarshaller implements Unmarshaller {
        private static BigIntegerJsonUnmarshaller instance;

        public static BigIntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerJsonUnmarshaller();
            }
            return instance;
        }

        public BigInteger unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigInteger(nextString);
        }
    }

    public static class BooleanJsonUnmarshaller implements Unmarshaller {
        private static BooleanJsonUnmarshaller instance;

        public static BooleanJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanJsonUnmarshaller();
            }
            return instance;
        }

        public Boolean unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(nextString));
        }
    }

    public static class ByteBufferJsonUnmarshaller implements Unmarshaller {
        private static ByteBufferJsonUnmarshaller instance;

        public static ByteBufferJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferJsonUnmarshaller();
            }
            return instance;
        }

        public ByteBuffer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(jsonUnmarshallerContext.getReader().nextString()));
        }
    }

    public static class ByteJsonUnmarshaller implements Unmarshaller {
        private static ByteJsonUnmarshaller instance;

        public static ByteJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteJsonUnmarshaller();
            }
            return instance;
        }

        public Byte unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Byte.valueOf(nextString);
        }
    }

    public static class DateJsonUnmarshaller implements Unmarshaller {
        private static final int DATE_MULTIPLIER = 1000;
        private static DateJsonUnmarshaller instance;
        private final TimestampFormat format;

        private DateJsonUnmarshaller(TimestampFormat timestampFormat) {
            this.format = timestampFormat;
        }

        public static DateJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateJsonUnmarshaller(TimestampFormat.UNIX_TIMESTAMP);
            }
            return instance;
        }

        public static DateJsonUnmarshaller getInstance(TimestampFormat timestampFormat) {
            DateJsonUnmarshaller dateJsonUnmarshaller = instance;
            if (dateJsonUnmarshaller == null || !dateJsonUnmarshaller.format.equals(timestampFormat)) {
                instance = new DateJsonUnmarshaller(timestampFormat);
            }
            return instance;
        }

        public Date unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            try {
                int i = 1.$SwitchMap$com$amazonaws$transform$TimestampFormat[this.format.ordinal()];
                return i != 1 ? i != 2 ? new Date(NumberFormat.getInstance(new Locale("en")).parse(nextString).longValue() * 1000) : DateUtils.parseRFC822Date(nextString) : DateUtils.parseISO8601Date(nextString);
            } catch (IllegalArgumentException e) {
                e = e;
                throw new AmazonClientException("Unable to parse date '" + nextString + "':  " + e.getMessage(), e);
            } catch (ParseException e2) {
                e = e2;
                throw new AmazonClientException("Unable to parse date '" + nextString + "':  " + e.getMessage(), e);
            }
        }
    }

    public static class DoubleJsonUnmarshaller implements Unmarshaller {
        private static DoubleJsonUnmarshaller instance;

        public static DoubleJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleJsonUnmarshaller();
            }
            return instance;
        }

        public Double unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(nextString));
        }
    }

    public static class FloatJsonUnmarshaller implements Unmarshaller {
        private static FloatJsonUnmarshaller instance;

        public static FloatJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatJsonUnmarshaller();
            }
            return instance;
        }

        public Float unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Float.valueOf(nextString);
        }
    }

    public static class IntegerJsonUnmarshaller implements Unmarshaller {
        private static IntegerJsonUnmarshaller instance;

        public static IntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerJsonUnmarshaller();
            }
            return instance;
        }

        public Integer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(nextString));
        }
    }

    public static class LongJsonUnmarshaller implements Unmarshaller {
        private static LongJsonUnmarshaller instance;

        public static LongJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongJsonUnmarshaller();
            }
            return instance;
        }

        public Long unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(nextString));
        }
    }

    public static class StringJsonUnmarshaller implements Unmarshaller {
        private static StringJsonUnmarshaller instance;

        public static StringJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringJsonUnmarshaller();
            }
            return instance;
        }

        public String unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return jsonUnmarshallerContext.getReader().nextString();
        }
    }
}
