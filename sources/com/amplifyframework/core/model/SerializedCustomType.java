package com.amplifyframework.core.model;

import O.c;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SerializedCustomType {
    private final CustomTypeSchema customTypeSchema;
    private final Map serializedData;

    public static final class Builder implements BuilderSteps.SerializedDataStep, BuilderSteps.CustomTypeSchemaStep, BuilderSteps.BuildStep {
        private CustomTypeSchema customTypeSchema;
        private final Map serializedData;

        private Builder() {
            this.serializedData = new HashMap();
        }

        public SerializedCustomType build() {
            return new SerializedCustomType(Immutable.of(this.serializedData), this.customTypeSchema, null);
        }

        public BuilderSteps.BuildStep customTypeSchema(CustomTypeSchema customTypeSchema) {
            this.customTypeSchema = customTypeSchema;
            return this;
        }

        public BuilderSteps.CustomTypeSchemaStep serializedData(Map map) {
            Map map2 = this.serializedData;
            Objects.requireNonNull(map);
            map2.putAll(map);
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    public interface BuilderSteps {

        public interface BuildStep {
            SerializedCustomType build();
        }

        public interface CustomTypeSchemaStep {
            BuildStep customTypeSchema(CustomTypeSchema customTypeSchema);
        }

        public interface SerializedDataStep {
            CustomTypeSchemaStep serializedData(Map map);
        }
    }

    private SerializedCustomType(Map map, CustomTypeSchema customTypeSchema) {
        this.serializedData = map;
        this.customTypeSchema = customTypeSchema;
    }

    public static BuilderSteps.SerializedDataStep builder() {
        return new Builder(null);
    }

    public static Map parseSerializedData(Map map, String str, SchemaRegistry schemaRegistry) {
        SerializedCustomType serializedCustomType;
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : schemaRegistry.getCustomTypeSchemaForCustomTypeClass(str).getFields().entrySet()) {
            String str2 = (String) entry.getKey();
            CustomTypeField customTypeField = (CustomTypeField) entry.getValue();
            if (map.containsKey(str2)) {
                Object obj = map.get(str2);
                if (obj == null) {
                    serializedCustomType = null;
                } else if (customTypeField.isCustomType()) {
                    schemaRegistry.getCustomTypeSchemaForCustomTypeClass(customTypeField.getTargetType());
                    if (customTypeField.isArray()) {
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList();
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(builder().serializedData(parseSerializedData((Map) it.next(), customTypeField.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(customTypeField.getTargetType())).build());
                            }
                        }
                        hashMap.put(str2, arrayList);
                    } else {
                        serializedCustomType = builder().serializedData(parseSerializedData((Map) obj, customTypeField.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(customTypeField.getTargetType())).build();
                    }
                } else {
                    hashMap.put(str2, obj);
                }
                hashMap.put(str2, serializedCustomType);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SerializedCustomType.class != obj.getClass()) {
            return false;
        }
        SerializedCustomType serializedCustomType = (SerializedCustomType) obj;
        return c.a(this.serializedData, serializedCustomType.serializedData) && c.a(this.customTypeSchema, serializedCustomType.customTypeSchema);
    }

    public String getCustomTypeName() {
        CustomTypeSchema customTypeSchema = this.customTypeSchema;
        if (customTypeSchema == null) {
            return null;
        }
        return customTypeSchema.getName();
    }

    public CustomTypeSchema getCustomTypeSchema() {
        return this.customTypeSchema;
    }

    public Map getSerializedData() {
        return this.serializedData;
    }

    public Object getValue(ModelField modelField) {
        return this.serializedData.get(modelField.getName());
    }

    public int hashCode() {
        return c.b(this.serializedData, this.customTypeSchema);
    }

    public String toString() {
        return "SerializedCustomType{serializedData=" + this.serializedData + ", customTypeName=" + getCustomTypeSchema() + '}';
    }

    public /* synthetic */ SerializedCustomType(Map map, CustomTypeSchema customTypeSchema, 1 r3) {
        this(map, customTypeSchema);
    }
}
