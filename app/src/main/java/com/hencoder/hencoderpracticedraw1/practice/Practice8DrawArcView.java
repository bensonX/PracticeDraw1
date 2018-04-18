package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int w = getWidth();
        int h = getHeight();

        int left = w / 3;
        int top = h / 3;
        int right = left + w / 3;
        int bottom = top + h / 3;
        RectF rectF = new RectF(left, top, right, bottom);

        float startAngle = 180;
        float sweepAngle = 60;
        boolean useCenter = false;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        canvas.drawArc(rectF, startAngle, sweepAngle, useCenter, paint);

        useCenter = true;
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 250, 100, useCenter, paint);

        useCenter = false;
        canvas.drawArc(rectF, 20, 140, useCenter, paint);
    }
}
