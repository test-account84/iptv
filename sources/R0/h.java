package R0;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {
    public static final String a = Q0.k.f("WrkDbPathHelper");
    public static final String[] b = {"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        return Build.VERSION.SDK_INT < 23 ? b(context) : c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    public static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        File b2 = b(context);
        if (Build.VERSION.SDK_INT < 23 || !b2.exists()) {
            return;
        }
        Q0.k.c().a(a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map f = f(context);
        for (File file : f.keySet()) {
            File file2 = (File) f.get(file);
            if (file.exists() && file2 != null) {
                if (file2.exists()) {
                    Q0.k.c().h(a, String.format("Over-writing contents of %s", new Object[]{file2}), new Throwable[0]);
                }
                Q0.k.c().a(a, file.renameTo(file2) ? String.format("Migrated %s to %s", new Object[]{file, file2}) : String.format("Renaming %s to %s failed", new Object[]{file, file2}), new Throwable[0]);
            }
        }
    }

    public static Map f(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File b2 = b(context);
            File a2 = a(context);
            hashMap.put(b2, a2);
            for (String str : b) {
                hashMap.put(new File(b2.getPath() + str), new File(a2.getPath() + str));
            }
        }
        return hashMap;
    }
}
