package a1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public final WorkDatabase a;

    public f(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void a(Context context, G0.b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            bVar.u();
            try {
                bVar.H("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                bVar.H("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                bVar.G();
            } finally {
                bVar.I();
            }
        }
    }

    public int b() {
        int c;
        synchronized (f.class) {
            c = c("next_alarm_manager_id");
        }
        return c;
    }

    public final int c(String str) {
        this.a.c();
        try {
            Long b = this.a.x().b(str);
            int i = 0;
            int intValue = b != null ? b.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            e(str, i);
            this.a.r();
            this.a.g();
            return intValue;
        } catch (Throwable th) {
            this.a.g();
            throw th;
        }
    }

    public int d(int i, int i2) {
        synchronized (f.class) {
            int c = c("next_job_scheduler_id");
            if (c < i || c > i2) {
                e("next_job_scheduler_id", i + 1);
            } else {
                i = c;
            }
        }
        return i;
    }

    public final void e(String str, int i) {
        this.a.x().a(new Z0.d(str, i));
    }
}
