package com.journeyapps.barcodescanner;

import B6.k;
import Y6.i;
import Y6.j;
import Y6.l;
import Y6.m;
import Y6.x;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x6.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BarcodeView extends com.journeyapps.barcodescanner.a {
    public b C;
    public Y6.a D;
    public l E;
    public j F;
    public Handler G;
    public final Handler.Callback H;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == k.g) {
                Y6.b bVar = (Y6.b) message.obj;
                if (bVar != null && BarcodeView.E(BarcodeView.this) != null && BarcodeView.F(BarcodeView.this) != b.NONE) {
                    BarcodeView.E(BarcodeView.this).b(bVar);
                    if (BarcodeView.F(BarcodeView.this) == b.SINGLE) {
                        BarcodeView.this.M();
                    }
                }
                return true;
            }
            if (i == k.f) {
                return true;
            }
            if (i != k.h) {
                return false;
            }
            List list = (List) message.obj;
            if (BarcodeView.E(BarcodeView.this) != null && BarcodeView.F(BarcodeView.this) != b.NONE) {
                BarcodeView.E(BarcodeView.this).a(list);
            }
            return true;
        }
    }

    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = b.NONE;
        this.D = null;
        this.H = new a();
        J();
    }

    public static /* synthetic */ Y6.a E(BarcodeView barcodeView) {
        return barcodeView.D;
    }

    public static /* synthetic */ b F(BarcodeView barcodeView) {
        return barcodeView.C;
    }

    public final i G() {
        if (this.F == null) {
            this.F = H();
        }
        Y6.k kVar = new Y6.k();
        Map hashMap = new HashMap();
        hashMap.put(e.NEED_RESULT_POINT_CALLBACK, kVar);
        i a2 = this.F.a(hashMap);
        kVar.b(a2);
        return a2;
    }

    public j H() {
        return new m();
    }

    public void I(Y6.a aVar) {
        this.C = b.SINGLE;
        this.D = aVar;
        K();
    }

    public final void J() {
        this.F = new m();
        this.G = new Handler(this.H);
    }

    public final void K() {
        L();
        if (this.C == b.NONE || !t()) {
            return;
        }
        l lVar = new l(getCameraInstance(), G(), this.G);
        this.E = lVar;
        lVar.i(getPreviewFramingRect());
        this.E.k();
    }

    public final void L() {
        l lVar = this.E;
        if (lVar != null) {
            lVar.l();
            this.E = null;
        }
    }

    public void M() {
        this.C = b.NONE;
        this.D = null;
        L();
    }

    public j getDecoderFactory() {
        return this.F;
    }

    public void setDecoderFactory(j jVar) {
        x.a();
        this.F = jVar;
        l lVar = this.E;
        if (lVar != null) {
            lVar.j(G());
        }
    }

    public void u() {
        L();
        super.u();
    }

    public void x() {
        super.x();
        K();
    }
}
