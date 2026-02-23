package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import d.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends u implements DialogInterface {
    public final AlertController a;

    public static class a {
        public final AlertController.f a;
        public final int b;

        public a(Context context) {
            this(context, a.g(context, 0));
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a b(boolean z) {
            this.a.r = z;
            return this;
        }

        public a c(View view) {
            this.a.g = view;
            return this;
        }

        public a create() {
            a aVar = new a(this.a.a, this.b);
            this.a.a(aVar.a);
            aVar.setCancelable(this.a.r);
            if (this.a.r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.a.s);
            aVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        public a d(int i) {
            this.a.c = i;
            return this;
        }

        public a e(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.l = charSequence;
            fVar.n = onClickListener;
            return this;
        }

        public Context getContext() {
            return this.a.a;
        }

        public a h(DialogInterface.OnDismissListener onDismissListener) {
            this.a.t = onDismissListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.i = charSequence;
            fVar.k = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i;
            fVar.H = true;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.v = charSequenceArr;
            fVar.x = onClickListener;
            fVar.I = i;
            fVar.H = true;
            return this;
        }

        public a m(int i) {
            AlertController.f fVar = this.a;
            fVar.f = fVar.a.getText(i);
            return this;
        }

        public a n() {
            a create = create();
            create.show();
            return create;
        }

        public a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.l = fVar.a.getText(i);
            this.a.n = onClickListener;
            return this;
        }

        public a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.i = fVar.a.getText(i);
            this.a.k = onClickListener;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.a;
            fVar.z = view;
            fVar.y = 0;
            fVar.E = false;
            return this;
        }

        public a(Context context, int i) {
            this.a = new AlertController.f(new ContextThemeWrapper(context, a.g(context, i)));
            this.b = i;
        }
    }

    public a(Context context, int i) {
        super(context, g(context, i));
        this.a = new AlertController(getContext(), this, getWindow());
    }

    public static int g(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.l, typedValue, true);
        return typedValue.resourceId;
    }

    public Button e(int i) {
        return this.a.c(i);
    }

    public ListView f() {
        return this.a.e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.f();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.a.i(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.r(charSequence);
    }
}
