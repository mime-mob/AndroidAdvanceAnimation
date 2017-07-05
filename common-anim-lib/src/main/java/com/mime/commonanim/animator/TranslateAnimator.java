package com.mime.commonanim.animator;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TranslateAnimator extends PropertyAnimator {

    @Override
    public TranslateAnimator generate(View view, String propertyName, float... values) {
        animator = ObjectAnimator.ofFloat(view, propertyName, values);
        return this;
    }
}
