package com.nst.iptvsmarterstvbox.view.activity;

import a7.g;
import a7.j;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.model.OneStreamLiveStreamDataModel;
import com.nst.iptvsmarterstvbox.model.OneStreamMovieStreamDataModel;
import com.nst.iptvsmarterstvbox.model.OneStreamSeriesStreamDataModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.LiveDataModel;
import com.nst.iptvsmarterstvbox.view.utility.LoadingGearSpinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ImportOneStreamActivity extends androidx.appcompat.app.b {
    public Context h;
    public TextView i;
    public TextView j;
    public ProgressBar k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public RelativeLayout o;
    public LoadingGearSpinner p;
    public LiveStreamDBHandler q;
    public MultiUserDBHandler s;
    public String x;
    public List d = new ArrayList();
    public List e = new ArrayList();
    public List f = new ArrayList();
    public List g = new ArrayList();
    public final A7.a r = new A7.a();
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String y = "";
    public String z = "";
    public String A = "";
    public String B = "";
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = "";
    public String M = "";

    public class a implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyOneStreamSeriesCategories();
                }
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler2 = importOneStreamActivity.q;
                if (liveStreamDBHandler2 == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler2.addonestreamSeriesCategories(ImportOneStreamActivity.u1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                ImportOneStreamActivity.v1(ImportOneStreamActivity.this);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public a() {
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            String str;
            String str2;
            String str3;
            try {
                Log.e("Categories For series", String.valueOf(jSONObject));
                if (jSONObject != null) {
                    try {
                        jSONObject2 = new JSONObject(String.valueOf(jSONObject));
                    } catch (Exception e) {
                        e.printStackTrace();
                        jSONObject2 = null;
                    }
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("content");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                try {
                                    jSONObject3 = jSONArray.getJSONObject(i);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    jSONObject3 = null;
                                }
                                if (jSONObject3 != null) {
                                    try {
                                        str = jSONObject3.getString("category_id");
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        str = null;
                                    }
                                    try {
                                        str2 = jSONObject3.getString("category_name");
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        str2 = null;
                                    }
                                    try {
                                        str3 = jSONObject3.getString("parent_id");
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                        str3 = null;
                                    }
                                    ImportOneStreamActivity.u1(ImportOneStreamActivity.this).add(new LiveDataModel(str, str2, str3));
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (ImportOneStreamActivity.u1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.u1(ImportOneStreamActivity.this).size() <= 0) {
                    ImportOneStreamActivity.v1(ImportOneStreamActivity.this);
                } else {
                    new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
                ImportOneStreamActivity.v1(ImportOneStreamActivity.this);
            }
        }

        public void b(m1.a aVar) {
            ImportOneStreamActivity.v1(ImportOneStreamActivity.this);
            Log.e("HONEY", "series category" + String.valueOf(aVar));
            Toast.makeText(ImportOneStreamActivity.this.getApplicationContext(), ImportOneStreamActivity.this.getResources().getString(j.D2), 0).show();
        }
    }

    public class b implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyONESTREAMMovieCategory();
                }
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler2 = importOneStreamActivity.q;
                if (liveStreamDBHandler2 == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler2.addOnestreamMovieCategories(ImportOneStreamActivity.u1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                ImportOneStreamActivity.w1(ImportOneStreamActivity.this);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public b() {
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            String str;
            String str2;
            try {
                Log.e("Categories For Live", String.valueOf(jSONObject));
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray = new JSONObject(String.valueOf(jSONObject)).getJSONArray("content");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String str3 = null;
                                try {
                                    jSONObject2 = jSONArray.getJSONObject(i);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    jSONObject2 = null;
                                }
                                if (jSONObject2 != null) {
                                    try {
                                        str = jSONObject2.getString("category_id");
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        str = null;
                                    }
                                    try {
                                        str2 = jSONObject2.getString("category_name");
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        str2 = null;
                                    }
                                    try {
                                        str3 = jSONObject2.getString("parent_id");
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                    ImportOneStreamActivity.u1(ImportOneStreamActivity.this).add(new LiveDataModel(str, str2, str3));
                                }
                            }
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (ImportOneStreamActivity.u1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.u1(ImportOneStreamActivity.this).size() <= 0) {
                ImportOneStreamActivity.w1(ImportOneStreamActivity.this);
            } else {
                new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }

        public void b(m1.a aVar) {
            ImportOneStreamActivity.w1(ImportOneStreamActivity.this);
            Log.e("HONEY", "error in vod data " + aVar);
        }
    }

    public class c implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler = importOneStreamActivity.q;
                if (liveStreamDBHandler == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler.addAllAvailableONESTREAMMovies(ImportOneStreamActivity.x1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                ImportOneStreamActivity.y1(ImportOneStreamActivity.this);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public c() {
        }

        public void a(JSONObject jSONObject) {
            JSONArray jSONArray;
            JSONObject jSONObject2;
            JSONArray jSONArray2;
            try {
                Log.e("Categories For Movie Streams", String.valueOf(jSONObject));
                if (jSONObject != null) {
                    try {
                        jSONArray = new JSONObject(String.valueOf(jSONObject)).getJSONArray("content");
                    } catch (Exception e) {
                        e.printStackTrace();
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                jSONObject2 = jSONArray.getJSONObject(i);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                jSONObject2 = null;
                            }
                            if (jSONObject2 != null) {
                                try {
                                    ImportOneStreamActivity.this.y = jSONObject2.getString("num");
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.z = jSONObject2.getString("name");
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.A = jSONObject2.getString("stream_type");
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.B = jSONObject2.getString("stream_id");
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.C = jSONObject2.getString("stream_icon");
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.K = jSONObject2.getString("rating");
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.L = jSONObject2.getString("rating_5based");
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.M = jSONObject2.getString("added");
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                                try {
                                    ImportOneStreamActivity.this.F = jSONObject2.getString("is_adult");
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                                try {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("links");
                                    Iterator keys = jSONObject3.keys();
                                    while (keys.hasNext()) {
                                        String str = (String) keys.next();
                                        ImportOneStreamActivity.this.G = (String) jSONObject3.get(str);
                                        Log.e("key", str);
                                    }
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                                try {
                                    jSONArray2 = jSONObject2.getJSONArray("categories");
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                    jSONArray2 = null;
                                }
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    try {
                                        ImportOneStreamActivity.this.w = jSONArray2.getString(0);
                                    } catch (Exception e14) {
                                        e14.printStackTrace();
                                    }
                                }
                                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                                ImportOneStreamActivity.x1(ImportOneStreamActivity.this).add(new OneStreamMovieStreamDataModel(importOneStreamActivity.y, importOneStreamActivity.z, importOneStreamActivity.A, importOneStreamActivity.B, importOneStreamActivity.C, importOneStreamActivity.K, importOneStreamActivity.L, importOneStreamActivity.M, importOneStreamActivity.F, importOneStreamActivity.w, importOneStreamActivity.G));
                            }
                        }
                    }
                }
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            if (ImportOneStreamActivity.u1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.u1(ImportOneStreamActivity.this).size() <= 0) {
                ImportOneStreamActivity.y1(ImportOneStreamActivity.this);
            } else {
                new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }

        public void b(m1.a aVar) {
            ImportOneStreamActivity.y1(ImportOneStreamActivity.this);
            Log.e("HONEY", "Categories For vod" + String.valueOf(aVar));
        }
    }

    public class d implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyLiveCategoryOneStream();
                }
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler2 = importOneStreamActivity.q;
                if (liveStreamDBHandler2 == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler2.addOneStreamLiveCategories(ImportOneStreamActivity.u1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                ImportOneStreamActivity.z1(ImportOneStreamActivity.this);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public d() {
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            String str;
            String str2;
            String str3;
            try {
                Log.e("Categories For Live", String.valueOf(jSONObject));
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray = new JSONObject(String.valueOf(jSONObject)).getJSONArray("content");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                try {
                                    try {
                                        jSONObject2 = jSONArray.getJSONObject(i);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        jSONObject2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        try {
                                            str = jSONObject2.getString("category_id");
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            str = "";
                                        }
                                        try {
                                            str2 = jSONObject2.getString("category_name");
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            str2 = "";
                                        }
                                        try {
                                            str3 = jSONObject2.getString("parent_id");
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            str3 = "";
                                        }
                                        ImportOneStreamActivity.u1(ImportOneStreamActivity.this).add(new LiveDataModel(str, str2, str3));
                                    }
                                } catch (Exception e5) {
                                    Log.e("exception", String.valueOf(e5));
                                }
                            }
                        }
                    } catch (Exception e6) {
                        Log.e("exception", String.valueOf(e6));
                    }
                }
                if (ImportOneStreamActivity.u1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.u1(ImportOneStreamActivity.this).size() <= 0) {
                    ImportOneStreamActivity.z1(ImportOneStreamActivity.this);
                } else {
                    new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            ImportOneStreamActivity.z1(ImportOneStreamActivity.this);
            Log.e("Categories For Live", String.valueOf(aVar));
        }
    }

    public class e implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyLiveStreamsOneStream();
                }
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler2 = importOneStreamActivity.q;
                if (liveStreamDBHandler2 == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler2.addOneStreamAllChannels(ImportOneStreamActivity.A1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                ImportOneStreamActivity.B1(ImportOneStreamActivity.this);
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public e() {
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            JSONArray jSONArray;
            int i = 0;
            try {
                Log.e("Categories For Live Streams", String.valueOf(jSONObject));
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyLiveStreamsOneStream();
                }
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray2 = new JSONObject(String.valueOf(jSONObject)).getJSONArray("content");
                        if (jSONArray2 != null) {
                            int i2 = 0;
                            while (i2 < jSONArray2.length()) {
                                JSONArray jSONArray3 = null;
                                try {
                                    jSONObject2 = jSONArray2.getJSONObject(i2);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    jSONObject2 = null;
                                }
                                if (jSONObject2 != null) {
                                    try {
                                        jSONObject2 = jSONArray2.getJSONObject(i2);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.y = jSONObject2.getString("num");
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.z = jSONObject2.getString("name");
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.A = jSONObject2.getString("stream_type");
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.B = jSONObject2.getString("stream_id");
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.C = jSONObject2.getString("stream_icon");
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.D = jSONObject2.getString("epg_channel_id");
                                    } catch (Exception e8) {
                                        e8.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.E = jSONObject2.getString("created_at");
                                    } catch (Exception e9) {
                                        e9.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.F = jSONObject2.getString("is_adult");
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.G = jSONObject2.getString("links");
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.H = jSONObject2.getString("tv_archive_id");
                                    } catch (Exception e12) {
                                        e12.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.I = jSONObject2.getString("tv_archive");
                                    } catch (Exception e13) {
                                        e13.printStackTrace();
                                    }
                                    try {
                                        ImportOneStreamActivity.this.J = jSONObject2.getString("tv_archive_duration");
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        jSONArray3 = jSONObject2.getJSONArray("categories");
                                    } catch (Exception e14) {
                                        e14.printStackTrace();
                                    }
                                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                                        try {
                                            ImportOneStreamActivity.this.w = jSONArray3.getString(i);
                                        } catch (Exception e15) {
                                            e15.printStackTrace();
                                        }
                                    }
                                    ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                                    jSONArray = jSONArray2;
                                    ImportOneStreamActivity.A1(ImportOneStreamActivity.this).add(new OneStreamLiveStreamDataModel(importOneStreamActivity.y, importOneStreamActivity.z, importOneStreamActivity.A, importOneStreamActivity.B, importOneStreamActivity.C, importOneStreamActivity.D, importOneStreamActivity.E, importOneStreamActivity.F, importOneStreamActivity.w, importOneStreamActivity.G, importOneStreamActivity.I, importOneStreamActivity.H, importOneStreamActivity.J));
                                } else {
                                    jSONArray = jSONArray2;
                                }
                                i2++;
                                jSONArray2 = jSONArray;
                                i = 0;
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (ImportOneStreamActivity.A1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.A1(ImportOneStreamActivity.this).size() <= 0) {
                ImportOneStreamActivity.B1(ImportOneStreamActivity.this);
            } else {
                new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }

        public void b(m1.a aVar) {
            ImportOneStreamActivity.B1(ImportOneStreamActivity.this);
            Log.e("HONEY", "Categories For Live streams" + aVar);
        }
    }

    public class f implements p1.c {

        public class a extends AsyncTask {
            public ProgressDialog a;

            public a(Context context) {
                this.a = new ProgressDialog(ImportOneStreamActivity.this);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.makeEmptyOneStreamSeriesStreams();
                }
                publishProgress(new Integer[]{0});
                ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                LiveStreamDBHandler liveStreamDBHandler2 = importOneStreamActivity.q;
                if (liveStreamDBHandler2 == null) {
                    return Boolean.FALSE;
                }
                try {
                    liveStreamDBHandler2.addAllOneStreamSeriesStreams(ImportOneStreamActivity.C1(importOneStreamActivity));
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                if (liveStreamDBHandler != null) {
                    liveStreamDBHandler.updateImportStatus("onestream_api", "1");
                }
                ImportOneStreamActivity.this.startActivity(new Intent(ImportOneStreamActivity.this.getApplicationContext(), NewDashboardActivity.class));
                ImportOneStreamActivity.this.finish();
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public f() {
        }

        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            if (jSONObject != null) {
                try {
                    Log.e("Categories For series Streams", String.valueOf(jSONObject));
                    LiveStreamDBHandler liveStreamDBHandler = ImportOneStreamActivity.this.q;
                    if (liveStreamDBHandler != null) {
                        liveStreamDBHandler.makeEmptySeriesStreams();
                    }
                    try {
                        try {
                            JSONArray jSONArray = new JSONObject(String.valueOf(jSONObject)).getJSONArray("content");
                            if (jSONArray != null) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONArray jSONArray2 = null;
                                    try {
                                        jSONObject2 = jSONArray.getJSONObject(i);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        jSONObject2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        try {
                                            ImportOneStreamActivity.this.y = jSONObject2.getString("num");
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                        try {
                                            ImportOneStreamActivity.this.z = jSONObject2.getString("name");
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                        try {
                                            str = jSONObject2.getString("series_id");
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            str = null;
                                        }
                                        try {
                                            str2 = jSONObject2.getString("cover");
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            str2 = null;
                                        }
                                        try {
                                            str3 = jSONObject2.getString("youtube_trailer");
                                        } catch (Exception e6) {
                                            e6.printStackTrace();
                                            str3 = null;
                                        }
                                        try {
                                            str4 = jSONObject2.getString("genre");
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                            str4 = null;
                                        }
                                        try {
                                            str5 = jSONObject2.getString("release_date");
                                        } catch (Exception e8) {
                                            e8.printStackTrace();
                                            str5 = null;
                                        }
                                        try {
                                            str6 = jSONObject2.getString("plot");
                                        } catch (Exception e9) {
                                            e9.printStackTrace();
                                            str6 = null;
                                        }
                                        try {
                                            str7 = jSONObject2.getString("cast");
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                            str7 = null;
                                        }
                                        try {
                                            str8 = jSONObject2.getString("rating");
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                            str8 = null;
                                        }
                                        try {
                                            str9 = jSONObject2.getString("rating_5based");
                                        } catch (Exception e12) {
                                            e12.printStackTrace();
                                            str9 = null;
                                        }
                                        try {
                                            str10 = jSONObject2.getString("director");
                                        } catch (Exception e13) {
                                            e13.printStackTrace();
                                            str10 = null;
                                        }
                                        try {
                                            str11 = jSONObject2.getString("backdrop_path");
                                        } catch (Exception e14) {
                                            e14.printStackTrace();
                                            str11 = null;
                                        }
                                        try {
                                            str12 = jSONObject2.getString("last_modified");
                                        } catch (Exception e15) {
                                            e15.printStackTrace();
                                            str12 = null;
                                        }
                                        try {
                                            str13 = jSONObject2.getString("episode_run_time");
                                        } catch (Exception e16) {
                                            e16.printStackTrace();
                                            str13 = null;
                                        }
                                        try {
                                            jSONArray2 = jSONObject2.getJSONArray("categories");
                                        } catch (Exception e17) {
                                            e17.printStackTrace();
                                        }
                                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                                            try {
                                                ImportOneStreamActivity.this.w = jSONArray2.getString(0);
                                            } catch (Exception e18) {
                                                e18.printStackTrace();
                                            }
                                        }
                                        ImportOneStreamActivity importOneStreamActivity = ImportOneStreamActivity.this;
                                        ImportOneStreamActivity.C1(ImportOneStreamActivity.this).add(new OneStreamSeriesStreamDataModel(importOneStreamActivity.y, importOneStreamActivity.z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, importOneStreamActivity.w));
                                    }
                                }
                            }
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    } catch (Exception e20) {
                        e20.printStackTrace();
                    }
                } catch (Exception e21) {
                    e21.printStackTrace();
                    return;
                }
            }
            if (ImportOneStreamActivity.A1(ImportOneStreamActivity.this) == null || ImportOneStreamActivity.A1(ImportOneStreamActivity.this).size() <= 0) {
                return;
            }
            new a(ImportOneStreamActivity.this.h).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }

        public void b(m1.a aVar) {
            Log.e("HONEY", "ERROE series streams" + String.valueOf(aVar));
        }
    }

    public static /* synthetic */ List A1(ImportOneStreamActivity importOneStreamActivity) {
        return importOneStreamActivity.d;
    }

    public static /* synthetic */ void B1(ImportOneStreamActivity importOneStreamActivity) {
        importOneStreamActivity.J1();
    }

    public static /* synthetic */ List C1(ImportOneStreamActivity importOneStreamActivity) {
        return importOneStreamActivity.f;
    }

    private void D1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void L1() {
        this.x = this.h.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "");
        this.v = SharepreferenceDBHandler.getOneStreamToken(this.h);
        String str = this.x;
        m7.a.Z = str;
        Log.e("Server url", str);
        F1();
    }

    public static /* synthetic */ List u1(ImportOneStreamActivity importOneStreamActivity) {
        return importOneStreamActivity.g;
    }

    public static /* synthetic */ void v1(ImportOneStreamActivity importOneStreamActivity) {
        importOneStreamActivity.I1();
    }

    public static /* synthetic */ void w1(ImportOneStreamActivity importOneStreamActivity) {
        importOneStreamActivity.K1();
    }

    public static /* synthetic */ List x1(ImportOneStreamActivity importOneStreamActivity) {
        return importOneStreamActivity.e;
    }

    public static /* synthetic */ void y1(ImportOneStreamActivity importOneStreamActivity) {
        importOneStreamActivity.H1();
    }

    public static /* synthetic */ void z1(ImportOneStreamActivity importOneStreamActivity) {
        importOneStreamActivity.G1();
    }

    public void E1() {
    }

    public final void F1() {
        List list = this.g;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/categories/live?token=" + SharepreferenceDBHandler.getOneStreamToken(this.h)).s(k1.e.MEDIUM).q().o(new d());
    }

    public final void G1() {
        List list = this.d;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/content/live?token=" + this.v + "&category_id=all").s(k1.e.MEDIUM).q().o(new e());
    }

    public final void H1() {
        List list = this.g;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/categories/series?token=" + this.v).s(k1.e.MEDIUM).q().o(new a());
    }

    public final void I1() {
        List list = this.f;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/content/series?token=" + this.v + "&category_id=all").s(k1.e.MEDIUM).q().o(new f());
    }

    public final void J1() {
        List list = this.g;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/categories/vod?token=" + this.v).s(k1.e.MEDIUM).q().o(new b());
    }

    public final void K1() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        j1.a.a(m7.a.Z + "play/b2c/v1/content/vod?token=" + this.v + "&category_id=all").s(k1.e.MEDIUM).q().o(new c());
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.M);
        this.i = findViewById(a7.f.Il);
        this.j = findViewById(a7.f.Dj);
        this.k = findViewById(a7.f.Nc);
        this.l = findViewById(a7.f.Mk);
        this.m = findViewById(a7.f.pi);
        this.n = findViewById(a7.f.ve);
        this.o = findViewById(a7.f.ue);
        this.p = findViewById(a7.f.j5);
        D1();
        getWindow().setFlags(1024, 1024);
        this.h = this;
        this.q = new LiveStreamDBHandler(this.h);
        this.s = new MultiUserDBHandler(this.h);
        if (this.q.getImportTableCount("onestream_api") == 0) {
            ArrayList arrayList = new ArrayList();
            ImportStatusModel importStatusModel = new ImportStatusModel();
            importStatusModel.setType("onestream_api");
            importStatusModel.setStatus("0");
            importStatusModel.setDate("");
            arrayList.add(0, importStatusModel);
            this.q.importDataStatusArrayList(arrayList, "onestream_api");
        }
        E1();
        L1();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.h);
        w.z0(this.h);
        getWindow().setFlags(1024, 1024);
    }
}
