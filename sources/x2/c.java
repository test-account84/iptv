package X2;

import android.content.Context;
import d4.B;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {

    public static class a implements Comparator {
        public final boolean a;

        public a(boolean z) {
            this.a = z;
        }

        public static int b(String str, String str2) {
            if (str != null && str2 != null) {
                String[] i1 = k0.i1(str, "\\.");
                String[] i12 = k0.i1(str2, "\\.");
                int min = Math.min(i1.length, i12.length);
                for (int i = 0; i < min; i++) {
                    if (!i1[i].equals(i12[i])) {
                        try {
                            return Integer.parseInt(i1[i]) - Integer.parseInt(i12[i]);
                        } catch (NumberFormatException unused) {
                            return 0;
                        }
                    }
                }
            }
            return 0;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CronetProvider cronetProvider, CronetProvider cronetProvider2) {
            int c = c(cronetProvider) - c(cronetProvider2);
            return c != 0 ? c : -b(cronetProvider.getVersion(), cronetProvider2.getVersion());
        }

        public final int c(CronetProvider cronetProvider) {
            String name = cronetProvider.getName();
            if ("App-Packaged-Cronet-Provider".equals(name)) {
                return 1;
            }
            if ("Google-Play-Services-Cronet-Provider".equals(name)) {
                return this.a ? 0 : 2;
            }
            return 3;
        }
    }

    public static CronetEngine a(Context context) {
        return b(context, null, false);
    }

    public static CronetEngine b(Context context, String str, boolean z) {
        String str2;
        ArrayList arrayList = new ArrayList(CronetProvider.getAllProviders(context));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((CronetProvider) arrayList.get(size)).isEnabled() || "Fallback-Cronet-Provider".equals(((CronetProvider) arrayList.get(size)).getName())) {
                arrayList.remove(size);
            }
        }
        Collections.sort(arrayList, new a(z));
        for (int i = 0; i < arrayList.size(); i++) {
            String name = ((CronetProvider) arrayList.get(i)).getName();
            try {
                CronetEngine.Builder createBuilder = ((CronetProvider) arrayList.get(i)).createBuilder();
                if (str != null) {
                    createBuilder.setUserAgent(str);
                }
                CronetEngine build = createBuilder.build();
                B.b("CronetUtil", "CronetEngine built using " + name);
                return build;
            } catch (UnsatisfiedLinkError unused) {
                str2 = "Failed to link Cronet binaries. Please check that native Cronet binaries arebundled into your app.";
                B.j("CronetUtil", str2);
            } catch (SecurityException unused2) {
                str2 = "Failed to build CronetEngine. Please check that the process has android.permission.ACCESS_NETWORK_STATE.";
                B.j("CronetUtil", str2);
            }
        }
        B.j("CronetUtil", "CronetEngine could not be built.");
        return null;
    }
}
