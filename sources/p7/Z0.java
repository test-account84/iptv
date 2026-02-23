package p7;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class z0 {
    public static SeriesRecentWatchDatabase b;
    public Context a;

    public z0(Context context) {
        this.a = context;
        b = new SeriesRecentWatchDatabase(context);
    }

    public int a(String str) {
        x7.a.f().x(str);
        return b.isStreamAvailable(str);
    }

    public void b(String str) {
        new SeriesRecentWatchDatabase(this.a).deleteSeriesRecentwatch(str);
    }

    public ArrayList c(String str) {
        SeriesRecentWatchDatabase seriesRecentWatchDatabase = b;
        if (seriesRecentWatchDatabase != null) {
            return seriesRecentWatchDatabase.getRecentWatchedByEpisodeID(str);
        }
        return null;
    }

    public final void d(Context context, List list, int i) {
        try {
            new SeriesRecentWatchDatabase(context).addAllSeriesRecentWatch((GetEpisdoeDetailsCallback) list.get(i));
        } catch (Exception unused) {
        }
    }

    public final void e(Context context, List list, int i) {
        d(context, list, i);
    }

    public void f() {
        if (x7.a.f() == null || h(x7.a.f().e(), SharepreferenceDBHandler.getUserID(this.a)) != 0) {
            return;
        }
        try {
            i(this.a, ((GetEpisdoeDetailsCallback) EpisodesUsingSinglton.getInstance().getEpisodeList().get(x7.a.f().d())).getSeriesId());
            e(this.a, EpisodesUsingSinglton.getInstance().getEpisodeList(), x7.a.f().d());
        } catch (Exception unused) {
        }
    }

    public void g(Context context, GetEpisdoeDetailsCallback getEpisdoeDetailsCallback) {
        try {
            new SeriesRecentWatchDatabase(context).addAllSeriesRecentWatch(getEpisdoeDetailsCallback);
        } catch (Exception unused) {
        }
    }

    public int h(String str, int i) {
        return b.isStreamAvailable(str);
    }

    public void i(Context context, String str) {
        try {
            new SeriesRecentWatchDatabase(context).updateAllRecordsBySeriesNumRecentWatchDB(str);
        } catch (Exception unused) {
        }
    }

    public void j(String str, long j) {
        SeriesRecentWatchDatabase seriesRecentWatchDatabase = b;
        if (seriesRecentWatchDatabase != null) {
            seriesRecentWatchDatabase.updateSeriesRecentWatch(str, Long.valueOf(j));
        }
    }
}
