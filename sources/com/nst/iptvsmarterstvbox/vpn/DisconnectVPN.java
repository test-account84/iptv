package com.nst.iptvsmarterstvbox.vpn;

import a7.g;
import a7.j;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DisconnectVPN extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    public h a;
    public Context c;
    public ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DisconnectVPN.a(DisconnectVPN.this, h.a.A(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            DisconnectVPN.a(DisconnectVPN.this, null);
        }
    }

    public static /* synthetic */ h a(DisconnectVPN disconnectVPN, h hVar) {
        disconnectVPN.a = hVar;
        return hVar;
    }

    public final void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(j.W7);
        builder.setMessage(j.e0);
        builder.setNegativeButton(17039360, this);
        builder.setPositiveButton(j.d0, this);
        builder.setNeutralButton(j.W5, this);
        builder.setOnCancelListener(this);
        builder.show();
    }

    public void onCancel(DialogInterface dialogInterface) {
        finish();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            C.s(this);
            h hVar = this.a;
            if (hVar != null) {
                try {
                    hVar.a(false);
                } catch (RemoteException e) {
                    G.r(e);
                }
            }
        } else if (i == -3) {
            Intent intent = new Intent(this, LaunchVPN.class);
            intent.putExtra("de.blinkt.openvpn.shortcutProfileUUID", G.g());
            intent.putExtra("username", m7.a.g0);
            intent.putExtra("password", m7.a.h0);
            intent.setAction("android.intent.action.MAIN");
            startActivity(intent);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.W4);
        this.c = this;
    }

    public void onPause() {
        super.onPause();
        unbindService(this.d);
    }

    public void onResume() {
        super.onResume();
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, this.d, 1);
        b();
    }
}
