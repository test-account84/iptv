package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NonOverlappingLinearLayout extends LinearLayout {
    public boolean a;
    public boolean c;
    public final ArrayList d;

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void focusableViewAvailable(View view) {
        int i;
        if (!this.c) {
            super.focusableViewAvailable(view);
            return;
        }
        for (View view2 = view; view2 != this && view2 != null; view2 = (View) view2.getParent()) {
            if (view2.getParent() == this) {
                i = indexOfChild(view2);
                break;
            }
        }
        i = -1;
        if (i != -1) {
            ((ArrayList) this.d.get(i)).add(view);
        }
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        try {
            boolean z2 = this.a && getOrientation() == 0 && getLayoutDirection() == 1;
            this.c = z2;
            if (z2) {
                while (this.d.size() > getChildCount()) {
                    ArrayList arrayList = this.d;
                    arrayList.remove(arrayList.size() - 1);
                }
                while (this.d.size() < getChildCount()) {
                    this.d.add(new ArrayList());
                }
            }
            super.onLayout(z, i, i2, i3, i4);
            if (this.c) {
                for (int i6 = 0; i6 < this.d.size(); i6++) {
                    for (int i7 = 0; i7 < ((ArrayList) this.d.get(i6)).size(); i7++) {
                        super.focusableViewAvailable((View) ((ArrayList) this.d.get(i6)).get(i7));
                    }
                }
            }
            if (this.c) {
                this.c = false;
                while (i5 < this.d.size()) {
                    ((ArrayList) this.d.get(i5)).clear();
                    i5++;
                }
            }
        } catch (Throwable th) {
            if (this.c) {
                this.c = false;
                while (i5 < this.d.size()) {
                    ((ArrayList) this.d.get(i5)).clear();
                    i5++;
                }
            }
            throw th;
        }
    }

    public void setFocusableViewAvailableFixEnabled(boolean z) {
        this.a = z;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.d = new ArrayList();
    }
}
