package z7;

import com.nst.iptvsmarterstvbox.model.callback.BillingAddOrderCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingCheckGPACallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingGetDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingIsPurchasedCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingLoginClientCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingUpdateDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.RegisterClientCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface d extends c {
    void B0(RegisterClientCallback registerClientCallback);

    void J(BillingIsPurchasedCallback billingIsPurchasedCallback);

    void L0(BillingLoginClientCallback billingLoginClientCallback);

    void N0(BillingUpdateDevicesCallback billingUpdateDevicesCallback);

    void g(BillingGetDevicesCallback billingGetDevicesCallback);

    void m0(BillingCheckGPACallback billingCheckGPACallback);

    void q0(BillingAddOrderCallback billingAddOrderCallback);
}
