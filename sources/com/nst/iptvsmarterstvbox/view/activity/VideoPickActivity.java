package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import a7.o;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.Mylist;
import d4.B;
import g7.m;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p7.k;
import q7.I;
import q7.h0;
import q7.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VideoPickActivity extends k {
    public String A;
    public int E;
    public Context H;
    public int g;
    public RecyclerView i;
    public h0 j;
    public boolean k;
    public boolean l;
    public List n;
    public ProgressBar o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public RelativeLayout s;
    public RelativeLayout t;
    public List u;
    public long v;
    public String w;
    public String x;
    public int y;
    public int z;
    public int h = 0;
    public ArrayList m = new ArrayList();
    public ArrayList B = new ArrayList();
    public int C = 0;
    public AsyncTask D = null;
    public m F = new m();
    public Handler G = new Handler();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("ResultPickVideo", VideoPickActivity.v1(VideoPickActivity.this));
            VideoPickActivity.this.setResult(-1, intent);
            VideoPickActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            VideoPickActivity videoPickActivity = VideoPickActivity.this;
            videoPickActivity.d.d(VideoPickActivity.w1(videoPickActivity));
        }
    }

    public class c implements p.b {
        public c() {
        }

        public void a(e7.c cVar) {
            if (VideoPickActivity.z1(VideoPickActivity.this) != null) {
                if (VideoPickActivity.A1(VideoPickActivity.this) != null && VideoPickActivity.A1(VideoPickActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                    VideoPickActivity.A1(VideoPickActivity.this).cancel(true);
                }
                VideoPickActivity.this.B.clear();
                VideoPickActivity.C1(VideoPickActivity.this).setAdapter((RecyclerView.g) null);
                VideoPickActivity.z1(VideoPickActivity.this).w();
            }
            VideoPickActivity videoPickActivity = VideoPickActivity.this;
            videoPickActivity.d.d(VideoPickActivity.w1(videoPickActivity));
            VideoPickActivity.D1(VideoPickActivity.this).setText(cVar.c());
            VideoPickActivity.this.u.clear();
            if (TextUtils.isEmpty(cVar.d())) {
                VideoPickActivity videoPickActivity2 = VideoPickActivity.this;
                VideoPickActivity.G1(videoPickActivity2, VideoPickActivity.E1(videoPickActivity2));
                return;
            }
            for (e7.c cVar2 : VideoPickActivity.E1(VideoPickActivity.this)) {
                if (cVar2.d().equals(cVar.d())) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cVar2);
                    VideoPickActivity.G1(VideoPickActivity.this, arrayList);
                    return;
                }
            }
        }
    }

    public class d implements d7.b {
        public d() {
        }

        public void a(List list) {
            VideoPickActivity.H1(VideoPickActivity.this).setVisibility(8);
            if (VideoPickActivity.this.e) {
                ArrayList arrayList = new ArrayList();
                e7.c cVar = new e7.c();
                cVar.f(VideoPickActivity.this.getResources().getString(j.F8));
                arrayList.add(cVar);
                arrayList.addAll(list);
                VideoPickActivity.this.d.a(arrayList);
            }
            VideoPickActivity.F1(VideoPickActivity.this, list);
            VideoPickActivity.G1(VideoPickActivity.this, list);
        }
    }

    public class e implements I {
        public e() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, e7.f fVar) {
            if (z) {
                VideoPickActivity.v1(VideoPickActivity.this).add(fVar);
                VideoPickActivity.J1(VideoPickActivity.this);
            } else {
                VideoPickActivity.v1(VideoPickActivity.this).remove(fVar);
                VideoPickActivity.K1(VideoPickActivity.this);
            }
            VideoPickActivity.y1(VideoPickActivity.this).setText(VideoPickActivity.I1(VideoPickActivity.this) + "/" + VideoPickActivity.x1(VideoPickActivity.this));
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            VideoPickActivity.B1(VideoPickActivity.this, VideoPickActivity.this.new g(0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
        }
    }

    public class g extends AsyncTask {
        public g(int i) {
            VideoPickActivity.this.E = 1;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            DecimalFormat decimalFormat;
            int i;
            m mVar;
            StringBuilder sb;
            int i2 = 0;
            try {
                decimalFormat = new DecimalFormat("#.##");
                VideoPickActivity.this.B.clear();
                i = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (i < VideoPickActivity.this.u.size()) {
                m mVar2 = VideoPickActivity.this.F;
                if (mVar2 != null) {
                    try {
                        mVar2.e();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if ((VideoPickActivity.A1(VideoPickActivity.this) != null && VideoPickActivity.A1(VideoPickActivity.this).isCancelled()) || ((mVar = VideoPickActivity.this.F) != null && mVar.b())) {
                    B.b("hgsdfhg", "hgshf");
                    break;
                }
                e7.f fVar = (e7.f) VideoPickActivity.this.u.get(i);
                long length = new File(fVar.x()).length();
                VideoPickActivity.this.v = length / 1024;
                float f = length / 1024;
                if (f >= 1048576) {
                    String valueOf = String.valueOf(Float.valueOf(decimalFormat.format(f / r8)).floatValue());
                    sb = new StringBuilder();
                    sb.append(valueOf);
                    sb.append(" GB");
                } else if (f >= 1024) {
                    String valueOf2 = String.valueOf(Float.valueOf(decimalFormat.format(f / 1024.0f)).floatValue());
                    sb = new StringBuilder();
                    sb.append(valueOf2);
                    sb.append(" MB");
                } else {
                    String valueOf3 = String.valueOf(f);
                    sb = new StringBuilder();
                    sb.append(valueOf3);
                    sb.append(" KB");
                }
                String sb2 = sb.toString();
                VideoPickActivity.this.w = fVar.x().substring(fVar.x().lastIndexOf("/") + 1);
                VideoPickActivity.this.x = fVar.x().substring(fVar.x().lastIndexOf(".") + 1);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fVar.x());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    VideoPickActivity.this.y = frameAtTime.getWidth();
                    VideoPickActivity.this.z = frameAtTime.getHeight();
                } catch (Exception unused) {
                    VideoPickActivity videoPickActivity = VideoPickActivity.this;
                    videoPickActivity.y = i2;
                    videoPickActivity.z = i2;
                }
                long lastModified = new File(fVar.x()).lastModified();
                VideoPickActivity.this.A = o.d(fVar.O());
                VideoPickActivity videoPickActivity2 = VideoPickActivity.this;
                videoPickActivity2.B.add(new Mylist(videoPickActivity2.w, lastModified, sb2, videoPickActivity2.y, videoPickActivity2.z, videoPickActivity2.A, videoPickActivity2.x));
                if (i == 10 || (i != 0 && i % 10 == 0)) {
                    publishProgress(new Integer[]{Integer.valueOf(i)});
                }
                i++;
                i2 = 0;
                e.printStackTrace();
            }
            return Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            VideoPickActivity videoPickActivity = VideoPickActivity.this;
            videoPickActivity.E = 0;
            VideoPickActivity.H1(videoPickActivity).setVisibility(8);
            VideoPickActivity.z1(VideoPickActivity.this).q0(VideoPickActivity.this.B);
            VideoPickActivity.z1(VideoPickActivity.this).w();
            VideoPickActivity.z1(VideoPickActivity.this).j0(VideoPickActivity.this.u);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            VideoPickActivity.H1(VideoPickActivity.this).setVisibility(8);
            VideoPickActivity.z1(VideoPickActivity.this).q0(VideoPickActivity.this.B);
            VideoPickActivity.z1(VideoPickActivity.this).w();
            VideoPickActivity.z1(VideoPickActivity.this).j0(VideoPickActivity.this.u);
        }

        public void onPreExecute() {
            VideoPickActivity.H1(VideoPickActivity.this).setVisibility(0);
            if (VideoPickActivity.A1(VideoPickActivity.this) == null || !VideoPickActivity.A1(VideoPickActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                return;
            }
            VideoPickActivity.A1(VideoPickActivity.this).cancel(true);
        }
    }

    public static /* synthetic */ AsyncTask A1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.D;
    }

    public static /* synthetic */ AsyncTask B1(VideoPickActivity videoPickActivity, AsyncTask asyncTask) {
        videoPickActivity.D = asyncTask;
        return asyncTask;
    }

    public static /* synthetic */ RecyclerView C1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.i;
    }

    public static /* synthetic */ TextView D1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.q;
    }

    public static /* synthetic */ List E1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.n;
    }

    public static /* synthetic */ List F1(VideoPickActivity videoPickActivity, List list) {
        videoPickActivity.n = list;
        return list;
    }

    public static /* synthetic */ void G1(VideoPickActivity videoPickActivity, List list) {
        videoPickActivity.O1(list);
    }

    public static /* synthetic */ ProgressBar H1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.o;
    }

    public static /* synthetic */ int I1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.h;
    }

    public static /* synthetic */ int J1(VideoPickActivity videoPickActivity) {
        int i = videoPickActivity.h;
        videoPickActivity.h = i + 1;
        return i;
    }

    public static /* synthetic */ int K1(VideoPickActivity videoPickActivity) {
        int i = videoPickActivity.h;
        videoPickActivity.h = i - 1;
        return i;
    }

    private boolean L1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e7.f fVar = (e7.f) it.next();
            if (fVar.x().equals(this.j.j)) {
                this.m.add(fVar);
                int i = this.h + 1;
                this.h = i;
                this.j.t0(i);
                this.p.setText(this.h + "/" + this.g);
                return true;
            }
        }
        return false;
    }

    private void M1() {
        TextView findViewById = findViewById(a7.f.oi);
        this.p = findViewById;
        findViewById.setText(this.h + "/" + this.g);
        this.i.setLayoutManager(new LinearLayoutManager(this));
        this.o = findViewById(a7.f.qc);
        if (new File(getExternalCacheDir().getAbsolutePath() + File.separator + "FilePick").exists()) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
        }
        RelativeLayout findViewById2 = findViewById(a7.f.ie);
        this.s = findViewById2;
        findViewById2.setOnClickListener(new a());
        this.t = findViewById(a7.f.Sg);
        LinearLayout findViewById3 = findViewById(a7.f.l8);
        this.r = findViewById3;
        if (this.e) {
            findViewById3.setVisibility(0);
            this.r.setOnClickListener(new b());
            TextView findViewById4 = findViewById(a7.f.sj);
            this.q = findViewById4;
            findViewById4.setText(getResources().getString(j.F8));
            try {
                this.d.c(new c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void N1() {
        c7.a.b(this, new d());
    }

    private void O1(List list) {
        boolean z = this.l;
        h0 h0Var = new h0(this, this.k, this.g);
        this.j = h0Var;
        this.i.setAdapter(h0Var);
        if (z && !TextUtils.isEmpty(this.j.j)) {
            z = !this.j.p0() && new File(this.j.j).exists();
        }
        this.u.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e7.c cVar = (e7.c) it.next();
            this.u.addAll(cVar.b());
            if (z) {
                z = L1(cVar.b());
            }
        }
        Iterator it2 = this.m.iterator();
        while (it2.hasNext()) {
            int indexOf = this.u.indexOf((e7.f) it2.next());
            if (indexOf != -1) {
                ((e7.f) this.u.get(indexOf)).M(true);
            }
        }
        this.j.k0(new e());
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.G.postDelayed(new f(), 1000L);
        }
    }

    public static /* synthetic */ ArrayList v1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.m;
    }

    public static /* synthetic */ RelativeLayout w1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.t;
    }

    public static /* synthetic */ int x1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.g;
    }

    public static /* synthetic */ TextView y1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.p;
    }

    public static /* synthetic */ h0 z1(VideoPickActivity videoPickActivity) {
        return videoPickActivity.j;
    }

    public void onCreate(Bundle bundle) {
        this.H = this;
        super.onCreate(bundle);
        setContentView(a7.g.Y4);
        if (new u7.a(this.H).A().equals(m7.a.K0)) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        this.u = new ArrayList();
        this.g = getIntent().getIntExtra("MaxNumber", 9);
        this.k = getIntent().getBooleanExtra("IsNeedCamera", false);
        this.l = getIntent().getBooleanExtra("IsTakenAutoSelected", true);
        RecyclerView findViewById = findViewById(a7.f.Gf);
        this.i = findViewById;
        findViewById.setNestedScrollingEnabled(false);
    }

    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.D;
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.D.cancel(true);
        }
        try {
            if (this.E == 1) {
                this.F.a();
            }
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        this.C++;
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        try {
            if (this.E == 1) {
                this.F.d();
            }
        } catch (Exception unused) {
        }
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.E == 1) {
                this.F.c();
            }
        } catch (Exception unused) {
        }
    }

    public void u1() {
        M1();
        N1();
    }
}
