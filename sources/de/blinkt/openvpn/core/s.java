package de.blinkt.openvpn.core;

import android.net.Network;
import android.net.VpnService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class s {
    public static /* bridge */ /* synthetic */ VpnService.Builder a(VpnService.Builder builder, Network[] networkArr) {
        return builder.setUnderlyingNetworks(networkArr);
    }
}
