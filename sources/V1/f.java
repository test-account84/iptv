package v1;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface f {

    public interface a {
        m marshaller();
    }

    public static class b {
        public abstract c marshaller();

        public abstract Map valueMap();
    }

    g name();

    String operationId();

    String queryDocument();

    l responseFieldMapper();

    b variables();

    Object wrapData(a aVar);
}
