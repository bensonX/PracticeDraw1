package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice1DrawColorView extends View {

    Paint paint = new Paint();

    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
//        黄色： Color.YELLOW

//        canvas.drawColor(Color.YELLOW);


        int w = getWidth();
        int h = getHeight();

        int cx = w / 2;
        int cy = h / 2;

        int r1 = h / 3;

        Path path = new Path();
        int left = cx - r1;
        int top = cy - r1;
        int right = cx + r1;
        int bottom = cy + r1;
        RectF oval = new RectF(left, top, right, bottom);

        int startAngle = -90;

        int[] percents = new int[] {10, 15, 20, 25, 30};
        int[] sweepAngles = new int[5];
        for (int i = 0; i < percents.length; i++) {
            sweepAngles[i] = (int) (percents[i] * 3.6);
        }

        int[] startAngles = new int[5];
        for (int i = 0; i < percents.length; i++) {
            int previousSweepAngle = i == 0 ? 0 : sweepAngles[i - 1];
            int previousStartAngle = i == 0 ? startAngle : startAngles[i - 1];
            startAngles[i] = previousStartAngle + previousSweepAngle;
        }

        int[] colors = new int[] {
                Color.parseColor("#fa3e08"),
                Color.parseColor("#a51baf"),
                Color.parseColor("#00b7d1"),
                Color.parseColor("#feab25"),
                Color.parseColor("#ebebeb"),
        };

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(50);
        int lastIndex = percents.length - 1;
        Path arcPath = new Path();
        arcPath.addArc(oval, startAngles[lastIndex], sweepAngles[lastIndex]);
        paint.setColor(colors[lastIndex]);
        canvas.drawPath(arcPath, paint);

        for (int i = 0; i < percents.length - 1; i++) {
            Log.e("angles", "start == " + startAngles[i] + ", sweep angles == " + sweepAngles[i]);
            arcPath = new Path();
            arcPath.addArc(oval, startAngles[i], sweepAngles[i]);
            paint.setColor(colors[i]);
            canvas.drawPath(arcPath, paint);
        }

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        paint.setTextSize(50);
        paint.setFakeBoldText(true);
        paint.setColor(Color.BLACK);
        String text = "1,453 calories";
        canvas.drawText(text, cx - r1 + 80, top + r1, paint);

        text = "burned";
        canvas.drawText(text, cx - r1 + 160, top + r1 + 50, paint);

        text = "Your avg is 2,399 calories";
        paint.setTextSize(30);
        paint.setColor(Color.LTGRAY);
        canvas.drawText(text, cx - r1 + 70, top + r1 + 50 + 60, paint);
    }

    private Rect getTextBounds(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }
}
