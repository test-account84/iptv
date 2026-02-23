package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RegionUtils {
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    private static List regions;

    public static Region getRegion(String str) {
        for (Region region : getRegions()) {
            if (region.getName().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region getRegionByEndpoint(String str) {
        String host = getUriByEndpoint(str).getHost();
        for (Region region : getRegions()) {
            Iterator it = region.getServiceEndpoints().values().iterator();
            while (it.hasNext()) {
                if (getUriByEndpoint((String) it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public static synchronized List getRegions() {
        List list;
        synchronized (RegionUtils.class) {
            try {
                if (regions == null) {
                    init();
                }
                list = regions;
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public static synchronized List getRegionsForService(String str) {
        LinkedList linkedList;
        synchronized (RegionUtils.class) {
            linkedList = new LinkedList();
            for (Region region : getRegions()) {
                if (region.isServiceSupported(str)) {
                    linkedList.add(region);
                }
            }
        }
        return linkedList;
    }

    private static URI getUriByEndpoint(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI("http://" + str);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to parse service endpoint: " + e.getMessage());
        }
    }

    public static synchronized void init() {
        synchronized (RegionUtils.class) {
            if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
                try {
                    loadRegionsFromOverrideFile();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("Couldn't find regions override file specified", e);
                }
            }
            if (regions == null) {
                initSDKRegions();
            }
            if (regions == null) {
                throw new RuntimeException("Failed to initialize the regions.");
            }
        }
    }

    private static void initRegions(InputStream inputStream) {
        try {
            regions = new RegionMetadataParser().parseRegionMetadata(inputStream);
        } catch (Exception e) {
            log.warn("Failed to parse regional endpoints", e);
        }
    }

    private static void initSDKRegions() {
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Initializing the regions with default regions");
        }
        regions = RegionDefaults.getRegions();
    }

    private static void loadRegionsFromOverrideFile() throws FileNotFoundException {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        initRegions(new FileInputStream(new File(property)));
    }
}
