package com.google.ads.interactivemedia.v3.impl.data;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class av {
    public static File a(String str, String str2, File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(b(str, file), str2);
    }

    public static File b(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        e(file2, false);
        return file2;
    }

    public static boolean c(File file) {
        boolean z;
        if (!file.exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            z = true;
            for (int i = 0; i < length; i++) {
                File file2 = listFiles[i];
                z = file2 != null && c(file2) && z;
            }
        } else {
            z = true;
        }
        return file.delete() && z;
    }

    public static boolean d(File file, byte[] bArr) {
        Closeable closeable = null;
        try {
            Closeable fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                C4.k.a(fileOutputStream);
                return true;
            } catch (IOException unused) {
                closeable = fileOutputStream;
                C4.k.a(closeable);
                return false;
            } catch (Throwable th) {
                th = th;
                closeable = fileOutputStream;
                C4.k.a(closeable);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void e(File file, boolean z) {
        if (z && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
