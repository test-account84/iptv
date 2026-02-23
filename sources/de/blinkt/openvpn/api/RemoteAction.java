package de.blinkt.openvpn.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.h;
import f8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RemoteAction extends Activity {
    public h8.b a;
    public h c;
    public ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RemoteAction.a(RemoteAction.this, h.a.A(iBinder));
            try {
                RemoteAction.b(RemoteAction.this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static /* synthetic */ h a(RemoteAction remoteAction, h hVar) {
        remoteAction.c = hVar;
        return hVar;
    }

    public static /* synthetic */ void b(RemoteAction remoteAction) {
        remoteAction.c();
    }

    public final void c() {
        if (!this.c.s(getCallingPackage())) {
            finish();
            return;
        }
        Intent intent = getIntent();
        setIntent((Intent) null);
        ComponentName component = intent.getComponent();
        if (component.getShortClassName().equals(".api.DisconnectVPN")) {
            this.c.a(false);
        } else if (component.getShortClassName().equals(".api.ConnectVPN")) {
            String stringExtra = intent.getStringExtra("de.blinkt.openvpn.api.profileName");
            l j = C.g(this).j(stringExtra);
            if (j == null) {
                Toast.makeText(this, String.format("Vpn profile %s from API call not found", new Object[]{stringExtra}), 1).show();
            } else {
                Intent intent2 = new Intent(this, LaunchVPN.class);
                intent2.putExtra("de.blinkt.openvpn.shortcutProfileUUID", j.A().toString());
                intent2.setAction("android.intent.action.MAIN");
                startActivity(intent2);
            }
        }
        finish();
    }

    public void finish() {
        if (this.c != null) {
            this.c = null;
            getApplicationContext().unbindService(this.d);
        }
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new h8.b(this);
    }

    public void onResume() {
        super.onResume();
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        getApplicationContext().bindService(intent, this.d, 1);
    }
}
