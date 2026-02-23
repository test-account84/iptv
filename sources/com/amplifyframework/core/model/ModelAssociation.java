package com.amplifyframework.core.model;

import O.c;
import com.amplifyframework.core.model.annotations.BelongsTo;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelAssociation {
    private final String associatedName;
    private final String associatedType;
    private final String name;
    private final String targetName;
    private final String[] targetNames;

    public static final class Builder {
        private String associatedName;
        private String associatedType;
        private String name;
        private String targetName;
        private String[] targetNames;

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.name;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.targetName;
        }

        public static /* synthetic */ String[] access$200(Builder builder) {
            return builder.targetNames;
        }

        public static /* synthetic */ String access$300(Builder builder) {
            return builder.associatedName;
        }

        public static /* synthetic */ String access$400(Builder builder) {
            return builder.associatedType;
        }

        public Builder associatedName(String str) {
            this.associatedName = str;
            return this;
        }

        public Builder associatedType(String str) {
            this.associatedType = str;
            return this;
        }

        public ModelAssociation build() {
            return new ModelAssociation(this, null);
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder targetName(String str) {
            this.targetName = str;
            return this;
        }

        public Builder targetNames(String[] strArr) {
            this.targetNames = strArr;
            return this;
        }
    }

    private ModelAssociation(Builder builder) {
        String access$000 = Builder.access$000(builder);
        Objects.requireNonNull(access$000);
        this.name = access$000;
        this.targetName = Builder.access$100(builder);
        this.targetNames = Builder.access$200(builder);
        this.associatedName = Builder.access$300(builder);
        this.associatedType = Builder.access$400(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelAssociation.class != obj.getClass()) {
            return false;
        }
        ModelAssociation modelAssociation = (ModelAssociation) obj;
        if (c.a(this.name, modelAssociation.name) && c.a(this.targetName, modelAssociation.targetName) && c.a(this.associatedName, modelAssociation.associatedName)) {
            return c.a(this.associatedType, modelAssociation.associatedType);
        }
        return false;
    }

    public String getAssociatedName() {
        return this.associatedName;
    }

    public String getAssociatedType() {
        return this.associatedType;
    }

    public String getName() {
        return this.name;
    }

    public String getTargetName() {
        return this.targetName;
    }

    public String[] getTargetNames() {
        return this.targetNames;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.targetName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.associatedName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.associatedType;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean isOwner() {
        return BelongsTo.class.getSimpleName().equals(getName());
    }

    public String toString() {
        return "ModelAssociation{name='" + this.name + "', targetName='" + this.targetName + "', associatedName='" + this.associatedName + "', associatedType='" + this.associatedType + "'}";
    }

    public /* synthetic */ ModelAssociation(Builder builder, 1 r2) {
        this(builder);
    }
}
