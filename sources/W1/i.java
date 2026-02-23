package W1;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public final int a;
    public final int b;
    public final Context c;

    public static class a implements b {
        public final DisplayMetrics a;

        public a(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        public int a() {
            return this.a.heightPixels;
        }

        public int b() {
            return this.a.widthPixels;
        }
    }

    public interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    public static int b(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1048576 * (d(activityManager) ? 0.33f : 0.4f));
    }

    public static boolean d(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public final String e(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    public i(Context context, ActivityManager activityManager, b bVar) {
        this.c = context;
        int b2 = b(activityManager);
        int b3 = bVar.b() * bVar.a();
        int i = b3 * 16;
        int i2 = b3 * 8;
        int i3 = i2 + i;
        if (i3 <= b2) {
            this.b = i2;
        } else {
            int round = Math.round(b2 / 6.0f);
            this.b = round * 2;
            i = round * 4;
        }
        this.a = i;
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(e(this.b));
            sb.append(" pool size: ");
            sb.append(e(this.a));
            sb.append(" memory class limited? ");
            sb.append(i3 > b2);
            sb.append(" max size: ");
            sb.append(e(b2));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(d(activityManager));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }
}
