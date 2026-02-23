package com.nst.iptvsmarterstvbox.view.activity;

import a7.g;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.b;
import e7.e;
import e7.f;
import java.util.Iterator;
import p7.J;
import u7.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Local_media_Activity extends b {
    public static a e;
    public Context d = this;

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 512) {
            if (i2 == -1) {
                Iterator it = intent.getParcelableArrayListExtra("ResultPickVideo").iterator();
                while (it.hasNext()) {
                    String x = ((f) it.next()).x();
                    StringBuilder sb = new StringBuilder();
                    sb.append(x);
                    sb.append("\n");
                }
                return;
            }
            return;
        }
        if (i == 768) {
            if (i2 == -1) {
                Iterator it2 = intent.getParcelableArrayListExtra("ResultPickAudio").iterator();
                while (it2.hasNext()) {
                    String x2 = ((e7.a) it2.next()).x();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(x2);
                    sb2.append("\n");
                }
                return;
            }
            return;
        }
        if (i == 1024 && i2 == -1) {
            Iterator it3 = intent.getParcelableArrayListExtra("ResultPickFILE").iterator();
            while (it3.hasNext()) {
                String x3 = ((e) it3.next()).x();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(x3);
                sb3.append("\n");
            }
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this.d, RoutingActivity.class));
        finishAffinity();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.l1) {
            Intent intent = new Intent(this, VideoPickActivity.class);
            intent.putExtra("IsNeedCamera", false);
            intent.putExtra("MaxNumber", 9);
            intent.putExtra("isNeedFolderList", true);
            startActivity(intent);
            return;
        }
        if (id == a7.f.j1) {
            Intent intent2 = new Intent(this, AudioPickActivity.class);
            intent2.putExtra("IsNeedRecorder", false);
            intent2.putExtra("MaxNumber", 9);
            intent2.putExtra("isNeedFolderList", true);
            startActivityForResult(intent2, 768);
            return;
        }
        if (id == a7.f.k1) {
            g7.b bVar = new g7.b(this.d, new J(new String[]{""}));
            if (Build.VERSION.SDK_INT >= 30) {
                bVar.x("");
            } else {
                bVar.w("");
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.d = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        a aVar = new a(this.d);
        e = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.T : g.S);
    }
}
