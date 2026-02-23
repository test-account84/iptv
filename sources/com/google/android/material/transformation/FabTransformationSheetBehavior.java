package com.google.android.material.transformation;

import P.L;
import R4.a;
import S4.f;
import S4.h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public Map i;

    public FabTransformationSheetBehavior() {
    }

    public boolean H(View view, View view2, boolean z, boolean z2) {
        b0(view2, z);
        return super.H(view, view2, z, z2);
    }

    public FabTransformationBehavior.b Z(Context context, boolean z) {
        int i = z ? a.d : a.c;
        FabTransformationBehavior.b bVar = new FabTransformationBehavior.b();
        bVar.a = f.c(context, i);
        bVar.b = new h(17, 0.0f, 0.0f);
        return bVar;
    }

    public final void b0(View view, boolean z) {
        int intValue;
        CoordinatorLayout parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.i = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (childAt.getLayoutParams().f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    Map map = this.i;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    } else {
                        intValue = (map != null && map.containsKey(childAt)) ? ((Integer) this.i.get(childAt)).intValue() : 4;
                    }
                    L.C0(childAt, intValue);
                }
            }
            if (z) {
                return;
            }
            this.i = null;
        }
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
