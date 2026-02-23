package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.b;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ToolbarCaptureActivity extends b {
    public com.journeyapps.barcodescanner.b d;
    public DecoratedBarcodeView e;

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.Q1);
        this.e = findViewById(f.Ym);
        com.journeyapps.barcodescanner.b bVar = new com.journeyapps.barcodescanner.b(this, this.e);
        this.d = bVar;
        bVar.p(getIntent(), bundle);
        this.d.l();
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.u();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.e.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        this.d.v();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        this.d.x();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        this.d.y(bundle);
    }

    public boolean p1() {
        onBackPressed();
        return true;
    }
}
