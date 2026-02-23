package Z0;

import Z0.p;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class r implements q {
    public final C0.e a;
    public final C0.b b;
    public final C0.k c;
    public final C0.k d;
    public final C0.k e;
    public final C0.k f;
    public final C0.k g;
    public final C0.k h;
    public final C0.k i;
    public final C0.k j;

    public class a extends C0.b {
        public a(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(G0.f fVar, p pVar) {
            String str = pVar.a;
            if (str == null) {
                fVar.X(1);
            } else {
                fVar.x(1, str);
            }
            fVar.A(2, v.j(pVar.b));
            String str2 = pVar.c;
            if (str2 == null) {
                fVar.X(3);
            } else {
                fVar.x(3, str2);
            }
            String str3 = pVar.d;
            if (str3 == null) {
                fVar.X(4);
            } else {
                fVar.x(4, str3);
            }
            byte[] n = androidx.work.b.n(pVar.e);
            if (n == null) {
                fVar.X(5);
            } else {
                fVar.S(5, n);
            }
            byte[] n2 = androidx.work.b.n(pVar.f);
            if (n2 == null) {
                fVar.X(6);
            } else {
                fVar.S(6, n2);
            }
            fVar.A(7, pVar.g);
            fVar.A(8, pVar.h);
            fVar.A(9, pVar.i);
            fVar.A(10, pVar.k);
            fVar.A(11, v.a(pVar.l));
            fVar.A(12, pVar.m);
            fVar.A(13, pVar.n);
            fVar.A(14, pVar.o);
            fVar.A(15, pVar.p);
            fVar.A(16, pVar.q ? 1L : 0L);
            fVar.A(17, v.i(pVar.r));
            Q0.b bVar = pVar.j;
            if (bVar != null) {
                fVar.A(18, v.h(bVar.b()));
                fVar.A(19, bVar.g() ? 1L : 0L);
                fVar.A(20, bVar.h() ? 1L : 0L);
                fVar.A(21, bVar.f() ? 1L : 0L);
                fVar.A(22, bVar.i() ? 1L : 0L);
                fVar.A(23, bVar.c());
                fVar.A(24, bVar.d());
                byte[] c = v.c(bVar.a());
                if (c != null) {
                    fVar.S(25, c);
                    return;
                }
            } else {
                fVar.X(18);
                fVar.X(19);
                fVar.X(20);
                fVar.X(21);
                fVar.X(22);
                fVar.X(23);
                fVar.X(24);
            }
            fVar.X(25);
        }
    }

    public class b extends C0.k {
        public b(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends C0.k {
        public c(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends C0.k {
        public d(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends C0.k {
        public e(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends C0.k {
        public f(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends C0.k {
        public g(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends C0.k {
        public h(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class i extends C0.k {
        public i(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(C0.e eVar) {
        this.a = eVar;
        this.b = new a(eVar);
        this.c = new b(eVar);
        this.d = new c(eVar);
        this.e = new d(eVar);
        this.f = new e(eVar);
        this.g = new f(eVar);
        this.h = new g(eVar);
        this.i = new h(eVar);
        this.j = new i(eVar);
    }

    public void a(String str) {
        this.a.b();
        G0.f a2 = this.c.a();
        if (str == null) {
            a2.X(1);
        } else {
            a2.x(1, str);
        }
        this.a.c();
        try {
            a2.E();
            this.a.r();
        } finally {
            this.a.g();
            this.c.f(a2);
        }
    }

    public List b(long j) {
        C0.h hVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        d2.A(1, j);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "required_network_type");
            int b4 = E0.b.b(b2, "requires_charging");
            int b5 = E0.b.b(b2, "requires_device_idle");
            int b6 = E0.b.b(b2, "requires_battery_not_low");
            int b7 = E0.b.b(b2, "requires_storage_not_low");
            int b8 = E0.b.b(b2, "trigger_content_update_delay");
            int b9 = E0.b.b(b2, "trigger_max_content_delay");
            int b10 = E0.b.b(b2, "content_uri_triggers");
            int b11 = E0.b.b(b2, "id");
            int b12 = E0.b.b(b2, "state");
            int b13 = E0.b.b(b2, "worker_class_name");
            int b14 = E0.b.b(b2, "input_merger_class_name");
            int b15 = E0.b.b(b2, "input");
            int b16 = E0.b.b(b2, "output");
            hVar = d2;
            try {
                int b17 = E0.b.b(b2, "initial_delay");
                int b18 = E0.b.b(b2, "interval_duration");
                int b19 = E0.b.b(b2, "flex_duration");
                int b20 = E0.b.b(b2, "run_attempt_count");
                int b21 = E0.b.b(b2, "backoff_policy");
                int b22 = E0.b.b(b2, "backoff_delay_duration");
                int b23 = E0.b.b(b2, "period_start_time");
                int b24 = E0.b.b(b2, "minimum_retention_duration");
                int b25 = E0.b.b(b2, "schedule_requested_at");
                int b26 = E0.b.b(b2, "run_in_foreground");
                int b27 = E0.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    Q0.b bVar = new Q0.b();
                    int i5 = b3;
                    bVar.k(v.e(b2.getInt(b3)));
                    bVar.m(b2.getInt(b4) != 0);
                    bVar.n(b2.getInt(b5) != 0);
                    bVar.l(b2.getInt(b6) != 0);
                    bVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    bVar.p(b2.getLong(b8));
                    bVar.q(b2.getLong(b9));
                    bVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.b = v.g(b2.getInt(b12));
                    pVar.d = b2.getString(b14);
                    pVar.e = androidx.work.b.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f = androidx.work.b.g(b2.getBlob(i8));
                    int i9 = b17;
                    i2 = i8;
                    pVar.g = b2.getLong(i9);
                    int i10 = b14;
                    int i11 = b18;
                    pVar.h = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.i = b2.getLong(i13);
                    int i14 = b20;
                    pVar.k = b2.getInt(i14);
                    int i15 = b21;
                    pVar.l = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.m = b2.getLong(i16);
                    int i17 = b23;
                    pVar.n = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.o = b2.getLong(i18);
                    int i19 = b25;
                    pVar.p = b2.getLong(i19);
                    int i20 = b26;
                    pVar.q = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.r = v.f(b2.getInt(i21));
                    pVar.j = bVar;
                    arrayList.add(pVar);
                    b4 = i6;
                    b27 = i21;
                    b14 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                hVar.h();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                hVar.h();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = d2;
        }
    }

    public List c() {
        C0.h hVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "required_network_type");
            int b4 = E0.b.b(b2, "requires_charging");
            int b5 = E0.b.b(b2, "requires_device_idle");
            int b6 = E0.b.b(b2, "requires_battery_not_low");
            int b7 = E0.b.b(b2, "requires_storage_not_low");
            int b8 = E0.b.b(b2, "trigger_content_update_delay");
            int b9 = E0.b.b(b2, "trigger_max_content_delay");
            int b10 = E0.b.b(b2, "content_uri_triggers");
            int b11 = E0.b.b(b2, "id");
            int b12 = E0.b.b(b2, "state");
            int b13 = E0.b.b(b2, "worker_class_name");
            int b14 = E0.b.b(b2, "input_merger_class_name");
            int b15 = E0.b.b(b2, "input");
            int b16 = E0.b.b(b2, "output");
            hVar = d2;
            try {
                int b17 = E0.b.b(b2, "initial_delay");
                int b18 = E0.b.b(b2, "interval_duration");
                int b19 = E0.b.b(b2, "flex_duration");
                int b20 = E0.b.b(b2, "run_attempt_count");
                int b21 = E0.b.b(b2, "backoff_policy");
                int b22 = E0.b.b(b2, "backoff_delay_duration");
                int b23 = E0.b.b(b2, "period_start_time");
                int b24 = E0.b.b(b2, "minimum_retention_duration");
                int b25 = E0.b.b(b2, "schedule_requested_at");
                int b26 = E0.b.b(b2, "run_in_foreground");
                int b27 = E0.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    Q0.b bVar = new Q0.b();
                    int i5 = b3;
                    bVar.k(v.e(b2.getInt(b3)));
                    bVar.m(b2.getInt(b4) != 0);
                    bVar.n(b2.getInt(b5) != 0);
                    bVar.l(b2.getInt(b6) != 0);
                    bVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    bVar.p(b2.getLong(b8));
                    bVar.q(b2.getLong(b9));
                    bVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.b = v.g(b2.getInt(b12));
                    pVar.d = b2.getString(b14);
                    pVar.e = androidx.work.b.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f = androidx.work.b.g(b2.getBlob(i8));
                    i2 = i8;
                    int i9 = b17;
                    pVar.g = b2.getLong(i9);
                    int i10 = b15;
                    int i11 = b18;
                    pVar.h = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.i = b2.getLong(i13);
                    int i14 = b20;
                    pVar.k = b2.getInt(i14);
                    int i15 = b21;
                    pVar.l = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.m = b2.getLong(i16);
                    int i17 = b23;
                    pVar.n = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.o = b2.getLong(i18);
                    int i19 = b25;
                    pVar.p = b2.getLong(i19);
                    int i20 = b26;
                    pVar.q = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.r = v.f(b2.getInt(i21));
                    pVar.j = bVar;
                    arrayList.add(pVar);
                    b27 = i21;
                    b4 = i6;
                    b15 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                hVar.h();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                hVar.h();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = d2;
        }
    }

    public int d(Q0.t tVar, String... strArr) {
        this.a.b();
        StringBuilder b2 = E0.e.b();
        b2.append("UPDATE workspec SET state=");
        b2.append("?");
        b2.append(" WHERE id IN (");
        E0.e.a(b2, strArr.length);
        b2.append(")");
        G0.f d2 = this.a.d(b2.toString());
        d2.A(1, v.j(tVar));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                d2.X(i2);
            } else {
                d2.x(i2, str);
            }
            i2++;
        }
        this.a.c();
        try {
            int E = d2.E();
            this.a.r();
            return E;
        } finally {
            this.a.g();
        }
    }

    public List e(String str) {
        C0.h d2 = C0.h.d("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public void f(p pVar) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(pVar);
            this.a.r();
        } finally {
            this.a.g();
        }
    }

    public Q0.t g(String str) {
        C0.h d2 = C0.h.d("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            return b2.moveToFirst() ? v.g(b2.getInt(0)) : null;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public p h(String str) {
        C0.h hVar;
        int b2;
        int b3;
        int b4;
        int b5;
        int b6;
        int b7;
        int b8;
        int b9;
        int b10;
        int b11;
        int b12;
        int b13;
        int b14;
        int b15;
        p pVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b16 = E0.c.b(this.a, d2, false, null);
        try {
            b2 = E0.b.b(b16, "required_network_type");
            b3 = E0.b.b(b16, "requires_charging");
            b4 = E0.b.b(b16, "requires_device_idle");
            b5 = E0.b.b(b16, "requires_battery_not_low");
            b6 = E0.b.b(b16, "requires_storage_not_low");
            b7 = E0.b.b(b16, "trigger_content_update_delay");
            b8 = E0.b.b(b16, "trigger_max_content_delay");
            b9 = E0.b.b(b16, "content_uri_triggers");
            b10 = E0.b.b(b16, "id");
            b11 = E0.b.b(b16, "state");
            b12 = E0.b.b(b16, "worker_class_name");
            b13 = E0.b.b(b16, "input_merger_class_name");
            b14 = E0.b.b(b16, "input");
            b15 = E0.b.b(b16, "output");
            hVar = d2;
        } catch (Throwable th) {
            th = th;
            hVar = d2;
        }
        try {
            int b17 = E0.b.b(b16, "initial_delay");
            int b18 = E0.b.b(b16, "interval_duration");
            int b19 = E0.b.b(b16, "flex_duration");
            int b20 = E0.b.b(b16, "run_attempt_count");
            int b21 = E0.b.b(b16, "backoff_policy");
            int b22 = E0.b.b(b16, "backoff_delay_duration");
            int b23 = E0.b.b(b16, "period_start_time");
            int b24 = E0.b.b(b16, "minimum_retention_duration");
            int b25 = E0.b.b(b16, "schedule_requested_at");
            int b26 = E0.b.b(b16, "run_in_foreground");
            int b27 = E0.b.b(b16, "out_of_quota_policy");
            if (b16.moveToFirst()) {
                String string = b16.getString(b10);
                String string2 = b16.getString(b12);
                Q0.b bVar = new Q0.b();
                bVar.k(v.e(b16.getInt(b2)));
                bVar.m(b16.getInt(b3) != 0);
                bVar.n(b16.getInt(b4) != 0);
                bVar.l(b16.getInt(b5) != 0);
                bVar.o(b16.getInt(b6) != 0);
                bVar.p(b16.getLong(b7));
                bVar.q(b16.getLong(b8));
                bVar.j(v.b(b16.getBlob(b9)));
                p pVar2 = new p(string, string2);
                pVar2.b = v.g(b16.getInt(b11));
                pVar2.d = b16.getString(b13);
                pVar2.e = androidx.work.b.g(b16.getBlob(b14));
                pVar2.f = androidx.work.b.g(b16.getBlob(b15));
                pVar2.g = b16.getLong(b17);
                pVar2.h = b16.getLong(b18);
                pVar2.i = b16.getLong(b19);
                pVar2.k = b16.getInt(b20);
                pVar2.l = v.d(b16.getInt(b21));
                pVar2.m = b16.getLong(b22);
                pVar2.n = b16.getLong(b23);
                pVar2.o = b16.getLong(b24);
                pVar2.p = b16.getLong(b25);
                pVar2.q = b16.getInt(b26) != 0;
                pVar2.r = v.f(b16.getInt(b27));
                pVar2.j = bVar;
                pVar = pVar2;
            } else {
                pVar = null;
            }
            b16.close();
            hVar.h();
            return pVar;
        } catch (Throwable th2) {
            th = th2;
            b16.close();
            hVar.h();
            throw th;
        }
    }

    public List i(String str) {
        C0.h d2 = C0.h.d("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public List j(String str) {
        C0.h d2 = C0.h.d("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(androidx.work.b.g(b2.getBlob(0)));
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public List k(int i2) {
        C0.h hVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        d2.A(1, i2);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "required_network_type");
            int b4 = E0.b.b(b2, "requires_charging");
            int b5 = E0.b.b(b2, "requires_device_idle");
            int b6 = E0.b.b(b2, "requires_battery_not_low");
            int b7 = E0.b.b(b2, "requires_storage_not_low");
            int b8 = E0.b.b(b2, "trigger_content_update_delay");
            int b9 = E0.b.b(b2, "trigger_max_content_delay");
            int b10 = E0.b.b(b2, "content_uri_triggers");
            int b11 = E0.b.b(b2, "id");
            int b12 = E0.b.b(b2, "state");
            int b13 = E0.b.b(b2, "worker_class_name");
            int b14 = E0.b.b(b2, "input_merger_class_name");
            int b15 = E0.b.b(b2, "input");
            int b16 = E0.b.b(b2, "output");
            hVar = d2;
            try {
                int b17 = E0.b.b(b2, "initial_delay");
                int b18 = E0.b.b(b2, "interval_duration");
                int b19 = E0.b.b(b2, "flex_duration");
                int b20 = E0.b.b(b2, "run_attempt_count");
                int b21 = E0.b.b(b2, "backoff_policy");
                int b22 = E0.b.b(b2, "backoff_delay_duration");
                int b23 = E0.b.b(b2, "period_start_time");
                int b24 = E0.b.b(b2, "minimum_retention_duration");
                int b25 = E0.b.b(b2, "schedule_requested_at");
                int b26 = E0.b.b(b2, "run_in_foreground");
                int b27 = E0.b.b(b2, "out_of_quota_policy");
                int i3 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i4 = b11;
                    String string2 = b2.getString(b13);
                    int i5 = b13;
                    Q0.b bVar = new Q0.b();
                    int i6 = b3;
                    bVar.k(v.e(b2.getInt(b3)));
                    bVar.m(b2.getInt(b4) != 0);
                    bVar.n(b2.getInt(b5) != 0);
                    bVar.l(b2.getInt(b6) != 0);
                    bVar.o(b2.getInt(b7) != 0);
                    int i7 = b4;
                    int i8 = b5;
                    bVar.p(b2.getLong(b8));
                    bVar.q(b2.getLong(b9));
                    bVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.b = v.g(b2.getInt(b12));
                    pVar.d = b2.getString(b14);
                    pVar.e = androidx.work.b.g(b2.getBlob(b15));
                    int i9 = i3;
                    pVar.f = androidx.work.b.g(b2.getBlob(i9));
                    i3 = i9;
                    int i10 = b17;
                    pVar.g = b2.getLong(i10);
                    int i11 = b14;
                    int i12 = b18;
                    pVar.h = b2.getLong(i12);
                    int i13 = b6;
                    int i14 = b19;
                    pVar.i = b2.getLong(i14);
                    int i15 = b20;
                    pVar.k = b2.getInt(i15);
                    int i16 = b21;
                    pVar.l = v.d(b2.getInt(i16));
                    b19 = i14;
                    int i17 = b22;
                    pVar.m = b2.getLong(i17);
                    int i18 = b23;
                    pVar.n = b2.getLong(i18);
                    b23 = i18;
                    int i19 = b24;
                    pVar.o = b2.getLong(i19);
                    int i20 = b25;
                    pVar.p = b2.getLong(i20);
                    int i21 = b26;
                    pVar.q = b2.getInt(i21) != 0;
                    int i22 = b27;
                    pVar.r = v.f(b2.getInt(i22));
                    pVar.j = bVar;
                    arrayList.add(pVar);
                    b27 = i22;
                    b4 = i7;
                    b14 = i11;
                    b17 = i10;
                    b18 = i12;
                    b20 = i15;
                    b25 = i20;
                    b11 = i4;
                    b13 = i5;
                    b3 = i6;
                    b26 = i21;
                    b24 = i19;
                    b5 = i8;
                    b22 = i17;
                    b6 = i13;
                    b21 = i16;
                }
                b2.close();
                hVar.h();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                hVar.h();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = d2;
        }
    }

    public int l() {
        this.a.b();
        G0.f a2 = this.i.a();
        this.a.c();
        try {
            int E = a2.E();
            this.a.r();
            return E;
        } finally {
            this.a.g();
            this.i.f(a2);
        }
    }

    public int m(String str, long j) {
        this.a.b();
        G0.f a2 = this.h.a();
        a2.A(1, j);
        if (str == null) {
            a2.X(2);
        } else {
            a2.x(2, str);
        }
        this.a.c();
        try {
            int E = a2.E();
            this.a.r();
            return E;
        } finally {
            this.a.g();
            this.h.f(a2);
        }
    }

    public List n(String str) {
        C0.h d2 = C0.h.d("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            d2.X(1);
        } else {
            d2.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "id");
            int b4 = E0.b.b(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                p.b bVar = new p.b();
                bVar.a = b2.getString(b3);
                bVar.b = v.g(b2.getInt(b4));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public List o(int i2) {
        C0.h hVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        d2.A(1, i2);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "required_network_type");
            int b4 = E0.b.b(b2, "requires_charging");
            int b5 = E0.b.b(b2, "requires_device_idle");
            int b6 = E0.b.b(b2, "requires_battery_not_low");
            int b7 = E0.b.b(b2, "requires_storage_not_low");
            int b8 = E0.b.b(b2, "trigger_content_update_delay");
            int b9 = E0.b.b(b2, "trigger_max_content_delay");
            int b10 = E0.b.b(b2, "content_uri_triggers");
            int b11 = E0.b.b(b2, "id");
            int b12 = E0.b.b(b2, "state");
            int b13 = E0.b.b(b2, "worker_class_name");
            int b14 = E0.b.b(b2, "input_merger_class_name");
            int b15 = E0.b.b(b2, "input");
            int b16 = E0.b.b(b2, "output");
            hVar = d2;
            try {
                int b17 = E0.b.b(b2, "initial_delay");
                int b18 = E0.b.b(b2, "interval_duration");
                int b19 = E0.b.b(b2, "flex_duration");
                int b20 = E0.b.b(b2, "run_attempt_count");
                int b21 = E0.b.b(b2, "backoff_policy");
                int b22 = E0.b.b(b2, "backoff_delay_duration");
                int b23 = E0.b.b(b2, "period_start_time");
                int b24 = E0.b.b(b2, "minimum_retention_duration");
                int b25 = E0.b.b(b2, "schedule_requested_at");
                int b26 = E0.b.b(b2, "run_in_foreground");
                int b27 = E0.b.b(b2, "out_of_quota_policy");
                int i3 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i4 = b11;
                    String string2 = b2.getString(b13);
                    int i5 = b13;
                    Q0.b bVar = new Q0.b();
                    int i6 = b3;
                    bVar.k(v.e(b2.getInt(b3)));
                    bVar.m(b2.getInt(b4) != 0);
                    bVar.n(b2.getInt(b5) != 0);
                    bVar.l(b2.getInt(b6) != 0);
                    bVar.o(b2.getInt(b7) != 0);
                    int i7 = b4;
                    int i8 = b5;
                    bVar.p(b2.getLong(b8));
                    bVar.q(b2.getLong(b9));
                    bVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.b = v.g(b2.getInt(b12));
                    pVar.d = b2.getString(b14);
                    pVar.e = androidx.work.b.g(b2.getBlob(b15));
                    int i9 = i3;
                    pVar.f = androidx.work.b.g(b2.getBlob(i9));
                    i3 = i9;
                    int i10 = b17;
                    pVar.g = b2.getLong(i10);
                    int i11 = b14;
                    int i12 = b18;
                    pVar.h = b2.getLong(i12);
                    int i13 = b6;
                    int i14 = b19;
                    pVar.i = b2.getLong(i14);
                    int i15 = b20;
                    pVar.k = b2.getInt(i15);
                    int i16 = b21;
                    pVar.l = v.d(b2.getInt(i16));
                    b19 = i14;
                    int i17 = b22;
                    pVar.m = b2.getLong(i17);
                    int i18 = b23;
                    pVar.n = b2.getLong(i18);
                    b23 = i18;
                    int i19 = b24;
                    pVar.o = b2.getLong(i19);
                    int i20 = b25;
                    pVar.p = b2.getLong(i20);
                    int i21 = b26;
                    pVar.q = b2.getInt(i21) != 0;
                    int i22 = b27;
                    pVar.r = v.f(b2.getInt(i22));
                    pVar.j = bVar;
                    arrayList.add(pVar);
                    b27 = i22;
                    b4 = i7;
                    b14 = i11;
                    b17 = i10;
                    b18 = i12;
                    b20 = i15;
                    b25 = i20;
                    b11 = i4;
                    b13 = i5;
                    b3 = i6;
                    b26 = i21;
                    b24 = i19;
                    b5 = i8;
                    b22 = i17;
                    b6 = i13;
                    b21 = i16;
                }
                b2.close();
                hVar.h();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                hVar.h();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = d2;
        }
    }

    public void p(String str, androidx.work.b bVar) {
        this.a.b();
        G0.f a2 = this.d.a();
        byte[] n = androidx.work.b.n(bVar);
        if (n == null) {
            a2.X(1);
        } else {
            a2.S(1, n);
        }
        if (str == null) {
            a2.X(2);
        } else {
            a2.x(2, str);
        }
        this.a.c();
        try {
            a2.E();
            this.a.r();
        } finally {
            this.a.g();
            this.d.f(a2);
        }
    }

    public List q() {
        C0.h hVar;
        C0.h d2 = C0.h.d("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            int b3 = E0.b.b(b2, "required_network_type");
            int b4 = E0.b.b(b2, "requires_charging");
            int b5 = E0.b.b(b2, "requires_device_idle");
            int b6 = E0.b.b(b2, "requires_battery_not_low");
            int b7 = E0.b.b(b2, "requires_storage_not_low");
            int b8 = E0.b.b(b2, "trigger_content_update_delay");
            int b9 = E0.b.b(b2, "trigger_max_content_delay");
            int b10 = E0.b.b(b2, "content_uri_triggers");
            int b11 = E0.b.b(b2, "id");
            int b12 = E0.b.b(b2, "state");
            int b13 = E0.b.b(b2, "worker_class_name");
            int b14 = E0.b.b(b2, "input_merger_class_name");
            int b15 = E0.b.b(b2, "input");
            int b16 = E0.b.b(b2, "output");
            hVar = d2;
            try {
                int b17 = E0.b.b(b2, "initial_delay");
                int b18 = E0.b.b(b2, "interval_duration");
                int b19 = E0.b.b(b2, "flex_duration");
                int b20 = E0.b.b(b2, "run_attempt_count");
                int b21 = E0.b.b(b2, "backoff_policy");
                int b22 = E0.b.b(b2, "backoff_delay_duration");
                int b23 = E0.b.b(b2, "period_start_time");
                int b24 = E0.b.b(b2, "minimum_retention_duration");
                int b25 = E0.b.b(b2, "schedule_requested_at");
                int b26 = E0.b.b(b2, "run_in_foreground");
                int b27 = E0.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    Q0.b bVar = new Q0.b();
                    int i5 = b3;
                    bVar.k(v.e(b2.getInt(b3)));
                    bVar.m(b2.getInt(b4) != 0);
                    bVar.n(b2.getInt(b5) != 0);
                    bVar.l(b2.getInt(b6) != 0);
                    bVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    bVar.p(b2.getLong(b8));
                    bVar.q(b2.getLong(b9));
                    bVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.b = v.g(b2.getInt(b12));
                    pVar.d = b2.getString(b14);
                    pVar.e = androidx.work.b.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f = androidx.work.b.g(b2.getBlob(i8));
                    i2 = i8;
                    int i9 = b17;
                    pVar.g = b2.getLong(i9);
                    int i10 = b15;
                    int i11 = b18;
                    pVar.h = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.i = b2.getLong(i13);
                    int i14 = b20;
                    pVar.k = b2.getInt(i14);
                    int i15 = b21;
                    pVar.l = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.m = b2.getLong(i16);
                    int i17 = b23;
                    pVar.n = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.o = b2.getLong(i18);
                    int i19 = b25;
                    pVar.p = b2.getLong(i19);
                    int i20 = b26;
                    pVar.q = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.r = v.f(b2.getInt(i21));
                    pVar.j = bVar;
                    arrayList.add(pVar);
                    b27 = i21;
                    b4 = i6;
                    b15 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                hVar.h();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                hVar.h();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = d2;
        }
    }

    public boolean r() {
        boolean z = false;
        C0.h d2 = C0.h.d("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d2, false, null);
        try {
            if (b2.moveToFirst()) {
                if (b2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            b2.close();
            d2.h();
        }
    }

    public int s(String str) {
        this.a.b();
        G0.f a2 = this.g.a();
        if (str == null) {
            a2.X(1);
        } else {
            a2.x(1, str);
        }
        this.a.c();
        try {
            int E = a2.E();
            this.a.r();
            return E;
        } finally {
            this.a.g();
            this.g.f(a2);
        }
    }

    public int t(String str) {
        this.a.b();
        G0.f a2 = this.f.a();
        if (str == null) {
            a2.X(1);
        } else {
            a2.x(1, str);
        }
        this.a.c();
        try {
            int E = a2.E();
            this.a.r();
            return E;
        } finally {
            this.a.g();
            this.f.f(a2);
        }
    }

    public void u(String str, long j) {
        this.a.b();
        G0.f a2 = this.e.a();
        a2.A(1, j);
        if (str == null) {
            a2.X(2);
        } else {
            a2.x(2, str);
        }
        this.a.c();
        try {
            a2.E();
            this.a.r();
        } finally {
            this.a.g();
            this.e.f(a2);
        }
    }
}
