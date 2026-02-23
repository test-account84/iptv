package k;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class w extends Spinner {
    public static final int[] j = {16843505};
    public final k.d a;
    public final Context c;
    public P d;
    public SpinnerAdapter e;
    public final boolean f;
    public j g;
    public int h;
    public final Rect i;

    public class a extends P {
        public final /* synthetic */ h k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, h hVar) {
            super(view);
            this.k = hVar;
        }

        public j.f b() {
            return this.k;
        }

        public boolean c() {
            if (w.this.getInternalPopup().a()) {
                return true;
            }
            w.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().a()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    public static final class c {
        public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static final class d {
        public static int a(View view) {
            return view.getTextAlignment();
        }

        public static int b(View view) {
            return view.getTextDirection();
        }

        public static void c(View view, int i) {
            view.setTextAlignment(i);
        }

        public static void d(View view, int i) {
            view.setTextDirection(i);
        }
    }

    public static final class e {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (O.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    public class f implements j, DialogInterface.OnClickListener {
        public androidx.appcompat.app.a a;
        public ListAdapter c;
        public CharSequence d;

        public f() {
        }

        public boolean a() {
            androidx.appcompat.app.a aVar = this.a;
            if (aVar != null) {
                return aVar.isShowing();
            }
            return false;
        }

        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public int c() {
            return 0;
        }

        public void dismiss() {
            androidx.appcompat.app.a aVar = this.a;
            if (aVar != null) {
                aVar.dismiss();
                this.a = null;
            }
        }

        public void e(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public CharSequence f() {
            return this.d;
        }

        public Drawable g() {
            return null;
        }

        public void h(CharSequence charSequence) {
            this.d = charSequence;
        }

        public void i(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void j(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void k(int i, int i2) {
            if (this.c == null) {
                return;
            }
            a.a aVar = new a.a(w.this.getPopupContext());
            CharSequence charSequence = this.d;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.a create = aVar.k(this.c, w.this.getSelectedItemPosition(), this).create();
            this.a = create;
            ListView f = create.f();
            d.d(f, i);
            d.c(f, i2);
            this.a.show();
        }

        public int l() {
            return 0;
        }

        public void m(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.this.setSelection(i);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick((View) null, i, this.c.getItemId(i));
            }
            dismiss();
        }
    }

    public static class g implements ListAdapter, SpinnerAdapter {
        public SpinnerAdapter a;
        public ListAdapter c;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !x.a(spinnerAdapter)) {
                return;
            }
            e.a(y.a(spinnerAdapter), theme);
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class h extends Q implements j {
        public CharSequence K;
        public ListAdapter L;
        public final Rect M;
        public int N;

        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ w a;

            public a(w wVar) {
                this.a = wVar;
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                w.this.setSelection(i);
                if (w.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    w.this.performItemClick(view, i, hVar.L.getItemId(i));
                }
                h.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.T(w.this)) {
                    h.this.dismiss();
                } else {
                    h.this.R();
                    h.Q(h.this);
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.M = new Rect();
            C(w.this);
            I(true);
            N(0);
            K(new a(w.this));
        }

        public static /* synthetic */ void Q(h hVar) {
            super.show();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void R() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.g()
                if (r0 == 0) goto L24
                k.w r1 = k.w.this
                android.graphics.Rect r1 = r1.i
                r0.getPadding(r1)
                k.w r0 = k.w.this
                boolean r0 = k.m0.b(r0)
                if (r0 == 0) goto L1c
                k.w r0 = k.w.this
                android.graphics.Rect r0 = r0.i
                int r0 = r0.right
                goto L2e
            L1c:
                k.w r0 = k.w.this
                android.graphics.Rect r0 = r0.i
                int r0 = r0.left
                int r0 = -r0
                goto L2e
            L24:
                k.w r0 = k.w.this
                android.graphics.Rect r0 = r0.i
                r1 = 0
                r0.right = r1
                r0.left = r1
                r0 = 0
            L2e:
                k.w r1 = k.w.this
                int r1 = r1.getPaddingLeft()
                k.w r2 = k.w.this
                int r2 = r2.getPaddingRight()
                k.w r3 = k.w.this
                int r3 = r3.getWidth()
                k.w r4 = k.w.this
                int r5 = r4.h
                r6 = -2
                if (r5 != r6) goto L7b
                android.widget.ListAdapter r5 = r8.L
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.g()
                int r4 = r4.a(r5, r6)
                k.w r5 = k.w.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                k.w r6 = k.w.this
                android.graphics.Rect r6 = r6.i
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L70
                r4 = r5
            L70:
                int r5 = r3 - r1
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
            L77:
                r8.E(r4)
                goto L85
            L7b:
                r4 = -1
                if (r5 != r4) goto L82
                int r4 = r3 - r1
                int r4 = r4 - r2
                goto L77
            L82:
                r8.E(r5)
            L85:
                k.w r4 = k.w.this
                boolean r4 = k.m0.b(r4)
                if (r4 == 0) goto L9a
                int r3 = r3 - r2
                int r1 = r8.y()
                int r3 = r3 - r1
                int r1 = r8.S()
                int r3 = r3 - r1
                int r0 = r0 + r3
                goto La0
            L9a:
                int r2 = r8.S()
                int r1 = r1 + r2
                int r0 = r0 + r1
            La0:
                r8.e(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k.w.h.R():void");
        }

        public int S() {
            return this.N;
        }

        public boolean T(View view) {
            return P.L.V(view) && view.getGlobalVisibleRect(this.M);
        }

        public CharSequence f() {
            return this.K;
        }

        public void h(CharSequence charSequence) {
            this.K = charSequence;
        }

        public void j(int i) {
            this.N = i;
        }

        public void k(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean a2 = a();
            R();
            H(2);
            super.show();
            ListView o = o();
            o.setChoiceMode(1);
            d.d(o, i);
            d.c(o, i2);
            O(w.this.getSelectedItemPosition());
            if (a2 || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            J(new c(bVar));
        }

        public void m(ListAdapter listAdapter) {
            super.m(listAdapter);
            this.L = listAdapter;
        }
    }

    public static class i extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new a();
        public boolean a;

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        }

        public i(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface j {
        boolean a();

        void b(Drawable drawable);

        int c();

        void dismiss();

        void e(int i);

        CharSequence f();

        Drawable g();

        void h(CharSequence charSequence);

        void i(int i);

        void j(int i);

        void k(int i, int i2);

        int l();

        void m(ListAdapter listAdapter);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.N);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.i);
        Rect rect = this.i;
        return i3 + rect.left + rect.right;
    }

    public void b() {
        this.g.k(d.b(this), d.a(this));
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        j jVar = this.g;
        return jVar != null ? jVar.c() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        j jVar = this.g;
        return jVar != null ? jVar.l() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.g != null ? this.h : super.getDropDownWidth();
    }

    public final j getInternalPopup() {
        return this.g;
    }

    public Drawable getPopupBackground() {
        j jVar = this.g;
        return jVar != null ? jVar.g() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.c;
    }

    public CharSequence getPrompt() {
        j jVar = this.g;
        return jVar != null ? jVar.f() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        k.d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k.d dVar = this.a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.g;
        if (jVar == null || !jVar.a()) {
            return;
        }
        this.g.dismiss();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.g == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (!iVar.a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        j jVar = this.g;
        iVar.a = jVar != null && jVar.a();
        return iVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        P p = this.d;
        if (p == null || !p.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        j jVar = this.g;
        if (jVar == null) {
            return super.performClick();
        }
        if (jVar.a()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        j jVar = this.g;
        if (jVar == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            jVar.j(i2);
            this.g.e(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        j jVar = this.g;
        if (jVar != null) {
            jVar.i(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.g != null) {
            this.h = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        j jVar = this.g;
        if (jVar != null) {
            jVar.b(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(e.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        j jVar = this.g;
        if (jVar != null) {
            jVar.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k.d dVar = this.a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public w(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            this.g.m(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public w(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k.w.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
