package com.amplifyframework.core.model;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CustomTypeField {
    private final boolean isArray;
    private final boolean isCustomType;
    private final boolean isEnum;
    private final boolean isRequired;
    private final Class javaClassForValue;
    private final String name;
    private final String targetType;

    public static class CustomTypeFieldBuilder {
        private Class javaClassForValue;
        private String name;
        private String targetType;
        private boolean isRequired = false;
        private boolean isArray = false;
        private boolean isEnum = false;
        private boolean isCustomType = false;

        public static /* synthetic */ String access$000(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.name;
        }

        public static /* synthetic */ Class access$100(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.javaClassForValue;
        }

        public static /* synthetic */ String access$200(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.targetType;
        }

        public static /* synthetic */ boolean access$300(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.isRequired;
        }

        public static /* synthetic */ boolean access$400(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.isArray;
        }

        public static /* synthetic */ boolean access$500(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.isEnum;
        }

        public static /* synthetic */ boolean access$600(CustomTypeFieldBuilder customTypeFieldBuilder) {
            return customTypeFieldBuilder.isCustomType;
        }

        public CustomTypeField build() {
            return new CustomTypeField(this, null);
        }

        public CustomTypeFieldBuilder isArray(boolean z) {
            this.isArray = z;
            return this;
        }

        public CustomTypeFieldBuilder isCustomType(boolean z) {
            this.isCustomType = z;
            return this;
        }

        public CustomTypeFieldBuilder isEnum(boolean z) {
            this.isEnum = z;
            return this;
        }

        public CustomTypeFieldBuilder isRequired(boolean z) {
            this.isRequired = z;
            return this;
        }

        public CustomTypeFieldBuilder javaClassForValue(Class cls) {
            this.javaClassForValue = cls;
            return this;
        }

        public CustomTypeFieldBuilder name(String str) {
            this.name = str;
            return this;
        }

        public CustomTypeFieldBuilder targetType(String str) {
            this.targetType = str;
            return this;
        }
    }

    private CustomTypeField(CustomTypeFieldBuilder customTypeFieldBuilder) {
        this.name = CustomTypeFieldBuilder.access$000(customTypeFieldBuilder);
        this.javaClassForValue = CustomTypeFieldBuilder.access$100(customTypeFieldBuilder);
        this.targetType = CustomTypeFieldBuilder.access$200(customTypeFieldBuilder);
        this.isRequired = CustomTypeFieldBuilder.access$300(customTypeFieldBuilder);
        this.isArray = CustomTypeFieldBuilder.access$400(customTypeFieldBuilder);
        this.isEnum = CustomTypeFieldBuilder.access$500(customTypeFieldBuilder);
        this.isCustomType = CustomTypeFieldBuilder.access$600(customTypeFieldBuilder);
    }

    public static CustomTypeFieldBuilder builder() {
        return new CustomTypeFieldBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomTypeField.class != obj.getClass()) {
            return false;
        }
        CustomTypeField customTypeField = (CustomTypeField) obj;
        if (this.isRequired == customTypeField.isRequired && this.isArray == customTypeField.isArray && this.isEnum == customTypeField.isEnum && this.isCustomType == customTypeField.isCustomType && c.a(this.name, customTypeField.name) && c.a(this.javaClassForValue, customTypeField.javaClassForValue)) {
            return c.a(this.targetType, customTypeField.targetType);
        }
        return false;
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
        return ((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.isRequired ? 1 : 0)) * 31) + (this.isArray ? 1 : 0)) * 31) + (this.isEnum ? 1 : 0)) * 31) + (this.isCustomType ? 1 : 0);
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

    public boolean isRequired() {
        return this.isRequired;
    }

    public String toString() {
        return "CustomTypeField{name='" + this.name + "', javaClassForValue='" + this.javaClassForValue + "', targetType='" + this.targetType + "', isRequired=" + this.isRequired + ", isArray=" + this.isArray + ", isEnum=" + this.isEnum + ", isCustomType=" + this.isCustomType + '}';
    }

    public /* synthetic */ CustomTypeField(CustomTypeFieldBuilder customTypeFieldBuilder, 1 r2) {
        this(customTypeFieldBuilder);
    }
}
