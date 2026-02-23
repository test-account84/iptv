package C5;

import A5.f;
import C5.a;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.zzef;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements C5.a {
    public static volatile C5.a c;
    public final L4.a a;
    public final Map b;

    public class a implements a.a {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }
    }

    public b(L4.a aVar) {
        r.m(aVar);
        this.a = aVar;
        this.b = new ConcurrentHashMap();
    }

    public static C5.a d(f fVar, Context context, g6.d dVar) {
        r.m(fVar);
        r.m(context);
        r.m(dVar);
        r.m(context.getApplicationContext());
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        Bundle bundle = new Bundle(1);
                        if (fVar.w()) {
                            dVar.b(A5.b.class, c.a, d.a);
                            bundle.putBoolean("dataCollectionDefaultEnabled", fVar.v());
                        }
                        c = new b(zzef.zzg(context, null, null, null, bundle).zzd());
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static /* synthetic */ void e(g6.a aVar) {
        throw null;
    }

    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (D5.b.d(str) && D5.b.b(str2, bundle) && D5.b.a(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.a.a(str, str2, bundle);
        }
    }

    public void b(String str, String str2, Object obj) {
        if (D5.b.d(str) && D5.b.e(str, str2)) {
            this.a.c(str, str2, obj);
        }
    }

    public a.a c(String str, a.b bVar) {
        r.m(bVar);
        if (!D5.b.d(str) || f(str)) {
            return null;
        }
        L4.a aVar = this.a;
        Object dVar = "fiam".equals(str) ? new D5.d(aVar, bVar) : "clx".equals(str) ? new D5.f(aVar, bVar) : null;
        if (dVar == null) {
            return null;
        }
        this.b.put(str, dVar);
        return new a(str);
    }

    public final boolean f(String str) {
        return (str.isEmpty() || !this.b.containsKey(str) || this.b.get(str) == null) ? false : true;
    }
}
