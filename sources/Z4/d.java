package z4;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends com.google.android.gms.common.api.e implements x {
    public static final a.g d;
    public static final a.a e;
    public static final com.google.android.gms.common.api.a f;

    static {
        a.g gVar = new a.g();
        d = gVar;
        c cVar = new c();
        e = cVar;
        f = new com.google.android.gms.common.api.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, y yVar) {
        super(context, f, yVar, e.a.c);
    }

    public final Task a(v vVar) {
        t.a a = t.a();
        a.d(zaf.zaa);
        a.c(false);
        a.b(new b(vVar));
        return doBestEffortWrite(a.a());
    }
}
