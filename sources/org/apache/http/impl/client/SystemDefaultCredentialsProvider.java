package org.apache.http.impl.client;

import j$.util.concurrent.ConcurrentHashMap;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map SCHEME_MAP;
    private final BasicCredentialsProvider internal = new BasicCredentialsProvider();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        SCHEME_MAP = concurrentHashMap;
        Locale locale = Locale.ROOT;
        concurrentHashMap.put("Basic".toUpperCase(locale), "Basic");
        concurrentHashMap.put("Digest".toUpperCase(locale), "Digest");
        concurrentHashMap.put("NTLM".toUpperCase(locale), "NTLM");
        concurrentHashMap.put("Negotiate".toUpperCase(locale), "SPNEGO");
        concurrentHashMap.put("Kerberos".toUpperCase(locale), "Kerberos");
    }

    private static PasswordAuthentication getSystemCreds(String str, AuthScope authScope, Authenticator.RequestorType requestorType) {
        return Authenticator.requestPasswordAuthentication(authScope.getHost(), (InetAddress) null, authScope.getPort(), str, (String) null, translateScheme(authScope.getScheme()), (URL) null, requestorType);
    }

    private static String translateScheme(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) SCHEME_MAP.get(str);
        return str2 != null ? str2 : str;
    }

    public void clear() {
        this.internal.clear();
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Auth scope");
        Credentials credentials = this.internal.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            HttpHost origin = authScope.getOrigin();
            String schemeName = origin != null ? origin.getSchemeName() : authScope.getPort() == 443 ? "https" : "http";
            PasswordAuthentication systemCreds = getSystemCreds(schemeName, authScope, Authenticator.RequestorType.SERVER);
            if (systemCreds == null) {
                systemCreds = getSystemCreds(schemeName, authScope, Authenticator.RequestorType.PROXY);
            }
            if (systemCreds == null) {
                String property = System.getProperty(schemeName + ".proxyHost");
                if (property != null) {
                    String property2 = System.getProperty(schemeName + ".proxyPort");
                    if (property2 != null) {
                        try {
                            if (authScope.match(new AuthScope(property, Integer.parseInt(property2))) >= 0) {
                                String property3 = System.getProperty(schemeName + ".proxyUser");
                                if (property3 != null) {
                                    String property4 = System.getProperty(schemeName + ".proxyPassword");
                                    systemCreds = new PasswordAuthentication(property3, property4 != null ? property4.toCharArray() : new char[0]);
                                }
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
            if (systemCreds != null) {
                String property5 = System.getProperty("http.auth.ntlm.domain");
                return property5 != null ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, property5) : "NTLM".equalsIgnoreCase(authScope.getScheme()) ? new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), null, null) : new UsernamePasswordCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()));
            }
        }
        return null;
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.internal.setCredentials(authScope, credentials);
    }
}
