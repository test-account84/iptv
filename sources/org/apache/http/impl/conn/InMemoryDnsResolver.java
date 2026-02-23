package org.apache.http.impl.conn;

import j$.util.concurrent.ConcurrentHashMap;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.DnsResolver;
import org.apache.http.util.Args;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class InMemoryDnsResolver implements DnsResolver {
    private final Log log = LogFactory.getLog(InMemoryDnsResolver.class);
    private final Map dnsMap = new ConcurrentHashMap();

    public void add(String str, InetAddress... inetAddressArr) {
        Args.notNull(str, "Host name");
        Args.notNull(inetAddressArr, "Array of IP addresses");
        this.dnsMap.put(str, inetAddressArr);
    }

    public InetAddress[] resolve(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = (InetAddress[]) this.dnsMap.get(str);
        if (this.log.isInfoEnabled()) {
            this.log.info("Resolving " + str + " to " + Arrays.deepToString(inetAddressArr));
        }
        if (inetAddressArr != null) {
            return inetAddressArr;
        }
        throw new UnknownHostException(str + " cannot be resolved");
    }
}
