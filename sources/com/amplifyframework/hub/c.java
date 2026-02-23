package com.amplifyframework.hub;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class c implements HubEventFilter {
    public final /* synthetic */ HubEventFilter[] a;

    public /* synthetic */ c(HubEventFilter[] hubEventFilterArr) {
        this.a = hubEventFilterArr;
    }

    public final boolean filter(HubEvent hubEvent) {
        return HubEventFilters.c(this.a, hubEvent);
    }
}
