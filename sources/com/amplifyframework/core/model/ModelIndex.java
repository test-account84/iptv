package com.amplifyframework.core.model;

import O.c;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ModelIndex {
    private final List indexFieldNames;
    private final String indexName;

    public static final class Builder {
        private List indexFieldNames;
        private String indexName;

        public ModelIndex build() {
            return new ModelIndex(this.indexName, this.indexFieldNames, null);
        }

        public Builder indexFieldNames(List list) {
            this.indexFieldNames = list;
            return this;
        }

        public Builder indexName(String str) {
            this.indexName = str;
            return this;
        }
    }

    private ModelIndex(String str, List list) {
        this.indexName = str;
        this.indexFieldNames = list;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelIndex.class != obj.getClass()) {
            return false;
        }
        ModelIndex modelIndex = (ModelIndex) obj;
        if (c.a(this.indexName, modelIndex.indexName)) {
            return c.a(this.indexFieldNames, modelIndex.indexFieldNames);
        }
        return false;
    }

    public List getIndexFieldNames() {
        return this.indexFieldNames;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public int hashCode() {
        String str = this.indexName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.indexFieldNames;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ModelIndex{indexName='" + this.indexName + "', indexFieldNames=" + this.indexFieldNames + '}';
    }

    public /* synthetic */ ModelIndex(String str, List list, 1 r3) {
        this(str, list);
    }
}
