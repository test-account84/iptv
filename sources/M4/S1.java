package M4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s1 extends G1 {
    public final r1 c;
    public boolean d;

    public s1(l2 l2Var) {
        super(l2Var);
        Context c = this.a.c();
        this.a.z();
        this.c = new r1(this, c, "google_app_measurement_local.db");
    }

    public final boolean n() {
        return false;
    }

    public final SQLiteDatabase o() {
        if (this.d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.d = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x023d A[PHI: r9 r15
      0x023d: PHI (r9v4 int) = (r9v1 int), (r9v2 int), (r9v1 int) binds: [B:58:0x0258, B:49:0x023b, B:23:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x023d: PHI (r15v7 android.database.sqlite.SQLiteDatabase) = 
      (r15v4 android.database.sqlite.SQLiteDatabase)
      (r15v5 android.database.sqlite.SQLiteDatabase)
      (r15v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:58:0x0258, B:49:0x023b, B:23:0x0229] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x025b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x025b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List p(int r23) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.s1.p(int):java.util.List");
    }

    public final void q() {
        int delete;
        h();
        try {
            SQLiteDatabase o = o();
            if (o == null || (delete = o.delete("messages", (String) null, (String[]) null)) <= 0) {
                return;
            }
            this.a.d().v().b("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e) {
            this.a.d().r().b("Error resetting local analytics data. error", e);
        }
    }

    public final boolean r() {
        return x(3, new byte[0]);
    }

    public final boolean s() {
        Context c = this.a.c();
        this.a.z();
        return c.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[PHI: r4
      0x0069: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:44:0x007c, B:39:0x0067, B:23:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean t() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.h()
            boolean r1 = r10.d
            r2 = 0
            if (r1 == 0) goto Lb
            return r2
        Lb:
            boolean r1 = r10.s()
            if (r1 == 0) goto L97
            r1 = 5
            r3 = 0
            r4 = 5
        L14:
            if (r3 >= r1) goto L88
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.o()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            if (r5 != 0) goto L27
            r10.d = r6     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            return r2
        L21:
            r0 = move-exception
            goto L82
        L23:
            r7 = move-exception
            goto L44
        L25:
            r7 = move-exception
            goto L6d
        L27:
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            r9 = 3
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String[] r9 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.delete(r7, r8, r9)     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.endTransaction()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.close()
            return r6
        L44:
            if (r5 == 0) goto L4f
            boolean r8 = r5.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r8 == 0) goto L4f
            r5.endTransaction()     // Catch: java.lang.Throwable -> L21
        L4f:
            M4.l2 r8 = r10.a     // Catch: java.lang.Throwable -> L21
            M4.z1 r8 = r8.d()     // Catch: java.lang.Throwable -> L21
            M4.x1 r8 = r8.r()     // Catch: java.lang.Throwable -> L21
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L21
            r10.d = r6     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L7f
            goto L69
        L61:
            long r6 = (long) r4     // Catch: java.lang.Throwable -> L21
            android.os.SystemClock.sleep(r6)     // Catch: java.lang.Throwable -> L21
            int r4 = r4 + 20
            if (r5 == 0) goto L7f
        L69:
            r5.close()
            goto L7f
        L6d:
            M4.l2 r8 = r10.a     // Catch: java.lang.Throwable -> L21
            M4.z1 r8 = r8.d()     // Catch: java.lang.Throwable -> L21
            M4.x1 r8 = r8.r()     // Catch: java.lang.Throwable -> L21
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L21
            r10.d = r6     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L7f
            goto L69
        L7f:
            int r3 = r3 + 1
            goto L14
        L82:
            if (r5 == 0) goto L87
            r5.close()
        L87:
            throw r0
        L88:
            M4.l2 r0 = r10.a
            M4.z1 r0 = r0.d()
            M4.x1 r0 = r0.w()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.s1.t():boolean");
    }

    public final boolean u(d dVar) {
        byte[] e0 = this.a.N().e0(dVar);
        if (e0.length <= 131072) {
            return x(2, e0);
        }
        this.a.d().t().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean v(v vVar) {
        Parcel obtain = Parcel.obtain();
        w.a(vVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return x(0, marshall);
        }
        this.a.d().t().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean w(V4 v4) {
        Parcel obtain = Parcel.obtain();
        W4.a(v4, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return x(1, marshall);
        }
        this.a.d().t().a("User property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f4 A[PHI: r8
      0x00f4: PHI (r8v5 android.database.Cursor) = (r8v1 android.database.Cursor), (r8v6 android.database.Cursor) binds: [B:65:0x0125, B:28:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0135  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean x(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.s1.x(int, byte[]):boolean");
    }
}
