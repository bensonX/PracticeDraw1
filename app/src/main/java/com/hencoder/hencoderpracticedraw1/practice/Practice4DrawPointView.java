package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        int w = getWidth();
        int h = getHeight();

        int sw = w > h ? h : w;
        int baseLeft = (w - sw) / 2;
        int baseTop = (h - sw) / 2;

        // 圆点
        int pointX = sw / 4 + baseLeft;
        int pointY = sw / 2 + baseTop;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getDisplay().getMetrics(displayMetrics);
        float strokeWidth = displayMetrics.density * 30;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(pointX, pointY, paint);

        // 方点
        baseLeft = w / 2;
        pointX = sw / 4 + baseLeft;
        pointY = sw / 2 + baseTop;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(pointX, pointY, paint);
    }
}
