package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsBooleanProperty implements AnalyticsPropertyBehavior {
    private final Boolean value;

    private AnalyticsBooleanProperty(Boolean bool) {
        this.value = bool;
    }

    public static AnalyticsBooleanProperty from(Boolean bool) {
        Objects.requireNonNull(bool);
        return new AnalyticsBooleanProperty(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsBooleanProperty.class != obj.getClass()) {
            return false;
        }
        return c.a(getValue(), ((AnalyticsBooleanProperty) obj).getValue());
    }

    public Boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "AnalyticsBooleanProperty{value=" + this.value + '}';
    }
}
