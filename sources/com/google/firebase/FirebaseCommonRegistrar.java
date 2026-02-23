package com.google.firebase;

import A5.h;
import A5.i;
import A5.j;
import A5.k;
import A5.l;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import h6.f;
import java.util.ArrayList;
import java.util.List;
import s6.c;
import s6.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        return h(context);
    }

    public static /* synthetic */ String b(Context context) {
        return f(context);
    }

    public static /* synthetic */ String c(Context context) {
        return e(context);
    }

    public static /* synthetic */ String d(Context context) {
        return g(context);
    }

    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(h.a(applicationInfo));
    }

    public static /* synthetic */ String g(Context context) {
        int i = Build.VERSION.SDK_INT;
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
    }

    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    public static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.c());
        arrayList.add(f.g());
        arrayList.add(s6.h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(s6.h.b("fire-core", "20.4.2"));
        arrayList.add(s6.h.b("device-name", i(Build.PRODUCT)));
        arrayList.add(s6.h.b("device-model", i(Build.DEVICE)));
        arrayList.add(s6.h.b("device-brand", i(Build.BRAND)));
        arrayList.add(s6.h.c("android-target-sdk", new i()));
        arrayList.add(s6.h.c("android-min-sdk", new j()));
        arrayList.add(s6.h.c("android-platform", new k()));
        arrayList.add(s6.h.c("android-installer", new l()));
        String a = e.a();
        if (a != null) {
            arrayList.add(s6.h.b("kotlin", a));
        }
        return arrayList;
    }
}
