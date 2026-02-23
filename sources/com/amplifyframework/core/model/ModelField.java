package com.amplifyframework.core.model;

import O.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelField {
    private final List authRules;
    private final boolean isArray;
    private final boolean isCustomType;
    private final boolean isEnum;
    private final boolean isModel;
    private final boolean isReadOnly;
    private final boolean isRequired;
    private final Class javaClassForValue;
    private final String name;
    private final String targetType;

    public static class ModelFieldBuilder {
        private Class javaClassForValue;
        private String name;
        private String targetType;
        private boolean isReadOnly = false;
        private boolean isRequired = false;
        private boolean isArray = false;
        private boolean isEnum = false;
        private boolean isModel = false;
        private boolean isCustomType = false;
        private List authRules = new ArrayList();

        public static /* synthetic */ String access$000(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.name;
        }

        public static /* synthetic */ Class access$100(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.javaClassForValue;
        }

        public static /* synthetic */ String access$200(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.targetType;
        }

        public static /* synthetic */ boolean access$300(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isReadOnly;
        }

        public static /* synthetic */ boolean access$400(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isRequired;
        }

        public static /* synthetic */ boolean access$500(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isArray;
        }

        public static /* synthetic */ boolean access$600(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isEnum;
        }

        public static /* synthetic */ boolean access$700(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isModel;
        }

        public static /* synthetic */ boolean access$800(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.isCustomType;
        }

        public static /* synthetic */ List access$900(ModelFieldBuilder modelFieldBuilder) {
            return modelFieldBuilder.authRules;
        }

        public ModelFieldBuilder authRules(List list) {
            this.authRules = list;
            return this;
        }

        public ModelField build() {
            return new ModelField(this, null);
        }

        public ModelFieldBuilder isArray(boolean z) {
            this.isArray = z;
            return this;
        }

        public ModelFieldBuilder isCustomType(boolean z) {
            this.isCustomType = z;
            return this;
        }

        public ModelFieldBuilder isEnum(boolean z) {
            this.isEnum = z;
            return this;
        }

        public ModelFieldBuilder isModel(boolean z) {
            this.isModel = z;
            return this;
        }

        public ModelFieldBuilder isReadOnly(boolean z) {
            this.isReadOnly = z;
            return this;
        }

        public ModelFieldBuilder isRequired(boolean z) {
            this.isRequired = z;
            return this;
        }

        public ModelFieldBuilder javaClassForValue(Class cls) {
            this.javaClassForValue = cls;
            return this;
        }

        public ModelFieldBuilder name(String str) {
            this.name = str;
            return this;
        }

        public ModelFieldBuilder targetType(String str) {
            this.targetType = str;
            return this;
        }
    }

    private ModelField(ModelFieldBuilder modelFieldBuilder) {
        this.name = ModelFieldBuilder.access$000(modelFieldBuilder);
        this.javaClassForValue = ModelFieldBuilder.access$100(modelFieldBuilder);
        this.targetType = ModelFieldBuilder.access$200(modelFieldBuilder);
        this.isReadOnly = ModelFieldBuilder.access$300(modelFieldBuilder);
        this.isRequired = ModelFieldBuilder.access$400(modelFieldBuilder);
        this.isArray = ModelFieldBuilder.access$500(modelFieldBuilder);
        this.isEnum = ModelFieldBuilder.access$600(modelFieldBuilder);
        this.isModel = ModelFieldBuilder.access$700(modelFieldBuilder);
        this.isCustomType = ModelFieldBuilder.access$800(modelFieldBuilder);
        this.authRules = ModelFieldBuilder.access$900(modelFieldBuilder);
    }

    public static ModelFieldBuilder builder() {
        return new ModelFieldBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelField.class != obj.getClass()) {
            return false;
        }
        ModelField modelField = (ModelField) obj;
        if (this.isReadOnly == modelField.isReadOnly && this.isRequired == modelField.isRequired && this.isArray == modelField.isArray && this.isEnum == modelField.isEnum && this.isModel == modelField.isModel && this.isCustomType == modelField.isCustomType && c.a(this.name, modelField.name) && c.a(this.javaClassForValue, modelField.javaClassForValue)) {
            return c.a(this.targetType, modelField.targetType);
        }
        return false;
    }

    public List getAuthRules() {
        return this.authRules;
    }

    public Class getJavaClassForValue() {
        return this.javaClassForValue;
    }

    public String getName() {
        return this.name;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Class cls = this.javaClassForValue;
        int hashCode2 = (hashCode + (cls != null ? cls.hashCode() : 0)) * 31;
        String str2 = this.targetType;
        return ((((((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.isReadOnly ? 1 : 0)) * 31) + (this.isRequired ? 1 : 0)) * 31) + (this.isArray ? 1 : 0)) * 31) + (this.isEnum ? 1 : 0)) * 31) + (this.isModel ? 1 : 0)) * 31) + (this.isCustomType ? 1 : 0);
    }

    public boolean isArray() {
        return this.isArray;
    }

    public boolean isCustomType() {
        return this.isCustomType;
    }

    public boolean isEnum() {
        return this.isEnum;
    }

    public boolean isModel() {
        return this.isModel;
    }

    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public String toString() {
        return "ModelField{name='" + this.name + "', javaClassForValue='" + this.javaClassForValue + "', targetType='" + this.targetType + "', isReadOnly=" + this.isReadOnly + ", isRequired=" + this.isRequired + ", isArray=" + this.isArray + ", isEnum=" + this.isEnum + ", isModel=" + this.isModel + ", isCustomType=" + this.isCustomType + '}';
    }

    public /* synthetic */ ModelField(ModelFieldBuilder modelFieldBuilder, 1 r2) {
        this(modelFieldBuilder);
    }
}
