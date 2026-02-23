package M4;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b4 implements Runnable {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ f5 e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ i4 g;

    public b4(i4 i4Var, AtomicReference atomicReference, String str, String str2, String str3, f5 f5Var, boolean z) {
        this.g = i4Var;
        this.a = atomicReference;
        this.c = str2;
        this.d = str3;
        this.e = f5Var;
        this.f = z;
    }

    public final void run() {
        AtomicReference atomicReference;
        i4 i4Var;
        p1 H;
        AtomicReference atomicReference2;
        List b0;
        synchronized (this.a) {
            try {
                try {
                    i4Var = this.g;
                    H = i4.H(i4Var);
                } catch (RemoteException e) {
                    this.g.a.d().r().d("(legacy) Failed to get user properties; remote exception", null, this.c, e);
                    this.a.set(Collections.emptyList());
                    atomicReference = this.a;
                }
                if (H == null) {
                    i4Var.a.d().r().d("(legacy) Failed to get user properties; not connected to service", null, this.c, this.d);
                    this.a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    com.google.android.gms.common.internal.r.m(this.e);
                    atomicReference2 = this.a;
                    b0 = H.b(this.c, this.d, this.f, this.e);
                } else {
                    atomicReference2 = this.a;
                    b0 = H.b0(null, this.c, this.d, this.f);
                }
                atomicReference2.set(b0);
                i4.N(this.g);
                atomicReference = this.a;
                atomicReference.notify();
            } finally {
                this.a.notify();
            }
        }
    }
}
