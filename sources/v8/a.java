package v8;

import C8.c;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a {
    public static final Class a(c cVar) {
        l.e(cVar, "<this>");
        Class a = ((d) cVar).a();
        l.c(a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Attempt to invoke interface method 'java.util.Iterator java.util.List.iterator()' on a null object reference
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(Unknown Source:139)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(Unknown Source:6)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(Unknown Source:6)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(Unknown Source:34)
     */
    public static final Class b(c cVar) {
        l.e(cVar, "<this>");
        Class<Short> a = ((d) cVar).a();
        if (!a.isPrimitive()) {
            l.c(a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return a;
        }
        String name = a.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    a = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    a = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    a = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    a = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    a = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    a = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    a = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    a = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    a = Short.class;
                    break;
                }
                break;
        }
        l.c(a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return a;
    }
}
