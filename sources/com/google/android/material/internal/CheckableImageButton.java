package com.google.android.material.internal;

import P.L;
import Q.C;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import k.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class CheckableImageButton extends n implements Checkable {
    public static final int[] h = {16842912};
    public boolean e;
    public boolean f;
    public boolean g;

    public class a extends P.a {
        public a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        public void g(View view, C c) {
            super.g(view, c);
            c.V(CheckableImageButton.this.a());
            c.W(CheckableImageButton.this.isChecked());
        }
    }

    public static class b extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public boolean d;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel);
        }

        private void c(Parcel parcel) {
            this.d = parcel.readInt() == 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.C);
    }

    public boolean a() {
        return this.f;
    }

    public boolean isChecked() {
        return this.e;
    }

    public int[] onCreateDrawableState(int i) {
        if (!this.e) {
            return super/*android.widget.ImageButton*/.onCreateDrawableState(i);
        }
        int[] iArr = h;
        return View.mergeDrawableStates(super/*android.widget.ImageButton*/.onCreateDrawableState(i + iArr.length), iArr);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super/*android.widget.ImageButton*/.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super/*android.widget.ImageButton*/.onRestoreInstanceState(bVar.a());
        setChecked(bVar.d);
    }

    public Parcelable onSaveInstanceState() {
        b bVar = new b(super/*android.widget.ImageButton*/.onSaveInstanceState());
        bVar.d = this.e;
        return bVar;
    }

    public void setCheckable(boolean z) {
        if (this.f != z) {
            this.f = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (!this.f || this.e == z) {
            return;
        }
        this.e = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.g = z;
    }

    public void setPressed(boolean z) {
        if (this.g) {
            super/*android.widget.ImageButton*/.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.e);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.g = true;
        L.s0(this, new a());
    }
}
