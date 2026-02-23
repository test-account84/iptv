package P3;

import O2.z0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface l {
    public static final l a = new a();

    public class a implements l {
        public boolean a(z0 z0Var) {
            String str = z0Var.m;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        public j b(z0 z0Var) {
            String str = z0Var.m;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new R3.a(z0Var.o);
                    case "application/pgs":
                        return new S3.a();
                    case "application/x-mp4-vtt":
                        return new Y3.a();
                    case "text/vtt":
                        return new Y3.h();
                    case "application/x-quicktime-tx3g":
                        return new X3.a(z0Var.o);
                    case "text/x-ssa":
                        return new U3.a(z0Var.o);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new Q3.a(str, z0Var.E, 16000L);
                    case "text/x-exoplayer-cues":
                        return new g();
                    case "application/cea-708":
                        return new Q3.c(z0Var.E, z0Var.o);
                    case "application/x-subrip":
                        return new V3.a();
                    case "application/ttml+xml":
                        return new W3.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(z0 z0Var);

    j b(z0 z0Var);
}
