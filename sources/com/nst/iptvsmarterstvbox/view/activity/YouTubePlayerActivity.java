package com.nst.iptvsmarterstvbox.view.activity;

import W7.f;
import a7.g;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class YouTubePlayerActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public RelativeLayout d;
    public AppCompatImageView e;
    public AppCompatImageView f;
    public YouTubePlayerView g;
    public W7.c i;
    public Handler l;
    public String h = "";
    public boolean j = false;
    public boolean k = false;

    public class a implements f {

        public class a extends W7.a {
            public final /* synthetic */ W7.c a;

            public a(W7.c cVar) {
                this.a = cVar;
            }

            public void h(int i) {
                if (i == 0) {
                    YouTubePlayerActivity.this.finish();
                }
                if (i == 1) {
                    YouTubePlayerActivity.w1(YouTubePlayerActivity.this, true);
                    YouTubePlayerActivity.x1(YouTubePlayerActivity.this, false);
                }
                if (i == 2) {
                    YouTubePlayerActivity.x1(YouTubePlayerActivity.this, false);
                    YouTubePlayerActivity.w1(YouTubePlayerActivity.this, false);
                }
            }

            public void l() {
                String u1 = YouTubePlayerActivity.u1(YouTubePlayerActivity.this);
                YouTubePlayerActivity.v1(YouTubePlayerActivity.this, this.a);
                if (u1 == null || u1.isEmpty()) {
                    return;
                }
                YouTubePlayerActivity.this.findViewById(a7.f.D3).setVisibility(4);
                YouTubePlayerActivity.this.findViewById(a7.f.C3).setVisibility(0);
                this.a.d(u1, 0.0f);
                YouTubePlayerActivity.w1(YouTubePlayerActivity.this, true);
            }

            public void onError(int i) {
            }
        }

        public a() {
        }

        public void a(W7.c cVar) {
            cVar.b(new a(cVar));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            YouTubePlayerActivity.this.findViewById(a7.f.o2).setVisibility(4);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            YouTubePlayerActivity.this.findViewById(a7.f.o2).setVisibility(4);
        }
    }

    public static /* synthetic */ String u1(YouTubePlayerActivity youTubePlayerActivity) {
        return youTubePlayerActivity.h;
    }

    public static /* synthetic */ W7.c v1(YouTubePlayerActivity youTubePlayerActivity, W7.c cVar) {
        youTubePlayerActivity.i = cVar;
        return cVar;
    }

    public static /* synthetic */ boolean w1(YouTubePlayerActivity youTubePlayerActivity, boolean z) {
        youTubePlayerActivity.j = z;
        return z;
    }

    public static /* synthetic */ boolean x1(YouTubePlayerActivity youTubePlayerActivity, boolean z) {
        youTubePlayerActivity.k = z;
        return z;
    }

    private void y1() {
        this.d = findViewById(a7.f.o2);
        this.e = findViewById(a7.f.C3);
        this.f = findViewById(a7.f.D3);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 23 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onClick(View view) {
        W7.c cVar;
        AppCompatImageView appCompatImageView;
        int id = view.getId();
        if (id == a7.f.D3) {
            W7.c cVar2 = this.i;
            if (cVar2 == null) {
                return;
            }
            cVar2.play();
            findViewById(a7.f.D3).setVisibility(4);
            findViewById(a7.f.C3).setVisibility(0);
            this.f.clearFocus();
            appCompatImageView = this.e;
        } else {
            if (id != a7.f.C3 || (cVar = this.i) == null) {
                return;
            }
            cVar.pause();
            findViewById(a7.f.D3).setVisibility(0);
            findViewById(a7.f.C3).setVisibility(4);
            this.e.clearFocus();
            appCompatImageView = this.f;
        }
        appCompatImageView.requestFocus();
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.H1);
        y1();
        this.g = findViewById(a7.f.Xm);
        this.g.addView(getLayoutInflater().inflate(g.d5, (ViewGroup) null));
        this.f = findViewById(a7.f.D3);
        this.e = findViewById(a7.f.C3);
        findViewById(a7.f.D3).setOnClickListener(this);
        findViewById(a7.f.C3).setOnClickListener(this);
        z1();
    }

    public void onDestroy() {
        super.onDestroy();
        YouTubePlayerView youTubePlayerView = this.g;
        if (youTubePlayerView != null) {
            youTubePlayerView.release();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        if (i == 23 || i == 66 || i == 166 || i == 167) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppCompatImageView appCompatImageView;
        W7.c cVar;
        keyEvent.getRepeatCount();
        if (i != 23 && i != 66) {
            return super/*android.app.Activity*/.onKeyUp(i, keyEvent);
        }
        findViewById(a7.f.o2).setVisibility(0);
        if (findViewById(a7.f.o2).getVisibility() == 0) {
            if (!this.j || (cVar = this.i) == null) {
                W7.c cVar2 = this.i;
                if (cVar2 != null) {
                    this.j = true;
                    cVar2.play();
                    findViewById(a7.f.D3).setVisibility(4);
                    findViewById(a7.f.C3).setVisibility(0);
                    this.e.requestFocus();
                    appCompatImageView = this.f;
                }
            } else {
                this.j = false;
                cVar.pause();
                findViewById(a7.f.D3).setVisibility(0);
                findViewById(a7.f.C3).setVisibility(4);
                this.f.requestFocus();
                appCompatImageView = this.e;
            }
            appCompatImageView.clearFocus();
        }
        this.l.removeCallbacksAndMessages((Object) null);
        this.l.postDelayed(new c(), 2000L);
        return true;
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
    }

    public final void z1() {
        this.l = new Handler();
        this.g.getPlayerUIController();
        Intent intent = getIntent();
        if (intent != null) {
            this.h = intent.getStringExtra("you_tube_trailer");
        }
        this.g.getPlayerUIController().a(false);
        if (new u7.a(this).A().equals(m7.a.K0)) {
            this.g.getPlayerUIController().o(false);
        } else {
            this.g.getPlayerUIController().o(true);
        }
        this.g.getPlayerUIController().b(false);
        this.g.getPlayerUIController().m(true);
        this.g.m(new a(), true);
        this.l.removeCallbacksAndMessages((Object) null);
        this.l.postDelayed(new b(), 2000L);
    }
}
