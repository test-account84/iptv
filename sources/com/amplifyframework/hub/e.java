package com.amplifyframework.hub;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class e implements HubEventFilter {
    public final /* synthetic */ HubEventFilter[] a;

    public /* synthetic */ e(HubEventFilter[] hubEventFilterArr) {
        this.a = hubEventFilterArr;
    }

    public final boolean filter(HubEvent hubEvent) {
        return HubEventFilters.d(this.a, hubEvent);
    }
}
