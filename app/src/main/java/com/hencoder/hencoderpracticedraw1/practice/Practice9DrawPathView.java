package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice9DrawPathView extends View {

    Paint paint = new Paint();
    Path path = new Path();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        path.addArc(new RectF(200, 200, 400, 400), -225, 225);
        path.arcTo(new RectF(400, 200, 600, 400), -180, 225, false);
        path.lineTo(400, 542);
        canvas.drawPath(path, paint);

        // 练习其他
        int w = getWidth();
        int h = getHeight();

        int sw = w > h ? h : w;
        int hw = sw / 2;
        int hh = h / 2;

//        int baseLeft = (w - h) / 2;
//        int x1 =  hw * 3 / 4 + baseLeft;
//        int y1 = hh;
//
//
//
//        paint.setColor(Color.RED);
//        canvas.drawLine(w / 2, 0, w / 2, h, paint);
//
//        canvas.drawLine(baseLeft, 0, baseLeft, h, paint);
//
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        paint.setStrokeWidth(10);
//        canvas.drawPoint(x1, y1, paint);
//        paint.setStrokeWidth(2);
//        canvas.drawLine(x1, y1, x1 + hh / 2, y1, paint);
//
//        canvas.drawCircle(x1, y1, hh / 2, paint);
////        path.addCircle(x1, y1, hh / 2, Path.Direction.CW);
//
//
//        int x2 = hw + baseLeft + hw / 4;
//        int y2 = hh;
//        path.addCircle(x2, y2, hh / 2, Path.Direction.CCW);
//
//        path.setFillType(Path.FillType.WINDING);
//        paint.setColor(Color.BLACK);
//        paint.setAlpha(200);
//        canvas.drawPath(path, paint);

//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
//        path.lineTo(300, 300);
//        path.rLineTo(100, 0);
////        path.rLineTo(400, 0);
////        path.rMoveTo(-400, 0);
////        path.rQuadTo(200, -300, 400, 100);
//        path.rCubicTo(200, 300, 200, -300, 400,0);
//        path.close();
//        canvas.drawPath(path, paint);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//
//        paint.setTextSize(30);
//        canvas.drawText("Hello Rain", bitmap.getWidth(), 30, paint);


//        path.moveTo(100, 200);
//        path.lineTo(400, 200);
//        path.lineTo(150, 400);
//        path.lineTo(250, 100);
//        path.lineTo(325, 400);
//        path.close();
//
//        path.setFillType(Path.FillType.EVEN_ODD);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawPath(path, paint);
    }
}
