package M4;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[Catch: SQLiteException -> 0x009e, TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:11:0x0040, B:14:0x0066, B:16:0x0074, B:18:0x007c, B:20:0x007f, B:21:0x009d, B:25:0x00a2, B:27:0x00a5, B:29:0x00ad, B:31:0x00b4, B:34:0x00b7, B:36:0x00bd, B:41:0x00ce, B:42:0x00d1, B:13:0x005f), top: B:10:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[Catch: SQLiteException -> 0x009e, LOOP:1: B:25:0x00a2->B:31:0x00b4, LOOP_START, PHI: r1
      0x00a2: PHI (r1v8 int) = (r1v7 int), (r1v9 int) binds: [B:24:0x00a0, B:31:0x00b4] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:11:0x0040, B:14:0x0066, B:16:0x0074, B:18:0x007c, B:20:0x007f, B:21:0x009d, B:25:0x00a2, B:27:0x00a5, B:29:0x00ad, B:31:0x00b4, B:34:0x00b7, B:36:0x00bd, B:41:0x00ce, B:42:0x00d1, B:13:0x005f), top: B:10:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd A[Catch: SQLiteException -> 0x009e, TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:11:0x0040, B:14:0x0066, B:16:0x0074, B:18:0x007c, B:20:0x007f, B:21:0x009d, B:25:0x00a2, B:27:0x00a5, B:29:0x00ad, B:31:0x00b4, B:34:0x00b7, B:36:0x00bd, B:41:0x00ce, B:42:0x00d1, B:13:0x005f), top: B:10:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(M4.z1 r9, android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.m.a(M4.z1, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void b(z1 z1Var, SQLiteDatabase sQLiteDatabase) {
        if (z1Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            z1Var.w().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            z1Var.w().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            z1Var.w().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        z1Var.w().a("Failed to turn on database write permission for owner");
    }
}
