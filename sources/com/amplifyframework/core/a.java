package com.amplifyframework.core;

import android.content.Context;
import com.amplifyframework.core.category.Category;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Category a;
    public final /* synthetic */ Context c;

    public /* synthetic */ a(Category category, Context context) {
        this.a = category;
        this.c = context;
    }

    public final void run() {
        Amplify.a(this.a, this.c);
    }
}
