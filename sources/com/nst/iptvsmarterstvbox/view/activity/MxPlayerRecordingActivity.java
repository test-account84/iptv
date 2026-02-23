package com.nst.iptvsmarterstvbox.view.activity;

import a7.c;
import a7.j;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MxPlayerRecordingActivity extends androidx.appcompat.app.b {
    public String d;
    public Uri e;
    public Context f;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                try {
                    MxPlayerRecordingActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.mxtech.videoplayer.ad")));
                } catch (ActivityNotFoundException e) {
                    w.P0(MxPlayerRecordingActivity.u1(MxPlayerRecordingActivity.this), String.valueOf(e));
                }
            } catch (ActivityNotFoundException unused) {
                MxPlayerRecordingActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad")));
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MxPlayerRecordingActivity.this.finish();
        }
    }

    public static /* synthetic */ Context u1(MxPlayerRecordingActivity mxPlayerRecordingActivity) {
        return mxPlayerRecordingActivity.f;
    }

    private void w1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    private void x1() {
        this.f = this;
        String stringExtra = getIntent().getStringExtra("VIDEO_PATH");
        this.d = stringExtra;
        this.e = Uri.parse(stringExtra);
        try {
            if (!v1("com.mxtech.videoplayer.pro")) {
                Intent intent = new Intent();
                intent.setClassName("com.mxtech.videoplayer.ad", "com.mxtech.videoplayer.ad.ActivityScreen");
                intent.putExtra("package", getPackageName());
                intent.setDataAndType(this.e, "application/x-mpegURL");
                startActivity(intent);
            } else {
                if (this.f == null) {
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClassName("com.mxtech.videoplayer.pro", "com.mxtech.videoplayer.pro.ActivityScreen");
                intent2.putExtra("package", getPackageName());
                intent2.setDataAndType(this.e, "application/x-mpegURL");
                intent2.setPackage("com.mxtech.videoplayer.pro");
                startActivity(intent2);
                overridePendingTransition(a7.b.f, a7.b.d);
            }
            finish();
        } catch (ActivityNotFoundException unused) {
            y1();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        w1();
        x1();
        getWindow().setFlags(1024, 1024);
    }

    public final boolean v1(String str) {
        Context context = this.f;
        if (context != null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public void y1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(j.m3));
        builder.setMessage(getResources().getString(j.v));
        builder.setPositiveButton(getResources().getString(j.z2), new a());
        builder.setNegativeButton(getResources().getString(j.f0), new b());
        builder.setCancelable(false);
        builder.create().show();
    }
}
