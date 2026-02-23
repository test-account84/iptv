package androidx.appcompat.app;

import P.L;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import c.j;
import d.u;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;
    public final Context a;
    public final u b;
    public final Window c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public ListView g;
    public View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;
    public boolean n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {
        public final int a;
        public final int c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.k2);
            this.c = obtainStyledAttributes.getDimensionPixelOffset(j.l2, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(j.m2, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.c);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            Message obtain = ((view != alertController.o || (message2 = alertController.q) == null) && (view != alertController.s || (message2 = alertController.u) == null)) ? (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message) : Message.obtain(message2);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.b).sendToTarget();
        }
    }

    public class b implements NestedScrollView.c {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        public b(View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.g(nestedScrollView, this.a, this.b);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View c;

        public c(View view, View view2) {
            this.a = view;
            this.c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.A, this.a, this.c);
        }
    }

    public class d implements AbsListView.OnScrollListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        public d(View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.g(absListView, this.a, this.b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View c;

        public e(View view, View view2) {
            this.a = view;
            this.c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.g, this.a, this.c);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public final Context a;
        public final LayoutInflater b;
        public Drawable d;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;
        public int c = 0;
        public int e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean O = true;
        public boolean r = true;

        public class a extends ArrayAdapter {
            public final /* synthetic */ RecycleListView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.a = recycleListView;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i]) {
                    this.a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {
            public final int a;
            public final int c;
            public final /* synthetic */ RecycleListView d;
            public final /* synthetic */ AlertController e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.d = recycleListView;
                this.e = alertController;
                Cursor cursor2 = getCursor();
                this.a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.c = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                view.findViewById(16908308).setText(cursor.getString(this.a));
                this.d.setItemChecked(cursor.getPosition(), cursor.getInt(this.c) == 1);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.b.inflate(this.e.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {
            public final /* synthetic */ AlertController a;

            public c(AlertController alertController) {
                this.a = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                f.this.x.onClick(this.a.b, i);
                if (f.this.H) {
                    return;
                }
                this.a.b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {
            public final /* synthetic */ RecycleListView a;
            public final /* synthetic */ AlertController c;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.a = recycleListView;
                this.c = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i] = this.a.isItemChecked(i);
                }
                f.this.J.onClick(this.c.b, i, this.a.isItemChecked(i));
            }
        }

        public f(Context context) {
            this.a = context;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i = this.c;
                if (i != 0) {
                    alertController.n(i);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    alertController.n(alertController.d(i2));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.i;
            if (charSequence3 != null || this.j != null) {
                alertController.l(-1, charSequence3, this.k, null, this.j);
            }
            CharSequence charSequence4 = this.l;
            if (charSequence4 != null || this.m != null) {
                alertController.l(-2, charSequence4, this.n, null, this.m);
            }
            CharSequence charSequence5 = this.o;
            if (charSequence5 != null || this.p != null) {
                alertController.l(-3, charSequence5, this.q, null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.u(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.t(view2);
                    return;
                }
            }
            int i3 = this.y;
            if (i3 != 0) {
                alertController.s(i3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(androidx.appcompat.app.AlertController r10) {
            /*
                r9 = this;
                android.view.LayoutInflater r0 = r9.b
                int r1 = r10.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r9.G
                if (r1 == 0) goto L34
                android.database.Cursor r1 = r9.K
                if (r1 != 0) goto L25
                androidx.appcompat.app.AlertController$f$a r8 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r9.a
                int r4 = r10.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r9.v
                r1 = r8
                r2 = r9
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L69
            L25:
                androidx.appcompat.app.AlertController$f$b r8 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r9.a
                android.database.Cursor r4 = r9.K
                r5 = 0
                r1 = r8
                r2 = r9
                r6 = r0
                r7 = r10
                r1.<init>(r3, r4, r5, r6, r7)
                goto L69
            L34:
                boolean r1 = r9.H
                if (r1 == 0) goto L3c
                int r1 = r10.N
            L3a:
                r4 = r1
                goto L3f
            L3c:
                int r1 = r10.O
                goto L3a
            L3f:
                android.database.Cursor r1 = r9.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L5b
                android.widget.SimpleCursorAdapter r8 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r9.a
                android.database.Cursor r5 = r9.K
                java.lang.String r1 = r9.L
                java.lang.String[] r6 = new java.lang.String[]{r1}
                int[] r7 = new int[]{r2}
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                goto L69
            L5b:
                android.widget.ListAdapter r8 = r9.w
                if (r8 == 0) goto L60
                goto L69
            L60:
                androidx.appcompat.app.AlertController$h r8 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r9.a
                java.lang.CharSequence[] r3 = r9.v
                r8.<init>(r1, r4, r2, r3)
            L69:
                r10.H = r8
                int r1 = r9.I
                r10.I = r1
                android.content.DialogInterface$OnClickListener r1 = r9.x
                if (r1 == 0) goto L7c
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r10)
            L78:
                r0.setOnItemClickListener(r1)
                goto L86
            L7c:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r9.J
                if (r1 == 0) goto L86
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r10)
                goto L78
            L86:
                android.widget.AdapterView$OnItemSelectedListener r1 = r9.N
                if (r1 == 0) goto L8d
                r0.setOnItemSelectedListener(r1)
            L8d:
                boolean r1 = r9.H
                if (r1 == 0) goto L96
                r1 = 1
            L92:
                r0.setChoiceMode(r1)
                goto L9c
            L96:
                boolean r1 = r9.G
                if (r1 == 0) goto L9c
                r1 = 2
                goto L92
            L9c:
                r10.g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }
    }

    public static final class g extends Handler {
        public WeakReference a;

        public g(DialogInterface dialogInterface) {
            this.a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter {
        public h(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, u uVar, Window window) {
        this.a = context;
        this.b = uVar;
        this.c = window;
        this.R = new g(uVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j.F, c.a.k, 0);
        this.J = obtainStyledAttributes.getResourceId(j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(j.M, true);
        this.d = obtainStyledAttributes.getDimensionPixelSize(j.H, 0);
        obtainStyledAttributes.recycle();
        uVar.supportRequestWindowFeature(1);
    }

    public static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.j, typedValue, true);
        return typedValue.data != 0;
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i) {
        if (i == -3) {
            return this.w;
        }
        if (i == -2) {
            return this.s;
        }
        if (i != -1) {
            return null;
        }
        return this.o;
    }

    public int d(int i) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.g;
    }

    public void f() {
        this.b.setContentView(k());
        z();
    }

    public boolean h(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.r(keyEvent);
    }

    public boolean i(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.r(keyEvent);
    }

    public final ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewGroup parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                parent.removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int k() {
        int i = this.K;
        return (i != 0 && this.Q == 1) ? i : this.J;
    }

    public void l(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        }
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i) {
        this.C = null;
        this.B = i;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void p(CharSequence charSequence) {
        this.f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void q(ViewGroup viewGroup, View view, int i, int i2) {
        NestedScrollView nestedScrollView;
        Runnable eVar;
        View findViewById = this.c.findViewById(c.f.v);
        View findViewById2 = this.c.findViewById(c.f.u);
        if (Build.VERSION.SDK_INT < 23) {
            if (findViewById != null && (i & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById == null && findViewById2 == null) {
                return;
            }
            if (this.f != null) {
                this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
                nestedScrollView = this.A;
                eVar = new c(findViewById, findViewById2);
            } else {
                ListView listView = this.g;
                if (listView != null) {
                    listView.setOnScrollListener(new d(findViewById, findViewById2));
                    nestedScrollView = this.g;
                    eVar = new e(findViewById, findViewById2);
                } else {
                    if (findViewById != null) {
                        viewGroup.removeView(findViewById);
                    }
                    if (findViewById2 == null) {
                        return;
                    }
                }
            }
            nestedScrollView.post(eVar);
            return;
        }
        L.I0(view, i, i2);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 == null) {
            return;
        }
        viewGroup.removeView(findViewById2);
    }

    public void r(CharSequence charSequence) {
        this.e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i) {
        this.h = null;
        this.i = i;
        this.n = false;
    }

    public void t(View view) {
        this.h = view;
        this.i = 0;
        this.n = false;
    }

    public void u(View view, int i, int i2, int i3, int i4) {
        this.h = view;
        this.i = 0;
        this.n = true;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    public final void v(ViewGroup viewGroup) {
        int i;
        Button button;
        Button findViewById = viewGroup.findViewById(16908313);
        this.o = findViewById;
        findViewById.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.o.setVisibility(0);
            i = 1;
        }
        Button findViewById2 = viewGroup.findViewById(16908314);
        this.s = findViewById2;
        findViewById2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.s.setVisibility(0);
            i |= 2;
        }
        Button findViewById3 = viewGroup.findViewById(16908315);
        this.w = findViewById3;
        findViewById3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i4 = this.d;
                drawable3.setBounds(0, 0, i4, i4);
                this.w.setCompoundDrawables(this.z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.w.setVisibility(0);
            i |= 4;
        }
        if (A(this.a)) {
            if (i == 1) {
                button = this.o;
            } else if (i == 2) {
                button = this.s;
            } else if (i == 4) {
                button = this.w;
            }
            b(button);
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void w(ViewGroup viewGroup) {
        NestedScrollView findViewById = this.c.findViewById(c.f.w);
        this.A = findViewById;
        findViewById.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView findViewById2 = viewGroup.findViewById(16908299);
        this.F = findViewById2;
        if (findViewById2 == null) {
            return;
        }
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            findViewById2.setText(charSequence);
            return;
        }
        findViewById2.setVisibility(8);
        this.A.removeView(this.F);
        if (this.g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup parent = this.A.getParent();
        int indexOfChild = parent.indexOfChild(this.A);
        parent.removeViewAt(indexOfChild);
        parent.addView(this.g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void x(ViewGroup viewGroup) {
        View view = this.h;
        if (view == null) {
            view = this.i != 0 ? LayoutInflater.from(this.a).inflate(this.i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.c.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout findViewById = this.c.findViewById(c.f.n);
        findViewById.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.n) {
            findViewById.setPadding(this.j, this.k, this.l, this.m);
        }
        if (this.g != null) {
            ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
        }
    }

    public final void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            viewGroup = this.c.findViewById(c.f.O);
        } else {
            this.D = this.c.findViewById(16908294);
            if ((!TextUtils.isEmpty(this.e)) && this.P) {
                TextView findViewById = this.c.findViewById(c.f.j);
                this.E = findViewById;
                findViewById.setText(this.e);
                int i = this.B;
                if (i != 0) {
                    this.D.setImageResource(i);
                    return;
                }
                Drawable drawable = this.C;
                if (drawable != null) {
                    this.D.setImageDrawable(drawable);
                    return;
                } else {
                    this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                    this.D.setVisibility(8);
                    return;
                }
            }
            this.c.findViewById(c.f.O).setVisibility(8);
            this.D.setVisibility(8);
        }
        viewGroup.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5 A[PHI: r1
      0x00a5: PHI (r1v6 android.view.View) = (r1v5 android.view.View), (r1v13 android.view.View) binds: [B:54:0x00a3, B:26:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z() {
        /*
            r8 = this;
            android.view.Window r0 = r8.c
            int r1 = c.f.t
            android.view.View r0 = r0.findViewById(r1)
            int r1 = c.f.P
            android.view.View r1 = r0.findViewById(r1)
            int r2 = c.f.m
            android.view.View r2 = r0.findViewById(r2)
            int r3 = c.f.k
            android.view.View r3 = r0.findViewById(r3)
            int r4 = c.f.o
            android.view.View r0 = r0.findViewById(r4)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r8.x(r0)
            int r4 = c.f.P
            android.view.View r4 = r0.findViewById(r4)
            int r5 = c.f.m
            android.view.View r5 = r0.findViewById(r5)
            int r6 = c.f.k
            android.view.View r6 = r0.findViewById(r6)
            android.view.ViewGroup r1 = r8.j(r4, r1)
            android.view.ViewGroup r2 = r8.j(r5, r2)
            android.view.ViewGroup r3 = r8.j(r6, r3)
            r8.w(r2)
            r8.v(r3)
            r8.y(r1)
            int r0 = r0.getVisibility()
            r4 = 8
            r5 = 1
            r6 = 0
            if (r0 == r4) goto L58
            r0 = 1
            goto L59
        L58:
            r0 = 0
        L59:
            if (r1 == 0) goto L63
            int r7 = r1.getVisibility()
            if (r7 == r4) goto L63
            r7 = 1
            goto L64
        L63:
            r7 = 0
        L64:
            if (r3 == 0) goto L6e
            int r3 = r3.getVisibility()
            if (r3 == r4) goto L6e
            r3 = 1
            goto L6f
        L6e:
            r3 = 0
        L6f:
            if (r3 != 0) goto L7e
            if (r2 == 0) goto L7e
            int r4 = c.f.K
            android.view.View r4 = r2.findViewById(r4)
            if (r4 == 0) goto L7e
            r4.setVisibility(r6)
        L7e:
            if (r7 == 0) goto L9b
            androidx.core.widget.NestedScrollView r4 = r8.A
            if (r4 == 0) goto L87
            r4.setClipToPadding(r5)
        L87:
            java.lang.CharSequence r4 = r8.f
            if (r4 != 0) goto L92
            android.widget.ListView r4 = r8.g
            if (r4 == 0) goto L90
            goto L92
        L90:
            r1 = 0
            goto L98
        L92:
            int r4 = c.f.N
            android.view.View r1 = r1.findViewById(r4)
        L98:
            if (r1 == 0) goto La8
            goto La5
        L9b:
            if (r2 == 0) goto La8
            int r1 = c.f.L
            android.view.View r1 = r2.findViewById(r1)
            if (r1 == 0) goto La8
        La5:
            r1.setVisibility(r6)
        La8:
            android.widget.ListView r1 = r8.g
            boolean r4 = r1 instanceof androidx.appcompat.app.AlertController.RecycleListView
            if (r4 == 0) goto Lb3
            androidx.appcompat.app.AlertController$RecycleListView r1 = (androidx.appcompat.app.AlertController.RecycleListView) r1
            r1.a(r7, r3)
        Lb3:
            if (r0 != 0) goto Lc7
            android.widget.ListView r0 = r8.g
            if (r0 == 0) goto Lba
            goto Lbc
        Lba:
            androidx.core.widget.NestedScrollView r0 = r8.A
        Lbc:
            if (r0 == 0) goto Lc7
            if (r3 == 0) goto Lc1
            r6 = 2
        Lc1:
            r1 = r7 | r6
            r3 = 3
            r8.q(r2, r0, r1, r3)
        Lc7:
            android.widget.ListView r0 = r8.g
            if (r0 == 0) goto Ldd
            android.widget.ListAdapter r1 = r8.H
            if (r1 == 0) goto Ldd
            r0.setAdapter(r1)
            int r1 = r8.I
            r2 = -1
            if (r1 <= r2) goto Ldd
            r0.setItemChecked(r1, r5)
            r0.setSelection(r1)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.z():void");
    }
}
