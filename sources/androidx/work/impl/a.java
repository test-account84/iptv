package androidx.work.impl;

import android.content.Context;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a {
    public static D0.a a = new a(1, 2);
    public static D0.a b = new b(3, 4);
    public static D0.a c = new c(4, 5);
    public static D0.a d = new d(6, 7);
    public static D0.a e = new e(7, 8);
    public static D0.a f = new f(8, 9);
    public static D0.a g = new g(11, 12);

    public class a extends D0.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.C("DROP TABLE IF EXISTS alarmInfo");
            bVar.C("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends D0.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.C("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    public class c extends D0.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.C("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    public class d extends D0.a {
        public d(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    public class e extends D0.a {
        public e(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    public class f extends D0.a {
        public f(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class g extends D0.a {
        public g(int i, int i2) {
            super(i, i2);
        }

        public void a(G0.b bVar) {
            bVar.C("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends D0.a {
        public final Context c;

        public h(Context context, int i, int i2) {
            super(i, i2);
            this.c = context;
        }

        public void a(G0.b bVar) {
            if (this.b >= 10) {
                bVar.H("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    public static class i extends D0.a {
        public final Context c;

        public i(Context context) {
            super(9, 10);
            this.c = context;
        }

        public void a(G0.b bVar) {
            bVar.C("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            a1.h.b(this.c, bVar);
            a1.f.a(this.c, bVar);
        }
    }
}
