package C0;

import G0.c;
import android.database.Cursor;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends c.a {
    public C0.a b;
    public final a c;
    public final String d;
    public final String e;

    public static abstract class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public abstract void a(G0.b bVar);

        public abstract void b(G0.b bVar);

        public abstract void c(G0.b bVar);

        public abstract void d(G0.b bVar);

        public abstract void e(G0.b bVar);

        public abstract void f(G0.b bVar);

        public abstract b g(G0.b bVar);
    }

    public static class b {
        public final boolean a;
        public final String b;

        public b(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    public g(C0.a aVar, a aVar2, String str, String str2) {
        super(aVar2.a);
        this.b = aVar;
        this.c = aVar2;
        this.d = str;
        this.e = str2;
    }

    public static boolean j(G0.b bVar) {
        Cursor U = bVar.U("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (U.moveToFirst()) {
                if (U.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            U.close();
        }
    }

    public static boolean k(G0.b bVar) {
        Cursor U = bVar.U("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (U.moveToFirst()) {
                if (U.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            U.close();
        }
    }

    public void b(G0.b bVar) {
        super.b(bVar);
    }

    public void d(G0.b bVar) {
        boolean j = j(bVar);
        this.c.a(bVar);
        if (!j) {
            b g = this.c.g(bVar);
            if (!g.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g.b);
            }
        }
        l(bVar);
        this.c.c(bVar);
    }

    public void e(G0.b bVar, int i, int i2) {
        g(bVar, i, i2);
    }

    public void f(G0.b bVar) {
        super.f(bVar);
        h(bVar);
        this.c.d(bVar);
        this.b = null;
    }

    public void g(G0.b bVar, int i, int i2) {
        List c;
        C0.a aVar = this.b;
        if (aVar == null || (c = aVar.d.c(i, i2)) == null) {
            C0.a aVar2 = this.b;
            if (aVar2 != null && !aVar2.a(i, i2)) {
                this.c.b(bVar);
                this.c.a(bVar);
                return;
            }
            throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.c.f(bVar);
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((D0.a) it.next()).a(bVar);
        }
        b g = this.c.g(bVar);
        if (g.a) {
            this.c.e(bVar);
            l(bVar);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + g.b);
        }
    }

    public final void h(G0.b bVar) {
        if (!k(bVar)) {
            b g = this.c.g(bVar);
            if (g.a) {
                this.c.e(bVar);
                l(bVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g.b);
            }
        }
        Cursor D = bVar.D(new G0.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = D.moveToFirst() ? D.getString(0) : null;
            D.close();
            if (!this.d.equals(string) && !this.e.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th) {
            D.close();
            throw th;
        }
    }

    public final void i(G0.b bVar) {
        bVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void l(G0.b bVar) {
        i(bVar);
        bVar.C(f.a(this.d));
    }
}
