package z8;

import java.util.Random;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b extends z8.a {
    public final a d = new a();

    public static final class a extends ThreadLocal {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random e() {
        Object obj = this.d.get();
        l.d(obj, "implStorage.get()");
        return (Random) obj;
    }
}
