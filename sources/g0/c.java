package G0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface c extends Closeable {

    public static class b {
        public final Context a;
        public final String b;
        public final a c;
        public final boolean d;

        public static class a {
            public Context a;
            public String b;
            public a c;
            public boolean d;

            public a(Context context) {
                this.a = context;
            }

            public b a() {
                if (this.c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.d && TextUtils.isEmpty(this.b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.a, this.b, this.c, this.d);
            }

            public a b(a aVar) {
                this.c = aVar;
                return this;
            }

            public a c(String str) {
                this.b = str;
                return this;
            }

            public a d(boolean z) {
                this.d = z;
                return this;
            }
        }

        public b(Context context, String str, a aVar, boolean z) {
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    public interface c {
        c a(b bVar);
    }

    void close();

    String getDatabaseName();

    G0.b getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    public static abstract class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                Log.w("SupportSQLite", "delete failed: ", e);
            }
        }

        public void c(G0.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.getPath());
            if (!bVar.isOpen()) {
                a(bVar.getPath());
                return;
            }
            List list = null;
            try {
                try {
                    list = bVar.B();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        a((String) ((Pair) it.next()).second);
                    }
                } else {
                    a(bVar.getPath());
                }
            }
        }

        public abstract void d(G0.b bVar);

        public abstract void e(G0.b bVar, int i, int i2);

        public abstract void g(G0.b bVar, int i, int i2);

        public void b(G0.b bVar) {
        }

        public void f(G0.b bVar) {
        }
    }
}
