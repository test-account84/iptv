package com.journeyapps.barcodescanner;

import B6.k;
import B6.l;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CaptureActivity extends Activity {
    public b a;
    public DecoratedBarcodeView c;

    public DecoratedBarcodeView a() {
        setContentView(l.b);
        return findViewById(k.a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = a();
        b bVar = new b(this, this.c);
        this.a = bVar;
        bVar.p(getIntent(), bundle);
        this.a.l();
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.u();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.c.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    public void onPause() {
        super.onPause();
        this.a.v();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.a.w(i, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.a.x();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.y(bundle);
    }
}
