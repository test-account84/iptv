package Z0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class u implements t {
    public final C0.e a;
    public final C0.b b;

    public class a extends C0.b {
        public a(C0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(G0.f fVar, s sVar) {
            String str = sVar.a;
            if (str == null) {
                fVar.X(1);
            } else {
                fVar.x(1, str);
            }
            String str2 = sVar.b;
            if (str2 == null) {
                fVar.X(2);
            } else {
                fVar.x(2, str2);
            }
        }
    }

    public u(C0.e eVar) {
        this.a = eVar;
        this.b = new a(eVar);
    }

    public List a(String str) {
        C0.h d = C0.h.d("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            d.X(1);
        } else {
            d.x(1, str);
        }
        this.a.b();
        Cursor b = E0.c.b(this.a, d, false, null);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            return arrayList;
        } finally {
            b.close();
            d.h();
        }
    }

    public void b(s sVar) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(sVar);
            this.a.r();
        } finally {
            this.a.g();
        }
    }
}
