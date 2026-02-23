package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.mediarouter.app.a;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o4.q;
import o4.s;
import o4.t;
import t0.f;
import t4.b;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzy extends a implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final b zzh = new b("DeviceChooserDialog");
    TextView zza;
    ListView zzb;
    View zzc;
    LinearLayout zzd;
    LinearLayout zze;
    LinearLayout zzf;
    RelativeLayout zzg;
    private final zzw zzi;
    private final List zzj;
    private final long zzk;
    private final boolean zzl;
    private L zzm;
    private zzdy zzn;
    private K zzo;
    private ArrayAdapter zzp;
    private boolean zzq;
    private Runnable zzr;
    private L.h zzs;

    public zzy(Context context, int i) {
        super(context, 0);
        this.zzj = new CopyOnWriteArrayList();
        this.zzo = K.c;
        this.zzi = new zzw(this);
        this.zzk = zzac.zza();
        this.zzl = zzac.zzc();
    }

    public static /* bridge */ /* synthetic */ List zza(zzy zzyVar) {
        return zzyVar.zzj;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzy zzyVar, L.h hVar) {
        zzyVar.zzs = hVar;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzy zzyVar) {
        zzyVar.zzf();
    }

    private final void zzf() {
        L l = this.zzm;
        if (l != null) {
            List arrayList = new ArrayList(l.m());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, zzx.zza);
            Iterator it = this.zzj.iterator();
            while (it.hasNext()) {
                ((zzv) it.next()).zza(arrayList);
            }
        }
    }

    private final void zzg() {
        b bVar = zzh;
        bVar.a("startDiscovery", new Object[0]);
        L l = this.zzm;
        if (l == null) {
            bVar.a("Can't start discovery. setUpMediaRouter needs to be called first", new Object[0]);
            return;
        }
        l.b(this.zzo, this.zzi, 1);
        Iterator it = this.zzj.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zzc(1);
        }
    }

    private final void zzh() {
        b bVar = zzh;
        bVar.a("stopDiscovery", new Object[0]);
        L l = this.zzm;
        if (l == null) {
            bVar.a("Can't stop discovery. setUpMediaRouter needs to be called first", new Object[0]);
            return;
        }
        l.s(this.zzi);
        this.zzm.b(this.zzo, this.zzi, 0);
        Iterator it = this.zzj.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zzd();
        }
    }

    private final void zzi(int i) {
        if (this.zzd == null || this.zze == null || this.zzf == null || this.zzg == null) {
            return;
        }
        o4.b d = o4.b.d();
        if (this.zzl && d != null && !d.k().zza()) {
            i = 3;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            setTitle(t.e);
            ((LinearLayout) r.m(this.zzd)).setVisibility(0);
            ((LinearLayout) r.m(this.zze)).setVisibility(8);
            ((LinearLayout) r.m(this.zzf)).setVisibility(8);
            ((RelativeLayout) r.m(this.zzg)).setVisibility(8);
            return;
        }
        if (i2 != 1) {
            setTitle(t.E);
            ((LinearLayout) r.m(this.zzd)).setVisibility(8);
            ((LinearLayout) r.m(this.zze)).setVisibility(8);
            ((LinearLayout) r.m(this.zzf)).setVisibility(0);
            ((RelativeLayout) r.m(this.zzg)).setVisibility(0);
            return;
        }
        setTitle(t.e);
        ((LinearLayout) r.m(this.zzd)).setVisibility(8);
        ((LinearLayout) r.m(this.zze)).setVisibility(0);
        ((LinearLayout) r.m(this.zzf)).setVisibility(8);
        ((RelativeLayout) r.m(this.zzg)).setVisibility(0);
    }

    public final void dismiss() {
        super/*d.u*/.dismiss();
        zzdy zzdyVar = this.zzn;
        if (zzdyVar != null) {
            zzdyVar.removeCallbacks(this.zzr);
        }
        View view = this.zzc;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        Iterator it = this.zzj.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zzb(this.zzs);
        }
        this.zzj.clear();
    }

    public final K getRouteSelector() {
        return this.zzo;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zzq = true;
        zzg();
        zzf();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ListView findViewById = super/*d.u*/.findViewById(f.u);
        if (findViewById == null) {
            return;
        }
        setContentView(s.a);
        this.zzp = findViewById.getAdapter();
        ListView findViewById2 = findViewById(q.A);
        this.zzb = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setAdapter(this.zzp);
            this.zzb.setOnItemClickListener(findViewById.getOnItemClickListener());
        }
        this.zza = findViewById(q.C);
        this.zzd = findViewById(q.B);
        this.zze = findViewById(q.F);
        this.zzf = findViewById(q.D);
        this.zzg = findViewById(q.O);
        TextView findViewById3 = findViewById(q.z);
        TextView findViewById4 = findViewById(q.E);
        zzt zztVar = new zzt(this);
        if (findViewById3 != null) {
            findViewById3.setMovementMethod(LinkMovementMethod.getInstance());
            findViewById3.setOnClickListener(zztVar);
        }
        if (findViewById4 != null) {
            findViewById4.setMovementMethod(LinkMovementMethod.getInstance());
            findViewById4.setOnClickListener(zztVar);
        }
        Button findViewById5 = findViewById(q.L);
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new zzu(this));
        }
        View findViewById6 = findViewById(16908292);
        this.zzc = findViewById6;
        if (this.zzb != null && findViewById6 != null) {
            ((View) r.m(findViewById6)).getViewTreeObserver().addOnGlobalLayoutListener(this);
            ((ListView) r.m(this.zzb)).setEmptyView((View) r.m(this.zzc));
        }
        this.zzr = new zzs(this);
    }

    public final void onDetachedFromWindow() {
        this.zzq = false;
        super.onDetachedFromWindow();
        zzh();
    }

    public final void onGlobalLayout() {
        View view = this.zzc;
        if (view == null) {
            return;
        }
        Object tag = view.getTag();
        int visibility = this.zzc.getVisibility();
        if (tag == null || ((Integer) tag).intValue() != visibility) {
            if (visibility == 0) {
                zzi(1);
                zzdy zzdyVar = this.zzn;
                if (zzdyVar != null) {
                    zzdyVar.removeCallbacks(this.zzr);
                    this.zzn.postDelayed(this.zzr, this.zzk);
                }
            } else {
                setTitle(t.e);
            }
            ((View) r.m(this.zzc)).setTag(Integer.valueOf(visibility));
        }
    }

    public final void refreshRoutes() {
        super.refreshRoutes();
        zzf();
    }

    public final void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        super.setRouteSelector(k);
        if (this.zzo.equals(k)) {
            return;
        }
        this.zzo = k;
        zzh();
        if (this.zzq) {
            zzg();
        }
        zzf();
    }

    public final void setTitle(int i) {
        TextView textView = this.zza;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public final /* synthetic */ void zzd() {
        zzi(2);
        for (zzv zzvVar : this.zzj) {
        }
    }

    public final void zze() {
        this.zzm = L.j(getContext());
        this.zzn = new zzdy(Looper.getMainLooper());
        zzv zza = zzp.zza();
        if (zza != null) {
            this.zzj.add(zza);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        TextView textView = this.zza;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
