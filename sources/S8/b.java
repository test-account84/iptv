package S8;

import v1.s;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b implements s {
    public static final b AWSDATETIME = new b("AWSDATETIME", 0);
    public static final b ID = new c("ID", 1);
    public static final b AWSDATE = new d("AWSDATE", 2);
    public static final b AWSTIME = new e("AWSTIME", 3);
    public static final b AWSTIMESTAMP = new f("AWSTIMESTAMP", 4);
    public static final b AWSEMAIL = new g("AWSEMAIL", 5);
    public static final b AWSJSON = new h("AWSJSON", 6);
    public static final b AWSURL = new i("AWSURL", 7);
    public static final b AWSPHONE = new j("AWSPHONE", 8);
    public static final b AWSIPADDRESS = new a("AWSIPADDRESS", 9);
    private static final /* synthetic */ b[] $VALUES = $values();

    public enum a extends b {
        public a(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSIPAddress";
        }
    }

    public enum b extends b {
        public b(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSDateTime";
        }
    }

    public enum c extends b {
        public c(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "ID";
        }
    }

    public enum d extends b {
        public d(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSDate";
        }
    }

    public enum e extends b {
        public e(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSTime";
        }
    }

    public enum f extends b {
        public f(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return Long.class;
        }

        public String typeName() {
            return "AWSTimestamp";
        }
    }

    public enum g extends b {
        public g(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSEmail";
        }
    }

    public enum h extends b {
        public h(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSJSON";
        }
    }

    public enum i extends b {
        public i(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSURL";
        }
    }

    public enum j extends b {
        public j(String str, int i) {
            super(str, i, null);
        }

        public Class javaType() {
            return String.class;
        }

        public String typeName() {
            return "AWSPhone";
        }
    }

    private static /* synthetic */ b[] $values() {
        return new b[]{AWSDATETIME, ID, AWSDATE, AWSTIME, AWSTIMESTAMP, AWSEMAIL, AWSJSON, AWSURL, AWSPHONE, AWSIPADDRESS};
    }

    private b(String str, int i2) {
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    public abstract /* synthetic */ Class javaType();

    public abstract /* synthetic */ String typeName();

    public /* synthetic */ b(String str, int i2, b bVar) {
        this(str, i2);
    }
}
