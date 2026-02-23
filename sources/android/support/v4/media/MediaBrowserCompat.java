package android.support.v4.media;

import D.g;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static MediaDescription getDescription(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        public static int getFlags(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    public static class CallbackHandler extends Handler {
        private final WeakReference mCallbackImplRef;
        private WeakReference mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference(mediaBrowserServiceCallbackImpl);
        }

        public void handleMessage(Message message) {
            WeakReference weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.ensureClassLoader(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) this.mCallbackImplRef.get();
            Messenger messenger = (Messenger) this.mCallbacksMessengerRef.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        public void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference(messenger);
        }
    }

    public static class ConnectionCallback {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new ConnectionCallbackApi21();
        ConnectionCallbackInternal mConnectionCallbackInternal;

        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        public CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                return;
            }
            Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
        }
    }

    public static abstract class ItemCallback {
        final MediaBrowser.ItemCallback mItemCallbackFwk;

        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            public void onError(String str) {
                ItemCallback.this.onError(str);
            }

            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(mediaItem));
            }
        }

        public ItemCallback() {
            this.mItemCallbackFwk = Build.VERSION.SDK_INT >= 23 ? new ItemCallbackApi23() : null;
        }

        public void onError(String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        public ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.mCallback.onItemLoaded((MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String str, Bundle bundle, SearchCallback searchCallback);

        void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback);

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final MediaBrowser mBrowserFwk;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private final s.a mSubscriptions = new s.a();

        public class 1 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public 1(ItemCallback itemCallback, String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public 2(ItemCallback itemCallback, String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public 3(ItemCallback itemCallback, String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        public class 4 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public 4(SearchCallback searchCallback, String str, Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        public class 5 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public 5(SearchCallback searchCallback, String str, Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        public class 6 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public 6(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        public class 7 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public 7(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.mContext = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.mRootHints = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, bundle2);
        }

        public void connect() {
            this.mBrowserFwk.connect();
        }

        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.mBrowserFwk.disconnect();
        }

        public Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        public void getItem(String str, ItemCallback itemCallback) {
            CallbackHandler callbackHandler;
            Runnable runnable;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.mBrowserFwk.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                callbackHandler = this.mHandler;
                runnable = new 1(itemCallback, str);
            } else {
                if (this.mServiceBinderWrapper != null) {
                    try {
                        this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                        this.mHandler.post(new 3(itemCallback, str));
                        return;
                    }
                }
                callbackHandler = this.mHandler;
                runnable = new 2(itemCallback, str);
            }
            callbackHandler.post(runnable);
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        public String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        public ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        public void onConnected() {
            try {
                Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt("extra_service_version", 0);
                IBinder a = g.a(extras, "extra_messenger");
                if (a != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(a, this.mRootHints);
                    Messenger messenger = new Messenger(this.mHandler);
                    this.mCallbacksMessenger = messenger;
                    this.mHandler.setCallbacksMessenger(messenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IMediaSession asInterface = IMediaSession.Stub.asInterface(g.a(extras, "extra_session_binder"));
                if (asInterface != null) {
                    this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), asInterface);
                }
            } catch (IllegalStateException e) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    } else {
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list);
                    }
                } else if (list == null) {
                    callback.onError(str, bundle);
                    return;
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                }
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void search(String str, Bundle bundle, SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                this.mHandler.post(new 4(searchCallback, str, bundle));
                return;
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                this.mHandler.post(new 5(searchCallback, str, bundle));
            }
        }

        public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                if (customActionCallback != null) {
                    this.mHandler.post(new 6(customActionCallback, str, bundle));
                }
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (customActionCallback != null) {
                    this.mHandler.post(new 7(customActionCallback, str, bundle));
                }
            }
        }

        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void unsubscribe(java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
            /*
                r7 = this;
                s.a r0 = r7.mSubscriptions
                java.lang.Object r0 = r0.get(r8)
                android.support.v4.media.MediaBrowserCompat$Subscription r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0
                if (r0 != 0) goto Lb
                return
            Lb:
                android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper r1 = r7.mServiceBinderWrapper
                if (r1 != 0) goto L3d
                if (r9 != 0) goto L17
            L11:
                android.media.browse.MediaBrowser r1 = r7.mBrowserFwk
                r1.unsubscribe(r8)
                goto L84
            L17:
                java.util.List r1 = r0.getCallbacks()
                java.util.List r2 = r0.getOptionsList()
                int r3 = r1.size()
                int r3 = r3 + (-1)
            L25:
                if (r3 < 0) goto L36
                java.lang.Object r4 = r1.get(r3)
                if (r4 != r9) goto L33
                r1.remove(r3)
                r2.remove(r3)
            L33:
                int r3 = r3 + (-1)
                goto L25
            L36:
                int r1 = r1.size()
                if (r1 != 0) goto L84
                goto L11
            L3d:
                if (r9 != 0) goto L46
                android.os.Messenger r2 = r7.mCallbacksMessenger     // Catch: android.os.RemoteException -> L6e
                r3 = 0
                r1.removeSubscription(r8, r3, r2)     // Catch: android.os.RemoteException -> L6e
                goto L84
            L46:
                java.util.List r1 = r0.getCallbacks()     // Catch: android.os.RemoteException -> L6e
                java.util.List r2 = r0.getOptionsList()     // Catch: android.os.RemoteException -> L6e
                int r3 = r1.size()     // Catch: android.os.RemoteException -> L6e
                int r3 = r3 + (-1)
            L54:
                if (r3 < 0) goto L84
                java.lang.Object r4 = r1.get(r3)     // Catch: android.os.RemoteException -> L6e
                if (r4 != r9) goto L6b
                android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper r4 = r7.mServiceBinderWrapper     // Catch: android.os.RemoteException -> L6e
                android.os.IBinder r5 = r9.mToken     // Catch: android.os.RemoteException -> L6e
                android.os.Messenger r6 = r7.mCallbacksMessenger     // Catch: android.os.RemoteException -> L6e
                r4.removeSubscription(r8, r5, r6)     // Catch: android.os.RemoteException -> L6e
                r1.remove(r3)     // Catch: android.os.RemoteException -> L6e
                r2.remove(r3)     // Catch: android.os.RemoteException -> L6e
            L6b:
                int r3 = r3 + (-1)
                goto L54
            L6e:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "removeSubscription failed with RemoteException parentId="
                r1.append(r2)
                r1.append(r8)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "MediaBrowserCompat"
                android.util.Log.d(r2, r1)
            L84:
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L8c
                if (r9 != 0) goto L91
            L8c:
                s.a r9 = r7.mSubscriptions
                r9.remove(r8)
            L91:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.unsubscribe(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void onConnectionFailed(Messenger messenger) {
        }
    }

    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void getItem(String str, ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                a.a(this.mBrowserFwk, str, itemCallback.mItemCallbackFwk);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            } else {
                b.a(this.mBrowserFwk, str, bundle, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }

        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                c.a(this.mBrowserFwk, str, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private final s.a mSubscriptions = new s.a();
        int mState = 1;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                boolean z;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mState == 0) {
                    return;
                }
                mediaBrowserImplBase.mState = 2;
                if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                    throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                }
                if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                }
                if (mediaBrowserImplBase.mCallbacksMessenger != null) {
                    throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                }
                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                mediaBrowserImplBase2.mServiceConnection = mediaBrowserImplBase2.new MediaServiceConnection();
                try {
                    MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                    z = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
                } catch (Exception unused) {
                    Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                    z = false;
                }
                if (!z) {
                    MediaBrowserImplBase.this.forceCloseConnection();
                    MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                }
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "connect...");
                    MediaBrowserImplBase.this.dump();
                }
            }
        }

        public class 2 implements Runnable {
            public 2() {
            }

            public void run() {
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                if (messenger != null) {
                    try {
                        mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                    } catch (RemoteException unused) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                    }
                }
                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                int i = mediaBrowserImplBase2.mState;
                mediaBrowserImplBase2.forceCloseConnection();
                if (i != 0) {
                    MediaBrowserImplBase.this.mState = i;
                }
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "disconnect...");
                    MediaBrowserImplBase.this.dump();
                }
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public 3(ItemCallback itemCallback, String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        public class 4 implements Runnable {
            final /* synthetic */ ItemCallback val$cb;
            final /* synthetic */ String val$mediaId;

            public 4(ItemCallback itemCallback, String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        public class 5 implements Runnable {
            final /* synthetic */ SearchCallback val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            public 5(SearchCallback searchCallback, String str, Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        public class 6 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ CustomActionCallback val$callback;
            final /* synthetic */ Bundle val$extras;

            public 6(CustomActionCallback customActionCallback, String str, Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        public class MediaServiceConnection implements ServiceConnection {

            public class 1 implements Runnable {
                final /* synthetic */ IBinder val$binder;
                final /* synthetic */ ComponentName val$name;

                public 1(ComponentName componentName, IBinder iBinder) {
                    this.val$name = componentName;
                    this.val$binder = iBinder;
                }

                public void run() {
                    boolean z = MediaBrowserCompat.DEBUG;
                    if (z) {
                        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.val$name + " binder=" + this.val$binder);
                        MediaBrowserImplBase.this.dump();
                    }
                    if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(this.val$binder, mediaBrowserImplBase.mRootHints);
                        MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                        MediaBrowserImplBase.this.mState = 2;
                        if (z) {
                            try {
                                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            } catch (RemoteException unused) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                    return;
                                }
                                return;
                            }
                        }
                        MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
                    }
                }
            }

            public class 2 implements Runnable {
                final /* synthetic */ ComponentName val$name;

                public 2(ComponentName componentName) {
                    this.val$name = componentName;
                }

                public void run() {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.val$name + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                        MediaBrowserImplBase.this.dump();
                    }
                    if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = null;
                        mediaBrowserImplBase.mCallbacksMessenger = null;
                        mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mState = 4;
                        mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                    }
                }
            }

            public MediaServiceConnection() {
            }

            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            public boolean isCurrent(String str) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this && (i = mediaBrowserImplBase.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = mediaBrowserImplBase.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                return false;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                postOrRun(new 1(componentName, iBinder));
            }

            public void onServiceDisconnected(ComponentName componentName) {
                postOrRun(new 2(componentName));
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = componentName;
            this.mCallback = connectionCallback;
            this.mRootHints = bundle == null ? null : new Bundle(bundle);
        }

        private static String getStateLabel(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i;
        }

        private boolean isCurrent(Messenger messenger, String str) {
            int i;
            if (this.mCallbacksMessenger == messenger && (i = this.mState) != 0 && i != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        }

        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new 1());
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
        }

        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new 2());
        }

        public void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
            Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        public void getItem(String str, ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new 3(itemCallback, str));
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                this.mHandler.post(new 4(itemCallback, str));
            }
        }

        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        public boolean isConnected() {
            return this.mState == 3;
        }

        public void onConnectionFailed(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState == 2) {
                    forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                    return;
                }
                Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            }
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.DEBUG;
                if (z) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + str);
                }
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (z) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        } else {
                            this.mNotifyChildrenChangedOptions = bundle2;
                            callback.onChildrenLoaded(str, list);
                        }
                    } else if (list == null) {
                        callback.onError(str, bundle);
                        return;
                    } else {
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list, bundle);
                    }
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (Map.Entry entry : this.mSubscriptions.entrySet()) {
                        String str2 = (String) entry.getKey();
                        Subscription subscription = (Subscription) entry.getValue();
                        List callbacks = subscription.getCallbacks();
                        List optionsList = subscription.getOptionsList();
                        for (int i = 0; i < callbacks.size(); i++) {
                            this.mServiceBinderWrapper.addSubscription(str2, ((SubscriptionCallback) callbacks.get(i)).mToken, (Bundle) optionsList.get(i), this.mCallbacksMessenger);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        public void search(String str, Bundle bundle, SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                this.mHandler.post(new 5(searchCallback, str, bundle));
            }
        }

        public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (customActionCallback != null) {
                    this.mHandler.post(new 6(customActionCallback, str, bundle));
                }
            }
        }

        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback != null) {
                    List callbacks = subscription.getCallbacks();
                    List optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                }
            } catch (RemoteException unused) {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator CREATOR = new 1();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        public class 1 implements Parcelable.Creator {
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        }

        public MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(mediaItem)), Api21Impl.getFlags(mediaItem));
        }

        public static List fromMediaItemList(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i;
            this.mDescription = mediaDescriptionCompat;
        }
    }

    public static abstract class SearchCallback {
        public void onError(String str, Bundle bundle) {
        }

        public void onSearchResult(String str, Bundle bundle, List list) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        public SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            if (parcelableArray == null) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            List arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            g.b(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            sendRequest(3, bundle2, messenger);
        }

        public void connect(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        public void disconnect(Messenger messenger) throws RemoteException {
            sendRequest(2, null, messenger);
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", str);
            bundle.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        public void registerCallbackMessenger(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        public void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", str);
            g.b(bundle, "data_callback_token", iBinder);
            sendRequest(4, bundle, messenger);
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_search_query", str);
            bundle2.putBundle("data_search_extras", bundle);
            bundle2.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_custom_action", str);
            bundle2.putBundle("data_custom_action_extras", bundle);
            bundle2.putParcelable("data_result_receiver", resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        public void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
            sendRequest(7, null, messenger);
        }
    }

    public static class Subscription {
        private final List mCallbacks = new ArrayList();
        private final List mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle bundle) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (q0.a.a((Bundle) this.mOptionsList.get(i), bundle)) {
                    return (SubscriptionCallback) this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public List getCallbacks() {
            return this.mCallbacks;
        }

        public List getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (q0.a.a((Bundle) this.mOptionsList.get(i), bundle)) {
                    this.mCallbacks.set(i, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        WeakReference mSubscriptionRef;
        final IBinder mToken = new Binder();

        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public List applyOptions(List list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }

            public void onChildrenLoaded(String str, List list) {
                WeakReference weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : (Subscription) weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List fromMediaItemList = MediaItem.fromMediaItemList(list);
                List callbacks = subscription.getCallbacks();
                List optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = (Bundle) optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            public void onError(String str) {
                SubscriptionCallback.this.onError(str);
            }
        }

        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            public void onChildrenLoaded(String str, List list, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            public void onError(String str, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            this.mSubscriptionCallbackFwk = Build.VERSION.SDK_INT >= 26 ? new SubscriptionCallbackApi26() : new SubscriptionCallbackApi21();
        }

        public void onChildrenLoaded(String str, List list) {
        }

        public void onError(String str) {
        }

        public void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference(subscription);
        }

        public void onChildrenLoaded(String str, List list, Bundle bundle) {
        }

        public void onError(String str, Bundle bundle) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        this.mImpl = i >= 26 ? new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle) : i >= 23 ? new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle) : new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
    }

    public void connect() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(String str, ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(String str, Bundle bundle, SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(str, bundle, searchCallback);
    }

    public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(str, bundle, subscriptionCallback);
    }

    public void unsubscribe(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(str, null, subscriptionCallback);
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.unsubscribe(str, subscriptionCallback);
    }
}
