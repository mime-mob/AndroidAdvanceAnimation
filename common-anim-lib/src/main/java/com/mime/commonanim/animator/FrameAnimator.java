package com.mime.commonanim.animator;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FrameAnimator {

    private AnimationDrawable animator;

    private ImageView target;

    public static FrameAnimator animateFrame(ImageView view) {
        return new FrameAnimator().animate(view);
    }

    public static FrameAnimator animateFrame(ImageView view, int resId) {
        return new FrameAnimator().animate(view, resId);
    }

    public static FrameAnimator animateFrame(ImageView view, int[] resIds, int[] times) {
        return new FrameAnimator().animate(view, resIds, times);
    }

    public static FrameAnimator animateFrame(ImageView view, Drawable[] frames, int[] times) {
        return new FrameAnimator().animate(view, frames, times);
    }

    private FrameAnimator animate(ImageView view) {
        this.target = view;
        animator = new AnimationDrawable();
        return this;
    }

    private FrameAnimator animate(ImageView view, int resId) {
        this.target = view;
        animator = (AnimationDrawable)ContextCompat.getDrawable(view.getContext(), resId);
        return this;
    }

    private FrameAnimator animate(ImageView view, int[] resIds, int[] times) {
        if(resIds == null || times == null) {
            throw new IllegalArgumentException("resIds or times can not be null");
        }
        if(resIds.length != times.length) {
            throw new IllegalArgumentException("resIds don't match times");
        }
        this.target = view;
        animator = new AnimationDrawable();
        for (int i = 0; i < resIds.length; i++) {
            addFrame(resIds[i], times[i]);
        }
        return this;
    }

    private FrameAnimator animate(ImageView view, Drawable[] frames, int[] times) {
        if(frames == null || times == null) {
            throw new IllegalArgumentException("frames or times can not be null");
        }
        if(frames.length != times.length) {
            throw new IllegalArgumentException("frames don't match times");
        }
        this.target = view;
        animator = new AnimationDrawable();
        for (int i = 0; i < frames.length; i++) {
            addFrame(frames[i], times[i]);
        }
        return this;
    }

    public FrameAnimator addFrame(Drawable frame, int time) {
        animator.addFrame(frame, time);
        return this;
    }

    public FrameAnimator addFrame(int resId, int time) {
        if(target == null) {
            throw new IllegalArgumentException("target can not be null");
        }
        Drawable frame = ContextCompat.getDrawable(target.getContext(), resId);
        animator.addFrame(frame, time);
        return this;
    }

    public void start() {
        if(animator != null && target != null) {
            target.setImageDrawable(animator);
            animator.start();
        }
    }

    public void stop() {
        if(animator != null) {
            animator.stop();
        }
    }

    private void checkObj() {
        if (animator == null) {
            animator = new AnimationDrawable();
        }
    }

    public AnimationDrawable get() {
        return animator;
    }
}
