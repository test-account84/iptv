package com.amplifyframework.hub;

import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class h implements HubSubscriber {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ h(Consumer consumer) {
        this.a = consumer;
    }

    public final void onEvent(HubEvent hubEvent) {
        i.b(this.a, hubEvent);
    }
}
