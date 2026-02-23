package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SonyHomeBadger implements T7.a {
    public final Uri a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    public AsyncQueryHandler b;

    public class a extends AsyncQueryHandler {
        public a(ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    private static void d(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0);
        context.sendBroadcast(intent);
    }

    public static boolean h(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }

    public List a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    public void b(Context context, ComponentName componentName, int i) {
        if (h(context)) {
            e(context, componentName, i);
        } else {
            d(context, componentName, i);
        }
    }

    public final ContentValues c(int i, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    public final void e(Context context, ComponentName componentName, int i) {
        if (i < 0) {
            return;
        }
        ContentValues c = c(i, componentName);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            g(context, c);
            return;
        }
        if (this.b == null) {
            this.b = new a(context.getApplicationContext().getContentResolver());
        }
        f(c);
    }

    public final void f(ContentValues contentValues) {
        this.b.startInsert(0, (Object) null, this.a, contentValues);
    }

    public final void g(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.a, contentValues);
    }
}
