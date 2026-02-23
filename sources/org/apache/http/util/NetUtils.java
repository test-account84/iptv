package org.apache.http.util;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class NetUtils {
    public static void formatAddress(StringBuilder sb, SocketAddress socketAddress) {
        Args.notNull(sb, "Buffer");
        Args.notNull(socketAddress, "Socket address");
        if (!(socketAddress instanceof InetSocketAddress)) {
            sb.append(socketAddress);
            return;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        String address = inetSocketAddress.getAddress();
        if (address != null) {
            address = address.getHostAddress();
        }
        sb.append(address);
        sb.append(':');
        sb.append(inetSocketAddress.getPort());
    }
}
