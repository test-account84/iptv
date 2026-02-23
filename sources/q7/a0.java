package q7;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import k.U;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a0 extends RecyclerView.g {
    public static SharedPreferences s;
    public final int d;
    public final String e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public String j;
    public final String k;
    public final String l;
    public final String m;
    public Context n;
    public ArrayList o;
    public SharedPreferences p;
    public String q = new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(new Date());
    public String r = "";

    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public a(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void onClick(View view) {
            if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
                a0.this.l0(view, this.a, this.c);
                return;
            }
            if (SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) >= m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(0, a0.j0(a0.this));
            } else {
                if (SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) != 0 || !SharepreferenceDBHandler.getFirstTimeAdsShow(a0.j0(a0.this))) {
                    a0.this.l0(view, this.a, this.c);
                    SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) + 1, a0.j0(a0.this));
                    return;
                }
                SharepreferenceDBHandler.setFirstTimeAdsShow(false, a0.j0(a0.this));
            }
            a0.k0(a0.this, view, this.a, this.c);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public b(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void onClick(View view) {
            if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
                a0.this.l0(view, this.a, this.c);
                return;
            }
            if (SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) >= m7.a.f1) {
                SharepreferenceDBHandler.setEventAdsView(0, a0.j0(a0.this));
            } else {
                if (SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) != 0 || !SharepreferenceDBHandler.getFirstTimeAdsShow(a0.j0(a0.this))) {
                    a0.this.l0(view, this.a, this.c);
                    SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(a0.j0(a0.this)) + 1, a0.j0(a0.this));
                    return;
                }
                SharepreferenceDBHandler.setFirstTimeAdsShow(false, a0.j0(a0.this));
            }
            a0.k0(a0.this, view, this.a, this.c);
        }
    }

    public class c implements U.d {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(ArrayList arrayList, Context context, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.a = arrayList;
            this.b = context;
            this.c = str;
            this.d = i;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
            this.l = str9;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                ArrayList arrayList = this.a;
                if (arrayList != null && arrayList.size() > 0) {
                    int i = 0;
                    while (true) {
                        if (i < this.a.size()) {
                            if (menuItem.getItemId() != i) {
                                i++;
                            } else if (menuItem.getItemId() == 0) {
                                m7.w.u0(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
                            } else {
                                String T = m7.w.T(this.b, this.d, this.i, this.k);
                                Intent intent = new Intent(this.b, PlayExternalPlayerActivity.class);
                                intent.putExtra("url", T);
                                intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                                intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                                this.b.startActivity(intent);
                            }
                        }
                    }
                }
                break;
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ Dialog d;

        public e(String str, String str2, Dialog dialog) {
            this.a = str;
            this.c = str2;
            this.d = dialog;
        }

        public void onClick(View view) {
            a0.this.l0(view, this.a, this.c);
            this.d.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ Dialog d;

        public f(String str, String str2, Dialog dialog) {
            this.a = str;
            this.c = str2;
            this.d = dialog;
        }

        public void onClick(View view) {
            a0.this.l0(view, this.a, this.c);
            this.d.dismiss();
        }
    }

    public class g implements View.OnFocusChangeListener {
        public View a;

        public g(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                this.a.getTag().equals("iv_cross");
                return;
            }
            View view3 = this.a;
            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                return;
            }
            view.setBackground(a0.j0(a0.this).getResources().getDrawable(a7.e.L));
        }
    }

    public static class h extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public TextView v;
        public RelativeLayout w;
        public LinearLayout x;

        public h(View view) {
            super(view);
            this.t = view.findViewById(a7.f.zi);
            this.u = view.findViewById(a7.f.ei);
            this.v = view.findViewById(a7.f.Ek);
            this.w = view.findViewById(a7.f.Rd);
            this.x = view.findViewById(a7.f.K8);
        }
    }

    public a0(ArrayList arrayList, int i, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context) {
        this.o = arrayList;
        this.n = context;
        this.d = i;
        this.e = str;
        this.f = z;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.k = str5;
        this.l = str6;
        this.m = str7;
        this.j = str8;
    }

    public static /* synthetic */ Context j0(a0 a0Var) {
        return a0Var.n;
    }

    public static /* synthetic */ void k0(a0 a0Var, View view, String str, String str2) {
        a0Var.n0(view, str, str2);
    }

    private long m0(String str, String str2) {
        long j;
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        new Date(System.currentTimeMillis());
        new SimpleDateFormat("yyyy-MM-dd", locale);
        try {
            j = simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            j = -1;
        }
        return (j / 1000) / 60;
    }

    public void l0(View view, String str, String str2) {
        int i;
        try {
            i = Integer.parseInt(this.g);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        r0(view, this.n, this.r, i, this.h, this.i, this.l, this.k, str, this.m, str2, "url");
    }

    public int n() {
        return this.o.size();
    }

    public final void n0(View view, String str, String str2) {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            l0(view, str, str2);
            return;
        }
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this.n, a7.k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        LinearLayout findViewById3 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new e(str, str2, dialog));
        findViewById3.setOnClickListener(new f(str, str2, dialog));
        findViewById2.setOnFocusChangeListener(new g(findViewById2));
        findViewById2.setOnFocusChangeListener(new g(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        com.squareup.picasso.t.q(this.n).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        com.squareup.picasso.t.q(this.n).l((String) a2.get(0)).g(findViewById);
                        m7.a.k1 = 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        findViewById2.requestFocus();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(2:7|8)|(2:10|11)|12|13|15|16|17|(1:32)(2:21|(1:31)(1:25))|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
    
        r3.printStackTrace();
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r7 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0114 A[Catch: Exception -> 0x0160, TryCatch #1 {Exception -> 0x0160, blocks: (B:3:0x000e, B:5:0x0012, B:17:0x0066, B:19:0x0114, B:21:0x011c, B:23:0x0120, B:25:0x0124, B:26:0x012e, B:27:0x014c, B:31:0x0136, B:32:0x0141, B:35:0x0062, B:40:0x004b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0141 A[Catch: Exception -> 0x0160, TryCatch #1 {Exception -> 0x0160, blocks: (B:3:0x000e, B:5:0x0012, B:17:0x0066, B:19:0x0114, B:21:0x011c, B:23:0x0120, B:25:0x0124, B:26:0x012e, B:27:0x014c, B:31:0x0136, B:32:0x0141, B:35:0x0062, B:40:0x004b), top: B:2:0x000e }] */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(q7.a0.h r12, int r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.a0.E(q7.a0$h, int):void");
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public h L(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.B3, viewGroup, false);
        if (inflate != null) {
            inflate.setFocusable(true);
        }
        return new h(inflate);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x00d0 A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d5, blocks: (B:19:0x00c6, B:4:0x00d0), top: B:2:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r0(android.view.View r17, android.content.Context r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            r16 = this;
            r3 = r18
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            k.U r14 = new k.U
            r0 = r17
            r14.<init>(r3, r0)
            android.view.MenuInflater r0 = r14.c()
            int r1 = a7.h.m
            android.view.Menu r4 = r14.b()
            r0.inflate(r1, r4)
            com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase r0 = new com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase
            r0.<init>(r3)
            java.util.ArrayList r0 = r0.getExternalPlayer()
            if (r0 == 0) goto Ld0
            int r1 = r0.size()     // Catch: java.lang.Exception -> L9e
            if (r1 <= 0) goto Ld0
            android.view.Menu r1 = r14.b()     // Catch: java.lang.Exception -> L9e
            android.content.res.Resources r4 = r18.getResources()     // Catch: java.lang.Exception -> L9e
            int r5 = a7.j.V3     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = r4.getString(r5)     // Catch: java.lang.Exception -> L9e
            r5 = 0
            r1.add(r5, r5, r5, r4)     // Catch: java.lang.Exception -> L9e
            com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass r1 = new com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass     // Catch: java.lang.Exception -> L9e
            r1.<init>()     // Catch: java.lang.Exception -> L9e
            r1.setId(r5)     // Catch: java.lang.Exception -> L9e
            android.content.res.Resources r4 = r18.getResources()     // Catch: java.lang.Exception -> L9e
            int r6 = a7.j.h5     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = r4.getString(r6)     // Catch: java.lang.Exception -> L9e
            r1.setAppname(r4)     // Catch: java.lang.Exception -> L9e
            r2.add(r1)     // Catch: java.lang.Exception -> L9e
            r1 = 0
        L5c:
            int r4 = r0.size()     // Catch: java.lang.Exception -> L9e
            if (r1 >= r4) goto La1
            android.view.Menu r4 = r14.b()     // Catch: java.lang.Exception -> L9e
            int r6 = r1 + 1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
            r7.<init>()     // Catch: java.lang.Exception -> L9e
            android.content.res.Resources r8 = r18.getResources()     // Catch: java.lang.Exception -> L9e
            int r9 = a7.j.h5     // Catch: java.lang.Exception -> L9e
            java.lang.String r8 = r8.getString(r9)     // Catch: java.lang.Exception -> L9e
            r7.append(r8)     // Catch: java.lang.Exception -> L9e
            java.lang.String r8 = " "
            r7.append(r8)     // Catch: java.lang.Exception -> L9e
            java.lang.Object r8 = r0.get(r1)     // Catch: java.lang.Exception -> L9e
            com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass r8 = (com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r8     // Catch: java.lang.Exception -> L9e
            java.lang.String r8 = r8.getAppname()     // Catch: java.lang.Exception -> L9e
            r7.append(r8)     // Catch: java.lang.Exception -> L9e
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L9e
            r4.add(r5, r6, r5, r7)     // Catch: java.lang.Exception -> L9e
            java.lang.Object r1 = r0.get(r1)     // Catch: java.lang.Exception -> L9e
            com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass r1 = (com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r1     // Catch: java.lang.Exception -> L9e
            r2.add(r1)     // Catch: java.lang.Exception -> L9e
            r1 = r6
            goto L5c
        L9e:
            r1 = r16
            goto Ld5
        La1:
            q7.a0$c r15 = new q7.a0$c     // Catch: java.lang.Exception -> L9e
            r0 = r15
            r1 = r16
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L9e
            r14.f(r15)     // Catch: java.lang.Exception -> L9e
            q7.a0$d r0 = new q7.a0$d     // Catch: java.lang.Exception -> L9e
            r1 = r16
            r0.<init>()     // Catch: java.lang.Exception -> Ld5
            r14.e(r0)     // Catch: java.lang.Exception -> Ld5
            r14.g()     // Catch: java.lang.Exception -> Ld5
            goto Ld5
        Ld0:
            r1 = r16
            m7.w.u0(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch: java.lang.Exception -> Ld5
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.a0.r0(android.view.View, android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final String s0(String str) {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        new Date(System.currentTimeMillis());
        try {
            return new SimpleDateFormat("yyyy-MM-dd:HH-mm", locale).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public class d implements U.c {
        public d() {
        }

        public void a(k.U u) {
        }
    }
}
