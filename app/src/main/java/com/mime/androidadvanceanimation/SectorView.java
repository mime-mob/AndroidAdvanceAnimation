package com.mime.androidadvanceanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SectorView extends View {

    private int width;

    private int height;

    private int xPadding;

    private int yPadding;

    private Paint paint;

    private float fraction;

    private int borderSize;

    private int borderColor;

    private int centerColor;

    public SectorView(Context context) {
        this(context, null);
    }

    public SectorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderSize = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
        borderColor = Color.parseColor("#20f00000");
        centerColor = Color.parseColor("#80f00000");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        if(width == height * 2) {
            xPadding = 0;
            yPadding = 0;
        } else if(width < height * 2) {
            xPadding = 0;
            yPadding = height - width / 2;
        } else {
            xPadding = (width - height * 2) / 2;
            yPadding = 0;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startAngle;
        float endAngle;
        if(fraction <= 0.5f) {
            startAngle = 180;
            endAngle = fraction / 0.5f * 180 + 180;
        } else {
            startAngle = (1 - fraction) / 0.5f * 180 * -1;
            endAngle = 0;
        }

        paint.setColor(borderColor);
        RectF borderRectF = new RectF(xPadding, yPadding, width - xPadding, height * 2 - yPadding);
        canvas.drawArc(borderRectF, startAngle, endAngle - startAngle, true, paint);

        paint.setColor(centerColor);
        RectF centerRectF = new RectF(xPadding + borderSize, yPadding + borderSize, width - xPadding - borderSize, height * 2 - yPadding - borderSize);
        canvas.drawArc(centerRectF, startAngle, endAngle - startAngle, true, paint);
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        Log.e("TAG", "## fraction=" + fraction);
        this.fraction = fraction;
        invalidate();
    }
}
