package com.journeyapps.barcodescanner;

import B6.e;
import B6.h;
import B6.n;
import Y6.d;
import Y6.f;
import Y6.g;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.journeyapps.barcodescanner.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x6.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public static final String o = "b";
    public static int p = 250;
    public Activity a;
    public DecoratedBarcodeView b;
    public h h;
    public e i;
    public Handler j;
    public final a.f m;
    public boolean n;
    public int c = -1;
    public boolean d = false;
    public boolean e = true;
    public String f = "";
    public boolean g = false;
    public boolean k = false;
    public Y6.a l = new a();

    public class a implements Y6.a {
        public a() {
        }

        public static /* synthetic */ void c(a aVar, Y6.b bVar) {
            aVar.d(bVar);
        }

        public void a(List list) {
        }

        public void b(Y6.b bVar) {
            b.d(b.this).e();
            b.e(b.this).f();
            b.f(b.this).post(new Y6.h(this, bVar));
        }

        public final /* synthetic */ void d(Y6.b bVar) {
            b.this.B(bVar);
        }
    }

    public class b implements a.f {
        public b() {
        }

        public void a() {
        }

        public void b() {
            if (b.h(b.this)) {
                Log.d(b.i(), "Camera closed; finishing activity");
                b.j(b.this);
            }
        }

        public void c(Exception exc) {
            b bVar = b.this;
            bVar.m(b.g(bVar).getString(n.c));
        }

        public void d() {
        }

        public void e() {
        }
    }

    public b(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.m = bVar;
        this.n = false;
        this.a = activity;
        this.b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(bVar);
        this.j = new Handler();
        this.h = new h(activity, new d(this));
        this.i = new e(activity);
    }

    public static Intent A(Y6.b bVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", bVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", bVar.a().toString());
        byte[] c = bVar.c();
        if (c != null && c.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", c);
        }
        Map d = bVar.d();
        if (d != null) {
            p pVar = p.UPC_EAN_EXTENSION;
            if (d.containsKey(pVar)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", d.get(pVar).toString());
            }
            Number number = (Number) d.get(p.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) d.get(p.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) d.get(p.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i = 0;
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i, (byte[]) it.next());
                    i++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    public static /* synthetic */ void a(b bVar, DialogInterface dialogInterface, int i) {
        bVar.q(dialogInterface, i);
    }

    public static /* synthetic */ void b(b bVar, DialogInterface dialogInterface) {
        bVar.r(dialogInterface);
    }

    public static /* synthetic */ void c(b bVar) {
        bVar.s();
    }

    public static /* synthetic */ DecoratedBarcodeView d(b bVar) {
        return bVar.b;
    }

    public static /* synthetic */ e e(b bVar) {
        return bVar.i;
    }

    public static /* synthetic */ Handler f(b bVar) {
        return bVar.j;
    }

    public static /* synthetic */ Activity g(b bVar) {
        return bVar.a;
    }

    public static /* synthetic */ boolean h(b bVar) {
        return bVar.k;
    }

    public static /* synthetic */ String i() {
        return o;
    }

    public static /* synthetic */ void j(b bVar) {
        bVar.n();
    }

    public void B(Y6.b bVar) {
        this.a.setResult(-1, A(bVar, o(bVar)));
        k();
    }

    public void C() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("TIMEOUT", true);
        this.a.setResult(0, intent);
        k();
    }

    public final void D() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("MISSING_CAMERA_PERMISSION", true);
        this.a.setResult(0, intent);
    }

    public void E(boolean z, String str) {
        this.e = z;
        if (str == null) {
            str = "";
        }
        this.f = str;
    }

    public void k() {
        if (this.b.getBarcodeView().s()) {
            n();
        } else {
            this.k = true;
        }
        this.b.e();
        this.h.d();
    }

    public void l() {
        this.b.b(this.l);
    }

    public void m(String str) {
        if (this.a.isFinishing() || this.g || this.k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.a.getString(n.c);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(n.a));
        builder.setMessage(str);
        builder.setPositiveButton(n.b, new f(this));
        builder.setOnCancelListener(new g(this));
        builder.show();
    }

    public final void n() {
        this.a.finish();
    }

    public final String o(Y6.b bVar) {
        if (this.d) {
            Bitmap b2 = bVar.b();
            try {
                File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.a.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                b2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return createTempFile.getAbsolutePath();
            } catch (IOException e) {
                Log.w(o, "Unable to create temporary file and store bitmap! " + e);
            }
        }
        return null;
    }

    public void p(Intent intent, Bundle bundle) {
        this.a.getWindow().addFlags(128);
        if (bundle != null) {
            this.c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                t();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.b.d(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.i.g(false);
            }
            if (intent.hasExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG")) {
                E(intent.getBooleanExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG", true), intent.getStringExtra("MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE"));
            }
            if (intent.hasExtra("TIMEOUT")) {
                this.j.postDelayed(new Y6.e(this), intent.getLongExtra("TIMEOUT", 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.d = true;
            }
        }
    }

    public final /* synthetic */ void q(DialogInterface dialogInterface, int i) {
        n();
    }

    public final /* synthetic */ void r(DialogInterface dialogInterface) {
        n();
    }

    public final /* synthetic */ void s() {
        Log.d(o, "Finishing due to inactivity");
        n();
    }

    public void t() {
        if (this.c == -1) {
            int rotation = this.a.getWindowManager().getDefaultDisplay().getRotation();
            int i = this.a.getResources().getConfiguration().orientation;
            int i2 = 0;
            if (i == 2) {
                if (rotation != 0 && rotation != 1) {
                    i2 = 8;
                }
            } else if (i == 1) {
                i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.c = i2;
        }
        this.a.setRequestedOrientation(this.c);
    }

    public void u() {
        this.g = true;
        this.h.d();
        this.j.removeCallbacksAndMessages((Object) null);
    }

    public void v() {
        this.h.d();
        this.b.f();
    }

    public void w(int i, String[] strArr, int[] iArr) {
        if (i == p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.b.g();
                return;
            }
            D();
            if (this.e) {
                m(this.f);
            } else {
                k();
            }
        }
    }

    public void x() {
        if (Build.VERSION.SDK_INT >= 23) {
            z();
        } else {
            this.b.g();
        }
        this.h.h();
    }

    public void y(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.c);
    }

    public final void z() {
        if (E.b.checkSelfPermission(this.a, "android.permission.CAMERA") == 0) {
            this.b.g();
        } else {
            if (this.n) {
                return;
            }
            D.b.h(this.a, new String[]{"android.permission.CAMERA"}, p);
            this.n = true;
        }
    }
}
