package com.amplifyframework.core.model;

import O.c;
import android.annotation.SuppressLint;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelAssociation;
import com.amplifyframework.core.model.ModelField;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.HasOne;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.Indexes;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.util.FieldFinder;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelSchema {
    private final Map associations;
    private final List authRules;
    private final Map fields;
    private final Map indexes;
    private final String listPluralName;
    private final Class modelClass;
    private final int modelSchemaVersion;
    private final Model.Type modelType;
    private final String name;
    private final String pluralName;
    private final String syncPluralName;

    public static final class Builder {
        private String listPluralName;
        private Class modelClass;
        private int modelSchemaVersion;
        private String name;
        private String pluralName;
        private String syncPluralName;
        private Model.Type type;
        private final List authRules = new ArrayList();
        private final Map fields = new TreeMap();
        private final Map associations = new TreeMap();
        private final Map indexes = new TreeMap();

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.name;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.pluralName;
        }

        public static /* synthetic */ int access$1000(Builder builder) {
            return builder.modelSchemaVersion;
        }

        public static /* synthetic */ String access$200(Builder builder) {
            return builder.listPluralName;
        }

        public static /* synthetic */ String access$300(Builder builder) {
            return builder.syncPluralName;
        }

        public static /* synthetic */ List access$400(Builder builder) {
            return builder.authRules;
        }

        public static /* synthetic */ Map access$500(Builder builder) {
            return builder.fields;
        }

        public static /* synthetic */ Map access$600(Builder builder) {
            return builder.associations;
        }

        public static /* synthetic */ Map access$700(Builder builder) {
            return builder.indexes;
        }

        public static /* synthetic */ Class access$800(Builder builder) {
            return builder.modelClass;
        }

        public static /* synthetic */ Model.Type access$900(Builder builder) {
            return builder.type;
        }

        public Builder associations(Map map) {
            Objects.requireNonNull(map);
            this.associations.clear();
            this.associations.putAll(map);
            return this;
        }

        public Builder authRules(List list) {
            Objects.requireNonNull(list);
            this.authRules.clear();
            this.authRules.addAll(list);
            return this;
        }

        @SuppressLint({"SyntheticAccessor"})
        public ModelSchema build() {
            Objects.requireNonNull(this.name);
            return new ModelSchema(this, null);
        }

        public Builder fields(Map map) {
            Objects.requireNonNull(map);
            this.fields.clear();
            this.fields.putAll(map);
            return this;
        }

        public Builder indexes(Map map) {
            Objects.requireNonNull(map);
            this.indexes.clear();
            this.indexes.putAll(map);
            return this;
        }

        public Builder listPluralName(String str) {
            this.listPluralName = str;
            return this;
        }

        public Builder modelClass(Class cls) {
            this.modelClass = cls;
            return this;
        }

        public Builder modelType(Model.Type type) {
            this.type = type;
            return this;
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder pluralName(String str) {
            this.pluralName = str;
            return this;
        }

        public Builder syncPluralName(String str) {
            this.syncPluralName = str;
            return this;
        }

        public Builder version(int i) {
            this.modelSchemaVersion = i;
            return this;
        }
    }

    private ModelSchema(Builder builder) {
        this.name = Builder.access$000(builder);
        this.pluralName = Builder.access$100(builder);
        this.listPluralName = Builder.access$200(builder);
        this.syncPluralName = Builder.access$300(builder);
        this.authRules = Builder.access$400(builder);
        this.fields = Builder.access$500(builder);
        this.associations = Builder.access$600(builder);
        this.indexes = Builder.access$700(builder);
        this.modelClass = Builder.access$800(builder);
        this.modelType = Builder.access$900(builder);
        this.modelSchemaVersion = Builder.access$1000(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static ModelAssociation createModelAssociation(Field field) {
        ModelAssociation.Builder associatedName;
        Class type;
        ModelAssociation.Builder associatedType;
        if (field.isAnnotationPresent(BelongsTo.class)) {
            Annotation annotation = field.getAnnotation(BelongsTo.class);
            Objects.requireNonNull(annotation);
            BelongsTo belongsTo = (BelongsTo) annotation;
            associatedType = ModelAssociation.builder().name(BelongsTo.class.getSimpleName()).targetName(belongsTo.targetName()).targetNames(belongsTo.targetNames()).associatedType(belongsTo.type().getSimpleName()).associatedName(field.getName());
        } else {
            if (field.isAnnotationPresent(HasOne.class)) {
                Annotation annotation2 = field.getAnnotation(HasOne.class);
                Objects.requireNonNull(annotation2);
                HasOne hasOne = (HasOne) annotation2;
                associatedName = ModelAssociation.builder().name(HasOne.class.getSimpleName()).associatedName(hasOne.associatedWith());
                type = hasOne.type();
            } else {
                if (!field.isAnnotationPresent(HasMany.class)) {
                    return null;
                }
                Annotation annotation3 = field.getAnnotation(HasMany.class);
                Objects.requireNonNull(annotation3);
                HasMany hasMany = (HasMany) annotation3;
                associatedName = ModelAssociation.builder().name(HasMany.class.getSimpleName()).associatedName(hasMany.associatedWith());
                type = hasMany.type();
            }
            associatedType = associatedName.associatedType(type.getSimpleName());
        }
        return associatedType.build();
    }

    private static ModelField createModelField(Field field) {
        com.amplifyframework.core.model.annotations.ModelField modelField = (com.amplifyframework.core.model.annotations.ModelField) field.getAnnotation(com.amplifyframework.core.model.annotations.ModelField.class);
        if (modelField == null) {
            return null;
        }
        String name = field.getName();
        Class type = field.getType();
        String targetType = modelField.targetType();
        List arrayList = new ArrayList();
        for (com.amplifyframework.core.model.annotations.AuthRule authRule : modelField.authRules()) {
            arrayList.add(new AuthRule(authRule));
        }
        ModelField.ModelFieldBuilder javaClassForValue = ModelField.builder().name(name).javaClassForValue(type);
        if (targetType.isEmpty()) {
            targetType = type.getSimpleName();
        }
        return javaClassForValue.targetType(targetType).isReadOnly(modelField.isReadOnly()).isRequired(modelField.isRequired()).isArray(Collection.class.isAssignableFrom(field.getType())).isEnum(Enum.class.isAssignableFrom(field.getType())).isModel(Model.class.isAssignableFrom(field.getType())).authRules(arrayList).build();
    }

    private static ModelIndex createModelIndex(Index index) {
        return ModelIndex.builder().indexName(index.name()).indexFieldNames(Arrays.asList(index.fields())).build();
    }

    public static ModelSchema fromModelClass(Class cls) throws AmplifyException {
        try {
            List<Field> findModelFieldsIn = FieldFinder.findModelFieldsIn(cls);
            Map treeMap = new TreeMap();
            Map treeMap2 = new TreeMap();
            Map treeMap3 = new TreeMap();
            List arrayList = new ArrayList();
            ModelConfig modelConfig = (ModelConfig) cls.getAnnotation(ModelConfig.class);
            String simpleName = cls.getSimpleName();
            String str = null;
            String pluralName = (modelConfig == null || modelConfig.pluralName().isEmpty()) ? null : modelConfig.pluralName();
            Model.Type type = modelConfig != null ? modelConfig.type() : Model.Type.USER;
            String listPluralName = (modelConfig == null || modelConfig.listPluralName().isEmpty()) ? null : modelConfig.listPluralName();
            if (modelConfig != null && !modelConfig.syncPluralName().isEmpty()) {
                str = modelConfig.syncPluralName();
            }
            int version = modelConfig != null ? modelConfig.version() : 0;
            if (modelConfig != null) {
                com.amplifyframework.core.model.annotations.AuthRule[] authRules = modelConfig.authRules();
                int length = authRules.length;
                int i = 0;
                while (i < length) {
                    arrayList.add(new AuthRule(authRules[i]));
                    i++;
                    authRules = authRules;
                }
            }
            Annotation[] annotations = cls.getAnnotations();
            int length2 = annotations.length;
            int i2 = 0;
            while (i2 < length2) {
                Annotation annotation = annotations[i2];
                Annotation[] annotationArr = annotations;
                int i3 = length2;
                if (annotation.annotationType().isAssignableFrom(Indexes.class)) {
                    Index[] value = ((Indexes) annotation).value();
                    int length3 = value.length;
                    int i4 = 0;
                    while (i4 < length3) {
                        Index[] indexArr = value;
                        ModelIndex createModelIndex = createModelIndex(value[i4]);
                        treeMap3.put(createModelIndex.getIndexName(), createModelIndex);
                        i4++;
                        length3 = length3;
                        value = indexArr;
                    }
                } else if (annotation.annotationType().isAssignableFrom(Index.class)) {
                    ModelIndex createModelIndex2 = createModelIndex((Index) annotation);
                    treeMap3.put(createModelIndex2.getIndexName(), createModelIndex2);
                }
                i2++;
                annotations = annotationArr;
                length2 = i3;
            }
            for (Field field : findModelFieldsIn) {
                ModelField createModelField = createModelField(field);
                if (createModelField != null) {
                    treeMap.put(field.getName(), createModelField);
                }
                ModelAssociation createModelAssociation = createModelAssociation(field);
                if (createModelAssociation != null) {
                    treeMap2.put(field.getName(), createModelAssociation);
                }
            }
            return builder().name(simpleName).pluralName(pluralName).listPluralName(listPluralName).syncPluralName(str).authRules(arrayList).fields(treeMap).associations(treeMap2).indexes(treeMap3).modelClass(cls).modelType(type).version(version).build();
        } catch (Exception e) {
            throw new AmplifyException("Error in constructing a ModelSchema.", e, "Sorry, we don't have a suggested fix for this error yet.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelSchema.class != obj.getClass()) {
            return false;
        }
        ModelSchema modelSchema = (ModelSchema) obj;
        return c.a(getName(), modelSchema.getName()) && c.a(getPluralName(), modelSchema.getPluralName()) && c.a(getListPluralName(), modelSchema.getListPluralName()) && c.a(getSyncPluralName(), modelSchema.getSyncPluralName()) && c.a(getAuthRules(), modelSchema.getAuthRules()) && c.a(getFields(), modelSchema.getFields()) && c.a(getAssociations(), modelSchema.getAssociations()) && c.a(getIndexes(), modelSchema.getIndexes()) && c.a(getModelClass(), modelSchema.getModelClass());
    }

    public Map getAssociations() {
        return Immutable.of(this.associations);
    }

    public List getAuthRules() {
        return this.authRules;
    }

    public Map getFields() {
        return this.fields;
    }

    public Map getIndexes() {
        return this.indexes;
    }

    public String getListPluralName() {
        return this.listPluralName;
    }

    public Class getModelClass() {
        return this.modelClass;
    }

    public Model.Type getModelType() {
        return this.modelType;
    }

    public String getName() {
        return this.name;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public List getPrimaryIndexFields() {
        ModelIndex modelIndex = (ModelIndex) this.indexes.get("undefined");
        return (modelIndex == null || modelIndex.getIndexFieldNames().size() < 1) ? Arrays.asList(new String[]{PrimaryKey.fieldName()}) : modelIndex.getIndexFieldNames();
    }

    public String getPrimaryKeyName() {
        return (String) getPrimaryIndexFields().get(0);
    }

    public String getSyncPluralName() {
        return this.syncPluralName;
    }

    public int getVersion() {
        return this.modelSchemaVersion;
    }

    public boolean hasModelLevelRules() {
        return this.authRules.size() > 0;
    }

    public int hashCode() {
        return c.b(getName(), getPluralName(), getListPluralName(), getSyncPluralName(), getAuthRules(), getFields(), getAssociations(), getIndexes(), getModelClass(), Integer.valueOf(getVersion()));
    }

    public String toString() {
        return "ModelSchema{name='" + this.name + "', pluralName='" + this.pluralName + "', listPluralName='" + this.listPluralName + "', syncPluralName='" + this.syncPluralName + "', authRules=" + this.authRules + ", fields=" + this.fields + ", associations=" + this.associations + ", indexes=" + this.indexes + ", modelClass=" + this.modelClass + ", modelSchemaVersion=" + this.modelSchemaVersion + '}';
    }

    public /* synthetic */ ModelSchema(Builder builder, 1 r2) {
        this(builder);
    }
}
