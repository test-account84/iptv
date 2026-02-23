package com.amplifyframework.core.model;

import O.c;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.ModelIdentifier;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SerializedModel implements Model {
    private final Serializable modelId;
    private final ModelSchema modelSchema;
    private final Map serializedData;

    public static final class Builder implements BuilderSteps.SerializedDataStep, BuilderSteps.ModelSchemaStep, BuilderSteps.BuildStep {
        private String id;
        private ModelSchema modelSchema;
        private final Map serializedData;

        private Builder() {
            this.serializedData = new HashMap();
        }

        public SerializedModel build() {
            return new SerializedModel(this.id, Immutable.of(this.serializedData), this.modelSchema, null);
        }

        public BuilderSteps.SerializedDataStep modelSchema(ModelSchema modelSchema) {
            this.modelSchema = modelSchema;
            return this;
        }

        public BuilderSteps.BuildStep serializedData(Map map) {
            Map map2 = this.serializedData;
            Objects.requireNonNull(map);
            map2.putAll(map);
            this.id = ModelIdentifier.Helper.getUniqueKey(this.modelSchema, map);
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    public interface BuilderSteps {

        public interface BuildStep {
            SerializedModel build();
        }

        public interface ModelSchemaStep {
            SerializedDataStep modelSchema(ModelSchema modelSchema);
        }

        public interface SerializedDataStep {
            BuildStep serializedData(Map map);
        }
    }

    private SerializedModel(Serializable serializable, Map map, ModelSchema modelSchema) {
        this.modelId = serializable;
        this.serializedData = map;
        this.modelSchema = modelSchema;
    }

    public static BuilderSteps.ModelSchemaStep builder() {
        return new Builder(null);
    }

    public static SerializedModel create(Model model, ModelSchema modelSchema) throws AmplifyException {
        return builder().modelSchema(modelSchema).serializedData(ModelConverter.toMap(model, modelSchema)).build();
    }

    public static SerializedModel difference(Model model, Model model2, ModelSchema modelSchema) throws AmplifyException {
        if (model2 == null) {
            return create(model, modelSchema);
        }
        Map map = ModelConverter.toMap(model, modelSchema);
        Map map2 = ModelConverter.toMap(model2, modelSchema);
        Map hashMap = new HashMap();
        for (String str : map.keySet()) {
            HashSet hashSet = new HashSet();
            hashSet.add(PrimaryKey.fieldName());
            hashSet.addAll(modelSchema.getPrimaryIndexFields());
            if (hashSet.contains(str) || !c.a(map2.get(str), map.get(str))) {
                hashMap.put(str, map.get(str));
            }
        }
        return builder().modelSchema(modelSchema).serializedData(hashMap).build();
    }

    public static SerializedModel merge(SerializedModel serializedModel, SerializedModel serializedModel2, ModelSchema modelSchema) {
        Map hashMap = new HashMap(serializedModel.serializedData);
        for (String str : serializedModel2.getSerializedData().keySet()) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, serializedModel2.getSerializedData().get(str));
            }
        }
        return builder().modelSchema(modelSchema).serializedData(hashMap).build();
    }

    public static Map parseSerializedData(Map map, String str, SchemaRegistry schemaRegistry) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : schemaRegistry.getModelSchemaForModelClass(str).getFields().entrySet()) {
            String str2 = (String) entry.getKey();
            ModelField modelField = (ModelField) entry.getValue();
            if (map.containsKey(str2)) {
                Object obj2 = map.get(str2);
                if (obj2 == null) {
                    obj = null;
                } else if (modelField.isModel()) {
                    ModelSchema modelSchemaForModelClass = schemaRegistry.getModelSchemaForModelClass(modelField.getTargetType());
                    Map map2 = (Map) map.get(str2);
                    if (map2 != null) {
                        obj = builder().modelSchema(modelSchemaForModelClass).serializedData(map2).build();
                    }
                } else if (!modelField.isCustomType()) {
                    hashMap.put(str2, obj2);
                } else if (modelField.isArray()) {
                    List list = (List) obj2;
                    ArrayList arrayList = new ArrayList();
                    if (!list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(SerializedCustomType.builder().serializedData(SerializedCustomType.parseSerializedData((Map) it.next(), modelField.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(modelField.getTargetType())).build());
                        }
                    }
                    hashMap.put(str2, arrayList);
                } else {
                    obj = SerializedCustomType.builder().serializedData(SerializedCustomType.parseSerializedData((Map) obj2, modelField.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(modelField.getTargetType())).build();
                }
                hashMap.put(str2, obj);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SerializedModel.class != obj.getClass()) {
            return false;
        }
        SerializedModel serializedModel = (SerializedModel) obj;
        return c.a(this.modelId, serializedModel.modelId) && c.a(this.serializedData, serializedModel.serializedData) && c.a(this.modelSchema, serializedModel.modelSchema);
    }

    public String getModelName() {
        ModelSchema modelSchema = this.modelSchema;
        if (modelSchema == null) {
            return null;
        }
        return modelSchema.getName();
    }

    public ModelSchema getModelSchema() {
        return this.modelSchema;
    }

    public /* synthetic */ String getPrimaryKeyString() {
        return a.b(this);
    }

    public Map getSerializedData() {
        return this.serializedData;
    }

    public Object getValue(ModelField modelField) {
        return this.serializedData.get(modelField.getName());
    }

    public int hashCode() {
        return c.b(this.modelId, this.serializedData, this.modelSchema);
    }

    public Serializable resolveIdentifier() {
        return this.modelId;
    }

    public String toString() {
        return "SerializedModel{id='" + this.modelId + "', serializedData=" + this.serializedData + ", modelName=" + getModelName() + '}';
    }

    public /* synthetic */ SerializedModel(Serializable serializable, Map map, ModelSchema modelSchema, 1 r4) {
        this(serializable, map, modelSchema);
    }
}
