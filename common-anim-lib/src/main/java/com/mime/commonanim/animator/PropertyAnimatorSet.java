package com.mime.commonanim.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
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
public class PropertyAnimatorSet implements PropertyInterpolator<PropertyAnimatorSet> {

    private AnimatorSet animatorSet;

    private PropertyAnimator[] childAnimators;

    public static PropertyAnimatorSet playTogether(PropertyAnimator ...animators) {
        return new PropertyAnimatorSet().together(animators);
    }

    public static PropertyAnimatorSet playSequentially(PropertyAnimator ...animators) {
        return new PropertyAnimatorSet().sequentially(animators);
    }

    public PropertyAnimatorSet pivot(float xPivot, float yPivot) {
        for (PropertyAnimator a : childAnimators) {
            if(a instanceof ScaleAnimator) {
                ((ScaleAnimator) a).pivot(xPivot, yPivot);
            }
        }
        return this;
    }

    public PropertyAnimatorSet pivotX(float xPivot) {
        for (PropertyAnimator a : childAnimators) {
            if(a instanceof ScaleAnimator) {
                ((ScaleAnimator) a).pivotX(xPivot);
            }
        }
        return this;
    }

    public PropertyAnimatorSet pivotY(float yPivot) {
        for (PropertyAnimator a : childAnimators) {
            if(a instanceof ScaleAnimator) {
                ((ScaleAnimator) a).pivotY(yPivot);
            }
        }
        return this;
    }

    private PropertyAnimatorSet together(PropertyAnimator ...animators) {
        checkObj();
        childAnimators = animators;
        animatorSet.playTogether(parseAnimator(animators));
        return this;
    }

    private PropertyAnimatorSet sequentially(PropertyAnimator ...animators) {
        checkObj();
        childAnimators = animators;
        animatorSet.playSequentially(parseAnimator(animators));
        return this;
    }

    public PropertyAnimatorSet duration(long time) {
        checkObj();
        animatorSet.setDuration(time);
        return this;
    }

    public PropertyAnimatorSet listener(Animator.AnimatorListener listener) {
        checkObj();
        animatorSet.addListener(listener);
        return this;
    }

    public PropertyAnimatorSet interpolator(TimeInterpolator interpolator) {
        checkObj();
        animatorSet.setInterpolator(interpolator);
        return this;
    }

    public PropertyAnimatorSet delay(long time) {
        checkObj();
        animatorSet.setStartDelay(time);
        return this;
    }

    public void cancel() {
        if(animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void start() {
        if(animatorSet != null) {
            animatorSet.start();
        }
    }

    private Animator[] parseAnimator(PropertyAnimator ...animators) {
        Animator[] animatorArray = new Animator[animators.length];
        for (int i = 0; i < animators.length; i++) {
            animatorArray[i] = animators[i].get();
        }
        return animatorArray;
    }

    private void checkObj() {
        if(animatorSet == null) {
            animatorSet = new AnimatorSet();
        }
    }

    public PropertyAnimator[] getChildAnimators() {
        return childAnimators;
    }

    public PropertyAnimatorSet linear() {
        checkObj();
        animatorSet.setInterpolator(new LinearInterpolator());
        return this;
    }

    public PropertyAnimatorSet accelerate() {
        checkObj();
        animatorSet.setInterpolator(new AccelerateInterpolator());
        return this;
    }

    public PropertyAnimatorSet decelerate() {
        checkObj();
        animatorSet.setInterpolator(new DecelerateInterpolator());
        return this;
    }

    public PropertyAnimatorSet accelerateDecelerate() {
        checkObj();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return this;
    }

    public PropertyAnimatorSet anticipate() {
        checkObj();
        animatorSet.setInterpolator(new AnticipateInterpolator());
        return this;
    }

    public PropertyAnimatorSet overshoot() {
        checkObj();
        animatorSet.setInterpolator(new OvershootInterpolator());
        return this;
    }

    public PropertyAnimatorSet anticipateOvershoot() {
        checkObj();
        animatorSet.setInterpolator(new AnticipateOvershootInterpolator());
        return this;
    }

    public PropertyAnimatorSet bounce() {
        checkObj();
        animatorSet.setInterpolator(new BounceInterpolator());
        return this;
    }
}