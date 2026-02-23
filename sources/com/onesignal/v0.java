package com.onesignal;

import android.content.Context;
import android.net.Uri;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class V0 {
    public Q0 a;
    public Context b;
    public JSONObject c;
    public boolean d;
    public boolean e;
    public Long f;
    public CharSequence g;
    public CharSequence h;
    public Uri i;
    public Integer j;
    public Integer k;
    public Uri l;

    public V0(Context context) {
        this.b = context;
    }

    public Integer a() {
        return Integer.valueOf(this.a.d());
    }

    public String b() {
        return F1.e0(this.c);
    }

    public CharSequence c() {
        CharSequence charSequence = this.g;
        return charSequence != null ? charSequence : this.a.e();
    }

    public Context d() {
        return this.b;
    }

    public JSONObject e() {
        return this.c;
    }

    public Q0 f() {
        return this.a;
    }

    public Uri g() {
        return this.l;
    }

    public Integer h() {
        return this.j;
    }

    public Uri i() {
        return this.i;
    }

    public Long j() {
        return this.f;
    }

    public CharSequence k() {
        CharSequence charSequence = this.h;
        return charSequence != null ? charSequence : this.a.k();
    }

    public boolean l() {
        this.a.f();
        return false;
    }

    public boolean m() {
        return this.e;
    }

    public boolean n() {
        return this.d;
    }

    public void o(Context context) {
        this.b = context;
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void r(Q0 q0) {
        if (q0 != null && !q0.m()) {
            Q0 q02 = this.a;
            q0.r((q02 == null || !q02.m()) ? new SecureRandom().nextInt() : this.a.d());
        }
        this.a = q0;
    }

    public void s(Integer num) {
        this.k = num;
    }

    public void t(Uri uri) {
        this.l = uri;
    }

    public String toString() {
        return "OSNotificationGenerationJob{jsonPayload=" + this.c + ", isRestoring=" + this.d + ", isNotificationToDisplay=" + this.e + ", shownTimeStamp=" + this.f + ", overriddenBodyFromExtender=" + this.g + ", overriddenTitleFromExtender=" + this.h + ", overriddenSound=" + this.i + ", overriddenFlags=" + this.j + ", orgFlags=" + this.k + ", orgSound=" + this.l + ", notification=" + this.a + '}';
    }

    public void u(CharSequence charSequence) {
        this.g = charSequence;
    }

    public void v(Integer num) {
        this.j = num;
    }

    public void w(Uri uri) {
        this.i = uri;
    }

    public void x(CharSequence charSequence) {
        this.h = charSequence;
    }

    public void y(boolean z) {
        this.d = z;
    }

    public void z(Long l) {
        this.f = l;
    }

    public V0(Context context, Q0 q0, JSONObject jSONObject) {
        this.b = context;
        this.c = jSONObject;
        r(q0);
    }

    public V0(Context context, JSONObject jSONObject) {
        this(context, new Q0(jSONObject), jSONObject);
    }
}
