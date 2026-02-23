package k8;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class l implements f, Serializable {
    public w8.a a;
    public volatile Object c;
    public final Object d;

    public l(w8.a initializer, Object obj) {
        kotlin.jvm.internal.l.e(initializer, "initializer");
        this.a = initializer;
        this.c = o.a;
        this.d = obj == null ? this : obj;
    }

    public boolean a() {
        return this.c != o.a;
    }

    public Object getValue() {
        Object obj;
        Object obj2 = this.c;
        o oVar = o.a;
        if (obj2 != oVar) {
            return obj2;
        }
        synchronized (this.d) {
            obj = this.c;
            if (obj == oVar) {
                w8.a aVar = this.a;
                kotlin.jvm.internal.l.b(aVar);
                obj = aVar.invoke();
                this.c = obj;
                this.a = null;
            }
        }
        return obj;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ l(w8.a aVar, Object obj, int i, kotlin.jvm.internal.g gVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }
}
