package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter ATOMIC_INTEGER;
    public static final TypeAdapter ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter BIG_DECIMAL;
    public static final TypeAdapter BIG_INTEGER;
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter FLOAT;
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    public class 1 extends TypeAdapter {
        public Class read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public class 10 extends TypeAdapter {
        public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException((Throwable) e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }

    public class 11 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 12 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 13 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 14 extends TypeAdapter {
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + nextString);
        }

        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    public class 15 extends TypeAdapter {
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek != JsonToken.NULL) {
                return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    public class 16 extends TypeAdapter {
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value((Number) bigDecimal);
        }
    }

    public class 17 extends TypeAdapter {
        public BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value((Number) bigInteger);
        }
    }

    public class 18 extends TypeAdapter {
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    public class 19 extends TypeAdapter {
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public class 2 extends TypeAdapter {
        /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet read(com.google.gson.stream.JsonReader r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.beginArray()
                com.google.gson.stream.JsonToken r1 = r8.peek()
                r2 = 0
                r3 = 0
            Le:
                com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = com.google.gson.internal.bind.TypeAdapters.34.$SwitchMap$com$google$gson$stream$JsonToken
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.nextBoolean()
                goto L69
            L63:
                int r1 = r8.nextInt()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                com.google.gson.stream.JsonToken r1 = r8.peek()
                goto Le
            L75:
                r8.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.2.read(com.google.gson.stream.JsonReader):java.util.BitSet");
        }

        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    public class 20 extends TypeAdapter {
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    public class 21 extends TypeAdapter {
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    public class 22 extends TypeAdapter {
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public class 23 extends TypeAdapter {
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    public class 24 extends TypeAdapter {
        public Currency read(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.nextString());
        }

        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    public class 25 extends TypeAdapter {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        public Calendar read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i = nextInt;
                } else if ("month".equals(nextName)) {
                    i2 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i3 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i4 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i5 = nextInt;
                } else if ("second".equals(nextName)) {
                    i6 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value(calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    public class 26 extends TypeAdapter {
        /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
            java.util.ConcurrentModificationException
            	at java.util.ArrayList$Itr.next(ArrayList.java:860)
            	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
            	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
            */
        public java.util.Locale read(
        /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
            java.util.ConcurrentModificationException
            	at java.util.ArrayList$Itr.next(ArrayList.java:860)
            	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
            	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
            */
        /*  JADX ERROR: Method generation error
            LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r5v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
            	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
            	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
            	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
            	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
            	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
            	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
            	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
            	at java.util.ArrayList.forEach(ArrayList.java:1262)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
            */

        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    public class 27 extends TypeAdapter {
        public JsonElement read(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                return ((JsonTreeReader) jsonReader).nextJsonElement();
            }
            switch (34.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, (JsonElement) it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (!jsonElement.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
            jsonWriter.beginObject();
            for (Map.Entry entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name((String) entry.getKey());
                write(jsonWriter, (JsonElement) entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    public class 28 implements TypeAdapterFactory {
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    public class 29 implements TypeAdapterFactory {
        final /* synthetic */ TypeToken val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public 29(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.val$type = typeToken;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.equals(this.val$type)) {
                return this.val$typeAdapter;
            }
            return null;
        }
    }

    public class 3 extends TypeAdapter {
        public Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek != JsonToken.NULL) {
                return peek == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString())) : Boolean.valueOf(jsonReader.nextBoolean());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool);
        }
    }

    public class 30 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public 30(Class cls, TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    public class 31 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        public 31(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    public class 32 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public 32(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.val$base || rawType == this.val$sub) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    public class 33 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        public class 1 extends TypeAdapter {
            final /* synthetic */ Class val$requestedType;

            public 1(Class cls) {
                this.val$requestedType = cls;
            }

            public Object read(JsonReader jsonReader) throws IOException {
                Object read = 33.this.val$typeAdapter.read(jsonReader);
                if (read == null || this.val$requestedType.isInstance(read)) {
                    return read;
                }
                throw new JsonSyntaxException("Expected a " + this.val$requestedType.getName() + " but was " + read.getClass().getName());
            }

            public void write(JsonWriter jsonWriter, Object obj) throws IOException {
                33.this.val$typeAdapter.write(jsonWriter, obj);
            }
        }

        public 33(Class cls, TypeAdapter typeAdapter) {
            this.val$clazz = cls;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (this.val$clazz.isAssignableFrom(rawType)) {
                return new 1(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.val$clazz.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    public static /* synthetic */ class 34 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class 4 extends TypeAdapter {
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    public class 5 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 6 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 7 extends TypeAdapter {
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    public class 8 extends TypeAdapter {
        public AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }

    public class 9 extends TypeAdapter {
        public AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    public static final class EnumTypeAdapter extends TypeAdapter {
        private final Map nameToConstant = new HashMap();
        private final Map constantToName = new HashMap();

        public class 1 implements PrivilegedAction {
            final /* synthetic */ Field val$field;

            public 1(Field field) {
                this.val$field = field;
            }

            public Void run() {
                this.val$field.setAccessible(true);
                return null;
            }
        }

        public EnumTypeAdapter(Class cls) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new 1(field));
                        Enum r4 = (Enum) field.get((Object) null);
                        String name = r4.name();
                        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                        if (serializedName != null) {
                            name = serializedName.value();
                            for (String str : serializedName.alternate()) {
                                this.nameToConstant.put(str, r4);
                            }
                        }
                        this.nameToConstant.put(name, r4);
                        this.constantToName.put(r4, name);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        public Enum read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return (Enum) this.nameToConstant.get(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Enum r3) throws IOException {
            jsonWriter.value(r3 == null ? null : (String) this.constantToName.get(r3));
        }
    }

    static {
        TypeAdapter nullSafe = new 1().nullSafe();
        CLASS = nullSafe;
        CLASS_FACTORY = newFactory(Class.class, nullSafe);
        TypeAdapter nullSafe2 = new 2().nullSafe();
        BIT_SET = nullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, nullSafe2);
        3 r0 = new 3();
        BOOLEAN = r0;
        BOOLEAN_AS_STRING = new 4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, r0);
        5 r02 = new 5();
        BYTE = r02;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, r02);
        6 r03 = new 6();
        SHORT = r03;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, r03);
        7 r04 = new 7();
        INTEGER = r04;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, r04);
        TypeAdapter nullSafe3 = new 8().nullSafe();
        ATOMIC_INTEGER = nullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, nullSafe3);
        TypeAdapter nullSafe4 = new 9().nullSafe();
        ATOMIC_BOOLEAN = nullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, nullSafe4);
        TypeAdapter nullSafe5 = new 10().nullSafe();
        ATOMIC_INTEGER_ARRAY = nullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, nullSafe5);
        LONG = new 11();
        FLOAT = new 12();
        DOUBLE = new 13();
        14 r05 = new 14();
        CHARACTER = r05;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, r05);
        15 r06 = new 15();
        STRING = r06;
        BIG_DECIMAL = new 16();
        BIG_INTEGER = new 17();
        STRING_FACTORY = newFactory(String.class, r06);
        18 r07 = new 18();
        STRING_BUILDER = r07;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, r07);
        19 r08 = new 19();
        STRING_BUFFER = r08;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, r08);
        20 r09 = new 20();
        URL = r09;
        URL_FACTORY = newFactory(URL.class, r09);
        21 r010 = new 21();
        URI = r010;
        URI_FACTORY = newFactory(URI.class, r010);
        22 r011 = new 22();
        INET_ADDRESS = r011;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, r011);
        23 r012 = new 23();
        UUID = r012;
        UUID_FACTORY = newFactory(UUID.class, r012);
        TypeAdapter nullSafe6 = new 24().nullSafe();
        CURRENCY = nullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, nullSafe6);
        25 r013 = new 25();
        CALENDAR = r013;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, r013);
        26 r014 = new 26();
        LOCALE = r014;
        LOCALE_FACTORY = newFactory(Locale.class, r014);
        27 r015 = new 27();
        JSON_ELEMENT = r015;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, r015);
        ENUM_FACTORY = new 28();
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static TypeAdapterFactory newFactory(TypeToken typeToken, TypeAdapter typeAdapter) {
        return new 29(typeToken, typeAdapter);
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class cls, Class cls2, TypeAdapter typeAdapter) {
        return new 32(cls, cls2, typeAdapter);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class cls, TypeAdapter typeAdapter) {
        return new 33(cls, typeAdapter);
    }

    public static TypeAdapterFactory newFactory(Class cls, TypeAdapter typeAdapter) {
        return new 30(cls, typeAdapter);
    }

    public static TypeAdapterFactory newFactory(Class cls, Class cls2, TypeAdapter typeAdapter) {
        return new 31(cls, cls2, typeAdapter);
    }
}
