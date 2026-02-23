package com.amplifyframework.core.category;

import com.amplifyframework.core.InitializationResult;
import com.amplifyframework.core.InitializationStatus;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CategoryInitializationResult {
    private final InitializationStatus initializationStatus;
    private final Map pluginInitializationResults;

    public interface PluginCriteria {
        boolean appliesTo(Object obj);
    }

    private CategoryInitializationResult(InitializationStatus initializationStatus, Map map) {
        this.initializationStatus = initializationStatus;
        this.pluginInitializationResults = map;
    }

    public static /* synthetic */ boolean a(Map.Entry entry) {
        return lambda$getSuccessfulPlugins$1(entry);
    }

    private static boolean anyFailed(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (((InitializationResult) it.next()).isFailure()) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean b(Map.Entry entry) {
        return lambda$getFailedPlugins$0(entry);
    }

    public static CategoryInitializationResult failure() {
        return new CategoryInitializationResult(InitializationStatus.FAILED, Collections.emptyMap());
    }

    private Set filterPluginResults(PluginCriteria pluginCriteria) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : this.pluginInitializationResults.entrySet()) {
            if (pluginCriteria.appliesTo(entry)) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    private static /* synthetic */ boolean lambda$getFailedPlugins$0(Map.Entry entry) {
        return ((InitializationResult) entry.getValue()).isFailure();
    }

    private static /* synthetic */ boolean lambda$getSuccessfulPlugins$1(Map.Entry entry) {
        return ((InitializationResult) entry.getValue()).isSuccess();
    }

    public static CategoryInitializationResult with(Map map) {
        Objects.requireNonNull(map);
        return new CategoryInitializationResult(anyFailed(map) ? InitializationStatus.FAILED : InitializationStatus.SUCCEEDED, map);
    }

    public Set getFailedPlugins() {
        return filterPluginResults(new a());
    }

    public InitializationStatus getInitializationStatus() {
        return this.initializationStatus;
    }

    public Map getPluginInitializationFailures() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.pluginInitializationResults.entrySet()) {
            Throwable failure = ((InitializationResult) entry.getValue()).getFailure();
            String str = (String) entry.getKey();
            if (failure != null) {
                hashMap.put(str, failure);
            }
        }
        return Immutable.of((Map) hashMap);
    }

    public Set getSuccessfulPlugins() {
        return filterPluginResults(new b());
    }

    public boolean isFailure() {
        return InitializationStatus.FAILED.equals(this.initializationStatus);
    }

    public boolean isSuccess() {
        return InitializationStatus.SUCCEEDED.equals(this.initializationStatus);
    }
}
