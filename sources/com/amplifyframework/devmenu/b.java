package com.amplifyframework.devmenu;

import android.content.Context;
import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ DevMenuFileIssueFragment a;
    public final /* synthetic */ Context c;

    public /* synthetic */ b(DevMenuFileIssueFragment devMenuFileIssueFragment, Context context) {
        this.a = devMenuFileIssueFragment;
        this.c = context;
    }

    public final void onClick(View view) {
        DevMenuFileIssueFragment.x(this.a, this.c, view);
    }
}
