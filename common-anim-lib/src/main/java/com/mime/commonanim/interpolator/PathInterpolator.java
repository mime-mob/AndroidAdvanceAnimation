package com.mime.commonanim.interpolator;

import com.mime.commonanim.animator.PathAnimator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PathInterpolator extends IInterpolator {

    PathAnimator fastOutLinear();

    PathAnimator fastOutSlowIn();

    PathAnimator linearOutSlowIn();
}
