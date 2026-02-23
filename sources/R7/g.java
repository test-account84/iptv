package r7;

import O2.H0;
import O2.R0;
import android.content.Intent;
import android.net.Uri;
import d4.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import s5.c0;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {
    public static void a(H0.d dVar, Intent intent, String str) {
        if (dVar.a != 0) {
            intent.putExtra("clip_start_position_ms" + str, dVar.a);
        }
        if (dVar.c != Long.MIN_VALUE) {
            intent.putExtra("clip_end_position_ms" + str, dVar.c);
        }
    }

    public static void b(H0.f fVar, Intent intent, String str) {
        intent.putExtra("drm_scheme" + str, fVar.a.toString());
        String str2 = "drm_license_uri" + str;
        Uri uri = fVar.d;
        intent.putExtra(str2, uri != null ? uri.toString() : null);
        intent.putExtra("drm_multi_session" + str, fVar.g);
        intent.putExtra("drm_force_default_license_uri" + str, fVar.i);
        String[] strArr = new String[fVar.f.size() * 2];
        c0 l = fVar.f.h().l();
        boolean z = false;
        int i = 0;
        while (l.hasNext()) {
            Map.Entry entry = (Map.Entry) l.next();
            int i2 = i + 1;
            strArr[i] = (String) entry.getKey();
            i += 2;
            strArr[i2] = (String) entry.getValue();
        }
        intent.putExtra("drm_key_request_properties" + str, strArr);
        y yVar = fVar.k;
        if (yVar.isEmpty()) {
            return;
        }
        if (yVar.size() == 2 && yVar.contains(2) && yVar.contains(1)) {
            z = true;
        }
        r5.m.p(z);
        intent.putExtra("drm_session_for_clear_content" + str, true);
    }

    public static void c(H0.h hVar, Intent intent, String str) {
        Intent putExtra = intent.putExtra("mime_type" + str, hVar.c);
        String str2 = "ad_tag_uri" + str;
        H0.b bVar = hVar.e;
        putExtra.putExtra(str2, bVar != null ? bVar.a.toString() : null);
        H0.f fVar = hVar.d;
        if (fVar != null) {
            b(fVar, intent, str);
        }
        if (hVar.h.isEmpty()) {
            return;
        }
        r5.m.p(hVar.h.size() == 1);
        H0.k kVar = (H0.k) hVar.h.get(0);
        intent.putExtra("subtitle_uri" + str, kVar.a.toString());
        intent.putExtra("subtitle_mime_type" + str, kVar.c);
        intent.putExtra("subtitle_language" + str, kVar.d);
    }

    public static void d(List list, Intent intent) {
        r5.m.d(!list.isEmpty());
        if (list.size() == 1) {
            H0 h0 = (H0) list.get(0);
            H0.h hVar = (H0.h) r5.m.k(h0.c);
            intent.setAction("com.google.android.exoplayer.demo.action.VIEW").setData(h0.c.a);
            CharSequence charSequence = h0.f.a;
            if (charSequence != null) {
                intent.putExtra("title", charSequence);
            }
            c(hVar, intent, "");
            a(h0.g, intent, "");
            return;
        }
        intent.setAction("com.google.android.exoplayer.demo.action.VIEW_LIST");
        for (int i = 0; i < list.size(); i++) {
            H0 h02 = (H0) list.get(i);
            H0.h hVar2 = (H0.h) r5.m.k(h02.c);
            intent.putExtra("uri_" + i, hVar2.a.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(i);
            c(hVar2, intent, sb.toString());
            a(h02.g, intent, "_" + i);
            if (h02.f.a != null) {
                intent.putExtra("title_" + i, h02.f.a);
            }
        }
    }

    public static H0 e(Uri uri, Intent intent, String str) {
        String stringExtra = intent.getStringExtra("mime_type" + str);
        String stringExtra2 = intent.getStringExtra("title" + str);
        String stringExtra3 = intent.getStringExtra("ad_tag_uri" + str);
        H0.k g = g(intent, str);
        H0.c c = new H0.c().m(uri).i(stringExtra).h(new R0.b().m0(stringExtra2).H()).c(new H0.d.a().k(intent.getLongExtra("clip_start_position_ms" + str, 0L)).h(intent.getLongExtra("clip_end_position_ms" + str, Long.MIN_VALUE)).f());
        if (stringExtra3 != null) {
            c.b(new H0.b.a(Uri.parse(stringExtra3)).c());
        }
        if (g != null) {
            c.k(y.A(g));
        }
        return h(c, intent, str).a();
    }

    public static List f(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if ("com.google.android.exoplayer.demo.action.VIEW_LIST".equals(intent.getAction())) {
            int i = 0;
            while (true) {
                if (!intent.hasExtra("uri_" + i)) {
                    break;
                }
                arrayList.add(e(Uri.parse(intent.getStringExtra("uri_" + i)), intent, "_" + i));
                i++;
            }
        } else {
            arrayList.add(e(intent.getData(), intent, ""));
        }
        return arrayList;
    }

    public static H0.k g(Intent intent, String str) {
        if (!intent.hasExtra("subtitle_uri" + str)) {
            return null;
        }
        return new H0.k.a(Uri.parse(intent.getStringExtra("subtitle_uri" + str))).n((String) r5.m.k(intent.getStringExtra("subtitle_mime_type" + str))).m(intent.getStringExtra("subtitle_language" + str)).p(1).i();
    }

    public static H0.c h(H0.c cVar, Intent intent, String str) {
        String stringExtra = intent.getStringExtra("drm_scheme" + str);
        if (stringExtra == null) {
            return cVar;
        }
        HashMap hashMap = new HashMap();
        String[] stringArrayExtra = intent.getStringArrayExtra("drm_key_request_properties" + str);
        if (stringArrayExtra != null) {
            for (int i = 0; i < stringArrayExtra.length; i += 2) {
                hashMap.put(stringArrayExtra[i], stringArrayExtra[i + 1]);
            }
        }
        UUID Y = k0.Y(stringExtra);
        if (Y != null) {
            cVar.e(new H0.f.a(Y).p(intent.getStringExtra("drm_license_uri" + str)).q(intent.getBooleanExtra("drm_multi_session" + str, false)).j(intent.getBooleanExtra("drm_force_default_license_uri" + str, false)).n(hashMap).k(intent.getBooleanExtra("drm_session_for_clear_content" + str, false)).i());
        }
        return cVar;
    }
}
