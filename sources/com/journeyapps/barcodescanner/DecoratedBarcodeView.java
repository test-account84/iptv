package com.journeyapps.barcodescanner;

import B6.f;
import B6.g;
import B6.k;
import B6.l;
import B6.o;
import Y6.m;
import Z6.i;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x6.j;
import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DecoratedBarcodeView extends FrameLayout {
    public BarcodeView a;
    public ViewfinderView c;
    public TextView d;

    public interface a {
    }

    public class b implements Y6.a {
        public Y6.a a;

        public b(Y6.a aVar) {
            this.a = aVar;
        }

        public void a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.a(DecoratedBarcodeView.this).a((q) it.next());
            }
            this.a.a(list);
        }

        public void b(Y6.b bVar) {
            this.a.b(bVar);
        }
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public static /* synthetic */ ViewfinderView a(DecoratedBarcodeView decoratedBarcodeView) {
        return decoratedBarcodeView.c;
    }

    public void b(Y6.a aVar) {
        this.a.I(new b(aVar));
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.l);
        int resourceId = obtainStyledAttributes.getResourceId(o.m, l.a);
        obtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView findViewById = findViewById(k.b);
        this.a = findViewById;
        if (findViewById == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        findViewById.q(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(k.l);
        this.c = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.a);
        this.d = findViewById(k.k);
    }

    public void d(Intent intent) {
        int intExtra;
        Set a2 = f.a(intent);
        Map a3 = g.a(intent);
        i iVar = new i();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            iVar.i(intExtra);
        }
        if (intent.hasExtra("TORCH_ENABLED") && intent.getBooleanExtra("TORCH_ENABLED", false)) {
            i();
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new j().e(a3);
        this.a.setCameraSettings(iVar);
        this.a.setDecoderFactory(new m(a2, a3, stringExtra2, intExtra2));
    }

    public void e() {
        this.a.u();
    }

    public void f() {
        this.a.v();
    }

    public void g() {
        this.a.y();
    }

    public BarcodeView getBarcodeView() {
        return findViewById(k.b);
    }

    public i getCameraSettings() {
        return this.a.getCameraSettings();
    }

    public Y6.j getDecoderFactory() {
        return this.a.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.d;
    }

    public ViewfinderView getViewFinder() {
        return this.c;
    }

    public void h() {
        this.a.setTorch(false);
    }

    public void i() {
        this.a.setTorch(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            i();
            return true;
        }
        if (i == 25) {
            h();
            return true;
        }
        if (i == 27 || i == 80) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setCameraSettings(i iVar) {
        this.a.setCameraSettings(iVar);
    }

    public void setDecoderFactory(Y6.j jVar) {
        this.a.setDecoderFactory(jVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }
}
