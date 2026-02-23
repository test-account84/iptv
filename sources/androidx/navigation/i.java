package androidx.navigation;

import D.P;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public final Context a;
    public final Intent b;
    public l c;
    public int d;
    public Bundle e;

    public i(Context context) {
        this.a = context;
        if (context instanceof Activity) {
            this.b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.b.addFlags(268468224);
    }

    public P a() {
        if (this.b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null) {
            if (this.c == null) {
                throw new IllegalStateException("You must call setGraph() before constructing the deep link");
            }
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
        P b = P.e(this.a).b(new Intent(this.b));
        for (int i = 0; i < b.i(); i++) {
            b.g(i).putExtra("android-support-nav:controller:deepLinkIntent", this.b);
        }
        return b;
    }

    public final void b() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.c);
        k kVar = null;
        while (!arrayDeque.isEmpty() && kVar == null) {
            k kVar2 = (k) arrayDeque.poll();
            if (kVar2.i() == this.d) {
                kVar = kVar2;
            } else if (kVar2 instanceof l) {
                Iterator it = ((l) kVar2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add((k) it.next());
                }
            }
        }
        if (kVar != null) {
            this.b.putExtra("android-support-nav:controller:deepLinkIds", kVar.d());
            return;
        }
        throw new IllegalArgumentException("Navigation destination " + k.h(this.a, this.d) + " cannot be found in the navigation graph " + this.c);
    }

    public i c(Bundle bundle) {
        this.e = bundle;
        this.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public i d(int i) {
        this.d = i;
        if (this.c != null) {
            b();
        }
        return this;
    }

    public i(NavController navController) {
        this(navController.f());
        this.c = navController.j();
    }
}
