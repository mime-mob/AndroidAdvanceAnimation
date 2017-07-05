package com.mime.commonanim.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.mime.commonanim.interpolator.CircularRevealInterpolator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CircularRevealAnimator implements CircularRevealInterpolator {

    private Animator animator;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static CircularRevealAnimator circularReveal(View view, int x, int y, float startRadius, float endRadius) {
        return new CircularRevealAnimator().animate(view, x, y, startRadius, endRadius);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private CircularRevealAnimator animate(View view, int x, int y, float startRadius, float endRadius) {
        animator = ViewAnimationUtils.createCircularReveal(view, x, y, startRadius, endRadius);
        return this;
    }

    public CircularRevealAnimator duration(long time) {
        if(animator != null) {
            animator.setDuration(time);
        }
        return this;
    }

    public CircularRevealAnimator listener(ValueAnimator.AnimatorListener listener) {
        if(animator != null) {
            animator.addListener(listener);
        }
        return this;
    }

    public void start() {
        if(animator != null) {
            animator.start();
        }
    }

    public void cancel() {
        if(animator != null) {
            animator.cancel();
        }
    }

    @Override
    public CircularRevealAnimator linear() {
        if(animator != null) {
            animator.setInterpolator(new LinearInterpolator());
        }
        return this;
    }

    @Override
    public CircularRevealAnimator accelerate() {
        if(animator != null) {
            animator.setInterpolator(new AccelerateInterpolator());
        }
        return this;
    }

    @Override
    public CircularRevealAnimator decelerate() {
        if(animator != null) {
            animator.setInterpolator(new DecelerateInterpolator());
        }
        return this;
    }
}