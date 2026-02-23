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
import androidx.core.content.FileProvider;
import java.io.File;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PlayRecordingExternalPlayerActivity extends androidx.appcompat.app.b {
    public String d;
    public Context e;
    public String f = "";
    public String g = "";
    public String h = "";

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                try {
                    PlayRecordingExternalPlayerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + PlayRecordingExternalPlayerActivity.u1(PlayRecordingExternalPlayerActivity.this))));
                } catch (ActivityNotFoundException unused) {
                    PlayRecordingExternalPlayerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + PlayRecordingExternalPlayerActivity.u1(PlayRecordingExternalPlayerActivity.this))));
                }
            } catch (ActivityNotFoundException e) {
                w.P0(PlayRecordingExternalPlayerActivity.v1(PlayRecordingExternalPlayerActivity.this), String.valueOf(e));
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PlayRecordingExternalPlayerActivity.this.finish();
        }
    }

    public static /* synthetic */ String u1(PlayRecordingExternalPlayerActivity playRecordingExternalPlayerActivity) {
        return playRecordingExternalPlayerActivity.f;
    }

    public static /* synthetic */ Context v1(PlayRecordingExternalPlayerActivity playRecordingExternalPlayerActivity) {
        return playRecordingExternalPlayerActivity.e;
    }

    private boolean w1(String str) {
        Context context = this.e;
        if (context != null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    private void y1() {
        this.e = this;
        this.f = getIntent().getStringExtra("packagename");
        this.g = this.f + ".ActivityScreen";
        this.h = getIntent().getStringExtra("app_name");
        this.d = getIntent().getStringExtra("url");
        if (w1(this.f)) {
            if (this.e == null) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.f);
                intent.setDataAndType(Uri.parse("file://" + this.d), "video/*");
                intent.addFlags(1);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                finish();
                return;
            } catch (ActivityNotFoundException | Exception unused) {
            } catch (Exception unused2) {
                File file = new File(this.d);
                Uri f = FileProvider.f(this.e, this.e.getApplicationContext().getPackageName() + ".provider", file);
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setPackage(this.f);
                intent2.setDataAndType(f, "video/*");
                intent2.addFlags(1);
                startActivity(intent2);
                overridePendingTransition(a7.b.f, a7.b.d);
                finish();
                return;
            }
        }
        z1();
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        x1();
        y1();
        getWindow().setFlags(1024, 1024);
    }

    public void z1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(j.m3));
        builder.setMessage(this.h + " " + getResources().getString(j.w));
        builder.setPositiveButton(getResources().getString(j.z2), new a());
        builder.setNegativeButton(getResources().getString(j.f0), new b());
        builder.setCancelable(false);
        builder.create().show();
    }
}
