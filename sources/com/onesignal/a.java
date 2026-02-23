package com.onesignal;

import android.content.pm.PackageInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class A {
    public final boolean a;
    public final PackageInfo b;

    public A(boolean z, PackageInfo packageInfo) {
        this.a = z;
        this.b = packageInfo;
    }

    public final PackageInfo a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a = (A) obj;
        return this.a == a.a && kotlin.jvm.internal.l.a(this.b, a.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        PackageInfo packageInfo = this.b;
        return i + (packageInfo == null ? 0 : packageInfo.hashCode());
    }

    public String toString() {
        return "GetPackageInfoResult(successful=" + this.a + ", packageInfo=" + this.b + ')';
    }
}
