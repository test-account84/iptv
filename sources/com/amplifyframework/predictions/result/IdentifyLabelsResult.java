package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyLabelsResult implements IdentifyResult {
    private final List labels;
    private final boolean unsafeContent;

    public static final class Builder {
        private List labels;
        private boolean unsafeContent;

        private Builder() {
            this.labels = Collections.emptyList();
        }

        public IdentifyLabelsResult build() {
            return new IdentifyLabelsResult(this, null);
        }

        public List getLabels() {
            List list = this.labels;
            Objects.requireNonNull(list);
            return list;
        }

        public boolean getUnsafeContent() {
            return this.unsafeContent;
        }

        public Builder labels(List list) {
            Objects.requireNonNull(list);
            this.labels = list;
            return this;
        }

        public Builder unsafeContent(boolean z) {
            this.unsafeContent = z;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private IdentifyLabelsResult(Builder builder) {
        this.labels = builder.getLabels();
        this.unsafeContent = builder.getUnsafeContent();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public List getLabels() {
        return Immutable.of(this.labels);
    }

    public boolean isUnsafeContent() {
        return this.unsafeContent;
    }

    public /* synthetic */ IdentifyLabelsResult(Builder builder, 1 r2) {
        this(builder);
    }
}
