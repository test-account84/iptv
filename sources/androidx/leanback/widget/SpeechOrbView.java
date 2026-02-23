package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.leanback.widget.SearchOrbView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SpeechOrbView extends SearchOrbView {
    public final float t;
    public SearchOrbView.c u;
    public SearchOrbView.c v;
    public int w;
    public boolean x;

    public SpeechOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void f() {
        setOrbColors(this.u);
        setOrbIcon(getResources().getDrawable(g0.d.c));
        a(true);
        b(false);
        c(1.0f);
        this.w = 0;
        this.x = true;
    }

    public void g() {
        setOrbColors(this.v);
        setOrbIcon(getResources().getDrawable(g0.d.d));
        a(hasFocus());
        c(1.0f);
        this.x = false;
    }

    public int getLayoutResourceId() {
        return g0.h.m;
    }

    public void setListeningOrbColors(SearchOrbView.c cVar) {
        this.u = cVar;
    }

    public void setNotListeningOrbColors(SearchOrbView.c cVar) {
        this.v = cVar;
    }

    public void setSoundLevel(int i) {
        if (this.x) {
            int i2 = this.w;
            if (i > i2) {
                this.w = i2 + ((i - i2) / 2);
            } else {
                this.w = (int) (i2 * 0.7f);
            }
            c((((this.t - getFocusedZoom()) * this.w) / 100.0f) + 1.0f);
        }
    }

    public SpeechOrbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 0;
        this.x = false;
        Resources resources = context.getResources();
        this.t = resources.getFraction(g0.e.f, 1, 1);
        this.v = new SearchOrbView.c(resources.getColor(g0.b.j), resources.getColor(g0.b.l), resources.getColor(g0.b.k));
        this.u = new SearchOrbView.c(resources.getColor(g0.b.m), resources.getColor(g0.b.m), 0);
        g();
    }
}
