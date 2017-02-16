package com.mime.common_anim_util.anim_path_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 介绍：一个路径动画的View
 * 利用源Path绘制“底”
 * 利用动画Path 绘制 填充动画
 * <p>
 * 通过mPathAnimHelper 对SourcePath做动画：
 * 一个SourcePath 内含多段Path，循环取出每段Path，并做一个动画,
 * <p>
 * 作者：zhangxutong
 * 邮箱：zhangxutong@imcoming.com
 * 时间： 2016/11/2.
 */
public class PathAnimView extends View {

    protected Path mSourcePath;//需要做动画的源Path
    protected Path mAnimPath;//用于绘制动画的Path
    protected Paint mPaint;
    protected int mColorBg = Color.GRAY;//背景色
    protected int mColorFg = Color.WHITE;//前景色 填充色
    protected PathAnimHelper mPathAnimHelper;//Path动画工具类

    protected int mPaddingLeft, mPaddingTop;

    public PathAnimView(Context context) {
        this(context, null);
    }

    public PathAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        //Paint
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(3);

        //动画路径只要初始化即可
        mAnimPath = new Path();

        //初始化动画帮助类
        initAnimHelper();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPaddingLeft = getPaddingLeft();
        mPaddingTop = getPaddingTop();
    }

    /**
     * 初始化动画帮助类
     */
    protected void initAnimHelper() {
        mPathAnimHelper = getInitAnimHeper();
    }

    /**
     * 子类可通过重写这个方法，返回自定义的AnimHelper
     */
    protected PathAnimHelper getInitAnimHeper() {
        return new PathAnimHelper(this, mSourcePath, mAnimPath);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //平移
        canvas.translate(mPaddingLeft, mPaddingTop);

        //先绘制底，
        mPaint.setColor(mColorBg);
        canvas.drawPath(mSourcePath, mPaint);

        //再绘制前景，mAnimPath不断变化，不断重绘View的话，就会有动画效果。
        mPaint.setColor(mColorFg);
        canvas.drawPath(mAnimPath, mPaint);
    }

    public void setStrokeWidth(float pixels) {
        mPaint.setStrokeWidth(pixels);
    }

    /**
     * 设置动画 循环
     */
    public PathAnimView setAnimInfinite(boolean infinite) {
        mPathAnimHelper.setInfinite(infinite);
        return this;
    }

    /**
     * 设置动画 总时长
     */
    public PathAnimView setAnimTime(long animTime) {
        mPathAnimHelper.setAnimTime(animTime);
        return this;
    }

    /**
     * 执行循环动画
     */
    public void startAnim() {
        mPathAnimHelper.startAnim();
    }

    /**
     * 停止动画
     */
    public void stopAnim() {
        mPathAnimHelper.stopAnim();
    }

    /**
     * 清除并停止动画
     */
    public void clearAnim() {
        stopAnim();
        mAnimPath.reset();
        mAnimPath.lineTo(0, 0);
        invalidate();
    }

    public Path getSourcePath() {
        return mSourcePath;
    }

    public PathAnimView setSourcePath(Path sourcePath) {
        mSourcePath = sourcePath;
        initAnimHelper();
        return this;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public PathAnimView setPaint(Paint paint) {
        mPaint = paint;
        return this;
    }

    public int getColorBg() {
        return mColorBg;
    }

    public PathAnimView setColorBg(int colorBg) {
        mColorBg = colorBg;
        return this;
    }

    public int getColorFg() {
        return mColorFg;
    }

    public PathAnimView setColorFg(int colorFg) {
        mColorFg = colorFg;
        return this;
    }

    public PathAnimHelper getPathAnimHelper() {
        return mPathAnimHelper;
    }

    public PathAnimView setPathAnimHelper(PathAnimHelper pathAnimHelper) {
        mPathAnimHelper = pathAnimHelper;
        return this;
    }

    public Path getAnimPath() {
        return mAnimPath;
    }
}
