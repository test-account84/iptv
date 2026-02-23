package z3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import d4.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z3.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements I {
    public static final String f = p(3, 4);
    public static final String[] g = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};
    public final String a;
    public final String b;
    public final T2.b c;
    public final Object d;
    public boolean e;

    public static final class b implements e {
        public final Cursor a;

        public b(Cursor cursor) {
            this.a = cursor;
        }

        public c J() {
            return a.i(this.a);
        }

        public boolean W(int i) {
            return this.a.moveToPosition(i);
        }

        public /* synthetic */ boolean a0() {
            return d.a(this);
        }

        public void close() {
            this.a.close();
        }

        public int getPosition() {
            return this.a.getPosition();
        }

        public /* synthetic */ b(Cursor cursor, a aVar) {
            this(cursor);
        }
    }

    public a(T2.b bVar) {
        this(bVar, "");
    }

    public static /* synthetic */ c i(Cursor cursor) {
        return n(cursor);
    }

    public static List j(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : k0.i1(str, ",")) {
            String[] i1 = k0.i1(str2, "\\.");
            d4.a.g(i1.length == 3);
            arrayList.add(new H(Integer.parseInt(i1[0]), Integer.parseInt(i1[1]), Integer.parseInt(i1[2])));
        }
        return arrayList;
    }

    public static String k(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            H h = (H) list.get(i);
            sb.append(h.a);
            sb.append('.');
            sb.append(h.c);
            sb.append('.');
            sb.append(h.d);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static c n(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        w.b f2 = new w.b((String) d4.a.e(cursor.getString(0)), Uri.parse((String) d4.a.e(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        w a2 = f2.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        v vVar = new v();
        vVar.a = cursor.getLong(13);
        vVar.b = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new c(a2, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, vVar);
    }

    public static c o(Cursor cursor) {
        w a2 = new w.b((String) d4.a.e(cursor.getString(0)), Uri.parse((String) d4.a.e(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        v vVar = new v();
        vVar.a = cursor.getLong(13);
        vVar.b = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new c(a2, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, vVar);
    }

    public static String p(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state");
        sb.append(" IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static String q(String str) {
        return "dash".equals(str) ? "application/dash+xml" : "hls".equals(str) ? "application/x-mpegURL" : "ss".equals(str) ? "application/vnd.ms-sstr+xml" : "video/x-unknown";
    }

    public void a(String str, int i) {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.c.getWritableDatabase().update(this.b, contentValues, f + " AND id = ?", new String[]{str});
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public void b(String str) {
        l();
        try {
            this.c.getWritableDatabase().delete(this.b, "id = ?", new String[]{str});
        } catch (SQLiteException e) {
            throw new T2.a(e);
        }
    }

    public void c(int i) {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.c.getWritableDatabase().update(this.b, contentValues, f, (String[]) null);
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public e d(int... iArr) {
        l();
        return new b(m(p(iArr), null), null);
    }

    public void e(c cVar) {
        l();
        try {
            s(cVar, this.c.getWritableDatabase());
        } catch (SQLiteException e) {
            throw new T2.a(e);
        }
    }

    public void f() {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", 5);
            contentValues.put("failure_reason", 0);
            this.c.getWritableDatabase().update(this.b, contentValues, (String) null, (String[]) null);
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public void g() {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", 0);
            this.c.getWritableDatabase().update(this.b, contentValues, "state = 2", (String[]) null);
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public c h(String str) {
        l();
        try {
            Cursor m = m("id = ?", new String[]{str});
            try {
                if (m.getCount() == 0) {
                    m.close();
                    return null;
                }
                m.moveToNext();
                c n = n(m);
                m.close();
                return n;
            } finally {
            }
        } catch (SQLiteException e) {
            throw new T2.a(e);
        }
    }

    public final void l() {
        synchronized (this.d) {
            if (this.e) {
                return;
            }
            try {
                int b2 = T2.e.b(this.c.getReadableDatabase(), 0, this.a);
                if (b2 != 3) {
                    SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        T2.e.d(writableDatabase, 0, this.a, 3);
                        List r = b2 == 2 ? r(writableDatabase) : new ArrayList();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.b);
                        writableDatabase.execSQL("CREATE TABLE " + this.b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator it = r.iterator();
                        while (it.hasNext()) {
                            s((c) it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.e = true;
            } catch (SQLException e) {
                throw new T2.a(e);
            }
        }
    }

    public final Cursor m(String str, String[] strArr) {
        try {
            return this.c.getReadableDatabase().query(this.b, g, str, strArr, (String) null, (String) null, "start_time_ms ASC");
        } catch (SQLiteException e) {
            throw new T2.a(e);
        }
    }

    public final List r(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!k0.o1(sQLiteDatabase, this.b)) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query(this.b, new String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(o(query));
            } finally {
            }
        }
        query.close();
        return arrayList;
    }

    public final void s(c cVar, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = cVar.a.f;
        if (bArr == null) {
            bArr = k0.f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.a.a);
        contentValues.put("mime_type", cVar.a.d);
        contentValues.put("uri", cVar.a.c.toString());
        contentValues.put("stream_keys", k(cVar.a.e));
        contentValues.put("custom_cache_key", cVar.a.g);
        contentValues.put("data", cVar.a.h);
        contentValues.put("state", Integer.valueOf(cVar.b));
        contentValues.put("start_time_ms", Long.valueOf(cVar.c));
        contentValues.put("update_time_ms", Long.valueOf(cVar.d));
        contentValues.put("content_length", Long.valueOf(cVar.e));
        contentValues.put("stop_reason", Integer.valueOf(cVar.f));
        contentValues.put("failure_reason", Integer.valueOf(cVar.g));
        contentValues.put("percent_downloaded", Float.valueOf(cVar.b()));
        contentValues.put("bytes_downloaded", Long.valueOf(cVar.a()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.b, (String) null, contentValues);
    }

    public a(T2.b bVar, String str) {
        this.a = str;
        this.c = bVar;
        this.b = "ExoPlayerDownloads" + str;
        this.d = new Object();
    }
}
