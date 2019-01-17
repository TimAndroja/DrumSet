package com.example.tim.midikontroler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyCanvas extends View {
    private Paint paint = new Paint();
    public MyCanvas(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int j = 100;j<3000;j+=200){
                canvas.drawLine(0, j, canvas.getWidth(), j, paint);
                canvas.drawLine(0, j+20, canvas.getWidth(), j+20, paint);
                canvas.drawLine(0, j+40, canvas.getWidth(), j+40, paint);
                canvas.drawLine(0, j+60, canvas.getWidth(), j+60, paint);
                canvas.drawLine(0, j+80, canvas.getWidth(), j+80, paint);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(60,90,10,paint); //Crash
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawCircle(100,90,10,paint); //Hi-Hat
                canvas.drawCircle(160,110,10,paint); //tom1
                canvas.drawCircle(200,120,10,paint); //tom1
                canvas.drawCircle(300,130,10,paint); //snare
                canvas.drawCircle(280,170,10,paint); //kick

        }



    }

}
