package f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e extends b {
    public a n;
    public boolean o;

    public static class a extends b.d {
        public int[][] J;

        public a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int h = h();
            for (int i = 0; i < h; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        public void o(int i, int i2) {
            super.o(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.J, 0, iArr, 0, i);
            this.J = iArr;
        }

        public abstract void r();

        public int z(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.J[a] = iArr;
            return a;
        }
    }

    public e(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.n = (a) dVar;
        }
    }

    public int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public Drawable mutate() {
        if (!this.o && super.mutate() == this) {
            this.n.r();
            this.o = true;
        }
        return this;
    }

    public abstract boolean onStateChange(int[] iArr);
}
