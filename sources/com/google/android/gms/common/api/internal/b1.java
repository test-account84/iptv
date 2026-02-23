package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.ads.interactivemedia.v3.internal.z1;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b1 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean a;
    public final AtomicReference c;
    public final Handler d;
    public final w4.h e;

    public b1(j jVar, w4.h hVar) {
        super(jVar);
        this.c = new AtomicReference((Object) null);
        this.d = new zau(Looper.getMainLooper());
        this.e = hVar;
    }

    public static final int e(Y0 y0) {
        if (y0 == null) {
            return -1;
        }
        return y0.a();
    }

    public static /* bridge */ /* synthetic */ void f(b1 b1Var, w4.b bVar, int i) {
        b1Var.a(bVar, i);
    }

    public static /* bridge */ /* synthetic */ void g(b1 b1Var) {
        b1Var.d();
    }

    public final void a(w4.b bVar, int i) {
        this.c.set((Object) null);
        b(bVar, i);
    }

    public abstract void b(w4.b bVar, int i);

    public abstract void c();

    public final void d() {
        this.c.set((Object) null);
        c();
    }

    public final void h(w4.b bVar, int i) {
        AtomicReference atomicReference;
        Y0 y0 = new Y0(bVar, i);
        do {
            atomicReference = this.c;
            if (z1.a(atomicReference, null, y0)) {
                this.d.post(new a1(this, y0));
                return;
            }
        } while (atomicReference.get() == null);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Y0 y0 = (Y0) this.c.get();
        if (i != 1) {
            if (i == 2) {
                int i3 = this.e.i(getActivity());
                if (i3 == 0) {
                    d();
                    return;
                } else {
                    if (y0 == null) {
                        return;
                    }
                    if (y0.b().H() == 18 && i3 == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            d();
            return;
        } else if (i2 == 0) {
            if (y0 != null) {
                a(new w4.b(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, y0.b().toString()), e(y0));
                return;
            }
            return;
        }
        if (y0 != null) {
            a(y0.b(), y0.a());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(new w4.b(13, null), e((Y0) this.c.get()));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new Y0(new w4.b(bundle.getInt("failed_status"), bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Y0 y0 = (Y0) this.c.get();
        if (y0 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", y0.a());
        bundle.putInt("failed_status", y0.b().H());
        bundle.putParcelable("failed_resolution", y0.b().J());
    }

    public void onStart() {
        super.onStart();
        this.a = true;
    }

    public void onStop() {
        super.onStop();
        this.a = false;
    }
}
