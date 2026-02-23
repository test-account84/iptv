package com.amplifyframework.devmenu;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.r;
import com.amplifyframework.core.R;
import x0.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DeveloperMenuActivity extends androidx.fragment.app.e {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dev_menu);
        findViewById(R.id.dev_layout).setFocusable(true);
        NavController a = r.a(this, R.id.nav_host_fragment);
        x0.c.d(findViewById(R.id.toolbar), a, new b.b(a.j()).a());
        DeveloperMenu.singletonInstance(getApplicationContext()).setOnHideAction(new h(this));
    }

    public void onStart() {
        DeveloperMenu.singletonInstance(getApplicationContext()).setVisible(true);
        super.onStart();
    }

    public void onStop() {
        DeveloperMenu.singletonInstance(getApplicationContext()).setVisible(false);
        super.onStop();
    }
}
