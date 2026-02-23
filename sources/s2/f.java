package s2;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends RecyclerView.D {
    public ShimmerLayout t;

    public f(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(layoutInflater.inflate(b.b, viewGroup, false));
        ShimmerLayout shimmerLayout = this.a;
        this.t = shimmerLayout;
        layoutInflater.inflate(i, shimmerLayout, true);
    }

    public void P() {
        this.t.n();
    }

    public void Q(boolean z) {
        this.t.setAnimationReversed(z);
    }

    public final void R(Drawable drawable) {
        this.t.setBackground(drawable);
    }

    public void S(int i) {
        this.t.setShimmerAngle(i);
    }

    public void T(int i) {
        this.t.setShimmerAnimationDuration(i);
    }

    public void U(int i) {
        this.t.setShimmerColor(i);
    }

    public void V(Drawable drawable) {
        if (drawable != null) {
            R(drawable);
        }
    }
}
