package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {

    float pf = 0.3f, pgb = 2f, pics = 2.7f, pjb = 17, pk = 25, pL = 35, pM = 18;

    float[] angles;

    int[] colors;

    String[] labels;

    Paint paint = new Paint();

    RectF rectF = new RectF();

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        float degree = 3.6f;
        angles = new float[]{
                pf * degree,
                pgb * degree,
                pics * degree,
                pjb * degree,
                pk * degree,
                pL * degree,
                pM * degree
        };

        colors = new int[]{
                Color.YELLOW,
                Color.BLUE,
                Color.CYAN,
                Color.DKGRAY,
                Color.GREEN,
                Color.MAGENTA,
                Color.RED
        };

        labels = new String[]{
                "Froyo",
                "GB",
                "ICS",
                "JB",
                "KitKat",
                "L",
                "M"
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图


        paint.setAntiAlias(true);


        int w = getWidth();
        int h = getHeight();

        int baseWidth = w / 5 * 2;
        int baseLeft = w / 5;
        int baseTop = h / 10;
        int baseRight = baseLeft + baseWidth;
        int baseBottom = baseTop + baseWidth;

        rectF.left = baseLeft;
        rectF.top = baseTop;
        rectF.right = baseRight;
        rectF.bottom = baseBottom;

        int selectedIndex = 5;

        float startAngle = 0;
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            paint.setColor(colors[i]);
            double theta = (startAngle + angles[i] / 2) * Math.PI / 180;
            if (i == selectedIndex) {
                canvas.save();
                final int OFFSET = 20;
                canvas.translate((int) (OFFSET * Math.cos(theta)), (int) (OFFSET * Math.sin(theta)));
            }
            canvas.drawArc(rectF, startAngle, angles[i], true, paint);
            // draw line
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);
            int radius = baseWidth / 2;
            int centerX = baseLeft + radius;
            int centerY = baseTop + radius;
            int startX = (int) (centerX + radius * Math.cos(theta));
            int startY = (int) (centerY + radius * Math.sin(theta));

            // 斜线
            int biggerR = radius + 50;
            int stopX = (int) (centerX + biggerR * Math.cos(theta));
            int stopY = (int) (centerY + biggerR * Math.sin(theta));
            canvas.drawLine(startX, startY, stopX, stopY, paint);

            // 斜线后的直线
            int endX = w / 5 - 100;
            boolean isRight = (startAngle + angles[i] / 2) > 270 || (startAngle + angles[i] / 2) < 90;
            if (isRight) {
                endX = w / 5 * 4 - 100;
            }
            canvas.drawLine(stopX, stopY, endX, stopY, paint);

            // 文字
            paint.setTextSize(30);
            Rect rect = getTextBounds(labels[i], paint);

            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Log.e("fm", "top == " + fontMetrics.top + ", ascent == " + fontMetrics.ascent
            + ", descent = " + fontMetrics.descent + ", bottom == " + fontMetrics.bottom);
            Rect tbRect = new Rect();
            tbRect.left = endX + 5;
            tbRect.top = (int) (stopY + fontMetrics.top);
            tbRect.right = tbRect.left + rect.width();
            tbRect.bottom = tbRect.top + (int) (fontMetrics.bottom - fontMetrics.top);


            if (isRight) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.YELLOW);
                canvas.drawRect(tbRect, paint);
                paint.setColor(Color.WHITE);
                canvas.drawText(labels[i], endX + 5, stopY, paint);
            } else {
                canvas.drawText(labels[i], endX - rect.width() - 5, stopY, paint);
            }

            if (i == selectedIndex) {
                canvas.restore();
            }
            startAngle += angles[i];
        }

    }

    private Rect getTextBounds(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }


}
