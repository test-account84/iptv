package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajn extends ImageView implements View.OnClickListener {
    private final CompanionData a;
    private final ajx b;
    private final String c;
    private final List d;
    private final aly e;

    public ajn(Context context, ajx ajxVar, CompanionData companionData, Task task, String str, List list, aly alyVar) {
        super(context);
        this.b = ajxVar;
        this.a = companionData;
        this.c = str;
        this.d = list;
        this.e = alyVar;
        setOnClickListener(this);
        task.addOnCompleteListener(new ajm(this, 0));
    }

    public final void onClick(View view) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((CompanionAdSlot.ClickListener) it.next()).onCompanionAdClick();
        }
        this.e.a(this.a.clickThroughUrl());
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ajx ajxVar = this.b;
        String companionId = this.a.companionId();
        String str = this.c;
        if (atp.c(companionId) || atp.c(str)) {
            return;
        }
        HashMap p = axo.p(1);
        p.put("companionId", companionId);
        ajxVar.o(new ajr(ajp.displayContainer, ajq.companionView, str, p));
    }
}
