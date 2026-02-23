package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class LifecycleCallback {
    protected final j mLifecycleFragment;

    public LifecycleCallback(j jVar) {
        this.mLifecycleFragment = jVar;
    }

    @Keep
    private static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public static j getFragment(Activity activity) {
        return getFragment(new i(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity h = this.mLifecycleFragment.h();
        com.google.android.gms.common.internal.r.m(h);
        return h;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public static j getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public static j getFragment(i iVar) {
        if (iVar.d()) {
            return n1.A(iVar.b());
        }
        if (iVar.c()) {
            return l1.c(iVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
