package com.diy.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by TYK on 2018/1/17 0017.
 */

public class BezierLine extends View {

    //画笔
    private Paint mPaint;

    //线条颜色
    private int lineColor;

    //起始X坐标
    private int startX;
    //起始y坐标
    private int startY;
    //结束点x坐标
    private int endX;
    //结束点Y坐标
    private int endY;
    //控制点X坐标
    private int controlX;
    //控制点Y坐标
    private int controlY;


    public BezierLine(Context context) {
        super(context);
    }

    public BezierLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BezierLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BezierLine);
        lineColor = a.getColor(R.styleable.BezierLine_line_Color, Color.parseColor("#000000"));
        startX = (int) a.getDimension(R.styleable.BezierLine_b_start_x, TransformUtil.convertDpToPixel(context, 20f));
        startY = (int) a.getDimension(R.styleable.BezierLine_b_start_y, TransformUtil.convertDpToPixel(context, 20f));
        endX = (int) a.getDimension(R.styleable.BezierLine_end_x, TransformUtil.convertDpToPixel(context, 20f));
        endY = (int) a.getDimension(R.styleable.BezierLine_end_y, TransformUtil.convertDpToPixel(context, 20f));
        controlX = (int) a.getDimension(R.styleable.BezierLine_control_x, TransformUtil.convertDpToPixel(context, 20f));
        controlY = (int) a.getDimension(R.styleable.BezierLine_control_y, TransformUtil.convertDpToPixel(context, 20f));
        mPaint.setColor(lineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);         //设置画笔宽度为5px
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(startX,startY);
        path.quadTo(controlX,controlY,endX,endY);
        canvas.drawPath(path,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式
    }

}
