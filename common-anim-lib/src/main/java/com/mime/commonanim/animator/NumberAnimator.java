package com.mime.commonanim.animator;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.mime.commonanim.interpolator.PropertyInterpolator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NumberAnimator implements PropertyInterpolator<NumberAnimator> {

    private ValueAnimator animator;

    public static NumberAnimator animateValue(float ...values) {
        return new NumberAnimator().animate(values);
    }

    private NumberAnimator animate(float ...values) {
        animator = ValueAnimator.ofFloat(values);
        return this;
    }

    public NumberAnimator duration(long time) {
        checkObj();
        animator.setDuration(time);
        return this;
    }

    public NumberAnimator updateListener(ValueAnimator.AnimatorUpdateListener listener) {
        checkObj();
        animator.addUpdateListener(listener);
        return this;
    }

    public NumberAnimator values(float ...values) {
        checkObj();
        animator.setFloatValues(values);
        return this;
    }

    public NumberAnimator loop(boolean loop) {
        checkObj();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        return this;
    }

    public NumberAnimator repeat(int count, int repeatMode) {
        checkObj();
        animator.setRepeatCount(count);
        animator.setRepeatMode(repeatMode);
        return this;
    }

    public NumberAnimator delay(long time) {
        checkObj();
        animator.setStartDelay(time);
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

    private void checkObj() {
        if(animator == null) {
            animator = new ValueAnimator();
        }
    }

    public NumberAnimator linear() {
        checkObj();
        animator.setInterpolator(new LinearInterpolator());
        return this;
    }

    public NumberAnimator accelerate() {
        checkObj();
        animator.setInterpolator(new AccelerateInterpolator());
        return this;
    }

    public NumberAnimator decelerate() {
        checkObj();
        animator.setInterpolator(new DecelerateInterpolator());
        return this;
    }

    public NumberAnimator accelerateDecelerate() {
        checkObj();
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return this;
    }

    public NumberAnimator anticipate() {
        checkObj();
        animator.setInterpolator(new AnticipateInterpolator());
        return this;
    }

    public NumberAnimator overshoot() {
        checkObj();
        animator.setInterpolator(new OvershootInterpolator());
        return this;
    }

    public NumberAnimator anticipateOvershoot() {
        checkObj();
        animator.setInterpolator(new AnticipateOvershootInterpolator());
        return this;
    }

    public NumberAnimator bounce() {
        checkObj();
        animator.setInterpolator(new BounceInterpolator());
        return this;
    }
}