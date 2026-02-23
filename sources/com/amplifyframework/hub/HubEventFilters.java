package com.amplifyframework.hub;

import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class HubEventFilters {
    private HubEventFilters() {
        throw new UnsupportedOperationException("No instances of the HubEventFilters utility, please.");
    }

    public static /* synthetic */ boolean a(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        return lambda$and$3(hubEventFilter, hubEventFilter2, hubEvent);
    }

    public static HubEventFilter all(HubEventFilter... hubEventFilterArr) {
        return new e(hubEventFilterArr);
    }

    public static HubEventFilter always() {
        return new f();
    }

    public static HubEventFilter and(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2) {
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubEventFilter2);
        return new g(hubEventFilter, hubEventFilter2);
    }

    public static HubEventFilter any(HubEventFilter... hubEventFilterArr) {
        return new c(hubEventFilterArr);
    }

    public static /* synthetic */ boolean b(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        return lambda$or$4(hubEventFilter, hubEventFilter2, hubEvent);
    }

    public static /* synthetic */ boolean c(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        return lambda$any$2(hubEventFilterArr, hubEvent);
    }

    public static /* synthetic */ boolean d(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        return lambda$all$1(hubEventFilterArr, hubEvent);
    }

    public static /* synthetic */ boolean e(HubEvent hubEvent) {
        return lambda$always$0(hubEvent);
    }

    private static /* synthetic */ boolean lambda$all$1(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        boolean z = true;
        for (HubEventFilter hubEventFilter : hubEventFilterArr) {
            if (hubEventFilter != null) {
                z &= hubEventFilter.filter(hubEvent);
            }
        }
        return z;
    }

    private static /* synthetic */ boolean lambda$always$0(HubEvent hubEvent) {
        return true;
    }

    private static /* synthetic */ boolean lambda$and$3(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        return hubEventFilter.filter(hubEvent) && hubEventFilter2.filter(hubEvent);
    }

    private static /* synthetic */ boolean lambda$any$2(HubEventFilter[] hubEventFilterArr, HubEvent hubEvent) {
        boolean z = false;
        for (HubEventFilter hubEventFilter : hubEventFilterArr) {
            if (hubEventFilter != null) {
                z |= hubEventFilter.filter(hubEvent);
            }
        }
        return z;
    }

    private static /* synthetic */ boolean lambda$or$4(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2, HubEvent hubEvent) {
        return hubEventFilter.filter(hubEvent) || hubEventFilter2.filter(hubEvent);
    }

    public static HubEventFilter or(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2) {
        Objects.requireNonNull(hubEventFilter);
        Objects.requireNonNull(hubEventFilter2);
        return new d(hubEventFilter, hubEventFilter2);
    }
}
