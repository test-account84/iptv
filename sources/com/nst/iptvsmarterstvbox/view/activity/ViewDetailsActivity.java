package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBPersonInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.model.pojo.TMDBTrailerPojo;
import com.nst.iptvsmarterstvbox.view.services.VideoDownloadService;
import com.squareup.picasso.C;
import com.squareup.picasso.t;
import d.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k.U;
import m7.w;
import p7.q1;
import p7.r1;
import p7.s1;
import p7.t1;
import p7.u1;
import p7.v1;
import p7.w1;
import q7.Z;
import q7.m0;
import q7.t;
import z3.w;
import z3.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ViewDetailsActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.n, z7.k, z7.g, z7.j {
    public static String x1;
    public static String y1;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public DatabaseHandler D0;
    public TextView E;
    public PopupWindow E0;
    public RatingBar F;
    public Button F0;
    public ImageView G;
    public String G0;
    public TextView H;
    public DateFormat H0;
    public TextView I;
    public String I0;
    public TextView J;
    public TextView J0;
    public TextView K;
    public MenuItem K0;
    public LinearLayout L;
    public Menu L0;
    public ScrollView M;
    public NestedScrollView N;
    public LinearLayout O;
    public Button O0;
    public LinearLayout P;
    public o4.e P0;
    public LinearLayout Q;
    public LinearLayout R;
    public LinearLayout S;
    public n7.h S0;
    public LinearLayout T;
    public RecentWatchDBHandler T0;
    public LinearLayout U;
    public LinearLayout V;
    public LinearLayout W;
    public RecyclerView W0;
    public LinearLayout X;
    public ImageView X0;
    public TextView Y;
    public q7.f Y0;
    public LinearLayout Z;
    public View e;
    public TextView e0;
    public String e1;
    public DownloadedDBHandler f;
    public ImageView f0;
    public String f1;
    public ArrayList g;
    public RelativeLayout g0;
    public String g1;
    public TextView h;
    public LinearLayout h0;
    public String h1;
    public ProgressBar i;
    public ProgressBar i0;
    public String i1;
    public ProgressBar j;
    public LinearLayout j0;
    public String j1;
    public ImageView k;
    public androidx.appcompat.app.a k0;
    public int k1;
    public String l;
    public String l1;
    public ProgressDialog m0;
    public String m1;
    public LinearLayout n;
    public SharedPreferences n0;
    public int n1;
    public int o;
    public SharedPreferences o0;
    public SimpleDateFormat o1;
    public LiveStreamDBHandler p0;
    public n7.e p1;
    public Toolbar q;
    public n7.g q1;
    public String r;
    public String s;
    public Date s1;
    public AppBarLayout t;
    public RelativeLayout u;
    public n7.l u0;
    public ImageView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    public boolean d = true;
    public String m = "";
    public String p = "";
    public Context l0 = this;
    public DatabaseUpdatedStatusDBModel q0 = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel r0 = new DatabaseUpdatedStatusDBModel();
    public String s0 = "";
    public String t0 = "";
    public String v0 = "";
    public String w0 = "";
    public String x0 = "";
    public String y0 = "";
    public String z0 = "";
    public int A0 = -1;
    public String B0 = "";
    public String C0 = "";
    public String M0 = "";
    public Boolean N0 = Boolean.TRUE;
    public String Q0 = "";
    public String R0 = "";
    public String U0 = "";
    public String V0 = "";
    public String Z0 = "mobile";
    public int a1 = 0;
    public boolean b1 = false;
    public int c1 = 0;
    public String d1 = "";
    public String r1 = "";
    public ArrayList t1 = new ArrayList();
    public ArrayList u1 = new ArrayList();
    public ArrayList v1 = new ArrayList();
    public BroadcastReceiver w1 = new k();

    public class a implements p1.c {

        public class a implements C {
            public a() {
            }

            public void a(Drawable drawable) {
                Log.d("TAG", "FAILED");
            }

            public void b(Bitmap bitmap, t.e eVar) {
                ViewDetailsActivity.this.t.setBackground(new BitmapDrawable(ViewDetailsActivity.c2(ViewDetailsActivity.this).getResources(), bitmap));
                ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
                viewDetailsActivity.g0.setBackgroundColor(viewDetailsActivity.getResources().getColor(a7.c.B));
                ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
                viewDetailsActivity2.q.setBackgroundColor(viewDetailsActivity2.getResources().getColor(a7.c.B));
            }

            public void c(Drawable drawable) {
                Log.d("TAG", "Prepare Load");
            }
        }

        public class b implements com.squareup.picasso.e {
            public b() {
            }

            public void a() {
                ViewDetailsActivity.this.v.setBackgroundResource(a7.e.o1);
            }

            public void onSuccess() {
            }
        }

        public a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(18:(2:20|21)|(2:23|24)|25|26|(2:28|29)|(2:31|32)|(2:34|35)|(2:36|37)|(2:39|40)|(2:41|42)|(2:44|45)|46|47|(1:49)|(2:50|51)|(3:52|53|(2:58|(1:62)))|64|(23:235|(1:237)|238|(2:240|234)|78|(1:228)(1:83)|84|(1:88)|89|90|(6:219|(1:221)|222|(1:224)|225|(1:227))(1:101)|102|(6:210|(1:212)|213|(1:215)|216|(1:218))(1:113)|114|(8:198|(1:200)|201|(1:203)|204|(1:206)|207|(1:209))(2:123|(1:125)(1:197))|126|(3:133|134|135)|138|(2:194|(1:196))(1:145)|146|(6:185|(1:187)|188|(1:190)|191|(1:193))(3:155|(1:157)(1:184)|158)|159|(5:(1:177)|178|(1:180)|181|(1:183))(7:165|166|167|168|169|(1:171)(1:174)|172))(4:68|(4:229|(1:231)|232|(1:234))(4:72|(1:74)|75|(1:77))|78|(6:228|84|(2:86|88)|89|90|(9:92|219|(0)|222|(0)|225|(0)|102|(9:104|210|(0)|213|(0)|216|(0)|114|(13:116|198|(0)|201|(0)|204|(0)|207|(0)|126|(5:129|131|133|134|135)|138|(4:194|(0)|146|(9:148|185|(0)|188|(0)|191|(0)|159|(6:161|(0)|178|(0)|181|(0))(0))(0))(0))(0))(0))(0))(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:248:0x00ee, code lost:
        
            r11 = 0;
         */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0434  */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0436 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:180:0x043f A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0448 A[Catch: JSONException -> 0x0065, PHI: r15
          0x0448: PHI (r15v24 android.widget.TextView) = (r15v21 android.widget.TextView), (r15v50 android.widget.TextView) binds: [B:318:0x04ad, B:182:0x0446] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:185:0x03ae A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:187:0x03b4 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:190:0x03bd A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:193:0x03c6 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:194:0x036c A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:196:0x0372 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:198:0x02fa A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:200:0x0300 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0309 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0312 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:209:0x031b A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:210:0x0295 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x029b A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:215:0x02a4 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:218:0x02ad A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:219:0x0248 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:221:0x024e A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x0257 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:227:0x0260 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:228:0x01f6 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:235:0x01af A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:237:0x01b5 A[Catch: JSONException -> 0x0065, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:240:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f2 A[Catch: JSONException -> 0x0065, TRY_ENTER, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0065, blocks: (B:4:0x0012, B:49:0x00f2, B:64:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017d, B:72:0x0189, B:74:0x018f, B:75:0x0192, B:77:0x0198, B:78:0x01bf, B:81:0x01cf, B:83:0x01d5, B:84:0x01ff, B:86:0x0207, B:88:0x020d, B:89:0x0214, B:92:0x021c, B:94:0x0220, B:97:0x0226, B:99:0x022c, B:101:0x0232, B:102:0x0263, B:104:0x0269, B:106:0x026d, B:109:0x0273, B:111:0x0279, B:113:0x027f, B:114:0x02b0, B:116:0x02b6, B:118:0x02ba, B:121:0x02c0, B:123:0x02c6, B:125:0x02dc, B:126:0x031e, B:129:0x0326, B:131:0x032c, B:133:0x0332, B:135:0x0339, B:137:0x0348, B:138:0x0350, B:141:0x0358, B:143:0x035e, B:145:0x0364, B:146:0x0375, B:148:0x037b, B:150:0x037f, B:153:0x0385, B:155:0x038b, B:157:0x03a1, B:158:0x03a5, B:159:0x03c9, B:161:0x03cf, B:163:0x03d3, B:165:0x03d7, B:175:0x042b, B:177:0x0436, B:178:0x0439, B:180:0x043f, B:181:0x0442, B:183:0x0448, B:184:0x03a9, B:185:0x03ae, B:187:0x03b4, B:188:0x03b7, B:190:0x03bd, B:191:0x03c0, B:193:0x03c6, B:194:0x036c, B:196:0x0372, B:197:0x02eb, B:198:0x02fa, B:200:0x0300, B:201:0x0303, B:203:0x0309, B:204:0x030c, B:206:0x0312, B:207:0x0315, B:209:0x031b, B:210:0x0295, B:212:0x029b, B:213:0x029e, B:215:0x02a4, B:216:0x02a7, B:218:0x02ad, B:219:0x0248, B:221:0x024e, B:222:0x0251, B:224:0x0257, B:225:0x025a, B:227:0x0260, B:228:0x01f6, B:229:0x019c, B:231:0x01a2, B:232:0x01a5, B:234:0x01ab, B:235:0x01af, B:237:0x01b5, B:238:0x01b8, B:242:0x0161, B:245:0x0103, B:251:0x00dc, B:253:0x00cc, B:256:0x00c0, B:259:0x00b4, B:263:0x00a8, B:266:0x009c, B:269:0x0091, B:274:0x007e, B:277:0x0072, B:287:0x0061, B:288:0x044c, B:290:0x0454, B:292:0x045a, B:293:0x0461, B:295:0x0467, B:296:0x046a, B:298:0x0470, B:299:0x0473, B:301:0x0479, B:302:0x047c, B:304:0x0482, B:305:0x0485, B:307:0x048b, B:308:0x048e, B:310:0x0494, B:311:0x0497, B:313:0x049d, B:314:0x04a0, B:316:0x04a6, B:317:0x04a9, B:168:0x03eb, B:171:0x03f3, B:174:0x040b, B:42:0x00c4, B:37:0x00ac, B:21:0x006a, B:53:0x0107, B:56:0x010f, B:58:0x0115, B:60:0x0137, B:62:0x0143, B:280:0x0029, B:281:0x0033, B:283:0x0039, B:40:0x00b8, B:24:0x0076, B:45:0x00cf, B:32:0x0094, B:35:0x00a0, B:51:0x00fb), top: B:2:0x0010, inners: #2, #5, #6, #7, #9, #10, #11, #12, #13, #14, #15, #16, #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01cd A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(org.json.JSONObject r15) {
            /*
                Method dump skipped, instructions count: 1234
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.a.a(org.json.JSONObject):void");
        }

        public void b(m1.a aVar) {
            Log.e("Categories For Live", String.valueOf(aVar));
            Toast.makeText(ViewDetailsActivity.this.getApplicationContext(), ViewDetailsActivity.this.getResources().getString(a7.j.D2), 0).show();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class d implements C {
        public d() {
        }

        public void a(Drawable drawable) {
            Log.d("TAG", "FAILED");
        }

        public void b(Bitmap bitmap, t.e eVar) {
            ViewDetailsActivity.this.t.setBackground(new BitmapDrawable(ViewDetailsActivity.c2(ViewDetailsActivity.this).getResources(), bitmap));
            ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
            viewDetailsActivity.g0.setBackgroundColor(viewDetailsActivity.getResources().getColor(a7.c.B));
            ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
            viewDetailsActivity2.q.setBackgroundColor(viewDetailsActivity2.getResources().getColor(a7.c.B));
        }

        public void c(Drawable drawable) {
            Log.d("TAG", "Prepare Load");
        }
    }

    public class e implements com.squareup.picasso.e {
        public e() {
        }

        public void a() {
            ViewDetailsActivity.this.v.setBackgroundResource(a7.e.o1);
        }

        public void onSuccess() {
        }
    }

    public class f implements C {
        public f() {
        }

        public void a(Drawable drawable) {
            Log.d("TAG", "FAILED");
        }

        public void b(Bitmap bitmap, t.e eVar) {
            ViewDetailsActivity.this.t.setBackground(new BitmapDrawable(ViewDetailsActivity.c2(ViewDetailsActivity.this).getResources(), bitmap));
            ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
            viewDetailsActivity.g0.setBackgroundColor(viewDetailsActivity.getResources().getColor(a7.c.B));
            ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
            viewDetailsActivity2.q.setBackgroundColor(viewDetailsActivity2.getResources().getColor(a7.c.B));
        }

        public void c(Drawable drawable) {
            Log.d("TAG", "Prepare Load");
        }
    }

    public class g implements U.d {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ String b;

        public g(ArrayList arrayList, String str) {
            this.a = arrayList;
            this.b = str;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ArrayList arrayList;
            Context c2;
            String str;
            int E1;
            String S1;
            String R1;
            String T1;
            String O1;
            String str2;
            int H1;
            String str3;
            String str4;
            try {
                if (ViewDetailsActivity.Q1(ViewDetailsActivity.this).booleanValue() && (arrayList = this.a) != null && arrayList.size() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= this.a.size()) {
                            break;
                        }
                        if (menuItem.getItemId() != i) {
                            i++;
                        } else if (menuItem.getItemId() == 0) {
                            if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("onestream_api")) {
                                String str5 = ViewDetailsActivity.this.R0;
                            } else {
                                w.U(ViewDetailsActivity.c2(ViewDetailsActivity.this), ViewDetailsActivity.E1(ViewDetailsActivity.this), ViewDetailsActivity.R1(ViewDetailsActivity.this), "movie");
                            }
                            if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("onestream_api")) {
                                c2 = ViewDetailsActivity.c2(ViewDetailsActivity.this);
                                str = this.b;
                                E1 = ViewDetailsActivity.E1(ViewDetailsActivity.this);
                                S1 = ViewDetailsActivity.S1(ViewDetailsActivity.this);
                                R1 = ViewDetailsActivity.R1(ViewDetailsActivity.this);
                                T1 = ViewDetailsActivity.T1(ViewDetailsActivity.this);
                                O1 = ViewDetailsActivity.O1(ViewDetailsActivity.this);
                                ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
                                str2 = viewDetailsActivity.R0;
                                H1 = ViewDetailsActivity.H1(viewDetailsActivity);
                                str3 = ViewDetailsActivity.d2(ViewDetailsActivity.this);
                                str4 = ViewDetailsActivity.this.p;
                            } else {
                                c2 = ViewDetailsActivity.c2(ViewDetailsActivity.this);
                                str = this.b;
                                E1 = ViewDetailsActivity.E1(ViewDetailsActivity.this);
                                S1 = ViewDetailsActivity.S1(ViewDetailsActivity.this);
                                R1 = ViewDetailsActivity.R1(ViewDetailsActivity.this);
                                T1 = ViewDetailsActivity.T1(ViewDetailsActivity.this);
                                O1 = ViewDetailsActivity.O1(ViewDetailsActivity.this);
                                str2 = "";
                                H1 = ViewDetailsActivity.H1(ViewDetailsActivity.this);
                                str3 = "";
                                str4 = ViewDetailsActivity.this.p;
                            }
                            w.w0(c2, str, E1, S1, R1, T1, O1, str2, H1, str3, str4, "");
                        } else {
                            String G = SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("onestream_api") ? ViewDetailsActivity.this.R0 : w.G(w.U(ViewDetailsActivity.c2(ViewDetailsActivity.this), ViewDetailsActivity.E1(ViewDetailsActivity.this), ViewDetailsActivity.R1(ViewDetailsActivity.this), "movie"));
                            if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("onestream_api")) {
                                Intent intent = new Intent(ViewDetailsActivity.c2(ViewDetailsActivity.this), PlayExternalPlayerActivity.class);
                                intent.putExtra("url", ViewDetailsActivity.this.R0);
                                intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                                intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                                ViewDetailsActivity.c2(ViewDetailsActivity.this).startActivity(intent);
                            } else {
                                Intent intent2 = new Intent(ViewDetailsActivity.c2(ViewDetailsActivity.this), PlayExternalPlayerActivity.class);
                                intent2.putExtra("url", G);
                                intent2.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                                intent2.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                                ViewDetailsActivity.c2(ViewDetailsActivity.this).startActivity(intent2);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            ViewDetailsActivity.e2(ViewDetailsActivity.this).dismiss();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public void onClick(View view) {
            ViewDetailsActivity.e2(ViewDetailsActivity.this).dismiss();
        }
    }

    public class k extends BroadcastReceiver {
        public k() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("status");
                Log.i("statusIs", "status:" + stringExtra);
                if (stringExtra.equals("completed")) {
                    if (intent.getStringExtra("url").equals(ViewDetailsActivity.this.l)) {
                        ViewDetailsActivity.this.h.setText(a7.j.g1);
                        ViewDetailsActivity.this.i.setVisibility(8);
                        ViewDetailsActivity.this.k.setVisibility(0);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(10, 0, 0, 0);
                        ViewDetailsActivity.this.h.setLayoutParams(layoutParams);
                    }
                } else if (stringExtra.equals("downloading")) {
                    int intExtra = intent.getIntExtra("percent", 0);
                    String stringExtra2 = intent.getStringExtra("url");
                    Log.i("getPercent", "percent:" + intExtra);
                    if (stringExtra2.equals(ViewDetailsActivity.this.l)) {
                        ViewDetailsActivity.this.i.setVisibility(0);
                        ViewDetailsActivity.this.h.setText(context.getResources().getString(a7.j.h1).concat(".."));
                        ViewDetailsActivity.this.i.setProgress(intExtra);
                    }
                } else if (stringExtra.equals("failed")) {
                    int intExtra2 = intent.getIntExtra("percent", 0);
                    if (intent.getStringExtra("url").equals(ViewDetailsActivity.this.l)) {
                        ViewDetailsActivity.this.i.setVisibility(0);
                        ViewDetailsActivity.this.i.setProgress(intExtra2);
                        ViewDetailsActivity.this.h.setText(a7.j.i1);
                        ViewDetailsActivity.this.i.setVisibility(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class l implements PopupMenu.OnMenuItemClickListener {
        public l() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Context c2;
            String valueOf;
            if (menuItem.getTitle().toString().equalsIgnoreCase("Cancel Downloading")) {
                Activity activity = ViewDetailsActivity.this;
                activity.B2(activity);
            } else if (menuItem.getTitle().toString().equalsIgnoreCase("Pause Downloading")) {
                int i = 0;
                Toast.makeText(ViewDetailsActivity.c2(ViewDetailsActivity.this), "Downloading Paused", 0).show();
                if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api")) {
                    c2 = ViewDetailsActivity.c2(ViewDetailsActivity.this);
                    valueOf = String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this));
                } else {
                    c2 = ViewDetailsActivity.c2(ViewDetailsActivity.this);
                    valueOf = String.valueOf(ViewDetailsActivity.d2(ViewDetailsActivity.this));
                }
                x.z(c2, VideoDownloadService.class, valueOf, 1001, true);
                ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
                viewDetailsActivity.h.setText(ViewDetailsActivity.c2(viewDetailsActivity).getResources().getString(a7.j.b5));
                ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
                viewDetailsActivity2.g = ViewDetailsActivity.Y1(viewDetailsActivity2).getDownloadedData();
                if (ViewDetailsActivity.this.g.size() > 0) {
                    while (true) {
                        if (i >= ViewDetailsActivity.this.g.size()) {
                            break;
                        }
                        if (((DownloadedDataModel) ViewDetailsActivity.this.g.get(i)).getMovieURL().equals(ViewDetailsActivity.this.l)) {
                            int idAuto = ((DownloadedDataModel) ViewDetailsActivity.this.g.get(i)).getIdAuto();
                            ArrayList arrayList = new ArrayList();
                            DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                            downloadedDataModel.setMovieState("Paused");
                            downloadedDataModel.setMoviePercentage(((DownloadedDataModel) ViewDetailsActivity.this.g.get(i)).getMoviePercentage());
                            arrayList.add(downloadedDataModel);
                            ViewDetailsActivity.Y1(ViewDetailsActivity.this).updateDownloadedData(arrayList, idAuto);
                            break;
                        }
                        i++;
                    }
                }
            } else {
                ViewDetailsActivity.this.startActivity(new Intent(ViewDetailsActivity.this, DownloadedMovies.class));
            }
            return true;
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Context applicationContext;
            String valueOf;
            Toast.makeText(ViewDetailsActivity.this.getApplicationContext(), "Downloading Cancelled", 1).show();
            if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api")) {
                applicationContext = ViewDetailsActivity.this.getApplicationContext();
                valueOf = String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this));
            } else {
                applicationContext = ViewDetailsActivity.this.getApplicationContext();
                valueOf = String.valueOf(ViewDetailsActivity.d2(ViewDetailsActivity.this));
            }
            x.y(applicationContext, VideoDownloadService.class, valueOf, true);
            ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
            viewDetailsActivity.h.setText(ViewDetailsActivity.c2(viewDetailsActivity).getResources().getString(a7.j.U0));
            ViewDetailsActivity.this.i.setVisibility(8);
            ViewDetailsActivity.this.i.setProgress(0);
            ViewDetailsActivity.this.k0.dismiss();
            try {
                ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
                viewDetailsActivity2.g = ViewDetailsActivity.Y1(viewDetailsActivity2).getDownloadedData();
                if (ViewDetailsActivity.this.g.size() > 0) {
                    for (int i2 = 0; i2 < ViewDetailsActivity.this.g.size(); i2++) {
                        if (((DownloadedDataModel) ViewDetailsActivity.this.g.get(i2)).getMovieURL().equals(ViewDetailsActivity.this.l)) {
                            ViewDetailsActivity.Y1(ViewDetailsActivity.this).deleteDownloadedData(((DownloadedDataModel) ViewDetailsActivity.this.g.get(i2)).getIdAuto());
                            return;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ViewDetailsActivity.this.k0.dismiss();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            ViewDetailsActivity.e2(ViewDetailsActivity.this).dismiss();
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        public void onClick(View view) {
            w.j(ViewDetailsActivity.c2(ViewDetailsActivity.this));
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        public void onClick(View view) {
            ViewDetailsActivity.this.onBackPressed();
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public r(Context context) {
            this.a = context;
        }

        public void onClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("stalker_api")) {
                if (ViewDetailsActivity.B1(ViewDetailsActivity.this) == 1) {
                    ViewDetailsActivity.C1(ViewDetailsActivity.this);
                    return;
                } else {
                    ViewDetailsActivity.D1(ViewDetailsActivity.this);
                    return;
                }
            }
            if (ViewDetailsActivity.G1(ViewDetailsActivity.this).checkFavourite(ViewDetailsActivity.E1(ViewDetailsActivity.this), ViewDetailsActivity.F1(ViewDetailsActivity.this), "vod", SharepreferenceDBHandler.getUserID(this.a), ViewDetailsActivity.d2(ViewDetailsActivity.this)).size() > 0) {
                ViewDetailsActivity.b2(ViewDetailsActivity.this);
            } else {
                ViewDetailsActivity.a2(ViewDetailsActivity.this);
            }
        }
    }

    public class s implements com.squareup.picasso.e {
        public s() {
        }

        public void a() {
            ViewDetailsActivity.this.v.setBackgroundResource(a7.e.o1);
        }

        public void onSuccess() {
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        public void onClick(View view) {
            if (ViewDetailsActivity.G1(ViewDetailsActivity.this).checkFavourite(ViewDetailsActivity.E1(ViewDetailsActivity.this), ViewDetailsActivity.F1(ViewDetailsActivity.this), "vod", SharepreferenceDBHandler.getUserID(ViewDetailsActivity.c2(ViewDetailsActivity.this)), ViewDetailsActivity.d2(ViewDetailsActivity.this)).size() > 0) {
                ViewDetailsActivity.b2(ViewDetailsActivity.this);
            } else {
                ViewDetailsActivity.a2(ViewDetailsActivity.this);
            }
        }
    }

    public class u extends AsyncTask {
        public u() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                HttpURLConnection openConnection = new URL("http://www.google.com").openConnection();
                openConnection.setRequestMethod("HEAD");
                openConnection.setReadTimeout(1500);
                openConnection.setConnectTimeout(1500);
                return Boolean.valueOf(openConnection.getResponseCode() == 200);
            } catch (Exception e) {
                Log.e("LOG_TAG", e.toString());
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            String str;
            DownloadedDataModel downloadedDataModel;
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                ViewDetailsActivity.V1(ViewDetailsActivity.this, true);
                str = "connected";
            } else {
                ViewDetailsActivity.V1(ViewDetailsActivity.this, false);
                str = "not connected";
            }
            Log.i("internetCheck", str);
            String trim = ViewDetailsActivity.this.h.getText().toString().trim();
            if (trim.equalsIgnoreCase(ViewDetailsActivity.c2(ViewDetailsActivity.this).getResources().getString(a7.j.h1).concat("..")) || trim.equalsIgnoreCase("Waiting..")) {
                ViewDetailsActivity viewDetailsActivity = ViewDetailsActivity.this;
                ViewDetailsActivity.X1(viewDetailsActivity, ViewDetailsActivity.W1(viewDetailsActivity));
                return;
            }
            if (ViewDetailsActivity.this.h.getText().toString().equals(ViewDetailsActivity.c2(ViewDetailsActivity.this).getResources().getString(a7.j.g1))) {
                Toast.makeText(ViewDetailsActivity.this.getApplicationContext(), "Already Downloaded", 1).show();
                return;
            }
            if (!ViewDetailsActivity.U1(ViewDetailsActivity.this)) {
                ViewDetailsActivity.Z1(ViewDetailsActivity.this);
                return;
            }
            Toast.makeText(ViewDetailsActivity.this.getApplicationContext(), "Downloading Started", 1).show();
            ViewDetailsActivity.this.i.setVisibility(0);
            ViewDetailsActivity viewDetailsActivity2 = ViewDetailsActivity.this;
            viewDetailsActivity2.h.setText(ViewDetailsActivity.c2(viewDetailsActivity2).getResources().getString(a7.j.h1).concat(".."));
            Log.i("movieURLIS", "url:" + ViewDetailsActivity.this.l);
            x.x(ViewDetailsActivity.this.getApplicationContext(), VideoDownloadService.class, (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api") ? new w.b(String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this)), Uri.parse(ViewDetailsActivity.this.l)) : new w.b(ViewDetailsActivity.d2(ViewDetailsActivity.this), Uri.parse(ViewDetailsActivity.this.l))).a(), true);
            try {
                ViewDetailsActivity viewDetailsActivity3 = ViewDetailsActivity.this;
                viewDetailsActivity3.g = ViewDetailsActivity.Y1(viewDetailsActivity3).getDownloadedData();
                if (ViewDetailsActivity.this.g.size() <= 0) {
                    ArrayList arrayList = new ArrayList();
                    DownloadedDataModel downloadedDataModel2 = new DownloadedDataModel();
                    downloadedDataModel2.setMovieName(ViewDetailsActivity.O1(ViewDetailsActivity.this));
                    downloadedDataModel2.setMovieExtension(ViewDetailsActivity.R1(ViewDetailsActivity.this));
                    downloadedDataModel2.setMovieStreamID(SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api") ? String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this)) : String.valueOf(ViewDetailsActivity.d2(ViewDetailsActivity.this)));
                    downloadedDataModel2.setMovieDuration(String.valueOf(ViewDetailsActivity.H1(ViewDetailsActivity.this)));
                    downloadedDataModel2.setMovieNum(ViewDetailsActivity.T1(ViewDetailsActivity.this));
                    downloadedDataModel2.setMovieImage(ViewDetailsActivity.this.m);
                    downloadedDataModel2.setMovieURL(ViewDetailsActivity.this.l);
                    downloadedDataModel2.setMovieState("Downloading");
                    downloadedDataModel2.setMoviePercentage(0);
                    if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api")) {
                        downloadedDataModel2.setMovieType("TYPE_API");
                    } else {
                        downloadedDataModel2.setMovieType("SINGLE_STREAM");
                    }
                    arrayList.add(downloadedDataModel2);
                    ViewDetailsActivity.Y1(ViewDetailsActivity.this).addDownloadedData(arrayList);
                    Log.i("movieDuration", "duration:" + ViewDetailsActivity.H1(ViewDetailsActivity.this));
                    Log.i("movieURLIS", "url:" + ViewDetailsActivity.this.l);
                    return;
                }
                boolean z = false;
                boolean z2 = false;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < ViewDetailsActivity.this.g.size(); i3++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api")) {
                        if (((DownloadedDataModel) ViewDetailsActivity.this.g.get(i3)).getMovieStreamID().equals(String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this)))) {
                            i2 = ((DownloadedDataModel) ViewDetailsActivity.this.g.get(i3)).getIdAuto();
                            downloadedDataModel = (DownloadedDataModel) ViewDetailsActivity.this.g.get(i3);
                            i = downloadedDataModel.getMoviePercentage();
                            z = true;
                        }
                    } else if (((DownloadedDataModel) ViewDetailsActivity.this.g.get(i3)).getMovieStreamID().equals(String.valueOf(ViewDetailsActivity.d2(ViewDetailsActivity.this)))) {
                        i2 = ((DownloadedDataModel) ViewDetailsActivity.this.g.get(i3)).getIdAuto();
                        downloadedDataModel = (DownloadedDataModel) ViewDetailsActivity.this.g.get(i3);
                        i = downloadedDataModel.getMoviePercentage();
                        z = true;
                    }
                    if (((DownloadedDataModel) ViewDetailsActivity.this.g.get(i3)).getMovieState().equals("Downloading")) {
                        z2 = true;
                    }
                }
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    DownloadedDataModel downloadedDataModel3 = new DownloadedDataModel();
                    if (z2) {
                        downloadedDataModel3.setMovieState("Waiting");
                    } else {
                        downloadedDataModel3.setMovieState("Downloading");
                    }
                    downloadedDataModel3.setMoviePercentage(i);
                    arrayList2.add(downloadedDataModel3);
                    ViewDetailsActivity.Y1(ViewDetailsActivity.this).updateDownloadedData(arrayList2, i2);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    DownloadedDataModel downloadedDataModel4 = new DownloadedDataModel();
                    downloadedDataModel4.setMovieName(ViewDetailsActivity.O1(ViewDetailsActivity.this));
                    downloadedDataModel4.setMovieExtension(ViewDetailsActivity.R1(ViewDetailsActivity.this));
                    downloadedDataModel4.setMovieStreamID(SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api") ? String.valueOf(ViewDetailsActivity.E1(ViewDetailsActivity.this)) : String.valueOf(ViewDetailsActivity.d2(ViewDetailsActivity.this)));
                    downloadedDataModel4.setMovieDuration(String.valueOf(ViewDetailsActivity.H1(ViewDetailsActivity.this)));
                    downloadedDataModel4.setMovieNum(ViewDetailsActivity.T1(ViewDetailsActivity.this));
                    downloadedDataModel4.setMovieImage(ViewDetailsActivity.this.m);
                    downloadedDataModel4.setMovieURL(ViewDetailsActivity.this.l);
                    if (z2) {
                        downloadedDataModel4.setMovieState("Waiting");
                    } else {
                        downloadedDataModel4.setMovieState("Downloading");
                    }
                    downloadedDataModel4.setMoviePercentage(0);
                    if (SharepreferenceDBHandler.getCurrentAPPType(ViewDetailsActivity.c2(ViewDetailsActivity.this)).equals("api")) {
                        downloadedDataModel4.setMovieType("TYPE_API");
                    } else {
                        downloadedDataModel4.setMovieType("SINGLE_STREAM");
                    }
                    arrayList3.add(downloadedDataModel4);
                    ViewDetailsActivity.Y1(ViewDetailsActivity.this).addDownloadedData(arrayList3);
                    Log.i("movieURLIS", "url:" + ViewDetailsActivity.this.l);
                }
                if (z2) {
                    ViewDetailsActivity.this.h.setText("Waiting..");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class v implements View.OnFocusChangeListener {
        public final View a;

        public v(View view) {
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
            LinearLayout linearLayout;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("1")) {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsActivity.this.j0;
                } else if (this.a.getTag().equals("2")) {
                    a(f);
                    b(f);
                    linearLayout = this.a;
                } else if (this.a.getTag().equals("5")) {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsActivity.this.h0;
                } else if (this.a.getTag().equals("8")) {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsActivity.this.O0;
                    i = a7.e.h;
                } else if (!this.a.getTag().equals("101")) {
                    a(1.15f);
                    b(1.15f);
                    return;
                } else {
                    a(f);
                    b(f);
                    linearLayout = ViewDetailsActivity.this.n;
                }
                i = a7.e.p;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("1")) {
                    linearLayout = ViewDetailsActivity.this.j0;
                } else {
                    if (this.a.getTag().equals("3")) {
                        linearLayout = this.a;
                    } else if (this.a.getTag().equals("5")) {
                        linearLayout = ViewDetailsActivity.this.h0;
                    } else if (this.a.getTag() != null && this.a.getTag().equals("8")) {
                        linearLayout = ViewDetailsActivity.this.O0;
                    } else if (!this.a.getTag().equals("101")) {
                        return;
                    } else {
                        linearLayout = ViewDetailsActivity.this.n;
                    }
                    i = a7.e.o;
                }
                i = a7.e.A1;
            }
            linearLayout.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ void A1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.u2(view);
    }

    public static /* synthetic */ int B1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.n1;
    }

    public static /* synthetic */ void C1(ViewDetailsActivity viewDetailsActivity) {
        viewDetailsActivity.z2();
    }

    public static /* synthetic */ void D1(ViewDetailsActivity viewDetailsActivity) {
        viewDetailsActivity.g2();
    }

    public static /* synthetic */ int E1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.A0;
    }

    public static /* synthetic */ String F1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.C0;
    }

    private void F2(Context context, String str, String str2) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        Resources resources;
        int i2;
        ImageView imageView2;
        int i3;
        this.u0 = new n7.l(this, context);
        this.S0 = new n7.h(this, context);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.A0 = Integer.parseInt(intent.getStringExtra(m7.a.Q));
            } catch (NumberFormatException unused) {
                this.A0 = -1;
            }
            this.B0 = intent.getStringExtra(m7.a.Q);
            this.v0 = intent.getStringExtra("movie");
            this.w0 = intent.getStringExtra("selectedPlayer");
            this.x0 = intent.getStringExtra("streamType");
            this.y0 = intent.getStringExtra("containerExtension");
            this.C0 = intent.getStringExtra("categoryID");
            this.z0 = intent.getStringExtra("num");
            this.Q0 = intent.getStringExtra("movie_icon");
            this.e1 = intent.getStringExtra("movie_director");
            this.f1 = intent.getStringExtra("movie_cast");
            this.g1 = intent.getStringExtra("movie_genre");
            this.h1 = intent.getStringExtra("movie_description");
            this.i1 = intent.getStringExtra("movie_cmd");
            this.j1 = intent.getStringExtra("movie_rating");
            this.l1 = intent.getStringExtra("movie_duration_min");
            this.m1 = intent.getStringExtra("movie_year");
            this.n1 = intent.getIntExtra("movie_fav", 0);
            VodAllCategoriesSingleton.getInstance().setMoviesPoster(this.Q0);
            G2();
            TextView textView3 = this.x;
            if (textView3 != null) {
                textView3.requestFocus();
                this.x.setFocusable(true);
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(context).equals("stalker_api")) {
                if (this.D0.checkFavourite(this.A0, this.C0, "vod", SharepreferenceDBHandler.getUserID(context), this.B0).size() > 0) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        imageView2 = this.G;
                        i3 = a7.e.V;
                        imageView2.setImageResource(i3);
                    } else {
                        imageView = this.G;
                        resources = context.getResources();
                        i2 = a7.e.V;
                        imageView.setImageDrawable(F.h.f(resources, i2, context.getTheme()));
                    }
                } else if (Build.VERSION.SDK_INT <= 21) {
                    imageView2 = this.G;
                    i3 = a7.e.W;
                    imageView2.setImageResource(i3);
                } else {
                    imageView = this.G;
                    resources = context.getResources();
                    i2 = a7.e.W;
                    imageView.setImageDrawable(F.h.f(resources, i2, context.getTheme()));
                }
            }
            ImageView imageView3 = this.G;
            if (imageView3 != null) {
                imageView3.setOnFocusChangeListener(new v(imageView3));
                this.G.setOnClickListener(new r(context));
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
                k2();
                return;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(context).equals("stalker_api")) {
                int i4 = this.A0;
                if (i4 == -1 || i4 == 0) {
                    return;
                }
                this.u0.b(str, str2, i4);
                String U = m7.w.U(context, this.A0, this.y0, "movie");
                this.l = U;
                this.l = m7.w.G(U);
                Log.i("downloadURLIS", "URL:" + this.l);
                return;
            }
            try {
                if (this.n1 == 1) {
                    f2();
                } else {
                    y2();
                }
                String str3 = this.v0;
                if (str3 != null && (textView2 = this.w) != null) {
                    textView2.setText(str3);
                }
                LinearLayout linearLayout = this.Q;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.V;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView4 = this.K;
                if (textView4 != null) {
                    textView4.setText("N/A");
                }
                TextView textView5 = this.C;
                if (textView5 != null) {
                    textView5.setText("N/A");
                }
                TextView textView6 = this.A;
                if (textView6 != null) {
                    textView6.setText("N/A");
                }
                TextView textView7 = this.E;
                if (textView7 != null) {
                    textView7.setText("N/A");
                }
                TextView textView8 = this.I;
                if (textView8 != null) {
                    textView8.setText("N/A");
                }
                TextView textView9 = this.Y;
                if (textView9 != null) {
                    textView9.setVisibility(8);
                }
                TextView textView10 = this.C;
                if (textView10 != null) {
                    textView10.setText("N/A");
                }
                String str4 = this.Q0;
                String str5 = this.e1;
                String str6 = this.f1;
                this.G0 = str6;
                String str7 = this.m1;
                String str8 = this.j1;
                String str9 = this.h1;
                String str10 = this.g1;
                int r0 = m7.w.r0(this.l1);
                this.k1 = r0;
                this.a1 = r0 * 60;
                this.I0 = str10;
                int i5 = r0 * 60;
                if (context == null || str4 == null || str4.isEmpty()) {
                    this.v.setBackgroundResource(a7.e.o1);
                } else {
                    com.squareup.picasso.t.q(context).l(str4).j(a7.e.B1).h(this.v, new s());
                }
                String str11 = this.v0;
                if (str11 != null && (textView = this.w) != null) {
                    textView.setText(str11);
                }
                if (this.P == null || this.U == null || this.E == null || str7 == null || str7.isEmpty() || str7.equals("n/A")) {
                    LinearLayout linearLayout3 = this.P;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    LinearLayout linearLayout4 = this.U;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                    TextView textView11 = this.E;
                    if (textView11 != null) {
                        textView11.setText("N/A");
                    }
                } else {
                    this.P.setVisibility(0);
                    this.U.setVisibility(0);
                    this.E.setText(str7);
                }
                if (this.A == null || this.T == null || this.O == null || str5 == null || str5.isEmpty() || str5.equals("n/A")) {
                    LinearLayout linearLayout5 = this.O;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(0);
                    }
                    LinearLayout linearLayout6 = this.T;
                    if (linearLayout6 != null) {
                        linearLayout6.setVisibility(0);
                    }
                    TextView textView12 = this.A;
                    if (textView12 != null) {
                        textView12.setText("N/A");
                    }
                } else {
                    this.O.setVisibility(0);
                    this.T.setVisibility(0);
                    this.A.setText(str5);
                }
                if (this.S == null || this.X == null || this.C == null || str6 == null || str6.isEmpty()) {
                    LinearLayout linearLayout7 = this.S;
                    if (linearLayout7 != null) {
                        linearLayout7.setVisibility(0);
                    }
                    LinearLayout linearLayout8 = this.X;
                    if (linearLayout8 != null) {
                        linearLayout8.setVisibility(0);
                    }
                    TextView textView13 = this.Y;
                    if (textView13 != null) {
                        textView13.setVisibility(8);
                    }
                    TextView textView14 = this.C;
                    if (textView14 != null) {
                        textView14.setText("N/A");
                    }
                } else {
                    this.S.setVisibility(0);
                    this.X.setVisibility(0);
                    if (str6.length() > 150) {
                        this.C.setText(str6);
                        this.Y.setVisibility(0);
                    } else {
                        this.C.setText(str6);
                        this.Y.setVisibility(8);
                    }
                }
                if (this.F != null && str8 != null && !str8.isEmpty() && !str8.equals("n/A")) {
                    this.F.setVisibility(0);
                    try {
                        this.F.setRating(Float.parseFloat(str8) / 2.0f);
                    } catch (NumberFormatException unused2) {
                        this.F.setRating(0.0f);
                    }
                }
                if (this.y == null || str9 == null || str9.isEmpty() || str9.equals("n/A")) {
                    TextView textView15 = this.y;
                    if (textView15 != null) {
                        textView15.setVisibility(8);
                    }
                } else {
                    this.y.setText(str9);
                }
                if (this.R == null || this.W == null || this.I == null || str10 == null || str10.isEmpty()) {
                    LinearLayout linearLayout9 = this.R;
                    if (linearLayout9 != null) {
                        linearLayout9.setVisibility(0);
                    }
                    LinearLayout linearLayout10 = this.W;
                    if (linearLayout10 != null) {
                        linearLayout10.setVisibility(0);
                    }
                    TextView textView16 = this.I;
                    if (textView16 != null) {
                        textView16.setText("N/A");
                    }
                } else {
                    this.R.setVisibility(0);
                    this.W.setVisibility(0);
                    str10.length();
                    this.I.setText(str10);
                }
                LinearLayout linearLayout11 = this.Q;
                if (linearLayout11 == null || this.V == null || this.K == null) {
                    if (linearLayout11 != null) {
                        linearLayout11.setVisibility(0);
                    }
                    LinearLayout linearLayout12 = this.V;
                    if (linearLayout12 != null) {
                        linearLayout12.setVisibility(0);
                    }
                    TextView textView17 = this.K;
                    if (textView17 != null) {
                        textView17.setText("N/A");
                        return;
                    }
                    return;
                }
                linearLayout11.setVisibility(0);
                this.V.setVisibility(0);
                float f2 = i5;
                int i6 = (int) (f2 / 3600.0f);
                try {
                    int round = Math.round((f2 % 3600.0f) / 60.0f);
                    if (i6 == 0) {
                        this.K.setText(round + "m");
                    } else {
                        this.K.setText(i6 + "h " + round + "m");
                    }
                } catch (Exception unused3) {
                    this.K.setText(i5);
                }
            } catch (Exception unused4) {
            }
        }
    }

    public static /* synthetic */ DatabaseHandler G1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.D0;
    }

    public static /* synthetic */ int H1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.a1;
    }

    public static /* synthetic */ int I1(ViewDetailsActivity viewDetailsActivity, int i2) {
        viewDetailsActivity.a1 = i2;
        return i2;
    }

    public static /* synthetic */ n7.h J1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.S0;
    }

    public static /* synthetic */ String K1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.d1;
    }

    public static /* synthetic */ String L1(ViewDetailsActivity viewDetailsActivity, String str) {
        viewDetailsActivity.d1 = str;
        return str;
    }

    public static /* synthetic */ String M1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.M0;
    }

    public static /* synthetic */ String N1(ViewDetailsActivity viewDetailsActivity, String str) {
        viewDetailsActivity.M0 = str;
        return str;
    }

    public static /* synthetic */ String O1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.v0;
    }

    public static /* synthetic */ ProgressDialog P1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.m0;
    }

    public static /* synthetic */ Boolean Q1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.N0;
    }

    public static /* synthetic */ String R1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.y0;
    }

    public static /* synthetic */ String S1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.x0;
    }

    public static /* synthetic */ String T1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.z0;
    }

    public static /* synthetic */ boolean U1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.d;
    }

    public static /* synthetic */ boolean V1(ViewDetailsActivity viewDetailsActivity, boolean z) {
        viewDetailsActivity.d = z;
        return z;
    }

    public static /* synthetic */ View W1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.e;
    }

    public static /* synthetic */ void X1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.E2(view);
    }

    public static /* synthetic */ DownloadedDBHandler Y1(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.f;
    }

    public static /* synthetic */ void Z1(ViewDetailsActivity viewDetailsActivity) {
        viewDetailsActivity.D2();
    }

    public static /* synthetic */ void a2(ViewDetailsActivity viewDetailsActivity) {
        viewDetailsActivity.f2();
    }

    public static /* synthetic */ void b2(ViewDetailsActivity viewDetailsActivity) {
        viewDetailsActivity.y2();
    }

    public static /* synthetic */ Context c2(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.l0;
    }

    public static /* synthetic */ String d2(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.B0;
    }

    public static /* synthetic */ PopupWindow e2(ViewDetailsActivity viewDetailsActivity) {
        return viewDetailsActivity.E0;
    }

    private void f2() {
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(this.C0);
        favouriteDBModel.setStreamID(this.A0);
        favouriteDBModel.setStreamIDOneStream(this.B0);
        favouriteDBModel.setName(this.v0);
        favouriteDBModel.setNum(this.z0);
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.l0));
        this.D0.addToFavourite(favouriteDBModel, "vod");
        if (Build.VERSION.SDK_INT <= 21) {
            this.G.setImageResource(a7.e.V);
        } else {
            this.G.setImageDrawable(F.h.f(this.l0.getResources(), a7.e.V, this.l0.getTheme()));
        }
    }

    private void g2() {
        m7.w.N0(this.l0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
        try {
            this.p1.e(SharepreferenceDBHandler.getLoggedInMacAddress(this.l0), stalkerToken, (m0.x) null, String.valueOf(this.A0), 0);
        } catch (Exception unused) {
        }
    }

    private void h2() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public static long i2(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String j2(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void m2() {
        this.W0 = findViewById(a7.f.Df);
        this.X0 = findViewById(a7.f.F4);
        this.n = findViewById(a7.f.P7);
        this.q = findViewById(a7.f.kh);
        this.h = findViewById(a7.f.Ki);
        this.i = findViewById(a7.f.Pc);
        this.j = findViewById(a7.f.Qc);
        this.k = findViewById(a7.f.s4);
        this.t = findViewById(a7.f.W);
        this.u = findViewById(a7.f.Nd);
        this.v = findViewById(a7.f.B5);
        this.w = findViewById(a7.f.lk);
        this.x = findViewById(a7.f.Pk);
        this.y = findViewById(a7.f.kk);
        this.z = findViewById(a7.f.Hi);
        this.A = findViewById(a7.f.Ii);
        this.B = findViewById(a7.f.Rh);
        this.C = findViewById(a7.f.Th);
        this.D = findViewById(a7.f.tl);
        this.E = findViewById(a7.f.ul);
        this.F = findViewById(a7.f.bd);
        this.G = findViewById(a7.f.g5);
        this.H = findViewById(a7.f.ik);
        this.I = findViewById(a7.f.zj);
        this.J = findViewById(a7.f.gk);
        this.K = findViewById(a7.f.hk);
        this.L = findViewById(a7.f.R8);
        this.M = findViewById(a7.f.Tf);
        this.N = findViewById(a7.f.Nb);
        this.O = findViewById(a7.f.I7);
        this.P = findViewById(a7.f.H9);
        this.Q = findViewById(a7.f.S7);
        this.R = findViewById(a7.f.r8);
        this.S = findViewById(a7.f.p7);
        this.T = findViewById(a7.f.J7);
        this.U = findViewById(a7.f.I9);
        this.V = findViewById(a7.f.T7);
        this.W = findViewById(a7.f.s8);
        this.X = findViewById(a7.f.q7);
        this.Y = findViewById(a7.f.kl);
        this.Z = findViewById(a7.f.Ga);
        this.e0 = findViewById(a7.f.qm);
        this.f0 = findViewById(a7.f.Xa);
        this.g0 = findViewById(a7.f.vf);
        this.h0 = findViewById(a7.f.Ha);
        this.i0 = findViewById(a7.f.Zb);
        this.j0 = findViewById(a7.f.p9);
    }

    private void n2() {
        this.p0 = new LiveStreamDBHandler(this.l0);
        this.p1 = new n7.e(this, this.l0);
        this.q1 = new n7.g(this, this.l0);
        this.D0 = new DatabaseHandler(this.l0);
        this.T0 = new RecentWatchDBHandler(this.l0);
        this.x.requestFocus();
        this.x.setFocusable(true);
        TextView textView = this.w;
        if (textView != null) {
            textView.setSelected(true);
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("stalker_api")) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.m0 = progressDialog;
            progressDialog.setCanceledOnTouchOutside(false);
            this.m0.setMessage(this.l0.getResources().getString(a7.j.t5));
            this.m0.show();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.n0 = sharedPreferences;
        String string = sharedPreferences.getString("username", "");
        String string2 = this.n0.getString("password", "");
        if (string.isEmpty() || string2.isEmpty()) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else {
            F2(this.l0, string, string2);
        }
        this.f0.setOnClickListener(new p());
        this.X0.setOnClickListener(new q());
    }

    public static /* synthetic */ void p2(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    private /* synthetic */ void q2(View view) {
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("stalker_api")) {
            x2(view);
            return;
        }
        m7.w.N0(this.l0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
        try {
            this.q1.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.l0), stalkerToken, this.i1, "", view, "vod", 0, 0, "", "", "", "", "", "", 0, "", "");
        } catch (Exception unused) {
        }
    }

    private /* synthetic */ void r2(View view) {
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("stalker_api")) {
            x2(view);
            return;
        }
        m7.w.N0(this.l0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
        try {
            this.q1.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.l0), stalkerToken, this.i1, "", view, "vod", 0, 0, "", "", "", "", "", "", 0, "", "");
        } catch (Exception unused) {
        }
    }

    private /* synthetic */ void t2(View view) {
        String str = this.M0;
        if (str == null || str.isEmpty()) {
            w2(this);
        } else {
            startActivity(new Intent(this, YouTubePlayerActivity.class).putExtra("you_tube_trailer", this.M0));
        }
    }

    public static /* synthetic */ void u1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.q2(view);
    }

    private /* synthetic */ void u2(View view) {
        new u().execute(new Void[0]);
        this.e = view;
    }

    public static /* synthetic */ void v1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.s2(view);
    }

    public static /* synthetic */ void w1(ViewDetailsActivity viewDetailsActivity, DialogInterface dialogInterface, int i2) {
        viewDetailsActivity.o2(dialogInterface, i2);
    }

    public static /* synthetic */ void x1(DialogInterface dialogInterface, int i2) {
        p2(dialogInterface, i2);
    }

    public static /* synthetic */ void y1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.t2(view);
    }

    private void y2() {
        this.D0.deleteFavourite(this.A0, this.C0, "vod", this.v0, SharepreferenceDBHandler.getUserID(this.l0), this.B0);
        if (Build.VERSION.SDK_INT <= 21) {
            this.G.setImageResource(a7.e.W);
        } else {
            this.G.setImageDrawable(F.h.f(this.l0.getResources(), a7.e.W, this.l0.getTheme()));
        }
    }

    public static /* synthetic */ void z1(ViewDetailsActivity viewDetailsActivity, View view) {
        viewDetailsActivity.r2(view);
    }

    private void z2() {
        m7.w.N0(this.l0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
        try {
            this.p1.s(SharepreferenceDBHandler.getLoggedInMacAddress(this.l0), stalkerToken, (m0.x) null, String.valueOf(this.A0), 0);
        } catch (Exception unused) {
        }
    }

    public void A2() {
        this.x.setOnClickListener(new s1(this));
        this.v.setOnClickListener(new t1(this));
        this.Y.setOnClickListener(new u1(this));
        this.e0.setOnClickListener(new v1(this));
        this.h.setOnClickListener(new w1(this));
    }

    public void B2(Activity activity) {
        if (activity != null) {
            a.a aVar = new a.a(activity);
            aVar.setTitle("Are you sure want to cancel the downloading?");
            aVar.j("Yes", new m());
            aVar.g("No", new n());
            androidx.appcompat.app.a create = aVar.create();
            this.k0 = create;
            create.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x015f A[Catch: Exception -> 0x01a0, TryCatch #0 {Exception -> 0x01a0, blocks: (B:36:0x0007, B:38:0x000d, B:40:0x001c, B:42:0x0022, B:44:0x002c, B:46:0x0098, B:47:0x00a5, B:48:0x00ba, B:51:0x00c0, B:53:0x00c4, B:54:0x00d6, B:57:0x00dc, B:59:0x00e0, B:62:0x00e6, B:64:0x00ec, B:66:0x00f2, B:67:0x0117, B:70:0x011d, B:72:0x0123, B:74:0x0128, B:76:0x0139, B:77:0x013f, B:80:0x0145, B:82:0x014b, B:84:0x0151, B:86:0x0157, B:31:0x015b, B:89:0x0102, B:91:0x0106, B:92:0x0109, B:94:0x010d, B:95:0x0110, B:97:0x0114, B:98:0x00ac, B:3:0x015f, B:5:0x0163, B:7:0x0167, B:8:0x016a, B:10:0x016e, B:11:0x0171, B:13:0x0175, B:14:0x0178, B:16:0x017c, B:17:0x017f, B:19:0x0183, B:20:0x0186, B:22:0x018a, B:23:0x018d, B:25:0x0191, B:26:0x0194, B:28:0x0198, B:29:0x019b), top: B:35:0x0007, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback r9) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.C(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBMoviesCallback):void");
    }

    /* renamed from: C2, reason: merged with bridge method [inline-methods] */
    public final void s2(ViewDetailsActivity viewDetailsActivity) {
        View inflate = ((LayoutInflater) viewDetailsActivity.getSystemService("layout_inflater")).inflate(a7.g.g3, viewDetailsActivity.findViewById(a7.f.We));
        TextView findViewById = inflate.findViewById(a7.f.Wh);
        this.J0 = findViewById;
        findViewById.setText(this.G0);
        PopupWindow popupWindow = new PopupWindow(viewDetailsActivity);
        this.E0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.E0.setWidth(-1);
        this.E0.setHeight(-1);
        this.E0.setFocusable(true);
        this.E0.showAtLocation(inflate, 17, 0, 0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        this.F0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new v(findViewById2));
        }
        this.F0.setOnClickListener(new o());
    }

    public void D0(String str) {
    }

    public final void D2() {
        Toast.makeText(getApplicationContext(), "please check your internet connection!", 0).show();
    }

    public void E0(String str) {
        TextView textView;
        try {
            this.G0 = "";
            this.I0 = "";
            String str2 = this.v0;
            if (str2 != null && (textView = this.w) != null) {
                textView.setText(str2);
            }
            LinearLayout linearLayout = this.P;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.U;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView2 = this.E;
            if (textView2 != null) {
                textView2.setText("N/A");
            }
            TextView textView3 = this.A;
            LinearLayout linearLayout3 = this.O;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = this.T;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            TextView textView4 = this.A;
            if (textView4 != null) {
                textView4.setText("N/A");
            }
            LinearLayout linearLayout5 = this.S;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            LinearLayout linearLayout6 = this.X;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            TextView textView5 = this.Y;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.C;
            if (textView6 != null) {
                textView6.setText("N/A");
            }
            TextView textView7 = this.y;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            LinearLayout linearLayout7 = this.R;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            LinearLayout linearLayout8 = this.W;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            TextView textView8 = this.I;
            if (textView8 != null) {
                textView8.setText("N/A");
            }
            LinearLayout linearLayout9 = this.Q;
            if (linearLayout9 == null || this.V == null || this.K == null) {
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
                LinearLayout linearLayout10 = this.V;
                if (linearLayout10 != null) {
                    linearLayout10.setVisibility(0);
                }
                TextView textView9 = this.K;
                if (textView9 != null) {
                    textView9.setText("N/A");
                    return;
                }
                return;
            }
            linearLayout9.setVisibility(0);
            this.V.setVisibility(0);
            float f2 = 0;
            int i2 = (int) (f2 / 3600.0f);
            try {
                int round = Math.round((f2 % 3600.0f) / 60.0f);
                if (i2 == 0) {
                    this.K.setText(round + "m");
                } else {
                    this.K.setText(i2 + "h " + round + "m");
                }
            } catch (Exception unused) {
                this.K.setText(0);
            }
        } catch (Exception unused2) {
        }
    }

    public final void E2(View view) {
        PopupMenu popupMenu = new PopupMenu(this.l0, view);
        popupMenu.getMenuInflater().inflate(a7.h.c, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new l());
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void G2() {
        /*
            r6 = this;
            android.content.Context r0 = r6.l0
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r0)
            java.lang.String r1 = "onestream_api"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L17
            com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler r0 = r6.T0
            java.lang.String r1 = r6.B0
            java.util.ArrayList r0 = r0.getRecentWatchedByStreamIDOneStream(r1)
            goto L1f
        L17:
            com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler r0 = r6.T0
            int r1 = r6.A0
            java.util.ArrayList r0 = r0.getRecentWatchedByStreamID(r1)
        L1f:
            r1 = 8
            if (r0 == 0) goto L9b
            int r2 = r0.size()
            if (r2 <= 0) goto L9b
            android.widget.TextView r2 = r6.x
            if (r2 == 0) goto La2
            android.content.res.Resources r3 = r6.getResources()
            int r4 = a7.j.l6
            java.lang.String r3 = r3.getString(r4)
            r2.setText(r3)
            r2 = 0
            java.lang.Object r3 = r0.get(r2)
            com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel r3 = (com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel) r3
            long r3 = r3.getMovieElapsedTime()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object r0 = r0.get(r2)
            com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel r0 = (com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel) r0
            long r4 = r0.getMovieDuraton()
            java.lang.String r0 = java.lang.String.valueOf(r4)
            android.widget.ProgressBar r4 = r6.i0
            if (r4 == 0) goto La2
            int r3 = m7.w.r0(r3)     // Catch: java.lang.Exception -> L6e
            float r4 = (float) r3     // Catch: java.lang.Exception -> L6e
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r4 = r4 / r5
            int r4 = java.lang.Math.round(r4)     // Catch: java.lang.Exception -> L6e
            r6.c1 = r3     // Catch: java.lang.Exception -> L6f
            int r0 = m7.w.r0(r0)     // Catch: java.lang.Exception -> L6f
            goto L70
        L6e:
            r4 = 0
        L6f:
            r0 = 0
        L70:
            float r3 = (float) r4
            float r0 = (float) r0
            float r3 = r3 / r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r0
            int r0 = java.lang.Math.round(r3)     // Catch: java.lang.Exception -> L7c
            goto L7e
        L7c:
            r0 = 0
        L7e:
            if (r0 == 0) goto L8b
            android.widget.ProgressBar r1 = r6.i0
            r1.setProgress(r0)
            android.widget.ProgressBar r0 = r6.i0
            r0.setVisibility(r2)
            goto La2
        L8b:
            android.widget.ProgressBar r2 = r6.i0
            int r2 = r2.getVisibility()
            if (r2 != 0) goto La2
            android.widget.ProgressBar r2 = r6.i0
            r2.setProgress(r0)
            android.widget.ProgressBar r0 = r6.i0
            goto L9f
        L9b:
            android.widget.ProgressBar r0 = r6.i0
            if (r0 == 0) goto La2
        L9f:
            r0.setVisibility(r1)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.G2():void");
    }

    public void H(String str) {
    }

    public void I(m0.x xVar, int i2) {
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.l0);
            this.r1 = "remove";
            this.p1.f(loggedInMacAddress, stalkerToken, i2);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0329 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0330 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b3 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b7 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02be A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c5 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0282 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0286 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0224 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0228 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x022f A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0236 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x023d A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01d3 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01d7 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01de A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01e5 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0194 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0198 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x019f A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01a6 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0156 A[Catch: Exception -> 0x0383, TryCatch #2 {Exception -> 0x0383, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:9:0x0016, B:11:0x001c, B:14:0x0085, B:16:0x0089, B:17:0x008e, B:20:0x009c, B:22:0x00a2, B:24:0x00bb, B:25:0x00cd, B:27:0x00d9, B:29:0x00e7, B:31:0x00f3, B:33:0x00f9, B:35:0x00fd, B:36:0x0100, B:38:0x0104, B:39:0x0123, B:42:0x0135, B:44:0x013b, B:45:0x015d, B:47:0x0161, B:49:0x0165, B:50:0x0168, B:53:0x016e, B:55:0x0172, B:58:0x0178, B:60:0x017e, B:62:0x0184, B:63:0x01a9, B:65:0x01ad, B:67:0x01b1, B:70:0x01b7, B:72:0x01bd, B:74:0x01c3, B:75:0x01e8, B:77:0x01ec, B:79:0x01f0, B:82:0x01f6, B:84:0x01fc, B:86:0x020e, B:87:0x0240, B:90:0x0246, B:92:0x024c, B:94:0x0252, B:96:0x0257, B:98:0x0264, B:99:0x026a, B:102:0x0270, B:104:0x0276, B:106:0x027c, B:107:0x0289, B:109:0x028d, B:111:0x0291, B:114:0x0297, B:116:0x029d, B:117:0x02c8, B:119:0x02cc, B:121:0x02d0, B:123:0x02d4, B:135:0x0321, B:138:0x0329, B:139:0x032c, B:141:0x0330, B:142:0x0333, B:144:0x0337, B:147:0x02b3, B:149:0x02b7, B:150:0x02ba, B:152:0x02be, B:153:0x02c1, B:155:0x02c5, B:156:0x0282, B:158:0x0286, B:159:0x0219, B:160:0x0224, B:162:0x0228, B:163:0x022b, B:165:0x022f, B:166:0x0232, B:168:0x0236, B:169:0x0239, B:171:0x023d, B:172:0x01d3, B:174:0x01d7, B:175:0x01da, B:177:0x01de, B:178:0x01e1, B:180:0x01e5, B:181:0x0194, B:183:0x0198, B:184:0x019b, B:186:0x019f, B:187:0x01a2, B:189:0x01a6, B:190:0x0156, B:191:0x0108, B:193:0x010c, B:194:0x010f, B:196:0x0113, B:197:0x0117, B:199:0x011b, B:200:0x011e, B:204:0x0083, B:205:0x033b, B:207:0x033f, B:209:0x0343, B:210:0x0346, B:212:0x034a, B:213:0x034d, B:215:0x0351, B:216:0x0354, B:218:0x0358, B:219:0x035b, B:221:0x035f, B:222:0x0362, B:224:0x0366, B:225:0x0369, B:227:0x036d, B:228:0x0370, B:230:0x0374, B:231:0x0377, B:233:0x037b, B:234:0x037e, B:13:0x006e, B:126:0x02e6, B:129:0x02ee, B:134:0x0304), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K(com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback r14) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.K(com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback):void");
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        ImageView imageView;
        Drawable drawable;
        try {
            m7.w.X();
            String str = this.r1;
            if (str == null || !str.equals("add")) {
                this.n1 = 0;
                if (Build.VERSION.SDK_INT <= 21) {
                    this.G.setImageResource(a7.e.W);
                }
                imageView = this.G;
                drawable = this.l0.getResources().getDrawable(a7.e.W, (Resources.Theme) null);
            } else {
                this.n1 = 1;
                if (Build.VERSION.SDK_INT <= 21) {
                    this.G.setImageResource(a7.e.V);
                }
                imageView = this.G;
                drawable = this.l0.getResources().getDrawable(a7.e.V, (Resources.Theme) null);
            }
            imageView.setImageDrawable(drawable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void P(String str) {
    }

    public void P0(String str) {
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:2:0x0042 A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #0 {Exception -> 0x0049, blocks: (B:10:0x0002, B:12:0x0008, B:14:0x0012, B:2:0x0042), top: B:9:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void U0(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L42
            java.util.List r0 = r6.getCast()     // Catch: java.lang.Exception -> L49
            if (r0 == 0) goto L42
            java.util.List r0 = r6.getCast()     // Catch: java.lang.Exception -> L49
            int r0 = r0.size()     // Catch: java.lang.Exception -> L49
            if (r0 <= 0) goto L42
            androidx.recyclerview.widget.RecyclerView r0 = r5.W0     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch: java.lang.Exception -> L49
            r2 = 0
            r1.<init>(r5, r2, r2)     // Catch: java.lang.Exception -> L49
            r0.setLayoutManager(r1)     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r0 = r5.W0     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.c r1 = new androidx.recyclerview.widget.c     // Catch: java.lang.Exception -> L49
            r1.<init>()     // Catch: java.lang.Exception -> L49
            r0.setItemAnimator(r1)     // Catch: java.lang.Exception -> L49
            q7.f r0 = new q7.f     // Catch: java.lang.Exception -> L49
            java.util.List r6 = r6.getCast()     // Catch: java.lang.Exception -> L49
            android.content.Context r1 = r5.l0     // Catch: java.lang.Exception -> L49
            java.lang.String r3 = r5.d1     // Catch: java.lang.Exception -> L49
            r4 = 1
            r0.<init>(r6, r1, r4, r3)     // Catch: java.lang.Exception -> L49
            r5.Y0 = r0     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r6 = r5.W0     // Catch: java.lang.Exception -> L49
            r6.setAdapter(r0)     // Catch: java.lang.Exception -> L49
            androidx.recyclerview.widget.RecyclerView r6 = r5.W0     // Catch: java.lang.Exception -> L49
            r6.setVisibility(r2)     // Catch: java.lang.Exception -> L49
            goto L49
        L42:
            androidx.recyclerview.widget.RecyclerView r6 = r5.W0     // Catch: java.lang.Exception -> L49
            r0 = 8
            r6.setVisibility(r0)     // Catch: java.lang.Exception -> L49
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.U0(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback):void");
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i2) {
        if (stalkerSetLiveFavCallback != null) {
            try {
                if (stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                    return;
                }
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.l0);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.l0);
                this.r1 = "add";
                this.p1.f(loggedInMacAddress, stalkerToken, 0);
            } catch (Exception unused) {
                m7.w.X();
            }
        }
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
    }

    public void X0(TMDBTrailerCallback tMDBTrailerCallback) {
        if (tMDBTrailerCallback != null) {
            try {
                if (tMDBTrailerCallback.getResults() == null || tMDBTrailerCallback.getResults().size() <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < tMDBTrailerCallback.getResults().size(); i2++) {
                    if (((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i2)).getType().equals("Trailer")) {
                        this.M0 = ((TMDBTrailerPojo) tMDBTrailerCallback.getResults().get(i2)).getKey();
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
    }

    public void b() {
    }

    public void c(String str) {
    }

    public void d(String str) {
        try {
            ProgressDialog progressDialog = this.m0;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.m0.dismiss();
            Toast.makeText(this, this.l0.getResources().getString(a7.j.e7), 1).show();
        } catch (Exception unused) {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0097 A[Catch: Exception -> 0x0151, TryCatch #2 {Exception -> 0x0151, blocks: (B:63:0x0005, B:65:0x000b, B:68:0x0018, B:70:0x0022, B:72:0x004d, B:74:0x005d, B:76:0x0061, B:78:0x0065, B:80:0x006b, B:14:0x00ac, B:47:0x013c, B:49:0x0140, B:50:0x0143, B:52:0x0147, B:53:0x014a, B:55:0x014e, B:81:0x0081, B:83:0x0085, B:84:0x0088, B:86:0x008c, B:87:0x008f, B:12:0x0093, B:3:0x0097, B:5:0x009b, B:6:0x009e, B:8:0x00a2, B:9:0x00a5, B:17:0x00b2, B:19:0x00c9, B:21:0x00cd, B:23:0x00d1, B:35:0x0122, B:38:0x012a, B:39:0x012d, B:41:0x0131, B:42:0x0134, B:44:0x0138, B:26:0x00e8, B:29:0x00f0, B:34:0x0105), top: B:62:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g0(com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback r8) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.g0(com.nst.iptvsmarterstvbox.model.callback.TMDBGenreCallback):void");
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public final void k2() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.A0 = Integer.parseInt(intent.getStringExtra(m7.a.Q));
            } catch (NumberFormatException unused) {
                this.A0 = -1;
            }
            this.B0 = intent.getStringExtra(m7.a.Q);
            Log.i("streamIDIS", "idIS:" + this.B0);
            this.v0 = intent.getStringExtra("movie");
            this.w0 = intent.getStringExtra("selectedPlayer");
            this.x0 = intent.getStringExtra("streamType");
            this.y0 = intent.getStringExtra("containerExtension");
            this.C0 = intent.getStringExtra("categoryID");
            this.z0 = intent.getStringExtra("num");
            this.Q0 = intent.getStringExtra("movie_icon");
            this.R0 = intent.getStringExtra("videoURL");
            this.w.setText(this.v0);
            com.squareup.picasso.t.q(this.l0).l(this.Q0).j(a7.e.B1).g(this.v);
            VodAllCategoriesSingleton.getInstance().setMoviesPoster(this.Q0);
            this.l = this.R0;
            this.m = this.Q0;
            Log.i("downloadURLIS", "URL:" + this.l);
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setOnFocusChangeListener(new v(imageView));
            this.G.setOnClickListener(new t());
        }
        String oneStreamToken = SharepreferenceDBHandler.getOneStreamToken(this.l0);
        String string = this.l0.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "");
        if (SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("onestream_api")) {
            String str = this.B0;
            Log.e("checkstream", str);
            j1.a.a(string + "play/b2c/v1/content/vod/" + str + "?token=" + oneStreamToken).s(k1.e.MEDIUM).q().o(new a());
        }
    }

    public void l2() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public void o0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void o2(DialogInterface dialogInterface, int i2) {
        m7.w.n0(this.l0);
        finishAffinity();
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        m7.a.m0 = true;
        m7.a.n0 = this.n1;
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.q.x(a7.h.v);
        this.L0 = menu;
        this.K0 = menu.getItem(1).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("api")) {
            menu.getItem(1).getSubMenu().findItem(a7.f.fb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.q.getChildCount(); i2++) {
            if (this.q.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.q.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        PopupWindow popupWindow = this.E0;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.E0.dismiss();
        }
        super.onDestroy();
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.L0;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.K0 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.l0) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new q1(this)).g(getResources().getString(a7.j.d4), new r1()).n();
        }
        if (itemId == a7.f.fb) {
            m7.w.A0(this.l0);
            if (itemId == a7.f.hb) {
                a.a aVar = new a.a(this);
                aVar.setTitle(this.l0.getResources().getString(a7.j.u0));
                aVar.f(this.l0.getResources().getString(a7.j.T0));
                aVar.d(a7.e.s1);
                aVar.j(this.l0.getResources().getString(a7.j.S8), new b());
                aVar.g(this.l0.getResources().getString(a7.j.d4), new c());
                aVar.n();
            }
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        l2();
        super/*androidx.fragment.app.e*/.onResume();
        m7.w.m(this.l0);
        m7.w.z0(this.l0);
        if (!this.b1) {
            G2();
            v2();
        }
        this.b1 = false;
        getWindow().setFlags(1024, 1024);
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        l2();
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x00c5 A[Catch: Exception -> 0x0186, TryCatch #0 {Exception -> 0x0186, blocks: (B:77:0x0009, B:79:0x000f, B:81:0x0019, B:84:0x0021, B:86:0x0027, B:88:0x0048, B:90:0x0058, B:92:0x005c, B:94:0x0060, B:96:0x0066, B:98:0x0078, B:17:0x00e1, B:19:0x00e7, B:21:0x00f1, B:24:0x00f8, B:26:0x00fe, B:30:0x0110, B:28:0x011b, B:31:0x011e, B:33:0x0122, B:35:0x0126, B:38:0x012c, B:40:0x0132, B:42:0x013a, B:45:0x014a, B:47:0x014e, B:48:0x0151, B:50:0x0155, B:51:0x0158, B:53:0x015c, B:57:0x0160, B:59:0x0164, B:60:0x0167, B:62:0x016b, B:63:0x016e, B:67:0x0173, B:69:0x0177, B:70:0x017a, B:72:0x017e, B:73:0x0181, B:99:0x0083, B:100:0x008e, B:102:0x0092, B:103:0x0095, B:105:0x0099, B:106:0x009c, B:108:0x00a0, B:109:0x00a3, B:15:0x00a7, B:111:0x00ab, B:113:0x00af, B:114:0x00b2, B:116:0x00b6, B:117:0x00b9, B:119:0x00bd, B:120:0x00c0, B:3:0x00c5, B:5:0x00c9, B:6:0x00cc, B:8:0x00d0, B:9:0x00d3, B:11:0x00d7, B:12:0x00da), top: B:76:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback r9) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity.s(com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback):void");
    }

    public void t(TMDBPersonInfoCallback tMDBPersonInfoCallback) {
    }

    public void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8) {
        try {
            m7.w.X();
            if (stalkerCreatePlayerLinkCallback == null || stalkerCreatePlayerLinkCallback.getJs() == null || stalkerCreatePlayerLinkCallback.getJs().getCmd() == null || stalkerCreatePlayerLinkCallback.getJs().getId() == null) {
                return;
            }
            this.U0 = stalkerCreatePlayerLinkCallback.getJs().getCmd();
            x2(view);
        } catch (Exception unused) {
        }
    }

    public void v0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public final void v2() {
        TextView textView;
        Resources resources;
        int i2;
        String str;
        int moviePercentage;
        this.f = new DownloadedDBHandler(this.l0);
        this.g = new ArrayList();
        ArrayList downloadedData = this.f.getDownloadedData();
        this.g = downloadedData;
        try {
            if (downloadedData.size() > 0) {
                for (int i3 = 0; i3 < this.g.size(); i3++) {
                    if (((DownloadedDataModel) this.g.get(i3)).getMovieURL().equals(this.l)) {
                        Log.i("movieState", ((DownloadedDataModel) this.g.get(i3)).getMovieState());
                        if (((DownloadedDataModel) this.g.get(i3)).getMovieState().equals("Downloading")) {
                            this.i.setVisibility(0);
                            this.h.setText(this.l0.getResources().getString(a7.j.h1).concat(".."));
                            moviePercentage = ((DownloadedDataModel) this.g.get(i3)).getMoviePercentage();
                        } else if (((DownloadedDataModel) this.g.get(i3)).getMovieState().equals("Paused")) {
                            this.i.setVisibility(0);
                            this.h.setText(this.l0.getResources().getString(a7.j.b5));
                            moviePercentage = ((DownloadedDataModel) this.g.get(i3)).getMoviePercentage();
                        } else {
                            if (((DownloadedDataModel) this.g.get(i3)).getMovieState().equals("Completed")) {
                                this.i.setVisibility(8);
                                this.h.setText(this.l0.getResources().getString(a7.j.g1));
                                this.k.setVisibility(0);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams.setMargins(10, 0, 0, 0);
                                this.h.setLayoutParams(layoutParams);
                                return;
                            }
                            if (!((DownloadedDataModel) this.g.get(i3)).getMovieState().equals("Failed")) {
                                if (((DownloadedDataModel) this.g.get(i3)).getMovieState().equals("Waiting")) {
                                    this.i.setVisibility(0);
                                    this.i.setProgress(((DownloadedDataModel) this.g.get(i3)).getMoviePercentage());
                                    textView = this.h;
                                    str = "Waiting..";
                                    textView.setText(str);
                                }
                                return;
                            }
                            this.i.setVisibility(0);
                            this.i.setProgress(((DownloadedDataModel) this.g.get(i3)).getMoviePercentage());
                            textView = this.h;
                            resources = this.l0.getResources();
                            i2 = a7.j.i1;
                        }
                        this.i.setProgress(moviePercentage);
                        return;
                    }
                }
                return;
            }
            this.i.setVisibility(8);
            textView = this.h;
            resources = this.l0.getResources();
            i2 = a7.j.U0;
            str = resources.getString(i2);
            textView.setText(str);
        } catch (Exception unused) {
        }
    }

    public final void w2(ViewDetailsActivity viewDetailsActivity) {
        View inflate = ((LayoutInflater) viewDetailsActivity.getSystemService("layout_inflater")).inflate(a7.g.l3, viewDetailsActivity.findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(viewDetailsActivity);
        this.E0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.E0.setWidth(-1);
        this.E0.setHeight(-1);
        this.E0.setFocusable(true);
        this.E0.setBackgroundDrawable(new BitmapDrawable());
        this.E0.showAtLocation(inflate, 17, 0, 0);
        this.O0 = inflate.findViewById(a7.f.H0);
        this.F0 = inflate.findViewById(a7.f.o0);
        Button button = this.O0;
        if (button != null) {
            button.setOnFocusChangeListener(new v(button));
        }
        Button button2 = this.F0;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new v(button2));
        }
        this.F0.setOnClickListener(new i());
        this.O0.setOnClickListener(new j());
    }

    public final void x2(View view) {
        Context context;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SharedPreferences sharedPreferences = this.l0.getSharedPreferences("selectedPlayer", 0);
        this.o0 = sharedPreferences;
        String str11 = "";
        String string = sharedPreferences.getString("selectedPlayer", "");
        SimpleDateFormat simpleDateFormat = this.o1;
        if (i2(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.l0))), this.H0.format(this.s1)) >= w7.c.p() && (str9 = this.r) != null && this.s != null && (!x1.equals(str9) || (this.r != null && (str10 = this.s) != null && !y1.equals(str10)))) {
            this.N0 = Boolean.FALSE;
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("stalker_api")) {
            if (!this.N0.booleanValue()) {
                return;
            }
            context = this.l0;
            i2 = this.A0;
            str = this.x0;
            str2 = this.y0;
            str3 = this.z0;
            str4 = this.v0;
            str5 = this.U0;
            i3 = this.a1;
            str7 = this.p;
            str8 = "";
            str6 = "";
        } else {
            if (!this.N0.booleanValue()) {
                return;
            }
            try {
                if (this.Z0.equals("mobile")) {
                    try {
                        this.P0 = o4.b.e(this.l0).c().c();
                    } catch (Exception unused) {
                    }
                }
                o4.e eVar = this.P0;
                if (eVar != null && eVar.c()) {
                    String G = m7.w.G(SharepreferenceDBHandler.getCurrentAPPType(this.l0).equals("onestream_api") ? this.R0 : m7.w.U(this.l0, this.A0, this.y0, "movie"));
                    o4.e eVar2 = this.P0;
                    if (eVar2 != null && eVar2.r() != null && this.P0.r().j() != null && this.P0.r().j().J() != null) {
                        str11 = this.P0.r().j().J();
                    }
                    if (str11.equals(G)) {
                        this.l0.startActivity(new Intent(this.l0, ExpandedControlsActivity.class));
                        return;
                    } else {
                        i7.a.c(this.c1, true, i7.a.a(this.v0, "", "", 0, G, "videos/mp4", this.Q0, "", (List) null), this.P0, this.l0);
                        return;
                    }
                }
                new ArrayList();
                ArrayList arrayList = new ArrayList();
                U u2 = new U(this, view);
                u2.c().inflate(a7.h.m, u2.b());
                ArrayList externalPlayer = new ExternalPlayerDataBase(this.l0).getExternalPlayer();
                if (externalPlayer != null) {
                    try {
                        if (externalPlayer.size() > 0) {
                            u2.b().add(0, 0, 0, this.l0.getResources().getString(a7.j.V3));
                            ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                            externalPlayerModelClass.setId(0);
                            externalPlayerModelClass.setAppname(this.l0.getResources().getString(a7.j.h5));
                            arrayList.add(externalPlayerModelClass);
                            int i4 = 0;
                            while (i4 < externalPlayer.size()) {
                                int i5 = i4 + 1;
                                u2.b().add(0, i5, 0, this.l0.getResources().getString(a7.j.h5) + " " + ((ExternalPlayerModelClass) externalPlayer.get(i4)).getAppname());
                                arrayList.add((ExternalPlayerModelClass) externalPlayer.get(i4));
                                i4 = i5;
                            }
                            u2.f(new g(arrayList, string));
                            u2.e(new h());
                            u2.g();
                            return;
                        }
                    } catch (Exception unused2) {
                        return;
                    }
                }
                Log.e("tagelapsed", String.valueOf(this.a1));
                m7.w.w0(this.l0, string, this.A0, this.x0, this.y0, this.z0, this.v0, this.U0, this.a1, this.B0, this.p, "");
                return;
            } catch (Exception unused3) {
                context = this.l0;
                i2 = this.A0;
                str = this.x0;
                str2 = this.y0;
                str3 = this.z0;
                str4 = this.v0;
                str5 = this.U0;
                i3 = this.a1;
                str6 = this.B0;
                str7 = this.p;
                str8 = "";
            }
        }
        m7.w.w0(context, string, i2, str, str2, str3, str4, str5, i3, str6, str7, str8);
    }

    public void y0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public class h implements U.c {
        public h() {
        }

        public void a(U u) {
        }
    }

    public void O(Z.E e2, int i2) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
