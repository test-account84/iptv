package q0;

import android.media.VolumeProvider;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k {
    public final int a;
    public final int b;
    public final String c;
    public int d;
    public d e;
    public VolumeProvider f;

    public class a extends VolumeProvider {
        public a(int i, int i2, int i3, String str) {
            super(i, i2, i3, str);
        }

        public void onAdjustVolume(int i) {
            k.this.e(i);
        }

        public void onSetVolumeTo(int i) {
            k.this.f(i);
        }
    }

    public class b extends VolumeProvider {
        public b(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public void onAdjustVolume(int i) {
            k.this.e(i);
        }

        public void onSetVolumeTo(int i) {
            k.this.f(i);
        }
    }

    public static class c {
        public static void a(VolumeProvider volumeProvider, int i) {
            volumeProvider.setCurrentVolume(i);
        }
    }

    public static abstract class d {
        public abstract void onVolumeChanged(k kVar);
    }

    public k(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = str;
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public Object d() {
        if (this.f == null) {
            this.f = Build.VERSION.SDK_INT >= 30 ? new a(this.a, this.b, this.d, this.c) : new b(this.a, this.b, this.d);
        }
        return this.f;
    }

    public abstract void e(int i);

    public abstract void f(int i);

    public void g(d dVar) {
        this.e = dVar;
    }

    public final void h(int i) {
        this.d = i;
        c.a((VolumeProvider) d(), i);
        d dVar = this.e;
        if (dVar != null) {
            dVar.onVolumeChanged(this);
        }
    }
}
