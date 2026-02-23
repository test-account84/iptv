package B6;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e {
    public static final String d = "e";
    public final Context a;
    public boolean b = true;
    public boolean c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.a = activity.getApplicationContext();
    }

    public static /* synthetic */ void a(MediaPlayer mediaPlayer) {
        c(mediaPlayer);
    }

    public static /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i, int i2) {
        return d(mediaPlayer, i, i2);
    }

    public static /* synthetic */ void c(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    public static /* synthetic */ boolean d(MediaPlayer mediaPlayer, int i, int i2) {
        Log.w(d, "Failed to beep " + i + ", " + i2);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new c());
        mediaPlayer.setOnErrorListener(new d());
        try {
            AssetFileDescriptor openRawResourceFd = this.a.getResources().openRawResourceFd(m.a);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                openRawResourceFd.close();
                throw th;
            }
        } catch (IOException e) {
            Log.w(d, e);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void f() {
        Vibrator vibrator;
        try {
            if (this.b) {
                e();
            }
            if (this.c && (vibrator = (Vibrator) this.a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(boolean z) {
        this.b = z;
    }
}
