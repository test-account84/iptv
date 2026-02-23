package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.view.SurfaceHolder;
import android.view.View;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface a {

    public interface a {
        void a(b bVar, int i, int i2, int i3);

        void b(b bVar, int i, int i2);

        void c(b bVar);
    }

    public interface b {
        a a();

        void b(IMediaPlayer iMediaPlayer);

        SurfaceHolder c();
    }

    void a(int i, int i2);

    void b(a aVar);

    void c(int i, int i2);

    boolean d();

    void e(a aVar);

    View getView();

    void setAspectRatio(int i);

    void setVideoRotation(int i);
}
