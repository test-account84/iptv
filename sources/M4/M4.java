package M4;

import android.app.job.JobParameters;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class m4 implements Runnable {
    public final /* synthetic */ q4 a;
    public final /* synthetic */ z1 c;
    public final /* synthetic */ JobParameters d;

    public /* synthetic */ m4(q4 q4Var, z1 z1Var, JobParameters jobParameters) {
        this.a = q4Var;
        this.c = z1Var;
        this.d = jobParameters;
    }

    public final void run() {
        this.a.d(this.c, this.d);
    }
}
