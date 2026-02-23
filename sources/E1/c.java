package E1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum c {
    IDLE,
    ACTIVE,
    TERMINATED,
    CANCELED;

    public static class a {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public static a b(c cVar) {
            return new a(cVar);
        }

        public String a(c... cVarArr) {
            StringBuilder sb = new StringBuilder("Expected: " + this.a.name() + ", but found [");
            int length = cVarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                c cVar = cVarArr[i];
                sb.append(str);
                sb.append(cVar.name());
                i++;
                str = ", ";
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
