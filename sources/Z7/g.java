package z7;

import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface g extends b {
    void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback);

    void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e, int i);

    void G0(StalkerTokenCallback stalkerTokenCallback);

    void H(String str);

    void I(m0.x xVar, int i);

    void M(StalkerGetAdCallback stalkerGetAdCallback, int i);

    void O(Z.E e, int i);

    void P0(String str);

    void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback);

    void V(StalkerProfilesCallback stalkerProfilesCallback);

    void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i);

    void c(String str);

    void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2);

    void e(String str);

    void e0(String str);

    void f0(StalkerGetGenresCallback stalkerGetGenresCallback);

    void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback);

    void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback);

    void o0(String str);

    void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback);

    void v0(String str);

    void y0(String str);
}
