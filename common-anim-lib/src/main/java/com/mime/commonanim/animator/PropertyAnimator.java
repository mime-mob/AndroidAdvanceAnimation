package com.mime.commonanim.animator;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
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
public abstract class PropertyAnimator implements PropertyInterpolator<PropertyAnimator> {

    public static final String ANIM_TRANSLATE_X = "translationX";
    public static final String ANIM_TRANSLATE_Y = "translationY";
    public static final String ANIM_TRANSLATE_Z = "translationZ";
    public static final String ANIM_ROTATE = "rotation";
    public static final String ANIM_ROTATE_X = "rotationX";
    public static final String ANIM_ROTATE_Y = "rotationY";
    public static final String ANIM_SCALE_X = "scaleX";
    public static final String ANIM_SCALE_Y = "scaleY";
    public static final String ANIM_ALPHA = "alpha";

    protected ObjectAnimator animator;

    protected abstract PropertyAnimator generate(View view, String propertyName, float ...values);

    public static TranslateAnimator translate(View view, String propertyName, float ...values) {
        return new TranslateAnimator().generate(view, propertyName, values);
    }

    public static RotateAnimator rotate(View view, String propertyName, float ...values) {
        return new RotateAnimator().generate(view, propertyName, values);
    }

    public static ScaleAnimator scale(View view, String propertyName, float ...values) {
        return new ScaleAnimator().generate(view, propertyName, values);
    }

    public static AlphaAnimator alpha(View view, String propertyName, float ...values) {
        return new AlphaAnimator().generate(view, propertyName, values);
    }

    public PropertyAnimator target(View view) {
        checkObj();
        animator.setTarget(view);
        return this;
    }

    public PropertyAnimator propertyName(String propertyName) {
        checkObj();
        animator.setPropertyName(propertyName);
        return this;
    }

    public PropertyAnimator values(float ...values) {
        checkObj();
        animator.setFloatValues(values);
        return this;
    }

    public PropertyAnimator duration(long time) {
        checkObj();
        animator.setDuration(time);
        return this;
    }

    public PropertyAnimator loop(boolean loop) {
        checkObj();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        return this;
    }

    public PropertyAnimator repeat(int count, int repeatMode) {
        checkObj();
        animator.setRepeatCount(count);
        animator.setRepeatMode(repeatMode);
        return this;
    }

    public PropertyAnimator delay(long time) {
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

    public PropertyAnimator updateListener(ValueAnimator.AnimatorUpdateListener listener) {
        checkObj();
        animator.addUpdateListener(listener);
        return this;
    }

    public PropertyAnimator listener(ValueAnimator.AnimatorListener listener) {
        checkObj();
        animator.addListener(listener);
        return this;
    }

    public PropertyAnimator removeAllListeners() {
        checkObj();
        animator.removeAllListeners();
        return this;
    }

    public PropertyAnimator interpolator(TimeInterpolator interpolator) {
        checkObj();
        animator.setInterpolator(interpolator);
        return this;
    }

    public ObjectAnimator get() {
        return animator;
    }

    protected void checkObj() {
        if(animator == null) {
            animator = new ObjectAnimator();
        }
    }

    public PropertyAnimator linear() {
        checkObj();
        animator.setInterpolator(new LinearInterpolator());
        return this;
    }

    public PropertyAnimator accelerate() {
        checkObj();
        animator.setInterpolator(new AccelerateInterpolator());
        return this;
    }

    public PropertyAnimator decelerate() {
        checkObj();
        animator.setInterpolator(new DecelerateInterpolator());
        return this;
    }

    public PropertyAnimator accelerateDecelerate() {
        checkObj();
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return this;
    }

    public PropertyAnimator anticipate() {
        checkObj();
        animator.setInterpolator(new AnticipateInterpolator());
        return this;
    }

    public PropertyAnimator overshoot() {
        checkObj();
        animator.setInterpolator(new OvershootInterpolator());
        return this;
    }

    public PropertyAnimator anticipateOvershoot() {
        checkObj();
        animator.setInterpolator(new AnticipateOvershootInterpolator());
        return this;
    }

    public PropertyAnimator bounce() {
        checkObj();
        animator.setInterpolator(new BounceInterpolator());
        return this;
    }
}