package com.nst.iptvsmarterstvbox.view.activity;

import a7.j;
import a7.n;
import a7.o;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.nst.iptvsmarterstvbox.model.Myaudiofile;
import g7.m;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p7.k;
import q7.I;
import q7.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AudioPickActivity extends k {
    public String A;
    public String C;
    public int F;
    public Context I;
    public Bitmap g;
    public int h;
    public RecyclerView j;
    public q7.d k;
    public boolean l;
    public boolean m;
    public List o;
    public String p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public RelativeLayout t;
    public RelativeLayout u;
    public RelativeLayout v;
    public ProgressBar w;
    public List x;
    public long y;
    public String z;
    public int i = 0;
    public ArrayList n = new ArrayList();
    public int B = 0;
    public ArrayList D = new ArrayList();
    public AsyncTask E = null;
    public m G = new m();
    public Handler H = new Handler();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("ResultPickAudio", AudioPickActivity.v1(AudioPickActivity.this));
            AudioPickActivity.this.setResult(-1, intent);
            AudioPickActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            AudioPickActivity audioPickActivity = AudioPickActivity.this;
            audioPickActivity.d.d(AudioPickActivity.w1(audioPickActivity));
        }
    }

    public class c implements p.b {
        public c() {
        }

        public void a(e7.c cVar) {
            ArrayList arrayList = AudioPickActivity.this.D;
            if (arrayList != null && arrayList.size() > 0) {
                AudioPickActivity.this.D.clear();
                AudioPickActivity.z1(AudioPickActivity.this).w();
            }
            AudioPickActivity.A1(AudioPickActivity.this).setVisibility(0);
            AudioPickActivity audioPickActivity = AudioPickActivity.this;
            audioPickActivity.d.d(AudioPickActivity.w1(audioPickActivity));
            AudioPickActivity.B1(AudioPickActivity.this).setText(cVar.c());
            AudioPickActivity.this.x.clear();
            if (TextUtils.isEmpty(cVar.d())) {
                AudioPickActivity audioPickActivity2 = AudioPickActivity.this;
                AudioPickActivity.E1(audioPickActivity2, AudioPickActivity.C1(audioPickActivity2));
                AudioPickActivity.A1(AudioPickActivity.this).setVisibility(8);
                return;
            }
            for (e7.c cVar2 : AudioPickActivity.C1(AudioPickActivity.this)) {
                if (cVar2.d().equals(cVar.d())) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(cVar2);
                    AudioPickActivity.E1(AudioPickActivity.this, arrayList2);
                    return;
                }
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (o.a(AudioPickActivity.this, intent)) {
                AudioPickActivity.this.startActivityForResult(intent, 769);
            } else {
                n.a(AudioPickActivity.this).c(AudioPickActivity.this.getString(j.G8));
            }
        }
    }

    public class e implements d7.b {
        public e() {
        }

        public void a(List list) {
            if (AudioPickActivity.this.e) {
                ArrayList arrayList = new ArrayList();
                e7.c cVar = new e7.c();
                cVar.f(AudioPickActivity.this.getResources().getString(j.F8));
                arrayList.add(cVar);
                arrayList.addAll(list);
                AudioPickActivity.this.d.a(arrayList);
            }
            AudioPickActivity.D1(AudioPickActivity.this, list);
            AudioPickActivity.E1(AudioPickActivity.this, list);
        }
    }

    public class f implements I {
        public f() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, e7.a aVar) {
            if (z) {
                AudioPickActivity.v1(AudioPickActivity.this).add(aVar);
                AudioPickActivity.G1(AudioPickActivity.this);
            } else {
                AudioPickActivity.v1(AudioPickActivity.this).remove(aVar);
                AudioPickActivity.H1(AudioPickActivity.this);
            }
            AudioPickActivity.J1(AudioPickActivity.this).setText(AudioPickActivity.F1(AudioPickActivity.this) + "/" + AudioPickActivity.I1(AudioPickActivity.this));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            AudioPickActivity.y1(AudioPickActivity.this, AudioPickActivity.this.new h(0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]));
        }
    }

    public class h extends AsyncTask {
        public h(int i) {
            AudioPickActivity.this.F = 1;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            StringBuilder sb;
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                AudioPickActivity.this.D.clear();
                for (int i = 0; i < AudioPickActivity.this.x.size() && (AudioPickActivity.x1(AudioPickActivity.this) == null || !AudioPickActivity.x1(AudioPickActivity.this).isCancelled()); i++) {
                    e7.a aVar = (e7.a) AudioPickActivity.this.x.get(i);
                    long length = new File(aVar.x()).length();
                    AudioPickActivity.this.y = length / 1048576;
                    float f = length / 1024;
                    if (f >= 1048576) {
                        String valueOf = String.valueOf(Float.valueOf(decimalFormat.format(f / r6)).floatValue());
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
                    AudioPickActivity.this.z = aVar.x().substring(aVar.x().lastIndexOf("/") + 1);
                    AudioPickActivity.this.A = aVar.x().substring(aVar.x().lastIndexOf(".") + 1);
                    long lastModified = new File(aVar.x()).lastModified();
                    AudioPickActivity.this.C = o.d(aVar.O());
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(aVar.x());
                        ByteArrayInputStream byteArrayInputStream = mediaMetadataRetriever.getEmbeddedPicture() != null ? new ByteArrayInputStream(mediaMetadataRetriever.getEmbeddedPicture()) : null;
                        mediaMetadataRetriever.release();
                        AudioPickActivity.this.g = BitmapFactory.decodeStream(byteArrayInputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AudioPickActivity audioPickActivity = AudioPickActivity.this;
                    audioPickActivity.D.add(new Myaudiofile(audioPickActivity.z, lastModified, sb2, audioPickActivity.C, audioPickActivity.g));
                    if (i == 2 || (i != 0 && i % 50 == 0)) {
                        publishProgress(new Integer[]{Integer.valueOf(i)});
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            AudioPickActivity audioPickActivity = AudioPickActivity.this;
            audioPickActivity.F = 0;
            AudioPickActivity.A1(audioPickActivity).setVisibility(8);
            AudioPickActivity.z1(AudioPickActivity.this).s0(AudioPickActivity.this.D);
            AudioPickActivity.z1(AudioPickActivity.this).w();
            AudioPickActivity.z1(AudioPickActivity.this).j0(AudioPickActivity.this.x);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            AudioPickActivity.z1(AudioPickActivity.this).s0(AudioPickActivity.this.D);
            AudioPickActivity.z1(AudioPickActivity.this).w();
            AudioPickActivity.z1(AudioPickActivity.this).j0(AudioPickActivity.this.x);
            AudioPickActivity.A1(AudioPickActivity.this).setVisibility(8);
        }

        public void onPreExecute() {
            super.onPreExecute();
            AudioPickActivity.A1(AudioPickActivity.this).setVisibility(0);
            if (AudioPickActivity.x1(AudioPickActivity.this) == null || !AudioPickActivity.x1(AudioPickActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                return;
            }
            AudioPickActivity.x1(AudioPickActivity.this).cancel(true);
        }
    }

    public static /* synthetic */ ProgressBar A1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.w;
    }

    public static /* synthetic */ TextView B1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.r;
    }

    public static /* synthetic */ List C1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.o;
    }

    public static /* synthetic */ List D1(AudioPickActivity audioPickActivity, List list) {
        audioPickActivity.o = list;
        return list;
    }

    public static /* synthetic */ void E1(AudioPickActivity audioPickActivity, List list) {
        audioPickActivity.N1(list);
    }

    public static /* synthetic */ int F1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.i;
    }

    public static /* synthetic */ int G1(AudioPickActivity audioPickActivity) {
        int i = audioPickActivity.i;
        audioPickActivity.i = i + 1;
        return i;
    }

    public static /* synthetic */ int H1(AudioPickActivity audioPickActivity) {
        int i = audioPickActivity.i;
        audioPickActivity.i = i - 1;
        return i;
    }

    public static /* synthetic */ int I1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.h;
    }

    public static /* synthetic */ TextView J1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.q;
    }

    public static /* synthetic */ ArrayList v1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.n;
    }

    public static /* synthetic */ RelativeLayout w1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.u;
    }

    public static /* synthetic */ AsyncTask x1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.E;
    }

    public static /* synthetic */ AsyncTask y1(AudioPickActivity audioPickActivity, AsyncTask asyncTask) {
        audioPickActivity.E = asyncTask;
        return asyncTask;
    }

    public static /* synthetic */ q7.d z1(AudioPickActivity audioPickActivity) {
        return audioPickActivity.k;
    }

    public final boolean K1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e7.a aVar = (e7.a) it.next();
            if (aVar.x().equals(this.p)) {
                this.n.add(aVar);
                int i = this.i + 1;
                this.i = i;
                this.k.z0(i);
                this.q.setText(this.i + "/" + this.h);
                return true;
            }
        }
        return false;
    }

    public final void L1() {
        TextView findViewById = findViewById(a7.f.oi);
        this.q = findViewById;
        findViewById.setText(this.i + "/" + this.h);
        this.j = findViewById(a7.f.Cf);
        this.j.setLayoutManager(new LinearLayoutManager(this));
        ProgressBar findViewById2 = findViewById(a7.f.qc);
        this.w = findViewById2;
        findViewById2.setVisibility(0);
        RelativeLayout findViewById3 = findViewById(a7.f.ie);
        this.t = findViewById3;
        findViewById3.setOnClickListener(new a());
        this.u = findViewById(a7.f.Sg);
        LinearLayout findViewById4 = findViewById(a7.f.l8);
        this.s = findViewById4;
        if (this.e) {
            findViewById4.setVisibility(0);
            this.s.setOnClickListener(new b());
            TextView findViewById5 = findViewById(a7.f.sj);
            this.r = findViewById5;
            findViewById5.setText(getResources().getString(j.F8));
            this.d.c(new c());
        }
        if (this.l) {
            RelativeLayout findViewById6 = findViewById(a7.f.ef);
            this.v = findViewById6;
            findViewById6.setVisibility(0);
            this.v.setOnClickListener(new d());
        }
    }

    public final void M1() {
        c7.a.a(this, new e());
    }

    public final void N1(List list) {
        boolean z = false;
        this.w.setVisibility(0);
        this.x.clear();
        q7.d dVar = new q7.d(this, this.h);
        this.k = dVar;
        this.j.setAdapter(dVar);
        this.k.k0(new f());
        boolean z2 = this.m;
        if (z2 && !TextUtils.isEmpty(this.p)) {
            File file = new File(this.p);
            if (!this.k.r0() && file.exists()) {
                z = true;
            }
            z2 = z;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e7.c cVar = (e7.c) it.next();
            this.x.addAll(cVar.b());
            if (z2) {
                z2 = K1(cVar.b());
            }
        }
        Iterator it2 = this.n.iterator();
        while (it2.hasNext()) {
            int indexOf = this.x.indexOf((e7.a) it2.next());
            if (indexOf != -1) {
                ((e7.a) this.x.get(indexOf)).M(true);
            }
        }
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.H.postDelayed(new g(), 1000L);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 769 && i2 == -1) {
            if (intent.getData() != null) {
                this.p = intent.getData().getPath();
            }
            M1();
        }
    }

    public void onCreate(Bundle bundle) {
        this.I = this;
        super.onCreate(bundle);
        setContentView(a7.g.X4);
        if (new u7.a(this.I).A().equals(m7.a.K0)) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        this.x = new ArrayList();
        this.h = getIntent().getIntExtra("MaxNumber", 9);
        this.l = getIntent().getBooleanExtra("IsNeedRecorder", false);
        this.m = getIntent().getBooleanExtra("IsTakenAutoSelected", true);
    }

    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.E;
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.E.cancel(true);
        }
        try {
            if (this.F == 1) {
                this.G.a();
            }
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        this.B++;
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.F == 1) {
                this.G.c();
            }
        } catch (Exception unused) {
        }
    }

    public void u1() {
        L1();
        M1();
    }
}
