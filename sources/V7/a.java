package v7;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a extends Service {
    public static IMediaPlayer a;

    public static IMediaPlayer a() {
        return a;
    }

    public static void b(Context context) {
        context.startService(c(context));
    }

    public static Intent c(Context context) {
        return new Intent(context, a.class);
    }

    public static void d(IMediaPlayer iMediaPlayer) {
        IMediaPlayer iMediaPlayer2 = a;
        if (iMediaPlayer2 != null && iMediaPlayer2 != iMediaPlayer) {
            if (iMediaPlayer2.isPlaying()) {
                a.stop();
            }
            a.release();
            a = null;
        }
        a = iMediaPlayer;
    }
}
