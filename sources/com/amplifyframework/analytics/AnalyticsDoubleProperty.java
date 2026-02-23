package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsDoubleProperty implements AnalyticsPropertyBehavior {
    private final Double value;

    private AnalyticsDoubleProperty(Double d) {
        this.value = d;
    }

    public static AnalyticsDoubleProperty from(Double d) {
        Objects.requireNonNull(d);
        return new AnalyticsDoubleProperty(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsDoubleProperty.class != obj.getClass()) {
            return false;
        }
        return c.a(getValue(), ((AnalyticsDoubleProperty) obj).getValue());
    }

    public Double getValue() {
        return this.value;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "AnalyticsDoubleProperty{value=" + this.value + '}';
    }
}
