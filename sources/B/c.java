package b;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c extends b.a {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        l.e(context, "context");
        l.e(intent, "input");
        return intent;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.a c(int i, Intent intent) {
        return new androidx.activity.result.a(i, intent);
    }
}
