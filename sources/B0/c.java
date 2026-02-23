package b0;

import G8.L;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public static final c a = new c();

    public static final class a extends m implements w8.a {
        public final /* synthetic */ w8.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w8.a aVar) {
            super(0);
            this.a = aVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) this.a.invoke();
            String a = u8.e.a(file);
            h hVar = h.a;
            if (l.a(a, hVar.f())) {
                return file;
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: " + hVar.f()).toString());
        }
    }

    public final Y.f a(Z.b bVar, List list, L l, w8.a aVar) {
        l.e(list, "migrations");
        l.e(l, "scope");
        l.e(aVar, "produceFile");
        return new b(Y.g.a.a(h.a, bVar, list, l, new a(aVar)));
    }
}
