package com.google.ads.interactivemedia.v3.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.tasks.Tasks;
import h4.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ali {
    private final Context a;
    private final boolean b;
    private final long c;

    public ali(Context context, boolean z, long j) {
        this.a = context;
        this.b = z;
        this.c = j <= 0 ? 150L : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final com.google.ads.interactivemedia.v3.impl.data.bg a() {
        alh alhVar;
        String str;
        String str2;
        String str3 = "";
        int i = 0;
        alh alhVar2 = new alh("", false);
        try {
            a.a a = h4.a.a(this.a);
            alhVar = new alh(a.a(), a.b());
            str = "adid";
        } catch (NoClassDefFoundError | Exception unused) {
            try {
                ContentResolver contentResolver = this.a.getContentResolver();
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                boolean z = true;
                if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                    z = false;
                }
                alhVar = new alh(string, z);
                str = "afai";
            } catch (Settings.SettingNotFoundException unused2) {
                alhVar = alhVar2;
                com.google.ads.interactivemedia.v3.impl.data.m.d("Failed to get advertising ID.");
                str = "";
            }
        }
        if (this.b) {
            try {
                i4.c cVar = (i4.c) Tasks.await(i4.a.a(this.a).getAppSetIdInfo(), this.c, TimeUnit.MILLISECONDS);
                str3 = cVar.a();
                i = cVar.b();
            } catch (NoClassDefFoundError | NoSuchMethodError | Exception unused3) {
                str2 = "Unable to contact the App Set SDK.";
                com.google.ads.interactivemedia.v3.impl.data.m.d(str2);
                return com.google.ads.interactivemedia.v3.impl.data.bg.create(alhVar.a, str, alhVar.b, str3, i);
            } catch (ExecutionException | InterruptedException | TimeoutException unused4) {
                str2 = "Timeout getting AppSet ID.";
                com.google.ads.interactivemedia.v3.impl.data.m.d(str2);
                return com.google.ads.interactivemedia.v3.impl.data.bg.create(alhVar.a, str, alhVar.b, str3, i);
            }
        }
        return com.google.ads.interactivemedia.v3.impl.data.bg.create(alhVar.a, str, alhVar.b, str3, i);
    }
}
