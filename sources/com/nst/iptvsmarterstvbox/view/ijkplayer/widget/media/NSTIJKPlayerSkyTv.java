package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerSkyTv extends FrameLayout implements MediaController.MediaPlayerControl, z7.n {
    public static LiveStreamDBHandler S1;
    public static String T1;
    public static final int[] U1 = {0, 1, 2, 3, 4, 5};
    public boolean A;
    public SharedPreferences A0;
    public LinearLayout A1;
    public boolean B;
    public SharedPreferences B0;
    public final SeekBar.OnSeekBarChangeListener B1;
    public int C;
    public SharedPreferences C0;
    public final SeekBar.OnSeekBarChangeListener C1;
    public Handler D;
    public SharedPreferences D0;
    public IMediaPlayer.OnVideoSizeChangedListener D1;
    public Handler E;
    public SharedPreferences.Editor E0;
    public IMediaPlayer.OnPreparedListener E1;
    public int F;
    public SharedPreferences.Editor F0;
    public IMediaPlayer.OnCompletionListener F1;
    public boolean G;
    public SharedPreferences.Editor G0;
    public IMediaPlayer.OnInfoListener G1;
    public int H;
    public boolean H0;
    public IMediaPlayer.OnErrorListener H1;
    public int I;
    public boolean I0;
    public IMediaPlayer.OnBufferingUpdateListener I1;
    public boolean J;
    public SharedPreferences J0;
    public IMediaPlayer.OnSeekCompleteListener J1;
    public SharedPreferences K;
    public n7.l K0;
    public IMediaPlayer.OnTimedTextListener K1;
    public SharedPreferences.Editor L;
    public boolean L0;
    public a.a L1;
    public SharedPreferences M;
    public TextView M0;
    public int M1;
    public Context N;
    public TextView N0;
    public int N1;
    public u7.a O;
    public TextView O0;
    public List O1;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a P;
    public RadioGroup P0;
    public int P1;
    public int Q;
    public RadioGroup Q0;
    public int Q1;
    public int R;
    public RadioGroup R0;
    public boolean R1;
    public long S;
    public SharedPreferences.Editor S0;
    public long T;
    public TextView T0;
    public long U;
    public FrameLayout U0;
    public long V;
    public androidx.appcompat.app.a V0;
    public TextView W;
    public SeekBar W0;
    public SeekBar X0;
    public LinearLayout Y0;
    public Handler Z0;
    public String a;
    public Runnable a1;
    public Animation b1;
    public Uri c;
    public Animation c1;
    public String d;
    public LinearLayout d1;
    public Map e;
    public String e0;
    public LinearLayout e1;
    public int f;
    public Activity f0;
    public int f1;
    public int g;
    public NSTIJKPlayerSkyTv g0;
    public TextView g1;
    public int h;
    public AudioManager h0;
    public TextView h1;
    public a.b i;
    public int i0;
    public LinearLayout i1;
    public IMediaPlayer j;
    public float j0;
    public Animation j1;
    public int k;
    public GestureDetector k0;
    public Animation k1;
    public int l;
    public int l0;
    public RelativeLayout l1;
    public int m;
    public View m0;
    public Animation m1;
    public int n;
    public y n0;
    public Animation n1;
    public int o;
    public Button o0;
    public Animation o1;
    public IMediaPlayer.OnCompletionListener p;
    public Boolean p0;
    public Animation p1;
    public IMediaPlayer.OnPreparedListener q;
    public Boolean q0;
    public SharedPreferences q1;
    public int r;
    public Boolean r0;
    public RelativeLayout r1;
    public IMediaPlayer.OnErrorListener s;
    public Boolean s0;
    public boolean s1;
    public IMediaPlayer.OnInfoListener t;
    public Boolean t0;
    public boolean t1;
    public int u;
    public Boolean u0;
    public String u1;
    public boolean v;
    public boolean v0;
    public String v1;
    public boolean w;
    public StringBuilder w0;
    public Handler w1;
    public boolean x;
    public Formatter x0;
    public Context x1;
    public int y;
    public boolean y0;
    public LinearLayout y1;
    public long z;
    public boolean z0;
    public LinearLayout z1;

    public class a implements IMediaPlayer.OnErrorListener {
        public a() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this), "Error: " + i + "," + i2);
            NSTIJKPlayerSkyTv.x(NSTIJKPlayerSkyTv.this, -1);
            NSTIJKPlayerSkyTv.X(NSTIJKPlayerSkyTv.this, -1);
            NSTIJKPlayerSkyTv.D(NSTIJKPlayerSkyTv.this);
            NSTIJKPlayerSkyTv.c0(NSTIJKPlayerSkyTv.this, -1);
            if (NSTIJKPlayerSkyTv.j0(NSTIJKPlayerSkyTv.this) != null) {
                NSTIJKPlayerSkyTv.j0(NSTIJKPlayerSkyTv.this).onError(NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this), i, i2);
            }
            return true;
        }
    }

    public class b implements IMediaPlayer.OnBufferingUpdateListener {
        public b() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            MyApplication.F("mCurrentBufferPercentage" + NSTIJKPlayerSkyTv.l0(NSTIJKPlayerSkyTv.this));
            NSTIJKPlayerSkyTv.m0(NSTIJKPlayerSkyTv.this, i);
        }
    }

    public class c implements IMediaPlayer.OnSeekCompleteListener {
        public c() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSkyTv.n0(NSTIJKPlayerSkyTv.this, System.currentTimeMillis());
        }
    }

    public class d implements IMediaPlayer.OnTimedTextListener {
        public d() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            TextView textView;
            if (ijkTimedText == null) {
                NSTIJKPlayerSkyTv.this.W.setVisibility(8);
                return;
            }
            String replace = ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", "").replace("{\\c}", "");
            StringBuilder sb = new StringBuilder();
            try {
                if (replace.contains("{")) {
                    for (String str : replace.split("\\{")) {
                        if (str.contains("}")) {
                            str = str.substring(str.lastIndexOf("}") + 1);
                        }
                        sb.append(str);
                    }
                }
            } catch (Exception unused) {
            }
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            NSTIJKPlayerSkyTv.q0(nSTIJKPlayerSkyTv, NSTIJKPlayerSkyTv.r0(nSTIJKPlayerSkyTv).getSharedPreferences("pref.using_sub_font_size", 0));
            try {
                NSTIJKPlayerSkyTv.this.W.setTextSize(2, Float.parseFloat(NSTIJKPlayerSkyTv.p0(NSTIJKPlayerSkyTv.this).getString("pref.using_sub_font_size", m7.a.x0)));
            } catch (Exception unused2) {
            }
            if (NSTIJKPlayerSkyTv.this.getShowOrHideSubtitles().equals("visible")) {
                NSTIJKPlayerSkyTv.this.W.setVisibility(0);
            } else {
                NSTIJKPlayerSkyTv.this.W.setVisibility(8);
            }
            if (sb.length() > 0) {
                textView = NSTIJKPlayerSkyTv.this.W;
                replace = sb.toString();
            } else {
                textView = NSTIJKPlayerSkyTv.this.W;
            }
            textView.setText(replace);
        }
    }

    public class e implements a.a {
        public e() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            if (a != nSTIJKPlayerSkyTv.P) {
                Log.e(NSTIJKPlayerSkyTv.b0(nSTIJKPlayerSkyTv), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSkyTv.P(nSTIJKPlayerSkyTv, i2);
            NSTIJKPlayerSkyTv.T(NSTIJKPlayerSkyTv.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerSkyTv.W(NSTIJKPlayerSkyTv.this) == 3;
            if (!NSTIJKPlayerSkyTv.this.P.d() || (NSTIJKPlayerSkyTv.k(NSTIJKPlayerSkyTv.this) == i2 && NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this) != null && z2 && z) {
                if (NSTIJKPlayerSkyTv.J(NSTIJKPlayerSkyTv.this) != 0) {
                    NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = NSTIJKPlayerSkyTv.this;
                    nSTIJKPlayerSkyTv2.seekTo(NSTIJKPlayerSkyTv.J(nSTIJKPlayerSkyTv2));
                }
                NSTIJKPlayerSkyTv.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            if (a != nSTIJKPlayerSkyTv.P) {
                Log.e(NSTIJKPlayerSkyTv.b0(nSTIJKPlayerSkyTv), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSkyTv.s0(nSTIJKPlayerSkyTv, bVar);
            if (NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this) == null) {
                NSTIJKPlayerSkyTv.this.q1();
            } else {
                NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = NSTIJKPlayerSkyTv.this;
                NSTIJKPlayerSkyTv.t0(nSTIJKPlayerSkyTv2, NSTIJKPlayerSkyTv.B(nSTIJKPlayerSkyTv2), bVar);
            }
        }

        public void c(a.b bVar) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            if (a != nSTIJKPlayerSkyTv.P) {
                Log.e(NSTIJKPlayerSkyTv.b0(nSTIJKPlayerSkyTv), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerSkyTv.s0(nSTIJKPlayerSkyTv, null);
                NSTIJKPlayerSkyTv.this.s1();
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public f(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
            if (NSTIJKPlayerSkyTv.x0(NSTIJKPlayerSkyTv.this).getVisibility() != 0 || NSTIJKPlayerSkyTv.z0(NSTIJKPlayerSkyTv.this) == null) {
                return;
            }
            NSTIJKPlayerSkyTv.z0(NSTIJKPlayerSkyTv.this).setVisibility(0);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyTv.A0(NSTIJKPlayerSkyTv.this);
        }
    }

    public class h implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public h(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            NSTIJKPlayerSkyTv.D0(nSTIJKPlayerSkyTv, NSTIJKPlayerSkyTv.J0(nSTIJKPlayerSkyTv).edit());
            if (i == 111 || i == 11111111) {
                NSTIJKPlayerSkyTv.B0(NSTIJKPlayerSkyTv.this).putInt("currentVideoTrack", -1);
                NSTIJKPlayerSkyTv.this.h1(this.a);
            } else {
                NSTIJKPlayerSkyTv.B0(NSTIJKPlayerSkyTv.this).putInt("currentVideoTrack", i);
                NSTIJKPlayerSkyTv.this.u1(i);
            }
            NSTIJKPlayerSkyTv.B0(NSTIJKPlayerSkyTv.this).apply();
        }
    }

    public class i implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            NSTIJKPlayerSkyTv.L0(nSTIJKPlayerSkyTv, NSTIJKPlayerSkyTv.M0(nSTIJKPlayerSkyTv).edit());
            if (i == 1111 || i == 1111111) {
                NSTIJKPlayerSkyTv.K0(NSTIJKPlayerSkyTv.this).putInt("currentAudioTrack", -1);
                NSTIJKPlayerSkyTv.this.h1(this.a);
            } else {
                NSTIJKPlayerSkyTv.K0(NSTIJKPlayerSkyTv.this).putInt("currentAudioTrack", i);
                int currentPosition = (int) NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this).getCurrentPosition();
                NSTIJKPlayerSkyTv.this.u1(i);
                NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this).seekTo(Long.parseLong(String.valueOf(currentPosition)));
            }
            NSTIJKPlayerSkyTv.K0(NSTIJKPlayerSkyTv.this).apply();
        }
    }

    public class j implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public j(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            NSTIJKPlayerSkyTv.O0(nSTIJKPlayerSkyTv, NSTIJKPlayerSkyTv.Q0(nSTIJKPlayerSkyTv).edit());
            if (i == 11111 || i == 111111) {
                TextView textView = NSTIJKPlayerSkyTv.this.W;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                NSTIJKPlayerSkyTv.N0(NSTIJKPlayerSkyTv.this).putInt("currentSubtitleTrack", -1);
                NSTIJKPlayerSkyTv.this.h1(this.a);
            } else {
                TextView textView2 = NSTIJKPlayerSkyTv.this.W;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                NSTIJKPlayerSkyTv.N0(NSTIJKPlayerSkyTv.this).putInt("currentSubtitleTrack", i);
                NSTIJKPlayerSkyTv.this.u1(i);
            }
            NSTIJKPlayerSkyTv.N0(NSTIJKPlayerSkyTv.this).apply();
        }
    }

    public class k implements SeekBar.OnSeekBarChangeListener {
        public k() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView h;
            Resources resources;
            int i2;
            NSTIJKPlayerSkyTv.g(NSTIJKPlayerSkyTv.this, i);
            int f = (int) ((NSTIJKPlayerSkyTv.f(NSTIJKPlayerSkyTv.this) / 255.0f) * 100.0f);
            if (f < 20) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.i0;
            } else if (f < 30) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.j0;
            } else if (f < 40) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.k0;
            } else if (f < 50) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.l0;
            } else if (f < 60) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.m0;
            } else if (f < 70) {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.n0;
            } else {
                h = NSTIJKPlayerSkyTv.h(NSTIJKPlayerSkyTv.this);
                resources = NSTIJKPlayerSkyTv.this.getResources();
                i2 = a7.e.o0;
            }
            h.setBackground(resources.getDrawable(i2));
            WindowManager.LayoutParams attributes = NSTIJKPlayerSkyTv.E(NSTIJKPlayerSkyTv.this).getWindow().getAttributes();
            attributes.screenBrightness = NSTIJKPlayerSkyTv.f(NSTIJKPlayerSkyTv.this) / 255.0f;
            NSTIJKPlayerSkyTv.k0(NSTIJKPlayerSkyTv.this).R((int) NSTIJKPlayerSkyTv.f(NSTIJKPlayerSkyTv.this));
            NSTIJKPlayerSkyTv.E(NSTIJKPlayerSkyTv.this).getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerSkyTv.this.C1();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerSkyTv.this.C1();
            NSTIJKPlayerSkyTv.this.d1(3000);
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv;
            String str;
            switch (i) {
                case 0:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "10";
                    break;
                case 1:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "12";
                    break;
                case 2:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "14";
                    break;
                case 3:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "16";
                    break;
                case 4:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "18";
                    break;
                case 5:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "20";
                    break;
                case 6:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "22";
                    break;
                case 7:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "24";
                    break;
                case 8:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "26";
                    break;
                case 9:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "28";
                    break;
                case 10:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "30";
                    break;
                case 11:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "32";
                    break;
                case 12:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "34";
                    break;
                case 13:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "36";
                    break;
                case 14:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "38";
                    break;
                case 15:
                    nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
                    str = "40";
                    break;
                default:
                    return;
            }
            NSTIJKPlayerSkyTv.R0(nSTIJKPlayerSkyTv, str);
            NSTIJKPlayerSkyTv.S0(NSTIJKPlayerSkyTv.this).setText(str);
            dialogInterface.cancel();
        }
    }

    public class m implements DialogInterface.OnDismissListener {
        public m() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class n implements SeekBar.OnSeekBarChangeListener {
        public n() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView Y0;
            Resources resources;
            int i2;
            if (NSTIJKPlayerSkyTv.F0(NSTIJKPlayerSkyTv.this) != null) {
                try {
                    NSTIJKPlayerSkyTv.F0(NSTIJKPlayerSkyTv.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((NSTIJKPlayerSkyTv.F0(NSTIJKPlayerSkyTv.this).getStreamVolume(3) / NSTIJKPlayerSkyTv.W0(NSTIJKPlayerSkyTv.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        Y0 = NSTIJKPlayerSkyTv.Y0(NSTIJKPlayerSkyTv.this);
                        resources = NSTIJKPlayerSkyTv.this.getResources();
                        i2 = a7.e.w0;
                    } else if (streamVolume < 40) {
                        Y0 = NSTIJKPlayerSkyTv.Y0(NSTIJKPlayerSkyTv.this);
                        resources = NSTIJKPlayerSkyTv.this.getResources();
                        i2 = a7.e.t0;
                    } else if (streamVolume < 80) {
                        Y0 = NSTIJKPlayerSkyTv.Y0(NSTIJKPlayerSkyTv.this);
                        resources = NSTIJKPlayerSkyTv.this.getResources();
                        i2 = a7.e.u0;
                    } else if (streamVolume < 100) {
                        Y0 = NSTIJKPlayerSkyTv.Y0(NSTIJKPlayerSkyTv.this);
                        resources = NSTIJKPlayerSkyTv.this.getResources();
                        i2 = a7.e.v0;
                    } else {
                        Y0 = NSTIJKPlayerSkyTv.Y0(NSTIJKPlayerSkyTv.this);
                        resources = NSTIJKPlayerSkyTv.this.getResources();
                        i2 = a7.e.v0;
                    }
                    Y0.setBackground(resources.getDrawable(i2));
                } catch (Exception unused) {
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerSkyTv.this.C1();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerSkyTv.this.C1();
            NSTIJKPlayerSkyTv.this.d1(3000);
        }
    }

    public class o implements View.OnTouchListener {
        public o() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return (NSTIJKPlayerSkyTv.E(NSTIJKPlayerSkyTv.this).findViewById(a7.f.G8).getVisibility() == 0 || motionEvent == null || !NSTIJKPlayerSkyTv.Z0(NSTIJKPlayerSkyTv.this).onTouchEvent(motionEvent)) ? false : true;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            nSTIJKPlayerSkyTv.H++;
            m7.w.P0(NSTIJKPlayerSkyTv.E(nSTIJKPlayerSkyTv), NSTIJKPlayerSkyTv.E(NSTIJKPlayerSkyTv.this).getResources().getString(a7.j.g5) + " (" + NSTIJKPlayerSkyTv.this.H + "/" + NSTIJKPlayerSkyTv.a1(NSTIJKPlayerSkyTv.this) + ")");
            NSTIJKPlayerSkyTv.this.q1();
            NSTIJKPlayerSkyTv.this.start();
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            NSTIJKPlayerSkyTv.this.k1();
        }
    }

    public class r implements IMediaPlayer.OnVideoSizeChangedListener {
        public r() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerSkyTv.l(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSkyTv.o(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerSkyTv.r(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerSkyTv.v(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerSkyTv.k(NSTIJKPlayerSkyTv.this) == 0 || NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this) == 0) {
                return;
            }
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerSkyTv.P;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerSkyTv.k(nSTIJKPlayerSkyTv), NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this));
                NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = NSTIJKPlayerSkyTv.this;
                nSTIJKPlayerSkyTv2.P.a(NSTIJKPlayerSkyTv.p(nSTIJKPlayerSkyTv2), NSTIJKPlayerSkyTv.u(NSTIJKPlayerSkyTv.this));
            }
            NSTIJKPlayerSkyTv.this.requestLayout();
        }
    }

    public class s implements IMediaPlayer.OnPreparedListener {
        public s() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSkyTv.w(NSTIJKPlayerSkyTv.this, System.currentTimeMillis());
            NSTIJKPlayerSkyTv.x(NSTIJKPlayerSkyTv.this, 2);
            if (NSTIJKPlayerSkyTv.z(NSTIJKPlayerSkyTv.this).b(a7.f.A) != null) {
                NSTIJKPlayerSkyTv.z(NSTIJKPlayerSkyTv.this).b(a7.f.A).a();
            }
            if (NSTIJKPlayerSkyTv.A(NSTIJKPlayerSkyTv.this) != null) {
                NSTIJKPlayerSkyTv.A(NSTIJKPlayerSkyTv.this).onPrepared(NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this));
            }
            NSTIJKPlayerSkyTv.D(NSTIJKPlayerSkyTv.this);
            NSTIJKPlayerSkyTv.l(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSkyTv.o(NSTIJKPlayerSkyTv.this, iMediaPlayer.getVideoHeight());
            int J = NSTIJKPlayerSkyTv.J(NSTIJKPlayerSkyTv.this);
            if (J != 0) {
                NSTIJKPlayerSkyTv.this.seekTo(J);
            }
            if (NSTIJKPlayerSkyTv.k(NSTIJKPlayerSkyTv.this) == 0 || NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this) == 0) {
                if (NSTIJKPlayerSkyTv.W(NSTIJKPlayerSkyTv.this) == 3) {
                    NSTIJKPlayerSkyTv.this.start();
                    return;
                }
                return;
            }
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = NSTIJKPlayerSkyTv.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerSkyTv.P;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerSkyTv.k(nSTIJKPlayerSkyTv), NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this));
                NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = NSTIJKPlayerSkyTv.this;
                nSTIJKPlayerSkyTv2.P.a(NSTIJKPlayerSkyTv.p(nSTIJKPlayerSkyTv2), NSTIJKPlayerSkyTv.u(NSTIJKPlayerSkyTv.this));
                if (!NSTIJKPlayerSkyTv.this.P.d() || (NSTIJKPlayerSkyTv.L(NSTIJKPlayerSkyTv.this) == NSTIJKPlayerSkyTv.k(NSTIJKPlayerSkyTv.this) && NSTIJKPlayerSkyTv.S(NSTIJKPlayerSkyTv.this) == NSTIJKPlayerSkyTv.n(NSTIJKPlayerSkyTv.this))) {
                    if (NSTIJKPlayerSkyTv.W(NSTIJKPlayerSkyTv.this) == 3) {
                        NSTIJKPlayerSkyTv.this.start();
                    } else {
                        if (NSTIJKPlayerSkyTv.this.isPlaying()) {
                            return;
                        }
                        if (J == 0 && NSTIJKPlayerSkyTv.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerSkyTv.D(NSTIJKPlayerSkyTv.this);
                }
            }
        }
    }

    public class t implements IMediaPlayer.OnCompletionListener {
        public t() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSkyTv.x(NSTIJKPlayerSkyTv.this, 5);
            NSTIJKPlayerSkyTv.X(NSTIJKPlayerSkyTv.this, 5);
            NSTIJKPlayerSkyTv.D(NSTIJKPlayerSkyTv.this);
            NSTIJKPlayerSkyTv.this.C1();
            NSTIJKPlayerSkyTv.this.y1();
            NSTIJKPlayerSkyTv.this.d1(5000);
            if (NSTIJKPlayerSkyTv.Y(NSTIJKPlayerSkyTv.this) != null) {
                NSTIJKPlayerSkyTv.Y(NSTIJKPlayerSkyTv.this).onCompletion(NSTIJKPlayerSkyTv.B(NSTIJKPlayerSkyTv.this));
            }
        }
    }

    public class u implements IMediaPlayer.OnInfoListener {
        public u() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String b0;
            String str;
            if (NSTIJKPlayerSkyTv.Z(NSTIJKPlayerSkyTv.this) != null) {
                NSTIJKPlayerSkyTv.Z(NSTIJKPlayerSkyTv.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerSkyTv.c0(NSTIJKPlayerSkyTv.this, 2);
                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerSkyTv.c0(NSTIJKPlayerSkyTv.this, 1);
                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerSkyTv.i0(NSTIJKPlayerSkyTv.this, i2);
                        Log.d(NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = NSTIJKPlayerSkyTv.this.P;
                        if (aVar != null) {
                            aVar.setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerSkyTv.c0(NSTIJKPlayerSkyTv.this, 1);
                                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerSkyTv.c0(NSTIJKPlayerSkyTv.this, 6);
                                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                b0 = NSTIJKPlayerSkyTv.b0(NSTIJKPlayerSkyTv.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(b0, str);
            return true;
        }
    }

    public static abstract class v {
    }

    public class w implements View.OnFocusChangeListener {
        public final View a;

        public w(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                if (z) {
                    return;
                }
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerSkyTv.T0(NSTIJKPlayerSkyTv.this) != null) {
                    NSTIJKPlayerSkyTv.T0(NSTIJKPlayerSkyTv.this).setBackgroundResource(a7.e.o);
                }
                a(1.0f);
                b(1.0f);
                return;
            }
            View view3 = this.a;
            if (view3 != null && view3.getTag() != null && this.a.getTag().equals("2")) {
                view.setBackground(NSTIJKPlayerSkyTv.this.getResources().getDrawable(a7.e.K1));
                return;
            }
            float f = z ? 1.12f : 1.0f;
            a(f);
            b(f);
            View view4 = this.a;
            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1") || NSTIJKPlayerSkyTv.T0(NSTIJKPlayerSkyTv.this) == null) {
                return;
            }
            NSTIJKPlayerSkyTv.T0(NSTIJKPlayerSkyTv.this).setBackgroundResource(a7.e.h);
        }
    }

    public class x extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public x() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.a = true;
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            NSTIJKPlayerSkyTv.this.H1();
            return true;
        }
    }

    public class y {
        public final Activity a;
        public View b;

        public y(Activity activity) {
            this.a = activity;
        }

        public y a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public y b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public y c() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public y d(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public y e() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public static class z extends AsyncTask {
        public final Context a;

        public z(Context context) {
            this.a = context;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            LiveStreamDBHandler liveStreamDBHandler;
            String g;
            String str;
            try {
                LiveStreamDBHandler liveStreamDBHandler2 = NSTIJKPlayerSkyTv.S1;
                if (liveStreamDBHandler2 != null) {
                    liveStreamDBHandler2.deleteLiveRecentlyWatched(x7.a.f().g());
                    if (NSTIJKPlayerSkyTv.b1().equalsIgnoreCase("true")) {
                        liveStreamDBHandler = NSTIJKPlayerSkyTv.S1;
                        g = x7.a.f().g();
                        str = "radio_streams";
                    } else {
                        liveStreamDBHandler = NSTIJKPlayerSkyTv.S1;
                        g = x7.a.f().g();
                        str = "live";
                    }
                    liveStreamDBHandler.addLiveRecentlyWatched(g, str);
                    NSTIJKPlayerSkyTv.S1.deleteExtraLiveRecentlyWatched();
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            try {
                if (bool.booleanValue()) {
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = this.a;
                    if (nSTIJKPlayerSkyTvActivity instanceof NSTIJKPlayerSkyTvActivity) {
                        nSTIJKPlayerSkyTvActivity.b4(2);
                    }
                }
            } catch (Exception unused) {
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public NSTIJKPlayerSkyTv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerSkyTv";
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = -1L;
        this.A = true;
        this.B = false;
        this.C = 7000;
        this.F = 0;
        this.H = 0;
        this.I = 5;
        this.J = false;
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        this.e0 = "visible";
        this.j0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.p0 = bool;
        this.q0 = bool;
        this.r0 = bool;
        this.s0 = bool;
        this.t0 = bool;
        this.u0 = bool;
        this.v0 = false;
        this.y0 = false;
        this.z0 = false;
        this.H0 = false;
        this.I0 = false;
        this.L0 = false;
        this.f1 = 0;
        this.t1 = false;
        this.B1 = new k();
        this.C1 = new n();
        this.D1 = new r();
        this.E1 = new s();
        this.F1 = new t();
        this.G1 = new u();
        this.H1 = new a();
        this.I1 = new b();
        this.J1 = new c();
        this.K1 = new d();
        this.L1 = new e();
        this.M1 = 4;
        this.N1 = U1[0];
        this.O1 = new ArrayList();
        this.P1 = 0;
        this.Q1 = 0;
        this.R1 = false;
        n1(context);
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener A(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.q;
    }

    public static /* synthetic */ void A0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        nSTIJKPlayerSkyTv.E1();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0184 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A1(int r15) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv.A1(int):void");
    }

    public static /* synthetic */ IMediaPlayer B(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.j;
    }

    public static /* synthetic */ SharedPreferences.Editor B0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.G0;
    }

    public static /* synthetic */ w7.b D(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        nSTIJKPlayerSkyTv.getClass();
        return null;
    }

    public static /* synthetic */ SharedPreferences.Editor D0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, SharedPreferences.Editor editor) {
        nSTIJKPlayerSkyTv.G0 = editor;
        return editor;
    }

    public static /* synthetic */ Activity E(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.f0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void E1() {
        int i2;
        CharSequence[] charSequenceArr = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"};
        a.a aVar = new a.a(getContext());
        aVar.setTitle(getResources().getString(a7.j.R7));
        String string = this.J0.getString("pref.using_sub_font_size", m7.a.x0);
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case 1567:
                if (string.equals("10")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1569:
                if (string.equals("12")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1571:
                if (string.equals("14")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1573:
                if (string.equals("16")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1575:
                if (string.equals("18")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1598:
                if (string.equals("20")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1600:
                if (string.equals("22")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1602:
                if (string.equals("24")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1604:
                if (string.equals("26")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1606:
                if (string.equals("28")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1629:
                if (string.equals("30")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1631:
                if (string.equals("32")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1633:
                if (string.equals("34")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1635:
                if (string.equals("36")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1637:
                if (string.equals("38")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1660:
                if (string.equals("40")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
            case '\b':
                i2 = 8;
                break;
            case '\t':
                i2 = 9;
                break;
            case '\n':
                i2 = 10;
                break;
            case 11:
                i2 = 11;
                break;
            case '\f':
                i2 = 12;
                break;
            case '\r':
                i2 = 13;
                break;
            case 14:
                i2 = 14;
                break;
            case 15:
                i2 = 15;
                break;
        }
        aVar.l(charSequenceArr, i2, new l());
        androidx.appcompat.app.a create = aVar.create();
        this.V0 = create;
        create.setOnDismissListener(new m());
        this.V0.show();
    }

    public static /* synthetic */ AudioManager F0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.h0;
    }

    private void F1(String str) {
        try {
            SharedPreferences sharedPreferences = this.f0.getSharedPreferences("pref.using_sub_font_size", 0);
            this.J0 = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.S0 = edit;
            if (edit != null) {
                edit.putString("pref.using_sub_font_size", str);
                this.S0.apply();
            }
        } catch (Exception unused) {
        }
    }

    private void I1() {
        View findViewById = this.f0.findViewById(a7.f.p);
        this.m0 = findViewById;
        findViewById.setClickable(true);
        this.m0.setOnTouchListener(new o());
    }

    public static /* synthetic */ int J(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.u;
    }

    public static /* synthetic */ SharedPreferences J0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.D0;
    }

    private void J1() {
        y yVar;
        int i2;
        try {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer == null || !iMediaPlayer.isPlaying()) {
                this.n0.b(a7.f.H5).a();
                yVar = this.n0;
                i2 = a7.f.I5;
            } else {
                this.n0.b(a7.f.I5).a();
                yVar = this.n0;
                i2 = a7.f.H5;
            }
            yVar.b(i2).e();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ SharedPreferences.Editor K0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.F0;
    }

    public static /* synthetic */ int L(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.m;
    }

    public static /* synthetic */ SharedPreferences.Editor L0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, SharedPreferences.Editor editor) {
        nSTIJKPlayerSkyTv.F0 = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences M0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.C0;
    }

    public static /* synthetic */ SharedPreferences.Editor N0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.E0;
    }

    public static /* synthetic */ SharedPreferences.Editor O0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, SharedPreferences.Editor editor) {
        nSTIJKPlayerSkyTv.E0 = editor;
        return editor;
    }

    public static /* synthetic */ int P(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.m = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences Q0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.B0;
    }

    public static /* synthetic */ void R0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, String str) {
        nSTIJKPlayerSkyTv.F1(str);
    }

    public static /* synthetic */ int S(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.n;
    }

    public static /* synthetic */ TextView S0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.T0;
    }

    public static /* synthetic */ int T(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.n = i2;
        return i2;
    }

    public static /* synthetic */ Button T0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.o0;
    }

    public static /* synthetic */ int W(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.h;
    }

    public static /* synthetic */ int W0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.i0;
    }

    public static /* synthetic */ int X(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.h = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener Y(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.p;
    }

    public static /* synthetic */ TextView Y0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.h1;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener Z(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.t;
    }

    public static /* synthetic */ GestureDetector Z0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.k0;
    }

    public static /* synthetic */ int a1(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.I;
    }

    public static /* synthetic */ String b0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.a;
    }

    public static /* synthetic */ String b1() {
        return T1;
    }

    public static /* synthetic */ void c0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.A1(i2);
    }

    private void c1() {
    }

    private void e1(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    public static /* synthetic */ float f(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.j0;
    }

    private String f1(String str) {
        return TextUtils.isEmpty(str) ? "und" : str;
    }

    public static /* synthetic */ float g(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, float f2) {
        nSTIJKPlayerSkyTv.j0 = f2;
        return f2;
    }

    public static /* synthetic */ TextView h(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.g1;
    }

    public static /* synthetic */ int i0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.o = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener j0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.s;
    }

    public static /* synthetic */ int k(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.k;
    }

    public static /* synthetic */ u7.a k0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.O;
    }

    public static /* synthetic */ int l(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.k = i2;
        return i2;
    }

    public static /* synthetic */ int l0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.r;
    }

    private void l1() {
        boolean p2 = this.O.p();
        this.R1 = p2;
        if (p2) {
            v7.a.b(getContext());
            this.j = v7.a.a();
        }
    }

    public static /* synthetic */ int m0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.r = i2;
        return i2;
    }

    private void m1() {
        this.O1.clear();
        if (this.O.s()) {
            this.O1.add(1);
        }
        if (this.O.t()) {
            this.O1.add(2);
        }
        if (this.O.r()) {
            this.O1.add(0);
        }
        if (this.O1.isEmpty()) {
            this.O1.add(1);
        }
        int intValue = ((Integer) this.O1.get(this.P1)).intValue();
        this.Q1 = intValue;
        setRender(intValue);
    }

    public static /* synthetic */ int n(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.l;
    }

    public static /* synthetic */ long n0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, long j2) {
        nSTIJKPlayerSkyTv.V = j2;
        return j2;
    }

    private void n1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.N = applicationContext;
        this.O = new u7.a(applicationContext);
        this.K0 = new n7.l(this, this.N);
        l1();
        m1();
        this.k = 0;
        this.l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.g = 0;
        this.h = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref.using_sub_font_size", 0);
        this.J0 = sharedPreferences;
        String string = sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0);
        TextView textView = new TextView(context);
        this.W = textView;
        try {
            textView.setTextSize(2, Float.parseFloat(string));
        } catch (Exception unused) {
        }
        this.W.setTextColor(context.getResources().getColor(a7.c.G));
        this.W.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.setMargins(0, 0, 0, 40);
        addView(this.W, layoutParams);
    }

    public static /* synthetic */ int o(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.l = i2;
        return i2;
    }

    public static /* synthetic */ int p(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.Q;
    }

    public static /* synthetic */ SharedPreferences p0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.J0;
    }

    private boolean p1() {
        int i2;
        return (this.j == null || (i2 = this.g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public static /* synthetic */ SharedPreferences q0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, SharedPreferences sharedPreferences) {
        nSTIJKPlayerSkyTv.J0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ int r(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.Q = i2;
        return i2;
    }

    public static /* synthetic */ Context r0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.N;
    }

    public static /* synthetic */ a.b s0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, a.b bVar) {
        nSTIJKPlayerSkyTv.i = bVar;
        return bVar;
    }

    public static /* synthetic */ void t0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerSkyTv.e1(iMediaPlayer, bVar);
    }

    public static /* synthetic */ int u(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.R;
    }

    public static /* synthetic */ int v(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.R = i2;
        return i2;
    }

    public static /* synthetic */ long w(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, long j2) {
        nSTIJKPlayerSkyTv.T = j2;
        return j2;
    }

    private void w1(Uri uri, Map map, boolean z2, String str) {
        this.c = uri;
        this.d = str;
        this.e = map;
        this.u = 0;
        this.G = z2;
        this.F = this.F;
        D1();
        q1();
        requestLayout();
        invalidate();
    }

    public static /* synthetic */ int x(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, int i2) {
        nSTIJKPlayerSkyTv.g = i2;
        return i2;
    }

    public static /* synthetic */ LinearLayout x0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.Y0;
    }

    public static /* synthetic */ y z(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.n0;
    }

    public static /* synthetic */ LinearLayout z0(NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv) {
        return nSTIJKPlayerSkyTv.i1;
    }

    public void B1() {
        v7.a.d(null);
    }

    public void C1() {
        Handler handler = this.Z0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void D1() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.g = 0;
            this.h = 0;
            ((AudioManager) this.N.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void E0(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int G1() {
        /*
            r6 = this;
            int r0 = r6.M1
            r1 = 1
            int r0 = r0 + r1
            r6.M1 = r0
            android.app.Activity r0 = r6.f0
            java.lang.String r2 = "loginPrefs"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            r6.K = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.L = r0
            int r0 = r6.M1
            int[] r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv.U1
            int r4 = r2.length
            int r0 = r0 % r4
            r6.M1 = r0
            r0 = r2[r0]
            r6.N1 = r0
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r0 = r6.P
            if (r0 == 0) goto Lb1
            android.app.Activity r0 = r6.f0
            int r2 = a7.f.X6
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.app.Activity r2 = r6.f0
            int r4 = a7.f.n
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r4 = r6.P
            int r5 = r6.N1
            r4.setAspectRatio(r5)
            int r4 = r6.M1
            if (r4 != 0) goto L54
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j2
        L4c:
            java.lang.String r1 = r1.getString(r4)
        L50:
            r2.setText(r1)
            goto L7d
        L54:
            if (r4 != r1) goto L5d
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.i2
            goto L4c
        L5d:
            r1 = 2
            if (r4 != r1) goto L67
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.Q8
            goto L4c
        L67:
            r1 = 3
            if (r4 != r1) goto L71
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j3
            goto L4c
        L71:
            r1 = 4
            if (r4 != r1) goto L77
            java.lang.String r1 = "16:9"
            goto L50
        L77:
            r1 = 5
            if (r4 != r1) goto L7d
            java.lang.String r1 = "4:3"
            goto L50
        L7d:
            android.content.SharedPreferences$Editor r1 = r6.L
            java.lang.String r2 = "aspect_ratio"
            int r4 = r6.M1
            r1.putInt(r2, r4)
            android.content.SharedPreferences$Editor r1 = r6.L
            r1.apply()
            r0.setVisibility(r3)
            android.widget.LinearLayout r1 = r6.i1
            if (r1 == 0) goto L9f
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L9f
            android.widget.LinearLayout r1 = r6.i1
            r2 = 8
            r1.setVisibility(r2)
        L9f:
            android.os.Handler r1 = r6.E
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.E
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv$f r2 = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv$f
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
        Lb1:
            int r0 = r6.N1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv.G1():int");
    }

    public void H1() {
        RelativeLayout relativeLayout;
        SeekBar seekBar = this.X0;
        if (seekBar != null) {
            seekBar.setProgress(this.h0.getStreamVolume(3));
        }
        C1();
        if (this.l1.getVisibility() == 0) {
            this.l1.startAnimation(this.m1);
            relativeLayout = this.l1;
        } else {
            if (this.r1.getVisibility() != 0) {
                if (this.Y0.getVisibility() == 0) {
                    k1();
                    return;
                } else {
                    y1();
                    d1(5000);
                    return;
                }
            }
            this.r1.startAnimation(this.p1);
            relativeLayout = this.r1;
        }
        relativeLayout.setVisibility(8);
    }

    public void K(VodInfoCallback vodInfoCallback) {
    }

    public void a() {
    }

    public void b() {
    }

    public boolean canPause() {
        return this.v;
    }

    public boolean canSeekBackward() {
        return this.w;
    }

    public boolean canSeekForward() {
        return this.x;
    }

    public void d(String str) {
    }

    public void d1(int i2) {
        q qVar = new q();
        this.a1 = qVar;
        this.Z0.postDelayed(qVar, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0052 A[PHI: r2
      0x0052: PHI (r2v1 java.lang.String) = (r2v0 java.lang.String), (r2v6 java.lang.String) binds: [B:9:0x002e, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tv.danmaku.ijk.media.player.IMediaPlayer g1(int r10) {
        /*
            r9 = this;
            r0 = 1
            if (r10 == r0) goto Lc9
            boolean r10 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.r3()
            if (r10 != 0) goto L14
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv$y r10 = r9.n0
            int r1 = a7.f.A
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv$y r10 = r10.b(r1)
            r10.e()
        L14:
            android.net.Uri r10 = r9.c
            if (r10 == 0) goto Lc7
            tv.danmaku.ijk.media.player.IjkMediaPlayer r10 = new tv.danmaku.ijk.media.player.IjkMediaPlayer
            r10.<init>()
            r1 = 3
            tv.danmaku.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r1)
            u7.a r1 = r9.O
            boolean r1 = r1.D()
            java.lang.String r2 = "mediacodec"
            r3 = 0
            r5 = 1
            r7 = 4
            if (r1 == 0) goto L52
            r10.setOption(r7, r2, r5)
            u7.a r1 = r9.O
            boolean r1 = r1.E()
            java.lang.String r2 = "mediacodec-auto-rotate"
            if (r1 == 0) goto L41
            r10.setOption(r7, r2, r5)
            goto L44
        L41:
            r10.setOption(r7, r2, r3)
        L44:
            u7.a r1 = r9.O
            boolean r1 = r1.v()
            java.lang.String r2 = "mediacodec-handle-resolution-change"
            if (r1 == 0) goto L52
            r10.setOption(r7, r2, r5)
            goto L55
        L52:
            r10.setOption(r7, r2, r3)
        L55:
            java.lang.String r1 = "subtitle"
            r10.setOption(r7, r1, r5)
            u7.a r1 = r9.O
            boolean r1 = r1.G()
            java.lang.String r2 = "opensles"
            if (r1 == 0) goto L68
            r10.setOption(r7, r2, r5)
            goto L6b
        L68:
            r10.setOption(r7, r2, r3)
        L6b:
            u7.a r1 = r9.O
            java.lang.String r1 = r1.w()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = "overlay-format"
            if (r1 == 0) goto L80
            r3 = 842225234(0x32335652, double:4.16114554E-315)
            r10.setOption(r7, r2, r3)
            goto L85
        L80:
            java.lang.String r1 = "fcc-_es2"
            r10.setOption(r7, r2, r1)
        L85:
            java.lang.String r1 = "framedrop"
            r10.setOption(r7, r1, r5)
            java.lang.String r1 = "start-on-prepared"
            r10.setOption(r7, r1, r5)
            android.app.Activity r1 = r9.f0
            java.lang.String r2 = "user_agent"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r9.M = r1
            java.lang.String r4 = "IPTVSmartersPlayer"
            java.lang.String r1 = r1.getString(r2, r4)
            java.lang.String r8 = ""
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto Lac
            r10.setOption(r0, r2, r1)
            goto Laf
        Lac:
            r10.setOption(r0, r2, r4)
        Laf:
            java.lang.String r0 = "mediacodec-hevc"
            r10.setOption(r7, r0, r5)
            java.lang.String r0 = "0"
            r1 = 48
            r4 = 2
            r10.setOption(r4, r0, r1)
            android.app.Activity r0 = r9.f0
            java.lang.String r1 = "pref.using_buffer_size"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r3)
            r9.q1 = r0
            goto Lce
        Lc7:
            r10 = 0
            goto Lce
        Lc9:
            tv.danmaku.ijk.media.player.AndroidMediaPlayer r10 = new tv.danmaku.ijk.media.player.AndroidMediaPlayer
            r10.<init>()
        Lce:
            u7.a r0 = r9.O
            boolean r0 = r0.q()
            if (r0 == 0) goto Ldc
            tv.danmaku.ijk.media.player.TextureMediaPlayer r0 = new tv.danmaku.ijk.media.player.TextureMediaPlayer
            r0.<init>(r10)
            r10 = r0
        Ldc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv.g1(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.j != null) {
            return this.r;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (p1()) {
            return (int) this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentWindowIndex() {
        return this.F;
    }

    public int getDuration() {
        if (p1()) {
            return (int) this.j.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.G);
    }

    public int getNewSeekPosition() {
        return (int) this.z;
    }

    public boolean getPlayerIsPrepared() {
        return this.L0;
    }

    public String getShowOrHideSubtitles() {
        return this.e0;
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void h1(int i2) {
        w7.e.b(this.j, i2);
    }

    public void i1() {
        v7.a.d(this.j);
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return p1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying();
    }

    public void j1(Boolean bool) {
        this.G = bool.booleanValue();
    }

    public void k1() {
        if (this.Y0.getVisibility() == 0) {
            this.Y0.startAnimation(this.c1);
            this.y1.startAnimation(this.c1);
            this.z1.startAnimation(this.c1);
            this.A1.startAnimation(this.c1);
            if (this.d1.getVisibility() == 0) {
                this.d1.startAnimation(this.c1);
            }
            if (this.i1.getVisibility() == 0) {
                this.i1.startAnimation(this.c1);
            }
            if (this.e1.getVisibility() == 0) {
                this.e1.startAnimation(this.c1);
            }
            this.Y0.setVisibility(8);
            if (this.d1.getVisibility() == 0) {
                this.d1.setVisibility(8);
            }
            if (this.i1.getVisibility() == 0) {
                this.i1.setVisibility(8);
            }
            if (this.e1.getVisibility() == 0) {
                this.e1.setVisibility(8);
            }
            this.y1.setVisibility(8);
            this.z1.setVisibility(8);
            this.A1.setVisibility(8);
        }
    }

    public boolean o1() {
        return this.R1;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        p1();
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (p1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying()) {
            this.j.pause();
            this.g = 4;
        }
        this.h = 4;
    }

    public void q1() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.i == null) {
            return;
        }
        r1(false);
        try {
            ((AudioManager) this.N.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            this.j = g1(this.O.x());
            getContext();
            this.j.setOnPreparedListener(this.E1);
            this.j.setOnVideoSizeChangedListener(this.D1);
            this.j.setOnCompletionListener(this.F1);
            this.j.setOnErrorListener(this.H1);
            this.j.setOnInfoListener(this.G1);
            this.j.setOnBufferingUpdateListener(this.I1);
            this.j.setOnSeekCompleteListener(this.J1);
            this.j.setOnTimedTextListener(this.K1);
            this.r = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.O.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.j.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.j.setDataSource(this.N, this.c, this.e);
            }
            e1(this.j, this.i);
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
            this.S = System.currentTimeMillis();
            this.j.prepareAsync();
            this.l0 = this.f0.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.f0.getSystemService("audio");
            this.h0 = audioManager;
            this.i0 = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.h0.getStreamVolume(3);
            this.X0.setMax(this.h0.getStreamMaxVolume(3));
            this.X0.setProgress(streamVolume);
            this.k0 = new GestureDetector(this.f0, new x());
            I1();
            this.w0 = new StringBuilder();
            this.x0 = new Formatter(this.w0, Locale.getDefault());
            this.g = 1;
        } catch (NullPointerException e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.H1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IllegalArgumentException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.H1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IOException e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.H1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Exception e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.H1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void r1(boolean z2) {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.g = 0;
            if (z2) {
                this.h = 0;
            }
            ((AudioManager) this.N.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void s1() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void seekTo(int i2) {
        if (p1()) {
            this.U = System.currentTimeMillis();
            this.j.seekTo(i2);
            i2 = 0;
        }
        this.u = i2;
    }

    public void setAdjustViewBounds(boolean z2) {
        if (this.s1 == z2) {
            return;
        }
        this.s1 = z2;
        if (z2) {
            setBackground((Drawable) null);
        } else {
            setBackgroundColor(-16777216);
        }
        requestLayout();
    }

    public void setContext(Context context) {
        this.x1 = context;
    }

    public void setCurrentChannelLogo(String str) {
        this.v1 = str;
    }

    public void setCurrentEpgChannelID(String str) {
        this.u1 = str;
    }

    public void setCurrentWindowIndex(int i2) {
        this.F = i2;
    }

    public void setEPGHandler(Handler handler) {
        this.w1 = handler;
    }

    public void setHudView(TableLayout tableLayout) {
    }

    public void setLiveStreamDBHandler(LiveStreamDBHandler liveStreamDBHandler) {
        S1 = liveStreamDBHandler;
    }

    public void setMediaController(w7.b bVar) {
        c1();
    }

    public void setMovieListener(v vVar) {
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
    }

    public void setRender(int i2) {
        SurfaceView surfaceView;
        if (i2 == 0) {
            surfaceView = null;
        } else if (i2 == 1) {
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b(getContext());
        } else {
            if (i2 != 2) {
                Log.e(this.a, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i2)}));
                return;
            }
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c(getContext());
            if (this.j != null) {
                surfaceView.getSurfaceHolder().b(this.j);
                surfaceView.c(this.j.getVideoWidth(), this.j.getVideoHeight());
                surfaceView.a(this.j.getVideoSarNum(), this.j.getVideoSarDen());
                surfaceView.setAspectRatio(this.N1);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.P != null) {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.P.getView();
            this.P.b(this.L1);
            this.P = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.P = aVar;
        SharedPreferences sharedPreferences = this.N.getSharedPreferences("loginPrefs", 0);
        this.K = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.M1 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.k;
        if (i5 > 0 && (i3 = this.l) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.Q;
        if (i6 > 0 && (i2 = this.R) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.P.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.P.e(this.L1);
        this.P.setVideoRotation(this.o);
    }

    public void setShowOrHideSubtitles(String str) {
        this.e0 = str;
    }

    public void setTitle(CharSequence charSequence) {
        this.n0.b(a7.f.lj).d(charSequence);
    }

    public void start() {
        if (p1()) {
            this.j.start();
            this.g = 3;
        }
        this.h = 3;
    }

    public void t1() {
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void u1(int i2) {
        w7.e.e(this.j, i2);
    }

    public void v1(Activity activity, NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView, TextView textView2, TextView textView3, TextView textView4, SeekBar seekBar, SeekBar seekBar2, LinearLayout linearLayout, Animation animation, Animation animation2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4, Animation animation3, Animation animation4, TextView textView6, RelativeLayout relativeLayout, Animation animation5, Animation animation6, Animation animation7, RelativeLayout relativeLayout2, Animation animation8, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, FrameLayout frameLayout, String str) {
        this.f0 = activity;
        T1 = str;
        this.g0 = nSTIJKPlayerSkyTv;
        this.D = new Handler();
        this.E = new Handler();
        this.P0 = radioGroup;
        this.Q0 = radioGroup2;
        this.R0 = radioGroup3;
        this.O0 = textView;
        this.N0 = textView2;
        this.M0 = textView3;
        this.T0 = textView4;
        this.W0 = seekBar;
        this.X0 = seekBar2;
        this.Y0 = linearLayout;
        this.Z0 = new Handler();
        this.b1 = animation;
        this.c1 = animation2;
        this.d1 = linearLayout2;
        this.e1 = linearLayout3;
        this.W0.setOnSeekBarChangeListener(this.B1);
        this.X0.setOnSeekBarChangeListener(this.C1);
        this.g1 = textView5;
        seekBar.setKeyProgressIncrement(1);
        float f2 = this.f0.getWindow().getAttributes().screenBrightness;
        this.j0 = f2;
        if (f2 == -1.0f) {
            this.j0 = this.O != null ? r3.o() : m7.a.J0;
        }
        seekBar.setProgress((int) this.j0);
        this.i1 = linearLayout4;
        this.j1 = animation3;
        this.k1 = animation4;
        this.h1 = textView6;
        this.l1 = relativeLayout;
        this.m1 = animation5;
        this.n1 = animation6;
        this.o1 = animation7;
        this.r1 = relativeLayout2;
        this.p1 = animation8;
        this.A1 = linearLayout7;
        this.z1 = linearLayout6;
        this.y1 = linearLayout5;
        this.n0 = new y(activity);
        this.U0 = frameLayout;
    }

    public void x1(Uri uri, boolean z2, String str) {
        w1(uri, null, z2, str);
    }

    public void y1() {
        if (NSTIJKPlayerSkyTvActivity.G5 && this.Y0.getVisibility() == 8) {
            this.Y0.startAnimation(this.b1);
            this.Y0.setVisibility(0);
            if (this.d1.getVisibility() == 8) {
                this.d1.startAnimation(this.b1);
                this.d1.setVisibility(0);
            }
            if (this.i1.getVisibility() == 8 && !NSTIJKPlayerSkyTvActivity.r3()) {
                this.i1.startAnimation(this.b1);
                this.i1.setVisibility(0);
            }
            if (this.e1.getVisibility() == 8) {
                this.e1.startAnimation(this.b1);
                this.e1.setVisibility(0);
            }
            this.y1.startAnimation(this.b1);
            this.y1.setVisibility(0);
            this.z1.startAnimation(this.b1);
            this.z1.setVisibility(0);
            this.A1.startAnimation(this.b1);
            this.A1.setVisibility(0);
        }
    }

    public void z1(RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout) {
        TextView textView5;
        int i2;
        ITrackInfo[] iTrackInfoArr;
        int i3;
        if (this.j == null) {
            return;
        }
        radioGroup.removeAllViews();
        radioGroup2.removeAllViews();
        radioGroup3.removeAllViews();
        try {
            SharedPreferences sharedPreferences = this.f0.getSharedPreferences("pref.using_sub_font_size", 0);
            this.J0 = sharedPreferences;
            textView4.setText(sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0));
            frameLayout.setOnClickListener(new g());
        } catch (Exception unused) {
        }
        Boolean bool = Boolean.FALSE;
        this.u0 = bool;
        this.t0 = bool;
        this.s0 = bool;
        this.q0 = bool;
        this.p0 = bool;
        this.r0 = bool;
        int d2 = w7.e.d(this.j, 1);
        int d3 = w7.e.d(this.j, 2);
        int d4 = w7.e.d(this.j, 3);
        ITrackInfo[] trackInfo = this.j.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            textView5 = textView3;
            i2 = 0;
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            int i4 = 0;
            int i5 = -1;
            for (int length = trackInfo.length; i4 < length; length = i3) {
                ITrackInfo iTrackInfo = trackInfo[i4];
                int i6 = i5 + 1;
                int trackType = iTrackInfo.getTrackType();
                IMediaFormat format = iTrackInfo.getFormat();
                if (format != null && (format instanceof IjkMediaFormat)) {
                    iTrackInfoArr = trackInfo;
                    i3 = length;
                    if (trackType == 1) {
                        Boolean bool2 = Boolean.TRUE;
                        this.s0 = bool2;
                        if (!this.p0.booleanValue()) {
                            this.p0 = bool2;
                            RadioButton radioButton = new RadioButton(this.f0);
                            radioButton.setText("Disable");
                            radioButton.setTextColor(getResources().getColor(a7.c.G));
                            radioButton.setTextSize(13.0f);
                            radioButton.setId(11111111);
                            radioButton.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton.setPadding(0, 0, 16, 0);
                            radioButton.setOnFocusChangeListener(new w(radioButton));
                            if (d2 == -1) {
                                radioButton.setChecked(true);
                                radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton.setTag("2");
                            radioGroup.addView(radioButton);
                        }
                        RadioButton radioButton2 = new RadioButton(this.f0);
                        iTrackInfo.getInfoInline();
                        radioButton2.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        if (i6 == -1) {
                            radioButton2.setId(111);
                        } else {
                            radioButton2.setId(i6);
                        }
                        radioButton2.setTextColor(getResources().getColor(a7.c.G));
                        radioButton2.setTextSize(13.0f);
                        radioButton2.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        radioButton2.setPadding(0, 0, 16, 0);
                        radioButton2.setOnFocusChangeListener(new w(radioButton2));
                        if (i6 == d2) {
                            radioButton2.setChecked(true);
                            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton2.setTag("2");
                        radioGroup.addView(radioButton2);
                        radioGroup.setOnCheckedChangeListener(new h(d2));
                        i4++;
                        i5 = i6;
                        trackInfo = iTrackInfoArr;
                    } else if (trackType == 2) {
                        Boolean bool3 = Boolean.TRUE;
                        this.t0 = bool3;
                        if (!this.q0.booleanValue()) {
                            this.q0 = bool3;
                            RadioButton radioButton3 = new RadioButton(this.f0);
                            radioButton3.setText("Disable");
                            radioButton3.setTextColor(getResources().getColor(a7.c.G));
                            radioButton3.setTextSize(13.0f);
                            radioButton3.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton3.setId(1111111);
                            radioButton3.setPadding(0, 0, 16, 0);
                            radioButton3.setOnFocusChangeListener(new w(radioButton3));
                            if (d3 == -1) {
                                radioButton3.setChecked(true);
                                radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton3.setTag("2");
                            radioGroup2.addView(radioButton3);
                        }
                        RadioButton radioButton4 = new RadioButton(this.f0);
                        radioButton4.setText(i6 + ", " + iTrackInfo.getInfoInline() + ", " + f1(iTrackInfo.getLanguage()));
                        radioButton4.setTextColor(getResources().getColor(a7.c.G));
                        radioButton4.setTextSize(13.0f);
                        radioButton4.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        if (i6 == -1) {
                            radioButton4.setId(1111);
                        } else {
                            radioButton4.setId(i6);
                        }
                        radioButton4.setPadding(0, 0, 16, 0);
                        radioButton4.setOnFocusChangeListener(new w(radioButton4));
                        if (i6 == d3) {
                            radioButton4.setChecked(true);
                            radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton4.setTag("2");
                        radioGroup2.addView(radioButton4);
                        radioGroup2.setOnCheckedChangeListener(new i(d3));
                    } else if (trackType == 3) {
                        Boolean bool4 = Boolean.TRUE;
                        this.u0 = bool4;
                        if (!this.r0.booleanValue()) {
                            this.r0 = bool4;
                            RadioButton radioButton5 = new RadioButton(this.f0);
                            radioButton5.setText("Disable");
                            radioButton5.setTextColor(getResources().getColor(a7.c.G));
                            radioButton5.setTextSize(13.0f);
                            radioButton5.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                            radioButton5.setId(111111);
                            radioButton5.setPadding(0, 0, 16, 0);
                            radioButton5.setOnFocusChangeListener(new w(radioButton5));
                            if (d4 == -1) {
                                radioButton5.setChecked(true);
                                radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton5.setTag("2");
                            radioGroup3.addView(radioButton5);
                        }
                        RadioButton radioButton6 = new RadioButton(this.f0);
                        radioButton6.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        radioButton6.setTextColor(getResources().getColor(a7.c.G));
                        radioButton6.setTextSize(13.0f);
                        radioButton6.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.N, a7.c.G)));
                        if (i6 == -1) {
                            radioButton6.setId(11111);
                        } else {
                            radioButton6.setId(i6);
                        }
                        radioButton6.setPadding(0, 0, 16, 0);
                        radioButton6.setOnFocusChangeListener(new w(radioButton6));
                        if (i6 == d4) {
                            radioButton6.setChecked(true);
                            radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton6.setTag("2");
                        radioGroup3.addView(radioButton6);
                        radioGroup3.setOnCheckedChangeListener(new j(d4));
                    }
                } else {
                    iTrackInfoArr = trackInfo;
                    i3 = length;
                }
                i4++;
                i5 = i6;
                trackInfo = iTrackInfoArr;
            }
            if (this.s0.booleanValue()) {
                i2 = 0;
                textView.setVisibility(8);
            } else {
                i2 = 0;
                textView.setVisibility(0);
            }
            if (this.t0.booleanValue()) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(i2);
            }
            if (this.u0.booleanValue()) {
                textView3.setVisibility(8);
                return;
            }
            textView5 = textView3;
        }
        textView5.setVisibility(i2);
    }
}
