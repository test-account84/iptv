package p4;

import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v extends J {
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ JSONObject f;
    public final /* synthetic */ i g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(i iVar, int i, int i2, JSONObject jSONObject) {
        super(iVar, false);
        this.g = iVar;
        this.d = i;
        this.e = i2;
        this.f = jSONObject;
    }

    public final void c() {
        n4.p X;
        i iVar = this.g;
        int i = this.d;
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        int a = iVar.k().a(i);
        int i2 = 0;
        if (a == -1) {
            n4.r rVar = (n4.r) com.google.android.gms.common.internal.r.m(iVar.l());
            a = 0;
            while (true) {
                if (a >= rVar.Z()) {
                    a = -1;
                    break;
                } else if (((n4.p) com.google.android.gms.common.internal.r.m(rVar.X(a))).K() == i) {
                    break;
                } else {
                    a++;
                }
            }
        }
        int i3 = this.e;
        if (i3 < 0) {
            setResult(new I(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(this.e)}))));
            return;
        }
        if (a == i3) {
            setResult(new I(this, new Status(0)));
            return;
        }
        if (i3 > a) {
            i3++;
        }
        i iVar2 = this.g;
        com.google.android.gms.common.internal.r.f("Must be called from the main thread.");
        int b = iVar2.k().b(i3);
        if (b != 0) {
            i2 = b;
        } else {
            n4.r l = iVar2.l();
            if (l != null && (X = l.X(i3)) != null) {
                i2 = X.K();
            }
        }
        i.c0(this.g).S(d(), new int[]{this.d}, i2, this.f);
    }
}
