package q4;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzdx;
import com.google.android.gms.internal.cast.zzdy;
import java.util.List;
import p4.X;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w {
    public static final t4.b w = new t4.b("MediaSessionManager");
    public final Context a;
    public final o4.c b;
    public final zzbf c;
    public final o4.x d;
    public final p4.h e;
    public final ComponentName f;
    public final ComponentName g;
    public final b h;
    public final b i;
    public final p j;
    public final Handler k;
    public final Runnable l;
    public final i.a m;
    public p4.i n;
    public CastDevice o;
    public MediaSessionCompat p;
    public MediaSessionCompat.Callback q;
    public boolean r;
    public PlaybackStateCompat.CustomAction s;
    public PlaybackStateCompat.CustomAction t;
    public PlaybackStateCompat.CustomAction u;
    public PlaybackStateCompat.CustomAction v;

    public w(Context context, o4.c cVar, zzbf zzbfVar) {
        this.a = context;
        this.b = cVar;
        this.c = zzbfVar;
        o4.b d = o4.b.d();
        this.d = d != null ? d.c() : null;
        p4.a H = cVar.H();
        this.e = H == null ? null : H.L();
        this.m = new v(this, null);
        CharSequence H2 = H == null ? null : H.H();
        this.f = !TextUtils.isEmpty(H2) ? new ComponentName(context, H2) : null;
        CharSequence J = H == null ? null : H.J();
        this.g = !TextUtils.isEmpty(J) ? new ComponentName(context, J) : null;
        b bVar = new b(context);
        this.h = bVar;
        bVar.c(new r(this));
        b bVar2 = new b(context);
        this.i = bVar2;
        bVar2.c(new s(this));
        this.k = new zzdy(Looper.getMainLooper());
        this.j = p.e(cVar) ? new p(context) : null;
        this.l = new q(this);
    }

    public static /* bridge */ /* synthetic */ ComponentName a(w wVar) {
        return wVar.g;
    }

    public static /* bridge */ /* synthetic */ Context b(w wVar) {
        return wVar.a;
    }

    public static /* bridge */ /* synthetic */ o4.x c(w wVar) {
        return wVar.d;
    }

    public static /* bridge */ /* synthetic */ p4.h d(w wVar) {
        return wVar.e;
    }

    public static /* bridge */ /* synthetic */ p4.i e(w wVar) {
        return wVar.n;
    }

    public static /* bridge */ /* synthetic */ t4.b f() {
        return w;
    }

    public static /* bridge */ /* synthetic */ void g(w wVar, Bitmap bitmap, int i) {
        wVar.p(bitmap, i);
    }

    public static final boolean v(String str) {
        return TextUtils.equals(str, "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK") || TextUtils.equals(str, "com.google.android.gms.cast.framework.action.SKIP_PREV") || TextUtils.equals(str, "com.google.android.gms.cast.framework.action.SKIP_NEXT");
    }

    public final void h(p4.i iVar, CastDevice castDevice) {
        AudioManager audioManager;
        o4.c cVar = this.b;
        p4.a H = cVar == null ? null : cVar.H();
        if (this.r || this.b == null || H == null || this.e == null || iVar == null || castDevice == null || this.g == null) {
            w.a("skip attaching media session", new Object[0]);
            return;
        }
        this.n = iVar;
        iVar.N(this.m);
        this.o = castDevice;
        if (!C4.m.f() && (audioManager = (AudioManager) this.a.getSystemService("audio")) != null) {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 3);
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(this.g);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.a, 0, intent, zzdx.zza);
        if (H.K()) {
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this.a, "CastMediaSession", this.g, broadcast);
            this.p = mediaSessionCompat;
            u(0, null);
            CastDevice castDevice2 = this.o;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.J())) {
                mediaSessionCompat.setMetadata(new MediaMetadataCompat.Builder().putString("android.media.metadata.ALBUM_ARTIST", this.a.getResources().getString(o4.t.b, new Object[]{this.o.J()})).build());
            }
            t tVar = new t(this);
            this.q = tVar;
            mediaSessionCompat.setCallback(tVar);
            mediaSessionCompat.setActive(true);
            this.c.zzr(mediaSessionCompat);
        }
        this.r = true;
        l(false);
    }

    public final void i(int i) {
        AudioManager audioManager;
        if (this.r) {
            this.r = false;
            p4.i iVar = this.n;
            if (iVar != null) {
                iVar.X(this.m);
            }
            if (!C4.m.f() && (audioManager = (AudioManager) this.a.getSystemService("audio")) != null) {
                audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            this.c.zzr(null);
            b bVar = this.h;
            if (bVar != null) {
                bVar.a();
            }
            b bVar2 = this.i;
            if (bVar2 != null) {
                bVar2.a();
            }
            MediaSessionCompat mediaSessionCompat = this.p;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setCallback((MediaSessionCompat.Callback) null);
                this.p.setMetadata(new MediaMetadataCompat.Builder().build());
                u(0, null);
            }
            MediaSessionCompat mediaSessionCompat2 = this.p;
            if (mediaSessionCompat2 != null) {
                mediaSessionCompat2.setActive(false);
                this.p.release();
                this.p = null;
            }
            this.n = null;
            this.o = null;
            this.q = null;
            s();
            if (i == 0) {
                t();
            }
        }
    }

    public final /* synthetic */ void j() {
        r(false);
    }

    public final void k(CastDevice castDevice) {
        w.e("update Cast device to %s", castDevice);
        this.o = castDevice;
        l(false);
    }

    public final void l(boolean z) {
        n4.p i;
        p4.i iVar = this.n;
        if (iVar == null) {
            return;
        }
        int Y = iVar.Y();
        MediaInfo j = iVar.j();
        if (iVar.t() && (i = iVar.i()) != null && i.L() != null) {
            j = i.L();
        }
        u(Y, j);
        if (!iVar.q()) {
            s();
            t();
        } else if (Y != 0) {
            p pVar = this.j;
            if (pVar != null) {
                w.a("Update media notification.", new Object[0]);
                pVar.d(this.o, this.n, this.p, z);
            }
            if (iVar.t()) {
                return;
            }
            r(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m(java.lang.String r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -945151566(0xffffffffc7aa21b2, float:-87107.39)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = -945080078(0xffffffffc7ab38f2, float:-87665.89)
            if (r0 == r1) goto L20
            r1 = 235550565(0xe0a3765, float:1.7036485E-30)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L20:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 1
            goto L35
        L2a:
            java.lang.String r0 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 2
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L61
            r0 = 0
            if (r5 == r3) goto L51
            if (r5 == r2) goto L3e
            goto L6d
        L3e:
            p4.i r5 = r4.n
            if (r5 == 0) goto L4b
            boolean r5 = r5.o0()
            if (r5 == 0) goto L4b
            r0 = 32
            goto L6d
        L4b:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT"
        L4d:
            r7.putBoolean(r5, r3)
            return r0
        L51:
            p4.i r5 = r4.n
            if (r5 == 0) goto L5e
            boolean r5 = r5.p0()
            if (r5 == 0) goto L5e
            r0 = 16
            goto L6d
        L5e:
            java.lang.String r5 = "android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS"
            goto L4d
        L61:
            r5 = 3
            if (r6 != r5) goto L69
            r6 = 514(0x202, double:2.54E-321)
            r0 = r6
            r6 = 3
            goto L6b
        L69:
            r0 = 512(0x200, double:2.53E-321)
        L6b:
            if (r6 == r2) goto L6e
        L6d:
            return r0
        L6e:
            r5 = 516(0x204, double:2.55E-321)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.w.m(java.lang.String, int, android.os.Bundle):long");
    }

    public final Uri n(n4.m mVar, int i) {
        p4.a H = this.b.H();
        if (H != null) {
            H.I();
        }
        x4.a aVar = mVar.L() ? (x4.a) mVar.H().get(0) : null;
        if (aVar == null) {
            return null;
        }
        return aVar.H();
    }

    public final MediaMetadataCompat.Builder o() {
        MediaSessionCompat mediaSessionCompat = this.p;
        MediaMetadataCompat metadata = mediaSessionCompat == null ? null : mediaSessionCompat.getController().getMetadata();
        return metadata == null ? new MediaMetadataCompat.Builder() : new MediaMetadataCompat.Builder(metadata);
    }

    public final void p(Bitmap bitmap, int i) {
        MediaSessionCompat mediaSessionCompat = this.p;
        if (mediaSessionCompat == null) {
            return;
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(0);
        }
        mediaSessionCompat.setMetadata(o().putBitmap(i == 0 ? "android.media.metadata.DISPLAY_ICON" : "android.media.metadata.ALBUM_ART", bitmap).build());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(android.support.v4.media.session.PlaybackStateCompat.Builder r9, java.lang.String r10, p4.f r11) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.w.q(android.support.v4.media.session.PlaybackStateCompat$Builder, java.lang.String, p4.f):void");
    }

    public final void r(boolean z) {
        if (this.b.I()) {
            Runnable runnable = this.l;
            if (runnable != null) {
                this.k.removeCallbacks(runnable);
            }
            Intent intent = new Intent(this.a, ReconnectionService.class);
            intent.setPackage(this.a.getPackageName());
            try {
                this.a.startService(intent);
            } catch (IllegalStateException unused) {
                if (z) {
                    this.k.postDelayed(this.l, 1000L);
                }
            }
        }
    }

    public final void s() {
        p pVar = this.j;
        if (pVar != null) {
            w.a("Stopping media notification.", new Object[0]);
            pVar.c();
        }
    }

    public final void t() {
        if (this.b.I()) {
            this.k.removeCallbacks(this.l);
            Intent intent = new Intent(this.a, ReconnectionService.class);
            intent.setPackage(this.a.getPackageName());
            this.a.stopService(intent);
        }
    }

    public final void u(int i, MediaInfo mediaInfo) {
        MediaSessionCompat mediaSessionCompat;
        n4.m Q;
        PendingIntent activity;
        MediaSessionCompat mediaSessionCompat2 = this.p;
        if (mediaSessionCompat2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        p4.i iVar = this.n;
        if (iVar != null && this.j != null) {
            builder.setState(i, (iVar.Y() == 0 || iVar.s()) ? 0L : iVar.g(), 1.0f);
            if (i != 0) {
                p4.h hVar = this.e;
                X m0 = hVar != null ? hVar.m0() : null;
                p4.i iVar2 = this.n;
                long j = (iVar2 == null || iVar2.s() || this.n.w()) ? 0L : 256L;
                if (m0 != null) {
                    List<p4.f> f = x.f(m0);
                    if (f != null) {
                        for (p4.f fVar : f) {
                            String H = fVar.H();
                            if (v(H)) {
                                j |= m(H, i, bundle);
                            } else {
                                q(builder, H, fVar);
                            }
                        }
                    }
                } else {
                    p4.h hVar2 = this.e;
                    if (hVar2 != null) {
                        for (String str : hVar2.H()) {
                            if (v(str)) {
                                j |= m(str, i, bundle);
                            } else {
                                q(builder, str, null);
                            }
                        }
                    }
                }
                builder = builder.setActions(j);
            }
        }
        mediaSessionCompat2.setPlaybackState(builder.build());
        p4.h hVar3 = this.e;
        if (hVar3 != null && hVar3.p0()) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        }
        p4.h hVar4 = this.e;
        if (hVar4 != null && hVar4.o0()) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        }
        if (bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
            mediaSessionCompat2.setExtras(bundle);
        }
        if (i == 0) {
            mediaSessionCompat2.setMetadata(new MediaMetadataCompat.Builder().build());
            return;
        }
        if (this.n != null) {
            if (this.f == null) {
                activity = null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(this.f);
                activity = PendingIntent.getActivity(this.a, 0, intent, zzdx.zza | 134217728);
            }
            if (activity != null) {
                mediaSessionCompat2.setSessionActivity(activity);
            }
        }
        if (this.n == null || (mediaSessionCompat = this.p) == null || mediaInfo == null || (Q = mediaInfo.Q()) == null) {
            return;
        }
        p4.i iVar3 = this.n;
        long S = (iVar3 == null || !iVar3.s()) ? mediaInfo.S() : 0L;
        String J = Q.J("com.google.android.gms.cast.metadata.TITLE");
        String J2 = Q.J("com.google.android.gms.cast.metadata.SUBTITLE");
        MediaMetadataCompat.Builder putLong = o().putLong("android.media.metadata.DURATION", S);
        if (J != null) {
            putLong.putString("android.media.metadata.TITLE", J);
            putLong.putString("android.media.metadata.DISPLAY_TITLE", J);
        }
        if (J2 != null) {
            putLong.putString("android.media.metadata.DISPLAY_SUBTITLE", J2);
        }
        mediaSessionCompat.setMetadata(putLong.build());
        Uri n = n(Q, 0);
        if (n != null) {
            this.h.d(n);
        } else {
            p(null, 0);
        }
        Uri n2 = n(Q, 3);
        if (n2 != null) {
            this.i.d(n2);
        } else {
            p(null, 3);
        }
    }
}
