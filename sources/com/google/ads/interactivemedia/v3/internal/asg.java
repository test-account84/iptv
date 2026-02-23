package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import h4.a;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asg {
    private final Context a;
    private final Executor b;
    private final aru c;
    private final arw d;
    private final asf e;
    private final asf f;
    private Task g;
    private Task h;

    @VisibleForTesting
    public asg(Context context, Executor executor, aru aruVar, arw arwVar, asd asdVar, ase aseVar) {
        this.a = context;
        this.b = executor;
        this.c = aruVar;
        this.d = arwVar;
        this.e = asdVar;
        this.f = aseVar;
    }

    public static asg e(Context context, Executor executor, aru aruVar, arw arwVar) {
        asg asgVar = new asg(context, executor, aruVar, arwVar, new asd(), new ase());
        asgVar.g = asgVar.d.d() ? asgVar.h(new asb(asgVar, 1)) : Tasks.forResult(asgVar.e.a());
        asgVar.h = asgVar.h(new asb(asgVar, 0));
        return asgVar;
    }

    private static agc g(Task task, agc agcVar) {
        return !task.isSuccessful() ? agcVar : (agc) task.getResult();
    }

    private final Task h(Callable callable) {
        return Tasks.call(this.b, callable).addOnFailureListener(this.b, new asc(this));
    }

    public final agc a() {
        return g(this.g, this.e.a());
    }

    public final agc b() {
        return g(this.h, this.f.a());
    }

    public final /* synthetic */ agc c() throws Exception {
        Context context = this.a;
        agl as = agc.as();
        a.a a = h4.a.a(context);
        String a2 = a.a();
        if (a2 != null && a2.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(a2);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            a2 = Base64.encodeToString(bArr, 11);
        }
        if (a2 != null) {
            as.ab(a2);
            as.aa(a.b());
            as.aL(aft.f);
        }
        return (agc) as.aY();
    }

    public final /* synthetic */ agc d() throws Exception {
        Context context = this.a;
        return asa.b(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void f(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.c.c(2025, -1L, exc);
    }
}
