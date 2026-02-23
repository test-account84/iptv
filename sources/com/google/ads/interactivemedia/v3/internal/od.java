package com.google.ads.interactivemedia.v3.internal;

import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class od {
    public static final /* synthetic */ od a = new od();

    private /* synthetic */ od() {
    }

    public final ob a(UUID uuid) {
        try {
            return og.o(uuid);
        } catch (ol unused) {
            cd.b("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + String.valueOf(uuid) + ".");
            return new ny();
        }
    }
}
