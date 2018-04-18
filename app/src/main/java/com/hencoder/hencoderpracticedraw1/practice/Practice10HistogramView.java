package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        String bgColor = "#506E7A";
         canvas.drawColor(Color.parseColor(bgColor));
//        canvas.drawColor(Color.GRAY);

        int w = getWidth();
        int h = getHeight();


        int baseLeft = w / 8;
        int baseTop = h / 10;

        int startX = baseLeft;
        int startY = baseTop;
        int endX = baseLeft;
        int endY = h / 10 * 7 + baseTop;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);

        Path path = new Path();
        path.moveTo(startX, startY);
        path.lineTo(endX, endY);
        path.rLineTo(w / 8 * 6, 0);
        canvas.drawPath(path, paint);


        float pf = 0.1f, pgb = 2f, pics = 2.3f, pjb = 23, pk = 35, pL = 45, pM = 22f;
        int histogramHeight = h / 10 * 7;
        int heightUnit = histogramHeight / 50;
        float[] barHeights = new float[] {
                heightUnit * pf,
                heightUnit * pgb,
                heightUnit * pics,
                heightUnit * pjb,
                heightUnit * pk,
                heightUnit * pL,
                heightUnit * pM
        };

        String[] labels = new String[] {
                "Froyo",
                "GB",
                "ICS",
                "JB",
                "KitKat",
                "L",
                "M"
        };

        final int paddingLeftRight = 30;
        int itemsCount = barHeights.length;
        final int barMarginSingle = 15;
        int histogramWidth = w / 8 * 6 - paddingLeftRight * 2;
        final int barWidth = (histogramWidth - barMarginSingle * 2 * itemsCount) / itemsCount;

        int barBaseLeft = baseLeft + paddingLeftRight;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        String barColor = "#72B916";
        for (int i = 0; i < itemsCount; i++) {
            paint.setColor(Color.parseColor(barColor));

            int barLeft = barMarginSingle * (i * 2 + 1) + barBaseLeft;
            int barTop = (int) (histogramHeight + baseTop - barHeights[i]);
            int barRight = barLeft + barWidth;
            int barBottom = (int) (histogramHeight + baseTop);
            RectF rectF = new RectF();
            rectF.left = barLeft;
            rectF.top = barTop;
            rectF.right = barRight;
            rectF.bottom = barBottom;
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            float textWidth = paint.measureText(labels[i]);
            int textX = (int) (barLeft + (barWidth - textWidth) / 2);
            int textY = barBottom + 30;
            canvas.drawText(labels[i], textX, textY, paint);
            barBaseLeft = barBaseLeft + barWidth;
        }

        String histogramTitle = "直方图";
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        float titleWidth = paint.measureText(histogramTitle);
        int titleX = (int) (w - titleWidth) / 2;
        int titleY = h - 50;
        canvas.drawText(histogramTitle, titleX, titleY, paint);
    }
}
