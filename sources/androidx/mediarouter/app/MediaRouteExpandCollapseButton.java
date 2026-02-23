package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import k.n;
import t0.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MediaRouteExpandCollapseButton extends n {
    public final AnimationDrawable e;
    public final AnimationDrawable f;
    public final String g;
    public final String h;
    public boolean i;
    public View.OnClickListener j;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton;
            String str;
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton2 = MediaRouteExpandCollapseButton.this;
            boolean z = !mediaRouteExpandCollapseButton2.i;
            mediaRouteExpandCollapseButton2.i = z;
            if (z) {
                mediaRouteExpandCollapseButton2.setImageDrawable(mediaRouteExpandCollapseButton2.e);
                MediaRouteExpandCollapseButton.this.e.start();
                mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
                str = mediaRouteExpandCollapseButton.h;
            } else {
                mediaRouteExpandCollapseButton2.setImageDrawable(mediaRouteExpandCollapseButton2.f);
                MediaRouteExpandCollapseButton.this.f.start();
                mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
                str = mediaRouteExpandCollapseButton.g;
            }
            mediaRouteExpandCollapseButton.setContentDescription(str);
            View.OnClickListener onClickListener = MediaRouteExpandCollapseButton.this.j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnimationDrawable drawable = E.b.getDrawable(context, t0.e.d);
        this.e = drawable;
        AnimationDrawable drawable2 = E.b.getDrawable(context, t0.e.c);
        this.f = drawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i.f(context, i), PorterDuff.Mode.SRC_IN);
        drawable.setColorFilter(porterDuffColorFilter);
        drawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(j.i);
        this.g = string;
        this.h = context.getString(j.g);
        setImageDrawable(drawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new a());
    }
}
