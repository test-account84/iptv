package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsStringProperty implements AnalyticsPropertyBehavior {
    private final String value;

    private AnalyticsStringProperty(String str) {
        this.value = str;
    }

    public static AnalyticsStringProperty from(String str) {
        Objects.requireNonNull(str);
        return new AnalyticsStringProperty(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsStringProperty.class != obj.getClass()) {
            return false;
        }
        return c.a(getValue(), ((AnalyticsStringProperty) obj).getValue());
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "AnalyticsStringProperty{value='" + this.value + "'}";
    }

    public String getValue() {
        return this.value;
    }
}
