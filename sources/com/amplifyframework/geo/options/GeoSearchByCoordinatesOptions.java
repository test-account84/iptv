package com.amplifyframework.geo.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GeoSearchByCoordinatesOptions {
    private final int maxResults;

    public static class Builder {
        private static final int DEFAULT_MAX_RESULTS_LIMIT = 50;
        private int maxResults = 50;

        public static /* synthetic */ int access$000(Builder builder) {
            return builder.maxResults;
        }

        public GeoSearchByCoordinatesOptions build() {
            return new GeoSearchByCoordinatesOptions(this);
        }

        public Builder maxResults(int i) {
            this.maxResults = i;
            return this;
        }
    }

    public GeoSearchByCoordinatesOptions(Builder builder) {
        this.maxResults = Builder.access$000(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GeoSearchByCoordinatesOptions defaults() {
        return builder().build();
    }

    public int getMaxResults() {
        return this.maxResults;
    }
}
