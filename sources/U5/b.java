package U5;

import C2.u;
import O5.D;
import O5.r;
import Q5.B;
import R5.h;
import V5.i;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import java.nio.charset.Charset;
import z2.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public static final h c = new h();
    public static final String d = e("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String e = e("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final z2.e f = new a();
    public final e a;
    public final z2.e b;

    public b(e eVar, z2.e eVar2) {
        this.a = eVar;
        this.b = eVar2;
    }

    public static /* synthetic */ byte[] a(B b) {
        return d(b);
    }

    public static b b(Context context, i iVar, D d2) {
        u.f(context);
        g g = u.c().g(new A2.a(d, e));
        z2.b b = z2.b.b("json");
        z2.e eVar = f;
        return new b(new e(g.a("FIREBASE_CRASHLYTICS_REPORT", B.class, b, eVar), iVar.b(), d2), eVar);
    }

    public static /* synthetic */ byte[] d(B b) {
        return c.G(b).getBytes(Charset.forName("UTF-8"));
    }

    public static String e(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public Task c(r rVar, boolean z) {
        return this.a.i(rVar, z).getTask();
    }
}
