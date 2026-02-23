package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.SearchOrbView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TitleView extends FrameLayout {
    public ImageView a;
    public TextView c;
    public SearchOrbView d;
    public int e;
    public boolean f;
    public final Z g;

    public class a extends Z {
        public a() {
        }
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g0.a.a);
    }

    public final void a() {
        if (this.a.getDrawable() != null) {
            this.a.setVisibility(0);
            this.c.setVisibility(8);
        } else {
            this.a.setVisibility(8);
            this.c.setVisibility(0);
        }
    }

    public final void b() {
        int i = 4;
        if (this.f && (this.e & 4) == 4) {
            i = 0;
        }
        this.d.setVisibility(i);
    }

    public Drawable getBadgeDrawable() {
        return this.a.getDrawable();
    }

    public SearchOrbView.c getSearchAffordanceColors() {
        return this.d.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.d;
    }

    public CharSequence getTitle() {
        return this.c.getText();
    }

    public Z getTitleViewAdapter() {
        return this.g;
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
        a();
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.f = onClickListener != null;
        this.d.setOnOrbClickedListener(onClickListener);
        b();
    }

    public void setSearchAffordanceColors(SearchOrbView.c cVar) {
        this.d.setOrbColors(cVar);
    }

    public void setTitle(CharSequence charSequence) {
        this.c.setText(charSequence);
        a();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 6;
        this.f = false;
        this.g = new a();
        View inflate = LayoutInflater.from(context).inflate(g0.h.n, this);
        this.a = inflate.findViewById(g0.f.B);
        this.c = inflate.findViewById(g0.f.D);
        this.d = inflate.findViewById(g0.f.C);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
