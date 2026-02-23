package com.amazonaws.transform;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SimpleTypeStaxUnmarshallers {
    private static Log log = LogFactory.getLog(SimpleTypeStaxUnmarshallers.class);

    public static class BigDecimalStaxUnmarshaller implements Unmarshaller {
        private static BigDecimalStaxUnmarshaller instance;

        public static BigDecimalStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalStaxUnmarshaller();
            }
            return instance;
        }

        public BigDecimal unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return new BigDecimal(readText);
        }
    }

    public static class BigIntegerStaxUnmarshaller implements Unmarshaller {
        private static BigIntegerStaxUnmarshaller instance;

        public static BigIntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerStaxUnmarshaller();
            }
            return instance;
        }

        public BigInteger unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return new BigInteger(readText);
        }
    }

    public static class BooleanStaxUnmarshaller implements Unmarshaller {
        private static BooleanStaxUnmarshaller instance;

        public static BooleanStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanStaxUnmarshaller();
            }
            return instance;
        }

        public Boolean unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(readText));
        }
    }

    public static class ByteBufferStaxUnmarshaller implements Unmarshaller {
        private static ByteBufferStaxUnmarshaller instance;

        public static ByteBufferStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferStaxUnmarshaller();
            }
            return instance;
        }

        public ByteBuffer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(staxUnmarshallerContext.readText()));
        }
    }

    public static class ByteStaxUnmarshaller implements Unmarshaller {
        private static ByteStaxUnmarshaller instance;

        public static ByteStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteStaxUnmarshaller();
            }
            return instance;
        }

        public Byte unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Byte.valueOf(readText);
        }
    }

    public static class DateStaxUnmarshaller implements Unmarshaller {
        private static DateStaxUnmarshaller instance;

        public static DateStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateStaxUnmarshaller();
            }
            return instance;
        }

        public Date unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            try {
                return DateUtils.parseISO8601Date(readText);
            } catch (Exception e) {
                SimpleTypeStaxUnmarshallers.access$000().warn("Unable to parse date '" + readText + "':  " + e.getMessage(), e);
                return null;
            }
        }
    }

    public static class DoubleStaxUnmarshaller implements Unmarshaller {
        private static DoubleStaxUnmarshaller instance;

        public static DoubleStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleStaxUnmarshaller();
            }
            return instance;
        }

        public Double unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(readText));
        }
    }

    public static class FloatStaxUnmarshaller implements Unmarshaller {
        private static FloatStaxUnmarshaller instance;

        public static FloatStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatStaxUnmarshaller();
            }
            return instance;
        }

        public Float unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Float.valueOf(readText);
        }
    }

    public static class IntegerStaxUnmarshaller implements Unmarshaller {
        private static IntegerStaxUnmarshaller instance;

        public static IntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerStaxUnmarshaller();
            }
            return instance;
        }

        public Integer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(readText));
        }
    }

    public static class LongStaxUnmarshaller implements Unmarshaller {
        private static LongStaxUnmarshaller instance;

        public static LongStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongStaxUnmarshaller();
            }
            return instance;
        }

        public Long unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(readText));
        }
    }

    public static class StringStaxUnmarshaller implements Unmarshaller {
        private static StringStaxUnmarshaller instance;

        public static StringStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringStaxUnmarshaller();
            }
            return instance;
        }

        public String unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return staxUnmarshallerContext.readText();
        }
    }

    public static /* synthetic */ Log access$000() {
        return log;
    }
}
