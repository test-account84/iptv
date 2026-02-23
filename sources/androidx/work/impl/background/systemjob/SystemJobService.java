package androidx.work.impl.background.systemjob;

import Q0.k;
import R0.b;
import R0.j;
import U0.n;
import U0.o;
import U0.p;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SystemJobService extends JobService implements b {
    public static final String d = k.f("SystemJobService");
    public j a;
    public final Map c = new HashMap();

    public static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void d(String str, boolean z) {
        JobParameters jobParameters;
        k.c().a(d, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.c) {
            jobParameters = (JobParameters) this.c.remove(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            j m = j.m(getApplicationContext());
            this.a = m;
            m.o().c(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            k.c().h(d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j jVar = this.a;
        if (jVar != null) {
            jVar.o().i(this);
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        if (this.a == null) {
            k.c().a(d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String a = a(jobParameters);
        if (TextUtils.isEmpty(a)) {
            k.c().b(d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.c) {
            try {
                if (this.c.containsKey(a)) {
                    k.c().a(d, String.format("Job is already being executed by SystemJobService: %s", new Object[]{a}), new Throwable[0]);
                    return false;
                }
                k.c().a(d, String.format("onStartJob for %s", new Object[]{a}), new Throwable[0]);
                this.c.put(a, jobParameters);
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    aVar = new WorkerParameters.a();
                    if (n.a(jobParameters) != null) {
                        aVar.b = Arrays.asList(n.a(jobParameters));
                    }
                    if (o.a(jobParameters) != null) {
                        aVar.a = Arrays.asList(o.a(jobParameters));
                    }
                    if (i >= 28) {
                        aVar.c = p.a(jobParameters);
                    }
                } else {
                    aVar = null;
                }
                this.a.x(a, aVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.a == null) {
            k.c().a(d, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a = a(jobParameters);
        if (TextUtils.isEmpty(a)) {
            k.c().b(d, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        k.c().a(d, String.format("onStopJob for %s", new Object[]{a}), new Throwable[0]);
        synchronized (this.c) {
            this.c.remove(a);
        }
        this.a.z(a);
        return !this.a.o().f(a);
    }
}
