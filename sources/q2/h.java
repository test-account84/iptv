package Q2;

import O2.z0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import com.google.ads.interactivemedia.v3.internal.b1;
import java.util.Arrays;
import s5.A;
import s5.C;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h {
    public static final h c = new h(new int[]{2}, 10);
    public static final s5.y d = s5.y.D(2, 5, 6);
    public static final s5.A e = new A.a().f(5, 6).f(17, 6).f(7, 6).f(30, 10).f(18, 6).f(6, 8).f(8, 8).f(14, 8).c();
    public final int[] a;
    public final int b;

    public static final class a {
        private static final s5.C a() {
            C.a i = new C.a().i(8, 7);
            int i2 = d4.k0.a;
            if (i2 >= 31) {
                i.i(26, 27);
            }
            if (i2 >= 33) {
                i.a(30);
            }
            return i.l();
        }

        public static final boolean b(Context context) {
            AudioDeviceInfo[] a = f.a((AudioManager) d4.a.e((AudioManager) context.getSystemService("audio")), 2);
            s5.C a2 = a();
            for (AudioDeviceInfo audioDeviceInfo : a) {
                if (a2.contains(Integer.valueOf(g.a(audioDeviceInfo)))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b {
        public static final AudioAttributes a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        public static s5.y a() {
            y.a p = s5.y.p();
            s5.c0 l = h.a().keySet().l();
            while (l.hasNext()) {
                Integer num = (Integer) l.next();
                int intValue = num.intValue();
                if (d4.k0.a >= 34 || intValue != 30) {
                    if (b1.a(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), a)) {
                        p.a(num);
                    }
                }
            }
            p.a(2);
            return p.k();
        }

        public static int b(int i, int i2) {
            for (int i3 = 10; i3 > 0; i3--) {
                if (b1.a(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(d4.k0.I(i3)).build(), a)) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public h(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.a = new int[0];
        }
        this.b = i;
    }

    public static /* synthetic */ s5.A a() {
        return e;
    }

    public static boolean b() {
        if (d4.k0.a >= 17) {
            String str = d4.k0.c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static h c(Context context) {
        return d(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public static h d(Context context, Intent intent) {
        int i = d4.k0.a;
        if (i >= 23 && a.b(context)) {
            return c;
        }
        C.a aVar = new C.a();
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            aVar.j(d);
        }
        if (i >= 29 && (d4.k0.I0(context) || d4.k0.B0(context))) {
            aVar.j(b.a());
            return new h(w5.f.l(aVar.l()), 10);
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            s5.C l = aVar.l();
            return !l.isEmpty() ? new h(w5.f.l(l), 10) : c;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            aVar.j(w5.f.c(intArrayExtra));
        }
        return new h(w5.f.l(aVar.l()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10));
    }

    public static int e(int i) {
        int i2 = d4.k0.a;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(d4.k0.b) && i == 1) {
            i = 2;
        }
        return d4.k0.I(i);
    }

    public static Uri g() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static int h(int i, int i2) {
        return d4.k0.a >= 29 ? b.b(i, i2) : ((Integer) d4.a.e((Integer) e.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Arrays.equals(this.a, hVar.a) && this.b == hVar.b;
    }

    public Pair f(z0 z0Var) {
        int f = d4.F.f((String) d4.a.e(z0Var.m), z0Var.j);
        if (!e.containsKey(Integer.valueOf(f))) {
            return null;
        }
        if (f == 18 && !j(18)) {
            f = 6;
        } else if ((f == 8 && !j(8)) || (f == 30 && !j(30))) {
            f = 7;
        }
        if (!j(f)) {
            return null;
        }
        int i = z0Var.z;
        if (i == -1 || f == 18) {
            int i2 = z0Var.A;
            if (i2 == -1) {
                i2 = 48000;
            }
            i = h(f, i2);
        } else if (z0Var.m.equals("audio/vnd.dts.uhd;profile=p2")) {
            if (i > 10) {
                return null;
            }
        } else if (i > this.b) {
            return null;
        }
        int e2 = e(i);
        if (e2 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f), Integer.valueOf(e2));
    }

    public int hashCode() {
        return this.b + (Arrays.hashCode(this.a) * 31);
    }

    public boolean i(z0 z0Var) {
        return f(z0Var) != null;
    }

    public boolean j(int i) {
        return Arrays.binarySearch(this.a, i) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.a) + "]";
    }
}
