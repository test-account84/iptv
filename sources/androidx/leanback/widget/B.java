package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b extends RecyclerView {
    public final m M0;
    public boolean N0;
    public boolean O0;
    public RecyclerView.l P0;
    public RecyclerView.w Q0;
    public e R0;
    public int S0;

    public class a implements RecyclerView.w {
        public a() {
        }

        public void a(RecyclerView.D d) {
            b.this.M0.F3(d);
            RecyclerView.w wVar = b.this.Q0;
            if (wVar != null) {
                wVar.a(d);
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        boolean a(KeyEvent keyEvent);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.N0 = true;
        this.O0 = true;
        this.S0 = 4;
        m mVar = new m(this);
        this.M0 = mVar;
        setLayoutManager(mVar);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((androidx.recyclerview.widget.n) getItemAnimator()).R(false);
        super.setRecyclerListener(new a());
    }

    public void C1(View view, int[] iArr) {
        this.M0.j3(view, iArr);
    }

    public void D1(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.A);
        this.M0.a4(obtainStyledAttributes.getBoolean(g0.l.F, false), obtainStyledAttributes.getBoolean(g0.l.E, false));
        this.M0.b4(obtainStyledAttributes.getBoolean(g0.l.H, true), obtainStyledAttributes.getBoolean(g0.l.G, true));
        this.M0.y4(obtainStyledAttributes.getDimensionPixelSize(g0.l.D, obtainStyledAttributes.getDimensionPixelSize(g0.l.J, 0)));
        this.M0.f4(obtainStyledAttributes.getDimensionPixelSize(g0.l.C, obtainStyledAttributes.getDimensionPixelSize(g0.l.I, 0)));
        if (obtainStyledAttributes.hasValue(g0.l.B)) {
            setGravity(obtainStyledAttributes.getInt(g0.l.B, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean E1() {
        return isChildrenDrawingOrderEnabled();
    }

    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        e eVar = this.R0;
        return eVar != null && eVar.a(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public View focusSearch(int i) {
        if (isFocused()) {
            m mVar = this.M0;
            View a0 = mVar.a0(mVar.U2());
            if (a0 != null) {
                return focusSearch(a0, i);
            }
        }
        return super.focusSearch(i);
    }

    public int getChildDrawingOrder(int i, int i2) {
        return this.M0.B2(this, i, i2);
    }

    public int getExtraLayoutSpace() {
        return this.M0.E2();
    }

    public int getFocusScrollStrategy() {
        return this.M0.G2();
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.M0.H2();
    }

    public int getHorizontalSpacing() {
        return this.M0.H2();
    }

    public int getInitialPrefetchItemCount() {
        return this.S0;
    }

    public int getItemAlignmentOffset() {
        return this.M0.I2();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.M0.J2();
    }

    public int getItemAlignmentViewId() {
        return this.M0.K2();
    }

    public e getOnUnhandledKeyListener() {
        return this.R0;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.M0.f0.c();
    }

    public final int getSaveChildrenPolicy() {
        return this.M0.f0.d();
    }

    public int getSelectedPosition() {
        return this.M0.U2();
    }

    public int getSelectedSubPosition() {
        return this.M0.Y2();
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.M0.a3();
    }

    public int getVerticalSpacing() {
        return this.M0.a3();
    }

    public int getWindowAlignment() {
        return this.M0.k3();
    }

    public int getWindowAlignmentOffset() {
        return this.M0.l3();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.M0.m3();
    }

    public boolean hasOverlappingRendering() {
        return this.O0;
    }

    public void m1(int i) {
        if (this.M0.x3()) {
            this.M0.x4(i, 0, 0);
        } else {
            super.m1(i);
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.M0.G3(z, i, rect);
    }

    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        return this.M0.n3(this, i, rect);
    }

    public void onRtlPropertiesChanged(int i) {
        this.M0.H3(i);
    }

    public void setAnimateChildLayout(boolean z) {
        RecyclerView.l lVar;
        if (this.N0 != z) {
            this.N0 = z;
            if (z) {
                lVar = this.P0;
            } else {
                this.P0 = getItemAnimator();
                lVar = null;
            }
            super.setItemAnimator(lVar);
        }
    }

    public void setChildrenVisibility(int i) {
        this.M0.Y3(i);
    }

    public void setExtraLayoutSpace(int i) {
        this.M0.Z3(i);
    }

    public void setFocusDrawingOrderEnabled(boolean z) {
        super.setChildrenDrawingOrderEnabled(z);
    }

    public void setFocusScrollStrategy(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid scrollStrategy");
        }
        this.M0.c4(i);
        requestLayout();
    }

    public final void setFocusSearchDisabled(boolean z) {
        setDescendantFocusability(z ? 393216 : 262144);
        this.M0.d4(z);
    }

    public void setGravity(int i) {
        this.M0.e4(i);
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z) {
        this.O0 = z;
    }

    @Deprecated
    public void setHorizontalMargin(int i) {
        setHorizontalSpacing(i);
    }

    public void setHorizontalSpacing(int i) {
        this.M0.f4(i);
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i) {
        this.S0 = i;
    }

    public void setItemAlignmentOffset(int i) {
        this.M0.g4(i);
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f) {
        this.M0.h4(f);
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z) {
        this.M0.i4(z);
        requestLayout();
    }

    public void setItemAlignmentViewId(int i) {
        this.M0.j4(i);
    }

    @Deprecated
    public void setItemMargin(int i) {
        setItemSpacing(i);
    }

    public void setItemSpacing(int i) {
        this.M0.k4(i);
        requestLayout();
    }

    public void setLayoutEnabled(boolean z) {
        this.M0.l4(z);
    }

    public void setOnChildLaidOutListener(z zVar) {
        this.M0.n4(zVar);
    }

    public void setOnChildSelectedListener(A a2) {
        this.M0.o4(a2);
    }

    public void setOnChildViewHolderSelectedListener(B b2) {
        this.M0.p4(b2);
    }

    public void setOnKeyInterceptListener(b bVar) {
    }

    public void setOnMotionInterceptListener(c cVar) {
    }

    public void setOnTouchInterceptListener(d dVar) {
    }

    public void setOnUnhandledKeyListener(e eVar) {
        this.R0 = eVar;
    }

    public void setPruneChild(boolean z) {
        this.M0.r4(z);
    }

    public void setRecyclerListener(RecyclerView.w wVar) {
        this.Q0 = wVar;
    }

    public final void setSaveChildrenLimitNumber(int i) {
        this.M0.f0.m(i);
    }

    public final void setSaveChildrenPolicy(int i) {
        this.M0.f0.n(i);
    }

    public void setScrollEnabled(boolean z) {
        this.M0.t4(z);
    }

    public void setSelectedPosition(int i) {
        this.M0.u4(i, 0);
    }

    public void setSelectedPositionSmooth(int i) {
        this.M0.w4(i);
    }

    @Deprecated
    public void setVerticalMargin(int i) {
        setVerticalSpacing(i);
    }

    public void setVerticalSpacing(int i) {
        this.M0.y4(i);
        requestLayout();
    }

    public void setWindowAlignment(int i) {
        this.M0.z4(i);
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i) {
        this.M0.A4(i);
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f) {
        this.M0.B4(f);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z) {
        this.M0.a0.a().u(z);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z) {
        this.M0.a0.a().v(z);
        requestLayout();
    }

    public void u1(int i) {
        if (this.M0.x3()) {
            this.M0.x4(i, 0, 0);
        } else {
            super.u1(i);
        }
    }
}
