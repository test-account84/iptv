package com.amplifyframework.core.model;

import O.c;
import android.annotation.SuppressLint;
import j$.util.Objects;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CustomTypeSchema {
    private final Map fields;
    private final String name;
    private final String pluralName;

    public static final class Builder {
        private final Map fields = new TreeMap();
        private String name;
        private String pluralName;

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.name;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.pluralName;
        }

        public static /* synthetic */ Map access$200(Builder builder) {
            return builder.fields;
        }

        @SuppressLint({"SyntheticAccessor"})
        public CustomTypeSchema build() {
            Objects.requireNonNull(this.name);
            return new CustomTypeSchema(this, null);
        }

        public Builder fields(Map map) {
            Objects.requireNonNull(map);
            this.fields.clear();
            this.fields.putAll(map);
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
    }

    private CustomTypeSchema(Builder builder) {
        this.name = Builder.access$000(builder);
        this.pluralName = Builder.access$100(builder);
        this.fields = Builder.access$200(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomTypeSchema.class != obj.getClass()) {
            return false;
        }
        CustomTypeSchema customTypeSchema = (CustomTypeSchema) obj;
        return c.a(getName(), customTypeSchema.getName()) && c.a(getPluralName(), customTypeSchema.getPluralName()) && c.a(getFields(), customTypeSchema.getFields());
    }

    public Map getFields() {
        return this.fields;
    }

    public String getName() {
        return this.name;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public int hashCode() {
        return c.b(getName(), getPluralName(), getFields());
    }

    public String toString() {
        return "CustomTypeSchema{name='" + this.name + "', pluralName='" + this.pluralName + "', fields=" + this.fields + '}';
    }

    public /* synthetic */ CustomTypeSchema(Builder builder, 1 r2) {
        this(builder);
    }
}
