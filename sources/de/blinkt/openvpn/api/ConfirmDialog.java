package de.blinkt.openvpn.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;
import android.widget.CompoundButton;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ConfirmDialog extends Activity implements CompoundButton.OnCheckedChangeListener, DialogInterface.OnClickListener {
    public String a;
    public Button c;
    public h d;
    public ServiceConnection e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ConfirmDialog.a(ConfirmDialog.this, h.a.A(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ConfirmDialog.a(ConfirmDialog.this, null);
        }
    }

    public static /* synthetic */ h a(ConfirmDialog confirmDialog, h hVar) {
        confirmDialog.d = hVar;
        return hVar;
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.c.setEnabled(z);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            try {
                this.d.H0(this.a);
                setResult(-1);
                finish();
            } catch (RemoteException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (i == -2) {
            setResult(0);
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        unbindService(this.e);
    }

    public void onResume() {
        super.onResume();
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, this.e, 1);
        Intent intent2 = getIntent();
        if (intent2.getStringExtra("android.intent.extra.PACKAGE_NAME") != null) {
            this.a = intent2.getStringExtra("android.intent.extra.PACKAGE_NAME");
            return;
        }
        String callingPackage = getCallingPackage();
        this.a = callingPackage;
        if (callingPackage == null) {
            finish();
        }
    }
}
