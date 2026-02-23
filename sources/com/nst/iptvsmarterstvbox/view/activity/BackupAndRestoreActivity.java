package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.amplifyframework.storage.result.StorageListResult;
import com.amplifyframework.storage.result.StorageRemoveResult;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import m7.w;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BackupAndRestoreActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Handler A;
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public Context k;
    public u7.a l;
    public PopupWindow n;
    public Button o;
    public Button p;
    public RecentWatchDBHandler q;
    public SeriesRecentWatchDatabase r;
    public LiveStreamDBHandler s;
    public DatabaseHandler t;
    public SharedPreferences u;
    public Thread m = null;
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public String z = "";
    public boolean B = false;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                BackupAndRestoreActivity backupAndRestoreActivity = BackupAndRestoreActivity.this;
                backupAndRestoreActivity.new i(BackupAndRestoreActivity.A1(backupAndRestoreActivity)).show();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            w.j(BackupAndRestoreActivity.A1(BackupAndRestoreActivity.this));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(BackupAndRestoreActivity.A1(BackupAndRestoreActivity.this));
                String A = w.A(date);
                TextView textView = BackupAndRestoreActivity.this.i;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = BackupAndRestoreActivity.this.h;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            BackupAndRestoreActivity.B1(BackupAndRestoreActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ BackupAndRestoreActivity c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ EditText e;

        public e(String str, BackupAndRestoreActivity backupAndRestoreActivity, String[] strArr, EditText editText) {
            this.a = str;
            this.c = backupAndRestoreActivity;
            this.d = strArr;
            this.e = editText;
        }

        public static /* synthetic */ void a(StorageTransferProgress storageTransferProgress) {
            g(storageTransferProgress);
        }

        public static /* synthetic */ void b(e eVar, StorageException storageException) {
            eVar.e(storageException);
        }

        public static /* synthetic */ void c(e eVar, StorageDownloadFileResult storageDownloadFileResult) {
            eVar.d(storageDownloadFileResult);
        }

        public static /* synthetic */ void g(StorageTransferProgress storageTransferProgress) {
            Log.i("MyAmplifyApp", "Fraction completed: " + storageTransferProgress.getFractionCompleted());
        }

        public final void d(StorageDownloadFileResult storageDownloadFileResult) {
            BackupAndRestoreActivity.this.new l().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{storageDownloadFileResult.getFile().getParent()});
        }

        public final void e(StorageException storageException) {
            BackupAndRestoreActivity.I1(BackupAndRestoreActivity.this, "405");
            w.X();
            try {
                BackupAndRestoreActivity.J1(BackupAndRestoreActivity.this).obtainMessage(1, BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this)).sendToTarget();
            } catch (Exception unused) {
            }
        }

        public final boolean f() {
            this.d[0] = String.valueOf(this.e.getText());
            String[] strArr = this.d;
            if (strArr == null || !strArr[0].equals("")) {
                BackupAndRestoreActivity.G1(BackupAndRestoreActivity.this, this.d[0]);
                return true;
            }
            Toast.makeText(this.c, BackupAndRestoreActivity.this.getResources().getString(a7.j.C1), 1).show();
            return false;
        }

        public void onClick(View view) {
            if (f()) {
                BackupAndRestoreActivity.B1(BackupAndRestoreActivity.this).dismiss();
                if (this.a.equals("backup")) {
                    BackupAndRestoreActivity.this.new k().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                }
                if (this.a.equals("download")) {
                    Log.e("honey", "download backup started");
                    w.M0(this.c);
                    String string = BackupAndRestoreActivity.E1(BackupAndRestoreActivity.this).getString("username", "");
                    String string2 = BackupAndRestoreActivity.E1(BackupAndRestoreActivity.this).getString("serverUrl", "");
                    String o0 = w.o0(string + "-" + string2);
                    String o02 = w.o0(string + "-" + string2 + "-" + BackupAndRestoreActivity.F1(BackupAndRestoreActivity.this) + "*NB!@#12ZKWd");
                    try {
                        Amplify.Storage.downloadFile(o0 + "/" + o02 + ".zip", new File(BackupAndRestoreActivity.this.getApplicationContext().getFilesDir().getParent() + "/download.zip"), StorageDownloadFileOptions.defaultInstance(), new p7.h(), new p7.i(this), new p7.j(this));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            BackupAndRestoreActivity.B1(BackupAndRestoreActivity.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ Activity d;

        public g(String[] strArr, EditText editText, Activity activity) {
            this.a = strArr;
            this.c = editText;
            this.d = activity;
        }

        public final boolean a() {
            this.a[0] = String.valueOf(this.c.getText());
            String[] strArr = this.a;
            if (strArr == null || !strArr[0].equals("")) {
                BackupAndRestoreActivity.G1(BackupAndRestoreActivity.this, this.a[0]);
                return true;
            }
            Toast.makeText(this.d, BackupAndRestoreActivity.this.getResources().getString(a7.j.C1), 1).show();
            return false;
        }

        public void onClick(View view) {
            if (a()) {
                BackupAndRestoreActivity.B1(BackupAndRestoreActivity.this).dismiss();
                BackupAndRestoreActivity.D1(BackupAndRestoreActivity.this, true);
                BackupAndRestoreActivity.this.new k().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    BackupAndRestoreActivity.this.T1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class i extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public LinearLayout g;
        public LinearLayout h;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = i.b(i.this);
                        }
                    } else {
                        b = i.a(i.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = i.b(i.this);
                        }
                    } else {
                        b = i.a(i.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public i(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(i iVar) {
            return iVar.g;
        }

        public static /* synthetic */ LinearLayout b(i iVar) {
            return iVar.h;
        }

        public void onClick(View view) {
            try {
                if (view.getId() == a7.f.i1) {
                    dismiss();
                } else {
                    if (view.getId() != a7.f.a1) {
                        return;
                    }
                    dismiss();
                    BackupAndRestoreActivity backupAndRestoreActivity = BackupAndRestoreActivity.this;
                    BackupAndRestoreActivity.C1(backupAndRestoreActivity, BackupAndRestoreActivity.A1(backupAndRestoreActivity));
                }
            } catch (Exception unused) {
            }
        }

        public void onCreate(Bundle bundle) {
            TextView textView;
            StringBuilder sb;
            Resources resources;
            int i;
            String sb2;
            ImageView imageView;
            int i2;
            super.onCreate(bundle);
            setContentView(BackupAndRestoreActivity.N1(BackupAndRestoreActivity.this).A().equals(m7.a.K0) ? a7.g.n2 : a7.g.m2);
            this.c = findViewById(a7.f.i1);
            this.d = findViewById(a7.f.a1);
            this.g = findViewById(a7.f.n8);
            this.h = findViewById(a7.f.f9);
            this.e = findViewById(a7.f.fm);
            this.f = findViewById(a7.f.o5);
            if (BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this) != null && BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this).equals("uploaded")) {
                this.g.setVisibility(8);
                this.e.setText(BackupAndRestoreActivity.this.getResources().getString(a7.j.S));
                imageView = this.f;
                i2 = a7.e.g0;
            } else {
                if (BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this) != null && BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this).equals("downloaded")) {
                    try {
                        Log.e("honey", "restart your application");
                        this.g.setVisibility(8);
                        this.e.setText(BackupAndRestoreActivity.this.getResources().getString(a7.j.P));
                        this.f.setImageResource(a7.e.g0);
                    } catch (Exception unused) {
                    }
                    this.c.setOnClickListener(this);
                    this.d.setOnClickListener(this);
                    TextView textView2 = this.c;
                    textView2.setOnFocusChangeListener(new a(textView2));
                    TextView textView3 = this.d;
                    textView3.setOnFocusChangeListener(new a(textView3));
                }
                if (BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this) == null || !BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this).equals("error3")) {
                    if (BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this) == null || !BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this).equals("405")) {
                        this.g.setVisibility(8);
                        textView = this.e;
                        sb = new StringBuilder();
                        resources = BackupAndRestoreActivity.this.getResources();
                        i = a7.j.V1;
                    } else {
                        this.g.setVisibility(8);
                        textView = this.e;
                        sb = new StringBuilder();
                        resources = BackupAndRestoreActivity.this.getResources();
                        i = a7.j.R;
                    }
                    sb.append(resources.getString(i));
                    sb.append(" ");
                    sb.append(BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this));
                    sb2 = sb.toString();
                } else {
                    this.g.setVisibility(0);
                    textView = this.e;
                    sb2 = BackupAndRestoreActivity.this.getResources().getString(a7.j.Q);
                }
                textView.setText(sb2);
                imageView = this.f;
                i2 = a7.e.N2;
            }
            imageView.setImageResource(i2);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView22 = this.c;
            textView22.setOnFocusChangeListener(new a(textView22));
            TextView textView32 = this.d;
            textView32.setOnFocusChangeListener(new a(textView32));
        }
    }

    public static class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            View view3;
            View view4;
            View view5;
            int i;
            View view6;
            View view7;
            if (z) {
                f = z ? 1.05f : 1.0f;
                View view8 = this.a;
                if ((view8 == null || view8.getTag() == null || !this.a.getTag().equals("1")) && ((view6 = this.a) == null || view6.getTag() == null || !this.a.getTag().equals("8"))) {
                    View view9 = this.a;
                    if ((view9 == null || view9.getTag() == null || !this.a.getTag().equals("2")) && ((view7 = this.a) == null || view7.getTag() == null || !this.a.getTag().equals("9"))) {
                        return;
                    }
                    a(f);
                    b(f);
                    view5 = this.a;
                    i = a7.e.k1;
                } else {
                    a(f);
                    b(f);
                    view5 = this.a;
                    i = a7.e.p;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                View view10 = this.a;
                if ((view10 == null || view10.getTag() == null || !this.a.getTag().equals("1")) && (((view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("8")) && (((view3 = this.a) == null || view3.getTag() == null || !this.a.getTag().equals("2")) && ((view4 = this.a) == null || view4.getTag() == null || !this.a.getTag().equals("9"))))) {
                    return;
                }
                view5 = this.a;
                i = a7.e.o;
            }
            view5.setBackgroundResource(i);
        }
    }

    public class k extends AsyncTask {
        public k() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(BackupAndRestoreActivity.K1(BackupAndRestoreActivity.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                BackupAndRestoreActivity.L1(BackupAndRestoreActivity.this);
            } else {
                w.X();
                Toast.makeText(BackupAndRestoreActivity.A1(BackupAndRestoreActivity.this), "Error while uploading backup.", 0).show();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            w.N0(BackupAndRestoreActivity.A1(BackupAndRestoreActivity.this));
        }
    }

    public class l extends AsyncTask {
        public l() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return BackupAndRestoreActivity.M1(BackupAndRestoreActivity.this, strArr[0]);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            try {
                File file = new File(BackupAndRestoreActivity.this.getFilesDir().getParent() + "/file.json");
                if (file.exists()) {
                    w.t(file);
                }
            } catch (Exception unused) {
            }
            Log.e("honey", "download backup done");
            BackupAndRestoreActivity.I1(BackupAndRestoreActivity.this, "downloaded");
            w.X();
            try {
                BackupAndRestoreActivity.J1(BackupAndRestoreActivity.this).obtainMessage(1, BackupAndRestoreActivity.H1(BackupAndRestoreActivity.this)).sendToTarget();
            } catch (Exception unused2) {
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ Context A1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.k;
    }

    public static /* synthetic */ PopupWindow B1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.n;
    }

    public static /* synthetic */ void C1(BackupAndRestoreActivity backupAndRestoreActivity, Activity activity) {
        backupAndRestoreActivity.Z1(activity);
    }

    public static /* synthetic */ boolean D1(BackupAndRestoreActivity backupAndRestoreActivity, boolean z) {
        backupAndRestoreActivity.B = z;
        return z;
    }

    public static /* synthetic */ SharedPreferences E1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.u;
    }

    public static /* synthetic */ String F1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.z;
    }

    public static /* synthetic */ String G1(BackupAndRestoreActivity backupAndRestoreActivity, String str) {
        backupAndRestoreActivity.z = str;
        return str;
    }

    public static /* synthetic */ String H1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.y;
    }

    public static /* synthetic */ String I1(BackupAndRestoreActivity backupAndRestoreActivity, String str) {
        backupAndRestoreActivity.y = str;
        return str;
    }

    public static /* synthetic */ Handler J1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.A;
    }

    public static /* synthetic */ boolean K1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.a2();
    }

    public static /* synthetic */ void L1(BackupAndRestoreActivity backupAndRestoreActivity) {
        backupAndRestoreActivity.e2();
    }

    public static /* synthetic */ Boolean M1(BackupAndRestoreActivity backupAndRestoreActivity, String str) {
        return backupAndRestoreActivity.b2(str);
    }

    public static /* synthetic */ u7.a N1(BackupAndRestoreActivity backupAndRestoreActivity) {
        return backupAndRestoreActivity.l;
    }

    private void P1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void U1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new j(button));
            this.f.requestFocus();
            this.f.requestFocusFromTouch();
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new j(button2));
        }
    }

    private void W1() {
        this.t = new DatabaseHandler(this.k);
        this.s = new LiveStreamDBHandler(this.k);
        this.q = new RecentWatchDBHandler(this.k);
        this.r = new SeriesRecentWatchDatabase(this.k);
        this.u = getSharedPreferences("loginPrefs", 0);
    }

    public static /* synthetic */ void u1(BackupAndRestoreActivity backupAndRestoreActivity, StorageListResult storageListResult) {
        backupAndRestoreActivity.Q1(storageListResult);
    }

    public static /* synthetic */ void v1(BackupAndRestoreActivity backupAndRestoreActivity, StorageUploadFileResult storageUploadFileResult) {
        backupAndRestoreActivity.f2(storageUploadFileResult);
    }

    public static /* synthetic */ void w1(BackupAndRestoreActivity backupAndRestoreActivity, StorageException storageException) {
        backupAndRestoreActivity.R1(storageException);
    }

    public static /* synthetic */ void x1(BackupAndRestoreActivity backupAndRestoreActivity, StorageException storageException) {
        backupAndRestoreActivity.c2(storageException);
    }

    public static /* synthetic */ void y1(BackupAndRestoreActivity backupAndRestoreActivity, StorageException storageException) {
        backupAndRestoreActivity.O1(storageException);
    }

    public static /* synthetic */ void z1(BackupAndRestoreActivity backupAndRestoreActivity, String str, StorageRemoveResult storageRemoveResult) {
        backupAndRestoreActivity.X1(str, storageRemoveResult);
    }

    public final void O1(StorageException storageException) {
        this.y = "401";
        w.X();
        try {
            this.A.obtainMessage(1, this.y).sendToTarget();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Q1(com.amplifyframework.storage.result.StorageListResult r12) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity.Q1(com.amplifyframework.storage.result.StorageListResult):void");
    }

    public final void R1(StorageException storageException) {
        try {
            File file = new File(getFilesDir().getParent() + "/backup_database.zip");
            if (file.exists()) {
                w.t(file);
            }
        } catch (Exception unused) {
        }
        try {
            File file2 = new File(getFilesDir().getParent() + "/file.json");
            if (file2.exists()) {
                w.t(file2);
            }
        } catch (Exception unused2) {
        }
        Log.e("honey", "backup error");
        this.y = "404";
        w.X();
        try {
            this.A.obtainMessage(1, this.y).sendToTarget();
        } catch (Exception unused3) {
        }
    }

    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public final void X1(StorageRemoveResult storageRemoveResult, String str) {
        File file = new File(getFilesDir().getParent() + "/backup_database.zip");
        if (file.exists()) {
            Amplify.Storage.uploadFile(this.x + "/" + str, file, new p7.f(this), new p7.g(this));
        }
    }

    public void T1() {
        runOnUiThread(new c());
    }

    public String V1(String str) {
        String[] split = str.split("/");
        return split.length == 0 ? "" : split[split.length - 1];
    }

    public final void Y1(BackupAndRestoreActivity backupAndRestoreActivity, String str) {
        try {
            View inflate = ((LayoutInflater) backupAndRestoreActivity.getSystemService("layout_inflater")).inflate(this.l.A().equals(m7.a.K0) ? a7.g.P4 : a7.g.O4, backupAndRestoreActivity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(backupAndRestoreActivity);
            this.n = popupWindow;
            popupWindow.setContentView(inflate);
            this.n.setWidth(-1);
            this.n.setHeight(-1);
            this.n.setFocusable(true);
            this.n.showAtLocation(inflate, 17, 0, 0);
            this.o = inflate.findViewById(a7.f.I0);
            TextView findViewById = inflate.findViewById(a7.f.Nk);
            if (str.equals("backup")) {
                inflate.findViewById(a7.f.Jh).setText(getResources().getString(a7.j.W6));
                findViewById.setVisibility(0);
                findViewById.setText(getResources().getString(a7.j.T));
            } else if (str.equals("download")) {
                inflate.findViewById(a7.f.Jh).setText(getResources().getString(a7.j.W0));
                findViewById.setVisibility(8);
            }
            this.p = inflate.findViewById(a7.f.o0);
            Button button = this.o;
            if (button != null) {
                button.setOnFocusChangeListener(new j(button));
            }
            Button button2 = this.p;
            if (button2 != null) {
                button2.setOnFocusChangeListener(new j(button2));
            }
            EditText findViewById2 = inflate.findViewById(a7.f.k3);
            if (backupAndRestoreActivity.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById2.setGravity(21);
            }
            this.p.setOnClickListener(new d());
            this.o.setOnClickListener(new e(str, backupAndRestoreActivity, new String[1], findViewById2));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public final void Z1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(this.l.A().equals(m7.a.K0) ? a7.g.P4 : a7.g.O4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.n = popupWindow;
            popupWindow.setContentView(inflate);
            this.n.setWidth(-1);
            this.n.setHeight(-1);
            this.n.setFocusable(true);
            this.n.showAtLocation(inflate, 17, 0, 0);
            EditText findViewById = inflate.findViewById(a7.f.k3);
            TextView findViewById2 = inflate.findViewById(a7.f.Nk);
            findViewById2.setText(getResources().getString(a7.j.o8));
            findViewById2.setTextColor(getResources().getColor(a7.c.y));
            findViewById.setHint(getResources().getString(a7.j.B1));
            this.o = inflate.findViewById(a7.f.I0);
            this.p = inflate.findViewById(a7.f.o0);
            Button button = this.o;
            if (button != null) {
                button.setOnFocusChangeListener(new j(button));
            }
            Button button2 = this.p;
            if (button2 != null) {
                button2.setOnFocusChangeListener(new j(button2));
            }
            if (activity.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById.setGravity(21);
            }
            this.p.setOnClickListener(new f());
            this.o.setOnClickListener(new g(new String[1], findViewById, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public final boolean a2() {
        boolean z;
        boolean z2;
        Log.e("honey", "backup started");
        this.y = "";
        try {
            ArrayList allFavouritesIDString = this.t.getAllFavouritesIDString();
            ArrayList allLiveWatchedIDString = this.s.getAllLiveWatchedIDString();
            ArrayList allVodContiueWatchingforBackup = this.q.getAllVodContiueWatchingforBackup();
            ArrayList allSeriesContiueWatchingforBackup = this.r.getAllSeriesContiueWatchingforBackup();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("favourites_live", "");
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("favourites_movies", "");
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("favourites_series", "");
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("channels_history", "");
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("movies_continue_watching", "");
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("series_continue_watching", "");
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("getRecentlyAddedLimit", String.valueOf(this.l.y()));
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("getAutoClearCache", String.valueOf(this.l.c()));
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put("getShowEPGInChannelsList", String.valueOf(this.l.B()));
            } catch (Exception unused9) {
            }
            try {
                jSONObject.put("getAutoplayChannelInLive", String.valueOf(this.l.i()));
            } catch (Exception unused10) {
            }
            try {
                jSONObject.put("getRecentlyWatchedLimitLive", String.valueOf(this.l.z()));
            } catch (Exception unused11) {
            }
            try {
                jSONObject.put("getAutoPlayEpisode", this.l.d());
            } catch (Exception unused12) {
            }
            try {
                jSONObject.put("getAutoStartOnBoot", String.valueOf(this.l.f().booleanValue()));
            } catch (Exception unused13) {
            }
            try {
                jSONObject.put("getfullEPG", String.valueOf(this.l.H().booleanValue()));
            } catch (Exception unused14) {
            }
            try {
                jSONObject.put("getActiveSubtitle", String.valueOf(this.l.b().booleanValue()));
            } catch (Exception unused15) {
            }
            try {
                jSONObject.put("getAutoPlayNextEpisode", String.valueOf(this.l.e().booleanValue()));
            } catch (Exception unused16) {
            }
            if (allFavouritesIDString != null && allFavouritesIDString.size() > 0) {
                for (int i2 = 0; i2 < allFavouritesIDString.size(); i2++) {
                    if (((FavouriteDBModel) allFavouritesIDString.get(i2)).getType() != null && ((FavouriteDBModel) allFavouritesIDString.get(i2)).getType().equals("live")) {
                        try {
                            jSONObject.put("favourites_live", ((FavouriteDBModel) allFavouritesIDString.get(i2)).getCommaSeparatedStreamIDs());
                        } catch (Exception unused17) {
                        }
                    } else if (((FavouriteDBModel) allFavouritesIDString.get(i2)).getType() != null && ((FavouriteDBModel) allFavouritesIDString.get(i2)).getType().equals("vod")) {
                        jSONObject.put("favourites_movies", ((FavouriteDBModel) allFavouritesIDString.get(i2)).getCommaSeparatedStreamIDs());
                    } else if (((FavouriteDBModel) allFavouritesIDString.get(i2)).getType() != null && ((FavouriteDBModel) allFavouritesIDString.get(i2)).getType().equals("series")) {
                        jSONObject.put("favourites_series", ((FavouriteDBModel) allFavouritesIDString.get(i2)).getCommaSeparatedStreamIDs());
                    }
                }
            }
            if (allLiveWatchedIDString != null && allLiveWatchedIDString.size() > 0) {
                for (int i3 = 0; i3 < allLiveWatchedIDString.size(); i3++) {
                    if (((FavouriteDBModel) allLiveWatchedIDString.get(i3)).getType() != null && ((FavouriteDBModel) allLiveWatchedIDString.get(i3)).getType().equals("api")) {
                        try {
                            jSONObject.put("channels_history", ((FavouriteDBModel) allLiveWatchedIDString.get(i3)).getCommaSeparatedStreamIDs());
                        } catch (Exception unused18) {
                        }
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (allVodContiueWatchingforBackup == null || allVodContiueWatchingforBackup.size() <= 0) {
                z = false;
            } else {
                int i4 = 0;
                z = false;
                while (i4 < allVodContiueWatchingforBackup.size()) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("stream_id", ((LiveStreamsDBModel) allVodContiueWatchingforBackup.get(i4)).getStreamId());
                    } catch (Exception unused19) {
                    }
                    try {
                        jSONObject3.put("movie_elapsed_time", ((LiveStreamsDBModel) allVodContiueWatchingforBackup.get(i4)).getMovieElapsedTime());
                    } catch (Exception unused20) {
                    }
                    try {
                        jSONObject3.put("movie_duration", ((LiveStreamsDBModel) allVodContiueWatchingforBackup.get(i4)).getMovieDuraton());
                    } catch (Exception unused21) {
                    }
                    try {
                        jSONObject3.put("is_watched", ((LiveStreamsDBModel) allVodContiueWatchingforBackup.get(i4)).getIsRecentlyWatched());
                    } catch (Exception unused22) {
                    }
                    try {
                        jSONObject2.put(String.valueOf(i4), jSONObject3);
                    } catch (Exception unused23) {
                    }
                    i4++;
                    z = true;
                }
            }
            if (z) {
                try {
                    jSONObject.put("movies_continue_watching", jSONObject2);
                } catch (Exception unused24) {
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            if (allSeriesContiueWatchingforBackup == null || allSeriesContiueWatchingforBackup.size() <= 0) {
                z2 = false;
            } else {
                z2 = false;
                for (int i5 = 0; i5 < allSeriesContiueWatchingforBackup.size(); i5++) {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("episode_id", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getId());
                        jSONObject5.put("episode_name", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getTitle());
                        jSONObject5.put("container_extension", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getContainerExtension());
                        jSONObject5.put("added", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getAdded());
                        jSONObject5.put("elapsed_time", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getElapsed_time());
                        jSONObject5.put("image", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getMovieImage());
                        jSONObject5.put("series_main_image", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getMainSeriesImg());
                        jSONObject5.put("is_recent_watched", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getIsRecentlyWatched());
                        jSONObject5.put("season_num", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getSeasonNumber());
                        jSONObject5.put("episode_num", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getEpisodeNumber());
                        jSONObject5.put("episode_duration_sec", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getDurationSec());
                        jSONObject5.put("series_id", ((GetEpisdoeDetailsCallback) allSeriesContiueWatchingforBackup.get(i5)).getSeriesId());
                        try {
                            jSONObject4.put(String.valueOf(i5), jSONObject5);
                        } catch (Exception unused25) {
                        }
                        z2 = true;
                    } catch (Exception unused26) {
                    }
                }
            }
            if (z2) {
                try {
                    jSONObject.put("series_continue_watching", jSONObject4);
                } catch (Exception unused27) {
                }
            }
            try {
                File file = new File(getFilesDir().getParent() + "/file.json");
                if (file.exists()) {
                    w.t(file);
                }
            } catch (Exception unused28) {
            }
            try {
                FileWriter fileWriter = new FileWriter(new File(getFilesDir().getParent(), "file.json"));
                fileWriter.write(jSONObject.toString());
                fileWriter.close();
            } catch (Exception unused29) {
            }
            try {
                File file2 = new File(getFilesDir().getParent() + "/backup_database.zip");
                if (file2.exists()) {
                    w.t(file2);
                }
            } catch (Exception unused30) {
            }
            String str = this.k.getApplicationInfo().dataDir;
            StringBuilder sb = new StringBuilder();
            sb.append(getFilesDir().getParent());
            sb.append("/backup_database.zip");
            return g2(str, sb.toString());
        } catch (Exception unused31) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:0|1|(3:2|3|(1:5))|(42:7|8|9|10|(1:12)|14|15|16|(2:18|(1:(1:26))(1:22))|27|29|30|(2:32|(1:(1:40))(1:36))|41|42|(2:44|(1:(1:52))(1:48))|53|54|(1:56)|58|59|(1:61)|63|64|(3:66|(1:(1:76))(1:70)|71)|77|78|(3:80|(1:(1:90))(1:84)|85)|91|92|(3:94|(1:(1:104))(1:98)|99)|105|106|(3:108|(1:(1:118))(1:112)|113)|119|(1:(1:408)(1:407))|127|(1:129)|130|(1:393)(1:134)|135|(1:392)(1:140))|(1:(21:(1:391)|149|(1:151)|152|(1:161)|162|(1:164)|165|166|(5:170|(2:172|173)(2:175|176)|174|167|168)|177|178|(2:180|(3:182|(3:186|(4:189|(7:191|192|194|195|196|197|199)(1:205)|200|187)|206)|(1:210)))|212|(1:214)|215|(7:216|217|(4:219|220|(2:222|223)(2:225|226)|224)(1:232)|227|228|229|230)|233|(5:235|236|237|238|(4:240|(3:244|(4:247|(2:248|(1:(1:365)(56:253|254|255|256|257|258|259|260|261|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|278|279|280|281|282|283|284|285|286|287|288|289|290|291|292|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310))(3:367|368|369))|311|245)|370)|371|(3:373|374|375)(1:228))(1:380))(0)|229|230)(1:387))(1:147)|148|149|(0)|152|(4:155|157|159|161)|162|(0)|165|166|(2:167|168)|177|178|(0)|212|(0)|215|(8:216|217|(0)(0)|227|228|229|230|224)|233|(0)(0)|229|230) */
    /* JADX WARN: Can't wrap try/catch for region: R(51:(2:253|254)|(2:255|256)|(3:257|258|259)|(2:260|261)|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|278|279|280|281|282|283|284|285|286|287|288|289|290|291|292|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310) */
    /* JADX WARN: Can't wrap try/catch for region: R(53:(2:253|254)|(2:255|256)|257|258|259|(2:260|261)|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|278|279|280|281|282|283|284|285|286|287|288|289|290|291|292|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310) */
    /* JADX WARN: Can't wrap try/catch for region: R(54:(2:253|254)|255|256|257|258|259|(2:260|261)|262|263|264|265|266|267|268|269|270|271|272|273|274|275|276|278|279|280|281|282|283|284|285|286|287|288|289|290|291|292|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310) */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x06f6, code lost:
    
        r10 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x06f4, code lost:
    
        r20 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x06e1, code lost:
    
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x06df, code lost:
    
        r26 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x06cc, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x06ca, code lost:
    
        r32 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x06b7, code lost:
    
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x06b5, code lost:
    
        r31 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x06a2, code lost:
    
        r7 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x06a0, code lost:
    
        r30 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x068d, code lost:
    
        r13 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x068b, code lost:
    
        r25 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0678, code lost:
    
        r14 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0676, code lost:
    
        r24 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0663, code lost:
    
        r5 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0661, code lost:
    
        r23 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x064e, code lost:
    
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x064c, code lost:
    
        r22 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02cc A[Catch: Exception -> 0x0806, TryCatch #38 {Exception -> 0x0806, blocks: (B:8:0x0047, B:121:0x021e, B:124:0x0226, B:127:0x0262, B:129:0x0266, B:130:0x0271, B:132:0x0275, B:134:0x027b, B:135:0x0283, B:138:0x0289, B:140:0x028f, B:142:0x0299, B:145:0x02a1, B:147:0x02a7, B:148:0x02ac, B:149:0x02c8, B:151:0x02cc, B:152:0x02cf, B:155:0x02d5, B:157:0x02db, B:159:0x02e3, B:161:0x02e9, B:162:0x02ee, B:164:0x02f2, B:212:0x0419, B:214:0x041d, B:215:0x0420, B:216:0x0439, B:385:0x02b2, B:387:0x02b8, B:389:0x02bd, B:391:0x02c3, B:395:0x022f, B:398:0x0237, B:402:0x0240, B:405:0x0248, B:407:0x024e), top: B:7:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02f2 A[Catch: Exception -> 0x0806, TRY_LEAVE, TryCatch #38 {Exception -> 0x0806, blocks: (B:8:0x0047, B:121:0x021e, B:124:0x0226, B:127:0x0262, B:129:0x0266, B:130:0x0271, B:132:0x0275, B:134:0x027b, B:135:0x0283, B:138:0x0289, B:140:0x028f, B:142:0x0299, B:145:0x02a1, B:147:0x02a7, B:148:0x02ac, B:149:0x02c8, B:151:0x02cc, B:152:0x02cf, B:155:0x02d5, B:157:0x02db, B:159:0x02e3, B:161:0x02e9, B:162:0x02ee, B:164:0x02f2, B:212:0x0419, B:214:0x041d, B:215:0x0420, B:216:0x0439, B:385:0x02b2, B:387:0x02b8, B:389:0x02bd, B:391:0x02c3, B:395:0x022f, B:398:0x0237, B:402:0x0240, B:405:0x0248, B:407:0x024e), top: B:7:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0322 A[Catch: Exception -> 0x0419, TRY_ENTER, TryCatch #13 {Exception -> 0x0419, blocks: (B:166:0x02fd, B:167:0x0316, B:170:0x0322, B:172:0x0335, B:178:0x039a, B:180:0x03a0, B:182:0x03af, B:184:0x03b5, B:187:0x03bc, B:189:0x03c2, B:208:0x040e, B:210:0x0414), top: B:165:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03a0 A[Catch: Exception -> 0x0419, TryCatch #13 {Exception -> 0x0419, blocks: (B:166:0x02fd, B:167:0x0316, B:170:0x0322, B:172:0x0335, B:178:0x039a, B:180:0x03a0, B:182:0x03af, B:184:0x03b5, B:187:0x03bc, B:189:0x03c2, B:208:0x040e, B:210:0x0414), top: B:165:0x02fd }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x041d A[Catch: Exception -> 0x0806, TryCatch #38 {Exception -> 0x0806, blocks: (B:8:0x0047, B:121:0x021e, B:124:0x0226, B:127:0x0262, B:129:0x0266, B:130:0x0271, B:132:0x0275, B:134:0x027b, B:135:0x0283, B:138:0x0289, B:140:0x028f, B:142:0x0299, B:145:0x02a1, B:147:0x02a7, B:148:0x02ac, B:149:0x02c8, B:151:0x02cc, B:152:0x02cf, B:155:0x02d5, B:157:0x02db, B:159:0x02e3, B:161:0x02e9, B:162:0x02ee, B:164:0x02f2, B:212:0x0419, B:214:0x041d, B:215:0x0420, B:216:0x0439, B:385:0x02b2, B:387:0x02b8, B:389:0x02bd, B:391:0x02c3, B:395:0x022f, B:398:0x0237, B:402:0x0240, B:405:0x0248, B:407:0x024e), top: B:7:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x045d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x058f A[EDGE_INSN: B:232:0x058f->B:233:0x058f BREAK  A[LOOP:2: B:216:0x0439->B:224:0x0582], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x059f A[Catch: Exception -> 0x0801, TRY_LEAVE, TryCatch #40 {Exception -> 0x0801, blocks: (B:220:0x045d, B:222:0x0476, B:233:0x058f, B:235:0x059f, B:242:0x05c3, B:244:0x05c9, B:245:0x05d1, B:247:0x05d7, B:248:0x05f0, B:251:0x05f8, B:309:0x06f8, B:365:0x0779, B:371:0x07f2), top: B:219:0x045d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean b2(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 2058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity.b2(java.lang.String):java.lang.Boolean");
    }

    public final void c2(StorageException storageException) {
        try {
            File file = new File(getFilesDir().getParent() + "/backup_database.zip");
            if (file.exists()) {
                w.t(file);
            }
        } catch (Exception unused) {
        }
        try {
            File file2 = new File(getFilesDir().getParent() + "/file.json");
            if (file2.exists()) {
                w.t(file2);
            }
        } catch (Exception unused2) {
        }
        Log.e("honey", "backup error");
        this.y = "403";
        w.X();
        try {
            this.A.obtainMessage(1, this.y).sendToTarget();
        } catch (Exception unused3) {
        }
    }

    public final boolean d2(String str, String str2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str + str2)));
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return true;
                }
                String name = nextEntry.getName();
                if (name.contains("/com.nst.iptvsmarterstvbox/")) {
                    name = name.replaceAll("/com.nst.iptvsmarterstvbox/", "");
                }
                if (nextEntry.isDirectory()) {
                    new File(str + name).mkdirs();
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(str + name);
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void e2() {
        try {
            this.v = this.u.getString("username", "");
            this.w = this.u.getString("serverUrl", "");
            String o0 = w.o0(this.v + "-" + this.w);
            this.x = o0;
            Amplify.Storage.list(o0, new p7.b(this), new p7.c(this));
        } catch (Exception e2) {
            Log.e("Exception", "Upload failed", e2);
            try {
                File file = new File(getFilesDir().getParent() + "/backup_database.zip");
                if (file.exists()) {
                    w.t(file);
                }
            } catch (Exception unused) {
            }
            try {
                File file2 = new File(getFilesDir().getParent() + "/file.json");
                if (file2.exists()) {
                    w.t(file2);
                }
            } catch (Exception unused2) {
            }
            this.y = "402";
            w.X();
            try {
                this.A.obtainMessage(1, this.y).sendToTarget();
            } catch (Exception unused3) {
            }
        }
    }

    public final void f2(StorageUploadFileResult storageUploadFileResult) {
        try {
            File file = new File(getFilesDir().getParent() + "/backup_database.zip");
            if (file.exists()) {
                w.t(file);
            }
        } catch (Exception unused) {
        }
        try {
            File file2 = new File(getFilesDir().getParent() + "/file.json");
            if (file2.exists()) {
                w.t(file2);
            }
        } catch (Exception unused2) {
        }
        Log.e("honey", "backup finished");
        this.y = "uploaded";
        w.X();
        try {
            this.A.obtainMessage(1, this.y).sendToTarget();
        } catch (Exception unused3) {
        }
    }

    public boolean g2(String str, String str2) {
        File file = new File(str);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            if (!file.isDirectory()) {
                byte[] bArr = new byte[2048];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 2048);
                ZipEntry zipEntry = new ZipEntry(V1(str));
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } else {
                h2(zipOutputStream, file, file.getParent().length());
            }
            zipOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void h2(ZipOutputStream zipOutputStream, File file, int i2) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && file2.getName().equals("shared_prefs")) {
                if (file2.isDirectory()) {
                    h2(zipOutputStream, file2, i2);
                }
            } else if (!file2.isDirectory() && !file2.getName().equals("backup_database.zip") && (file2.getName().equals("Accept_clicked.xml") || file2.getName().equals("allowedFormat.xml") || file2.getName().equals("automation_channels.xml") || file2.getName().equals("automation_epg.xml") || file2.getName().equals("cacheClearCount.xml") || file2.getName().equals("epgchannelupdate.xml") || file2.getName().equals("pref.using_infbuf.xml") || file2.getName().equals("pref.using_media_codec.xml") || file2.getName().equals("pref.using_opengl.xml") || file2.getName().equals("pref.using_opensl_es.xml") || file2.getName().equals("pref.using_buffer_size") || file2.getName().equals("timeFormat.xml") || file2.getName().equals("showPopup.xml") || file2.getName().equals("file.json"))) {
                try {
                    byte[] bArr = new byte[2048];
                    String path = file2.getPath();
                    String substring = path.substring(i2);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path), 2048);
                    ZipEntry zipEntry = new ZipEntry(substring);
                    zipEntry.setTime(file2.lastModified());
                    zipOutputStream.putNextEntry(zipEntry);
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        } else {
                            zipOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedInputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (view.getId() == a7.f.i0) {
            str = "backup";
        } else if (view.getId() != a7.f.z0) {
            return;
        } else {
            str = "download";
        }
        Y1(this, str);
    }

    public void onCreate(Bundle bundle) {
        this.k = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.k);
        this.l = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.n : a7.g.m);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.i0);
        this.g = findViewById(a7.f.z0);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h = findViewById(a7.f.E2);
        this.i = findViewById(a7.f.gh);
        this.j = findViewById(a7.f.Xa);
        W1();
        U1();
        try {
            this.A = new a(Looper.getMainLooper());
        } catch (Exception unused) {
        }
        P1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        Thread thread = this.m;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new h());
            this.m = thread2;
            thread2.start();
        }
        this.j.setOnClickListener(new b());
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.m;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.m.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.m;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new h());
            this.m = thread2;
            thread2.start();
        }
        w.m(this.k);
        w.z0(this.k);
    }

    public void onViewClicked(View view) {
        view.getId();
    }
}
