package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public class 1 extends BoundField {
        final /* synthetic */ Gson val$context;
        final /* synthetic */ Field val$field;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z4) {
            super(str, z, z2);
            this.val$field = field;
            this.val$jsonAdapterPresent = z3;
            this.val$typeAdapter = typeAdapter;
            this.val$context = gson;
            this.val$fieldType = typeToken;
            this.val$isPrimitive = z4;
        }

        public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            Object read = this.val$typeAdapter.read(jsonReader);
            if (read == null && this.val$isPrimitive) {
                return;
            }
            this.val$field.set(obj, read);
        }

        public void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
            (this.val$jsonAdapterPresent ? this.val$typeAdapter : new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType())).write(jsonWriter, this.val$field.get(obj));
        }

        public boolean writeField(Object obj) throws IOException, IllegalAccessException {
            return this.serialized && this.val$field.get(obj) != obj;
        }
    }

    public static final class Adapter extends TypeAdapter {
        private final Map boundFields;
        private final ObjectConstructor constructor;

        public Adapter(ObjectConstructor objectConstructor, Map map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = (BoundField) this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            }
        }

        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(obj)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, obj);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        public BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }

        public abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken typeToken, boolean z, boolean z2) {
        boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new 1(str, z, z2, field, z3, typeAdapter, gson, typeToken, isPrimitive);
    }

    private Map getBoundFields(Gson gson, TypeToken typeToken, Class cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken typeToken2 = typeToken;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, z);
                if (excludeField || excludeField2) {
                    this.accessor.makeAccessible(field);
                    Type resolve = $Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    List fieldNames = getFieldNames(field);
                    int size = fieldNames.size();
                    BoundField boundField = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = (String) fieldNames.get(i2);
                        boolean z2 = i2 != 0 ? false : excludeField;
                        int i3 = i2;
                        BoundField boundField2 = boundField;
                        int i4 = size;
                        List list = fieldNames;
                        Field field2 = field;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(resolve), z2, excludeField2)) : boundField2;
                        i2 = i3 + 1;
                        excludeField = z2;
                        fieldNames = list;
                        size = i4;
                        field = field2;
                    }
                    BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i++;
                z = false;
            }
            typeToken2 = TypeToken.get($Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    private List getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public TypeAdapter create(Gson gson, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    public static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }
}
