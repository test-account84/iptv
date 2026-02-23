package androidx.appcompat.widget;

import P.L;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.Y;
import k.d0;
import k.g0;
import k.m0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SearchView extends androidx.appcompat.widget.b implements i.c {
    public static final o t0;
    public Rect A;
    public Rect B;
    public int[] C;
    public int[] D;
    public final ImageView E;
    public final Drawable F;
    public final int G;
    public final int H;
    public final Intent I;
    public final Intent J;
    public final CharSequence K;
    public m L;
    public View.OnFocusChangeListener M;
    public View.OnClickListener N;
    public boolean O;
    public boolean P;
    public U.a Q;
    public boolean R;
    public CharSequence S;
    public boolean T;
    public boolean U;
    public int V;
    public boolean W;
    public CharSequence e0;
    public CharSequence f0;
    public boolean g0;
    public int h0;
    public SearchableInfo i0;
    public Bundle j0;
    public final Runnable k0;
    public Runnable l0;
    public final WeakHashMap m0;
    public final View.OnClickListener n0;
    public View.OnKeyListener o0;
    public final TextView.OnEditorActionListener p0;
    public final SearchAutoComplete q;
    public final AdapterView.OnItemClickListener q0;
    public final View r;
    public final AdapterView.OnItemSelectedListener r0;
    public final View s;
    public TextWatcher s0;
    public final View t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final View y;
    public q z;

    public static class SearchAutoComplete extends k.c {
        public int f;
        public SearchView g;
        public boolean h;
        public final Runnable i;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, c.a.m);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.t0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void d() {
            if (this.h) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.h = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.h) {
                removeCallbacks(this.i);
                post(this.i);
            }
            return onCreateInputConnection;
        }

        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.g.Z();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.g.hasFocus() && getVisibility() == 0) {
                this.h = true;
                if (SearchView.M(getContext())) {
                    b();
                }
            }
        }

        public void performCompletion() {
        }

        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.h = false;
                removeCallbacks(this.i);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.h = true;
                    return;
                }
                this.h = false;
                removeCallbacks(this.i);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.g = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new a();
            this.f = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.Y(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            SearchView.this.f0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            U.a aVar = SearchView.this.Q;
            if (aVar instanceof Y) {
                aVar.a(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.M;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.B();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.u) {
                searchView.V();
                return;
            }
            if (view == searchView.w) {
                searchView.R();
                return;
            }
            if (view == searchView.v) {
                searchView.W();
            } else if (view == searchView.x) {
                searchView.a0();
            } else if (view == searchView.q) {
                searchView.H();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.i0 == null) {
                return false;
            }
            if (searchView.q.isPopupShowing() && SearchView.this.q.getListSelection() != -1) {
                return SearchView.this.X(view, i, keyEvent);
            }
            if (SearchView.this.q.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.q.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.S(i, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.T(i);
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    public interface l {
    }

    public interface m {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface n {
    }

    public static class o {
        public Method a;
        public Method b;
        public Method c;

        public o() {
            this.a = null;
            this.b = null;
            this.c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", (Class[]) null);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", (Class[]) null);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, (Object[]) null);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, (Object[]) null);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class p extends V.a {
        public static final Parcelable.Creator CREATOR = new a();
        public boolean d;

        public class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i) {
                return new p[i];
            }
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.d + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.d));
        }

        public p(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class q extends TouchDelegate {
        public final View a;
        public final Rect b;
        public final Rect c;
        public final Rect d;
        public final int e;
        public boolean f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.c.set(rect2);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float f;
            int i;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.b.contains(x, y)) {
                    this.f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.c.contains(x, y)) {
                Rect rect = this.c;
                f = x - rect.left;
                i = y - rect.top;
            } else {
                f = this.a.getWidth() / 2;
                i = this.a.getHeight() / 2;
            }
            motionEvent.setLocation(f, i);
            return this.a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        t0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(c.d.e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(c.d.f);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void B() {
        if (this.y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.s.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = m0.b(this);
            int dimensionPixelSize = this.O ? resources.getDimensionPixelSize(c.d.c) + resources.getDimensionPixelSize(c.d.d) : 0;
            this.q.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.q.setDropDownHorizontalOffset(b2 ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.q.setDropDownWidth((((this.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent C(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.j0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.i0.getSearchActivity());
        return intent;
    }

    public final Intent D(Cursor cursor, int i2, String str) {
        int i3;
        String o2;
        try {
            String o3 = Y.o(cursor, "suggest_intent_action");
            if (o3 == null) {
                o3 = this.i0.getSuggestIntentAction();
            }
            if (o3 == null) {
                o3 = "android.intent.action.SEARCH";
            }
            String str2 = o3;
            String o4 = Y.o(cursor, "suggest_intent_data");
            if (o4 == null) {
                o4 = this.i0.getSuggestIntentData();
            }
            if (o4 != null && (o2 = Y.o(cursor, "suggest_intent_data_id")) != null) {
                o4 = o4 + "/" + Uri.encode(o2);
            }
            return C(str2, o4 == null ? null : Uri.parse(o4), Y.o(cursor, "suggest_intent_extra_data"), Y.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    public final Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.j0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void G() {
        this.q.dismissDropDown();
    }

    public void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.q);
            return;
        }
        o oVar = t0;
        oVar.b(this.q);
        oVar.a(this.q);
    }

    public final void I(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i2 = iArr[1];
        int[] iArr2 = this.D;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    public final CharSequence J(CharSequence charSequence) {
        if (!this.O || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (this.q.getTextSize() * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean K() {
        SearchableInfo searchableInfo = this.i0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.i0.getVoiceSearchLaunchWebSearch() ? this.I : this.i0.getVoiceSearchLaunchRecognizer() ? this.J : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean L() {
        return this.P;
    }

    public final boolean N() {
        return (this.R || this.W) && !L();
    }

    public final void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    public void P(int i2, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    public final boolean Q(int i2, int i3, String str) {
        Cursor d2 = this.Q.d();
        if (d2 == null || !d2.moveToPosition(i2)) {
            return false;
        }
        O(D(d2, i3, str));
        return true;
    }

    public void R() {
        if (!TextUtils.isEmpty(this.q.getText())) {
            this.q.setText("");
            this.q.requestFocus();
            this.q.setImeVisibility(true);
        } else if (this.O) {
            clearFocus();
            k0(true);
        }
    }

    public boolean S(int i2, int i3, String str) {
        Q(i2, 0, null);
        this.q.setImeVisibility(false);
        G();
        return true;
    }

    public boolean T(int i2) {
        c0(i2);
        return true;
    }

    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void V() {
        k0(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.N;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void W() {
        Editable text = this.q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.L;
        if (mVar == null || !mVar.onQueryTextSubmit(text.toString())) {
            if (this.i0 != null) {
                P(0, null, text.toString());
            }
            this.q.setImeVisibility(false);
            G();
        }
    }

    public boolean X(View view, int i2, KeyEvent keyEvent) {
        if (this.i0 != null && this.Q != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return S(this.q.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.q.setSelection(i2 == 21 ? 0 : this.q.length());
                this.q.setListSelection(0);
                this.q.clearListSelection();
                this.q.b();
                return true;
            }
            if (i2 == 19) {
                this.q.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void Y(CharSequence charSequence) {
        Editable text = this.q.getText();
        this.f0 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        j0(!isEmpty);
        l0(isEmpty);
        e0();
        i0();
        if (this.L != null && !TextUtils.equals(charSequence, this.e0)) {
            this.L.onQueryTextChange(charSequence.toString());
        }
        this.e0 = charSequence.toString();
    }

    public void Z() {
        k0(L());
        b0();
        if (this.q.hasFocus()) {
            H();
        }
    }

    public void a0() {
        Intent E;
        SearchableInfo searchableInfo = this.i0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                E = F(this.I, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                E = E(this.J, searchableInfo);
            }
            getContext().startActivity(E);
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void b() {
        if (this.g0) {
            return;
        }
        this.g0 = true;
        int imeOptions = this.q.getImeOptions();
        this.h0 = imeOptions;
        this.q.setImeOptions(imeOptions | 33554432);
        this.q.setText("");
        setIconified(false);
    }

    public final void b0() {
        post(this.k0);
    }

    public final void c0(int i2) {
        CharSequence b2;
        Editable text = this.q.getText();
        Cursor d2 = this.Q.d();
        if (d2 == null) {
            return;
        }
        if (!d2.moveToPosition(i2) || (b2 = this.Q.b(d2)) == null) {
            setQuery(text);
        } else {
            setQuery(b2);
        }
    }

    public void clearFocus() {
        this.U = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.U = false;
    }

    public void d0(CharSequence charSequence, boolean z) {
        this.q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    public final void e0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        if (!z2 && (!this.O || this.g0)) {
            z = false;
        }
        this.w.setVisibility(z ? 0 : 8);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.q.setImeOptions(this.h0);
        this.g0 = false;
    }

    public void f0() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void g0() {
        String queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.V;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.S;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.i0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.i0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    public int getSuggestionRowLayout() {
        return this.G;
    }

    public U.a getSuggestionsAdapter() {
        return this.Q;
    }

    public final void h0() {
        this.q.setThreshold(this.i0.getSuggestThreshold());
        this.q.setImeOptions(this.i0.getImeOptions());
        int inputType = this.i0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.i0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.q.setInputType(inputType);
        U.a aVar = this.Q;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.i0.getSuggestAuthority() != null) {
            Y y = new Y(getContext(), this, this.i0, this.m0);
            this.Q = y;
            this.q.setAdapter(y);
            ((Y) this.Q).x(this.T ? 2 : 1);
        }
    }

    public final void i0() {
        this.t.setVisibility((N() && (this.v.getVisibility() == 0 || this.x.getVisibility() == 0)) ? 0 : 8);
    }

    public final void j0(boolean z) {
        this.v.setVisibility((this.R && N() && hasFocus() && (z || !this.W)) ? 0 : 8);
    }

    public final void k0(boolean z) {
        this.P = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(i3);
        j0(!isEmpty);
        this.r.setVisibility(z ? 8 : 0);
        if (this.E.getDrawable() != null && !this.O) {
            i2 = 0;
        }
        this.E.setVisibility(i2);
        e0();
        l0(isEmpty);
        i0();
    }

    public final void l0(boolean z) {
        int i2 = 8;
        if (this.W && !L() && z) {
            this.v.setVisibility(8);
            i2 = 0;
        }
        this.x.setVisibility(i2);
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.k0);
        post(this.l0);
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I(this.q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            q qVar = this.z;
            if (qVar != null) {
                qVar.a(this.B, this.A);
                return;
            }
            q qVar2 = new q(this.B, this.A, this.q);
            this.z = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L30
            if (r0 == 0) goto L26
            if (r0 == r2) goto L1d
            goto L3a
        L1d:
            int r0 = r3.V
            if (r0 <= 0) goto L3a
        L21:
            int r4 = java.lang.Math.min(r0, r4)
            goto L3a
        L26:
            int r4 = r3.V
            if (r4 <= 0) goto L2b
            goto L3a
        L2b:
            int r4 = r3.getPreferredWidth()
            goto L3a
        L30:
            int r0 = r3.V
            if (r0 <= 0) goto L35
            goto L21
        L35:
            int r0 = r3.getPreferredWidth()
            goto L21
        L3a:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4c
            if (r0 == 0) goto L47
            goto L54
        L47:
            int r5 = r3.getPreferredHeight()
            goto L54
        L4c:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L54:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.a());
        k0(pVar.d);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.d = L();
        return pVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b0();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.U || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.q.requestFocus(i2, rect);
        if (requestFocus) {
            k0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.j0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.O == z) {
            return;
        }
        this.O = z;
        k0(z);
        g0();
    }

    public void setImeOptions(int i2) {
        this.q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.V = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.L = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.N = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.S = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.T = z;
        U.a aVar = this.Q;
        if (aVar instanceof Y) {
            ((Y) aVar).x(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.i0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.W = K;
        if (K) {
            this.q.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.R = z;
        k0(L());
    }

    public void setSuggestionsAdapter(U.a aVar) {
        this.Q = aVar;
        this.q.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.K);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.k0 = new b();
        this.l0 = new c();
        this.m0 = new WeakHashMap();
        f fVar = new f();
        this.n0 = fVar;
        this.o0 = new g();
        h hVar = new h();
        this.p0 = hVar;
        i iVar = new i();
        this.q0 = iVar;
        j jVar = new j();
        this.r0 = jVar;
        this.s0 = new a();
        d0 v = d0.v(context, attributeSet, c.j.n2, i2, 0);
        L.q0(this, context, c.j.n2, attributeSet, v.r(), i2, 0);
        LayoutInflater.from(context).inflate(v.n(c.j.x2, c.g.r), this, true);
        SearchAutoComplete findViewById = findViewById(c.f.D);
        this.q = findViewById;
        findViewById.setSearchView(this);
        this.r = findViewById(c.f.z);
        View findViewById2 = findViewById(c.f.C);
        this.s = findViewById2;
        View findViewById3 = findViewById(c.f.J);
        this.t = findViewById3;
        ImageView findViewById4 = findViewById(c.f.x);
        this.u = findViewById4;
        ImageView findViewById5 = findViewById(c.f.A);
        this.v = findViewById5;
        ImageView findViewById6 = findViewById(c.f.y);
        this.w = findViewById6;
        ImageView findViewById7 = findViewById(c.f.E);
        this.x = findViewById7;
        ImageView findViewById8 = findViewById(c.f.B);
        this.E = findViewById8;
        L.w0(findViewById2, v.g(c.j.y2));
        L.w0(findViewById3, v.g(c.j.C2));
        findViewById4.setImageDrawable(v.g(c.j.B2));
        findViewById5.setImageDrawable(v.g(c.j.v2));
        findViewById6.setImageDrawable(v.g(c.j.s2));
        findViewById7.setImageDrawable(v.g(c.j.E2));
        findViewById8.setImageDrawable(v.g(c.j.B2));
        this.F = v.g(c.j.A2);
        g0.a(findViewById4, getResources().getString(c.h.n));
        this.G = v.n(c.j.D2, c.g.q);
        this.H = v.n(c.j.t2, 0);
        findViewById4.setOnClickListener(fVar);
        findViewById6.setOnClickListener(fVar);
        findViewById5.setOnClickListener(fVar);
        findViewById7.setOnClickListener(fVar);
        findViewById.setOnClickListener(fVar);
        findViewById.addTextChangedListener(this.s0);
        findViewById.setOnEditorActionListener(hVar);
        findViewById.setOnItemClickListener(iVar);
        findViewById.setOnItemSelectedListener(jVar);
        findViewById.setOnKeyListener(this.o0);
        findViewById.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v.a(c.j.w2, true));
        int f2 = v.f(c.j.p2, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.K = v.p(c.j.u2);
        this.S = v.p(c.j.z2);
        int k2 = v.k(c.j.r2, -1);
        if (k2 != -1) {
            setImeOptions(k2);
        }
        int k3 = v.k(c.j.q2, -1);
        if (k3 != -1) {
            setInputType(k3);
        }
        setFocusable(v.a(c.j.o2, true));
        v.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById9 = findViewById(findViewById.getDropDownAnchor());
        this.y = findViewById9;
        if (findViewById9 != null) {
            findViewById9.addOnLayoutChangeListener(new e());
        }
        k0(this.O);
        g0();
    }
}
