package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class TypeAdapter {

    public class 1 extends TypeAdapter {
        public 1() {
        }

        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return TypeAdapter.this.read(jsonReader);
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter.this.write(jsonWriter, obj);
            }
        }
    }

    public final Object fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final Object fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public final TypeAdapter nullSafe() {
        return new 1();
    }

    public abstract Object read(JsonReader jsonReader) throws IOException;

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonElement toJsonTree(Object obj) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, obj);
            return jsonTreeWriter.get();
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }

    public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException;

    public final Object fromJson(String str) throws IOException {
        return fromJson((Reader) new StringReader(str));
    }

    public final void toJson(Writer writer, Object obj) throws IOException {
        write(new JsonWriter(writer), obj);
    }
}
