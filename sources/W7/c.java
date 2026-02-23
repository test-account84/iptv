package w7;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.widget.TableLayout;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c {
    public k a;
    public IMediaPlayer c;
    public SparseArray b = new SparseArray();
    public long d = 0;
    public long e = 0;
    public Handler f = new a();

    public class a extends Handler {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r20) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: w7.c.a.handleMessage(android.os.Message):void");
        }
    }

    public c(Context context, TableLayout tableLayout) {
        this.a = new k(context, tableLayout);
    }

    public static /* synthetic */ IMediaPlayer a(c cVar) {
        return cVar.c;
    }

    public static /* synthetic */ void b(c cVar, int i, String str) {
        cVar.m(i, str);
    }

    public static /* synthetic */ String c(long j) {
        return i(j);
    }

    public static /* synthetic */ String d(long j) {
        return j(j);
    }

    public static /* synthetic */ long e(c cVar) {
        return cVar.d;
    }

    public static /* synthetic */ long f(c cVar) {
        return cVar.e;
    }

    public static /* synthetic */ String g(long j, long j2) {
        return k(j, j2);
    }

    public static /* synthetic */ Handler h(c cVar) {
        return cVar.f;
    }

    public static String i(long j) {
        Locale locale = Locale.US;
        return j >= 1000 ? String.format(locale, "%.2f sec", new Object[]{Float.valueOf(j / 1000.0f)}) : String.format(locale, "%d msec", new Object[]{Long.valueOf(j)});
    }

    public static String j(long j) {
        if (j >= 100000) {
            return String.format(Locale.US, "%.2f MB", new Object[]{Float.valueOf((j / 1000.0f) / 1000.0f)});
        }
        Locale locale = Locale.US;
        return j >= 100 ? String.format(locale, "%.1f KB", new Object[]{Float.valueOf(j / 1000.0f)}) : String.format(locale, "%d B", new Object[]{Long.valueOf(j)});
    }

    public static String k(long j, long j2) {
        if (j2 <= 0 || j <= 0) {
            return "0 B/s";
        }
        float f = (j * 1000.0f) / j2;
        return f >= 1000000.0f ? String.format(Locale.US, "%.2f MB/s", new Object[]{Float.valueOf((f / 1000.0f) / 1000.0f)}) : f >= 1000.0f ? String.format(Locale.US, "%.1f KB/s", new Object[]{Float.valueOf(f / 1000.0f)}) : String.format(Locale.US, "%d B/s", new Object[]{Long.valueOf((long) f)});
    }

    public static int p() {
        return 0;
    }

    public void l(IMediaPlayer iMediaPlayer) {
        this.c = iMediaPlayer;
        if (iMediaPlayer != null) {
            this.f.sendEmptyMessageDelayed(1, 500L);
        } else {
            this.f.removeMessages(1);
        }
    }

    public final void m(int i, String str) {
        View view = (View) this.b.get(i);
        if (view != null) {
            this.a.l(view, str);
        } else {
            this.b.put(i, this.a.c(i, str));
        }
    }

    public void n(long j) {
        this.d = j;
    }

    public void o(long j) {
        this.e = j;
    }
}
