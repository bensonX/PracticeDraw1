package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();
        Log.e("x", "w == " + w + ", h == " + h);
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        // 求得4个圆的外围正方形边长
        int sw = w > h ? h : w;

        final int marginBetween = 30;

        // 1. 实心圆
        int baseLeft = (w - sw) / 2; // make margin left
        int firstCircleX = sw / 4 + baseLeft;
        int firstCircleY = sw / 4;
        int firstCircleRadius = sw / 4 - marginBetween; // to padding to right circle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(firstCircleX, firstCircleY, firstCircleRadius, paint);

        // 2 空心圆
        baseLeft = w / 2;
        int secondCircleX = sw / 4 + baseLeft;
        int secondCircleY = sw / 4;
        int secondCircleRadius = sw / 4 - marginBetween;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawCircle(secondCircleX, secondCircleY, secondCircleRadius, paint);

        // 3. 蓝色实心圆
        baseLeft = (w - sw) / 2;
        int baseTop = sw / 2;
        int thirdCircleX = sw / 4 + baseLeft;
        int thirdCircleY = sw / 4 + baseTop;
        int thirdRadius = sw / 4 - marginBetween;
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(thirdCircleX, thirdCircleY, thirdRadius, paint);

        // 4. stroke width = 20 的空心圆
        baseLeft = w / 2;
        int fourthCircleX = sw / 4 + baseLeft;
        int fourthCircleY = sw / 4 + baseTop;
        int fourthCircleRadius = sw / 4 - marginBetween;
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getDisplay().getMetrics(displayMetrics);
        float strokeWidth = displayMetrics.density * 20;
        paint.setStrokeWidth(strokeWidth);
        canvas.drawCircle(fourthCircleX, fourthCircleY, fourthCircleRadius, paint);
    }
}
