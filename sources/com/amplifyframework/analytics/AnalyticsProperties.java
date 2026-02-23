package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsProperties implements Iterable {
    private final Map properties;

    public static final class Builder {
        private final Map properties = new HashMap();

        public Builder add(String str, AnalyticsPropertyBehavior analyticsPropertyBehavior) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(analyticsPropertyBehavior);
            this.properties.put(str, analyticsPropertyBehavior);
            return this;
        }

        public AnalyticsProperties build() {
            return new AnalyticsProperties(this.properties, null);
        }

        public Builder add(String str, Boolean bool) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(bool);
            this.properties.put(str, AnalyticsBooleanProperty.from(bool));
            return this;
        }

        public Builder add(String str, Double d) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(d);
            this.properties.put(str, AnalyticsDoubleProperty.from(d));
            return this;
        }

        public Builder add(String str, Integer num) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(num);
            this.properties.put(str, AnalyticsIntegerProperty.from(num));
            return this;
        }

        public Builder add(String str, String str2) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(str2);
            this.properties.put(str, AnalyticsStringProperty.from(str2));
            return this;
        }
    }

    private AnalyticsProperties(Map map) {
        this.properties = map;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsProperties.class != obj.getClass()) {
            return false;
        }
        return c.a(this.properties, ((AnalyticsProperties) obj).properties);
    }

    public AnalyticsPropertyBehavior get(String str) throws NoSuchElementException {
        if (((AnalyticsPropertyBehavior) this.properties.get(str)) != null) {
            return (AnalyticsPropertyBehavior) this.properties.get(str);
        }
        throw new NoSuchElementException("AnalyticsPropertyBehavior not found " + str);
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    public Iterator iterator() {
        return this.properties.entrySet().iterator();
    }

    public int size() {
        return this.properties.size();
    }

    public String toString() {
        return "AnalyticsProperties{properties=" + this.properties + '}';
    }

    public /* synthetic */ AnalyticsProperties(Map map, 1 r2) {
        this(map);
    }
}
