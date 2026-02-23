package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.internal.featurehighlight.HelpTextView;
import o4.g;
import o4.h;
import o4.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzar extends RelativeLayout {
    private final boolean zza;
    private Activity zzb;
    private h zzc;
    private View zzd;
    private String zze;
    private boolean zzf;
    private int zzg;

    public zzar(g gVar) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ h zza(zzar zzarVar) {
        zzarVar.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzar zzarVar) {
        zzarVar.zzd();
    }

    public static /* bridge */ /* synthetic */ boolean zzc(zzar zzarVar) {
        return zzarVar.zzf;
    }

    private final void zzd() {
        removeAllViews();
        this.zzb = null;
        this.zzd = null;
        this.zze = null;
        this.zzg = 0;
        this.zzf = false;
    }

    public final void remove() {
        Activity activity;
        if (!this.zzf || (activity = this.zzb) == null) {
            return;
        }
        activity.getWindow().getDecorView().removeView(this);
        zzd();
    }

    public final void show() {
        View view;
        Activity activity = this.zzb;
        if (activity == null || (view = this.zzd) == null || this.zzf) {
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) activity.getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        if (this.zza && PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("googlecast-introOverlayShown", false)) {
            zzd();
            return;
        }
        com.google.android.gms.cast.framework.internal.featurehighlight.h hVar = new com.google.android.gms.cast.framework.internal.featurehighlight.h(activity);
        int i = this.zzg;
        if (i != 0) {
            hVar.j(i);
        }
        addView(hVar);
        HelpTextView helpTextView = (HelpTextView) activity.getLayoutInflater().inflate(s.c, hVar, false);
        helpTextView.setText(this.zze, null);
        hVar.n(helpTextView);
        hVar.i(view, null, true, new zzaq(this, activity, hVar));
        this.zzf = true;
        activity.getWindow().getDecorView().addView(this);
        hVar.l(null);
    }
}
