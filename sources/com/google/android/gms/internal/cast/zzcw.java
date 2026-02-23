package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import o4.e;
import o4.m;
import o4.q;
import o4.u;
import o4.v;
import p4.i;
import r4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcw extends zzcq {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final c zzd;

    public zzcw(RelativeLayout relativeLayout, CastSeekBar castSeekBar, c cVar) {
        this.zza = relativeLayout;
        TextView findViewById = relativeLayout.findViewById(q.f0);
        this.zzb = findViewById;
        this.zzc = castSeekBar;
        this.zzd = cVar;
        TypedArray obtainStyledAttributes = findViewById.getContext().obtainStyledAttributes((AttributeSet) null, v.b, m.a, u.a);
        int resourceId = obtainStyledAttributes.getResourceId(v.w, 0);
        obtainStyledAttributes.recycle();
        findViewById.getBackground().setColorFilter(findViewById.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    public final void onMediaStatusUpdated() {
        zzd();
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        zzd();
    }

    public final void onSessionEnded() {
        super.onSessionEnded();
        zzd();
    }

    public final void zza(boolean z) {
        super.zza(z);
        zzd();
    }

    public final void zzb(long j) {
        zzd();
    }

    public final void zzd() {
        i remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.q() || zzc()) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
        TextView textView = this.zzb;
        c cVar = this.zzd;
        textView.setText(cVar.l(this.zzc.getProgress() + cVar.e()));
        int measuredWidth = (this.zzc.getMeasuredWidth() - this.zzc.getPaddingLeft()) - this.zzc.getPaddingRight();
        this.zzb.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth2 = this.zzb.getMeasuredWidth();
        int min = Math.min(Math.max(0, ((int) ((this.zzc.getProgress() / this.zzc.getMaxProgress()) * measuredWidth)) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = this.zzb.getLayoutParams();
        layoutParams.leftMargin = min;
        this.zzb.setLayoutParams(layoutParams);
    }
}
