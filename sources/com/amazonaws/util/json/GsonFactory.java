package com.amazonaws.util.json;

import com.amazonaws.util.BinaryUtils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class GsonFactory implements AwsJsonFactory {

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static final class GsonReader implements AwsJsonReader {
        private final JsonReader reader;

        public GsonReader(Reader reader) {
            this.reader = new JsonReader(reader);
        }

        public void beginArray() throws IOException {
            this.reader.beginArray();
        }

        public void beginObject() throws IOException {
            this.reader.beginObject();
        }

        public void close() throws IOException {
            this.reader.close();
        }

        public void endArray() throws IOException {
            this.reader.endArray();
        }

        public void endObject() throws IOException {
            this.reader.endObject();
        }

        public boolean hasNext() throws IOException {
            return this.reader.hasNext();
        }

        public boolean isContainer() throws IOException {
            JsonToken peek = this.reader.peek();
            return JsonToken.BEGIN_ARRAY.equals(peek) || JsonToken.BEGIN_OBJECT.equals(peek);
        }

        public String nextName() throws IOException {
            return this.reader.nextName();
        }

        public String nextString() throws IOException {
            JsonToken peek = this.reader.peek();
            if (!JsonToken.NULL.equals(peek)) {
                return JsonToken.BOOLEAN.equals(peek) ? this.reader.nextBoolean() ? "true" : "false" : this.reader.nextString();
            }
            this.reader.nextNull();
            return null;
        }

        public AwsJsonToken peek() throws IOException {
            try {
                return GsonFactory.access$000(this.reader.peek());
            } catch (EOFException unused) {
                return null;
            }
        }

        public void skipValue() throws IOException {
            this.reader.skipValue();
        }
    }

    public static final class GsonWriter implements AwsJsonWriter {
        private static final int NEGATIVE_THREE = -3;
        private final JsonWriter writer;

        public GsonWriter(Writer writer) {
            this.writer = new JsonWriter(writer);
        }

        public AwsJsonWriter beginArray() throws IOException {
            this.writer.beginArray();
            return this;
        }

        public AwsJsonWriter beginObject() throws IOException {
            this.writer.beginObject();
            return this;
        }

        public void close() throws IOException {
            this.writer.close();
        }

        public AwsJsonWriter endArray() throws IOException {
            this.writer.endArray();
            return this;
        }

        public AwsJsonWriter endObject() throws IOException {
            this.writer.endObject();
            return this;
        }

        public void flush() throws IOException {
            this.writer.flush();
        }

        public AwsJsonWriter name(String str) throws IOException {
            this.writer.name(str);
            return this;
        }

        public AwsJsonWriter value() throws IOException {
            this.writer.nullValue();
            return this;
        }

        public AwsJsonWriter value(double d) throws IOException {
            this.writer.value(d);
            return this;
        }

        public AwsJsonWriter value(long j) throws IOException {
            this.writer.value(j);
            return this;
        }

        public AwsJsonWriter value(Number number) throws IOException {
            this.writer.value(number);
            return this;
        }

        public AwsJsonWriter value(String str) throws IOException {
            this.writer.value(str);
            return this;
        }

        public AwsJsonWriter value(ByteBuffer byteBuffer) throws IOException {
            byteBuffer.mark();
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            byteBuffer.reset();
            this.writer.value(BinaryUtils.toBase64(bArr));
            return this;
        }

        public AwsJsonWriter value(Date date) throws IOException {
            this.writer.value((Number) BigDecimal.valueOf(date.getTime()).scaleByPowerOfTen(-3));
            return this;
        }

        public AwsJsonWriter value(boolean z) throws IOException {
            this.writer.value(z);
            return this;
        }
    }

    public static /* synthetic */ AwsJsonToken access$000(JsonToken jsonToken) {
        return convert(jsonToken);
    }

    private static AwsJsonToken convert(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (1.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()]) {
            case 1:
                return AwsJsonToken.BEGIN_ARRAY;
            case 2:
                return AwsJsonToken.END_ARRAY;
            case 3:
                return AwsJsonToken.BEGIN_OBJECT;
            case 4:
                return AwsJsonToken.END_OBJECT;
            case 5:
                return AwsJsonToken.FIELD_NAME;
            case 6:
                return AwsJsonToken.VALUE_BOOLEAN;
            case 7:
                return AwsJsonToken.VALUE_NUMBER;
            case 8:
                return AwsJsonToken.VALUE_NULL;
            case 9:
                return AwsJsonToken.VALUE_STRING;
            case 10:
                return null;
            default:
                return AwsJsonToken.UNKNOWN;
        }
    }

    public AwsJsonReader getJsonReader(Reader reader) {
        return new GsonReader(reader);
    }

    public AwsJsonWriter getJsonWriter(Writer writer) {
        return new GsonWriter(writer);
    }
}
