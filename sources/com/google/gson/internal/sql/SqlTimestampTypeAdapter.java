package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SqlTimestampTypeAdapter extends TypeAdapter {
    static final TypeAdapterFactory FACTORY = new 1();
    private final TypeAdapter dateTypeAdapter;

    public class 1 implements TypeAdapterFactory {
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.getAdapter(Date.class), null);
            }
            return null;
        }
    }

    private SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.dateTypeAdapter = typeAdapter;
    }

    public /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter typeAdapter, 1 r2) {
        this(typeAdapter);
    }

    public Timestamp read(JsonReader jsonReader) throws IOException {
        Date date = (Date) this.dateTypeAdapter.read(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.dateTypeAdapter.write(jsonWriter, timestamp);
    }
}
