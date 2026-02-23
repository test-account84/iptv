package com.amazonaws.regions;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Region {
    private static final String DEFAULT_DOMAIN = "amazonaws.com";
    private final String domain;
    private final String name;
    private final Map serviceEndpoints = new HashMap();
    private final Map httpSupport = new HashMap();
    private final Map httpsSupport = new HashMap();

    public Region(String str, String str2) {
        this.name = str;
        if (str2 == null || str2.isEmpty()) {
            this.domain = "amazonaws.com";
        } else {
            this.domain = str2;
        }
    }

    public static Region getRegion(Regions regions) {
        return RegionUtils.getRegion(regions.getName());
    }

    public AmazonWebServiceClient createClient(Class cls, AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        try {
            AmazonWebServiceClient amazonWebServiceClient = (AmazonWebServiceClient) ((aWSCredentialsProvider == null && clientConfiguration == null) ? cls.getConstructor((Class[]) null).newInstance((Object[]) null) : aWSCredentialsProvider == null ? cls.getConstructor(new Class[]{ClientConfiguration.class}).newInstance(new Object[]{clientConfiguration}) : clientConfiguration == null ? cls.getConstructor(new Class[]{AWSCredentialsProvider.class}).newInstance(new Object[]{aWSCredentialsProvider}) : cls.getConstructor(new Class[]{AWSCredentialsProvider.class, ClientConfiguration.class}).newInstance(new Object[]{aWSCredentialsProvider, clientConfiguration}));
            amazonWebServiceClient.setRegion(this);
            return amazonWebServiceClient;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't instantiate instance of " + cls, e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return getName().equals(((Region) obj).getName());
        }
        return false;
    }

    public String getDomain() {
        return this.domain;
    }

    public Map getHttpSupport() {
        return this.httpSupport;
    }

    public Map getHttpsSupport() {
        return this.httpsSupport;
    }

    public String getName() {
        return this.name;
    }

    public String getServiceEndpoint(String str) {
        return (String) this.serviceEndpoints.get(str);
    }

    public Map getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    public boolean hasHttpEndpoint(String str) {
        return this.httpSupport.containsKey(str) && ((Boolean) this.httpSupport.get(str)).booleanValue();
    }

    public boolean hasHttpsEndpoint(String str) {
        return this.httpsSupport.containsKey(str) && ((Boolean) this.httpsSupport.get(str)).booleanValue();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isServiceSupported(String str) {
        return this.serviceEndpoints.containsKey(str);
    }

    public String toString() {
        return getName();
    }

    public static Region getRegion(String str) {
        return RegionUtils.getRegion(str);
    }
}
