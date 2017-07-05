package com.mime.commonanim.trimpathview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.mime.commonanim.R;


/**
 * <p>write the description for the file
 *
 * @author renjialiang
 * @createTime 2016/8/1 9:46
 * @project Demo
 */
public class SearchView extends View {

    private static final int DEAFULT_WIDTH = 180;

    private static final int DEAFULT_HEIGHT = 180;

    private static final int ANIM_TIME = 1600;

    public enum State {
        NONE,
        STARTING,
        SEARCHING,
        ENDING
    }

    private Paint mPaint;

    private int mViewWidth = DEAFULT_WIDTH;

    private int mViewHeight = DEAFULT_HEIGHT;

    private State mCurrentState = State.NONE;

    private Path path_search;

    private Path path_circle;

    private PathMeasure mMeasure;

    private ValueAnimator mStartingAnimator;

    private ValueAnimator mSearchingAnimator;

    private ValueAnimator mEndingAnimator;

    private float mAnimatorValue = 0;

    private ValueAnimator.AnimatorUpdateListener mUpdateListener;

    private Animator.AnimatorListener mAnimatorListener;

    private Handler mAnimatorHandler;

    private boolean isOver = false;

    private int count = 0;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initPath();
        initListener();
        initHandler();
        initAnimator();
        setBackgroundColor(getResources().getColor(R.color.bg_search_view));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        if(measureWidth <= 0) {
            mViewWidth = DEAFULT_WIDTH;
        } else {
            mViewWidth = measureWidth;
        }
        if(measureHeight <= 0) {
            mViewHeight = DEAFULT_HEIGHT;
        } else {
            mViewHeight = measureHeight;
        }
        setMeasuredDimension(mViewWidth, mViewHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    public void startAnim() {
        mCurrentState = State.STARTING;
        mStartingAnimator.start();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(60);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private void initPath() {
        path_search = new Path();
        path_circle = new Path();

        mMeasure = new PathMeasure();

        RectF oval1 = new RectF(-200, -200, 200, 200);
        path_search.addArc(oval1, 45, 359.99f);//Don not be 360.

        RectF oval2 = new RectF(-400, -400, 400, 400);
        path_circle.addArc(oval2, 45, -359.99f);//Don not be 360.

        float[] pos = new float[2];

        mMeasure.setPath(path_circle, false);
        mMeasure.getPosTan(0, pos, null);

        path_search.lineTo(pos[0], pos[1]);
    }

    private void initListener() {
        mUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatorValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        };

        mAnimatorListener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimatorHandler.sendEmptyMessage(0);
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        };
    }

    private void initHandler() {
        mAnimatorHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (mCurrentState) {
                    case STARTING:
                        isOver = false;
                        mCurrentState = State.SEARCHING;
                        mSearchingAnimator.start();
                        break;
                    case SEARCHING:
                        count++;
                        if (count == 2){
                            isOver = true;
                        }
                        if (!isOver) {
                            mSearchingAnimator.start();
                        } else {
                            mCurrentState = State.ENDING;
                            mEndingAnimator.start();
                        }
                        break;
                    case ENDING:
                        count = 0;
                        mCurrentState = State.NONE;
                        break;
                }
            }
        };
    }

    private void initAnimator() {
        mStartingAnimator = ValueAnimator.ofFloat(0, 1).setDuration(ANIM_TIME);
        mSearchingAnimator = ValueAnimator.ofFloat(0, 1).setDuration(ANIM_TIME);
        mEndingAnimator = ValueAnimator.ofFloat(1, 0).setDuration(ANIM_TIME);

        mStartingAnimator.addUpdateListener(mUpdateListener);
        mSearchingAnimator.addUpdateListener(mUpdateListener);
        mEndingAnimator.addUpdateListener(mUpdateListener);

        mStartingAnimator.addListener(mAnimatorListener);
        mSearchingAnimator.addListener(mAnimatorListener);
        mEndingAnimator.addListener(mAnimatorListener);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSearch(canvas);
    }

    private void drawSearch(Canvas canvas) {
        canvas.translate(mViewWidth / 2, mViewHeight / 2);

        float start;
        float end;
        switch (mCurrentState) {
            case NONE:
                canvas.drawPath(path_search, mPaint);
                break;
            case STARTING:
                mMeasure.setPath(path_search, false);
                Path dst = new Path();
                dst.rLineTo(0, 0);
                start = mMeasure.getLength() * mAnimatorValue;
                end = mMeasure.getLength();
                mMeasure.getSegment(start == end ? start - 0.01f : start, end, dst, true);
                canvas.drawPath(dst, mPaint);
                break;
            case SEARCHING:
                mMeasure.setPath(path_circle, false);
                Path dst2 = new Path();
                dst2.rLineTo(0, 0);
                end = mMeasure.getLength() * mAnimatorValue;
                start = (float) (end - ((0.5 - Math.abs(mAnimatorValue - 0.5)) * mMeasure.getLength() / 4));
                if(start == end) {
                    end = end + 0.01f;
                }
                mMeasure.getSegment(start, end, dst2, true);
                canvas.drawPath(dst2, mPaint);
                break;
            case ENDING:
                mMeasure.setPath(path_search, false);
                Path dst3 = new Path();
                dst3.rLineTo(0, 0);
                start = mMeasure.getLength() * mAnimatorValue;
                end = mMeasure.getLength();
                mMeasure.getSegment(start == end ? start - 0.01f : start, end, dst3, true);
                canvas.drawPath(dst3, mPaint);
                break;
        }
    }
}