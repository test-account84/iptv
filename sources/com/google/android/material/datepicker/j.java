package com.google.android.material.datepicker;

import P.E;
import P.L;
import P.X;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import d.D;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends androidx.fragment.app.d {
    public static final Object w = "CONFIRM_BUTTON_TAG";
    public static final Object x = "CANCEL_BUTTON_TAG";
    public static final Object y = "TOGGLE_BUTTON_TAG";
    public final LinkedHashSet a = new LinkedHashSet();
    public final LinkedHashSet c = new LinkedHashSet();
    public final LinkedHashSet d = new LinkedHashSet();
    public final LinkedHashSet e = new LinkedHashSet();
    public int f;
    public p g;
    public com.google.android.material.datepicker.a h;
    public i i;
    public int j;
    public CharSequence k;
    public boolean l;
    public int m;
    public int n;
    public CharSequence o;
    public int p;
    public CharSequence q;
    public TextView r;
    public CheckableImageButton s;
    public l5.g t;
    public Button u;
    public boolean v;

    public class a implements E {
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public a(int i, View view, int i2) {
            this.a = i;
            this.b = view;
            this.c = i2;
        }

        public X a(View view, X x) {
            int i = x.f(X.m.c()).b;
            if (this.a >= 0) {
                this.b.getLayoutParams().height = this.a + i;
                View view2 = this.b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.b;
            view3.setPadding(view3.getPaddingLeft(), this.c + i, this.b.getPaddingRight(), this.b.getPaddingBottom());
            return x;
        }
    }

    public class b extends o {
        public b() {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            j.B(j.this);
            j.A(j.this);
            throw null;
        }
    }

    public static /* synthetic */ d A(j jVar) {
        jVar.J();
        return null;
    }

    public static /* synthetic */ Button B(j jVar) {
        return jVar.u;
    }

    public static Drawable D(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, e.a.b(context, R4.e.b));
        stateListDrawable.addState(new int[0], e.a.b(context, R4.e.c));
        return stateListDrawable;
    }

    private d J() {
        D.a(getArguments().getParcelable("DATE_SELECTOR_KEY"));
        return null;
    }

    public static int P(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R4.d.G);
        int i = l.h().e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R4.d.I) * i) + ((i - 1) * resources.getDimensionPixelOffset(R4.d.L));
    }

    public static boolean W(Context context) {
        return Y(context, 16843277);
    }

    public static boolean X(Context context) {
        return Y(context, R4.b.A);
    }

    public static boolean Y(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5.b.d(context, R4.b.v, i.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void E(Window window) {
        if (this.v) {
            return;
        }
        View findViewById = requireView().findViewById(R4.f.f);
        f5.d.a(window, true, f5.w.c(findViewById), null);
        L.E0(findViewById, new a(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
        this.v = true;
    }

    public String L() {
        J();
        getContext();
        throw null;
    }

    public final int S(Context context) {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        J();
        throw null;
    }

    public final void T(Context context) {
        this.s.setTag(y);
        this.s.setImageDrawable(D(context));
        this.s.setChecked(this.m != 0);
        L.s0(this.s, (P.a) null);
        c0(this.s);
        this.s.setOnClickListener(new c());
    }

    public final void Z() {
        p pVar;
        int S = S(requireContext());
        J();
        this.i = i.c0(null, S, this.h);
        if (this.s.isChecked()) {
            J();
            pVar = k.A(null, S, this.h);
        } else {
            pVar = this.i;
        }
        this.g = pVar;
        b0();
        androidx.fragment.app.w m = getChildFragmentManager().m();
        m.q(R4.f.w, this.g);
        m.k();
        this.g.x(new b());
    }

    public final void b0() {
        String L = L();
        this.r.setContentDescription(String.format(getString(R4.j.m), new Object[]{L}));
        this.r.setText(L);
    }

    public final void c0(CheckableImageButton checkableImageButton) {
        this.s.setContentDescription(checkableImageButton.getContext().getString(this.s.isChecked() ? R4.j.p : R4.j.r));
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        D.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.h = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.j = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.k = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.m = bundle.getInt("INPUT_MODE_KEY");
        this.n = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.o = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.p = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.q = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), S(requireContext()));
        Context context = dialog.getContext();
        this.l = W(context);
        int d = i5.b.d(context, R4.b.m, j.class.getCanonicalName());
        l5.g gVar = new l5.g(context, null, R4.b.v, R4.k.t);
        this.t = gVar;
        gVar.L(context);
        this.t.W(ColorStateList.valueOf(d));
        this.t.V(L.y(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View findViewById;
        LinearLayout.LayoutParams layoutParams;
        View inflate = layoutInflater.inflate(this.l ? R4.h.t : R4.h.s, viewGroup);
        Context context = inflate.getContext();
        if (this.l) {
            findViewById = inflate.findViewById(R4.f.w);
            layoutParams = new LinearLayout.LayoutParams(P(context), -2);
        } else {
            findViewById = inflate.findViewById(R4.f.x);
            layoutParams = new LinearLayout.LayoutParams(P(context), -1);
        }
        findViewById.setLayoutParams(layoutParams);
        TextView findViewById2 = inflate.findViewById(R4.f.C);
        this.r = findViewById2;
        L.u0(findViewById2, 1);
        this.s = inflate.findViewById(R4.f.D);
        TextView findViewById3 = inflate.findViewById(R4.f.E);
        CharSequence charSequence = this.k;
        if (charSequence != null) {
            findViewById3.setText(charSequence);
        } else {
            findViewById3.setText(this.j);
        }
        T(context);
        this.u = inflate.findViewById(R4.f.c);
        J();
        throw null;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup view = getView();
        if (view != null) {
            view.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f);
        bundle.putParcelable("DATE_SELECTOR_KEY", (Parcelable) null);
        a.b bVar = new a.b(this.h);
        if (this.i.W() != null) {
            bVar.b(this.i.W().g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.j);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.k);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.n);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.o);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.p);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.q);
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.l) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.t);
            E(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R4.d.K);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.t, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new a5.a(requireDialog(), rect));
        }
        Z();
    }

    public void onStop() {
        this.g.z();
        super.onStop();
    }
}
