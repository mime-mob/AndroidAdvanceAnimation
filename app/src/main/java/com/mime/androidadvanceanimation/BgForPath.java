package com.mime.androidadvanceanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.mime.androidadvanceanimation.R;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BgForPath extends View {

    private int screenWidth;

    private int screenHeight;

    private Path path;

    private Paint paint;

    public BgForPath(Context context) {
        this(context, null);
    }

    public BgForPath(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BgForPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        path = new Path();
        path.moveTo(100, 100);
        path.quadTo(screenWidth - 300, 200, screenWidth - 100, screenHeight - 600);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);


        /*try {
            SVG svg = SVG.getFromResource(context, R.raw.android);
            svgCanvas.scale(100, 100);
            svg.renderToCanvas(svgCanvas);
        } catch (SVGParseException e) {
            e.printStackTrace();
        }*/
    }

    /*private Canvas svgCanvas = new Canvas() {
        private final Matrix mMatrix = new Matrix();

        @Override
        public int getWidth() {
            return 720;
        }

        @Override
        public int getHeight() {
            return 1000;
        }

        @Override
        public void drawPath(Path p, Paint paint) {
            Path dst = new Path();
            getMatrix(mMatrix);
            p.transform(mMatrix, dst);
            path = dst;
        }
    };*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
}
