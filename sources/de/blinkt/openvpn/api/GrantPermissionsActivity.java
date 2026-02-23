package de.blinkt.openvpn.api;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GrantPermissionsActivity extends Activity {
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2);
        finish();
    }

    public void onStart() {
        super.onStart();
        Intent prepare = VpnService.prepare(this);
        if (prepare == null) {
            onActivityResult(0, -1, null);
        } else {
            startActivityForResult(prepare, 0);
        }
    }
}
