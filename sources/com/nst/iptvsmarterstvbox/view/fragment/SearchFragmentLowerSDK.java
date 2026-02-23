package com.nst.iptvsmarterstvbox.view.fragment;

import a7.f;
import a7.g;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.leanback.widget.v;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import m7.w;
import org.joda.time.LocalDateTime;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SearchFragmentLowerSDK extends Fragment implements Filterable {
    public androidx.leanback.widget.a c;
    public String d;
    public LiveStreamDBHandler g;
    public Context h;
    public EditText l;
    public final Handler a = new Handler();
    public boolean e = false;
    public e f = new e(this, null);
    public boolean i = false;
    public ArrayList j = new ArrayList();
    public final int k = 1;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchFragmentLowerSDK.a(SearchFragmentLowerSDK.this).filter(charSequence.toString());
        }
    }

    public class b extends AsyncTask {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList doInBackground(String... strArr) {
            return SearchFragmentLowerSDK.h(SearchFragmentLowerSDK.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:3:0x0069 A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:14:0x0005, B:16:0x000b, B:18:0x0041, B:20:0x004f, B:22:0x005d, B:4:0x007f, B:6:0x0087, B:3:0x0069), top: B:13:0x0005 }] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.ArrayList r3) {
            /*
                r2 = this;
                super.onPostExecute(r3)
                if (r3 == 0) goto L69
                int r0 = r3.size()     // Catch: java.lang.Exception -> L99
                if (r0 <= 0) goto L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                r1 = 1
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.e(r0, r1)     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r0     // Catch: java.lang.Exception -> L99
                r0.i()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r0     // Catch: java.lang.Exception -> L99
                r1 = 0
                r0.z(r3, r1)     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                r3.J()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                boolean r3 = r3.b()     // Catch: java.lang.Exception -> L99
                if (r3 != 0) goto L7f
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                boolean r3 = r3.c()     // Catch: java.lang.Exception -> L99
                if (r3 != 0) goto L7f
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                boolean r3 = r3.d()     // Catch: java.lang.Exception -> L99
                if (r3 != 0) goto L7f
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                r3.I()     // Catch: java.lang.Exception -> L99
                goto L7f
            L69:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                r3.k()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                r3.j()     // Catch: java.lang.Exception -> L99
            L7f:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                boolean r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.d(r3)     // Catch: java.lang.Exception -> L99
                if (r3 != 0) goto L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.i(r3)     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L99
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L99
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L99
                java.lang.String r0 = "No Record Found"
                r3.H(r0)     // Catch: java.lang.Exception -> L99
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.b.onPostExecute(java.util.ArrayList):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class c extends AsyncTask {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList doInBackground(String... strArr) {
            return SearchFragmentLowerSDK.g(SearchFragmentLowerSDK.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x014d A[Catch: Exception -> 0x0175, TRY_LEAVE, TryCatch #2 {Exception -> 0x0175, blocks: (B:50:0x00dd, B:52:0x00e3, B:53:0x0136, B:5:0x0147, B:4:0x014d), top: B:2:0x0003 }] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.ArrayList r10) {
            /*
                Method dump skipped, instructions count: 399
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.c.onPostExecute(java.util.ArrayList):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class d extends AsyncTask {
        public d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList doInBackground(String... strArr) {
            return SearchFragmentLowerSDK.c(SearchFragmentLowerSDK.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:3:0x004b A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #0 {Exception -> 0x0049, blocks: (B:13:0x0005, B:15:0x000b, B:3:0x004b), top: B:12:0x0005 }] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.ArrayList r3) {
            /*
                r2 = this;
                super.onPostExecute(r3)
                if (r3 == 0) goto L4b
                int r0 = r3.size()     // Catch: java.lang.Exception -> L49
                if (r0 <= 0) goto L4b
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                r1 = 1
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.e(r0, r1)     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r0     // Catch: java.lang.Exception -> L49
                r0.i()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r0     // Catch: java.lang.Exception -> L49
                r0.j()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r0     // Catch: java.lang.Exception -> L49
                r0.C(r3)     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L49
                r3.L()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L49
                r3.K()     // Catch: java.lang.Exception -> L49
                goto L7c
            L49:
                r3 = move-exception
                goto L62
            L4b:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L49
                r3.m()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this     // Catch: java.lang.Exception -> L49
                android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK) r3     // Catch: java.lang.Exception -> L49
                r3.l()     // Catch: java.lang.Exception -> L49
                goto L7c
            L62:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onPostExecute: "
                r0.append(r1)
                java.lang.String r3 = r3.getMessage()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                java.lang.String r0 = "SearchFragmentLowerSDK"
                android.util.Log.e(r0, r3)
            L7c:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK$c r3 = new com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK$c
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this
                r3.<init>()
                java.util.concurrent.Executor r0 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK r1 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.this
                java.lang.String r1 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.f(r1)
                java.lang.String[] r1 = new java.lang.String[]{r1}
                android.os.AsyncTask r3 = r3.executeOnExecutor(r0, r1)
                m7.w.p = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragmentLowerSDK.d.onPostExecute(java.util.ArrayList):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class e extends Filter {
        public e() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            SearchFragmentLowerSDK.b(SearchFragmentLowerSDK.this, charSequence.toString().toLowerCase());
            return new Filter.FilterResults();
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        }

        public /* synthetic */ e(SearchFragmentLowerSDK searchFragmentLowerSDK, a aVar) {
            this();
        }
    }

    public static /* synthetic */ e a(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.f;
    }

    public static /* synthetic */ void b(SearchFragmentLowerSDK searchFragmentLowerSDK, String str) {
        searchFragmentLowerSDK.n(str);
    }

    public static /* synthetic */ ArrayList c(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.l();
    }

    public static /* synthetic */ boolean d(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.i;
    }

    public static /* synthetic */ boolean e(SearchFragmentLowerSDK searchFragmentLowerSDK, boolean z) {
        searchFragmentLowerSDK.i = z;
        return z;
    }

    public static /* synthetic */ String f(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.d;
    }

    public static /* synthetic */ ArrayList g(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.k();
    }

    public static /* synthetic */ ArrayList h(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        return searchFragmentLowerSDK.j();
    }

    public static /* synthetic */ void i(SearchFragmentLowerSDK searchFragmentLowerSDK) {
        searchFragmentLowerSDK.m();
    }

    public Filter getFilter() {
        return this.f;
    }

    public final ArrayList j() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(new u7.a(this.h).C()));
        return this.g.getEPGSearch(this.d, simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + w.S(this.h))));
    }

    public final ArrayList k() {
        return this.g.getSearchRecords(this.d);
    }

    public final ArrayList l() {
        return this.g.getSearchRecordsSeries(this.d);
    }

    public final void m() {
        ((SearchActivityLowerSDK) getActivity()).f();
        ((SearchActivityLowerSDK) getActivity()).h();
        ((SearchActivityLowerSDK) getActivity()).m();
        ((SearchActivityLowerSDK) getActivity()).k();
        ((SearchActivityLowerSDK) getActivity()).e();
        ((SearchActivityLowerSDK) getActivity()).g();
        ((SearchActivityLowerSDK) getActivity()).l();
        ((SearchActivityLowerSDK) getActivity()).j();
    }

    public final void n(String str) {
        AsyncTask asyncTask = w.p;
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            w.p.cancel(true);
        }
        this.i = false;
        if (!TextUtils.isEmpty(str) && !str.equals("nil")) {
            this.d = str;
            w.p = new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else {
            Log.e("SearchFragmentLowerSDK", "loadQuery: hide all tabs");
            m();
            ((SearchActivityLowerSDK) getActivity()).H("Search any Channel, Movies and Series");
        }
    }

    public final void o() {
        EditText editText = this.l;
        if (editText != null) {
            editText.addTextChangedListener(new a());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new androidx.leanback.widget.a(new v());
        this.h = getActivity();
        this.g = new LiveStreamDBHandler(this.h);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(false);
        View inflate = layoutInflater.inflate(g.V2, viewGroup, false);
        this.l = inflate.findViewById(f.l3);
        o();
        return inflate;
    }
}
