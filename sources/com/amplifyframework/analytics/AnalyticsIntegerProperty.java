package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsIntegerProperty implements AnalyticsPropertyBehavior {
    private final Integer value;

    private AnalyticsIntegerProperty(Integer num) {
        this.value = num;
    }

    public static AnalyticsIntegerProperty from(Integer num) {
        Objects.requireNonNull(num);
        return new AnalyticsIntegerProperty(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsIntegerProperty.class != obj.getClass()) {
            return false;
        }
        return c.a(getValue(), ((AnalyticsIntegerProperty) obj).getValue());
    }

    public Integer getValue() {
        return this.value;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "AnalyticsIntegerProperty{value=" + this.value + '}';
    }
}
