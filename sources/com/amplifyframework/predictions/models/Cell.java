package com.amplifyframework.predictions.models;

import com.amplifyframework.predictions.models.ImageFeature;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Cell extends ImageFeature {
    private final int column;
    private final int row;
    private final boolean selected;

    public static final class Builder extends ImageFeature.Builder {
        private int column;
        private int row;
        private boolean selected;

        public Cell build() {
            return new Cell(this, null);
        }

        public Builder column(int i) {
            this.column = i;
            return this;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }

        public boolean getSelected() {
            return this.selected;
        }

        public Builder row(int i) {
            this.row = i;
            return this;
        }

        public Builder selected(boolean z) {
            this.selected = z;
            return this;
        }

        public Builder text(String str) {
            return (Builder) value(str);
        }
    }

    private Cell(Builder builder) {
        super(builder);
        this.selected = builder.getSelected();
        this.row = builder.getRow();
        this.column = builder.getColumn();
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public String getText() {
        return (String) getValue();
    }

    public String getTypeAlias() {
        return FeatureType.CELL.getAlias();
    }

    public boolean isSelected() {
        return this.selected;
    }

    public /* synthetic */ Cell(Builder builder, 1 r2) {
        this(builder);
    }
}
