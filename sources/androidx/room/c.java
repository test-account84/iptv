package androidx.room;

import C0.e;
import G0.f;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public static final String[] m = {"UPDATE", "DELETE", "INSERT"};
    public final String[] b;
    public Map c;
    public final e d;
    public volatile f g;
    public b h;
    public final C0.c i;
    public androidx.room.d k;
    public AtomicBoolean e = new AtomicBoolean(false);
    public volatile boolean f = false;
    public final m.b j = new m.b();
    public Runnable l = new a();
    public final HashMap a = new HashMap();

    public class a implements Runnable {
        public a() {
        }

        public final Set a() {
            HashSet hashSet = new HashSet();
            Cursor p = c.this.d.p(new G0.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (p.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(p.getInt(0)));
                } catch (Throwable th) {
                    p.close();
                    throw th;
                }
            }
            p.close();
            if (!hashSet.isEmpty()) {
                c.this.g.E();
            }
            return hashSet;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00a0 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                androidx.room.c r0 = androidx.room.c.this
                C0.e r0 = r0.d
                java.util.concurrent.locks.Lock r0 = r0.h()
                r1 = 0
                r0.lock()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                androidx.room.c r2 = androidx.room.c.this     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                boolean r2 = r2.c()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                if (r2 != 0) goto L18
                r0.unlock()
                return
            L18:
                androidx.room.c r2 = androidx.room.c.this     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.e     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                r3 = 1
                r4 = 0
                boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                if (r2 != 0) goto L28
                r0.unlock()
                return
            L28:
                androidx.room.c r2 = androidx.room.c.this     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                C0.e r2 = r2.d     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                boolean r2 = r2.k()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                if (r2 == 0) goto L36
                r0.unlock()
                return
            L36:
                androidx.room.c r2 = androidx.room.c.this     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                C0.e r2 = r2.d     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                boolean r3 = r2.g     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                if (r3 == 0) goto L5f
                G0.c r2 = r2.i()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                G0.b r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                r2.u()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                java.util.Set r1 = r5.a()     // Catch: java.lang.Throwable -> L5a
                r2.G()     // Catch: java.lang.Throwable -> L5a
                r2.I()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                goto L63
            L54:
                r1 = move-exception
                goto La1
            L56:
                r2 = move-exception
                goto L67
            L58:
                r2 = move-exception
                goto L67
            L5a:
                r3 = move-exception
                r2.I()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
                throw r3     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
            L5f:
                java.util.Set r1 = r5.a()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56 java.lang.IllegalStateException -> L58
            L63:
                r0.unlock()
                goto L6f
            L67:
                java.lang.String r3 = "ROOM"
                java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L54
                goto L63
            L6f:
                if (r1 == 0) goto La0
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto La0
                androidx.room.c r0 = androidx.room.c.this
                m.b r0 = r0.j
                monitor-enter(r0)
                androidx.room.c r2 = androidx.room.c.this     // Catch: java.lang.Throwable -> L9a
                m.b r2 = r2.j     // Catch: java.lang.Throwable -> L9a
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L9a
            L84:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L9a
                if (r3 == 0) goto L9c
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L9a
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L9a
                java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L9a
                androidx.room.c$d r3 = (androidx.room.c.d) r3     // Catch: java.lang.Throwable -> L9a
                r3.a(r1)     // Catch: java.lang.Throwable -> L9a
                goto L84
            L9a:
                r1 = move-exception
                goto L9e
            L9c:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9a
                goto La0
            L9e:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9a
                throw r1
            La0:
                return
            La1:
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.c.a.run():void");
        }
    }

    public static class b {
        public final long[] a;
        public final boolean[] b;
        public final int[] c;
        public boolean d;
        public boolean e;

        public b(int i) {
            long[] jArr = new long[i];
            this.a = jArr;
            boolean[] zArr = new boolean[i];
            this.b = zArr;
            this.c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public int[] a() {
            synchronized (this) {
                try {
                    if (this.d && !this.e) {
                        int length = this.a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i >= length) {
                                this.e = true;
                                this.d = false;
                                return this.c;
                            }
                            boolean z = this.a[i] > 0;
                            boolean[] zArr = this.b;
                            if (z != zArr[i]) {
                                int[] iArr = this.c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.c[i] = 0;
                            }
                            zArr[i] = z;
                            i++;
                        }
                    }
                    return null;
                } finally {
                }
            }
        }

        public boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            z = true;
                            this.d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public boolean c(int... iArr) {
            boolean z;
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            z = true;
                            this.d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public void d() {
            synchronized (this) {
                this.e = false;
            }
        }
    }

    public static abstract class c {
        public final String[] a;

        public c(String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract boolean a();

        public abstract void b(Set set);
    }

    public static class d {
        public final int[] a;
        public final String[] b;
        public final c c;
        public final Set d;

        public d(c cVar, int[] iArr, String[] strArr) {
            Set set;
            this.c = cVar;
            this.a = iArr;
            this.b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.d = set;
        }

        public void a(Set set) {
            int length = this.a.length;
            Set set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.a[i]))) {
                    if (length == 1) {
                        set2 = this.d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.b[i]);
                    }
                }
            }
            if (set2 != null) {
                this.c.b(set2);
            }
        }

        public void b(String[] strArr) {
            Set set = null;
            if (this.b.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (strArr[i].equalsIgnoreCase(this.b[0])) {
                        set = this.d;
                        break;
                    }
                    i++;
                }
            } else {
                Set hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.b;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String str2 = strArr2[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.c.b(set);
            }
        }
    }

    public c(e eVar, Map map, Map map2, String... strArr) {
        this.d = eVar;
        this.h = new b(strArr.length);
        this.c = map2;
        this.i = new C0.c(eVar);
        int length = strArr.length;
        this.b = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.a.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) map.get(strArr[i]);
            if (str2 != null) {
                this.b[i] = str2.toLowerCase(locale);
            } else {
                this.b[i] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap hashMap = this.a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    public static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    public void a(c cVar) {
        d dVar;
        String[] h = h(cVar.a);
        int[] iArr = new int[h.length];
        int length = h.length;
        for (int i = 0; i < length; i++) {
            Integer num = (Integer) this.a.get(h[i].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + h[i]);
            }
            iArr[i] = num.intValue();
        }
        d dVar2 = new d(cVar, iArr, h);
        synchronized (this.j) {
            dVar = (d) this.j.i(cVar, dVar2);
        }
        if (dVar == null && this.h.b(iArr)) {
            l();
        }
    }

    public boolean c() {
        if (!this.d.o()) {
            return false;
        }
        if (!this.f) {
            this.d.i().getWritableDatabase();
        }
        if (this.f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void d(G0.b bVar) {
        synchronized (this) {
            try {
                if (this.f) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                    return;
                }
                bVar.C("PRAGMA temp_store = MEMORY;");
                bVar.C("PRAGMA recursive_triggers='ON';");
                bVar.C("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                m(bVar);
                this.g = bVar.Q("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                this.f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(String... strArr) {
        synchronized (this.j) {
            try {
                Iterator it = this.j.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!((c) entry.getKey()).a()) {
                        ((d) entry.getValue()).b(strArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        if (this.e.compareAndSet(false, true)) {
            this.d.j().execute(this.l);
        }
    }

    public void g(c cVar) {
        d dVar;
        synchronized (this.j) {
            dVar = (d) this.j.j(cVar);
        }
        if (dVar == null || !this.h.c(dVar.a)) {
            return;
        }
        l();
    }

    public final String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                hashSet.addAll((Collection) this.c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void i(Context context, String str) {
        this.k = new androidx.room.d(context, str, this, this.d.j());
    }

    public final void j(G0.b bVar, int i) {
        bVar.C("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.C(sb.toString());
        }
    }

    public final void k(G0.b bVar, int i) {
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, str2);
            bVar.C(sb.toString());
        }
    }

    public void l() {
        if (this.d.o()) {
            m(this.d.i().getWritableDatabase());
        }
    }

    public void m(G0.b bVar) {
        if (bVar.Z()) {
            return;
        }
        while (true) {
            try {
                Lock h = this.d.h();
                h.lock();
                try {
                    int[] a2 = this.h.a();
                    if (a2 == null) {
                        return;
                    }
                    int length = a2.length;
                    bVar.u();
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = a2[i];
                            if (i2 == 1) {
                                j(bVar, i);
                            } else if (i2 == 2) {
                                k(bVar, i);
                            }
                        } finally {
                        }
                    }
                    bVar.G();
                    bVar.I();
                    this.h.d();
                } finally {
                    h.unlock();
                }
            } catch (IllegalStateException | SQLiteException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }
}
