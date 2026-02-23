package b;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d extends b.a {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, e eVar) {
        l.e(context, "context");
        l.e(eVar, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
        l.d(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return putExtra;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.a c(int i, Intent intent) {
        return new androidx.activity.result.a(i, intent);
    }
}
