package a7;

import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o {
    public static boolean a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static String b(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String c(String str) {
        return str.substring(0, str.lastIndexOf("/"));
    }

    public static String d(long j) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        long j2 = (j % 86400000) / 3600000;
        long j3 = (j % 3600000) / 60000;
        long j4 = (j % 60000) / 1000;
        if (j2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j2);
        } else {
            sb = new StringBuilder();
            sb.append(j2);
            sb.append("");
        }
        String sb5 = sb.toString();
        if (j3 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j3);
        } else {
            sb2 = new StringBuilder();
            sb2.append(j3);
            sb2.append("");
        }
        String sb6 = sb2.toString();
        if (j4 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j4);
        } else {
            sb3 = new StringBuilder();
            sb3.append(j4);
            sb3.append("");
        }
        String sb7 = sb3.toString();
        if (j2 != 0) {
            sb4 = new StringBuilder();
            sb4.append(sb5);
            sb4.append(":");
        } else {
            sb4 = new StringBuilder();
        }
        sb4.append(sb6);
        sb4.append(":");
        sb4.append(sb7);
        return sb4.toString();
    }
}
