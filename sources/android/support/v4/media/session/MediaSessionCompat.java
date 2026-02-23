package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import q0.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";

    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;

    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public class 1 extends Callback {
        public 1() {
        }
    }

    public static abstract class Callback {
        CallbackHandler mCallbackHandler;
        private boolean mMediaPlayPausePendingOnHandler;
        final Object mLock = new Object();
        final MediaSession.Callback mCallbackFwk = new MediaSessionCallbackApi21();
        WeakReference mSessionImpl = new WeakReference((Object) null);

        public class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            public CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                Callback callback;
                CallbackHandler callbackHandler;
                if (message.what == 1) {
                    synchronized (Callback.this.mLock) {
                        mediaSessionImpl = (MediaSessionImpl) Callback.this.mSessionImpl.get();
                        callback = Callback.this;
                        callbackHandler = callback.mCallbackHandler;
                    }
                    if (mediaSessionImpl == null || callback != mediaSessionImpl.getCallback() || callbackHandler == null) {
                        return;
                    }
                    mediaSessionImpl.setCurrentControllerInfo((q0.b) message.obj);
                    Callback.this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                    mediaSessionImpl.setCurrentControllerInfo(null);
                }
            }
        }

        public class MediaSessionCallbackApi21 extends MediaSession.Callback {
            public MediaSessionCallbackApi21() {
            }

            private void clearCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                mediaSessionImpl.setCurrentControllerInfo(null);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.mLock) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.mSessionImpl.get();
                }
                if (mediaSessionImplApi21 == null || Callback.this != mediaSessionImplApi21.getCallback()) {
                    return null;
                }
                return mediaSessionImplApi21;
            }

            private void setCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String callingPackage = mediaSessionImpl.getCallingPackage();
                if (TextUtils.isEmpty(callingPackage)) {
                    callingPackage = "android.media.session.MediaController";
                }
                mediaSessionImpl.setCurrentControllerInfo(new q0.b(callingPackage, -1, -1));
            }

            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Callback callback;
                MediaDescriptionCompat description;
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                try {
                    IBinder iBinder = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token sessionToken = sessionImplIfCallbackIsSet.getSessionToken();
                        IMediaSession extraBinder = sessionToken.getExtraBinder();
                        if (extraBinder != null) {
                            iBinder = extraBinder.asBinder();
                        }
                        D.g.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", iBinder);
                        M0.a.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", sessionToken.getSession2Token());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else {
                        if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                            callback = Callback.this;
                            description = (MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                        } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                            Callback.this.onCommand(str, bundle, resultReceiver);
                        } else if (sessionImplIfCallbackIsSet.mQueue != null) {
                            int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            if (i >= 0 && i < sessionImplIfCallbackIsSet.mQueue.size()) {
                                iBinder = (QueueItem) sessionImplIfCallbackIsSet.mQueue.get(i);
                            }
                            if (iBinder != null) {
                                callback = Callback.this;
                                description = iBinder.getDescription();
                            }
                        }
                        callback.onRemoveQueueItem(description);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri parcelable = bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        Callback.this.onPlayFromUri(parcelable, bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        Callback.this.onPrepare();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        Callback.this.onPrepareFromMediaId(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        Callback.this.onPrepareFromSearch(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Uri parcelable2 = bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        Callback.this.onPrepareFromUri(parcelable2, bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        Callback.this.onSetCaptioningEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        Callback.this.onSetRepeatMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        Callback.this.onSetShuffleMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle6);
                        Callback.this.onSetRating(ratingCompat, bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        Callback.this.onSetPlaybackSpeed(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        Callback.this.onCustomAction(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onFastForward() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onFastForward();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public boolean onMediaButtonEvent(Intent intent) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return false;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                boolean onMediaButtonEvent = Callback.this.onMediaButtonEvent(intent);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                return onMediaButtonEvent || super.onMediaButtonEvent(intent);
            }

            public void onPause() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPause();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPlay() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPlay();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPlayFromMediaId(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPlayFromSearch(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPlayFromUri(uri, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPrepare() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPrepare();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPrepareFromMediaId(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPrepareFromSearch(str, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onPrepareFromUri(uri, bundle);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onRewind() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onRewind();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSeekTo(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSeekTo(j);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSetPlaybackSpeed(float f) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSetPlaybackSpeed(f);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSetRating(Rating rating) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSetRating(RatingCompat.fromRating(rating));
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSkipToNext() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSkipToNext();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSkipToPrevious() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSkipToPrevious();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSkipToQueueItem(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onSkipToQueueItem(j);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onStop() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                Callback.this.onStop();
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
            }

            public void onSetRating(Rating rating, Bundle bundle) {
            }
        }

        public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl mediaSessionImpl, Handler handler) {
            if (this.mMediaPlayPausePendingOnHandler) {
                this.mMediaPlayPausePendingOnHandler = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long actions = playbackState == null ? 0L : playbackState.getActions();
                boolean z = playbackState != null && playbackState.getState() == 3;
                boolean z2 = (516 & actions) != 0;
                boolean z3 = (actions & 514) != 0;
                if (z && z3) {
                    onPause();
                } else {
                    if (z || !z2) {
                        return;
                    }
                    onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent parcelableExtra;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
                callbackHandler = this.mCallbackHandler;
            }
            if (mediaSessionImpl == null || callbackHandler == null || (parcelableExtra = intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || parcelableExtra.getAction() != 0) {
                return false;
            }
            q0.b currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = parcelableExtra.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                return false;
            }
            if (parcelableExtra.getRepeatCount() != 0) {
                handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
            } else if (this.mMediaPlayPausePendingOnHandler) {
                callbackHandler.removeMessages(1);
                this.mMediaPlayPausePendingOnHandler = false;
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                    onSkipToNext();
                }
            } else {
                this.mMediaPlayPausePendingOnHandler = true;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetPlaybackSpeed(float f) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            synchronized (this.mLock) {
                try {
                    this.mSessionImpl = new WeakReference(mediaSessionImpl);
                    CallbackHandler callbackHandler = this.mCallbackHandler;
                    CallbackHandler callbackHandler2 = null;
                    if (callbackHandler != null) {
                        callbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (mediaSessionImpl != null && handler != null) {
                        callbackHandler2 = new CallbackHandler(handler.getLooper());
                    }
                    this.mCallbackHandler = callbackHandler2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }
    }

    public interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        q0.b getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(q0.b bVar);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(q0.k kVar);

        void setQueue(List list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        public class 1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            public 1() {
            }

            public void onPlaybackPositionUpdate(long j) {
                MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(j), null);
            }
        }

        public MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, M0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (sIsMbrPendingIntentSupported) {
                return;
            }
            super.registerMediaButtonEventReceiver(pendingIntent, componentName);
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
            } else {
                this.mRcc.setPlaybackPositionUpdateListener(new 1());
            }
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (j * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        public class 1 implements RemoteControlClient.OnMetadataUpdateListener {
            public 1() {
            }

            public void onMetadataUpdate(int i, Object obj) {
                if (i == 268435457 && (obj instanceof Rating)) {
                    MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), null);
                }
            }
        }

        public MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, M0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            PlaybackStateCompat playbackStateCompat = this.mState;
            if (((playbackStateCompat == null ? 0L : playbackStateCompat.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey("android.media.metadata.YEAR")) {
                buildRccMetadata.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
            }
            if (bundle.containsKey("android.media.metadata.RATING")) {
                buildRccMetadata.putObject(101, bundle.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                buildRccMetadata.putObject(268435457, bundle.getParcelable("android.media.metadata.USER_RATING"));
            }
            return buildRccMetadata;
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
            } else {
                this.mRcc.setMetadataUpdateListener(new 1());
            }
        }
    }

    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        Callback mCallback;
        boolean mCaptioningEnabled;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List mQueue;
        int mRatingType;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        q0.b mRemoteUserInfo;
        int mRepeatMode;
        final MediaSession mSessionFwk;
        Bundle mSessionInfo;
        int mShuffleMode;
        final Token mToken;
        final Object mLock = new Object();
        boolean mDestroyed = false;
        final RemoteCallbackList mExtraControllerCallbacks = new RemoteCallbackList();

        public class ExtraSession extends IMediaSession.Stub {
            public ExtraSession() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
            }

            public List getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public Bundle getSessionInfo() {
                if (MediaSessionImplApi21.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplApi21.this.mSessionInfo);
            }

            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() throws RemoteException {
                throw new AssertionError();
            }

            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            public void play() throws RemoteException {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplApi21.this.mDestroyed) {
                    return;
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new q0.b("android.media.session.MediaController", callingPid, callingUid));
                synchronized (MediaSessionImplApi21.this.mLock) {
                    try {
                        RegistrationCallbackHandler registrationCallbackHandler = MediaSessionImplApi21.this.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            public void seekTo(long j) throws RemoteException {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z) throws RemoteException {
                throw new AssertionError();
            }

            public void setPlaybackSpeed(float f) throws RemoteException {
                throw new AssertionError();
            }

            public void setRepeatMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            public void setShuffleMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                synchronized (MediaSessionImplApi21.this.mLock) {
                    try {
                        RegistrationCallbackHandler registrationCallbackHandler = MediaSessionImplApi21.this.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public MediaSessionImplApi21(Context context, String str, M0.d dVar, Bundle bundle) {
            MediaSession createFwkMediaSession = createFwkMediaSession(context, str, bundle);
            this.mSessionFwk = createFwkMediaSession;
            this.mToken = new Token(createFwkMediaSession.getSessionToken(), new ExtraSession(), dVar);
            this.mSessionInfo = bundle;
            setFlags(3);
        }

        public MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.mSessionFwk.getClass().getMethod("getCallingPackage", (Class[]) null).invoke(this.mSessionFwk, (Object[]) null);
            } catch (Exception e) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
                return null;
            }
        }

        public q0.b getCurrentControllerInfo() {
            q0.b bVar;
            synchronized (this.mLock) {
                bVar = this.mRemoteUserInfo;
            }
            return bVar;
        }

        public Object getMediaSession() {
            return this.mSessionFwk;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mSessionFwk.isActive();
        }

        public void release() {
            this.mDestroyed = true;
            this.mExtraControllerCallbacks.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.mSessionFwk.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.mSessionFwk);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                } catch (Exception e) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e);
                }
            }
            this.mSessionFwk.setCallback((MediaSession.Callback) null);
            this.mSessionFwk.release();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast)).onEvent(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
            this.mSessionFwk.sendSessionEvent(str, bundle);
        }

        public void setActive(boolean z) {
            this.mSessionFwk.setActive(z);
        }

        public void setCallback(Callback callback, Handler handler) {
            synchronized (this.mLock) {
                try {
                    this.mCallback = callback;
                    this.mSessionFwk.setCallback(callback == null ? null : callback.mCallbackFwk, handler);
                    if (callback != null) {
                        callback.setSessionImpl(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast)).onCaptioningEnabledChanged(z);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        public void setCurrentControllerInfo(q0.b bVar) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = bVar;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mSessionFwk.setExtras(bundle);
        }

        @SuppressLint({"WrongConstant"})
        public void setFlags(int i) {
            this.mSessionFwk.setFlags(i | 3);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.mSessionFwk.setMediaButtonReceiver(pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            this.mSessionFwk.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            this.mPlaybackState = playbackStateCompat;
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            this.mSessionFwk.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.getPlaybackState());
        }

        public void setPlaybackToLocal(int i) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i);
            this.mSessionFwk.setPlaybackToLocal(builder.build());
        }

        public void setPlaybackToRemote(q0.k kVar) {
            this.mSessionFwk.setPlaybackToRemote((VolumeProvider) kVar.d());
        }

        public void setQueue(List list) {
            List arrayList;
            MediaSession mediaSession;
            this.mQueue = list;
            if (list == null) {
                mediaSession = this.mSessionFwk;
                arrayList = null;
            } else {
                arrayList = new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((MediaSession.QueueItem) ((QueueItem) it.next()).getQueueItem());
                }
                mediaSession = this.mSessionFwk;
            }
            mediaSession.setQueue(arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mSessionFwk.setQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
            synchronized (this.mLock) {
                try {
                    RegistrationCallbackHandler registrationCallbackHandler = this.mRegistrationCallbackHandler;
                    if (registrationCallbackHandler != null) {
                        registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (registrationCallback != null) {
                        this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                    } else {
                        this.mRegistrationCallbackHandler = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast)).onRepeatModeChanged(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            this.mSessionFwk.setSessionActivity(pendingIntent);
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast)).onShuffleModeChanged(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        public MediaSessionImplApi21(Object obj) {
            if (!(obj instanceof MediaSession)) {
                throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
            }
            MediaSession mediaSession = (MediaSession) obj;
            this.mSessionFwk = mediaSession;
            this.mToken = new Token(mediaSession.getSessionToken(), new ExtraSession());
            this.mSessionInfo = null;
            setFlags(3);
        }
    }

    public static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
        public MediaSessionImplApi22(Context context, String str, M0.d dVar, Bundle bundle) {
            super(context, str, dVar, bundle);
        }

        public void setRatingType(int i) {
            h.a(this.mSessionFwk, i);
        }

        public MediaSessionImplApi22(Object obj) {
            super(obj);
        }
    }

    public static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        public MediaSessionImplApi28(Context context, String str, M0.d dVar, Bundle bundle) {
            super(context, str, dVar, bundle);
        }

        public final q0.b getCurrentControllerInfo() {
            return new q0.b(i.a(this.mSessionFwk));
        }

        public MediaSessionImplApi28(Object obj) {
            super(obj);
        }

        public void setCurrentControllerInfo(q0.b bVar) {
        }
    }

    public static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        public MediaSessionImplApi29(Context context, String str, M0.d dVar, Bundle bundle) {
            super(context, str, dVar, bundle);
        }

        public MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
            return j.a(context, str, bundle);
        }

        public MediaSessionImplApi29(Object obj) {
            super(obj);
            this.mSessionInfo = a.a(((MediaSession) obj).getController());
        }
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        Bundle mExtras;
        private MessageHandler mHandler;
        int mLocalStream;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        private q0.b mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        final Bundle mSessionInfo;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        q0.k mVolumeProvider;
        int mVolumeType;
        final Object mLock = new Object();
        final RemoteCallbackList mControllerCallbacks = new RemoteCallbackList();
        boolean mDestroyed = false;
        boolean mIsActive = false;
        int mFlags = 3;
        private k.d mVolumeCallback = new 1();

        public class 1 extends k.d {
            public 1() {
            }

            public void onVolumeChanged(q0.k kVar) {
                if (MediaSessionImplBase.this.mVolumeProvider != kVar) {
                    return;
                }
                MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, kVar.c(), kVar.b(), kVar.a()));
            }
        }

        public static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        public class MediaSessionStub extends IMediaSession.Stub {
            public MediaSessionStub() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                postToHandler(26, mediaDescriptionCompat, i);
            }

            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.mLock) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    playbackStateCompat = mediaSessionImplBase.mState;
                    mediaMetadataCompat = mediaSessionImplBase.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List getQueue() {
                List list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public Bundle getSessionInfo() {
                if (MediaSessionImplBase.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplBase.this.mSessionInfo);
            }

            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int i3;
                int streamMaxVolume;
                int streamVolume;
                synchronized (MediaSessionImplBase.this.mLock) {
                    try {
                        MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                        i = mediaSessionImplBase.mVolumeType;
                        i2 = mediaSessionImplBase.mLocalStream;
                        q0.k kVar = mediaSessionImplBase.mVolumeProvider;
                        i3 = 2;
                        if (i == 2) {
                            int c = kVar.c();
                            int b = kVar.b();
                            streamVolume = kVar.a();
                            streamMaxVolume = b;
                            i3 = c;
                        } else {
                            streamMaxVolume = mediaSessionImplBase.mAudioManager.getStreamMaxVolume(i2);
                            streamVolume = MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i3, streamMaxVolume, streamVolume);
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return true;
            }

            public void next() throws RemoteException {
                postToHandler(14);
            }

            public void pause() throws RemoteException {
                postToHandler(12);
            }

            public void play() throws RemoteException {
                postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                postToHandler(8, str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                postToHandler(9, str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                postToHandler(10, uri, bundle);
            }

            public void postToHandler(int i) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, null, null);
            }

            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                postToHandler(4, str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                postToHandler(5, str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                postToHandler(6, uri, bundle);
            }

            public void previous() throws RemoteException {
                postToHandler(15);
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                postToHandler(19, ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                postToHandler(31, ratingCompat, bundle);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback, new q0.b(MediaSessionImplBase.this.getPackageNameForUid(callingUid), callingPid, callingUid));
                synchronized (MediaSessionImplBase.this.mLock) {
                    try {
                        RegistrationCallbackHandler registrationCallbackHandler = MediaSessionImplBase.this.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i) {
                postToHandler(28, i);
            }

            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            public void seekTo(long j) throws RemoteException {
                postToHandler(18, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, new Command(str, bundle, resultReceiverWrapper == null ? null : resultReceiverWrapper.mResultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                postToHandler(20, str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                postToHandler(21, keyEvent);
                return true;
            }

            public void setCaptioningEnabled(boolean z) throws RemoteException {
                postToHandler(29, Boolean.valueOf(z));
            }

            public void setPlaybackSpeed(float f) throws RemoteException {
                postToHandler(32, Float.valueOf(f));
            }

            public void setRepeatMode(int i) throws RemoteException {
                postToHandler(23, i);
            }

            public void setShuffleMode(int i) throws RemoteException {
                postToHandler(30, i);
            }

            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            public void skipToQueueItem(long j) {
                postToHandler(11, Long.valueOf(j));
            }

            public void stop() throws RemoteException {
                postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                synchronized (MediaSessionImplBase.this.mLock) {
                    try {
                        RegistrationCallbackHandler registrationCallbackHandler = MediaSessionImplBase.this.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public void postToHandler(int i, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, null, null);
            }

            public void postToHandler(int i, int i2, int i3) {
                MediaSessionImplBase.this.postToHandler(i, i2, i3, null, null);
            }

            public void postToHandler(int i, Object obj) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, null);
            }

            public void postToHandler(int i, Object obj, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, obj, null);
            }

            public void postToHandler(int i, Object obj, Bundle bundle) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, bundle);
            }
        }

        public class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_PLAYBACK_SPEED = 32;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.mState;
                long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode == 126) {
                        if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        }
                        return;
                    }
                    if (keyCode == 127) {
                        if ((actions & 2) != 0) {
                            callback.onPause();
                            return;
                        }
                        return;
                    }
                    switch (keyCode) {
                        case 86:
                            if ((actions & 1) != 0) {
                                callback.onStop();
                                break;
                            }
                            break;
                        case 87:
                            if ((actions & 32) != 0) {
                                callback.onSkipToNext();
                                break;
                            }
                            break;
                        case 88:
                            if ((actions & 16) != 0) {
                                callback.onSkipToPrevious();
                                break;
                            }
                            break;
                        case 89:
                            if ((actions & 8) != 0) {
                                callback.onRewind();
                                break;
                            }
                            break;
                        case 90:
                            if ((actions & 64) != 0) {
                                callback.onFastForward();
                                break;
                            }
                            break;
                    }
                }
                Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }

            public void handleMessage(Message message) {
                MediaDescriptionCompat mediaDescriptionCompat;
                Callback callback = MediaSessionImplBase.this.mCallback;
                if (callback == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                MediaSessionImplBase.this.setCurrentControllerInfo(new q0.b(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle("data_extras");
                MediaSessionCompat.ensureClassLoader(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            Command command = (Command) message.obj;
                            callback.onCommand(command.command, command.extras, command.stub);
                            break;
                        case 2:
                            MediaSessionImplBase.this.adjustVolume(message.arg1, 0);
                            break;
                        case 3:
                            callback.onPrepare();
                            break;
                        case 4:
                            callback.onPrepareFromMediaId((String) message.obj, bundle);
                            break;
                        case 5:
                            callback.onPrepareFromSearch((String) message.obj, bundle);
                            break;
                        case 6:
                            callback.onPrepareFromUri((Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.onPlay();
                            break;
                        case 8:
                            callback.onPlayFromMediaId((String) message.obj, bundle);
                            break;
                        case 9:
                            callback.onPlayFromSearch((String) message.obj, bundle);
                            break;
                        case 10:
                            callback.onPlayFromUri((Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.onSkipToQueueItem(((Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.onPause();
                            break;
                        case 13:
                            callback.onStop();
                            break;
                        case 14:
                            callback.onSkipToNext();
                            break;
                        case 15:
                            callback.onSkipToPrevious();
                            break;
                        case 16:
                            callback.onFastForward();
                            break;
                        case 17:
                            callback.onRewind();
                            break;
                        case 18:
                            callback.onSeekTo(((Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.onSetRating((RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.onCustomAction((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, callback);
                                break;
                            }
                            break;
                        case 22:
                            MediaSessionImplBase.this.setVolumeTo(message.arg1, 0);
                            break;
                        case 23:
                            callback.onSetRepeatMode(message.arg1);
                            break;
                        case 25:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            mediaDescriptionCompat = (MediaDescriptionCompat) message.obj;
                            callback.onRemoveQueueItem(mediaDescriptionCompat);
                            break;
                        case 28:
                            List list = MediaSessionImplBase.this.mQueue;
                            if (list != null) {
                                int i = message.arg1;
                                QueueItem queueItem = (i < 0 || i >= list.size()) ? null : (QueueItem) MediaSessionImplBase.this.mQueue.get(message.arg1);
                                if (queueItem != null) {
                                    mediaDescriptionCompat = queueItem.getDescription();
                                    callback.onRemoveQueueItem(mediaDescriptionCompat);
                                    break;
                                }
                            }
                            break;
                        case 29:
                            callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            callback.onSetRating((RatingCompat) message.obj, bundle);
                            break;
                        case 32:
                            callback.onSetPlaybackSpeed(((Float) message.obj).floatValue());
                            break;
                    }
                } finally {
                    MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, M0.d dVar, Bundle bundle) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mSessionInfo = bundle;
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = str;
            this.mMediaButtonReceiverComponentName = componentName;
            this.mMediaButtonReceiverIntent = pendingIntent;
            MediaSessionStub mediaSessionStub = new MediaSessionStub();
            this.mStub = mediaSessionStub;
            this.mToken = new Token(mediaSessionStub, null, dVar);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(pendingIntent);
        }

        private void sendCaptioningEnabled(boolean z) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onCaptioningEnabledChanged(z);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendEvent(String str, Bundle bundle) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendExtras(Bundle bundle) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onExtrasChanged(bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onMetadataChanged(mediaMetadataCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueue(List list) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueChanged(list);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueueTitle(CharSequence charSequence) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueTitleChanged(charSequence);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int i) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onRepeatModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendSessionDestroyed() {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onSessionDestroyed();
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
            }
        }

        private void sendShuffleMode(int i) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onShuffleModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public void adjustVolume(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
                return;
            }
            q0.k kVar = this.mVolumeProvider;
            if (kVar != null) {
                kVar.e(i);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001d A[PHI: r2
          0x001d: PHI (r2v30 android.graphics.Bitmap) = (r2v3 android.graphics.Bitmap), (r2v33 android.graphics.Bitmap) binds: [B:54:0x0037, B:8:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle r7) {
            /*
                Method dump skipped, instructions count: 270
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.buildRccMetadata(android.os.Bundle):android.media.RemoteControlClient$MetadataEditor");
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            return null;
        }

        public q0.b getCurrentControllerInfo() {
            q0.b bVar;
            synchronized (this.mLock) {
                bVar = this.mRemoteUserInfo;
            }
            return bVar;
        }

        public Object getMediaSession() {
            return null;
        }

        public String getPackageNameForUid(int i) {
            String nameForUid = this.mContext.getPackageManager().getNameForUid(i);
            return TextUtils.isEmpty(nameForUid) ? "android.media.session.MediaController" : nameForUid;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        public int getRccStateFromState(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int i = (1 & j) != 0 ? 32 : 0;
            if ((2 & j) != 0) {
                i |= 16;
            }
            if ((4 & j) != 0) {
                i |= 4;
            }
            if ((8 & j) != 0) {
                i |= 2;
            }
            if ((16 & j) != 0) {
                i |= 1;
            }
            if ((32 & j) != 0) {
                i |= 128;
            }
            if ((64 & j) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void postToHandler(int i, int i2, int i3, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                try {
                    MessageHandler messageHandler = this.mHandler;
                    if (messageHandler != null) {
                        Message obtainMessage = messageHandler.obtainMessage(i, i2, i3, obj);
                        Bundle bundle2 = new Bundle();
                        int callingUid = Binder.getCallingUid();
                        bundle2.putInt("data_calling_uid", callingUid);
                        bundle2.putString("data_calling_pkg", getPackageNameForUid(callingUid));
                        int callingPid = Binder.getCallingPid();
                        if (callingPid > 0) {
                            bundle2.putInt("data_calling_pid", callingPid);
                        } else {
                            bundle2.putInt("data_calling_pid", -1);
                        }
                        if (bundle != null) {
                            bundle2.putBundle("data_extras", bundle);
                        }
                        obtainMessage.setData(bundle2);
                        obtainMessage.sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            updateMbrAndRcc();
            sendSessionDestroyed();
            setCallback(null, null);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onVolumeInfoChanged(parcelableVolumeInfo);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public void setActive(boolean z) {
            if (z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            updateMbrAndRcc();
        }

        public void setCallback(Callback callback, Handler handler) {
            synchronized (this.mLock) {
                try {
                    MessageHandler messageHandler = this.mHandler;
                    if (messageHandler != null) {
                        messageHandler.removeCallbacksAndMessages((Object) null);
                    }
                    this.mHandler = (callback == null || handler == null) ? null : new MessageHandler(handler.getLooper());
                    if (this.mCallback != callback && this.mCallback != null) {
                        this.mCallback.setSessionImpl(null, null);
                    }
                    this.mCallback = callback;
                    if (this.mCallback != null) {
                        this.mCallback.setSessionImpl(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        public void setCurrentControllerInfo(q0.b bVar) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = bVar;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i | 3;
            }
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                } else {
                    setRccState(playbackStateCompat);
                    this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
                }
            }
        }

        public void setPlaybackToLocal(int i) {
            q0.k kVar = this.mVolumeProvider;
            if (kVar != null) {
                kVar.g(null);
            }
            this.mLocalStream = i;
            this.mVolumeType = 1;
            int i2 = this.mVolumeType;
            int i3 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(q0.k kVar) {
            if (kVar == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            q0.k kVar2 = this.mVolumeProvider;
            if (kVar2 != null) {
                kVar2.g(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = kVar;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.c(), this.mVolumeProvider.b(), this.mVolumeProvider.a()));
            kVar.g(this.mVolumeCallback);
        }

        public void setQueue(List list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
            synchronized (this.mLock) {
                try {
                    RegistrationCallbackHandler registrationCallbackHandler = this.mRegistrationCallbackHandler;
                    if (registrationCallbackHandler != null) {
                        registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (registrationCallback != null) {
                        this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                    } else {
                        this.mRegistrationCallbackHandler = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        public void setVolumeTo(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
                return;
            }
            q0.k kVar = this.mVolumeProvider;
            if (kVar != null) {
                kVar.f(i);
            }
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        public void updateMbrAndRcc() {
            if (!this.mIsActive) {
                unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mRcc.setPlaybackState(0);
                this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            } else {
                registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
            }
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator CREATOR = new 1();
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private MediaSession.QueueItem mItemFwk;

        public class 1 implements Parcelable.Creator {
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        public static class Api21Impl {
            private Api21Impl() {
            }

            public static MediaSession.QueueItem createQueueItem(MediaDescription mediaDescription, long j) {
                return new MediaSession.QueueItem(mediaDescription, j);
            }

            public static MediaDescription getDescription(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            public static long getQueueId(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat;
            this.mId = j;
            this.mItemFwk = queueItem;
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(queueItem)), Api21Impl.getQueueId(queueItem));
        }

        public static List fromQueueItemList(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromQueueItem(it.next()));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem queueItem = this.mItemFwk;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem createQueueItem = Api21Impl.createQueueItem((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
            this.mItemFwk = createQueueItem;
            return createQueueItem;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }

        public QueueItem(Parcel parcel) {
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }
    }

    public interface RegistrationCallback {
        void onCallbackRegistered(int i, int i2);

        void onCallbackUnregistered(int i, int i2);
    }

    public static final class RegistrationCallbackHandler extends Handler {
        private static final int MSG_CALLBACK_REGISTERED = 1001;
        private static final int MSG_CALLBACK_UNREGISTERED = 1002;
        private final RegistrationCallback mCallback;

        public RegistrationCallbackHandler(Looper looper, RegistrationCallback registrationCallback) {
            super(looper);
            this.mCallback = registrationCallback;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1001) {
                this.mCallback.onCallbackRegistered(message.arg1, message.arg2);
            } else {
                if (i != 1002) {
                    return;
                }
                this.mCallback.onCallbackUnregistered(message.arg1, message.arg2);
            }
        }

        public void postCallbackRegistered(int i, int i2) {
            obtainMessage(1001, i, i2).sendToTarget();
        }

        public void postCallbackUnregistered(int i, int i2) {
            obtainMessage(1002, i, i2).sendToTarget();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator CREATOR = new 1();
        ResultReceiver mResultReceiver;

        public class 1 implements Parcelable.Creator {
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator CREATOR = new 1();
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private final Object mLock;
        private M0.d mSession2Token;

        public class 1 implements Parcelable.Creator {
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession asInterface = IMediaSession.Stub.asInterface(D.g.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
            M0.d b = M0.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
            Token token = (Token) bundle.getParcelable("android.support.v4.media.session.TOKEN");
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, asInterface, b);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.mInner;
            Object obj3 = ((Token) obj).mInner;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.mLock) {
                iMediaSession = this.mExtraBinder;
            }
            return iMediaSession;
        }

        public M0.d getSession2Token() {
            M0.d dVar;
            synchronized (this.mLock) {
                dVar = this.mSession2Token;
            }
            return dVar;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession) {
            synchronized (this.mLock) {
                this.mExtraBinder = iMediaSession;
            }
        }

        public void setSession2Token(M0.d dVar) {
            synchronized (this.mLock) {
                this.mSession2Token = dVar;
            }
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.TOKEN", this);
            synchronized (this.mLock) {
                try {
                    IMediaSession iMediaSession = this.mExtraBinder;
                    if (iMediaSession != null) {
                        D.g.b(bundle, "android.support.v4.media.session.EXTRA_BINDER", iMediaSession.asBinder());
                    }
                    M0.d dVar = this.mSession2Token;
                    if (dVar != null) {
                        M0.a.c(bundle, "android.support.v4.media.session.SESSION_TOKEN2", dVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable((Parcelable) this.mInner, i);
        }

        public Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, iMediaSession);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        public Token(Object obj, IMediaSession iMediaSession, M0.d dVar) {
            this.mLock = new Object();
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSession2Token = dVar;
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mediaSessionImpl;
        this.mController = new MediaControllerCompat(context, this);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        int i = Build.VERSION.SDK_INT;
        if (context == null || obj == null) {
            return null;
        }
        return new MediaSessionCompat(context, i >= 29 ? new MediaSessionImplApi29(obj) : i >= 28 ? new MediaSessionImplApi28(obj) : new MediaSessionImplApi21(obj));
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getLastPositionUpdateTime() <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * (elapsedRealtime - r0))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
            j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j < 0 || playbackSpeed <= j) ? playbackSpeed < 0 ? 0L : playbackSpeed : j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(onActiveChangeListener);
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final q0.b getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        Iterator it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(q0.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(kVar);
    }

    public void setQueue(List list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                QueueItem queueItem = (QueueItem) it.next();
                if (queueItem == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                if (hashSet.contains(Long.valueOf(queueItem.getQueueId()))) {
                    Log.e("MediaSessionCompat", "Found duplicate queue id: " + queueItem.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(queueItem.getQueueId()));
            }
        }
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
        this.mImpl.setRegistrationCallback(registrationCallback, handler);
    }

    public void setRepeatMode(int i) {
        this.mImpl.setRepeatMode(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i) {
        this.mImpl.setShuffleMode(i);
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, M0.d dVar) {
        this.mActiveListeners = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (componentName == null && (componentName = s0.a.a(context)) == null) {
            Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        int i = Build.VERSION.SDK_INT;
        this.mImpl = i >= 29 ? new MediaSessionImplApi29(context, str, dVar, bundle) : i >= 28 ? new MediaSessionImplApi28(context, str, dVar, bundle) : i >= 22 ? new MediaSessionImplApi22(context, str, dVar, bundle) : new MediaSessionImplApi21(context, str, dVar, bundle);
        setCallback(new 1(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
        this.mImpl.setMediaButtonReceiver(pendingIntent);
        this.mController = new MediaControllerCompat(context, this);
        if (sMaxBitmapSize == 0) {
            sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }
}
