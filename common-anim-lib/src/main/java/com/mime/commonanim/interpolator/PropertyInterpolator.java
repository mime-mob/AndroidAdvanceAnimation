package com.mime.commonanim.interpolator;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PropertyInterpolator <T> extends IInterpolator{

    T linear();

    T accelerate();

    T decelerate();

    T accelerateDecelerate();

    T anticipate();

    T overshoot();

    T anticipateOvershoot();

    T bounce();
}