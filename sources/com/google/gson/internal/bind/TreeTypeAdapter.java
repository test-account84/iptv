package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class TreeTypeAdapter extends TypeAdapter {
    private final GsonContextImpl context = new GsonContextImpl(this, null);
    private TypeAdapter delegate;
    private final JsonDeserializer deserializer;
    final Gson gson;
    private final JsonSerializer serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken typeToken;

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }

        public Object deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }

        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter treeTypeAdapter, 1 r2) {
            this();
        }

        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer deserializer;
        private final TypeToken exactType;
        private final Class hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer serializer;

        public SingleTypeFactory(Object obj, TypeToken typeToken, boolean z, Class cls) {
            JsonSerializer jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.serializer = jsonSerializer;
            JsonDeserializer jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.deserializer = jsonDeserializer;
            $Gson$Preconditions.checkArgument((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            TypeToken typeToken2 = this.exactType;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType()) : this.hierarchyType.isAssignableFrom(typeToken.getRawType())) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    private TypeAdapter delegate() {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public Object read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonSerializer jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, obj);
        } else if (obj == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(obj, this.typeToken.getType(), this.context), jsonWriter);
        }
    }
}
