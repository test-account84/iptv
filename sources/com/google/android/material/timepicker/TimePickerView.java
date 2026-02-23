package com.google.android.material.timepicker;

import P.L;
import R4.h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class TimePickerView extends ConstraintLayout {
    public final ClockHandView A;
    public final ClockFaceView B;
    public final MaterialButtonToggleGroup C;
    public final View.OnClickListener D;
    public final Chip y;
    public final Chip z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TimePickerView.t(TimePickerView.this);
        }
    }

    public class b implements MaterialButtonToggleGroup.d {
        public b() {
        }

        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
            TimePickerView.u(TimePickerView.this);
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.v(TimePickerView.this);
            return false;
        }
    }

    public class d implements View.OnTouchListener {
        public final /* synthetic */ GestureDetector a;

        public d(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ g t(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ f u(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ e v(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        y();
    }

    public void onVisibilityChanged(View view, int i) {
        super/*android.view.ViewGroup*/.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            y();
        }
    }

    public final void w() {
        this.y.setTag(R4.f.G, 12);
        this.z.setTag(R4.f.G, 10);
        this.y.setOnClickListener(this.D);
        this.z.setOnClickListener(this.D);
        this.y.setAccessibilityClassName("android.view.View");
        this.z.setAccessibilityClassName("android.view.View");
    }

    public final void x() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.y.setOnTouchListener(dVar);
        this.z.setOnTouchListener(dVar);
    }

    public final void y() {
        if (this.C.getVisibility() == 0) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.g(this);
            cVar.e(R4.f.g, L.E(this) == 0 ? 2 : 1);
            cVar.c(this);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = new a();
        LayoutInflater.from(context).inflate(h.k, this);
        this.B = findViewById(R4.f.h);
        MaterialButtonToggleGroup findViewById = findViewById(R4.f.j);
        this.C = findViewById;
        findViewById.b(new b());
        this.y = findViewById(R4.f.m);
        this.z = findViewById(R4.f.k);
        this.A = (ClockHandView) findViewById(R4.f.i);
        x();
        w();
    }
}
