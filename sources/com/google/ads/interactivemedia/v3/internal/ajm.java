package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ajm implements OnCompleteListener {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ ajm(aiq aiqVar, int i) {
        this.b = i;
        this.a = aiqVar;
    }

    public final void onComplete(Task task) {
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                ((ajx) this.a).p();
                return;
            } else {
                ((aiq) this.a).k(task);
                return;
            }
        }
        Object obj = this.a;
        if (!task.isSuccessful()) {
            com.google.ads.interactivemedia.v3.impl.data.m.b("Image companion error", task.getException());
        } else {
            ((ajn) obj).setImageBitmap((Bitmap) task.getResult());
        }
    }

    public /* synthetic */ ajm(ajn ajnVar, int i) {
        this.b = i;
        this.a = ajnVar;
    }

    public /* synthetic */ ajm(ajx ajxVar, int i) {
        this.b = i;
        this.a = ajxVar;
    }
}
