package a1;

import androidx.work.WorkerParameters;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l implements Runnable {
    public R0.j a;
    public String c;
    public WorkerParameters.a d;

    public l(R0.j jVar, String str, WorkerParameters.a aVar) {
        this.a = jVar;
        this.c = str;
        this.d = aVar;
    }

    public void run() {
        this.a.o().k(this.c, this.d);
    }
}
