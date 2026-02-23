package r4;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.cast.zzbs;
import com.google.android.gms.internal.cast.zzbt;
import com.google.android.gms.internal.cast.zzbu;
import com.google.android.gms.internal.cast.zzby;
import com.google.android.gms.internal.cast.zzbz;
import com.google.android.gms.internal.cast.zzca;
import com.google.android.gms.internal.cast.zzcb;
import com.google.android.gms.internal.cast.zzcd;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzcg;
import com.google.android.gms.internal.cast.zzch;
import com.google.android.gms.internal.cast.zzci;
import com.google.android.gms.internal.cast.zzcl;
import com.google.android.gms.internal.cast.zzcm;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzcq;
import com.google.android.gms.internal.cast.zzcs;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n4.q;
import o4.x;
import o4.y;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements i.b, y {
    public static final t4.b h = new t4.b("UIMediaController");
    public final Activity a;
    public final x b;
    public final Map c = new HashMap();
    public final Set d = new HashSet();
    public final c e = c.f();
    public i.b f;
    public p4.i g;

    public b(Activity activity) {
        this.a = activity;
        o4.b g = o4.b.g(activity);
        zzr.zzd(zzln.UI_MEDIA_CONTROLLER);
        x c = g != null ? g.c() : null;
        this.b = c;
        if (c != null) {
            c.a(this, o4.e.class);
            a0(c.c());
        }
    }

    public boolean A() {
        r.f("Must be called from the main thread.");
        return this.g != null;
    }

    public void B(View view) {
        p4.i z = z();
        if (z != null && z.q() && (this.a instanceof androidx.fragment.app.e)) {
            p4.j A = p4.j.A();
            androidx.fragment.app.e eVar = this.a;
            w m = eVar.getSupportFragmentManager().m();
            Fragment h0 = eVar.getSupportFragmentManager().h0("TRACKS_CHOOSER_DIALOG_TAG");
            if (h0 != null) {
                m.p(h0);
            }
            A.show(m, "TRACKS_CHOOSER_DIALOG_TAG");
        }
    }

    public void C(View view, long j) {
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        if (!z.r0()) {
            z.R(z.g() + j);
            return;
        }
        z.R(Math.min(z.g() + j, r6.c() + this.e.e()));
    }

    public void D(View view) {
        p4.a H = o4.b.e(this.a).a().H();
        if (H == null || TextUtils.isEmpty(H.H())) {
            return;
        }
        ComponentName componentName = new ComponentName(this.a.getApplicationContext(), H.H());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        this.a.startActivity(intent);
    }

    public void E(ImageView imageView) {
        o4.e c = o4.b.e(this.a.getApplicationContext()).c().c();
        if (c == null || !c.c()) {
            return;
        }
        try {
            c.u(!c.s());
        } catch (IOException | IllegalArgumentException e) {
            h.c("Unable to call CastSession.setMute(boolean).", e);
        }
    }

    public void F(ImageView imageView) {
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        z.W();
    }

    public void G(View view, long j) {
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        if (!z.r0()) {
            z.R(z.g() - j);
            return;
        }
        z.R(Math.max(z.g() - j, r6.d() + this.e.e()));
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onSessionEnded(o4.e eVar, int i) {
        Z();
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void onSessionResumeFailed(o4.e eVar, int i) {
        Z();
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onSessionResumed(o4.e eVar, boolean z) {
        a0(eVar);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void onSessionStartFailed(o4.e eVar, int i) {
        Z();
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onSessionStarted(o4.e eVar, String str) {
        a0(eVar);
    }

    public void Q(View view) {
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        z.J(null);
    }

    public void R(View view) {
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        z.K(null);
    }

    public void S(i.b bVar) {
        r.f("Must be called from the main thread.");
        this.f = bVar;
    }

    public final c T() {
        return this.e;
    }

    public final void U(ImageView imageView, p4.b bVar, View view, zzby zzbyVar) {
        r.f("Must be called from the main thread.");
        e0(imageView, new zzbz(imageView, this.a, bVar, 0, view, zzbyVar));
    }

    public final void V(CastSeekBar castSeekBar, int i, boolean z) {
        b0(i, z);
    }

    public final void W(CastSeekBar castSeekBar) {
        c0();
    }

    public final void X(CastSeekBar castSeekBar) {
        d0(castSeekBar.getProgress());
    }

    public final void Y(zzcq zzcqVar) {
        this.d.add(zzcqVar);
    }

    public final void Z() {
        if (A()) {
            this.e.a = null;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    ((a) it2.next()).onSessionEnded();
                }
            }
            r.m(this.g);
            this.g.O(this);
            this.g = null;
        }
    }

    public void a() {
        f0();
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void a0(o4.w wVar) {
        if (A() || wVar == null || !wVar.c()) {
            return;
        }
        o4.e eVar = (o4.e) wVar;
        p4.i r = eVar.r();
        this.g = r;
        if (r != null) {
            r.b(this);
            r.m(this.e);
            this.e.a = eVar.r();
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    ((a) it2.next()).onSessionConnected(eVar);
                }
            }
            f0();
        }
    }

    public void b() {
        f0();
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void b0(int i, boolean z) {
        if (z) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((zzcq) it.next()).zzb(i + this.e.e());
            }
        }
    }

    public void c() {
        f0();
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void c0() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((zzcq) it.next()).zza(false);
        }
    }

    public void d() {
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).onSendingRemoteMediaRequest();
            }
        }
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
    }

    public final void d0(int i) {
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                ((zzcq) it.next()).zza(true);
            }
        }
        p4.i z = z();
        if (z == null || !z.q()) {
            return;
        }
        long e = i + this.e.e();
        q.a aVar = new q.a();
        aVar.d(e);
        aVar.c(z.s() && this.e.n(e));
        z.T(aVar.a());
    }

    public void e() {
        f0();
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final void e0(View view, a aVar) {
        if (this.b == null) {
            return;
        }
        ArrayList arrayList = (List) this.c.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.c.put(view, arrayList);
        }
        arrayList.add(aVar);
        if (A()) {
            aVar.onSessionConnected((o4.e) r.m(this.b.c()));
            f0();
        }
    }

    public void f() {
        f0();
        i.b bVar = this.f;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void f0() {
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).onMediaStatusUpdated();
            }
        }
    }

    public void g(ImageView imageView, p4.b bVar, int i) {
        r.f("Must be called from the main thread.");
        e0(imageView, new zzbz(imageView, this.a, bVar, i, null, null));
    }

    public void h(ImageView imageView) {
        r.f("Must be called from the main thread.");
        imageView.setOnClickListener(new d(this));
        e0(imageView, new zzcf(imageView, this.a));
    }

    public void i(ImageView imageView, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z) {
        r.f("Must be called from the main thread.");
        zzr.zzd(zzln.PAUSE_CONTROLLER);
        imageView.setOnClickListener(new e(this));
        e0(imageView, new zzcg(imageView, this.a, drawable, drawable2, drawable3, view, z));
    }

    public void j(ProgressBar progressBar) {
        k(progressBar, 1000L);
    }

    public void k(ProgressBar progressBar, long j) {
        r.f("Must be called from the main thread.");
        e0(progressBar, new zzch(progressBar, j));
    }

    public void l(CastSeekBar castSeekBar, long j) {
        r.f("Must be called from the main thread.");
        zzr.zzd(zzln.SEEK_CONTROLLER);
        castSeekBar.g = new j(this);
        e0(castSeekBar, new zzbs(castSeekBar, j, this.e));
    }

    public void m(TextView textView, String str) {
        r.f("Must be called from the main thread.");
        n(textView, Collections.singletonList(str));
    }

    public void n(TextView textView, List list) {
        r.f("Must be called from the main thread.");
        e0(textView, new zzcd(textView, list));
    }

    public void o(TextView textView) {
        r.f("Must be called from the main thread.");
        e0(textView, new zzcn(textView));
    }

    public void p(View view) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new l(this));
        e0(view, new zzbt(view, this.a));
    }

    public void q(View view, long j) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new h(this, j));
        e0(view, new zzbu(view, this.e));
    }

    public void r(View view) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new k(this));
        e0(view, new zzca(view));
    }

    public void s(View view) {
        r.f("Must be called from the main thread.");
        e0(view, new zzcb(view));
    }

    public void t(View view, long j) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new i(this, j));
        e0(view, new zzci(view, this.e));
    }

    public void u(View view, int i) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new f(this));
        e0(view, new zzcl(view, i));
    }

    public void v(View view, int i) {
        r.f("Must be called from the main thread.");
        view.setOnClickListener(new g(this));
        e0(view, new zzcm(view, i));
    }

    public void w(View view, a aVar) {
        r.f("Must be called from the main thread.");
        e0(view, aVar);
    }

    public void x(View view, int i) {
        r.f("Must be called from the main thread.");
        e0(view, new zzcs(view, i));
    }

    public void y() {
        r.f("Must be called from the main thread.");
        Z();
        this.c.clear();
        x xVar = this.b;
        if (xVar != null) {
            xVar.e(this, o4.e.class);
        }
        this.f = null;
    }

    public p4.i z() {
        r.f("Must be called from the main thread.");
        return this.g;
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onSessionEnding(o4.e eVar) {
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onSessionStarting(o4.e eVar) {
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onSessionResuming(o4.e eVar, String str) {
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onSessionSuspended(o4.e eVar, int i) {
    }
}
