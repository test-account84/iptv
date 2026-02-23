package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class o extends g {
    public static final String[] b = {"orientation"};

    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);

        final int androidKind;
        final int height;
        final int width;

        a(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }

    public o(Context context) {
        super(context);
    }

    public static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, b, (String) null, (String[]) null, (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                int i = cursor.getInt(0);
                cursor.close();
                return i;
            }
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static a l(int i, int i2) {
        a aVar = a.MICRO;
        if (i <= aVar.width && i2 <= aVar.height) {
            return aVar;
        }
        a aVar2 = a.MINI;
        return (i > aVar2.width || i2 > aVar2.height) ? a.FULL : aVar2;
    }

    public boolean c(w wVar) {
        Uri uri = wVar.d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public y.a f(w wVar, int i) {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.a.getContentResolver();
        int k = k(contentResolver, wVar.d);
        String type = contentResolver.getType(wVar.d);
        boolean z = type != null && type.startsWith("video/");
        if (wVar.c()) {
            a l = l(wVar.h, wVar.i);
            if (!z && l == a.FULL) {
                return new y.a(null, j(wVar), t.e.DISK, k);
            }
            long parseId = ContentUris.parseId(wVar.d);
            BitmapFactory.Options d = y.d(wVar);
            d.inJustDecodeBounds = true;
            y.a(wVar.h, wVar.i, l.width, l.height, d, wVar);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, l == a.FULL ? 1 : l.androidKind, d);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, l.androidKind, d);
            }
            if (thumbnail != null) {
                return new y.a(thumbnail, null, t.e.DISK, k);
            }
        }
        return new y.a(null, j(wVar), t.e.DISK, k);
    }
}
