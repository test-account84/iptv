package androidx.work;

import Q0.k;
import Q0.u;
import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class WorkManagerInitializer implements I0.b {
    public static final String a = k.f("WrkMgrInitializer");

    public List a() {
        return Collections.emptyList();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u b(Context context) {
        k.c().a(a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        u.g(context, new a.b().a());
        return u.f(context);
    }
}
