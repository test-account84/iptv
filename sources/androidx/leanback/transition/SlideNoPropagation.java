package androidx.leanback.transition;

import android.content.Context;
import android.transition.Slide;
import android.transition.TransitionPropagation;
import android.util.AttributeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SlideNoPropagation extends Slide {
    public SlideNoPropagation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSlideEdge(int i) {
        super.setSlideEdge(i);
        setPropagation((TransitionPropagation) null);
    }
}
