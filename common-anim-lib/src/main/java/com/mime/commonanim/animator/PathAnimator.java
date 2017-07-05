package com.mime.commonanim.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;

import com.mime.commonanim.interpolator.PathInterpolator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PathAnimator implements PathInterpolator {

    protected ObjectAnimator animator;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static PathAnimator animatePath(View view, Path path) {
        return new PathAnimator().animate(view, path);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private PathAnimator animate(View view, Path path) {
        animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator duration(long time) {
        checkObj();
        animator.setDuration(time);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator delay(long time) {
        checkObj();
        animator.setStartDelay(time);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator loop(boolean loop) {
        checkObj();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator repeat(int count, int repeatMode) {
        checkObj();
        animator.setRepeatCount(count);
        animator.setRepeatMode(repeatMode);
        return this;
    }

    public void cancel() {
        if(animator != null) {
            animator.cancel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator updateListener(ValueAnimator.AnimatorUpdateListener listener) {
        checkObj();
        animator.addUpdateListener(listener);
        return this;
    }

    public void start() {
        if(animator != null) {
            animator.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkObj() {
        if(animator == null) {
            animator = ObjectAnimator.ofFloat(null, View.X, View.Y, null);
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator fastOutLinear() {
        checkObj();
        animator.setInterpolator(new FastOutLinearInInterpolator());
        return this;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator fastOutSlowIn() {
        checkObj();
        animator.setInterpolator(new FastOutSlowInInterpolator());
        return this;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathAnimator linearOutSlowIn() {
        checkObj();
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        return this;
    }

    public ObjectAnimator get() {
        return animator;
    }
}