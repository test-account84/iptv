package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j0 {

    public static class a implements b {
        public final /* synthetic */ g a;

        public a(g gVar) {
            this.a = gVar;
        }

        public byte a(int i) {
            return this.a.b(i);
        }

        public int size() {
            return this.a.size();
        }
    }

    public interface b {
        byte a(int i);

        int size();
    }

    public static String a(g gVar) {
        return b(new a(gVar));
    }

    public static String b(b bVar) {
        String str;
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i = 0; i < bVar.size(); i++) {
            int a2 = bVar.a(i);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a2 < 32 || a2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(g.g(str));
    }
}
