package a0;

import G8.L;
import G8.M;
import G8.S0;
import G8.b0;
import G8.x0;
import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.m;
import l8.k;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {

    public static final class a extends m implements l {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(Context context) {
            kotlin.jvm.internal.l.e(context, "it");
            return k.f();
        }
    }

    public static final y8.a a(String str, Z.b bVar, l lVar, L l) {
        kotlin.jvm.internal.l.e(str, "name");
        kotlin.jvm.internal.l.e(lVar, "produceMigrations");
        kotlin.jvm.internal.l.e(l, "scope");
        return new c(str, bVar, lVar, l);
    }

    public static /* synthetic */ y8.a b(String str, Z.b bVar, l lVar, L l, int i, Object obj) {
        if ((i & 2) != 0) {
            bVar = null;
        }
        if ((i & 4) != 0) {
            lVar = a.a;
        }
        if ((i & 8) != 0) {
            l = M.a(b0.b().V(S0.b((x0) null, 1, (Object) null)));
        }
        return a(str, bVar, lVar, l);
    }
}
