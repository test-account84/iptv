package tv.danmaku.ijk.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.annotations.AccessedByNative;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class IjkMediaPlayer extends AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private String mDataSource;
    private EventHandler mEventHandler;

    @AccessedByNative
    private int mListenerContext;

    @AccessedByNative
    private long mNativeAndroidIO;

    @AccessedByNative
    private long mNativeMediaDataSource;

    @AccessedByNative
    private long mNativeMediaPlayer;

    @AccessedByNative
    private int mNativeSurfaceTexture;
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;
    private static final IjkLibLoader sLocalLibLoader = new 1();
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    public class 1 implements IjkLibLoader {
        public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
            System.loadLibrary(str);
        }
    }

    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
        @android.annotation.TargetApi(16)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer r17, java.lang.String r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 307
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector.onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer, java.lang.String, int, int):java.lang.String");
        }
    }

    public static class EventHandler extends Handler {
        private final WeakReference mWeakPlayer;

        public EventHandler(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference(ijkMediaPlayer);
        }

        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                if (IjkMediaPlayer.access$000(ijkMediaPlayer) != 0) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            ijkMediaPlayer.notifyOnPrepared();
                            return;
                        }
                        if (i == 2) {
                            IjkMediaPlayer.access$200(ijkMediaPlayer, false);
                            ijkMediaPlayer.notifyOnCompletion();
                            return;
                        }
                        if (i == 3) {
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long duration = ijkMediaPlayer.getDuration();
                            long j2 = duration > 0 ? (j * 100) / duration : 0L;
                            ijkMediaPlayer.notifyOnBufferingUpdate((int) (j2 < 100 ? j2 : 100L));
                            return;
                        }
                        if (i == 4) {
                            ijkMediaPlayer.notifyOnSeekComplete();
                            return;
                        }
                        if (i == 5) {
                            IjkMediaPlayer.access$302(ijkMediaPlayer, message.arg1);
                            IjkMediaPlayer.access$402(ijkMediaPlayer, message.arg2);
                            ijkMediaPlayer.notifyOnVideoSizeChanged(IjkMediaPlayer.access$300(ijkMediaPlayer), IjkMediaPlayer.access$400(ijkMediaPlayer), IjkMediaPlayer.access$500(ijkMediaPlayer), IjkMediaPlayer.access$600(ijkMediaPlayer));
                            return;
                        }
                        if (i == 99) {
                            if (message.obj == null) {
                                ijkMediaPlayer.notifyOnTimedText(null);
                                return;
                            } else {
                                ijkMediaPlayer.notifyOnTimedText(new IjkTimedText(new Rect(0, 0, 1, 1), (String) message.obj));
                                return;
                            }
                        }
                        if (i == 100) {
                            DebugLog.e(IjkMediaPlayer.access$100(), "Error (" + message.arg1 + "," + message.arg2 + ")");
                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                ijkMediaPlayer.notifyOnCompletion();
                            }
                            IjkMediaPlayer.access$200(ijkMediaPlayer, false);
                            return;
                        }
                        if (i == 200) {
                            if (message.arg1 == 3) {
                                DebugLog.i(IjkMediaPlayer.access$100(), "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        } else if (i == 10001) {
                            IjkMediaPlayer.access$502(ijkMediaPlayer, message.arg1);
                            IjkMediaPlayer.access$602(ijkMediaPlayer, message.arg2);
                            ijkMediaPlayer.notifyOnVideoSizeChanged(IjkMediaPlayer.access$300(ijkMediaPlayer), IjkMediaPlayer.access$400(ijkMediaPlayer), IjkMediaPlayer.access$500(ijkMediaPlayer), IjkMediaPlayer.access$600(ijkMediaPlayer));
                            return;
                        } else {
                            DebugLog.e(IjkMediaPlayer.access$100(), "Unknown message type " + message.what);
                            return;
                        }
                    }
                    return;
                }
            }
            DebugLog.w(IjkMediaPlayer.access$100(), "IjkMediaPlayer went away with unhandled events");
        }
    }

    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    public interface OnNativeInvokeListener {
        public static final String ARG_ERROR = "error";
        public static final String ARG_FAMILIY = "family";
        public static final String ARG_FD = "fd";
        public static final String ARG_FILE_SIZE = "file_size";
        public static final String ARG_HTTP_CODE = "http_code";
        public static final String ARG_IP = "ip";
        public static final String ARG_OFFSET = "offset";
        public static final String ARG_PORT = "port";
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo();

    private native void _pause() throws IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setFrameAtTime(String str, long j, long j2, int i, int i2) throws IllegalArgumentException, IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(Surface surface);

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    public static /* synthetic */ long access$000(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mNativeMediaPlayer;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$200(IjkMediaPlayer ijkMediaPlayer, boolean z) {
        ijkMediaPlayer.stayAwake(z);
    }

    public static /* synthetic */ int access$300(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoWidth;
    }

    public static /* synthetic */ int access$302(IjkMediaPlayer ijkMediaPlayer, int i) {
        ijkMediaPlayer.mVideoWidth = i;
        return i;
    }

    public static /* synthetic */ int access$400(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoHeight;
    }

    public static /* synthetic */ int access$402(IjkMediaPlayer ijkMediaPlayer, int i) {
        ijkMediaPlayer.mVideoHeight = i;
        return i;
    }

    public static /* synthetic */ int access$500(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoSarNum;
    }

    public static /* synthetic */ int access$502(IjkMediaPlayer ijkMediaPlayer, int i) {
        ijkMediaPlayer.mVideoSarNum = i;
        return i;
    }

    public static /* synthetic */ int access$600(IjkMediaPlayer ijkMediaPlayer) {
        return ijkMediaPlayer.mVideoSarDen;
    }

    public static /* synthetic */ int access$602(IjkMediaPlayer ijkMediaPlayer, int i) {
        ijkMediaPlayer.mVideoSarDen = i;
        return i;
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    private static void initNativeOnce() {
        synchronized (IjkMediaPlayer.class) {
            try {
                if (!mIsNativeInitialized) {
                    native_init();
                    mIsNativeInitialized = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void initPlayer(IjkLibLoader ijkLibLoader) {
        EventHandler eventHandler;
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            eventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.mEventHandler = null;
                native_setup(new WeakReference(this));
            }
            eventHandler = new EventHandler(this, mainLooper);
        }
        this.mEventHandler = eventHandler;
        native_setup(new WeakReference(this));
    }

    public static void loadLibrariesOnce(IjkLibLoader ijkLibLoader) {
        synchronized (IjkMediaPlayer.class) {
            try {
                if (!mIsLibLoaded) {
                    if (ijkLibLoader == null) {
                        ijkLibLoader = sLocalLibLoader;
                    }
                    ijkLibLoader.loadLibrary("ijkffmpeg");
                    ijkLibLoader.loadLibrary("ijksdl");
                    ijkLibLoader.loadLibrary("ijkplayer");
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    @CalledByNative
    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer == null) {
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
        if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
            return true;
        }
        if (i != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
            return false;
        }
        int i2 = bundle.getInt("segment_index", -1);
        if (i2 < 0) {
            throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
        if (onControlResolveSegmentUrl == null) {
            throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
        }
        bundle.putString("url", onControlResolveSegmentUrl);
        return true;
    }

    @CalledByNative
    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i, i2);
    }

    @CalledByNative
    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            ijkMediaPlayer.start();
        }
        EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    @SuppressLint({"Wakelock"})
    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public native void _prepareAsync() throws IllegalStateException;

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    public void finalize() throws Throwable {
        super.finalize();
        native_finalize();
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(20201, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(20203, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(20202, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(20008, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(20010, 0L);
    }

    public native int getAudioSessionId();

    public long getBitRate() {
        return _getPropertyLong(20100, 0L);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(20208, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(20206, 0L);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(20207, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(20205, 0L);
    }

    public native long getCurrentPosition();

    public String getDataSource() {
        return this.mDataSource;
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    public native long getDuration();

    public long getFileSize() {
        return _getPropertyLong(20209, 0L);
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(20300, 0L);
    }

    public int getSelectedTrack(int i) {
        int i2;
        if (i == 1) {
            i2 = 20001;
        } else if (i == 2) {
            i2 = 20002;
        } else {
            if (i != 3) {
                return -1;
            }
            i2 = 20011;
        }
        return (int) _getPropertyLong(i2, -1L);
    }

    public float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(20200, 0L);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(20204, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(20007, 0L);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(20009, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0L);
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void httphookReconnect() {
        _setPropertyLong(20211, 1L);
    }

    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    public boolean isPlayable() {
        return true;
    }

    public native boolean isPlaying();

    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    public void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages((Object) null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    public native void seekTo(long j) throws IllegalStateException;

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void setAndroidIOCallback(IAndroidIO iAndroidIO) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    public void setAudioStreamType(int i) {
    }

    public void setCacheShare(int i) {
        _setPropertyLong(20210, i);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, (Map) null);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    public void setKeepInBackground(boolean z) {
    }

    public void setLogEnabled(boolean z) {
    }

    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public void setSpeed(float f) {
        _setPropertyFloat(10003, f);
    }

    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public native void setVolume(float f, float f2);

    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z = true;
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, IjkMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    public IjkMediaPlayer(IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        initPlayer(ijkLibLoader);
    }

    public IjkTrackInfo[] getTrackInfo() {
        IjkMediaMeta parse;
        int i;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = parse.mStreams.iterator();
        while (it.hasNext()) {
            IjkMediaMeta.IjkStreamMeta ijkStreamMeta = (IjkMediaMeta.IjkStreamMeta) it.next();
            IjkTrackInfo ijkTrackInfo = new IjkTrackInfo(ijkStreamMeta);
            if (ijkStreamMeta.mType.equalsIgnoreCase("video")) {
                i = 1;
            } else if (ijkStreamMeta.mType.equalsIgnoreCase("audio")) {
                i = 2;
            } else if (ijkStreamMeta.mType.equalsIgnoreCase("timedtext")) {
                i = 3;
            } else {
                arrayList.add(ijkTrackInfo);
            }
            ijkTrackInfo.setTrackType(i);
            arrayList.add(ijkTrackInfo);
        }
        return (IjkTrackInfo[]) arrayList.toArray(new IjkTrackInfo[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @android.annotation.TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDataSource(android.content.Context r8, android.net.Uri r9, java.util.Map r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        /*
            r7 = this;
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L14
            java.lang.String r8 = r9.getPath()
            r7.setDataSource(r8)
            return
        L14:
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3b
            java.lang.String r0 = "settings"
            java.lang.String r1 = r9.getAuthority()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3b
            int r9 = android.media.RingtoneManager.getDefaultType(r9)
            android.net.Uri r9 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r8, r9)
            if (r9 == 0) goto L33
            goto L3b
        L33:
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r9 = "Failed to resolve default ringtone"
            r8.<init>(r9)
            throw r8
        L3b:
            r0 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = r8.openAssetFileDescriptor(r9, r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            if (r0 != 0) goto L4e
            if (r0 == 0) goto L4d
            r0.close()
        L4d:
            return
        L4e:
            long r1 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L66
            java.io.FileDescriptor r8 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            r7.setDataSource(r8)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            goto L76
        L60:
            r8 = move-exception
            goto L7a
        L62:
            goto L80
        L64:
            goto L86
        L66:
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            long r3 = r0.getStartOffset()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            long r5 = r0.getDeclaredLength()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
            r1 = r7
            r1.setDataSource(r2, r3, r5)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62 java.lang.SecurityException -> L64
        L76:
            r0.close()
            return
        L7a:
            if (r0 == 0) goto L7f
            r0.close()
        L7f:
            throw r8
        L80:
            if (r0 == 0) goto L89
        L82:
            r0.close()
            goto L89
        L86:
            if (r0 == 0) goto L89
            goto L82
        L89:
            java.lang.String r8 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG
            java.lang.String r0 = "Couldn't open file on client side, trying server side"
            android.util.Log.d(r8, r0)
            java.lang.String r8 = r9.toString()
            r7.setDataSource(r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.IjkMediaPlayer.setDataSource(android.content.Context, android.net.Uri, java.util.Map):void");
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
        try {
            _setDataSourceFd(dup.getFd());
        } finally {
            dup.close();
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty((String) entry.getValue())) {
                    sb.append((String) entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }
}
