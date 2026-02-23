package com.google.firebase.analytics.connector.internal;

import A5.f;
import C5.a;
import C5.b;
import I5.c;
import I5.e;
import I5.r;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import g6.d;
import java.util.Arrays;
import java.util.List;
import s6.h;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return b.d((f) eVar.a(f.class), (Context) eVar.a(Context.class), (d) eVar.a(d.class));
    }

    @Keep
    @SuppressLint({"MissingPermission"})
    public List getComponents() {
        return Arrays.asList(new c[]{c.e(a.class).b(r.k(f.class)).b(r.k(Context.class)).b(r.k(d.class)).f(D5.a.a).e().d(), h.b("fire-analytics", "21.3.0")});
    }
}
