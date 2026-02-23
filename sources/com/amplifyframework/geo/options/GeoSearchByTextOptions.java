package com.amplifyframework.geo.options;

import com.amplifyframework.geo.models.CountryCode;
import com.amplifyframework.geo.models.SearchArea;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GeoSearchByTextOptions {
    private final List countries;
    private final int maxResults;
    private final SearchArea searchArea;

    public static class Builder {
        private static final int DEFAULT_MAX_RESULTS_LIMIT = 50;
        private SearchArea searchArea;
        private int maxResults = 50;
        private List countries = Collections.singletonList(CountryCode.USA);

        public static /* synthetic */ int access$000(Builder builder) {
            return builder.maxResults;
        }

        public static /* synthetic */ SearchArea access$100(Builder builder) {
            return builder.searchArea;
        }

        public static /* synthetic */ List access$200(Builder builder) {
            return builder.countries;
        }

        public GeoSearchByTextOptions build() {
            return new GeoSearchByTextOptions(this);
        }

        public Builder countries(List list) {
            Objects.requireNonNull(list);
            this.countries = list;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Country filter cannot be empty.");
            }
            return this;
        }

        public Builder maxResults(int i) {
            this.maxResults = i;
            return this;
        }

        public Builder searchArea(SearchArea searchArea) {
            Objects.requireNonNull(searchArea);
            this.searchArea = searchArea;
            return this;
        }
    }

    public GeoSearchByTextOptions(Builder builder) {
        this.maxResults = Builder.access$000(builder);
        this.searchArea = Builder.access$100(builder);
        this.countries = Builder.access$200(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GeoSearchByTextOptions defaults() {
        return builder().build();
    }

    public List getCountries() {
        return Immutable.of(this.countries);
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public SearchArea getSearchArea() {
        return this.searchArea;
    }
}
