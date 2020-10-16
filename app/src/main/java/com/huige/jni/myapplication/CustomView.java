package com.huige.jni.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private float mTranslateY = 0;
    private float mTranslateX = 0;
    private float mScale = 1;
    private int mWidth;
    private int mHeight;
    private String TAG = this.getClass().getSimpleName();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TAG, "w,h=" + w + " , " + h);
        mWidth = w;
        mHeight = h;
    }

    public void setmScale(float mScale) {
        this.mScale = mScale;
        if(this.mScale!=1f){
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mScale!=1){
            canvas.scale(mScale,mScale);
        }
        canvas.drawColor(Color.BLUE);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint1 = new Paint();
        paint1.setColor(Color.YELLOW);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        //抗锯齿
        paint.setAntiAlias(true);
        canvas.drawRect(new Rect(0,0,400,400),paint);
        canvas.translate(200,200);
        canvas.scale(0.5f,0.5f,0,0);
        canvas.translate(-400,-400);
        canvas.drawRect(new Rect(0,0,400,400),paint1);
        Log.i(TAG, "canvas.width,height," + canvas.getWidth() + " ; " + canvas.getHeight());
        Log.i(TAG, "view.translateX,translateY," + getTranslationX() + " ; " + getTranslationY());


    }
}
