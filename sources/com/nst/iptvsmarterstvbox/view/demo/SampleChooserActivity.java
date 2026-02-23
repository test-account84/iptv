package com.nst.iptvsmarterstvbox.view.demo;

import O2.H0;
import O2.R0;
import a7.g;
import a7.h;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import b4.o;
import b4.q;
import b4.r;
import b4.s;
import com.nst.iptvsmarterstvbox.view.demo.a;
import d4.B;
import d4.k0;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import r5.j;
import r5.m;
import r7.t;
import s5.A;
import s5.y;
import z3.x;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SampleChooserActivity extends androidx.appcompat.app.b implements a.c, ExpandableListView.OnChildClickListener {
    public String[] d;
    public boolean e;
    public com.nst.iptvsmarterstvbox.view.demo.a f;
    public e g;
    public MenuItem h;
    public ExpandableListView i;
    public H0 j;
    public boolean k;

    public static class b {
        public static String a() {
            return "android.permission.POST_NOTIFICATIONS";
        }
    }

    public static final class c {
        public final String a;
        public final List b = new ArrayList();

        public c(String str) {
            this.a = str;
        }
    }

    public static final class d {
        public final String a;
        public final List b;

        public d(String str, List list) {
            m.d(!list.isEmpty());
            this.a = str;
            this.b = Collections.unmodifiableList(new ArrayList(list));
        }

        public /* synthetic */ d(String str, List list, a aVar) {
            this(str, list);
        }
    }

    public final class e extends BaseExpandableListAdapter implements View.OnClickListener {
        public List a = Collections.emptyList();

        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d getChild(int i, int i2) {
            return (d) getGroup(i).b.get(i2);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c getGroup(int i) {
            return (c) this.a.get(i);
        }

        public final void c(View view, d dVar) {
            view.setTag(dVar);
            view.findViewById(a7.f.If).setText(dVar.a);
            boolean z = SampleChooserActivity.w1(SampleChooserActivity.this, dVar) == 0;
            boolean z2 = z && SampleChooserActivity.x1(SampleChooserActivity.this).g((H0) dVar.b.get(0));
            ImageButton findViewById = view.findViewById(a7.f.M2);
            findViewById.setTag(dVar);
            findViewById.setColorFilter(z ? z2 ? -12409355 : -4342339 : -10066330);
            findViewById.setImageResource(z2 ? a7.e.p0 : a7.e.E0);
        }

        public void d(List list) {
            this.a = list;
            notifyDataSetChanged();
        }

        public long getChildId(int i, int i2) {
            return i2;
        }

        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SampleChooserActivity.this.getLayoutInflater().inflate(g.o4, viewGroup, false);
                View findViewById = view.findViewById(a7.f.M2);
                findViewById.setOnClickListener(this);
                findViewById.setFocusable(false);
            }
            c(view, getChild(i, i2));
            return view;
        }

        public int getChildrenCount(int i) {
            return getGroup(i).b.size();
        }

        public int getGroupCount() {
            return this.a.size();
        }

        public long getGroupId(int i) {
            return i;
        }

        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SampleChooserActivity.this.getLayoutInflater().inflate(17367046, viewGroup, false);
            }
            ((TextView) view).setText(getGroup(i).a);
            return view;
        }

        public boolean hasStableIds() {
            return false;
        }

        public boolean isChildSelectable(int i, int i2) {
            return true;
        }

        public void onClick(View view) {
            SampleChooserActivity.v1(SampleChooserActivity.this, (d) view.getTag());
        }
    }

    public final class f extends AsyncTask {
        public boolean a;

        public f() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List doInBackground(String... strArr) {
            ArrayList arrayList = new ArrayList();
            o a = r7.b.d(SampleChooserActivity.this.getApplicationContext()).a();
            for (String str : strArr) {
                try {
                    try {
                        f(new JsonReader(new InputStreamReader(new q(a, new s(Uri.parse(str))), "UTF-8")), arrayList);
                    } catch (Exception e) {
                        B.e("SampleChooserActivity", "Error loading sample list: " + str, e);
                        this.a = true;
                    }
                } finally {
                    r.a(a);
                }
            }
            return arrayList;
        }

        public final c b(String str, List list) {
            for (int i = 0; i < list.size(); i++) {
                if (j.a(str, ((c) list.get(i)).a)) {
                    return (c) list.get(i);
                }
            }
            c cVar = new c(str);
            list.add(cVar);
            return cVar;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List list) {
            SampleChooserActivity.u1(SampleChooserActivity.this, list, this.a);
        }

        public final d d(JsonReader jsonReader, boolean z) {
            String nextName;
            String str;
            Uri uri;
            String str2;
            A k = A.k();
            H0.d.a aVar = new H0.d.a();
            H0.c cVar = new H0.c();
            jsonReader.beginObject();
            String str3 = null;
            ArrayList arrayList = null;
            CharSequence charSequence = null;
            Uri uri2 = null;
            CharSequence charSequence2 = null;
            UUID uuid = null;
            String str4 = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            Uri uri3 = null;
            String str5 = null;
            while (jsonReader.hasNext()) {
                nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "subtitle_uri":
                        uri3 = Uri.parse(jsonReader.nextString());
                    case "subtitle_mime_type":
                        str3 = jsonReader.nextString();
                    case "ad_tag_uri":
                        str = str3;
                        uri = uri3;
                        cVar.b(new H0.b.a(Uri.parse(jsonReader.nextString())).c());
                        str3 = str;
                        uri3 = uri;
                    case "extension":
                        charSequence = jsonReader.nextString();
                    case "drm_license_uri":
                    case "drm_license_url":
                        str4 = jsonReader.nextString();
                    case "uri":
                        uri2 = Uri.parse(jsonReader.nextString());
                    case "name":
                        charSequence2 = jsonReader.nextString();
                    case "drm_force_default_license_uri":
                        z4 = jsonReader.nextBoolean();
                    case "drm_scheme":
                        uuid = k0.Y(jsonReader.nextString());
                    case "drm_key_request_properties":
                        str = str3;
                        uri = uri3;
                        HashMap hashMap = new HashMap();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            hashMap.put(jsonReader.nextName(), jsonReader.nextString());
                        }
                        jsonReader.endObject();
                        k = A.d(hashMap);
                        str3 = str;
                        uri3 = uri;
                    case "subtitle_language":
                        str5 = jsonReader.nextString();
                    case "clip_start_position_ms":
                        str = str3;
                        uri = uri3;
                        aVar.k(jsonReader.nextLong());
                        str3 = str;
                        uri3 = uri;
                    case "drm_session_for_clear_content":
                        str2 = str3;
                        z2 = jsonReader.nextBoolean();
                        str3 = str2;
                    case "drm_multi_session":
                        str2 = str3;
                        z3 = jsonReader.nextBoolean();
                        str3 = str2;
                    case "playlist":
                        String str6 = str3;
                        boolean z5 = true;
                        m.q(!z, "Invalid nesting of playlists");
                        arrayList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add(d(jsonReader, z5));
                            str6 = str6;
                            uri3 = uri3;
                            z5 = true;
                        }
                        str2 = str6;
                        jsonReader.endArray();
                        str3 = str2;
                    case "clip_end_position_ms":
                        aVar.h(jsonReader.nextLong());
                        str = str3;
                        uri = uri3;
                        str3 = str;
                        uri3 = uri;
                    default:
                        throw new IOException("Unsupported attribute name: " + nextName, (Throwable) null);
                }
            }
            String str7 = str3;
            Uri uri4 = uri3;
            jsonReader.endObject();
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2.addAll(((d) arrayList.get(i)).b);
                }
                return new d(charSequence2, arrayList2, null);
            }
            cVar.m(uri2).h(new R0.b().m0(charSequence2).H()).i(k0.H(TextUtils.isEmpty(charSequence) ? k0.w0(uri2) : k0.x0(charSequence))).c(aVar.f());
            if (uuid != null) {
                cVar.e(new H0.f.a(uuid).p(str4).n(k).k(z2).q(z3).j(z4).i());
            } else {
                m.q(str4 == null, "drm_uuid is required if drm_license_uri is set.");
                m.q(k.isEmpty(), "drm_uuid is required if drm_key_request_properties is set.");
                m.q(!z2, "drm_uuid is required if drm_session_for_clear_content is set.");
                m.q(!z3, "drm_uuid is required if drm_multi_session is set.");
                m.q(true ^ z4, "drm_uuid is required if drm_force_default_license_uri is set.");
            }
            if (uri4 != null) {
                cVar.k(y.A(new H0.k.a(uri4).n((String) m.l(str7, "subtitle_mime_type is required if subtitle_uri is set.")).m(str5).i()));
            }
            return new d(charSequence2, Collections.singletonList(cVar.a()), null);
        }

        public final void e(JsonReader jsonReader, List list) {
            String nextName;
            ArrayList arrayList = new ArrayList();
            jsonReader.beginObject();
            String str = "";
            while (jsonReader.hasNext()) {
                nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "_comment":
                        jsonReader.nextString();
                        break;
                    case "name":
                        str = jsonReader.nextString();
                        break;
                    case "samples":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add(d(jsonReader, false));
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        throw new IOException("Unsupported name: " + nextName, (Throwable) null);
                }
            }
            jsonReader.endObject();
            b(str, list).b.addAll(arrayList);
        }

        public final void f(JsonReader jsonReader, List list) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                e(jsonReader, list);
            }
            jsonReader.endArray();
        }

        public /* synthetic */ f(SampleChooserActivity sampleChooserActivity, a aVar) {
            this();
        }
    }

    public static boolean B1(MenuItem menuItem) {
        return menuItem != null && menuItem.isChecked();
    }

    public static /* synthetic */ void u1(SampleChooserActivity sampleChooserActivity, List list, boolean z) {
        sampleChooserActivity.D1(list, z);
    }

    public static /* synthetic */ void v1(SampleChooserActivity sampleChooserActivity, d dVar) {
        sampleChooserActivity.E1(dVar);
    }

    public static /* synthetic */ int w1(SampleChooserActivity sampleChooserActivity, d dVar) {
        return sampleChooserActivity.y1(dVar);
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.demo.a x1(SampleChooserActivity sampleChooserActivity) {
        return sampleChooserActivity.f;
    }

    public final void A1(int[] iArr) {
        if (!this.k && (iArr.length == 0 || iArr[0] != 0)) {
            this.k = true;
        }
        H0 h0 = this.j;
        if (h0 != null) {
            G1(h0);
            this.j = null;
        }
    }

    public final void C1() {
        m.k(this.d);
        int i = 0;
        while (true) {
            String[] strArr = this.d;
            if (i >= strArr.length) {
                new f(this, null).execute(this.d);
                return;
            } else if (k0.O0(this, new Uri[]{Uri.parse(strArr[i])})) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void D1(List list, boolean z) {
        if (z) {
            Toast.makeText(getApplicationContext(), a7.j.v6, 1).show();
        }
        this.g.d(list);
        SharedPreferences preferences = getPreferences(0);
        int i = preferences.getInt("sample_chooser_group_position", -1);
        int i2 = preferences.getInt("sample_chooser_child_position", -1);
        if (i == -1 || i2 == -1 || i >= list.size() || i2 >= ((c) list.get(i)).b.size()) {
            return;
        }
        this.i.expandGroup(i);
        this.i.setSelectedChild(i, i2, true);
    }

    public final void E1(d dVar) {
        int y1 = y1(dVar);
        if (y1 != 0) {
            Toast.makeText(getApplicationContext(), y1, 1).show();
            return;
        }
        if (this.k || Build.VERSION.SDK_INT < 33 || r7.s.a(this, b.a()) == 0) {
            G1((H0) dVar.b.get(0));
        } else {
            this.j = (H0) dVar.b.get(0);
            t.a(this, new String[]{b.a()}, 100);
        }
    }

    public final void F1() {
        try {
            x.A(this, r7.a.class);
        } catch (IllegalStateException unused) {
            x.B(this, r7.a.class);
        }
    }

    public final void G1(H0 h0) {
        this.f.j(getSupportFragmentManager(), h0, r7.b.b(this, B1(this.h)));
    }

    public void Y0() {
        this.g.notifyDataSetChanged();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putInt("sample_chooser_group_position", i);
        edit.putInt("sample_chooser_child_position", i2);
        edit.apply();
        d dVar = (d) view.getTag();
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("prefer_extension_decoders", B1(this.h));
        r7.g.d(dVar.b, intent);
        startActivity(intent);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.n4);
        this.g = new e();
        ExpandableListView findViewById = findViewById(a7.f.Hf);
        this.i = findViewById;
        findViewById.setAdapter(this.g);
        this.i.setOnChildClickListener(this);
        String dataString = getIntent().getDataString();
        if (dataString != null) {
            this.d = new String[]{dataString};
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                for (String str : getAssets().list("")) {
                    if (str.endsWith(".exolist.json")) {
                        arrayList.add("asset:///" + str);
                    }
                }
            } catch (IOException unused) {
                Toast.makeText(getApplicationContext(), a7.j.v6, 1).show();
            }
            String[] strArr = new String[arrayList.size()];
            this.d = strArr;
            arrayList.toArray(strArr);
            Arrays.sort(this.d);
        }
        this.e = r7.b.h();
        this.f = r7.b.f(this);
        C1();
        F1();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(h.x, menu);
        MenuItem findItem = menu.findItem(a7.f.Jc);
        this.h = findItem;
        findItem.setVisible(this.e);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.setChecked(!menuItem.isChecked());
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            A1(iArr);
        } else {
            z1(iArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.f.e(this);
        this.g.notifyDataSetChanged();
    }

    public void onStop() {
        this.f.i(this);
        super.onStop();
    }

    public final int y1(d dVar) {
        if (dVar.b.size() > 1) {
            return a7.j.a1;
        }
        H0.h hVar = (H0.h) m.k(((H0) dVar.b.get(0)).c);
        if (hVar.e != null) {
            return a7.j.V0;
        }
        String scheme = hVar.a.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return 0;
        }
        return a7.j.b1;
    }

    public final void z1(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        if (iArr[0] == 0) {
            C1();
        } else {
            Toast.makeText(getApplicationContext(), a7.j.v6, 1).show();
            finish();
        }
    }
}
