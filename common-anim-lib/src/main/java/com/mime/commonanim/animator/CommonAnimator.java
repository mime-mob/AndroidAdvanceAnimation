package com.mime.commonanim.animator;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

/**
 * <p>通用动画
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CommonAnimator {

    public static TranslateAnimator translateX(View view, float ...values) {
        return PropertyAnimator.translate(view, PropertyAnimator.ANIM_TRANSLATE_X, values);
    }

    public static TranslateAnimator translateY(View view, float ...values) {
        return PropertyAnimator.translate(view, PropertyAnimator.ANIM_TRANSLATE_Y, values);
    }

    public static TranslateAnimator translateZ(View view, float ...values) {
        return PropertyAnimator.translate(view, PropertyAnimator.ANIM_TRANSLATE_Z, values);
    }

    public static RotateAnimator rotate(View view, float ...values) {
        return PropertyAnimator.rotate(view, PropertyAnimator.ANIM_ROTATE, values);
    }

    public static RotateAnimator rotateX(View view, float ...values) {
        return PropertyAnimator.rotate(view, PropertyAnimator.ANIM_ROTATE_X, values);
    }

    public static RotateAnimator rotateY(View view, float ...values) {
        return PropertyAnimator.rotate(view, PropertyAnimator.ANIM_ROTATE_Y, values);
    }

    public static PropertyAnimatorSet scale(View view, float ...values) {
        return PropertyAnimatorSet.playTogether(scaleX(view, values), scaleY(view, values));
    }

    public static PropertyAnimatorSet scale(float pivotX, float pivotY, View view, float ...values) {
        return PropertyAnimatorSet.playTogether(scaleX(view, values).pivotX(pivotX), scaleY(view, values).pivotY(pivotY));
    }

    public static ScaleAnimator scaleX(View view, float ...values) {
        return PropertyAnimator.scale(view, PropertyAnimator.ANIM_SCALE_X, values);
    }

    public static ScaleAnimator scaleY(View view, float ...values) {
        return PropertyAnimator.scale(view, PropertyAnimator.ANIM_SCALE_Y, values);
    }

    public static AlphaAnimator alpha(View view, float ...values) {
        return PropertyAnimator.alpha(view, PropertyAnimator.ANIM_ALPHA, values);
    }

    public static PropertyAnimatorSet playTogether(PropertyAnimator ...animators) {
        return PropertyAnimatorSet.playTogether(animators);
    }

    public static PropertyAnimatorSet playSequentially(PropertyAnimator ...animators) {
        return PropertyAnimatorSet.playSequentially(animators);
    }

    public static ViewPropertyAnimator animate(View view) {
        return view.animate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static PathAnimator animatePath(View view, Path path) {
        return PathAnimator.animatePath(view, path);
    }

    public static NumberAnimator number(float ...values) {
        return NumberAnimator.animateValue(values);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static CircularRevealAnimator circularReveal(View view, int x, int y, float startRadius, float endRadius) {
        return CircularRevealAnimator.circularReveal(view, x, y, startRadius, endRadius);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Bundle transActivity(Activity activity, Pair<View, String> ...pairs) {
        return ActivityOptions.makeSceneTransitionAnimation(activity, pairs).toBundle();
    }

    public static FrameAnimator animateFrame(ImageView view) {
        return FrameAnimator.animateFrame(view);
    }

    public static FrameAnimator animateFrame(ImageView view, int animationResId) {
        return FrameAnimator.animateFrame(view, animationResId);
    }

    public static FrameAnimator animateFrame(ImageView view, int[] resIds, int[] times) {
        return FrameAnimator.animateFrame(view, resIds, times);
    }

    public static FrameAnimator animateFrame(ImageView view, Drawable[] frames, int[] times) {
        return FrameAnimator.animateFrame(view, frames, times);
    }

    public void test(Context context) {
        try {
            SVG svg = SVG.getFromResource(context, 0);
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }
}