package n8;

import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a {

    public static final class a extends Thread {
        public final /* synthetic */ w8.a a;

        public a(w8.a aVar) {
            this.a = aVar;
        }

        public void run() {
            this.a.invoke();
        }
    }

    public static final Thread a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, w8.a block) {
        l.e(block, "block");
        a aVar = new a(block);
        if (z2) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread b(boolean z, boolean z2, ClassLoader classLoader, String str, int i, w8.a aVar, int i2, Object obj) {
        return a((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, aVar);
    }
}
