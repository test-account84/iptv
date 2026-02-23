package a0;

import C8.i;
import G8.L;
import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.m;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c implements y8.a {
    public final String a;
    public final l b;
    public final L c;
    public final Object d;
    public volatile Y.f e;

    public static final class a extends m implements w8.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, c cVar) {
            super(0);
            this.a = context;
            this.c = cVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context context = this.a;
            kotlin.jvm.internal.l.d(context, "applicationContext");
            return b.a(context, c.b(this.c));
        }
    }

    public c(String str, Z.b bVar, l lVar, L l) {
        kotlin.jvm.internal.l.e(str, "name");
        kotlin.jvm.internal.l.e(lVar, "produceMigrations");
        kotlin.jvm.internal.l.e(l, "scope");
        this.a = str;
        this.b = lVar;
        this.c = l;
        this.d = new Object();
    }

    public static final /* synthetic */ String b(c cVar) {
        return cVar.a;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Y.f a(Context context, i iVar) {
        Y.f fVar;
        kotlin.jvm.internal.l.e(context, "thisRef");
        kotlin.jvm.internal.l.e(iVar, "property");
        Y.f fVar2 = this.e;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this.d) {
            try {
                if (this.e == null) {
                    Context applicationContext = context.getApplicationContext();
                    b0.c cVar = b0.c.a;
                    l lVar = this.b;
                    kotlin.jvm.internal.l.d(applicationContext, "applicationContext");
                    this.e = cVar.a(null, (List) lVar.invoke(applicationContext), this.c, new a(applicationContext, this));
                }
                fVar = this.e;
                kotlin.jvm.internal.l.b(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }
}
