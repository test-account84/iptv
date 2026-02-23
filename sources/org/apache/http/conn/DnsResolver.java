package org.apache.http.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface DnsResolver {
    InetAddress[] resolve(String str) throws UnknownHostException;
}
