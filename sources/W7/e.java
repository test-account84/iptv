package w7;

import android.content.Context;
import android.content.pm.PackageManager;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class e {
    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void b(IMediaPlayer iMediaPlayer, int i) {
        IjkMediaPlayer c = c(iMediaPlayer);
        if (c == null) {
            return;
        }
        c.deselectTrack(i);
    }

    public static IjkMediaPlayer c(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return null;
        }
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            if (!(iMediaPlayer instanceof MediaPlayerProxy)) {
                return null;
            }
            MediaPlayerProxy mediaPlayerProxy = (MediaPlayerProxy) iMediaPlayer;
            if (!(mediaPlayerProxy.getInternalMediaPlayer() instanceof IjkMediaPlayer)) {
                return null;
            }
            iMediaPlayer = mediaPlayerProxy.getInternalMediaPlayer();
        }
        return (IjkMediaPlayer) iMediaPlayer;
    }

    public static int d(IMediaPlayer iMediaPlayer, int i) {
        IjkMediaPlayer c = c(iMediaPlayer);
        if (c == null) {
            return -1;
        }
        return c.getSelectedTrack(i);
    }

    public static void e(IMediaPlayer iMediaPlayer, int i) {
        IjkMediaPlayer c = c(iMediaPlayer);
        if (c == null) {
            return;
        }
        c.selectTrack(i);
    }
}
