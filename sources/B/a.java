package b;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {

    public static final class a {
        public final Object a;

        public a(Object obj) {
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public a b(Context context, Object obj) {
        l.e(context, "context");
        return null;
    }

    public abstract Object c(int i, Intent intent);
}
