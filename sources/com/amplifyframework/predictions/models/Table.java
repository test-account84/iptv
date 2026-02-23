package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.ImageFeature;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Table extends ImageFeature {
    private final int columnSize;
    private final int rowSize;

    public static final class Builder extends ImageFeature.Builder {
        private List cells;
        private int columnSize;
        private int rowSize;

        private Builder() {
            this.cells = Collections.emptyList();
        }

        public Builder cells(List list) {
            return (Builder) value(list);
        }

        public Builder columnSize(int i) {
            this.columnSize = i;
            return this;
        }

        public List getCells() {
            List list = this.cells;
            Objects.requireNonNull(list);
            return list;
        }

        public int getColumnSize() {
            return this.columnSize;
        }

        public int getRowSize() {
            return this.rowSize;
        }

        public Builder rowSize(int i) {
            this.rowSize = i;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }

        public Table build() {
            return new Table(this, null);
        }
    }

    private Table(Builder builder) {
        super(builder);
        this.rowSize = builder.getRowSize();
        this.columnSize = builder.getColumnSize();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public List getCells() {
        return (List) getValue();
    }

    public int getColumnSize() {
        return this.columnSize;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public String getTypeAlias() {
        return FeatureType.TABLE.getAlias();
    }

    public /* synthetic */ Table(Builder builder, 1 r2) {
        this(builder);
    }
}
