package v6;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.l;
import v6.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements h {
    public static final a b = new a(null);
    public final Bundle a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b(Context context) {
        l.e(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.a = bundle == null ? Bundle.EMPTY : bundle;
    }

    public Boolean a() {
        if (this.a.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.a.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    public F8.a b() {
        if (this.a.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return F8.a.c(F8.c.o(this.a.getInt("firebase_sessions_sessions_restart_timeout"), F8.d.SECONDS));
        }
        return null;
    }

    public Double c() {
        if (this.a.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.a.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    public Object d(o8.d dVar) {
        return h.a.a(this, dVar);
    }
}
