package com.michael.instrumentpanelview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View{
    public static final String TAG = "MyView";
    public static final int rotateDegree = 360/24;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        Log.d(TAG,"getWidth() = " +getWidth() + "getHeight = " +getHeight());
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paintCircle);

        //画刻度
        Paint paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        for(int i = 0;i < 24;i ++){
            if(i % 6 == 0) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(getWidth() / 2, getHeight() / 2 - getWidth() / 2, getWidth() / 2, getHeight() / 2 - getWidth() / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,getWidth()/2-paintDegree.measureText(degree)/2,getHeight()/2-getWidth()/2+90,paintDegree);
            }else{
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(getWidth()/2,getHeight()/2-getWidth()/2,getWidth()/2,getHeight()/2-getWidth()/2+30,paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,getWidth()/2-paintDegree.measureText(degree)/2,getHeight()/2-getWidth()/2+60,paintDegree);
            }
            canvas.rotate(rotateDegree,getWidth()/2,getHeight()/2);
        }

        //画指针
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMinute);
        canvas.restore();
    }
}
