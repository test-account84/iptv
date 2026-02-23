package com.amazonaws.mobileconnectors.appsync.subscription;

import F1.h;
import K1.d;
import L1.b;
import android.content.Context;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.retry.RetryInterceptor;
import com.amazonaws.mobileconnectors.appsync.subscription.SubscriptionResponse;
import com.amazonaws.mobileconnectors.appsync.subscription.mqtt.MqttSubscriptionClient;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import v1.t;
import z1.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RealSubscriptionManager implements b {
    private static final String TAG = "RealSubscriptionManager";
    private a apolloStore;
    private Context applicationContext;
    final List clients;
    private u1.a mApolloClient;
    private final SubscriptionCallback mainMessageCallback;
    private CountDownLatch reconnectCountdownLatch;
    Thread reconnectThread;
    boolean reconnectionInProgress;
    final Object reconnectionLock;
    private d scalarTypeAdapters;
    private boolean subscriptionsAutoReconnect;
    final Map subscriptionsById;
    private final Object subscriptionsByIdLock;
    final Map subscriptionsByTopic;
    private final Object subscriptionsByTopicLock;
    final Map topicConnectionMap;

    public class 1 implements SubscriptionClientCallback {
        final /* synthetic */ CountDownLatch val$allClientsConnectedLatch;
        final /* synthetic */ SubscriptionResponse.MqttInfo val$info;
        final /* synthetic */ MqttSubscriptionClient val$mqttClient;
        final /* synthetic */ List val$newClients;
        final /* synthetic */ Set val$topicSet;

        public 1(SubscriptionResponse.MqttInfo mqttInfo, Set set, MqttSubscriptionClient mqttSubscriptionClient, List list, CountDownLatch countDownLatch) {
            this.val$info = mqttInfo;
            this.val$topicSet = set;
            this.val$mqttClient = mqttSubscriptionClient;
            this.val$newClients = list;
            this.val$allClientsConnectedLatch = countDownLatch;
        }

        public void onConnect() {
            if (RealSubscriptionManager.access$000(RealSubscriptionManager.this)) {
                RealSubscriptionManager.this.reportSuccessfulConnection();
            }
            Log.v(RealSubscriptionManager.access$100(), String.format("Subscription Infrastructure: Connection successful for clientID [" + this.val$info.clientId + "]. Will subscribe up to %d topics", new Object[]{Integer.valueOf(this.val$info.topics.length)}));
            for (String str : this.val$info.topics) {
                if (this.val$topicSet.contains(str)) {
                    Log.v(RealSubscriptionManager.access$100(), String.format("Subscription Infrastructure: Subscribing to MQTT topic:[%s]", new Object[]{str}));
                    this.val$mqttClient.subscribe(str, 1, RealSubscriptionManager.access$200(RealSubscriptionManager.this));
                    RealSubscriptionManager.this.topicConnectionMap.put(str, this.val$mqttClient);
                }
            }
            this.val$newClients.add(this.val$mqttClient);
            this.val$allClientsConnectedLatch.countDown();
        }

        public void onError(Exception exc) {
            Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: onError called " + exc);
            if (RealSubscriptionManager.access$000(RealSubscriptionManager.this) && (exc instanceof SubscriptionDisconnectedException)) {
                Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Disconnect received. Unexpected - Initiating reconnect sequence.");
                RealSubscriptionManager.this.reportConnectionError();
                RealSubscriptionManager.this.initiateReconnectSequence();
                return;
            }
            for (String str : this.val$info.topics) {
                if (RealSubscriptionManager.access$300(RealSubscriptionManager.this, str) != null) {
                    Iterator it = RealSubscriptionManager.access$300(RealSubscriptionManager.this, str).iterator();
                    while (it.hasNext()) {
                        ((SubscriptionObject) it.next()).onFailure(new B1.b("Connection Error Reported", exc));
                    }
                }
            }
            this.val$allClientsConnectedLatch.countDown();
        }
    }

    public class 2 implements SubscriptionCallback {
        public 2() {
        }

        public void onError(String str, Exception exc) {
            Set<SubscriptionObject> access$300 = RealSubscriptionManager.access$300(RealSubscriptionManager.this, str);
            if (access$300 == null || access$300.size() == 0) {
                Log.w(RealSubscriptionManager.access$100(), "Subscription Infrastructure: No subscription objects found for topic [" + str + "]");
                return;
            }
            for (SubscriptionObject subscriptionObject : access$300) {
                subscriptionObject.onFailure(new B1.b("Subscription Infrastructure: onError called for Subscription [" + subscriptionObject + "]", exc));
            }
        }

        public void onMessage(String str, String str2) {
            Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Received message on topic [" + str + "]. Message is \n" + str2);
            Set<SubscriptionObject> access$300 = RealSubscriptionManager.access$300(RealSubscriptionManager.this, str);
            if (access$300 == null) {
                Log.w(RealSubscriptionManager.access$100(), "Subscription Infrastructure: No subscription objects found for topic [" + str + "]");
                return;
            }
            for (SubscriptionObject subscriptionObject : access$300) {
                Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Propagating message received on topic " + str + " to " + subscriptionObject.subscription);
                subscriptionObject.onMessage(str2);
            }
        }
    }

    public class 3 implements Runnable {
        public 3() {
        }

        public void run() {
            SubscriptionObject subscriptionObject;
            AppSyncSubscriptionCall.Callback callback;
            int i = 1;
            while (RealSubscriptionManager.this.reconnectionInProgress) {
                long calculateBackoff = RetryInterceptor.calculateBackoff(i);
                try {
                    Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Sleeping for [" + calculateBackoff + "] ms");
                    Thread.sleep(calculateBackoff);
                } catch (InterruptedException unused) {
                    Log.v(RealSubscriptionManager.access$100(), "SubscriptionInfrastructure: Thread.sleep was interrupted in the exponential backoff for reconnects");
                }
                synchronized (RealSubscriptionManager.access$400(RealSubscriptionManager.this)) {
                    try {
                        Iterator it = RealSubscriptionManager.this.subscriptionsById.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                subscriptionObject = null;
                                callback = null;
                                break;
                            } else {
                                subscriptionObject = (SubscriptionObject) it.next();
                                if (!subscriptionObject.isCancelled() && !subscriptionObject.getListeners().isEmpty()) {
                                    callback = (AppSyncSubscriptionCall.Callback) subscriptionObject.getListeners().iterator().next();
                                    break;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (subscriptionObject == null || callback == null) {
                    RealSubscriptionManager.this.reconnectionInProgress = false;
                } else {
                    Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Attempting to reconnect");
                    RealSubscriptionManager.access$502(RealSubscriptionManager.this, new CountDownLatch(1));
                    RealSubscriptionManager.access$600(RealSubscriptionManager.this).subscribe(subscriptionObject.subscription).execute(callback);
                    try {
                        RealSubscriptionManager.access$500(RealSubscriptionManager.this).await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException unused2) {
                        Log.v(RealSubscriptionManager.access$100(), "Subscription Infrastructure: Wait interrupted.");
                    }
                }
                i++;
            }
        }
    }

    public RealSubscriptionManager(Context context) {
        this(context, true);
    }

    public static /* synthetic */ boolean access$000(RealSubscriptionManager realSubscriptionManager) {
        return realSubscriptionManager.subscriptionsAutoReconnect;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ SubscriptionCallback access$200(RealSubscriptionManager realSubscriptionManager) {
        return realSubscriptionManager.mainMessageCallback;
    }

    public static /* synthetic */ Set access$300(RealSubscriptionManager realSubscriptionManager, String str) {
        return realSubscriptionManager.getSubscriptionObjectSetFromTopicMap(str);
    }

    public static /* synthetic */ Object access$400(RealSubscriptionManager realSubscriptionManager) {
        return realSubscriptionManager.subscriptionsByIdLock;
    }

    public static /* synthetic */ CountDownLatch access$500(RealSubscriptionManager realSubscriptionManager) {
        return realSubscriptionManager.reconnectCountdownLatch;
    }

    public static /* synthetic */ CountDownLatch access$502(RealSubscriptionManager realSubscriptionManager, CountDownLatch countDownLatch) {
        realSubscriptionManager.reconnectCountdownLatch = countDownLatch;
        return countDownLatch;
    }

    public static /* synthetic */ u1.a access$600(RealSubscriptionManager realSubscriptionManager) {
        return realSubscriptionManager.mApolloClient;
    }

    private void addSubscriptionObjectToTopic(String str, SubscriptionObject subscriptionObject) {
        synchronized (this.subscriptionsByTopicLock) {
            try {
                Set subscriptionObjectSetFromTopicMap = getSubscriptionObjectSetFromTopicMap(str);
                if (subscriptionObjectSetFromTopicMap == null) {
                    subscriptionObjectSetFromTopicMap = createSubscriptionsObjectSetinTopicMap(str);
                }
                subscriptionObjectSetFromTopicMap.add(subscriptionObject);
                Log.d(TAG, "Subscription Infrastructure: Adding subscription object " + subscriptionObject + " to topic " + str + ". Total subscription objects: " + subscriptionObjectSetFromTopicMap.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private SubscriptionObject createAndAddSubscriptionObjectToIdMap(t tVar) {
        SubscriptionObject subscriptionObject;
        synchronized (this.subscriptionsByIdLock) {
            try {
                subscriptionObject = (SubscriptionObject) this.subscriptionsById.get(tVar);
                if (subscriptionObject == null) {
                    subscriptionObject = new SubscriptionObject();
                    subscriptionObject.subscription = tVar;
                    this.subscriptionsById.put(tVar, subscriptionObject);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return subscriptionObject;
    }

    private Set createSubscriptionsObjectSetinTopicMap(String str) {
        HashSet hashSet;
        synchronized (this.subscriptionsByTopicLock) {
            try {
                hashSet = (HashSet) this.subscriptionsByTopic.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    this.subscriptionsByTopic.put(str, hashSet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashSet;
    }

    private SubscriptionObject getSubscriptionObjectFromIdMap(t tVar) {
        SubscriptionObject subscriptionObject;
        synchronized (this.subscriptionsByIdLock) {
            subscriptionObject = (SubscriptionObject) this.subscriptionsById.get(tVar);
        }
        return subscriptionObject;
    }

    private Set getSubscriptionObjectSetFromTopicMap(String str) {
        Set set;
        synchronized (this.subscriptionsByTopicLock) {
            set = (Set) this.subscriptionsByTopic.get(str);
        }
        return set;
    }

    private void removeSubscriptionObjectFromIdMap(SubscriptionObject subscriptionObject) {
        if (subscriptionObject == null || subscriptionObject.subscription == null) {
            return;
        }
        synchronized (this.subscriptionsByIdLock) {
            subscriptionObject.getTopics().clear();
            this.subscriptionsById.remove(subscriptionObject.subscription);
        }
    }

    private void removeUnusedTopics(Set set) {
        this.subscriptionsByTopic.keySet().retainAll(set);
    }

    public void addListener(t tVar, AppSyncSubscriptionCall.Callback callback) {
        synchronized (this.subscriptionsByIdLock) {
            try {
                SubscriptionObject subscriptionObjectFromIdMap = getSubscriptionObjectFromIdMap(tVar);
                if (subscriptionObjectFromIdMap == null) {
                    subscriptionObjectFromIdMap = createAndAddSubscriptionObjectToIdMap(tVar);
                }
                Log.v(TAG, "Subscription Infrastructure: Adding listener [" + callback.toString() + "] to SubscriptionObject: " + tVar + " got: " + subscriptionObjectFromIdMap.subscription);
                subscriptionObjectFromIdMap.addListener(callback);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void initiateReconnectSequence() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionInProgress) {
                    return;
                }
                this.reconnectionInProgress = true;
                Thread thread = new Thread(new 3());
                this.reconnectThread = thread;
                thread.start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeListener(t tVar, AppSyncSubscriptionCall.Callback callback) {
        synchronized (this.subscriptionsByIdLock) {
            try {
                SubscriptionObject subscriptionObjectFromIdMap = getSubscriptionObjectFromIdMap(tVar);
                if (subscriptionObjectFromIdMap == null) {
                    return;
                }
                subscriptionObjectFromIdMap.listeners.remove(callback);
                if (subscriptionObjectFromIdMap.listeners.size() == 0) {
                    Iterator it = subscriptionObjectFromIdMap.topics.iterator();
                    while (it.hasNext()) {
                        Set subscriptionObjectSetFromTopicMap = getSubscriptionObjectSetFromTopicMap(it.next().toString());
                        if (subscriptionObjectSetFromTopicMap != null) {
                            subscriptionObjectSetFromTopicMap.remove(subscriptionObjectFromIdMap);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reportConnectionError() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionInProgress) {
                    String str = TAG;
                    Log.v(str, "Subscription Infrastructure: Connection Error reported!");
                    if (this.reconnectCountdownLatch != null) {
                        Log.v(str, "Subscription Infrastructure: Counting down the latch");
                        this.reconnectCountdownLatch.countDown();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reportNetworkUp() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionInProgress) {
                    Thread thread = this.reconnectThread;
                    if (thread != null && Thread.State.TERMINATED != thread.getState()) {
                        Log.v(TAG, "Subscription Infrastructure: Network is up. Interrupting the thread for immediate reconnect.");
                        this.reconnectThread.interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reportSuccessfulConnection() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionInProgress) {
                    String str = TAG;
                    Log.v(str, "Subscription Infrastructure: Successful connection reported!");
                    this.reconnectionInProgress = false;
                    if (this.reconnectCountdownLatch != null) {
                        Log.v(str, "Subscription Infrastructure: Counting down the latch");
                        this.reconnectCountdownLatch.countDown();
                    }
                    Thread thread = this.reconnectThread;
                    if (thread != null && Thread.State.TERMINATED != thread.getState()) {
                        Log.v(str, "Subscription Infrastructure: Interrupting the thread.");
                        this.reconnectThread.interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setApolloClient(u1.a aVar) {
        this.mApolloClient = aVar;
    }

    public void setScalarTypeAdapters(d dVar) {
        this.scalarTypeAdapters = dVar;
    }

    public void setStore(a aVar) {
        this.apolloStore = aVar;
    }

    public synchronized void subscribe(t tVar, List list, SubscriptionResponse subscriptionResponse, h hVar) {
        try {
            Log.v(TAG, "Subscription Infrastructure: subscribe called for " + tVar);
            SubscriptionObject subscriptionObjectFromIdMap = getSubscriptionObjectFromIdMap(tVar);
            if (subscriptionObjectFromIdMap == null) {
                subscriptionObjectFromIdMap = createAndAddSubscriptionObjectToIdMap(tVar);
            }
            subscriptionObjectFromIdMap.subscription = tVar;
            subscriptionObjectFromIdMap.normalizer = hVar;
            subscriptionObjectFromIdMap.scalarTypeAdapters = this.scalarTypeAdapters;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                subscriptionObjectFromIdMap.topics.add(str);
                addSubscriptionObjectToTopic(str, subscriptionObjectFromIdMap);
            }
            CountDownLatch countDownLatch = new CountDownLatch(subscriptionResponse.mqttInfos.size());
            ArrayList arrayList = new ArrayList();
            Log.v(TAG, "Subscription Infrastructure: Attempting to make [" + subscriptionResponse.mqttInfos.size() + "] MQTT clients]");
            Set keySet = this.subscriptionsByTopic.keySet();
            this.topicConnectionMap.clear();
            try {
                Thread.sleep(1000L);
            } catch (Exception unused) {
                Log.v(TAG, "Subscription Infrastructure: Thread.sleep for server propagation delay was interrupted");
            }
            Iterator it2 = subscriptionResponse.mqttInfos.iterator();
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    try {
                        break;
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Subscription Infrastructure: Failed to wait for all clients to finish connecting.", e);
                    }
                }
                SubscriptionResponse.MqttInfo mqttInfo = (SubscriptionResponse.MqttInfo) it2.next();
                for (String str2 : mqttInfo.topics) {
                    if (keySet.contains(str2)) {
                        z = false;
                    }
                }
                if (z) {
                    countDownLatch.countDown();
                } else {
                    MqttSubscriptionClient mqttSubscriptionClient = new MqttSubscriptionClient(this.applicationContext, mqttInfo.wssURL, mqttInfo.clientId);
                    mqttSubscriptionClient.setTransmitting(false);
                    Log.v(TAG, "Subscription Infrastructure: Connecting with Client ID[" + mqttInfo.clientId + "]");
                    mqttSubscriptionClient.connect(new 1(mqttInfo, keySet, mqttSubscriptionClient, arrayList, countDownLatch));
                }
            }
            countDownLatch.await();
            String str3 = TAG;
            Log.v(str3, "Subscription Infrastructure: Made [" + arrayList.size() + "] MQTT clients");
            Log.v(str3, "Subscription Infrastructure: Unmuting the new clients [" + arrayList.size() + "] in total");
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((SubscriptionClient) it3.next()).setTransmitting(true);
            }
            Log.v(TAG, "Subscription Infrastructure: Muting the old clients [ " + this.clients.size() + "] in total");
            Iterator it4 = this.clients.iterator();
            while (it4.hasNext()) {
                ((SubscriptionClient) it4.next()).setTransmitting(false);
            }
            Log.v(TAG, "Subscription Infrastructure: Closing the old clients [" + this.clients.size() + "] in total");
            for (SubscriptionClient subscriptionClient : this.clients) {
                Log.v(TAG, "Subscription Infrastructure: Closing client: " + subscriptionClient);
                subscriptionClient.close();
            }
            this.clients.clear();
            this.clients.addAll(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void unsubscribe(t tVar) {
        try {
            SubscriptionObject subscriptionObjectFromIdMap = getSubscriptionObjectFromIdMap(tVar);
            if (subscriptionObjectFromIdMap == null) {
                return;
            }
            if (subscriptionObjectFromIdMap.isCancelled()) {
                return;
            }
            subscriptionObjectFromIdMap.setCancelled();
            for (Object obj : subscriptionObjectFromIdMap.getTopics()) {
                synchronized (this.subscriptionsByTopicLock) {
                    try {
                        Set subscriptionObjectSetFromTopicMap = getSubscriptionObjectSetFromTopicMap(obj.toString());
                        if (subscriptionObjectSetFromTopicMap != null) {
                            subscriptionObjectSetFromTopicMap.remove(subscriptionObjectFromIdMap);
                        }
                    } finally {
                    }
                }
            }
            removeSubscriptionObjectFromIdMap(subscriptionObjectFromIdMap);
            synchronized (this.subscriptionsByTopicLock) {
                try {
                    for (String str : this.subscriptionsByTopic.keySet()) {
                        Set subscriptionObjectSetFromTopicMap2 = getSubscriptionObjectSetFromTopicMap(str);
                        if (subscriptionObjectSetFromTopicMap2 == null || subscriptionObjectSetFromTopicMap2.size() <= 0) {
                            String str2 = TAG;
                            Log.v(str2, "Subscription Infrastructure: Number of SubscriptionObjects for topic [" + str + "] is 0. Unsubscribing at the MQTT Level...");
                            MqttSubscriptionClient mqttSubscriptionClient = (MqttSubscriptionClient) this.topicConnectionMap.get(str);
                            if (mqttSubscriptionClient != null) {
                                mqttSubscriptionClient.unsubscribe(str);
                                this.subscriptionsByTopic.remove(str);
                                if (mqttSubscriptionClient.getTopics() == null || mqttSubscriptionClient.getTopics().size() == 0) {
                                    Log.v(str2, "Subscription Infrastructure: MQTT Client has no active topics. Disconnecting...");
                                    mqttSubscriptionClient.close();
                                }
                            }
                        } else {
                            Log.v(TAG, "Subscription Infrastructure: SubscriptionObjects still exist for topic [" + str + "]. Will not unsubscribe at the MQTT level");
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public RealSubscriptionManager(Context context, boolean z) {
        this.mApolloClient = null;
        this.subscriptionsAutoReconnect = true;
        this.subscriptionsByIdLock = new Object();
        this.subscriptionsByTopicLock = new Object();
        this.mainMessageCallback = new 2();
        this.reconnectThread = null;
        this.reconnectionLock = new Object();
        this.reconnectionInProgress = false;
        this.reconnectCountdownLatch = null;
        this.applicationContext = context.getApplicationContext();
        this.subscriptionsById = new ConcurrentHashMap();
        this.subscriptionsByTopic = new ConcurrentHashMap();
        this.topicConnectionMap = new ConcurrentHashMap();
        this.clients = new ArrayList();
        this.subscriptionsAutoReconnect = z;
    }
}
