package O2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i {
    public final AudioManager a;
    public final a b;
    public b c;
    public Q2.e d;
    public int f;
    public AudioFocusRequest h;
    public boolean i;
    public float g = 1.0f;
    public int e = 0;

    public class a implements AudioManager.OnAudioFocusChangeListener {
        public final Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        public static /* synthetic */ void a(a aVar, int i) {
            aVar.b(i);
        }

        public final /* synthetic */ void b(int i) {
            i.d(i.this, i);
        }

        public void onAudioFocusChange(int i) {
            this.a.post(new h(this, i));
        }
    }

    public interface b {
        void F(float f);

        void G(int i);
    }

    public i(Context context, Handler handler, b bVar) {
        this.a = (AudioManager) d4.a.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.c = bVar;
        this.b = new a(handler);
    }

    public static /* synthetic */ void d(i iVar, int i) {
        iVar.h(i);
    }

    public static int e(Q2.e eVar) {
        if (eVar == null) {
            return 0;
        }
        switch (eVar.d) {
            case 0:
                d4.B.j("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (eVar.a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                d4.B.j("AudioFocusManager", "Unidentified audio usage: " + eVar.d);
                return 0;
            case 16:
                return d4.k0.a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.a.abandonAudioFocus(this.b);
    }

    public final void b() {
        if (this.e == 0) {
            return;
        }
        if (d4.k0.a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    public final void c() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            com.google.ads.interactivemedia.v3.internal.U.a(this.a, audioFocusRequest);
        }
    }

    public final void f(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.G(i);
        }
    }

    public float g() {
        return this.g;
    }

    public final void h(int i) {
        int i2;
        if (i == -3 || i == -2) {
            if (i == -2 || q()) {
                f(0);
                i2 = 2;
            } else {
                i2 = 3;
            }
            n(i2);
            return;
        }
        if (i == -1) {
            f(-1);
            b();
        } else if (i == 1) {
            n(1);
            f(1);
        } else {
            d4.B.j("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }

    public void i() {
        this.c = null;
        b();
    }

    public final int j() {
        if (this.e == 1) {
            return 1;
        }
        if ((d4.k0.a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.a.requestAudioFocus(this.b, d4.k0.l0(((Q2.e) d4.a.e(this.d)).d), this.f);
    }

    public final int l() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest == null || this.i) {
            com.google.ads.interactivemedia.v3.internal.W.a();
            this.h = g.a(f.a(e.a(d.a(audioFocusRequest == null ? com.google.ads.interactivemedia.v3.internal.V.a(this.f) : c.a(this.h), ((Q2.e) d4.a.e(this.d)).b().a), q()), this.b));
            this.i = false;
        }
        return com.google.ads.interactivemedia.v3.internal.T.a(this.a, this.h);
    }

    public void m(Q2.e eVar) {
        if (d4.k0.c(this.d, eVar)) {
            return;
        }
        this.d = eVar;
        int e = e(eVar);
        this.f = e;
        boolean z = true;
        if (e != 1 && e != 0) {
            z = false;
        }
        d4.a.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            bVar.F(f);
        }
    }

    public final boolean o(int i) {
        return i == 1 || this.f != 1;
    }

    public int p(boolean z, int i) {
        if (o(i)) {
            b();
            return z ? 1 : -1;
        }
        if (z) {
            return j();
        }
        return -1;
    }

    public final boolean q() {
        Q2.e eVar = this.d;
        return eVar != null && eVar.a == 1;
    }
}
