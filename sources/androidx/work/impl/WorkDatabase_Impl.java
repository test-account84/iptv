package androidx.work.impl;

import C0.e;
import C0.g;
import E0.f;
import G0.c;
import Z0.b;
import Z0.e;
import Z0.f;
import Z0.h;
import Z0.i;
import Z0.k;
import Z0.l;
import Z0.n;
import Z0.o;
import Z0.q;
import Z0.r;
import Z0.t;
import Z0.u;
import androidx.room.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile q m;
    public volatile b n;
    public volatile t o;
    public volatile h p;
    public volatile k q;
    public volatile n r;
    public volatile e s;

    public static /* synthetic */ List D(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List E(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List F(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List G(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List H(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List I(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List J(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ G0.b K(WorkDatabase_Impl workDatabase_Impl, G0.b bVar) {
        workDatabase_Impl.a = bVar;
        return bVar;
    }

    public static /* synthetic */ void L(WorkDatabase_Impl workDatabase_Impl, G0.b bVar) {
        workDatabase_Impl.m(bVar);
    }

    public static /* synthetic */ List M(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public static /* synthetic */ List N(WorkDatabase_Impl workDatabase_Impl) {
        return workDatabase_Impl.h;
    }

    public n A() {
        n nVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new o(this);
                }
                nVar = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public q B() {
        q qVar;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            try {
                if (this.m == null) {
                    this.m = new r(this);
                }
                qVar = this.m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    public t C() {
        t tVar;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            try {
                if (this.o == null) {
                    this.o = new u(this);
                }
                tVar = this.o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public c e() {
        return new c(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public G0.c f(C0.a aVar) {
        return aVar.a.a(c.b.a(aVar.b).c(aVar.c).b(new g(aVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    public b t() {
        b bVar;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            try {
                if (this.n == null) {
                    this.n = new Z0.c(this);
                }
                bVar = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public e x() {
        e eVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new f(this);
                }
                eVar = this.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public h y() {
        h hVar;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            try {
                if (this.p == null) {
                    this.p = new i(this);
                }
                hVar = this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public k z() {
        k kVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new l(this);
                }
                kVar = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public class a extends g.a {
        public a(int i) {
            super(i);
        }

        public void a(G0.b bVar) {
            bVar.C("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            bVar.C("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            bVar.C("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            bVar.C("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            bVar.C("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.C("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            bVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        public void b(G0.b bVar) {
            bVar.C("DROP TABLE IF EXISTS `Dependency`");
            bVar.C("DROP TABLE IF EXISTS `WorkSpec`");
            bVar.C("DROP TABLE IF EXISTS `WorkTag`");
            bVar.C("DROP TABLE IF EXISTS `SystemIdInfo`");
            bVar.C("DROP TABLE IF EXISTS `WorkName`");
            bVar.C("DROP TABLE IF EXISTS `WorkProgress`");
            bVar.C("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.D(WorkDatabase_Impl.this) != null) {
                int size = WorkDatabase_Impl.E(WorkDatabase_Impl.this).size();
                for (int i = 0; i < size; i++) {
                    ((e.b) WorkDatabase_Impl.G(WorkDatabase_Impl.this).get(i)).b(bVar);
                }
            }
        }

        public void c(G0.b bVar) {
            if (WorkDatabase_Impl.H(WorkDatabase_Impl.this) != null) {
                int size = WorkDatabase_Impl.I(WorkDatabase_Impl.this).size();
                for (int i = 0; i < size; i++) {
                    ((e.b) WorkDatabase_Impl.J(WorkDatabase_Impl.this).get(i)).a(bVar);
                }
            }
        }

        public void d(G0.b bVar) {
            WorkDatabase_Impl.K(WorkDatabase_Impl.this, bVar);
            bVar.C("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.L(WorkDatabase_Impl.this, bVar);
            if (WorkDatabase_Impl.M(WorkDatabase_Impl.this) != null) {
                int size = WorkDatabase_Impl.N(WorkDatabase_Impl.this).size();
                for (int i = 0; i < size; i++) {
                    ((e.b) WorkDatabase_Impl.F(WorkDatabase_Impl.this).get(i)).c(bVar);
                }
            }
        }

        public void f(G0.b bVar) {
            E0.c.a(bVar);
        }

        public g.b g(G0.b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap.put("prerequisite_id", new f.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new f.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            hashSet2.add(new f.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
            E0.f fVar = new E0.f("Dependency", hashMap, hashSet, hashSet2);
            E0.f a = E0.f.a(bVar, "Dependency");
            if (!fVar.equals(a)) {
                return new g.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + fVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("id", new f.a("id", "TEXT", true, 1, null, 1));
            hashMap2.put("state", new f.a("state", "INTEGER", true, 0, null, 1));
            hashMap2.put("worker_class_name", new f.a("worker_class_name", "TEXT", true, 0, null, 1));
            hashMap2.put("input_merger_class_name", new f.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            hashMap2.put("input", new f.a("input", "BLOB", true, 0, null, 1));
            hashMap2.put("output", new f.a("output", "BLOB", true, 0, null, 1));
            hashMap2.put("initial_delay", new f.a("initial_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("interval_duration", new f.a("interval_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("flex_duration", new f.a("flex_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_attempt_count", new f.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_policy", new f.a("backoff_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("backoff_delay_duration", new f.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("period_start_time", new f.a("period_start_time", "INTEGER", true, 0, null, 1));
            hashMap2.put("minimum_retention_duration", new f.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            hashMap2.put("schedule_requested_at", new f.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            hashMap2.put("run_in_foreground", new f.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            hashMap2.put("out_of_quota_policy", new f.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            hashMap2.put("required_network_type", new f.a("required_network_type", "INTEGER", false, 0, null, 1));
            hashMap2.put("requires_charging", new f.a("requires_charging", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_device_idle", new f.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_battery_not_low", new f.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("requires_storage_not_low", new f.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_content_update_delay", new f.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("trigger_max_content_delay", new f.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            hashMap2.put("content_uri_triggers", new f.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new f.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
            hashSet4.add(new f.d("index_WorkSpec_period_start_time", false, Arrays.asList(new String[]{"period_start_time"})));
            E0.f fVar2 = new E0.f("WorkSpec", hashMap2, hashSet3, hashSet4);
            E0.f a2 = E0.f.a(bVar, "WorkSpec");
            if (!fVar2.equals(a2)) {
                return new g.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + fVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new f.a("tag", "TEXT", true, 1, null, 1));
            hashMap3.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new f.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            E0.f fVar3 = new E0.f("WorkTag", hashMap3, hashSet5, hashSet6);
            E0.f a3 = E0.f.a(bVar, "WorkTag");
            if (!fVar3.equals(a3)) {
                return new g.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + fVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap4.put("system_id", new f.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            E0.f fVar4 = new E0.f("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            E0.f a4 = E0.f.a(bVar, "SystemIdInfo");
            if (!fVar4.equals(a4)) {
                return new g.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + fVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new f.a("name", "TEXT", true, 1, null, 1));
            hashMap5.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new f.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            E0.f fVar5 = new E0.f("WorkName", hashMap5, hashSet8, hashSet9);
            E0.f a5 = E0.f.a(bVar, "WorkName");
            if (!fVar5.equals(a5)) {
                return new g.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + fVar5 + "\n Found:\n" + a5);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, null, 1));
            hashMap6.put("progress", new f.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            E0.f fVar6 = new E0.f("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            E0.f a6 = E0.f.a(bVar, "WorkProgress");
            if (!fVar6.equals(a6)) {
                return new g.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + fVar6 + "\n Found:\n" + a6);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new f.a("key", "TEXT", true, 1, null, 1));
            hashMap7.put("long_value", new f.a("long_value", "INTEGER", false, 0, null, 1));
            E0.f fVar7 = new E0.f("Preference", hashMap7, new HashSet(0), new HashSet(0));
            E0.f a7 = E0.f.a(bVar, "Preference");
            if (fVar7.equals(a7)) {
                return new g.b(true, null);
            }
            return new g.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + fVar7 + "\n Found:\n" + a7);
        }

        public void e(G0.b bVar) {
        }
    }
}
