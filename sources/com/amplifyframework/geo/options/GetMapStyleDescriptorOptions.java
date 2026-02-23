package com.amplifyframework.geo.options;

import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GetMapStyleDescriptorOptions {
    private final String mapName;

    public static final class Builder {
        private String mapName;

        private Builder() {
        }

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.mapName;
        }

        public GetMapStyleDescriptorOptions build() {
            return new GetMapStyleDescriptorOptions(this, null);
        }

        public Builder mapName(String str) {
            Objects.requireNonNull(str);
            this.mapName = str;
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    private GetMapStyleDescriptorOptions(Builder builder) {
        this.mapName = Builder.access$000(builder);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static GetMapStyleDescriptorOptions defaults() {
        return builder().build();
    }

    public String getMapName() {
        return this.mapName;
    }

    public /* synthetic */ GetMapStyleDescriptorOptions(Builder builder, 1 r2) {
        this(builder);
    }
}
