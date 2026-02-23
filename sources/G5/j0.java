package G5;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.zzafn;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j0 implements H5.s, H5.T {
    public final /* synthetic */ FirebaseAuth a;

    public j0(FirebaseAuth firebaseAuth) {
        this.a = firebaseAuth;
    }

    public final void a(zzafn zzafnVar, u uVar) {
        this.a.s(uVar, zzafnVar, true, true);
    }

    public final void zza(Status status) {
        int I = status.I();
        if (I == 17011 || I == 17021 || I == 17005) {
            this.a.k();
        }
    }
}
