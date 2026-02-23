package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class cl implements bu {
    private Message a;

    private cl() {
    }

    private final void d() {
        this.a = null;
        cm.k(this);
    }

    public final void a() {
        Message message = this.a;
        af.s(message);
        message.sendToTarget();
        d();
    }

    public final boolean b(Handler handler) {
        Message message = this.a;
        af.s(message);
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        d();
        return sendMessageAtFrontOfQueue;
    }

    public final void c(Message message) {
        this.a = message;
    }

    public /* synthetic */ cl(byte[] bArr) {
    }
}
