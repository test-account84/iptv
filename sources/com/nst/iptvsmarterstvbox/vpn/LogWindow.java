package com.nst.iptvsmarterstvbox.vpn;

import G7.a;
import a7.f;
import a7.g;
import android.os.Bundle;
import android.view.MenuItem;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LogWindow extends a {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.F3);
        if (bundle == null) {
            getFragmentManager().beginTransaction().add(f.m2, new K7.a()).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
