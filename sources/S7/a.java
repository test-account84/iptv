package s7;

import a7.k;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.ui.PlayerView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.PlayerSelectedSinglton;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSmallEPG;
import com.nst.iptvsmarterstvbox.view.utility.epg.EPG;
import d.a;
import g7.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m7.w;
import org.joda.time.LocalDateTime;
import s5.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends Fragment {
    public static final int[] W = {0, 1, 2, 3, 4, 5};
    public static u7.a X;
    public SharedPreferences A;
    public Toolbar E;
    public TextView F;
    public TextView G;
    public TextView H;
    public Handler I;
    public SharedPreferences L;
    public SharedPreferences P;
    public SharedPreferences S;
    public String T;
    public String U;
    public Context a;
    public ProgressBar c;
    public TextView d;
    public TextView e;
    public RelativeLayout f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    public PlayerView j;
    public TextView k;
    public EPG l;
    public TextView m;
    public ProgressBar n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public NSTIJKPlayerSmallEPG r;
    public LinearLayout s;
    public RelativeLayout t;
    public DatabaseHandler u;
    public LiveStreamDBHandler v;
    public SharedPreferences y;
    public SharedPreferences z;
    public LiveStreamsDBModel w = new LiveStreamsDBModel();
    public ArrayList x = new ArrayList();
    public DatabaseUpdatedStatusDBModel B = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel C = new DatabaseUpdatedStatusDBModel();
    public ArrayList D = new ArrayList();
    public int J = 0;
    public boolean K = false;
    public String M = "0";
    public String N = "ALL";
    public AsyncTask O = null;
    public int Q = 4;
    public int R = W[0];
    public m V = new m();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a.this.E();
        }
    }

    public class b extends AsyncTask {
        public EPG a;
        public int b;
        public boolean d;
        public ArrayList f;
        public ArrayList g;
        public ArrayList h;
        public ArrayList i;
        public ArrayList j;
        public final /* synthetic */ String l;
        public final /* synthetic */ RelativeLayout m;
        public int c = 0;
        public ArrayList e = new ArrayList();
        public Map k = I.h();

        public b(EPG epg, int i, String str, RelativeLayout relativeLayout) {
            this.l = str;
            this.m = relativeLayout;
            this.b = 0;
            this.b = i;
            this.a = epg;
            epg.S0 = 1;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            String string = a.this.a.getSharedPreferences("epgchannelupdate", 0).getString("epgchannelupdate", "");
            this.d = a.this.a.getSharedPreferences("auto_start", 0).getBoolean("full_epg", false);
            try {
                if (string.equals("all")) {
                    h(this.l);
                } else {
                    g(this.l);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Boolean.TRUE;
        }

        public ArrayList b() {
            String categoryID;
            String valueOf;
            Context context = a.this.a;
            if (context == null) {
                return null;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u")) {
                a.this.v = new LiveStreamDBHandler(a.this.a);
                ArrayList favouriteM3U = a.this.v.getFavouriteM3U("live");
                ArrayList arrayList = new ArrayList();
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = a.this.v.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
                if (arrayList.size() != 0) {
                    return arrayList;
                }
                return null;
            }
            a.this.u = new DatabaseHandler(a.this.a);
            a aVar = a.this;
            ArrayList allFavourites = aVar.u.getAllFavourites("live", SharepreferenceDBHandler.getUserID(aVar.a));
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = allFavourites.iterator();
            while (it2.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(a.this.a);
                if (SharepreferenceDBHandler.getCurrentAPPType(a.this.a).equals("onestream_api")) {
                    categoryID = favouriteDBModel.getCategoryID();
                    valueOf = favouriteDBModel.getStreamIDOneStream();
                } else {
                    categoryID = favouriteDBModel.getCategoryID();
                    valueOf = String.valueOf(favouriteDBModel.getStreamID());
                }
                LiveStreamsDBModel liveStreamFavouriteRow = liveStreamDBHandler.getLiveStreamFavouriteRow(categoryID, valueOf, favouriteDBModel.getTimestamp(), "");
                if (liveStreamFavouriteRow != null) {
                    arrayList2.add(liveStreamFavouriteRow);
                }
            }
            if (arrayList2.size() != 0) {
                return arrayList2;
            }
            return null;
        }

        public final ArrayList c() {
            a aVar = a.this;
            ArrayList allPasswordStatus = aVar.v.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(aVar.a));
            this.f = allPasswordStatus;
            if (allPasswordStatus != null) {
                Iterator it = allPasswordStatus.iterator();
                while (it.hasNext()) {
                    PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                    if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                        this.e.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                    }
                }
            }
            return this.e;
        }

        public final ArrayList d(ArrayList arrayList, ArrayList arrayList2) {
            if (arrayList == null) {
                return null;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                                break;
                            }
                        } else {
                            ArrayList arrayList3 = this.g;
                            if (arrayList3 != null) {
                                arrayList3.add(liveStreamsDBModel);
                            }
                        }
                    }
                }
            }
            return this.g;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            Map map;
            EPG epg;
            if (a.this.g == null || (map = this.k) == null || map.size() <= 0 || (epg = this.a) == null) {
                LinearLayout linearLayout = a.this.g;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    a.this.d.setVisibility(0);
                    a aVar = a.this;
                    aVar.d.setText(aVar.getResources().getString(a7.j.h4));
                }
            } else {
                epg.S0 = 0;
                epg.d0();
                a.this.g.setVisibility(0);
                try {
                    this.a.setEPGData(new E7.a(this.k));
                    EPG epg2 = this.a;
                    epg2.k0(null, false, this.m, epg2);
                } catch (Exception unused) {
                }
            }
            ProgressBar progressBar = a.this.c;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            EPG epg;
            Map map = this.k;
            if (map == null || map.size() <= 0) {
                return;
            }
            ProgressBar progressBar = a.this.c;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            if (a.this.g == null || (epg = this.a) == null) {
                return;
            }
            epg.d0();
            a.this.g.setVisibility(0);
            try {
                this.a.setEPGData(new E7.a(this.k));
                EPG epg2 = this.a;
                epg2.k0(null, false, this.m, epg2);
            } catch (Exception unused) {
            }
        }

        public final void g(String str) {
            if (this.d) {
                i(str);
            } else {
                j(str);
            }
        }

        public final void h(String str) {
            if (this.d) {
                k(str);
            } else {
                l(str);
            }
        }

        public final void i(String str) {
            D7.a aVar;
            D7.a aVar2;
            m mVar;
            D7.b bVar;
            a.this.v = new LiveStreamDBHandler(a.this.a);
            try {
                ArrayList b = str.equals("-1") ? b() : new LiveStreamDBHandler(a.this.a).getAllLiveStreasWithSkyId(str, "live");
                this.f = new ArrayList();
                this.g = new ArrayList();
                this.h = new ArrayList();
                this.i = new ArrayList();
                this.j = new ArrayList();
                a aVar3 = a.this;
                if (aVar3.v.getParentalStatusCount(SharepreferenceDBHandler.getUserID(aVar3.a)) > 0 && b != null) {
                    ArrayList c = c();
                    this.e = c;
                    if (c != null) {
                        this.h = d(b, c);
                    }
                    b = this.h;
                }
                this.i = b;
                if (this.i != null) {
                    int i = -1;
                    D7.a aVar4 = null;
                    D7.a aVar5 = null;
                    D7.a aVar6 = null;
                    int i2 = 0;
                    D7.b bVar2 = null;
                    for (int i3 = 0; i3 < this.i.size(); i3++) {
                        m mVar2 = a.this.V;
                        if (mVar2 != null) {
                            mVar2.e();
                        }
                        if ((a.x(a.this) != null && a.x(a.this).isCancelled()) || ((mVar = a.this.V) != null && mVar.b())) {
                            break;
                        }
                        String name = ((LiveStreamsDBModel) this.i.get(i3)).getName();
                        String epgChannelId = ((LiveStreamsDBModel) this.i.get(i3)).getEpgChannelId();
                        String streamIcon = ((LiveStreamsDBModel) this.i.get(i3)).getStreamIcon();
                        String streamId = ((LiveStreamsDBModel) this.i.get(i3)).getStreamId();
                        String num = ((LiveStreamsDBModel) this.i.get(i3)).getNum();
                        String epgChannelId2 = ((LiveStreamsDBModel) this.i.get(i3)).getEpgChannelId();
                        String url = ((LiveStreamsDBModel) this.i.get(i3)).getUrl();
                        String categoryId = ((LiveStreamsDBModel) this.i.get(i3)).getCategoryId();
                        if (!epgChannelId.equals("")) {
                            int i4 = i + 1;
                            ArrayList epg = a.this.v.getEPG(epgChannelId);
                            if (epg == null || epg.size() == 0) {
                                aVar5 = aVar5;
                            } else {
                                ArrayList arrayList = epg;
                                D7.a aVar7 = aVar5;
                                D7.a aVar8 = new D7.a(streamIcon, name, i2, streamId, num, epgChannelId2, categoryId, url, str);
                                i2++;
                                if (aVar6 == null) {
                                    aVar6 = aVar8;
                                }
                                if (aVar7 != null) {
                                    aVar8.o(aVar7);
                                    aVar7.n(aVar8);
                                }
                                ArrayList arrayList2 = new ArrayList();
                                this.k.put(aVar8, arrayList2);
                                D7.b bVar3 = bVar2;
                                int i5 = 0;
                                Long l = null;
                                while (i5 < arrayList.size() && (a.x(a.this) == null || !a.x(a.this).isCancelled())) {
                                    ArrayList arrayList3 = arrayList;
                                    String start = ((XMLTVProgrammePojo) arrayList3.get(i5)).getStart();
                                    String stop = ((XMLTVProgrammePojo) arrayList3.get(i5)).getStop();
                                    String title = ((XMLTVProgrammePojo) arrayList3.get(i5)).getTitle();
                                    String desc = ((XMLTVProgrammePojo) arrayList3.get(i5)).getDesc();
                                    long x = w.x(start, a.this.a);
                                    Long valueOf = Long.valueOf(x);
                                    long x2 = w.x(stop, a.this.a);
                                    Long valueOf2 = Long.valueOf(x2);
                                    if (l != null && valueOf.equals(l)) {
                                        bVar = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                        if (bVar3 != null) {
                                            bVar.k(bVar3);
                                            bVar3.j(bVar);
                                        }
                                        aVar8.a(bVar);
                                    } else if (l != null) {
                                        D7.b bVar4 = new D7.b(aVar8, l.longValue(), x, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                        if (bVar3 != null) {
                                            bVar4.k(bVar3);
                                            bVar3.j(bVar4);
                                        }
                                        aVar8.a(bVar4);
                                        arrayList2.add(bVar4);
                                        bVar = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                        bVar.k(bVar4);
                                        bVar4.j(bVar);
                                        aVar8.a(bVar);
                                    } else {
                                        bVar = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                        if (bVar3 != null) {
                                            bVar.k(bVar3);
                                            bVar3.j(bVar);
                                        }
                                        aVar8.a(bVar);
                                    }
                                    arrayList2.add(bVar);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (i5 == arrayList3.size() - 1 && x2 < currentTimeMillis) {
                                        D7.b bVar5 = new D7.b(aVar8, x2, x2 + currentTimeMillis + Long.parseLong("7200000"), a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                        bVar5.k(bVar);
                                        bVar.j(bVar5);
                                        aVar8.a(bVar5);
                                        arrayList2.add(bVar5);
                                        bVar = bVar5;
                                    }
                                    if (i5 != 0 || x <= currentTimeMillis) {
                                        bVar3 = bVar;
                                    } else {
                                        bVar3 = new D7.b(aVar8, currentTimeMillis - Long.parseLong("86400000"), x, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                        bVar3.k(bVar);
                                        bVar.j(bVar3);
                                        aVar8.a(bVar3);
                                        arrayList2.add(bVar3);
                                    }
                                    i5++;
                                    arrayList = arrayList3;
                                    l = valueOf2;
                                }
                                bVar2 = bVar3;
                                aVar4 = aVar8;
                                aVar5 = aVar4;
                            }
                            i = i4;
                        }
                        if (i == 10 || (i != 0 && i % 50 == 0)) {
                            publishProgress(new Integer[]{Integer.valueOf(i)});
                        }
                    }
                    aVar2 = aVar4;
                    aVar = aVar6;
                } else {
                    aVar = null;
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    aVar2.n(aVar);
                }
                if (aVar != null) {
                    aVar.o(aVar2);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }

        public final void j(String str) {
            D7.a aVar;
            D7.a aVar2;
            m mVar;
            int i;
            ArrayList epg;
            D7.b bVar;
            List list;
            D7.b bVar2;
            int i2;
            a.this.v = new LiveStreamDBHandler(a.this.a);
            try {
                ArrayList b = str.equals("-1") ? b() : new LiveStreamDBHandler(a.this.a).getAllLiveStreasWithSkyId(str, "live");
                this.f = new ArrayList();
                this.g = new ArrayList();
                this.h = new ArrayList();
                this.i = new ArrayList();
                this.j = new ArrayList();
                a aVar3 = a.this;
                if (aVar3.v.getParentalStatusCount(SharepreferenceDBHandler.getUserID(aVar3.a)) > 0 && b != null) {
                    ArrayList c = c();
                    this.e = c;
                    if (c != null) {
                        this.h = d(b, c);
                    }
                    b = this.h;
                }
                this.i = b;
                if (this.i != null) {
                    int i3 = -1;
                    D7.a aVar4 = null;
                    D7.a aVar5 = null;
                    int i4 = 0;
                    D7.a aVar6 = null;
                    int i5 = 0;
                    D7.b bVar3 = null;
                    while (i4 < this.i.size()) {
                        m mVar2 = a.this.V;
                        if (mVar2 != null) {
                            mVar2.e();
                        }
                        if ((a.x(a.this) != null && a.x(a.this).isCancelled()) || ((mVar = a.this.V) != null && mVar.b())) {
                            break;
                        }
                        String name = ((LiveStreamsDBModel) this.i.get(i4)).getName();
                        String epgChannelId = ((LiveStreamsDBModel) this.i.get(i4)).getEpgChannelId();
                        String streamIcon = ((LiveStreamsDBModel) this.i.get(i4)).getStreamIcon();
                        String streamId = ((LiveStreamsDBModel) this.i.get(i4)).getStreamId();
                        String num = ((LiveStreamsDBModel) this.i.get(i4)).getNum();
                        String epgChannelId2 = ((LiveStreamsDBModel) this.i.get(i4)).getEpgChannelId();
                        String url = ((LiveStreamsDBModel) this.i.get(i4)).getUrl();
                        String categoryId = ((LiveStreamsDBModel) this.i.get(i4)).getCategoryId();
                        if (epgChannelId.equals("") || (epg = a.this.v.getEPG(epgChannelId)) == null || epg.size() == 0) {
                            aVar5 = aVar5;
                        } else {
                            int i6 = i3 + 1;
                            D7.a aVar7 = aVar5;
                            D7.a aVar8 = new D7.a(streamIcon, name, i5, streamId, num, epgChannelId2, categoryId, url, str);
                            i5++;
                            if (aVar6 == null) {
                                aVar6 = aVar8;
                            }
                            if (aVar7 != null) {
                                aVar8.o(aVar7);
                                aVar7.n(aVar8);
                            }
                            List arrayList = new ArrayList();
                            this.k.put(aVar8, arrayList);
                            D7.b bVar4 = bVar3;
                            int i7 = 0;
                            boolean z = false;
                            Long l = null;
                            while (true) {
                                if (i7 >= epg.size()) {
                                    bVar = bVar4;
                                    break;
                                }
                                String start = ((XMLTVProgrammePojo) epg.get(i7)).getStart();
                                String stop = ((XMLTVProgrammePojo) epg.get(i7)).getStop();
                                String title = ((XMLTVProgrammePojo) epg.get(i7)).getTitle();
                                String desc = ((XMLTVProgrammePojo) epg.get(i7)).getDesc();
                                ArrayList arrayList2 = epg;
                                long x = w.x(start, a.this.a);
                                Long valueOf = Long.valueOf(x);
                                List list2 = arrayList;
                                D7.b bVar5 = bVar4;
                                long x2 = w.x(stop, a.this.a);
                                Long valueOf2 = Long.valueOf(x2);
                                if (a.x(a.this) != null && a.x(a.this).isCancelled()) {
                                    bVar = bVar5;
                                    break;
                                }
                                if (w.b0(x, x2, a.this.a) || z) {
                                    long millis = LocalDateTime.now().toDateTime().getMillis() + w.S(a.this.a);
                                    if (x > millis + 12600000) {
                                        list = list2;
                                        bVar2 = bVar5;
                                    } else if (l == null || !valueOf.equals(l)) {
                                        list = list2;
                                        if (l != null) {
                                            D7.b bVar6 = new D7.b(aVar8, l.longValue(), x, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                            if (bVar5 != null) {
                                                bVar6.k(bVar5);
                                                bVar5.j(bVar6);
                                            }
                                            aVar8.a(bVar6);
                                            list.add(bVar6);
                                            bVar2 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                            bVar2.k(bVar6);
                                            bVar6.j(bVar2);
                                            aVar8.a(bVar2);
                                        } else {
                                            bVar2 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                            if (bVar5 != null) {
                                                bVar2.k(bVar5);
                                                bVar5.j(bVar2);
                                            }
                                            aVar8.a(bVar2);
                                        }
                                        list.add(bVar2);
                                    } else {
                                        D7.b bVar7 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                        if (bVar5 != null) {
                                            bVar7.k(bVar5);
                                            bVar5.j(bVar7);
                                        }
                                        aVar8.a(bVar7);
                                        list = list2;
                                        list.add(bVar7);
                                        bVar2 = bVar7;
                                    }
                                    if (i7 == arrayList2.size() - 1 && x2 < millis) {
                                        long parseLong = Long.parseLong("3600000") + x2;
                                        long j = x2;
                                        int i8 = 0;
                                        for (int i9 = 3; i8 < i9 && (a.x(a.this) == null || !a.x(a.this).isCancelled()); i9 = 3) {
                                            D7.b bVar8 = new D7.b(aVar8, j, parseLong, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                            if (bVar2 != null) {
                                                bVar8.k(bVar2);
                                                bVar2.j(bVar8);
                                            }
                                            aVar8.a(bVar8);
                                            list.add(bVar8);
                                            i8++;
                                            bVar2 = bVar8;
                                            j = parseLong;
                                            parseLong = Long.parseLong("3600000") + parseLong;
                                        }
                                    }
                                    if (i7 == 0 && x > millis) {
                                        long j2 = millis;
                                        int i10 = 0;
                                        while (i10 < 3 && (a.x(a.this) == null || !a.x(a.this).isCancelled())) {
                                            D7.b bVar9 = new D7.b(aVar8, j2, x, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                            if (bVar2 != null) {
                                                bVar9.k(bVar2);
                                                bVar2.j(bVar9);
                                            }
                                            aVar8.a(bVar9);
                                            list.add(bVar9);
                                            i10++;
                                            bVar2 = bVar9;
                                            j2 = x;
                                            x = Long.parseLong("3600000") + x;
                                        }
                                    }
                                    bVar4 = bVar2;
                                    l = valueOf2;
                                    i2 = 1;
                                    z = true;
                                } else {
                                    bVar4 = bVar5;
                                    list = list2;
                                    i2 = 1;
                                }
                                i7 += i2;
                                arrayList = list;
                                epg = arrayList2;
                            }
                            bVar3 = bVar;
                            aVar4 = aVar8;
                            aVar5 = aVar4;
                            i3 = i6;
                        }
                        if (i3 == 10 || (i3 != 0 && i3 % 50 == 0)) {
                            i = 1;
                            publishProgress(new Integer[]{Integer.valueOf(i3)});
                        } else {
                            i = 1;
                        }
                        i4 += i;
                    }
                    aVar2 = aVar4;
                    aVar = aVar6;
                } else {
                    aVar = null;
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    aVar2.n(aVar);
                }
                if (aVar != null) {
                    aVar.o(aVar2);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:127:0x0433 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0011, B:5:0x0022, B:6:0x0030, B:9:0x0065, B:11:0x006d, B:12:0x0073, B:13:0x0075, B:16:0x0088, B:18:0x0090, B:20:0x0096, B:21:0x0099, B:23:0x00a1, B:35:0x00ad, B:37:0x00b3, B:41:0x00bb, B:144:0x012d, B:147:0x013c, B:149:0x0142, B:151:0x014e, B:152:0x0152, B:154:0x0158, B:158:0x016b, B:160:0x0171, B:162:0x0177, B:168:0x0186, B:171:0x0192, B:173:0x0198, B:175:0x019e, B:177:0x01ac, B:178:0x01b0, B:180:0x01b6, B:184:0x01c7, B:186:0x01cd, B:188:0x01d3, B:192:0x01e1, B:199:0x01ef, B:48:0x021e, B:49:0x0224, B:53:0x023b, B:55:0x0245, B:58:0x0250, B:60:0x0256, B:62:0x025e, B:80:0x026e, B:82:0x02b2, B:84:0x02b8, B:86:0x02cd, B:87:0x02d3, B:88:0x02d6, B:89:0x0348, B:93:0x0358, B:97:0x0390, B:99:0x03c3, B:102:0x02dd, B:104:0x0300, B:105:0x0306, B:106:0x0329, B:108:0x033e, B:109:0x0344, B:70:0x049e, B:73:0x04ad, B:75:0x04ba, B:111:0x03c9, B:114:0x03e2, B:116:0x03ea, B:120:0x03f7, B:122:0x0416, B:124:0x041c, B:127:0x0433, B:130:0x044c, B:132:0x0454, B:136:0x0461, B:138:0x0480, B:140:0x0486, B:203:0x01e6, B:44:0x0203, B:28:0x04cb, B:30:0x04d0, B:213:0x002a), top: B:2:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x021e A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0011, B:5:0x0022, B:6:0x0030, B:9:0x0065, B:11:0x006d, B:12:0x0073, B:13:0x0075, B:16:0x0088, B:18:0x0090, B:20:0x0096, B:21:0x0099, B:23:0x00a1, B:35:0x00ad, B:37:0x00b3, B:41:0x00bb, B:144:0x012d, B:147:0x013c, B:149:0x0142, B:151:0x014e, B:152:0x0152, B:154:0x0158, B:158:0x016b, B:160:0x0171, B:162:0x0177, B:168:0x0186, B:171:0x0192, B:173:0x0198, B:175:0x019e, B:177:0x01ac, B:178:0x01b0, B:180:0x01b6, B:184:0x01c7, B:186:0x01cd, B:188:0x01d3, B:192:0x01e1, B:199:0x01ef, B:48:0x021e, B:49:0x0224, B:53:0x023b, B:55:0x0245, B:58:0x0250, B:60:0x0256, B:62:0x025e, B:80:0x026e, B:82:0x02b2, B:84:0x02b8, B:86:0x02cd, B:87:0x02d3, B:88:0x02d6, B:89:0x0348, B:93:0x0358, B:97:0x0390, B:99:0x03c3, B:102:0x02dd, B:104:0x0300, B:105:0x0306, B:106:0x0329, B:108:0x033e, B:109:0x0344, B:70:0x049e, B:73:0x04ad, B:75:0x04ba, B:111:0x03c9, B:114:0x03e2, B:116:0x03ea, B:120:0x03f7, B:122:0x0416, B:124:0x041c, B:127:0x0433, B:130:0x044c, B:132:0x0454, B:136:0x0461, B:138:0x0480, B:140:0x0486, B:203:0x01e6, B:44:0x0203, B:28:0x04cb, B:30:0x04d0, B:213:0x002a), top: B:2:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0238  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void k(java.lang.String r35) {
            /*
                Method dump skipped, instructions count: 1246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: s7.a.b.k(java.lang.String):void");
        }

        public final void l(String str) {
            D7.a aVar;
            D7.a aVar2;
            m mVar;
            D7.b bVar;
            D7.b bVar2;
            a.this.v = new LiveStreamDBHandler(a.this.a);
            try {
                ArrayList b = str.equals("-1") ? b() : new LiveStreamDBHandler(a.this.a).getAllLiveStreasWithSkyId(str, "live");
                this.f = new ArrayList();
                this.g = new ArrayList();
                this.h = new ArrayList();
                this.i = new ArrayList();
                this.j = new ArrayList();
                a aVar3 = a.this;
                if (aVar3.v.getParentalStatusCount(SharepreferenceDBHandler.getUserID(aVar3.a)) > 0 && b != null) {
                    ArrayList c = c();
                    this.e = c;
                    if (c != null) {
                        this.h = d(b, c);
                    }
                    b = this.h;
                }
                this.i = b;
                if (this.i != null) {
                    D7.a aVar4 = null;
                    D7.a aVar5 = null;
                    int i = 0;
                    int i2 = -1;
                    D7.a aVar6 = null;
                    D7.b bVar3 = null;
                    while (i < this.i.size()) {
                        m mVar2 = a.this.V;
                        if (mVar2 != null) {
                            mVar2.e();
                        }
                        if ((a.x(a.this) != null && a.x(a.this).isCancelled()) || ((mVar = a.this.V) != null && mVar.b())) {
                            break;
                        }
                        String name = ((LiveStreamsDBModel) this.i.get(i)).getName();
                        String epgChannelId = ((LiveStreamsDBModel) this.i.get(i)).getEpgChannelId();
                        String streamIcon = ((LiveStreamsDBModel) this.i.get(i)).getStreamIcon();
                        D7.a aVar7 = aVar5;
                        int i3 = i;
                        D7.a aVar8 = new D7.a(streamIcon, name, i, ((LiveStreamsDBModel) this.i.get(i)).getStreamId(), ((LiveStreamsDBModel) this.i.get(i)).getNum(), ((LiveStreamsDBModel) this.i.get(i)).getEpgChannelId(), ((LiveStreamsDBModel) this.i.get(i)).getCategoryId(), ((LiveStreamsDBModel) this.i.get(i)).getUrl(), str);
                        if (aVar6 == null) {
                            aVar6 = aVar8;
                        }
                        if (aVar7 != null) {
                            aVar8.o(aVar7);
                            aVar7.n(aVar8);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.k.put(aVar8, arrayList);
                        if (epgChannelId == null || epgChannelId.equals("")) {
                            long millis = LocalDateTime.now().toDateTime().getMillis();
                            long parseLong = Long.parseLong("3600000") + millis;
                            long j = millis;
                            D7.b bVar4 = bVar3;
                            int i4 = 0;
                            while (i4 < 3 && (a.x(a.this) == null || !a.x(a.this).isCancelled())) {
                                D7.b bVar5 = new D7.b(aVar8, j, parseLong, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                if (bVar4 != null) {
                                    bVar5.k(bVar4);
                                    bVar4.j(bVar5);
                                }
                                aVar8.a(bVar5);
                                arrayList.add(bVar5);
                                i4++;
                                bVar4 = bVar5;
                                j = parseLong;
                                parseLong = Long.parseLong("3600000") + parseLong;
                            }
                            bVar3 = bVar4;
                        } else {
                            i2++;
                            ArrayList epg = a.this.v.getEPG(epgChannelId);
                            if (epg == null || epg.size() == 0) {
                                long millis2 = LocalDateTime.now().toDateTime().getMillis();
                                long parseLong2 = Long.parseLong("3600000") + millis2;
                                long j2 = millis2;
                                D7.b bVar6 = bVar3;
                                int i5 = 0;
                                while (i5 < 3 && (a.x(a.this) == null || !a.x(a.this).isCancelled())) {
                                    D7.b bVar7 = new D7.b(aVar8, j2, parseLong2, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                    if (bVar6 != null) {
                                        bVar7.k(bVar6);
                                        bVar6.j(bVar7);
                                    }
                                    aVar8.a(bVar7);
                                    arrayList.add(bVar7);
                                    i5++;
                                    bVar6 = bVar7;
                                    j2 = parseLong2;
                                    parseLong2 = Long.parseLong("3600000") + parseLong2;
                                }
                                bVar = bVar6;
                            } else {
                                bVar = bVar3;
                                boolean z = false;
                                int i6 = 0;
                                Long l = null;
                                while (i6 < epg.size() && (a.x(a.this) == null || !a.x(a.this).isCancelled())) {
                                    String start = ((XMLTVProgrammePojo) epg.get(i6)).getStart();
                                    String stop = ((XMLTVProgrammePojo) epg.get(i6)).getStop();
                                    String title = ((XMLTVProgrammePojo) epg.get(i6)).getTitle();
                                    String desc = ((XMLTVProgrammePojo) epg.get(i6)).getDesc();
                                    long x = w.x(start, a.this.a);
                                    Long valueOf = Long.valueOf(x);
                                    ArrayList arrayList2 = epg;
                                    int i7 = i6;
                                    long x2 = w.x(stop, a.this.a);
                                    Long valueOf2 = Long.valueOf(x2);
                                    if (w.b0(x, x2, a.this.a) || z) {
                                        if (x <= LocalDateTime.now().toDateTime().getMillis() + w.S(a.this.a) + 12600000) {
                                            if (l != null && valueOf.equals(l)) {
                                                bVar2 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                                if (bVar != null) {
                                                    bVar2.k(bVar);
                                                    bVar.j(bVar2);
                                                }
                                                aVar8.a(bVar2);
                                            } else if (l != null) {
                                                D7.b bVar8 = new D7.b(aVar8, l.longValue(), x, a.this.a.getResources().getString(a7.j.p4), streamIcon, "");
                                                if (bVar != null) {
                                                    bVar8.k(bVar);
                                                    bVar.j(bVar8);
                                                }
                                                aVar8.a(bVar8);
                                                arrayList.add(bVar8);
                                                D7.b bVar9 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                                bVar9.k(bVar8);
                                                bVar8.j(bVar9);
                                                aVar8.a(bVar9);
                                                arrayList.add(bVar9);
                                                bVar2 = bVar9;
                                                l = valueOf2;
                                                bVar = bVar2;
                                            } else {
                                                bVar2 = new D7.b(aVar8, x, x2, title, streamIcon, desc);
                                                if (bVar != null) {
                                                    bVar2.k(bVar);
                                                    bVar.j(bVar2);
                                                }
                                                aVar8.a(bVar2);
                                            }
                                            arrayList.add(bVar2);
                                            l = valueOf2;
                                            bVar = bVar2;
                                        }
                                        z = true;
                                    }
                                    i6 = i7 + 1;
                                    epg = arrayList2;
                                }
                            }
                            bVar3 = bVar;
                        }
                        if (i2 == 10 || (i2 != 0 && i2 % 50 == 0)) {
                            publishProgress(new Integer[]{Integer.valueOf(i2)});
                        }
                        i = i3 + 1;
                        aVar4 = aVar8;
                        aVar5 = aVar4;
                    }
                    aVar2 = aVar4;
                    aVar = aVar6;
                } else {
                    aVar = null;
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    aVar2.n(aVar);
                }
                if (aVar != null) {
                    aVar.o(aVar2);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }
    }

    public class c implements View.OnKeyListener {
        public c() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            EPG epg;
            if (keyEvent.getAction() == 1) {
                return false;
            }
            if ((i == 20 || i == 19 || i == 22 || i == 21 || i == 23 || i == 66) && (epg = a.this.l) != null) {
                return epg.onKeyDown(i, keyEvent);
            }
            return false;
        }
    }

    public class d implements C7.a {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        public void a(int i, int i2, D7.b bVar) {
            String str;
            int i3;
            String str2 = "";
            try {
                str2 = bVar.a().l();
                str = str2;
                i3 = Integer.parseInt(bVar.a().l());
            } catch (NumberFormatException unused) {
                str = str2;
                i3 = -1;
            }
            String g = bVar.a().g();
            String i4 = bVar.a().i();
            String d = bVar.a().d();
            String f = bVar.a().f();
            String b = bVar.a().b();
            String j = bVar.a().j();
            String m = bVar.a().m();
            a.this.l.q0(bVar, true);
            EPG epg = a.this.l;
            if (epg != null) {
                epg.H();
            }
            a aVar = a.this;
            EPG epg2 = aVar.l;
            if (epg2 != null) {
                epg2.a(aVar.getContext(), this.a, i3, i4, g, d, f, j, m, b, str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b(int r14, D7.a r15) {
            /*
                r13 = this;
                java.lang.String r14 = r15.l()     // Catch: java.lang.NumberFormatException -> Lf
                java.lang.String r0 = r15.l()     // Catch: java.lang.NumberFormatException -> L11
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L11
                r12 = r14
                r4 = r0
                goto L14
            Lf:
                java.lang.String r14 = ""
            L11:
                r0 = -1
                r12 = r14
                r4 = -1
            L14:
                java.lang.String r6 = r15.g()
                java.lang.String r5 = r15.i()
                java.lang.String r7 = r15.d()
                java.lang.String r8 = r15.f()
                java.lang.String r11 = r15.b()
                java.lang.String r10 = r15.m()
                java.lang.String r9 = r15.j()
                s7.a r14 = s7.a.this
                com.nst.iptvsmarterstvbox.view.utility.epg.EPG r14 = r14.l
                if (r14 == 0) goto L39
                r14.H()
            L39:
                s7.a r14 = s7.a.this
                com.nst.iptvsmarterstvbox.view.utility.epg.EPG r1 = r14.l
                if (r1 == 0) goto L48
                android.content.Context r2 = r14.getContext()
                java.lang.String r3 = r13.a
                r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            L48:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s7.a.d.b(int, D7.a):void");
        }

        public void c() {
            a.this.l.p0();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(a.this.a);
        }
    }

    private void B() {
        RelativeLayout relativeLayout;
        this.a = getContext();
        this.v = new LiveStreamDBHandler(this.a);
        if (this.a != null) {
            J(false);
            if (!this.M.equals("-1")) {
                if ((SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u") ? this.v.getAvailableCountM3U(this.M, "live") : this.v.getLiveStreamsCount(this.M)) == 0 && !this.M.equals("0")) {
                    ProgressBar progressBar = this.c;
                    if (progressBar != null) {
                        progressBar.setVisibility(4);
                    }
                    relativeLayout = this.m;
                    if (relativeLayout == null) {
                        return;
                    }
                    relativeLayout.setVisibility(0);
                    return;
                }
                L(this.M, this.f, a7.f.S2);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u")) {
                ArrayList A = A();
                if (A == null || A.size() == 0) {
                    ProgressBar progressBar2 = this.c;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(4);
                    }
                    TextView textView = this.m;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    relativeLayout = this.t;
                    if (relativeLayout == null) {
                        return;
                    }
                    relativeLayout.setVisibility(0);
                    return;
                }
                L(this.M, this.f, a7.f.S2);
            }
            ArrayList z = z();
            if (z == null || z.size() == 0) {
                ProgressBar progressBar3 = this.c;
                if (progressBar3 != null) {
                    progressBar3.setVisibility(4);
                }
                TextView textView2 = this.m;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                relativeLayout = this.t;
                if (relativeLayout == null) {
                    return;
                }
                relativeLayout.setVisibility(0);
                return;
            }
            L(this.M, this.f, a7.f.S2);
        }
    }

    public static a D(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("ACTIVE_LIVE_STREAM_CATEGORY_ID", str);
        bundle.putString("ACTIVE_LIVE_STREAM_CATEGORY_NAME", str2);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    private void P() {
        this.E = getActivity().findViewById(a7.f.kh);
    }

    public static /* synthetic */ AsyncTask x(a aVar) {
        return aVar.O;
    }

    public ArrayList A() {
        LiveStreamDBHandler liveStreamDBHandler;
        ArrayList favouriteM3U;
        if (this.a == null || (liveStreamDBHandler = this.v) == null || (favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live")) == null || favouriteM3U.size() == 0) {
            return null;
        }
        return favouriteM3U;
    }

    public void E() {
        J((this.l == null || this.l.getSelectedEvent() == null) ? false : true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J(boolean r20) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.a.J(boolean):void");
    }

    public final void L(String str, RelativeLayout relativeLayout, int i) {
        this.O = new b(this.l, 0, str, relativeLayout).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        this.a = context;
        X = new u7.a(context);
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("loginPrefs", 0);
        this.S = sharedPreferences;
        this.Q = sharedPreferences.getInt("aspect_ratio", this.Q);
        Context context2 = this.a;
        if (context2 != null) {
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("openedVideo", 0);
            this.L = sharedPreferences2;
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            this.P = this.a.getSharedPreferences("epgSyncStopped", 0);
            edit.putInt("openedVideoID", 0);
            edit.putString("LOGIN_PREF_OPENED_VIDEO_URL_M3U", "");
            edit.apply();
        }
        if (getArguments() != null) {
            this.M = getArguments().getString("ACTIVE_LIVE_STREAM_CATEGORY_ID");
            this.N = getArguments().getString("ACTIVE_LIVE_STREAM_CATEGORY_NAME");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.a == null || this.E == null) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (this.a.getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.a.getResources().getDisplayMetrics());
        }
        for (int i = 0; i < this.E.getChildCount(); i++) {
            if (this.E.getChildAt(i) instanceof ActionMenuView) {
                ((a.a) this.E.getChildAt(i).getLayoutParams()).a = 16;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        if (X.x() == 3) {
            PlayerSelectedSinglton.getInstance().setPlayerType("epg");
            i = a7.g.O2;
        } else {
            i = a7.g.P2;
        }
        View inflate = layoutInflater.inflate(i, viewGroup, false);
        this.c = inflate.findViewById(a7.f.ec);
        this.d = inflate.findViewById(a7.f.wk);
        this.e = inflate.findViewById(a7.f.lm);
        this.f = inflate.findViewById(a7.f.Me);
        this.g = inflate.findViewById(a7.f.d8);
        this.h = inflate.findViewById(a7.f.y2);
        this.i = inflate.findViewById(a7.f.w2);
        this.j = inflate.findViewById(a7.f.Bc);
        this.k = inflate.findViewById(a7.f.x2);
        this.l = inflate.findViewById(a7.f.S2);
        this.m = inflate.findViewById(a7.f.sk);
        this.n = inflate.findViewById(a7.f.A);
        this.o = inflate.findViewById(a7.f.G);
        this.p = inflate.findViewById(a7.f.K);
        this.q = inflate.findViewById(a7.f.Zh);
        this.r = inflate.findViewById(a7.f.Im);
        this.s = inflate.findViewById(a7.f.p);
        this.t = inflate.findViewById(a7.f.Od);
        this.s.setOnClickListener(new a());
        D.b.d(getActivity());
        setHasOptionsMenu(true);
        try {
            P();
        } catch (Exception unused) {
        }
        B();
        this.i.setSelected(true);
        return inflate;
    }

    public void onDestroyView() {
        EPG epg = this.l;
        if (epg != null) {
            epg.H();
            this.l.I();
            this.l.X0 = true;
        }
        AsyncTask asyncTask = this.O;
        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.O.cancel(true);
        }
        EPG epg2 = this.l;
        if (epg2 != null && epg2.S0 == 1) {
            this.V.a();
        }
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("openedVideo", 0);
        this.L = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this.a, NewDashboardActivity.class));
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this.a, SettingsActivity.class));
        }
        if (itemId != a7.f.f || (context = this.a) == null) {
            return false;
        }
        new a.a(context, k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new f()).g(getResources().getString(a7.j.d4), new e()).n();
        return false;
    }

    public void onPause() {
        super.onPause();
        EPG epg = this.l;
        if (epg != null) {
            epg.H();
            this.l.I();
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
    }

    public void onResume() {
        m mVar;
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("openedVideo", 0);
        this.L = sharedPreferences;
        int i = sharedPreferences.getInt("openedVideoID", 0);
        String string = this.L.getString("LOGIN_PREF_OPENED_VIDEO_URL_M3U", "");
        if (i != 0) {
            this.L.edit().apply();
            if (this.l != null) {
                if (X.x() == 3) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u") || SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("onestream_api")) {
                        this.l.V0 = Uri.parse(string);
                    } else {
                        this.l.V0 = Uri.parse(this.T + i + this.U);
                    }
                    EPG epg = this.l;
                    epg.X0 = false;
                    epg.F0 = 0;
                    epg.I0 = false;
                } else {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("m3u") || SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("onestream_api")) {
                        this.r.b0(Uri.parse(string), true, "");
                    } else {
                        this.r.b0(Uri.parse(this.T + i + this.U), true, "");
                    }
                    NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG = this.r;
                    nSTIJKPlayerSmallEPG.J = 0;
                    nSTIJKPlayerSmallEPG.L = false;
                    nSTIJKPlayerSmallEPG.start();
                }
            }
        }
        EPG epg2 = this.l;
        if (epg2 != null && epg2.S0 == 1 && (mVar = this.V) != null) {
            mVar.d();
        }
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        EPG epg = this.l;
        if (epg != null) {
            epg.H();
            this.l.I();
        }
        try {
            EPG epg2 = this.l;
            if (epg2 != null && epg2.S0 == 1) {
                this.V.c();
            }
        } catch (Exception unused) {
        }
        super.onStop();
        this.I.removeCallbacksAndMessages((Object) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getView() != null) {
            getView().setOnKeyListener(new c());
        }
    }

    public ArrayList z() {
        if (this.a == null) {
            return null;
        }
        DatabaseHandler databaseHandler = new DatabaseHandler(this.a);
        this.u = databaseHandler;
        ArrayList allFavourites = databaseHandler.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.a));
        if (allFavourites == null || allFavourites.size() == 0) {
            return null;
        }
        return allFavourites;
    }
}
