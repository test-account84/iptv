package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.ConnectivityWatcher;
import com.amazonaws.mobileconnectors.appsync.retry.RetryInterceptor;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONException;
import org.json.JSONObject;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class WebSocketConnectionManager {
    private static final int MSG_RECONNECT = 0;
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    private static final String TAG = "com.amazonaws.mobileconnectors.appsync.WebSocketConnectionManager";
    private final ApolloResponseBuilder apolloResponseBuilder;
    private final Context applicationContext;
    private final String serverUrl;
    private final SubscriptionAuthorizer subscriptionAuthorizer;
    private final boolean subscriptionsAutoReconnect;
    private WebSocket websocket;
    private HandlerThread reconnectThread = null;
    private Handler reconnectHandler = null;
    private ConnectivityWatcher connectivityWatcher = null;
    private final Object reconnectionLock = new Object();
    private int reconnectionCount = 0;
    private final Map subscriptions = new ConcurrentHashMap();
    private final TimeoutWatchdog watchdog = new TimeoutWatchdog();

    public class 1 extends WebSocketListener {
        public 1() {
        }

        public void onClosing(WebSocket webSocket, int i, String str) {
            webSocket.close(1000, (String) null);
            WebSocketConnectionManager.access$500(WebSocketConnectionManager.this);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (WebSocketConnectionManager.access$000(WebSocketConnectionManager.this)) {
                WebSocketConnectionManager.access$600(WebSocketConnectionManager.this);
            }
            WebSocketConnectionManager.access$700(WebSocketConnectionManager.this, th);
        }

        public void onMessage(WebSocket webSocket, String str) {
            WebSocketConnectionManager webSocketConnectionManager = WebSocketConnectionManager.this;
            WebSocketConnectionManager.access$400(webSocketConnectionManager, WebSocketConnectionManager.access$200(webSocketConnectionManager), str);
        }

        public void onOpen(WebSocket webSocket, Response response) {
            if (WebSocketConnectionManager.access$000(WebSocketConnectionManager.this)) {
                WebSocketConnectionManager.access$100(WebSocketConnectionManager.this);
            }
            WebSocketConnectionManager webSocketConnectionManager = WebSocketConnectionManager.this;
            WebSocketConnectionManager.access$300(webSocketConnectionManager, WebSocketConnectionManager.access$200(webSocketConnectionManager));
        }
    }

    public class 2 implements Handler.Callback {
        public 2() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            WebSocketConnectionManager.access$800(WebSocketConnectionManager.this);
            return true;
        }
    }

    public class 3 implements ConnectivityWatcher.Callback {
        public 3() {
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                WebSocketConnectionManager.access$900(WebSocketConnectionManager.this);
            }
        }
    }

    public static /* synthetic */ class 4 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType = iArr;
            try {
                iArr[MessageType.CONNECTION_ACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[MessageType.SUBSCRIPTION_ACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[MessageType.SUBSCRIPTION_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[MessageType.KEEP_ALIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[MessageType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[MessageType.DATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum MessageType {
        KEEP_ALIVE("ka"),
        CONNECTION_ACK("connection_ack"),
        SUBSCRIPTION_COMPLETED("complete"),
        SUBSCRIPTION_ACK("start_ack"),
        ERROR("error"),
        DATA("data");

        private final String messageType;

        MessageType(String str) {
            this.messageType = str;
        }

        public static MessageType fromString(String str) {
            for (MessageType messageType : values()) {
                if (messageType.toString().equals(str)) {
                    return messageType;
                }
            }
            throw new IllegalArgumentException("Invalid message type string");
        }

        public String toString() {
            return this.messageType;
        }
    }

    public static final class SubscriptionResponseDispatcher {
        private final ApolloResponseBuilder apolloResponseBuilder;
        private final AppSyncSubscriptionCall.Callback callback;
        private final t subscription;

        public SubscriptionResponseDispatcher(t tVar, AppSyncSubscriptionCall.Callback callback, ApolloResponseBuilder apolloResponseBuilder) {
            this.subscription = tVar;
            this.callback = callback;
            this.apolloResponseBuilder = apolloResponseBuilder;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SubscriptionResponseDispatcher.class != obj.getClass()) {
                return false;
            }
            SubscriptionResponseDispatcher subscriptionResponseDispatcher = (SubscriptionResponseDispatcher) obj;
            if (getSubscription() == null ? subscriptionResponseDispatcher.getSubscription() == null : getSubscription().equals(subscriptionResponseDispatcher.getSubscription())) {
                return getCallback() != null ? getCallback().equals(subscriptionResponseDispatcher.getCallback()) : subscriptionResponseDispatcher.getCallback() == null;
            }
            return false;
        }

        public AppSyncSubscriptionCall.Callback getCallback() {
            return this.callback;
        }

        public t getSubscription() {
            return this.subscription;
        }

        public int hashCode() {
            return ((getSubscription() != null ? getSubscription().hashCode() : 0) * 31) + (getCallback() != null ? getCallback().hashCode() : 0);
        }

        public void invokeResponseCallback(String str) {
            this.callback.onResponse(this.apolloResponseBuilder.buildResponse(str, this.subscription));
        }
    }

    public WebSocketConnectionManager(Context context, String str, SubscriptionAuthorizer subscriptionAuthorizer, ApolloResponseBuilder apolloResponseBuilder, boolean z) {
        this.applicationContext = context.getApplicationContext();
        this.serverUrl = str;
        this.subscriptionAuthorizer = subscriptionAuthorizer;
        this.apolloResponseBuilder = apolloResponseBuilder;
        this.subscriptionsAutoReconnect = z;
    }

    public static /* synthetic */ boolean access$000(WebSocketConnectionManager webSocketConnectionManager) {
        return webSocketConnectionManager.subscriptionsAutoReconnect;
    }

    public static /* synthetic */ void access$100(WebSocketConnectionManager webSocketConnectionManager) {
        webSocketConnectionManager.reportSuccessfulConnection();
    }

    public static /* synthetic */ WebSocket access$200(WebSocketConnectionManager webSocketConnectionManager) {
        return webSocketConnectionManager.websocket;
    }

    public static /* synthetic */ void access$300(WebSocketConnectionManager webSocketConnectionManager, WebSocket webSocket) {
        webSocketConnectionManager.sendConnectionInit(webSocket);
    }

    public static /* synthetic */ void access$400(WebSocketConnectionManager webSocketConnectionManager, WebSocket webSocket, String str) {
        webSocketConnectionManager.processMessage(webSocket, str);
    }

    public static /* synthetic */ void access$500(WebSocketConnectionManager webSocketConnectionManager) {
        webSocketConnectionManager.notifyAllSubscriptionsCompleted();
    }

    public static /* synthetic */ void access$600(WebSocketConnectionManager webSocketConnectionManager) {
        webSocketConnectionManager.scheduleReconnect();
    }

    public static /* synthetic */ void access$700(WebSocketConnectionManager webSocketConnectionManager, Throwable th) {
        webSocketConnectionManager.notifyFailure(th);
    }

    public static /* synthetic */ void access$800(WebSocketConnectionManager webSocketConnectionManager) {
        webSocketConnectionManager.retryAllSubscriptions();
    }

    public static /* synthetic */ void access$900(WebSocketConnectionManager webSocketConnectionManager) {
        webSocketConnectionManager.reportNetworkUp();
    }

    private WebSocket createWebSocket() {
        try {
            WebSocket newWebSocket = new OkHttpClient.Builder().retryOnConnectionFailure(true).build().newWebSocket(new Request.Builder().url(getConnectionRequestUrl()).addHeader("Sec-WebSocket-Protocol", "graphql-ws").build(), new 1());
            this.websocket = newWebSocket;
            return newWebSocket;
        } catch (JSONException e) {
            throw new RuntimeException("Failed to get connection url : ", e);
        }
    }

    private String getConnectionRequestUrl() throws JSONException {
        URL url;
        byte[] bytes = this.subscriptionAuthorizer.getConnectionAuthorizationDetails().toString().getBytes();
        try {
            url = new URL(this.serverUrl);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null) {
            throw new RuntimeException("Malformed Api Url: " + this.serverUrl);
        }
        DomainType from = DomainType.from(this.serverUrl);
        String host = url.getHost();
        if (from == DomainType.STANDARD) {
            host = host.replace("appsync-api", "appsync-realtime-api");
        }
        String path = url.getPath();
        if (from == DomainType.CUSTOM) {
            path = path + "/realtime";
        }
        return new Uri.Builder().scheme("wss").authority(host).appendPath(path).appendQueryParameter("header", Base64.encodeToString(bytes, 0)).appendQueryParameter("payload", "e30=").build().toString();
    }

    private void notifyAllSubscriptionsCompleted() {
        Iterator it = new HashSet(this.subscriptions.values()).iterator();
        while (it.hasNext()) {
            ((SubscriptionResponseDispatcher) it.next()).getCallback().onCompleted();
        }
    }

    private void notifyFailure(Throwable th) {
        Iterator it = new HashSet(this.subscriptions.values()).iterator();
        while (it.hasNext()) {
            ((SubscriptionResponseDispatcher) it.next()).getCallback().onFailure(new b("Subscription failed.", th));
        }
    }

    private void notifySubscriptionCompleted(String str) {
        SubscriptionResponseDispatcher subscriptionResponseDispatcher = (SubscriptionResponseDispatcher) this.subscriptions.get(str);
        if (subscriptionResponseDispatcher != null) {
            subscriptionResponseDispatcher.getCallback().onCompleted();
        }
    }

    private void notifySubscriptionData(String str, String str2) {
        SubscriptionResponseDispatcher subscriptionResponseDispatcher = (SubscriptionResponseDispatcher) this.subscriptions.get(str);
        if (subscriptionResponseDispatcher != null) {
            subscriptionResponseDispatcher.invokeResponseCallback(str2);
        }
    }

    private void notifySubscriptionStarted(String str) {
        SubscriptionResponseDispatcher subscriptionResponseDispatcher = (SubscriptionResponseDispatcher) this.subscriptions.get(str);
        if (subscriptionResponseDispatcher != null) {
            AppSyncSubscriptionCall.Callback callback = subscriptionResponseDispatcher.getCallback();
            if (callback instanceof AppSyncSubscriptionCall.StartedCallback) {
                ((AppSyncSubscriptionCall.StartedCallback) callback).onStarted();
            }
        }
    }

    private void processJsonMessage(WebSocket webSocket, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        MessageType fromString = MessageType.fromString(jSONObject.getString("type"));
        switch (4.$SwitchMap$com$amazonaws$mobileconnectors$appsync$WebSocketConnectionManager$MessageType[fromString.ordinal()]) {
            case 1:
                this.watchdog.start(webSocket, Integer.parseInt(jSONObject.getJSONObject("payload").getString("connectionTimeoutMs")));
                break;
            case 2:
                notifySubscriptionStarted(jSONObject.getString("id"));
                Log.d(TAG, "Subscription created with id = " + jSONObject.getString("id"));
                break;
            case 3:
                notifySubscriptionCompleted(jSONObject.getString("id"));
                break;
            case 4:
                this.watchdog.reset();
                break;
            case 5:
            case 6:
                notifySubscriptionData(jSONObject.getString("id"), jSONObject.getString("payload"));
                break;
            default:
                notifyFailure(new b("Got unknown message type: " + fromString));
                break;
        }
    }

    private void processMessage(WebSocket webSocket, String str) {
        try {
            processJsonMessage(webSocket, str);
        } catch (JSONException e) {
            notifyFailure(e);
        }
    }

    private void reportNetworkUp() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionCount == 0) {
                    return;
                }
                Log.v(TAG, "Network is up. Trying to reconnect immediately.");
                this.reconnectHandler.removeMessages(0);
                this.reconnectHandler.sendEmptyMessage(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void reportSuccessfulConnection() {
        synchronized (this.reconnectionLock) {
            try {
                if (this.reconnectionCount == 0) {
                    return;
                }
                Log.v(TAG, "Successful connection reported!");
                this.connectivityWatcher.unregister();
                this.connectivityWatcher = null;
                this.reconnectThread.quit();
                this.reconnectThread = null;
                this.reconnectHandler = null;
                this.reconnectionCount = 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void retryAllSubscriptions() {
        WebSocket webSocket = this.websocket;
        if (webSocket != null) {
            webSocket.cancel();
        }
        try {
            createWebSocket();
            for (Map.Entry entry : this.subscriptions.entrySet()) {
                SubscriptionResponseDispatcher subscriptionResponseDispatcher = (SubscriptionResponseDispatcher) entry.getValue();
                startSubscription(subscriptionResponseDispatcher.getSubscription(), subscriptionResponseDispatcher.getCallback(), (String) entry.getKey());
            }
        } catch (AmazonClientException e) {
            Log.v(TAG, "Failed to create WebSocket: " + e);
            scheduleReconnect();
        }
    }

    private void scheduleReconnect() {
        synchronized (this.reconnectionLock) {
            try {
                Handler handler = this.reconnectHandler;
                if (handler == null || !handler.hasMessages(0)) {
                    if (this.reconnectionCount == 0) {
                        HandlerThread handlerThread = new HandlerThread("AWSAppSyncWebSocketReconnectionThread");
                        this.reconnectThread = handlerThread;
                        handlerThread.start();
                        this.reconnectHandler = new Handler(this.reconnectThread.getLooper(), new 2());
                        3 r1 = new 3();
                        ConnectivityWatcher connectivityWatcher = this.connectivityWatcher;
                        if (connectivityWatcher == null) {
                            this.connectivityWatcher = new ConnectivityWatcher(this.applicationContext, r1);
                        } else {
                            connectivityWatcher.unregister();
                        }
                        this.connectivityWatcher.register();
                    }
                    int i = this.reconnectionCount + 1;
                    this.reconnectionCount = i;
                    int calculateBackoff = RetryInterceptor.calculateBackoff(i);
                    Log.v(TAG, "Scheduling reconnection after [" + calculateBackoff + "] ms.");
                    this.reconnectHandler.sendEmptyMessageDelayed(0, (long) calculateBackoff);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void sendConnectionInit(WebSocket webSocket) {
        try {
            webSocket.send(new JSONObject().put("type", "connection_init").toString());
        } catch (JSONException e) {
            notifyFailure(e);
        }
    }

    private synchronized void startSubscription(t tVar, AppSyncSubscriptionCall.Callback callback, String str) {
        try {
            if (!this.websocket.send(new JSONObject().put("id", str).put("type", "start").put("payload", new JSONObject().put("data", new JSONObject().put("query", tVar.queryDocument()).put("variables", new JSONObject(tVar.variables().valueMap())).toString()).put("extensions", new JSONObject().put("authorization", this.subscriptionAuthorizer.getAuthorizationDetails(false, tVar)))).toString())) {
                callback.onFailure(new b("WebSocket communication failed."));
            }
        } catch (JSONException e) {
            throw new RuntimeException("Failed to construct subscription registration message.", e);
        }
    }

    public synchronized void releaseSubscription(String str) {
        if (!this.subscriptions.containsKey(str)) {
            throw new IllegalArgumentException("No existing subscription with the given id.");
        }
        try {
            this.websocket.send(new JSONObject().put("type", "stop").put("id", str).toString());
            this.subscriptions.remove(str);
            if (this.subscriptions.size() == 0) {
                this.watchdog.stop();
                this.websocket.close(1000, "No active subscriptions");
                this.websocket = null;
            }
        } catch (JSONException e) {
            throw new RuntimeException("Failed to construct subscription release message.", e);
        }
    }

    public synchronized String requestSubscription(t tVar, AppSyncSubscriptionCall.Callback callback) {
        String uuid;
        try {
            if (this.websocket == null) {
                this.websocket = createWebSocket();
            }
            uuid = UUID.randomUUID().toString();
            startSubscription(tVar, callback, uuid);
            this.subscriptions.put(uuid, new SubscriptionResponseDispatcher(tVar, callback, this.apolloResponseBuilder));
        } catch (Throwable th) {
            throw th;
        }
        return uuid;
    }
}
