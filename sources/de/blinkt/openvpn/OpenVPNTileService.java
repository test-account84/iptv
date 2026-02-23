package de.blinkt.openvpn;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.e;
import de.blinkt.openvpn.core.h;
import f8.c;
import f8.d;
import f8.f;
import f8.g;
import f8.i;
import f8.j;
import f8.k;
import f8.l;

@TargetApi(24)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OpenVPNTileService extends TileService implements G.e {

    public class a implements Runnable {
        public final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
        }

        public void run() {
            OpenVPNTileService.a(OpenVPNTileService.this, this.a);
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h A = h.a.A(iBinder);
            if (A != null) {
                try {
                    A.a(false);
                } catch (RemoteException e) {
                    G.r(e);
                }
            }
            k.a(OpenVPNTileService.this, this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static /* synthetic */ void a(OpenVPNTileService openVPNTileService, l lVar) {
        openVPNTileService.b(lVar);
    }

    public void Z(String str) {
    }

    public final void b(l lVar) {
        if (!G.k()) {
            d(lVar, this);
            return;
        }
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        j.a(this, intent, new b(), 1);
    }

    public l c() {
        return C.f(this);
    }

    public void c0(String str, String str2, int i, e eVar, Intent intent) {
        try {
            Tile a2 = c.a(this);
            if (eVar == e.LEVEL_AUTH_FAILED || eVar == e.LEVEL_NOTCONNECTED) {
                l c = c();
                if (c == null) {
                    g.a(a2, f.a(this, a7.j.K4));
                    d.a(a2, 0);
                } else {
                    g.a(a2, f8.h.a(this, a7.j.L5, new Object[]{c.u()}));
                    d.a(a2, 1);
                }
            } else {
                l c2 = C.c(i.a(this), G.g());
                g.a(a2, f8.h.a(this, a7.j.M5, new Object[]{c2 == null ? "null?!" : c2.u()}));
                d.a(a2, 2);
            }
            f8.e.a(a2);
        } catch (Exception unused) {
        }
    }

    public void d(l lVar, Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(context, LaunchVPN.class);
        intent.putExtra("de.blinkt.openvpn.shortcutProfileUUID", lVar.B());
        intent.setFlags(268435456);
        intent.putExtra("de.blinkt.openvpn.showNoLogWindow", true);
        context.startActivity(intent);
    }

    public void onClick() {
        super.onClick();
        l c = c();
        if (c == null) {
            Toast.makeText(this, a7.j.K4, 0).show();
        } else if (f8.a.a(this)) {
            f8.b.a(this, new a(c));
        } else {
            b(c);
        }
    }

    public void onStartListening() {
        super.onStartListening();
        G.c(this);
    }

    public void onStopListening() {
        G.E(this);
        super.onStopListening();
    }

    public void onTileAdded() {
    }
}
