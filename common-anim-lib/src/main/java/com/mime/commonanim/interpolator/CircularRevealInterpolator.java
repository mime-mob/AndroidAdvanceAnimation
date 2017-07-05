package com.mime.commonanim.interpolator;

import com.mime.commonanim.animator.CircularRevealAnimator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface CircularRevealInterpolator extends IInterpolator{

    CircularRevealAnimator linear();

    CircularRevealAnimator accelerate();

    CircularRevealAnimator decelerate();
}
