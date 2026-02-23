package com.amazonaws.regions;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RegionMetadata {
    private final List regions;

    public RegionMetadata(List list) {
        if (list == null) {
            throw new IllegalArgumentException("regions cannot be null");
        }
        this.regions = Collections.unmodifiableList(new ArrayList(list));
    }

    private static String getHost(String str) {
        String host = URI.create(str).getHost();
        if (host != null) {
            return host;
        }
        return URI.create("http://" + str).getHost();
    }

    public Region getRegion(String str) {
        for (Region region : this.regions) {
            if (region.getName().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public Region getRegionByEndpoint(String str) {
        String host = getHost(str);
        for (Region region : this.regions) {
            Iterator it = region.getServiceEndpoints().values().iterator();
            while (it.hasNext()) {
                if (host.equals(getHost((String) it.next()))) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public List getRegions() {
        return this.regions;
    }

    public List getRegionsForService(String str) {
        LinkedList linkedList = new LinkedList();
        for (Region region : this.regions) {
            if (region.isServiceSupported(str)) {
                linkedList.add(region);
            }
        }
        return linkedList;
    }

    public String toString() {
        return this.regions.toString();
    }
}
