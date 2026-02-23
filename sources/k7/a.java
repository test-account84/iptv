package K7;

import a7.j;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.core.B;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.k;
import f8.l;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends ListFragment implements G.e, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, G.b {
    public SeekBar a;
    public LinearLayout c;
    public RadioGroup d;
    public TextView e;
    public TextView f;
    public TextView g;
    public boolean h;
    public CheckBox i;
    public g j;
    public TextView k;
    public AnimatorListenerAdapter l = new b();

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public a(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void run() {
            a.a(a.this).setText(this.a);
            a.b(a.this).setText(this.c);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            a.c(a.this).setVisibility(8);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ l a;

        public c(l lVar) {
            this.a = lVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(a.this.getActivity(), LaunchVPN.class);
            intent.putExtra("de.blinkt.openvpn.shortcutProfileUUID", this.a.B());
            intent.setAction("android.intent.action.MAIN");
            a.this.startActivity(intent);
        }
    }

    public class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
            ((ClipboardManager) a.this.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Log Entry", ((TextView) view).getText()));
            Toast.makeText(a.this.getActivity(), j.x0, 0).show();
            return true;
        }
    }

    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            B.a(a.this.getActivity()).edit().putBoolean("clearlogconnect", z).apply();
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        public void run() {
            if (a.this.isAdded()) {
                if (a.d(a.this) != null) {
                    a.d(a.this).setText(this.a);
                }
                if (a.e(a.this) != null) {
                    a.e(a.this).setText(this.a);
                }
            }
        }
    }

    public static /* synthetic */ TextView a(a aVar) {
        return aVar.e;
    }

    public static /* synthetic */ TextView b(a aVar) {
        return aVar.f;
    }

    public static /* synthetic */ LinearLayout c(a aVar) {
        return aVar.c;
    }

    public static /* synthetic */ TextView d(a aVar) {
        return aVar.k;
    }

    public static /* synthetic */ TextView e(a aVar) {
        return aVar.g;
    }

    public void E(long j, long j2, long j3, long j4) {
        Resources resources = getActivity().getResources();
        String format = String.format("%2$s %1$s", new Object[]{OpenVPNService.y1(j, false, resources), OpenVPNService.y1(j3 / 2, true, resources)});
        String format2 = String.format("%2$s %1$s", new Object[]{OpenVPNService.y1(j2, false, resources), OpenVPNService.y1(j4 / 2, true, resources)});
        if (this.e == null || this.f == null || getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new a(format2, format));
    }

    public void c0(String str, String str2, int i, de.blinkt.openvpn.core.e eVar, Intent intent) {
        if (isAdded()) {
            getActivity().runOnUiThread(new f(G.f(getActivity())));
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemLongClickListener(new d());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            l c2 = C.c(getActivity(), intent.getStringExtra("de.blinkt.openvpn.profileUUID"));
            C.g(getActivity()).o(getActivity(), c2);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(j.s0);
            builder.setMessage(j.k6);
            builder.setPositiveButton(j.g6, new c(c2));
            builder.setNegativeButton(j.r2, (DialogInterface.OnClickListener) null);
            builder.create().show();
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.h = false;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        g gVar;
        int i2;
        if (i == a7.f.Yc) {
            gVar = this.j;
            i2 = 2;
        } else if (i == a7.f.Zc) {
            gVar = this.j;
            i2 = 0;
        } else {
            if (i != a7.f.ad) {
                return;
            }
            gVar = this.j;
            i2 = 1;
        }
        gVar.j(i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r5, android.view.ViewGroup r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r7 = a7.g.E3
            r0 = 0
            android.view.View r5 = r5.inflate(r7, r6, r0)
            r6 = 1
            r4.setHasOptionsMenu(r6)
            K7.a$g r7 = new K7.a$g
            r7.<init>()
            r4.j = r7
            android.app.Activity r1 = r4.getActivity()
            android.content.SharedPreferences r1 = r1.getPreferences(r0)
            java.lang.String r2 = "logtimeformat"
            int r1 = r1.getInt(r2, r6)
            K7.a.g.d(r7, r1)
            android.app.Activity r7 = r4.getActivity()
            android.content.SharedPreferences r7 = r7.getPreferences(r0)
            java.lang.String r1 = "verbositylevel"
            int r7 = r7.getInt(r1, r6)
            K7.a$g r1 = r4.j
            r1.i(r7)
            K7.a$g r1 = r4.j
            r4.setListAdapter(r1)
            int r1 = a7.f.hh
            android.view.View r1 = r5.findViewById(r1)
            android.widget.RadioGroup r1 = (android.widget.RadioGroup) r1
            r4.d = r1
            r1.setOnCheckedChangeListener(r4)
            K7.a$g r1 = r4.j
            int r1 = K7.a.g.c(r1)
            r2 = 2
            if (r1 != r2) goto L59
            android.widget.RadioGroup r1 = r4.d
            int r2 = a7.f.Yc
        L55:
            r1.check(r2)
            goto L73
        L59:
            K7.a$g r1 = r4.j
            int r1 = K7.a.g.c(r1)
            if (r1 != 0) goto L66
            android.widget.RadioGroup r1 = r4.d
            int r2 = a7.f.Zc
            goto L55
        L66:
            K7.a$g r1 = r4.j
            int r1 = K7.a.g.c(r1)
            if (r1 != r6) goto L73
            android.widget.RadioGroup r1 = r4.d
            int r2 = a7.f.ad
            goto L55
        L73:
            int r1 = a7.f.j2
            android.view.View r1 = r5.findViewById(r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            r4.i = r1
            android.app.Activity r2 = r4.getActivity()
            android.content.SharedPreferences r2 = android.preference.PreferenceManager.getDefaultSharedPreferences(r2)
            java.lang.String r3 = "clearlogconnect"
            boolean r2 = r2.getBoolean(r3, r6)
            r1.setChecked(r2)
            android.widget.CheckBox r1 = r4.i
            K7.a$e r2 = new K7.a$e
            r2.<init>()
            r1.setOnCheckedChangeListener(r2)
            int r1 = a7.f.vg
            android.view.View r1 = r5.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r4.k = r1
            int r1 = a7.f.Ua
            android.view.View r1 = r5.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r4.c = r1
            int r1 = a7.f.b
            android.view.View r1 = r5.findViewById(r1)
            android.widget.SeekBar r1 = (android.widget.SeekBar) r1
            r4.a = r1
            r2 = 3
            r1.setMax(r2)
            android.widget.SeekBar r1 = r4.a
            int r7 = r7 - r6
            r1.setProgress(r7)
            android.widget.SeekBar r6 = r4.a
            r6.setOnSeekBarChangeListener(r4)
            int r6 = a7.f.yg
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.e = r6
            int r6 = a7.f.wg
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.f = r6
            int r6 = a7.f.xg
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.g = r6
            boolean r6 = r4.h
            if (r6 == 0) goto Lec
            android.widget.LinearLayout r6 = r4.c
            r6.setVisibility(r0)
        Lec:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: K7.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onDestroy() {
        G.D(this.j);
        super.onDestroy();
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.j.i(i + 1);
    }

    public void onResume() {
        super.onResume();
        new Intent(getActivity(), OpenVPNService.class).setAction("de.blinkt.openvpn.START_SERVICE");
    }

    public void onStart() {
        super.onStart();
        G.c(this);
        G.a(this);
    }

    public void onStop() {
        super.onStop();
        G.E(this);
        G.C(this);
        getActivity().getPreferences(0).edit().putInt("logtimeformat", g.c(this.j)).putInt("verbositylevel", g.b(this.j)).apply();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public class g implements ListAdapter, G.d, Handler.Callback, G.b, G.e {
        public Handler d;
        public Vector a = new Vector();
        public Vector c = new Vector();
        public Vector e = new Vector();
        public int f = 0;
        public int g = 3;

        public g() {
            h();
            if (this.d == null) {
                this.d = new Handler(this);
            }
            G.b(this);
        }

        public static /* synthetic */ int b(g gVar) {
            return gVar.g;
        }

        public static /* synthetic */ int c(g gVar) {
            return gVar.f;
        }

        public static /* synthetic */ int d(g gVar, int i) {
            gVar.f = i;
            return i;
        }

        public void a(k kVar) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            Bundle bundle = new Bundle();
            bundle.putParcelable("logmessage", kVar);
            obtain.setData(bundle);
            this.d.sendMessage(obtain);
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public final boolean e(k kVar) {
            this.a.add(kVar);
            if (this.a.size() <= 1000) {
                if (kVar.f() > this.g) {
                    return false;
                }
                this.c.add(kVar);
                return true;
            }
            Vector vector = this.a;
            this.a = new Vector(this.a.size());
            for (int i = 50; i < vector.size(); i++) {
                this.a.add((k) vector.elementAt(i));
            }
            g();
            return true;
        }

        public final String f(k kVar, int i) {
            if (i == 0) {
                return "";
            }
            Date date = new Date(kVar.a());
            return (i == 2 ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()) : DateFormat.getTimeFormat(a.this.getActivity())).format(date) + " ";
        }

        public final void g() {
            this.c.clear();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                int f = kVar.f();
                int i = this.g;
                if (f <= i || i == 4) {
                    this.c.add(kVar);
                }
            }
        }

        public int getCount() {
            return this.c.size();
        }

        public Object getItem(int i) {
            return this.c.get(i);
        }

        public long getItemId(int i) {
            return this.c.get(i).hashCode();
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = view == null ? new TextView(a.this.getActivity()) : (TextView) view;
            k kVar = (k) this.c.get(i);
            textView.setTextColor(a.this.getActivity().getResources().getColor(a7.c.d));
            String e = kVar.e(a.this.getActivity());
            String f = f(kVar, this.f);
            f.length();
            textView.setText(new SpannableString(f + e));
            return textView;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public final void h() {
            this.a.clear();
            Collections.addAll(this.a, G.j());
            g();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (e((k) message.getData().getParcelable("logmessage"))) {
                    Iterator it = this.e.iterator();
                    while (it.hasNext()) {
                        ((DataSetObserver) it.next()).onChanged();
                    }
                }
            } else if (i == 1) {
                Iterator it2 = this.e.iterator();
                while (it2.hasNext()) {
                    ((DataSetObserver) it2.next()).onInvalidated();
                }
                h();
            } else if (i == 2) {
                Iterator it3 = this.e.iterator();
                while (it3.hasNext()) {
                    ((DataSetObserver) it3.next()).onInvalidated();
                }
            } else if (i == 3) {
                g();
                Iterator it4 = this.e.iterator();
                while (it4.hasNext()) {
                    ((DataSetObserver) it4.next()).onChanged();
                }
            }
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }

        public void i(int i) {
            this.g = i;
            this.d.sendEmptyMessage(3);
        }

        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public void j(int i) {
            this.f = i;
            this.d.sendEmptyMessage(2);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.e.add(dataSetObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.e.remove(dataSetObserver);
        }

        public void Z(String str) {
        }

        public void c0(String str, String str2, int i, de.blinkt.openvpn.core.e eVar, Intent intent) {
        }

        public void E(long j, long j2, long j3, long j4) {
        }
    }

    public void Z(String str) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
