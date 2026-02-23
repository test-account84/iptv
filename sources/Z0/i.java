package Z0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i implements h {
    public final C0.e a;
    public final C0.b b;
    public final C0.k c;

    public class a extends C0.b {
        public a(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(G0.f fVar, g gVar) {
            String str = gVar.a;
            if (str == null) {
                fVar.X(1);
            } else {
                fVar.x(1, str);
            }
            fVar.A(2, gVar.b);
        }
    }

    public class b extends C0.k {
        public b(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(C0.e eVar) {
        this.a = eVar;
        this.b = new a(eVar);
        this.c = new b(eVar);
    }

    public g a(String str) {
        C0.h d = C0.h.d("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            d.X(1);
        } else {
            d.x(1, str);
        }
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d, false, null);
        try {
            return b2.moveToFirst() ? new g(b2.getString(E0.b.b(b2, "work_spec_id")), b2.getInt(E0.b.b(b2, "system_id"))) : null;
        } finally {
            b2.close();
            d.h();
        }
    }

    public List b() {
        C0.h d = C0.h.d("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.a.b();
        Cursor b2 = E0.c.b(this.a, d, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            d.h();
        }
    }

    public void c(g gVar) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(gVar);
            this.a.r();
        } finally {
            this.a.g();
        }
    }

    public void d(String str) {
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
}
