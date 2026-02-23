package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class w extends LinearLayout {
    public HorizontalGridView a;

    public w(Context context) {
        this(context, null);
    }

    public HorizontalGridView getGridView() {
        return this.a;
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(g0.h.a, this);
        HorizontalGridView findViewById = findViewById(g0.f.x);
        this.a = findViewById;
        findViewById.setHasFixedSize(false);
        setOrientation(1);
        setDescendantFocusability(262144);
    }
}
