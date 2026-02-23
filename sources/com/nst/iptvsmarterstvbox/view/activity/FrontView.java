package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.VideoView;
import androidx.appcompat.app.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FrontView extends b {
    public boolean d = false;

    public class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ View c;

        public a(View view, View view2) {
            this.a = view;
            this.c = view2;
        }

        public void onClick(View view) {
            FrontView frontView;
            boolean z = false;
            if (FrontView.u1(FrontView.this)) {
                this.a.setVisibility(0);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                FrontView.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                FrameLayout.LayoutParams layoutParams = this.c.getLayoutParams();
                float f = displayMetrics.density;
                layoutParams.width = (int) (200.0f * f);
                layoutParams.height = (int) (150.0f * f);
                layoutParams.leftMargin = (int) (20.0f * f);
                layoutParams.topMargin = (int) (f * 50.0f);
                this.c.setLayoutParams(layoutParams);
                frontView = FrontView.this;
            } else {
                this.a.setVisibility(8);
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                FrontView.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
                FrameLayout.LayoutParams layoutParams2 = this.c.getLayoutParams();
                layoutParams2.width = displayMetrics2.widthPixels;
                layoutParams2.height = displayMetrics2.heightPixels;
                layoutParams2.leftMargin = 0;
                layoutParams2.topMargin = 0;
                this.c.setLayoutParams(layoutParams2);
                frontView = FrontView.this;
                z = true;
            }
            FrontView.v1(frontView, z);
        }
    }

    public static /* synthetic */ boolean u1(FrontView frontView) {
        return frontView.d;
    }

    public static /* synthetic */ boolean v1(FrontView frontView, boolean z) {
        frontView.d = z;
        return z;
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.I);
        View findViewById = findViewById(f.p4);
        View findViewById2 = findViewById(f.p6);
        VideoView findViewById3 = findViewById(f.Im);
        findViewById3.setVideoURI(Uri.parse("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
        findViewById3.start();
        findViewById.setOnClickListener(new a(findViewById2, findViewById));
    }
}
