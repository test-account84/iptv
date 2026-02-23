package J2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d implements x {
    public final Context a;
    public final K2.d b;
    public final f c;

    public d(Context context, K2.d dVar, f fVar) {
        this.a = context;
        this.b = dVar;
        this.c = fVar;
    }

    public void a(C2.p pVar, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int c = c(pVar);
        if (!z && d(jobScheduler, c, i)) {
            G2.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long b = this.b.b(pVar);
        JobInfo.Builder c2 = this.c.c(new JobInfo.Builder(c, componentName), pVar.d(), b, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", N2.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        c2.setExtras(persistableBundle);
        G2.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c), Long.valueOf(this.c.g(pVar.d(), b, i)), Long.valueOf(b), Integer.valueOf(i));
        jobScheduler.schedule(c2.build());
    }

    public void b(C2.p pVar, int i) {
        a(pVar, i, false);
    }

    public int c(C2.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(N2.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }
}
