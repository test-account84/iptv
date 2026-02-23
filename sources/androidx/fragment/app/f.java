package androidx.fragment.app;

import L.e;
import P.H;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {

    public class a implements e.b {
        public final /* synthetic */ Fragment a;

        public a(Fragment fragment) {
            this.a = fragment;
        }

        public void a() {
            if (this.a.getAnimatingAway() != null) {
                View animatingAway = this.a.getAnimatingAway();
                this.a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.a.setAnimator(null);
        }
    }

    public class b implements Animation.AnimationListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ x.g c;
        public final /* synthetic */ L.e d;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (b.this.b.getAnimatingAway() != null) {
                    b.this.b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.c.b(bVar.b, bVar.d);
                }
            }
        }

        public b(ViewGroup viewGroup, Fragment fragment, x.g gVar, L.e eVar) {
            this.a = viewGroup;
            this.b = fragment;
            this.c = gVar;
            this.d = eVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Fragment d;
        public final /* synthetic */ x.g e;
        public final /* synthetic */ L.e f;

        public c(ViewGroup viewGroup, View view, Fragment fragment, x.g gVar, L.e eVar) {
            this.a = viewGroup;
            this.c = view;
            this.d = fragment;
            this.e = gVar;
            this.f = eVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.c);
            Animator animator2 = this.d.getAnimator();
            this.d.setAnimator(null);
            if (animator2 == null || this.a.indexOfChild(this.c) >= 0) {
                return;
            }
            this.e.b(this.d, this.f);
        }
    }

    public static class d {
        public final Animation a;
        public final Animator b;

        public d(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        public d(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    public static class e extends AnimationSet implements Runnable {
        public final ViewGroup a;
        public final View c;
        public boolean d;
        public boolean e;
        public boolean f;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f = true;
            this.a = viewGroup;
            this.c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.f = true;
            if (this.d) {
                return !this.e;
            }
            if (!super.getTransformation(j, transformation)) {
                this.d = true;
                H.a(this.a, this);
            }
            return true;
        }

        public void run() {
            if (this.d || !this.f) {
                this.a.endViewTransition(this.c);
                this.e = true;
            } else {
                this.f = false;
                this.a.post(this);
            }
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f = true;
            if (this.d) {
                return !this.e;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.d = true;
                H.a(this.a, this);
            }
            return true;
        }
    }

    public static void a(Fragment fragment, d dVar, x.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        L.e eVar = new L.e();
        eVar.d(new a(fragment));
        gVar.a(fragment, eVar);
        if (dVar.a != null) {
            e eVar2 = new e(dVar.a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar2.setAnimationListener(new b(viewGroup, fragment, gVar, eVar));
            fragment.mView.startAnimation(eVar2);
            return;
        }
        Animator animator = dVar.b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, eVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static int b(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    public static d c(Context context, Fragment fragment, boolean z, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int b2 = b(fragment, z, z2);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(e0.b.c) != null) {
            fragment.mContainer.setTag(e0.b.c, (Object) null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, b2);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, b2);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (b2 == 0 && nextTransition != 0) {
            b2 = d(nextTransition, z);
        }
        if (b2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b2);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b2);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b2);
                    if (loadAnimation2 != null) {
                        return new d(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    public static int d(int i, boolean z) {
        if (i == 4097) {
            return z ? e0.a.e : e0.a.f;
        }
        if (i == 4099) {
            return z ? e0.a.c : e0.a.d;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? e0.a.a : e0.a.b;
    }
}
