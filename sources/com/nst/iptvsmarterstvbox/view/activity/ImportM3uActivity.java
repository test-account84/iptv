package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import a7.j;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.utility.LoadingGearSpinner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import m7.w;
import p7.F;
import p7.G;
import p7.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ImportM3uActivity extends androidx.appcompat.app.b {
    public Context d;
    public TextView e;
    public TextView f;
    public ProgressBar g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public RelativeLayout k;
    public LoadingGearSpinner l;
    public LiveStreamDBHandler m;
    public SharedPreferences n;
    public InputStream o;
    public final A7.a p = new A7.a();
    public MultiUserDBHandler q;

    public class b extends AsyncTask {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            String sb;
            try {
                URL url = new URL(strArr[0]);
                ImportM3uActivity.this.y1();
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(ImportM3uActivity.this.d.getFilesDir() + "/data_temp.txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Log.e("file size", "size" + file2.length());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter bufferedWriter = Build.VERSION.SDK_INT >= 26 ? new BufferedWriter(new OutputStreamWriter(H.a(G.a(new File(ImportM3uActivity.this.d.getFilesDir() + "/data_temp.txt").toString(), new String[0]), new OpenOption[0]))) : null;
                if (file2.length() > 50) {
                    sb = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb = (sb + readLine) + "\n";
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb2.append(readLine2);
                        sb2.append('\n');
                    }
                    sb = sb2.toString();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.write(sb);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                return Boolean.TRUE;
            } catch (Exception e2) {
                Log.d("Google", "DownloadFileFromUrl " + e2.getMessage());
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                if (!bool.booleanValue()) {
                    w.P0(ImportM3uActivity.this.d, "Incorrect File/URL");
                    ImportM3uActivity.this.onBackPressed();
                    return;
                }
                ImportM3uActivity importM3uActivity = ImportM3uActivity.this;
                TextView textView = importM3uActivity.f;
                if (textView != null) {
                    textView.setText(importM3uActivity.getResources().getString(j.u2));
                }
                ImportM3uActivity.this.new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{ImportM3uActivity.this.d.getFilesDir() + "/data_temp.txt"});
            } catch (Exception unused) {
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(String... strArr) {
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public /* synthetic */ b(ImportM3uActivity importM3uActivity, a aVar) {
            this();
        }
    }

    public class c extends AsyncTask {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                ImportM3uActivity.this.o = new FileInputStream(new File(strArr[0]));
                ImportM3uActivity importM3uActivity = ImportM3uActivity.this;
                if (importM3uActivity.p.d(importM3uActivity.o, importM3uActivity.d)) {
                    ImportM3uActivity.this.m.deleteChannelsHistoryDuplicateM3U();
                    ImportM3uActivity.this.m.deleteFavDuplicateM3U();
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            } catch (OutOfMemoryError unused2) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            Intent intent;
            super.onPostExecute(bool);
            try {
                File file = new File(ImportM3uActivity.this.d.getFilesDir() + "/data_temp.txt");
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
            if (bool.booleanValue()) {
                LiveStreamDBHandler liveStreamDBHandler = ImportM3uActivity.this.m;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.updateImportStatus("all", "1");
                }
                SharedPreferences sharedPreferences = ImportM3uActivity.this.getSharedPreferences("loginPrefs", 0);
                sharedPreferences.getString("username", "");
                sharedPreferences.getString("password", "");
                String string = sharedPreferences.getString("serverUrl", "");
                sharedPreferences.getString("serverM3UUrl", "");
                sharedPreferences.getString("anyName", "M3ULine");
                if (!string.startsWith("http://")) {
                    string.startsWith("https://");
                }
                SharepreferenceDBHandler.setCurrentAPPType("m3u", ImportM3uActivity.this.d);
                ImportM3uActivity.u1(ImportM3uActivity.this, new MultiUserDBHandler(ImportM3uActivity.this.d));
                if (ImportM3uActivity.this.d == null) {
                    return;
                } else {
                    intent = new Intent(ImportM3uActivity.this.d, NewDashboardActivity.class);
                }
            } else {
                LiveStreamDBHandler liveStreamDBHandler2 = ImportM3uActivity.this.m;
                if (liveStreamDBHandler2 != null) {
                    liveStreamDBHandler2.updateImportStatus("all", "2");
                }
                if (ImportM3uActivity.this.d == null) {
                    return;
                } else {
                    intent = new Intent(ImportM3uActivity.this.d, NewDashboardActivity.class);
                }
            }
            ImportM3uActivity.this.startActivity(intent);
            ImportM3uActivity.this.finish();
        }

        public void onPreExecute() {
            super.onPreExecute();
            LiveStreamDBHandler liveStreamDBHandler = ImportM3uActivity.this.m;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.updateImportStatus("all", "3");
            }
        }
    }

    public static /* synthetic */ MultiUserDBHandler u1(ImportM3uActivity importM3uActivity, MultiUserDBHandler multiUserDBHandler) {
        importM3uActivity.q = multiUserDBHandler;
        return multiUserDBHandler;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void x1() {
        Intent intent;
        if (this.d != null) {
            this.n = getSharedPreferences("loginPrefs", 0);
            ArrayList userDetails = this.q.getUserDetails(SharepreferenceDBHandler.getUserID(this.d));
            if (userDetails == null || userDetails.size() <= 0) {
                Context context = this.d;
                w.P0(context, context.getResources().getString(j.s8));
                intent = new Intent(this.d, NewDashboardActivity.class);
            } else {
                String str = ((MultiUserDBModel) userDetails.get(0)).getmagportal();
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters");
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (((MultiUserDBModel) userDetails.get(0)).getM3uType().equals("file")) {
                    if (!str.equals("")) {
                        TextView textView = this.f;
                        if (textView != null) {
                            textView.setText(getResources().getString(j.u2));
                        }
                        new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
                        return;
                    }
                    Context context2 = this.d;
                    w.P0(context2, context2.getResources().getString(j.g3));
                    intent = new Intent(this.d, NewDashboardActivity.class);
                } else if (!str.equals("")) {
                    new b(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
                    return;
                } else {
                    Context context3 = this.d;
                    w.P0(context3, context3.getResources().getString(j.h3));
                    intent = new Intent(this.d, NewDashboardActivity.class);
                }
            }
            startActivity(intent);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.M);
        w.Y(this);
        this.e = findViewById(f.Il);
        this.f = findViewById(f.Dj);
        this.g = findViewById(f.Nc);
        this.h = findViewById(f.Mk);
        this.i = findViewById(f.pi);
        this.j = findViewById(f.ve);
        this.k = findViewById(f.ue);
        this.l = findViewById(f.j5);
        v1();
        getWindow().setFlags(1024, 1024);
        this.d = this;
        this.m = new LiveStreamDBHandler(this.d);
        this.q = new MultiUserDBHandler(this.d);
        if (this.m.getImportTableCount("m3u") == 0) {
            ArrayList arrayList = new ArrayList();
            ImportStatusModel importStatusModel = new ImportStatusModel();
            importStatusModel.setType("all");
            importStatusModel.setStatus("0");
            importStatusModel.setDate("");
            arrayList.add(0, importStatusModel);
            this.m.importDataStatusArrayList(arrayList, "m3u");
        }
        w1();
        x1();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.d);
        w.z0(this.d);
        getWindow().setFlags(1024, 1024);
    }

    public void w1() {
        LiveStreamDBHandler liveStreamDBHandler = this.m;
        if (liveStreamDBHandler != null) {
            liveStreamDBHandler.makeEmptyAllTablesRecordsM3U();
        }
    }

    public void y1() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (i >= 33) {
                if (F.a(this, "android.permission.READ_MEDIA_AUDIO") == 0) {
                    return;
                }
                D.b.h(this, new String[]{"android.permission.READ_MEDIA_AUDIO"}, 101);
                return;
            } else if (E.b.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGEandroid.permission.READ_EXTERNAL_STORAGE") != 0) {
                Log.v("TAG", "Permission is revoked");
                D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
                return;
            }
        }
        Log.v("TAG", "Permission is granted");
    }
}
