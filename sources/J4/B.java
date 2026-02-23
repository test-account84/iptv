package j4;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b extends e {
    private static final a.g zza;
    private static final a.a zzb;
    private static final com.google.android.gms.common.api.a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        c cVar = new c();
        zzb = cVar;
        zzc = new com.google.android.gms.common.api.a("SmsRetriever.API", cVar, gVar);
    }

    public b(Activity activity) {
        super(activity, zzc, (a.d) null, e.a.c);
    }

    public abstract Task startSmsRetriever();

    public b(Context context) {
        super(context, zzc, (a.d) null, e.a.c);
    }
}
