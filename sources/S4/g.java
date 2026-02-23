package S4;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g {
    public long a;
    public long b;
    public TimeInterpolator c;
    public int d;
    public int e;

    public g(long j, long j2) {
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.b = j2;
    }

    public static g b(ValueAnimator valueAnimator) {
        g gVar = new g(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        gVar.d = valueAnimator.getRepeatCount();
        gVar.e = valueAnimator.getRepeatMode();
        return gVar;
    }

    public static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.b : interpolator instanceof AccelerateInterpolator ? a.c : interpolator instanceof DecelerateInterpolator ? a.d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (c() == gVar.c() && d() == gVar.d() && g() == gVar.g() && h() == gVar.h()) {
            return e().getClass().equals(gVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public g(long j, long j2, TimeInterpolator timeInterpolator) {
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.b = j2;
        this.c = timeInterpolator;
    }
}
