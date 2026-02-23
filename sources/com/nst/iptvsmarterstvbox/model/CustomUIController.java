package com.nst.iptvsmarterstvbox.model;

import W7.c;
import android.view.View;
import android.widget.Button;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CustomUIController {
    private Button playPauseButton;
    private View playerUI;
    private boolean playing = false;
    private c youTubePlayer;
    private YouTubePlayerView youTubePlayerView;

    public CustomUIController(View view, c cVar, YouTubePlayerView youTubePlayerView) {
        this.playerUI = view;
        this.youTubePlayer = cVar;
        this.youTubePlayerView = youTubePlayerView;
        initViews(view);
    }

    private void initViews(View view) {
    }
}
