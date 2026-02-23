package f8;

import android.content.ServiceConnection;
import de.blinkt.openvpn.OpenVPNTileService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class k {
    public static /* bridge */ /* synthetic */ void a(OpenVPNTileService openVPNTileService, ServiceConnection serviceConnection) {
        openVPNTileService.unbindService(serviceConnection);
    }
}
