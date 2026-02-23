package androidx.preference;

import F.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import s.i;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final i E;
    public final Handler F;
    public final List G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public final Runnable L;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            synchronized (this) {
                PreferenceGroup.this.E.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Preference M(int i) {
        return (Preference) this.G.get(i);
    }

    public int N() {
        return this.G.size();
    }

    public void O(int i) {
        if (i != Integer.MAX_VALUE && !v()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.K = i;
    }

    public void z(boolean z) {
        super.z(z);
        int N = N();
        for (int i = 0; i < N; i++) {
            M(i).D(this, z);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.E = new i();
        this.F = new Handler(Looper.getMainLooper());
        this.H = true;
        this.I = 0;
        this.J = false;
        this.K = Integer.MAX_VALUE;
        this.L = new a();
        this.G = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.v0, i, i2);
        int i3 = g.x0;
        this.H = k.b(obtainStyledAttributes, i3, i3, true);
        if (obtainStyledAttributes.hasValue(g.w0)) {
            int i4 = g.w0;
            O(k.d(obtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }
}
