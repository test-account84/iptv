package f8;

import android.content.Intent;
import android.content.ServiceConnection;
import de.blinkt.openvpn.OpenVPNTileService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class j {
    public static /* bridge */ /* synthetic */ boolean a(OpenVPNTileService openVPNTileService, Intent intent, ServiceConnection serviceConnection, int i) {
        return openVPNTileService.bindService(intent, serviceConnection, i);
    }
}
