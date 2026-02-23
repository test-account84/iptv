package a0;

import androidx.datastore.preferences.protobuf.z;
import java.io.InputStream;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public final f a(InputStream inputStream) {
            l.e(inputStream, "input");
            try {
                f O = f.O(inputStream);
                l.d(O, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return O;
            } catch (z e) {
                throw new Y.a("Unable to parse preferences proto.", e);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
