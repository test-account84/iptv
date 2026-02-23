package com.onesignal.shortcutbadger.impl;

import T7.a;
import U7.b;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SamsungHomeBadger implements a {
    public static final String[] b = {"_id", "class"};
    public DefaultBadger a = new DefaultBadger();

    public List a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }

    public void b(Context context, ComponentName componentName, int i) {
        DefaultBadger defaultBadger = this.a;
        if (defaultBadger != null && defaultBadger.c(context)) {
            this.a.b(context, componentName, i);
            return;
        }
        Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(parse, b, "package=?", new String[]{componentName.getPackageName()}, (String) null);
            if (cursor != null) {
                String className = componentName.getClassName();
                boolean z = false;
                while (cursor.moveToNext()) {
                    contentResolver.update(parse, c(componentName, i, false), "_id=?", new String[]{String.valueOf(cursor.getInt(0))});
                    if (className.equals(cursor.getString(cursor.getColumnIndex("class")))) {
                        z = true;
                    }
                }
                if (!z) {
                    contentResolver.insert(parse, c(componentName, i, true));
                }
            }
            b.a(cursor);
        } catch (Throwable th) {
            b.a(cursor);
            throw th;
        }
    }

    public final ContentValues c(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }
}
