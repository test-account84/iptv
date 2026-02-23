package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import g1.G;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public int a;
    public String b;

    public static class a {
        public int a;
        public String b = "";

        public /* synthetic */ a(G g) {
        }

        public a a() {
            a aVar = new a();
            a.e(aVar, this.a);
            a.d(aVar, this.b);
            return aVar;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(int i) {
            this.a = i;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public static /* bridge */ /* synthetic */ void d(a aVar, String str) {
        aVar.b = str;
    }

    public static /* bridge */ /* synthetic */ void e(a aVar, int i) {
        aVar.a = i;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return "Response Code: " + zzb.zzh(this.a) + ", Debug Message: " + this.b;
    }
}
