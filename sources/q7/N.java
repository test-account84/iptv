package q7;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.view.activity.DownloadedMovies;
import com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries;
import com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSeriesThumbnail;
import com.nst.iptvsmarterstvbox.view.services.VideoDownloadService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k.U;
import p4.i;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import z3.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class n extends RecyclerView.g implements z7.j {
    public static String T;
    public static String U;
    public String A;
    public List B;
    public String C;
    public String D;
    public String E;
    public SharedPreferences F;
    public String G;
    public String H;
    public String I;
    public NSTIJKPlayerSeriesThumbnail K;
    public String N;
    public String O;
    public n7.g P;
    public DownloadedDBHandler d;
    public ArrayList e;
    public RecyclerView f;
    public Context h;
    public SharedPreferences j;
    public DatabaseHandler k;
    public LiveStreamDBHandler l;
    public l m;
    public Boolean n;
    public Date o;
    public String p;
    public DateFormat q;
    public SimpleDateFormat r;
    public String u;
    public o4.e w;
    public androidx.appcompat.app.a y;
    public boolean z;
    public boolean g = true;
    public int s = 0;
    public String t = "mp4";
    public String v = "";
    public Handler J = new Handler();
    public String L = "";
    public int M = 0;
    public String Q = "";
    public i.a R = new c();
    public BroadcastReceiver S = new b();
    public List i = EpisodesUsingSinglton.getInstance().getCurrentSeasonEpisodeList();
    public String x = m7.w.S0(w7.a.a());

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("status");
                int i = 0;
                if (stringExtra.equals("completed")) {
                    int intExtra = intent.getIntExtra("percent", 0);
                    String stringExtra2 = intent.getStringExtra("url");
                    Log.i("getPercent", "percent:" + intExtra);
                    n nVar = n.this;
                    nVar.e = n.N0(nVar).getDownloadedData();
                    while (i < n.this.e.size()) {
                        if (((DownloadedDataModel) n.this.e.get(i)).getMovieURL().equals(stringExtra2)) {
                            ((DownloadedDataModel) n.this.e.get(i)).setMovieState("Completed");
                            ((DownloadedDataModel) n.this.e.get(i)).setMoviePercentage(intExtra);
                        } else {
                            i++;
                        }
                    }
                    return;
                }
                if (!stringExtra.equals("downloading")) {
                    if (stringExtra.equals("failed")) {
                        int intExtra2 = intent.getIntExtra("percent", 0);
                        String stringExtra3 = intent.getStringExtra("url");
                        Log.i("getPercent", "percent:" + intExtra2);
                        n nVar2 = n.this;
                        nVar2.e = n.N0(nVar2).getDownloadedData();
                        while (i < n.this.e.size()) {
                            if (((DownloadedDataModel) n.this.e.get(i)).getMovieURL().equals(stringExtra3)) {
                                ((DownloadedDataModel) n.this.e.get(i)).setMovieState("Failed");
                                ((DownloadedDataModel) n.this.e.get(i)).setMoviePercentage(intExtra2);
                            } else {
                                i++;
                            }
                        }
                        return;
                    }
                    return;
                }
                int intExtra3 = intent.getIntExtra("percent", 0);
                String stringExtra4 = intent.getStringExtra("url");
                Log.i("getPercent", "percent:" + intExtra3 + "changedPercentage:");
                if (intExtra3 != 0) {
                    for (int i2 = 0; i2 < n.this.e.size(); i2++) {
                        if (((DownloadedDataModel) n.this.e.get(i2)).getMovieURL().equals(stringExtra4)) {
                            if (((DownloadedDataModel) n.this.e.get(i2)).getMovieState().equals("Waiting")) {
                                n nVar3 = n.this;
                                nVar3.e = n.N0(nVar3).getDownloadedData();
                                n.this.w();
                                Log.i("methodCalled", "waiting");
                                return;
                            }
                            ((DownloadedDataModel) n.this.e.get(i2)).setMoviePercentage(intExtra3);
                            int childCount = n.A0(n.this).getChildCount();
                            while (i < childCount) {
                                l lVar = new l(n.A0(n.this).getChildAt(i));
                                if (lVar.v.getText().toString().equals("Downloading..")) {
                                    lVar.u.setProgress(intExtra3);
                                    Log.i("posIS", "pos:" + i);
                                    return;
                                }
                                i++;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
                n.this.w();
            } catch (Exception unused) {
            }
        }
    }

    public class c extends i.a {
        public c() {
        }

        public void g() {
            int n;
            try {
                if (n.j0(n.this) == null || (n = n.j0(n.this).r().n()) == n.k0(n.this)) {
                    return;
                }
                if (n == 2 || n == 3) {
                    n.this.w();
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public d(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = str7;
            this.l = str8;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("stalker_api")) {
                try {
                    m7.w.N0(n.x0(n.this));
                    n.B0(n.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(n.x0(n.this)), SharepreferenceDBHandler.getStalkerToken(n.x0(n.this)), this.a, String.valueOf(this.c), view, "vod", this.d, this.e, this.f, this.g, this.h, this.i, this.j, "", 0, "", "");
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            Log.i("urlIsHere", "url:" + this.k);
            n.F0(n.this, this.d, this.e, this.f, this.g, this.h, this.i, this.j, view, this.l, this.k);
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public e(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = str7;
            this.l = str8;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("stalker_api")) {
                try {
                    m7.w.N0(n.x0(n.this));
                    n.B0(n.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(n.x0(n.this)), SharepreferenceDBHandler.getStalkerToken(n.x0(n.this)), this.a, String.valueOf(this.c), view, "vod", this.d, this.e, this.f, this.g, this.h, this.i, this.j, "", 0, "", "");
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            Log.i("urlIsHere", "url:" + this.k);
            n.F0(n.this, this.d, this.e, this.f, this.g, this.h, this.i, this.j, view, this.l, this.k);
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public f(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = str7;
            this.l = str8;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("stalker_api")) {
                try {
                    m7.w.N0(n.x0(n.this));
                    n.B0(n.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(n.x0(n.this)), SharepreferenceDBHandler.getStalkerToken(n.x0(n.this)), this.a, String.valueOf(this.c), view, "vod", this.d, this.e, this.f, this.g, this.h, this.i, this.j, "", 0, "", "");
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            Log.i("urlIsHere", "url:" + this.k);
            n.F0(n.this, this.d, this.e, this.f, this.g, this.h, this.i, this.j, view, this.l, this.k);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ l i;
        public final /* synthetic */ String j;

        public g(int i, String str, int i2, String str2, String str3, String str4, String str5, l lVar, String str6) {
            this.a = i;
            this.c = str;
            this.d = i2;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = lVar;
            this.j = str6;
        }

        public void onClick(View view) {
            n nVar;
            l lVar;
            String str;
            boolean z;
            boolean z2;
            int i;
            int i2;
            String U = SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api") ? m7.w.U(n.x0(n.this), this.a, this.c, "series") : ((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getLinks();
            Log.i("urlISHERE", "urlIS:" + ((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getLinks());
            Log.i("clickedDownload", "listPosition:" + this.d + "\nfinalStreamID:" + this.a + "\nfinalContainerExtension:" + this.c + "\nfinalName:" + this.e + "\nStreamIcon:" + this.f + "\nfinalSeasonNumber:" + this.g + "\nfinalElapsed_time:" + this.h + "\nurl:" + U);
            if (((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDuration() != null) {
                try {
                    Log.i("duration", "hours:" + ((int) (m7.w.r0(((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDurationSec()) / 3600.0f)) + "\nminutes:" + Math.round((m7.w.r0(((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDurationSec()) % 3600.0f) / 60.0f) + "\nduration:" + ((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDurationSec() + "\nposition" + this.d);
                } catch (Exception unused) {
                }
            }
            String trim = this.i.v.getText().toString().trim();
            if (trim.equalsIgnoreCase(n.x0(n.this).getResources().getString(a7.j.h1).concat("..")) || trim.equalsIgnoreCase("Waiting..")) {
                if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api")) {
                    nVar = n.this;
                    lVar = this.i;
                    str = String.valueOf(this.a);
                } else {
                    nVar = n.this;
                    lVar = this.i;
                    str = this.j;
                }
                n.K0(nVar, view, lVar, str, U);
                return;
            }
            if (this.i.v.getText().toString().equals(n.x0(n.this).getResources().getString(a7.j.g1))) {
                Toast.makeText(n.x0(n.this), "Already Downloaded", 1).show();
                return;
            }
            Toast.makeText(n.x0(n.this), "Downloading Started", 1).show();
            this.i.u.setVisibility(0);
            this.i.v.setText(n.x0(n.this).getResources().getString(a7.j.h1).concat(".."));
            z3.x.x(n.x0(n.this), VideoDownloadService.class, (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api") ? new w.b(String.valueOf(this.a), Uri.parse(U)) : new w.b(String.valueOf(this.j), Uri.parse(U))).a(), true);
            try {
                DownloadedDBHandler downloadedDBHandler = new DownloadedDBHandler(n.x0(n.this));
                ArrayList downloadedData = downloadedDBHandler.getDownloadedData();
                if (downloadedData.size() <= 0) {
                    ArrayList arrayList = new ArrayList();
                    DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                    downloadedDataModel.setMovieName(this.e);
                    downloadedDataModel.setMovieExtension(this.c);
                    downloadedDataModel.setMovieStreamID(SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api") ? String.valueOf(this.a) : this.j);
                    downloadedDataModel.setMovieDuration(((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDurationSec());
                    downloadedDataModel.setMovieNum(String.valueOf(this.d));
                    downloadedDataModel.setMovieImage(this.f);
                    downloadedDataModel.setMovieURL(U);
                    downloadedDataModel.setMovieState("Downloading");
                    downloadedDataModel.setMoviePercentage(0);
                    if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api")) {
                        downloadedDataModel.setMovieType("TYPE_API");
                    } else {
                        downloadedDataModel.setMovieType("SINGLE_STREAM");
                    }
                    arrayList.add(downloadedDataModel);
                    downloadedDBHandler.addDownloadedData(arrayList);
                    return;
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api")) {
                    z = false;
                    z2 = false;
                    i = 0;
                    i2 = 0;
                    for (int i3 = 0; i3 < downloadedData.size(); i3++) {
                        if (((DownloadedDataModel) downloadedData.get(i3)).getMovieStreamID().equals(String.valueOf(this.a))) {
                            i2 = ((DownloadedDataModel) downloadedData.get(i3)).getIdAuto();
                            i = ((DownloadedDataModel) downloadedData.get(i3)).getMoviePercentage();
                            z = true;
                        }
                        if (((DownloadedDataModel) downloadedData.get(i3)).getMovieState().equals("Downloading")) {
                            z2 = true;
                        }
                    }
                } else {
                    z = false;
                    z2 = false;
                    i = 0;
                    i2 = 0;
                    for (int i4 = 0; i4 < downloadedData.size(); i4++) {
                        if (((DownloadedDataModel) downloadedData.get(i4)).getMovieStreamID().equals(String.valueOf(this.j))) {
                            i2 = ((DownloadedDataModel) downloadedData.get(i4)).getIdAuto();
                            i = ((DownloadedDataModel) downloadedData.get(i4)).getMoviePercentage();
                            z = true;
                        }
                        if (((DownloadedDataModel) downloadedData.get(i4)).getMovieState().equals("Downloading")) {
                            z2 = true;
                        }
                    }
                }
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    DownloadedDataModel downloadedDataModel2 = new DownloadedDataModel();
                    if (z2) {
                        downloadedDataModel2.setMovieState("Waiting");
                    } else {
                        downloadedDataModel2.setMovieState("Downloading");
                    }
                    downloadedDataModel2.setMoviePercentage(i);
                    arrayList2.add(downloadedDataModel2);
                    downloadedDBHandler.updateDownloadedData(arrayList2, i2);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    DownloadedDataModel downloadedDataModel3 = new DownloadedDataModel();
                    downloadedDataModel3.setMovieName(this.e);
                    downloadedDataModel3.setMovieExtension(this.c);
                    downloadedDataModel3.setMovieStreamID(SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api") ? String.valueOf(this.a) : this.j);
                    downloadedDataModel3.setMovieDuration(((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.d)).getDurationSec());
                    downloadedDataModel3.setMovieNum(String.valueOf(this.d));
                    downloadedDataModel3.setMovieImage(this.f);
                    downloadedDataModel3.setMovieURL(U);
                    if (z2) {
                        downloadedDataModel3.setMovieState("Waiting");
                    } else {
                        downloadedDataModel3.setMovieState("Downloading");
                    }
                    downloadedDataModel3.setMoviePercentage(0);
                    if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("api")) {
                        downloadedDataModel3.setMovieType("TYPE_API");
                    } else {
                        downloadedDataModel3.setMovieType("SINGLE_STREAM");
                    }
                    arrayList3.add(downloadedDataModel3);
                    downloadedDBHandler.addDownloadedData(arrayList3);
                }
                if (z2) {
                    this.i.v.setText("Waiting..");
                }
            } catch (Exception unused2) {
            }
        }
    }

    public class h implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public h(l lVar, String str, String str2) {
            this.a = lVar;
            this.b = str;
            this.c = str2;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getTitle().toString().equalsIgnoreCase("Cancel Downloading")) {
                n nVar = n.this;
                n.L0(nVar, n.x0(nVar), this.a, this.b, this.c);
            } else if (menuItem.getTitle().toString().equalsIgnoreCase("Pause Downloading")) {
                int i = 0;
                Toast.makeText(n.x0(n.this), "Downloading Paused", 0).show();
                z3.x.z(n.x0(n.this), VideoDownloadService.class, String.valueOf(this.b), 1001, true);
                this.a.v.setText(n.x0(n.this).getResources().getString(a7.j.b5));
                n nVar2 = n.this;
                nVar2.e = n.N0(nVar2).getDownloadedData();
                if (n.this.e.size() > 0) {
                    while (true) {
                        if (i >= n.this.e.size()) {
                            break;
                        }
                        if (((DownloadedDataModel) n.this.e.get(i)).getMovieStreamID().equals(this.b)) {
                            int idAuto = ((DownloadedDataModel) n.this.e.get(i)).getIdAuto();
                            ArrayList arrayList = new ArrayList();
                            DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                            downloadedDataModel.setMovieState("Paused");
                            downloadedDataModel.setMoviePercentage(((DownloadedDataModel) n.this.e.get(i)).getMoviePercentage());
                            arrayList.add(downloadedDataModel);
                            n.N0(n.this).updateDownloadedData(arrayList, idAuto);
                            break;
                        }
                        i++;
                    }
                }
            } else {
                n.x0(n.this).startActivity(new Intent(n.x0(n.this), DownloadedMovies.class));
            }
            return true;
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String c;
        public final /* synthetic */ l d;

        public i(Context context, String str, l lVar) {
            this.a = context;
            this.c = str;
            this.d = lVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(this.a, "Downloading Cancelled", 1).show();
            z3.x.y(this.a, VideoDownloadService.class, String.valueOf(this.c), true);
            this.d.v.setText(n.x0(n.this).getResources().getString(a7.j.U0));
            this.d.u.setVisibility(8);
            this.d.u.setProgress(0);
            n.O0(n.this).dismiss();
            try {
                n nVar = n.this;
                nVar.e = n.N0(nVar).getDownloadedData();
                if (n.this.e.size() > 0) {
                    for (int i2 = 0; i2 < n.this.e.size(); i2++) {
                        if (((DownloadedDataModel) n.this.e.get(i2)).getMovieStreamID().equals(this.c)) {
                            n.N0(n.this).deleteDownloadedData(((DownloadedDataModel) n.this.e.get(i2)).getIdAuto());
                            return;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            n.O0(n.this).dismiss();
        }
    }

    public class k implements U.d {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public k(ArrayList arrayList, int i, String str, String str2, String str3, String str4) {
            this.a = arrayList;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Context x0;
            String l0;
            int i;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            try {
                ArrayList arrayList = this.a;
                if (arrayList != null && arrayList.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.a.size()) {
                            break;
                        }
                        if (menuItem.getItemId() != i2) {
                            i2++;
                        } else if (menuItem.getItemId() == 0) {
                            if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("onestream_api")) {
                                x0 = n.x0(n.this);
                                l0 = n.l0(n.this);
                                i = this.b;
                                str = "series";
                                str2 = this.c;
                                str3 = "0";
                                str4 = this.d;
                                str5 = this.e;
                                str6 = this.f;
                            } else {
                                x0 = n.x0(n.this);
                                l0 = n.l0(n.this);
                                i = this.b;
                                str = "series";
                                str2 = this.c;
                                str3 = "0";
                                str4 = this.d;
                                str5 = "";
                                str6 = "";
                            }
                            m7.w.v0(x0, l0, i, str, str2, str3, str4, (List) null, str5, str6, "");
                        } else {
                            String U = SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("onestream_api") ? this.e : m7.w.U(n.x0(n.this), this.b, this.c, "series");
                            Intent intent = new Intent(n.x0(n.this), PlayExternalPlayerActivity.class);
                            intent.putExtra("url", U);
                            intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i2)).getAppname());
                            intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i2)).getPackagename());
                            n.x0(n.this).startActivity(intent);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public static class l extends RecyclerView.D {
        public RatingBar A;
        public LinearLayout B;
        public ImageView C;
        public LinearLayout D;
        public LinearLayout E;
        public ProgressBar F;
        public LinearLayout G;
        public LinearLayout H;
        public NSTIJKPlayerSeriesThumbnail I;
        public LinearLayout J;
        public ImageView K;
        public LinearLayout L;
        public LinearLayout M;
        public LinearLayout N;
        public LinearLayout O;
        public ImageView t;
        public ProgressBar u;
        public TextView v;
        public LinearLayout w;
        public TextView x;
        public TextView y;
        public TextView z;

        public l(View view) {
            super(view);
            this.t = view.findViewById(a7.f.s4);
            this.u = view.findViewById(a7.f.Pc);
            this.v = view.findViewById(a7.f.Ki);
            this.w = view.findViewById(a7.f.R7);
            this.x = view.findViewById(a7.f.lk);
            this.y = view.findViewById(a7.f.mj);
            this.z = view.findViewById(a7.f.kj);
            this.A = view.findViewById(a7.f.bd);
            this.B = view.findViewById(a7.f.Ge);
            this.C = view.findViewById(a7.f.B5);
            this.D = view.findViewById(a7.f.J1);
            this.E = view.findViewById(a7.f.w8);
            this.F = view.findViewById(a7.f.pc);
            this.G = view.findViewById(a7.f.l9);
            this.H = view.findViewById(a7.f.e8);
            this.I = view.findViewById(a7.f.Im);
            this.J = view.findViewById(a7.f.Ca);
            this.K = view.findViewById(a7.f.L5);
            this.L = view.findViewById(a7.f.e9);
            this.M = view.findViewById(a7.f.d9);
            this.N = view.findViewById(a7.f.c9);
            this.O = view.findViewById(a7.f.k7);
            J(false);
        }
    }

    public class m implements View.OnFocusChangeListener {
        public final View a;
        public final View b;
        public final l c;
        public final int d;
        public final String e;
        public final String f;
        public final String g;
        public final int h;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (m.a(m.this) != null && m.a(m.this).J != null) {
                    m.a(m.this).J.setVisibility(4);
                }
                if (m.a(m.this) == null || m.a(m.this).I == null) {
                    return;
                }
                m.a(m.this).I.setVisibility(0);
                m.a(m.this).I.Y((Activity) n.x0(n.this), m.a(m.this).I);
                n.p0(n.this, n.q0(n.this) + ":" + n.r0(n.this) + "/series/" + n.s0(n.this) + "/" + n.t0(n.this) + "/");
                if (SharepreferenceDBHandler.getCurrentAPPType(n.x0(n.this)).equals("onestream_api")) {
                    try {
                        if (m.b(m.this) != null) {
                            m.a(m.this).I.a0(Uri.parse(m.b(m.this)), true, "");
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    m.a(m.this).I.a0(Uri.parse(n.n0(n.this) + m.c(m.this) + "." + m.d(m.this)), true, "");
                }
                m.a(m.this).I.H = 0;
                m.a(m.this).I.J = false;
                m.a(m.this).I.M(m.a(m.this).I, m.a(m.this).E, m.a(m.this).J, m.a(m.this).C, m.a(m.this).G, m.a(m.this).H, m.a(m.this).F, ((GetEpisdoeDetailsCallback) n.J0(n.this).get(m.e(m.this))).getEpisode_watched_percentage());
                m.a(m.this).I.start();
                m mVar = m.this;
                n.z0(n.this, m.a(mVar).I);
            }
        }

        public m(View view, LinearLayout linearLayout, l lVar, int i, String str, int i2, String str2, String str3) {
            this.a = view;
            this.b = linearLayout;
            this.c = lVar;
            this.d = i;
            this.e = str;
            this.h = i2;
            this.g = str2;
            this.f = str3;
        }

        public static /* synthetic */ l a(m mVar) {
            return mVar.c;
        }

        public static /* synthetic */ String b(m mVar) {
            return mVar.f;
        }

        public static /* synthetic */ int c(m mVar) {
            return mVar.d;
        }

        public static /* synthetic */ String d(m mVar) {
            return mVar.e;
        }

        public static /* synthetic */ int e(m mVar) {
            return mVar.h;
        }

        public final void f(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void g(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void h(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            ImageView imageView;
            NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail;
            LinearLayout linearLayout;
            TextView textView;
            ImageView imageView2;
            NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail2;
            ImageView imageView3;
            TextView textView2;
            try {
                if (z) {
                    f = z ? 1.1f : 1.0f;
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("1")) {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("2")) {
                            View view5 = this.a;
                            if (view5 != null && view5.getTag() != null && this.a.getTag().equals("20")) {
                                View view6 = this.b;
                                if (view6 != null) {
                                    view6.setVisibility(0);
                                }
                                l lVar = this.c;
                                if (lVar != null && (textView2 = lVar.x) != null) {
                                    textView2.setTextColor(n.x0(n.this).getResources().getColor(a7.c.x));
                                }
                                l lVar2 = this.c;
                                if (lVar2 != null && (imageView3 = lVar2.K) != null) {
                                    imageView3.setVisibility(0);
                                }
                                n.m0(n.this).removeCallbacksAndMessages((Object) null);
                                n.m0(n.this).postDelayed(new a(), 5000L);
                                return;
                            }
                            View view7 = this.a;
                            if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("101")) {
                                g(f);
                                return;
                            } else {
                                g(f);
                                view2 = this.c.w;
                                i = a7.e.p;
                            }
                        } else {
                            g(f);
                            view2 = this.a;
                            i = a7.e.k1;
                        }
                    } else {
                        g(f);
                        view2 = this.a;
                        i = a7.e.h;
                    }
                } else {
                    if (z) {
                        return;
                    }
                    f = z ? 1.09f : 1.0f;
                    n.m0(n.this).removeCallbacksAndMessages((Object) null);
                    l lVar3 = this.c;
                    if (lVar3 != null && (nSTIJKPlayerSeriesThumbnail2 = lVar3.I) != null) {
                        try {
                            if (nSTIJKPlayerSeriesThumbnail2.R()) {
                                this.c.I.K();
                            } else {
                                this.c.I.e0();
                                this.c.I.V(true);
                                this.c.I.d0();
                            }
                            IjkMediaPlayer.native_profileEnd();
                        } catch (Exception unused) {
                        }
                    }
                    l lVar4 = this.c;
                    if (lVar4 != null && (imageView2 = lVar4.K) != null) {
                        imageView2.setVisibility(8);
                    }
                    View view8 = this.b;
                    if (view8 != null) {
                        view8.setVisibility(8);
                    }
                    l lVar5 = this.c;
                    if (lVar5 != null && (textView = lVar5.x) != null) {
                        textView.setTextColor(-1);
                    }
                    l lVar6 = this.c;
                    if (lVar6 != null && (linearLayout = lVar6.J) != null) {
                        linearLayout.setVisibility(8);
                    }
                    l lVar7 = this.c;
                    if (lVar7 != null && (nSTIJKPlayerSeriesThumbnail = lVar7.I) != null) {
                        nSTIJKPlayerSeriesThumbnail.setVisibility(8);
                    }
                    l lVar8 = this.c;
                    if (lVar8 != null && (imageView = lVar8.C) != null) {
                        imageView.setVisibility(0);
                    }
                    if (this.c != null && n.J0(n.this) != null && n.J0(n.this).size() > 0) {
                        try {
                            if (n.J0(n.this).get(this.h) == null || ((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.h)).getEpisode_watched_percentage() == 0) {
                                this.c.G.setVisibility(8);
                            } else {
                                this.c.G.setVisibility(0);
                                this.c.F.setProgress(((GetEpisdoeDetailsCallback) n.J0(n.this).get(this.h)).getEpisode_watched_percentage());
                            }
                        } catch (Exception unused2) {
                            this.c.G.setVisibility(8);
                        }
                    }
                    f(z);
                    View view9 = this.a;
                    if (view9 == null || view9.getTag() == null || !this.a.getTag().equals("1")) {
                        View view10 = this.a;
                        if (view10 == null || view10.getTag() == null || !this.a.getTag().equals("2")) {
                            View view11 = this.a;
                            if (view11 == null || view11.getTag() == null || !this.a.getTag().equals("101")) {
                                g(f);
                                h(f);
                                return;
                            } else {
                                g(f);
                                h(f);
                                view2 = this.c.w;
                                i = a7.e.A1;
                            }
                        } else {
                            g(f);
                            h(f);
                            view2 = this.a;
                        }
                    } else {
                        g(f);
                        h(f);
                        view2 = this.a;
                    }
                    i = a7.e.o;
                }
                view2.setBackgroundResource(i);
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.util.List r11, java.lang.String r12, java.lang.String r13, androidx.recyclerview.widget.RecyclerView r14) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.n.<init>(android.content.Context, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, androidx.recyclerview.widget.RecyclerView):void");
    }

    public static /* synthetic */ RecyclerView A0(n nVar) {
        return nVar.f;
    }

    public static /* synthetic */ n7.g B0(n nVar) {
        return nVar.P;
    }

    public static /* synthetic */ void F0(n nVar, int i2, int i3, String str, String str2, String str3, String str4, String str5, View view, String str6, String str7) {
        nVar.W0(i2, i3, str, str2, str3, str4, str5, view, str6, str7);
    }

    public static /* synthetic */ List J0(n nVar) {
        return nVar.i;
    }

    public static /* synthetic */ void K0(n nVar, View view, l lVar, String str, String str2) {
        nVar.a1(view, lVar, str, str2);
    }

    public static /* synthetic */ void L0(n nVar, Context context, l lVar, String str, String str2) {
        nVar.Z0(context, lVar, str, str2);
    }

    public static /* synthetic */ DownloadedDBHandler N0(n nVar) {
        return nVar.d;
    }

    public static /* synthetic */ androidx.appcompat.app.a O0(n nVar) {
        return nVar.y;
    }

    public static long Q0(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String R0(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ o4.e j0(n nVar) {
        return nVar.w;
    }

    public static /* synthetic */ int k0(n nVar) {
        return nVar.M;
    }

    public static /* synthetic */ String l0(n nVar) {
        return nVar.C;
    }

    public static /* synthetic */ Handler m0(n nVar) {
        return nVar.J;
    }

    public static /* synthetic */ String n0(n nVar) {
        return nVar.I;
    }

    public static /* synthetic */ String p0(n nVar, String str) {
        nVar.I = str;
        return str;
    }

    public static /* synthetic */ String q0(n nVar) {
        return nVar.D;
    }

    public static /* synthetic */ String r0(n nVar) {
        return nVar.E;
    }

    public static /* synthetic */ String s0(n nVar) {
        return nVar.G;
    }

    public static /* synthetic */ String t0(n nVar) {
        return nVar.H;
    }

    public static /* synthetic */ Context x0(n nVar) {
        return nVar.h;
    }

    public static /* synthetic */ NSTIJKPlayerSeriesThumbnail z0(n nVar, NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        nVar.K = nSTIJKPlayerSeriesThumbnail;
        return nSTIJKPlayerSeriesThumbnail;
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0567, code lost:
    
        r30.u.setProgress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x05db, code lost:
    
        r30.v.setLayoutParams(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02f9, code lost:
    
        if (r0 != 4) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04c4 A[Catch: Exception -> 0x07a1, TryCatch #6 {Exception -> 0x07a1, blocks: (B:102:0x04bc, B:104:0x04c4, B:106:0x04d0, B:107:0x04e9, B:111:0x0506, B:113:0x050e, B:117:0x0520, B:119:0x0541, B:120:0x0567, B:131:0x056e, B:133:0x0580, B:134:0x05a3, B:136:0x05b5, B:137:0x05db, B:138:0x05e2, B:140:0x05f4, B:141:0x0614, B:142:0x061d, B:144:0x062f, B:145:0x0645, B:115:0x064c, B:148:0x0652, B:150:0x065a, B:154:0x066c, B:156:0x068d, B:157:0x06b5, B:159:0x06c7, B:160:0x06eb, B:162:0x06fd, B:163:0x0725, B:165:0x0737, B:166:0x0759, B:168:0x076b, B:152:0x0783, B:170:0x04dd, B:171:0x078a), top: B:101:0x04bc }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x078a A[Catch: Exception -> 0x07a1, TRY_LEAVE, TryCatch #6 {Exception -> 0x07a1, blocks: (B:102:0x04bc, B:104:0x04c4, B:106:0x04d0, B:107:0x04e9, B:111:0x0506, B:113:0x050e, B:117:0x0520, B:119:0x0541, B:120:0x0567, B:131:0x056e, B:133:0x0580, B:134:0x05a3, B:136:0x05b5, B:137:0x05db, B:138:0x05e2, B:140:0x05f4, B:141:0x0614, B:142:0x061d, B:144:0x062f, B:145:0x0645, B:115:0x064c, B:148:0x0652, B:150:0x065a, B:154:0x066c, B:156:0x068d, B:157:0x06b5, B:159:0x06c7, B:160:0x06eb, B:162:0x06fd, B:163:0x0725, B:165:0x0737, B:166:0x0759, B:168:0x076b, B:152:0x0783, B:170:0x04dd, B:171:0x078a), top: B:101:0x04bc }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0452 A[Catch: Exception -> 0x07b0, TryCatch #0 {Exception -> 0x07b0, blocks: (B:91:0x041b, B:93:0x0429, B:95:0x043a, B:96:0x043e, B:99:0x0461, B:100:0x04b9, B:121:0x07a1, B:123:0x07a5, B:125:0x07a9, B:175:0x0443, B:177:0x0452, B:178:0x0455), top: B:90:0x041b }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0455 A[Catch: Exception -> 0x07b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x07b0, blocks: (B:91:0x041b, B:93:0x0429, B:95:0x043a, B:96:0x043e, B:99:0x0461, B:100:0x04b9, B:121:0x07a1, B:123:0x07a5, B:125:0x07a9, B:175:0x0443, B:177:0x0452, B:178:0x0455), top: B:90:0x041b }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0461 A[Catch: Exception -> 0x07b0, TRY_ENTER, TryCatch #0 {Exception -> 0x07b0, blocks: (B:91:0x041b, B:93:0x0429, B:95:0x043a, B:96:0x043e, B:99:0x0461, B:100:0x04b9, B:121:0x07a1, B:123:0x07a5, B:125:0x07a9, B:175:0x0443, B:177:0x0452, B:178:0x0455), top: B:90:0x041b }] */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(q7.n.l r30, int r31) {
        /*
            Method dump skipped, instructions count: 1969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.n.E(q7.n$l, int):void");
    }

    public final void W0(int i2, int i3, String str, String str2, String str3, String str4, String str5, View view, String str6, String str7) {
        Context context;
        String str8;
        String str9;
        String valueOf;
        String str10;
        String str11;
        List list;
        int i4;
        String str12;
        String str13;
        String str14;
        Log.e("listpos", i2 + "cjec" + (this.i.size() - 1));
        try {
            Handler handler = this.J;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            m7.a.p0 = true;
            m7.a.o0 = i2;
            b1();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.h).equals("stalker_api")) {
                String str15 = this.N;
                if (str15 == null || !str15.equals("from_player")) {
                    m7.w.v0(this.h, this.C, i3, "series", str, String.valueOf(i2), str2, (List) null, this.Q, "", "");
                    return;
                }
                HoneyPlayer honeyPlayer = this.h;
                if (honeyPlayer instanceof HoneyPlayer) {
                    honeyPlayer.r2(this.C, i3, str2, "series", str6, this.Q);
                    return;
                }
                return;
            }
            o4.e eVar = this.w;
            if (eVar != null && eVar.c()) {
                if (this.n.booleanValue()) {
                    String str16 = this.h.getResources().getString(a7.j.J6) + " - " + str4;
                    String U2 = m7.w.U(this.h, i3, str, "series");
                    o4.e eVar2 = this.w;
                    if (eVar2 != null && eVar2.r() != null && this.w.r().j() != null && this.w.r().j().J() != null) {
                        this.L = this.w.r().j().J();
                    }
                    if (this.L.equals(U2)) {
                        this.h.startActivity(new Intent(this.h, ExpandedControlsActivity.class));
                        return;
                    } else {
                        i7.a.c(m7.w.r0(str5), true, i7.a.a(str2, str16, "", 0, U2, "videos/mp4", str3, "", (List) null), this.w, this.h);
                        return;
                    }
                }
                return;
            }
            if (this.n.booleanValue()) {
                if (this.N.equals("from_player")) {
                    Context context2 = this.h;
                    if (context2 instanceof HoneyPlayer) {
                        ((HoneyPlayer) context2).r2(this.C, i3, str2, "series", str6, str7);
                        return;
                    } else {
                        if (context2 instanceof ExoPlayerMoviesSeries) {
                            ((ExoPlayerMoviesSeries) context2).k3(this.C, i3, str2, "series", str6, str7);
                            return;
                        }
                        return;
                    }
                }
                new ArrayList();
                ArrayList arrayList = new ArrayList();
                k.U u = new k.U(this.h, view);
                u.c().inflate(a7.h.m, u.b());
                ArrayList externalPlayer = new ExternalPlayerDataBase(this.h).getExternalPlayer();
                if (externalPlayer != null && externalPlayer.size() > 0) {
                    u.b().add(0, 0, 0, this.h.getResources().getString(a7.j.V3));
                    ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                    externalPlayerModelClass.setId(0);
                    externalPlayerModelClass.setAppname(this.h.getResources().getString(a7.j.h5));
                    arrayList.add(externalPlayerModelClass);
                    int i5 = 0;
                    while (i5 < externalPlayer.size()) {
                        int i6 = i5 + 1;
                        u.b().add(0, i6, 0, this.h.getResources().getString(a7.j.h5) + " " + ((ExternalPlayerModelClass) externalPlayer.get(i5)).getAppname());
                        arrayList.add((ExternalPlayerModelClass) externalPlayer.get(i5));
                        i5 = i6;
                    }
                    u.f(new k(arrayList, i3, str, str2, str7, str6));
                    u.e(new a());
                    u.g();
                    return;
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.h).equals("onestream_api")) {
                    Log.i("urlIS", "url:" + str7);
                    context = this.h;
                    str8 = this.C;
                    str9 = "series";
                    valueOf = String.valueOf(i2);
                    str11 = "";
                    list = null;
                    i4 = i3;
                    str12 = str;
                    str13 = str2;
                    str14 = str7;
                    str10 = str6;
                } else {
                    context = this.h;
                    str8 = this.C;
                    str9 = "series";
                    valueOf = String.valueOf(i2);
                    str10 = "";
                    str11 = "";
                    list = null;
                    i4 = i3;
                    str12 = str;
                    str13 = str2;
                    str14 = this.Q;
                }
                m7.w.v0(context, str8, i4, str9, str12, valueOf, str13, list, str14, str10, str11);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public l L(ViewGroup viewGroup, int i2) {
        LayoutInflater from;
        int i3;
        if (this.O.equals("mobile")) {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.F2;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.G2;
        }
        l lVar = new l(from.inflate(i3, viewGroup, false));
        this.m = lVar;
        return lVar;
    }

    public final void Z0(Context context, l lVar, String str, String str2) {
        if (context != null) {
            a.a aVar = new a.a(context);
            aVar.setTitle("Are you sure want to cancel the downloading?");
            aVar.j("Yes", new i(context, str, lVar));
            aVar.g("No", new j());
            androidx.appcompat.app.a create = aVar.create();
            this.y = create;
            create.show();
        }
    }

    public final void a1(View view, l lVar, String str, String str2) {
        PopupMenu popupMenu = new PopupMenu(this.h, view);
        popupMenu.getMenuInflater().inflate(a7.h.c, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new h(lVar, str, str2));
    }

    public void b1() {
        NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail = this.K;
        if (nSTIJKPlayerSeriesThumbnail != null) {
            try {
                if (nSTIJKPlayerSeriesThumbnail.R()) {
                    this.K.K();
                } else {
                    this.K.e0();
                    this.K.V(true);
                    this.K.d0();
                }
                IjkMediaPlayer.native_profileEnd();
            } catch (Exception unused) {
            }
        }
    }

    public int n() {
        try {
            List list = this.i;
            if (list != null) {
                return list.size();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8) {
        try {
            m7.w.X();
            if (stalkerCreatePlayerLinkCallback != null && stalkerCreatePlayerLinkCallback.getJs() != null && stalkerCreatePlayerLinkCallback.getJs().getCmd() != null && stalkerCreatePlayerLinkCallback.getJs().getId() != null) {
                try {
                    this.Q = stalkerCreatePlayerLinkCallback.getJs().getCmd();
                    W0(i2, i3, str, str2, str3, str4, str5, view, "", "");
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    public class a implements U.c {
        public a() {
        }

        public void a(k.U u) {
        }
    }

    public void D0(String str) {
    }

    public void P(String str) {
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
    }
}
