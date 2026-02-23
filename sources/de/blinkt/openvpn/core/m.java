package de.blinkt.openvpn.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Vector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class m {
    public static Vector a(Context context, boolean z) {
        Vector vector = new Vector();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        for (Network network : connectivityManager.getAllNetworks()) {
            connectivityManager.getNetworkInfo(network);
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (!networkCapabilities.hasTransport(4) && !networkCapabilities.hasTransport(0)) {
                for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                    if (((linkAddress.getAddress() instanceof Inet4Address) && !z) || ((linkAddress.getAddress() instanceof Inet6Address) && z)) {
                        vector.add(linkAddress.toString());
                    }
                }
            }
        }
        return vector;
    }
}
