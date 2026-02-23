package com.amplifyframework.devmenu;

import com.amplifyframework.devmenu.DeveloperMenu;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class h implements DeveloperMenu.HideAction {
    public final /* synthetic */ DeveloperMenuActivity a;

    public /* synthetic */ h(DeveloperMenuActivity developerMenuActivity) {
        this.a = developerMenuActivity;
    }

    public final void hideDeveloperMenu() {
        this.a.finish();
    }
}
