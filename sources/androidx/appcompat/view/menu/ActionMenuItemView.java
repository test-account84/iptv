package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import k.P;
import k.g0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements j.a, View.OnClickListener, ActionMenuView.a {
    public g i;
    public CharSequence j;
    public Drawable k;
    public e.b l;
    public P m;
    public b n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;

    public class a extends P {
        public a() {
            super(ActionMenuItemView.this);
        }

        public j.f b() {
            b bVar = ActionMenuItemView.this.n;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        public boolean c() {
            j.f b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.l;
            return bVar != null && bVar.d(actionMenuItemView.i) && (b = b()) != null && b.a();
        }
    }

    public static abstract class b {
        public abstract j.f a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return r();
    }

    public boolean b() {
        return r() && this.i.getIcon() == null;
    }

    public void c(g gVar, int i) {
        this.i = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.m == null) {
            this.m = new a();
        }
    }

    public boolean e() {
        return true;
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public g getItemData() {
        return this.i;
    }

    public void onClick(View view) {
        e.b bVar = this.l;
        if (bVar != null) {
            bVar.d(this.i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.o = s();
        t();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        boolean r = r();
        if (r && (i3 = this.r) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.q) : this.q;
        if (mode != 1073741824 && this.q > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (r || this.k == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.k.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        P p;
        if (this.i.hasSubMenu() && (p = this.m) != null && p.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.p != z) {
            this.p = z;
            g gVar = this.i;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.k = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.s;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        t();
    }

    public void setItemInvoker(e.b bVar) {
        this.l = bVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.r = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.n = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        t();
    }

    public final void t() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.j);
        if (this.k != null && (!this.i.B() || (!this.o && !this.p))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.j : null);
        CharSequence contentDescription = this.i.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.i.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.i.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            g0.a(this, z3 ? null : this.i.getTitle());
        } else {
            g0.a(this, tooltipText);
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.o = s();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.v, i, 0);
        this.q = obtainStyledAttributes.getDimensionPixelSize(c.j.w, 0);
        obtainStyledAttributes.recycle();
        this.s = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.r = -1;
        setSaveEnabled(false);
    }
}
