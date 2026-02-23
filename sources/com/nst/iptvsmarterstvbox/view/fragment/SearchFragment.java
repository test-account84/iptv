package com.nst.iptvsmarterstvbox.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.leanback.widget.C;
import androidx.leanback.widget.E;
import androidx.leanback.widget.J;
import androidx.leanback.widget.M;
import androidx.leanback.widget.v;
import androidx.leanback.widget.y;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.SearchActivity;
import com.nst.iptvsmarterstvbox.view.fragment.a;
import d.D;
import g0.f;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import m7.w;
import org.joda.time.LocalDateTime;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SearchFragment extends com.nst.iptvsmarterstvbox.view.fragment.a implements a.i {
    public androidx.leanback.widget.a A;
    public String B;
    public LiveStreamDBHandler D;
    public Context E;
    public final Handler z = new Handler();
    public boolean C = false;
    public boolean F = false;
    public ArrayList G = new ArrayList();
    public final int H = 1;

    public class b extends AsyncTask {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList doInBackground(String... strArr) {
            return SearchFragment.s0(SearchFragment.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:3:0x006b A[Catch: Exception -> 0x0069, TryCatch #0 {Exception -> 0x0069, blocks: (B:16:0x0005, B:18:0x000b, B:20:0x0041, B:22:0x004f, B:24:0x005d, B:4:0x0081, B:6:0x0089, B:3:0x006b), top: B:15:0x0005 }] */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.ArrayList r3) {
            /*
                r2 = this;
                super.onPostExecute(r3)
                if (r3 == 0) goto L6b
                int r0 = r3.size()     // Catch: java.lang.Exception -> L69
                if (r0 <= 0) goto L6b
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                r1 = 1
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.p0(r0, r1)     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r0 = r0.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r0     // Catch: java.lang.Exception -> L69
                r0.x1()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r0 = r0.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r0     // Catch: java.lang.Exception -> L69
                r1 = 0
                r0.S1(r3, r1)     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                r3.c2()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                boolean r3 = r3.q1()     // Catch: java.lang.Exception -> L69
                if (r3 != 0) goto L81
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                boolean r3 = r3.r1()     // Catch: java.lang.Exception -> L69
                if (r3 != 0) goto L81
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                boolean r3 = r3.s1()     // Catch: java.lang.Exception -> L69
                if (r3 != 0) goto L81
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                r3.b2()     // Catch: java.lang.Exception -> L69
                goto L81
            L69:
                r3 = move-exception
                goto L9c
            L6b:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                r3.z1()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                r3.y1()     // Catch: java.lang.Exception -> L69
            L81:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                boolean r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.n0(r3)     // Catch: java.lang.Exception -> L69
                if (r3 != 0) goto L9f
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.t0(r3)     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L69
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L69
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = "No Record Found"
                r3.a2(r0)     // Catch: java.lang.Exception -> L69
                goto L9f
            L9c:
                r3.printStackTrace()
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.b.onPostExecute(java.util.ArrayList):void");
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
            return SearchFragment.r0(SearchFragment.this);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:3:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00e3 -> B:49:0x00e6). Please report as a decompilation issue!!! */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.ArrayList r10) {
            /*
                Method dump skipped, instructions count: 425
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.c.onPostExecute(java.util.ArrayList):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ c(SearchFragment searchFragment, a aVar) {
            this();
        }
    }

    public class d extends AsyncTask {
        public d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList doInBackground(String... strArr) {
            return SearchFragment.m0(SearchFragment.this);
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
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                r1 = 1
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.p0(r0, r1)     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r0     // Catch: java.lang.Exception -> L49
                r0.x1()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r0     // Catch: java.lang.Exception -> L49
                r0.y1()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r0 = r0.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r0 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r0     // Catch: java.lang.Exception -> L49
                r0.V1(r3)     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L49
                r3.e2()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L49
                r3.d2()     // Catch: java.lang.Exception -> L49
                goto L65
            L49:
                r3 = move-exception
                goto L62
            L4b:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L49
                r3.B1()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r3 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this     // Catch: java.lang.Exception -> L49
                androidx.fragment.app.e r3 = r3.getActivity()     // Catch: java.lang.Exception -> L49
                com.nst.iptvsmarterstvbox.view.activity.SearchActivity r3 = (com.nst.iptvsmarterstvbox.view.activity.SearchActivity) r3     // Catch: java.lang.Exception -> L49
                r3.A1()     // Catch: java.lang.Exception -> L49
                goto L65
            L62:
                r3.printStackTrace()
            L65:
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment$c r3 = new com.nst.iptvsmarterstvbox.view.fragment.SearchFragment$c
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r0 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this
                r1 = 0
                r3.<init>(r0, r1)
                java.util.concurrent.Executor r0 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
                com.nst.iptvsmarterstvbox.view.fragment.SearchFragment r1 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.this
                java.lang.String r1 = com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.q0(r1)
                java.lang.String[] r1 = new java.lang.String[]{r1}
                android.os.AsyncTask r3 = r3.executeOnExecutor(r0, r1)
                m7.w.p = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.fragment.SearchFragment.d.onPostExecute(java.util.ArrayList):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public final class e implements C {
        public e() {
        }

        public /* bridge */ /* synthetic */ void a(E.a aVar, Object obj, M.b bVar, Object obj2) {
            D.a(obj2);
            b(aVar, obj, bVar, null);
        }

        public void b(E.a aVar, Object obj, M.b bVar, J j) {
        }

        public /* synthetic */ e(SearchFragment searchFragment, a aVar) {
            this();
        }
    }

    public static /* synthetic */ ArrayList m0(SearchFragment searchFragment) {
        return searchFragment.A0();
    }

    public static /* synthetic */ boolean n0(SearchFragment searchFragment) {
        return searchFragment.F;
    }

    public static /* synthetic */ boolean p0(SearchFragment searchFragment, boolean z) {
        searchFragment.F = z;
        return z;
    }

    public static /* synthetic */ String q0(SearchFragment searchFragment) {
        return searchFragment.B;
    }

    public static /* synthetic */ ArrayList r0(SearchFragment searchFragment) {
        return searchFragment.z0();
    }

    public static /* synthetic */ ArrayList s0(SearchFragment searchFragment) {
        return searchFragment.x0();
    }

    public static /* synthetic */ void t0(SearchFragment searchFragment) {
        searchFragment.F0();
    }

    public final ArrayList A0() {
        return this.D.getSearchRecordsSeries(this.B);
    }

    public final boolean B0(String str) {
        androidx.fragment.app.e activity = getActivity();
        this.E = activity;
        return activity.getPackageManager().checkPermission(str, this.E.getPackageName()) == 0;
    }

    public boolean D0() {
        return this.A.i() > 0 && this.C;
    }

    public final void F0() {
        ((SearchActivity) getActivity()).u1();
        ((SearchActivity) getActivity()).w1();
        ((SearchActivity) getActivity()).B1();
        ((SearchActivity) getActivity()).z1();
        ((SearchActivity) getActivity()).t1();
        ((SearchActivity) getActivity()).v1();
        ((SearchActivity) getActivity()).A1();
        ((SearchActivity) getActivity()).y1();
    }

    public final void J0(String str) {
        AsyncTask asyncTask = w.p;
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            w.p.cancel(true);
        }
        this.F = false;
        if (TextUtils.isEmpty(str) || str.equals("nil")) {
            F0();
            ((SearchActivity) getActivity()).a2("Search any Channel, Movies and Series");
        } else {
            this.B = str;
            w.p = new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public y n() {
        return this.A;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 16) {
            return;
        }
        if (i2 == -1) {
            W(intent, true);
        } else {
            if (D0()) {
                return;
            }
            Log.v("SearchFragment", "Voice search canceled");
            getView().findViewById(f.p).requestFocus();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A = new androidx.leanback.widget.a(new v());
        this.E = getActivity();
        this.D = new LiveStreamDBHandler(this.E);
        E.d.b(this.E, "android.permission.RECORD_AUDIO");
        if (getActivity() != null) {
            D.b.h(getActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 1);
        }
        Z(this);
        T(new e(this, null));
        Log.d("SearchFragment", "User is initiating a search. Do we have RECORD_AUDIO permission? " + B0("android.permission.RECORD_AUDIO"));
        Log.d("SearchFragment", !B0("android.permission.RECORD_AUDIO") ? "Does not have RECORD_AUDIO, using SpeechRecognitionCallback" : "We DO have RECORD_AUDIO");
    }

    public void onPause() {
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        super.onPause();
    }

    public boolean onQueryTextChange(String str) {
        Log.i("SearchFragment", String.format("Search text changed: %s", new Object[]{str}));
        if (!str.equals(this.B)) {
            J0(str);
        }
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        Log.i("SearchFragment", String.format("Search text submitted: %s", new Object[]{str}));
        if (!str.equals(this.B)) {
            J0(str);
        }
        return true;
    }

    public final ArrayList x0() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(new u7.a(this.E).C()));
            return this.D.getEPGSearch(this.B, simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + w.S(this.E))));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final ArrayList z0() {
        return this.D.getSearchRecords(this.B);
    }
}
