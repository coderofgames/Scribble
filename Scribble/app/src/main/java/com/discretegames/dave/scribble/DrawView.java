package com.discretegames.dave.scribble;

/**
 * Created by dave on 15/11/2016.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;


public class DrawView extends View implements View.OnTouchListener{




    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLACK);

    }

    public ArrayList GetArrayList()
    {
        return (ArrayList)points;
    }

    public void Clear()
    {
        points.clear();
        this.refreshDrawableState();
    }

    public DrawView(Context context, AttributeSet attrSet)
    {
        super(context,attrSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Point point : points) {
        //for( int i = 0; i < points.size(); i++){
            //canvas.drawLine((float)points.get(i-1).X, (float)points.get(i-1).Y,
            //        (float)points.get(i).X, (float)points.get(i).Y,paint);
            canvas.drawCircle((float)point.X, (float)point.Y, 4, paint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        Point point = new Point();
        point.X = event.getX();
        point.Y = event.getY();
        points.add(point);
        invalidate();
        return true;
    }
}



