package com.amplifyframework.hub;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class d implements HubEventFilter {
    public final /* synthetic */ HubEventFilter a;
    public final /* synthetic */ HubEventFilter b;

    public /* synthetic */ d(HubEventFilter hubEventFilter, HubEventFilter hubEventFilter2) {
        this.a = hubEventFilter;
        this.b = hubEventFilter2;
    }

    public final boolean filter(HubEvent hubEvent) {
        return HubEventFilters.b(this.a, this.b, hubEvent);
    }
}
