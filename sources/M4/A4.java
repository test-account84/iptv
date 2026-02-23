package M4;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a4 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String c;
    public final /* synthetic */ f5 d;
    public final /* synthetic */ zzcf e;
    public final /* synthetic */ i4 f;

    public a4(i4 i4Var, String str, String str2, f5 f5Var, zzcf zzcfVar) {
        this.f = i4Var;
        this.a = str;
        this.c = str2;
        this.d = f5Var;
        this.e = zzcfVar;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        try {
            try {
                i4 i4Var = this.f;
                p1 H = i4.H(i4Var);
                if (H == null) {
                    i4Var.a.d().r().c("Failed to get conditional properties; not connected to service", this.a, this.c);
                } else {
                    com.google.android.gms.common.internal.r.m(this.d);
                    arrayList = a5.v(H.s0(this.a, this.c, this.d));
                    i4.N(this.f);
                }
            } catch (RemoteException e) {
                this.f.a.d().r().d("Failed to get conditional properties; remote exception", this.a, this.c, e);
            }
        } finally {
            this.f.a.N().F(this.e, arrayList);
        }
    }
}
