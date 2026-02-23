package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.SearchEditText;
import androidx.leanback.widget.SearchOrbView;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SearchBar extends RelativeLayout {
    public static final String C = "SearchBar";
    public AudioManager A;
    public l B;
    public k a;
    public SearchEditText c;
    public SpeechOrbView d;
    public ImageView e;
    public String f;
    public String g;
    public String h;
    public Drawable i;
    public final Handler j;
    public final InputMethodManager k;
    public boolean l;
    public Drawable m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public int r;
    public int s;
    public int t;
    public SpeechRecognizer u;
    public boolean v;
    public SoundPool w;
    public SparseIntArray x;
    public boolean y;
    public final Context z;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void run() {
            SearchBar.this.w.play(SearchBar.this.x.get(this.a), 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchBar searchBar = SearchBar.this;
            if (z) {
                searchBar.h();
            } else {
                searchBar.a();
            }
            SearchBar.this.n(z);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            SearchBar searchBar = SearchBar.this;
            searchBar.setSearchQueryInternal(searchBar.c.getText().toString());
        }
    }

    public class d implements TextWatcher {
        public final /* synthetic */ Runnable a;

        public d(Runnable runnable) {
            this.a = runnable;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchBar searchBar = SearchBar.this;
            if (searchBar.y) {
                return;
            }
            searchBar.j.removeCallbacks(this.a);
            SearchBar.this.j.post(this.a);
        }
    }

    public class e implements SearchEditText.a {
        public e() {
        }

        public void a() {
            SearchBar searchBar = SearchBar.this;
            k kVar = searchBar.a;
            if (kVar != null) {
                kVar.b(searchBar.f);
            }
        }
    }

    public class f implements TextView.OnEditorActionListener {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SearchBar.this.k();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                SearchBar searchBar = SearchBar.this;
                searchBar.a.b(searchBar.f);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                SearchBar searchBar = SearchBar.this;
                searchBar.l = true;
                searchBar.d.requestFocus();
            }
        }

        public f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x001e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onEditorAction(android.widget.TextView r4, int r5, android.view.KeyEvent r6) {
            /*
                r3 = this;
                r4 = 3
                r0 = 500(0x1f4, double:2.47E-321)
                r6 = 1
                if (r4 == r5) goto L8
                if (r5 != 0) goto L1e
            L8:
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                androidx.leanback.widget.SearchBar$k r2 = r4.a
                if (r2 == 0) goto L1e
                r4.a()
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                android.os.Handler r4 = r4.j
                androidx.leanback.widget.SearchBar$f$a r5 = new androidx.leanback.widget.SearchBar$f$a
                r5.<init>()
            L1a:
                r4.postDelayed(r5, r0)
                goto L46
            L1e:
                if (r6 != r5) goto L33
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                androidx.leanback.widget.SearchBar$k r2 = r4.a
                if (r2 == 0) goto L33
                r4.a()
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                android.os.Handler r4 = r4.j
                androidx.leanback.widget.SearchBar$f$b r5 = new androidx.leanback.widget.SearchBar$f$b
                r5.<init>()
                goto L1a
            L33:
                r4 = 2
                if (r4 != r5) goto L45
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                r4.a()
                androidx.leanback.widget.SearchBar r4 = androidx.leanback.widget.SearchBar.this
                android.os.Handler r4 = r4.j
                androidx.leanback.widget.SearchBar$f$c r5 = new androidx.leanback.widget.SearchBar$f$c
                r5.<init>()
                goto L1a
            L45:
                r6 = 0
            L46:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.SearchBar.f.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            SearchBar.this.l();
        }
    }

    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchBar searchBar = SearchBar.this;
            if (z) {
                searchBar.a();
                SearchBar searchBar2 = SearchBar.this;
                if (searchBar2.l) {
                    searchBar2.i();
                    SearchBar.this.l = false;
                }
            } else {
                searchBar.j();
            }
            SearchBar.this.n(z);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            SearchBar.this.c.requestFocusFromTouch();
            SearchBar.this.c.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, SearchBar.this.c.getWidth(), SearchBar.this.c.getHeight(), 0));
            SearchBar.this.c.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, SearchBar.this.c.getWidth(), SearchBar.this.c.getHeight(), 0));
        }
    }

    public class j implements RecognitionListener {
        public j() {
        }

        public void onBeginningOfSpeech() {
        }

        public void onBufferReceived(byte[] bArr) {
        }

        public void onEndOfSpeech() {
        }

        public void onError(int i) {
            String str;
            String str2;
            switch (i) {
                case 1:
                    str = SearchBar.C;
                    str2 = "recognizer network timeout";
                    Log.w(str, str2);
                    break;
                case 2:
                    str = SearchBar.C;
                    str2 = "recognizer network error";
                    Log.w(str, str2);
                    break;
                case 3:
                    str = SearchBar.C;
                    str2 = "recognizer audio error";
                    Log.w(str, str2);
                    break;
                case 4:
                    str = SearchBar.C;
                    str2 = "recognizer server error";
                    Log.w(str, str2);
                    break;
                case 5:
                    str = SearchBar.C;
                    str2 = "recognizer client error";
                    Log.w(str, str2);
                    break;
                case 6:
                    str = SearchBar.C;
                    str2 = "recognizer speech timeout";
                    Log.w(str, str2);
                    break;
                case 7:
                    str = SearchBar.C;
                    str2 = "recognizer no match";
                    Log.w(str, str2);
                    break;
                case 8:
                    str = SearchBar.C;
                    str2 = "recognizer busy";
                    Log.w(str, str2);
                    break;
                case 9:
                    str = SearchBar.C;
                    str2 = "recognizer insufficient permissions";
                    Log.w(str, str2);
                    break;
                default:
                    Log.d(SearchBar.C, "recognizer other error");
                    break;
            }
            SearchBar.this.j();
            SearchBar.this.e();
        }

        public void onEvent(int i, Bundle bundle) {
        }

        public void onPartialResults(Bundle bundle) {
            ArrayList stringArrayList = bundle.getStringArrayList("results_recognition");
            if (stringArrayList == null || stringArrayList.size() == 0) {
                return;
            }
            SearchBar.this.c.g((String) stringArrayList.get(0), stringArrayList.size() > 1 ? (String) stringArrayList.get(1) : null);
        }

        public void onReadyForSpeech(Bundle bundle) {
            SearchBar.this.d.f();
            SearchBar.this.f();
        }

        public void onResults(Bundle bundle) {
            ArrayList stringArrayList = bundle.getStringArrayList("results_recognition");
            if (stringArrayList != null) {
                SearchBar.this.f = (String) stringArrayList.get(0);
                SearchBar searchBar = SearchBar.this;
                searchBar.c.setText(searchBar.f);
                SearchBar.this.k();
            }
            SearchBar.this.j();
            SearchBar.this.g();
        }

        public void onRmsChanged(float f) {
            SearchBar.this.d.setSoundLevel(f < 0.0f ? 0 : (int) (f * 10.0f));
        }
    }

    public interface k {
        void a(String str);

        void b(String str);

        void c(String str);
    }

    public interface l {
        void a();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        this.k.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }

    public final boolean b() {
        return this.d.isFocused();
    }

    public final void c(Context context) {
        int[] iArr = {g0.i.a, g0.i.c, g0.i.b, g0.i.d};
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[i2];
            this.x.put(i3, this.w.load(context, i3, 1));
        }
    }

    public final void d(int i2) {
        this.j.post(new a(i2));
    }

    public void e() {
        d(g0.i.a);
    }

    public void f() {
        d(g0.i.c);
    }

    public void g() {
        d(g0.i.d);
    }

    public Drawable getBadgeDrawable() {
        return this.i;
    }

    public CharSequence getHint() {
        return this.g;
    }

    public String getTitle() {
        return this.h;
    }

    public void h() {
        this.j.post(new i());
    }

    public void i() {
        l lVar;
        if (this.y) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.u == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            if (Build.VERSION.SDK_INT < 23 || (lVar = this.B) == null) {
                throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
            }
            lVar.a();
            return;
        }
        this.y = true;
        this.c.setText("");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.u.setRecognitionListener(new j());
        this.v = true;
        this.u.startListening(intent);
    }

    public void j() {
        if (this.y) {
            this.c.setText(this.f);
            this.c.setHint(this.g);
            this.y = false;
            if (this.u == null) {
                return;
            }
            this.d.g();
            if (this.v) {
                this.u.cancel();
                this.v = false;
            }
            this.u.setRecognitionListener((RecognitionListener) null);
        }
    }

    public void k() {
        k kVar;
        if (TextUtils.isEmpty(this.f) || (kVar = this.a) == null) {
            return;
        }
        kVar.c(this.f);
    }

    public void l() {
        if (this.y) {
            j();
        } else {
            i();
        }
    }

    public final void m() {
        String string = getResources().getString(g0.j.a);
        if (!TextUtils.isEmpty(this.h)) {
            string = b() ? getResources().getString(g0.j.d, new Object[]{this.h}) : getResources().getString(g0.j.c, new Object[]{this.h});
        } else if (b()) {
            string = getResources().getString(g0.j.b);
        }
        this.g = string;
        SearchEditText searchEditText = this.c;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public void n(boolean z) {
        SearchEditText searchEditText;
        int i2;
        SearchEditText searchEditText2;
        int i3;
        if (z) {
            this.m.setAlpha(this.s);
            if (b()) {
                searchEditText2 = this.c;
                i3 = this.q;
            } else {
                searchEditText2 = this.c;
                i3 = this.o;
            }
            searchEditText2.setTextColor(i3);
            searchEditText = this.c;
            i2 = this.q;
        } else {
            this.m.setAlpha(this.r);
            this.c.setTextColor(this.n);
            searchEditText = this.c;
            i2 = this.p;
        }
        searchEditText.setHintTextColor(i2);
        m();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = new SoundPool(2, 1, 0);
        c(this.z);
    }

    public void onDetachedFromWindow() {
        j();
        this.w.release();
        super.onDetachedFromWindow();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.m = findViewById(g0.f.o).getBackground();
        this.c = findViewById(g0.f.q);
        ImageView findViewById = findViewById(g0.f.n);
        this.e = findViewById;
        Drawable drawable = this.i;
        if (drawable != null) {
            findViewById.setImageDrawable(drawable);
        }
        this.c.setOnFocusChangeListener(new b());
        this.c.addTextChangedListener(new d(new c()));
        this.c.setOnKeyboardDismissListener(new e());
        this.c.setOnEditorActionListener(new f());
        this.c.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView findViewById2 = findViewById(g0.f.p);
        this.d = findViewById2;
        findViewById2.setOnOrbClickedListener(new g());
        this.d.setOnFocusChangeListener(new h());
        n(hasFocus());
        m();
    }

    public void setBadgeDrawable(Drawable drawable) {
        ImageView imageView;
        int i2;
        this.i = drawable;
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
            if (drawable != null) {
                imageView = this.e;
                i2 = 0;
            } else {
                imageView = this.e;
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void setNextFocusDownId(int i2) {
        this.d.setNextFocusDownId(i2);
        this.c.setNextFocusDownId(i2);
    }

    public void setPermissionListener(l lVar) {
        this.B = lVar;
    }

    public void setSearchAffordanceColors(SearchOrbView.c cVar) {
        SpeechOrbView speechOrbView = this.d;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(cVar);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.c cVar) {
        SpeechOrbView speechOrbView = this.d;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(cVar);
        }
    }

    public void setSearchBarListener(k kVar) {
        this.a = kVar;
    }

    public void setSearchQuery(String str) {
        j();
        this.c.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.f, str)) {
            return;
        }
        this.f = str;
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(str);
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(U u) {
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        j();
        SpeechRecognizer speechRecognizer2 = this.u;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener((RecognitionListener) null);
            if (this.v) {
                this.u.cancel();
                this.v = false;
            }
        }
        this.u = speechRecognizer;
    }

    public void setTitle(String str) {
        this.h = str;
        m();
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new Handler();
        this.l = false;
        this.x = new SparseIntArray();
        this.y = false;
        this.z = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(g0.h.j, this, true);
        this.t = getResources().getDimensionPixelSize(g0.c.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.t);
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f = "";
        this.k = (InputMethodManager) context.getSystemService("input_method");
        this.o = resources.getColor(g0.b.i);
        this.n = resources.getColor(g0.b.h);
        this.s = resources.getInteger(g0.g.b);
        this.r = resources.getInteger(g0.g.c);
        this.q = resources.getColor(g0.b.g);
        this.p = resources.getColor(g0.b.f);
        this.A = (AudioManager) context.getSystemService("audio");
    }
}
