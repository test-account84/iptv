package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class NotificationConfiguration {
    private Filter filter;
    private Set events = new HashSet();

    @Deprecated
    private List objectPrefixes = new ArrayList();

    public NotificationConfiguration() {
    }

    public void addEvent(S3Event s3Event) {
        this.events.add(s3Event.toString());
    }

    @Deprecated
    public void addObjectPrefix(String str) {
        this.objectPrefixes.add(str);
    }

    public Set getEvents() {
        return this.events;
    }

    public Filter getFilter() {
        return this.filter;
    }

    @Deprecated
    public List getObjectPrefixes() {
        return this.objectPrefixes;
    }

    public void setEvents(Set set) {
        this.events = set;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Deprecated
    public void setObjectPrefixes(List list) {
        this.objectPrefixes = list;
    }

    public NotificationConfiguration withEvents(Set set) {
        this.events.clear();
        this.events.addAll(set);
        return this;
    }

    public NotificationConfiguration withFilter(Filter filter) {
        setFilter(filter);
        return this;
    }

    @Deprecated
    public NotificationConfiguration withObjectPrefixes(String... strArr) {
        this.objectPrefixes.clear();
        if (strArr != null && strArr.length > 0) {
            this.objectPrefixes.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public NotificationConfiguration(EnumSet enumSet) {
        if (enumSet != null) {
            Iterator it = enumSet.iterator();
            while (it.hasNext()) {
                this.events.add(((S3Event) it.next()).toString());
            }
        }
    }

    public void addEvent(String str) {
        this.events.add(str);
    }

    public NotificationConfiguration(String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                this.events.add(str);
            }
        }
    }
}
