package E8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class f {
    public static void a(Appendable appendable, Object obj, w8.l lVar) {
        CharSequence valueOf;
        kotlin.jvm.internal.l.e(appendable, "<this>");
        if (lVar == null) {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    appendable.append(((Character) obj).charValue());
                    return;
                }
                valueOf = String.valueOf(obj);
            }
            appendable.append(valueOf);
        }
        obj = lVar.invoke(obj);
        valueOf = (CharSequence) obj;
        appendable.append(valueOf);
    }
}
