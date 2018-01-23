package com.diy.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by TYK on 2018/1/17 0017.
 * D等边三角形 正方形
 *
 */

public class EquilateralTriangleView extends View {

    public static final int THREE = 101;//等边三角形
    public static final int FOUR = 102;//正方形
    public static final  int FIVE = 103;//等边五边形
    //形状
    private int mShape;
    // 背景色
    private int mBgColor;
    // 边框颜色
    private int mBorderColor;
    //画笔
    private Paint mPaint;
    // 边框宽度
    private int mBorderWidth;
    // 是否显示边框
    private boolean showBorder;
    // 背景矩形
    private RectF mRectF;
    //每边的长度
    private int mLength;
    //起始点的横坐标
    private int startX ;
    //起始点的纵坐标
    private int startY ;

    public EquilateralTriangleView(Context context) {
        super(context);

    }

    public EquilateralTriangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public EquilateralTriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mRectF = new RectF();
        initPaint(context,mPaint,attrs);
    }
    // 2.初始化画笔
    private void initPaint(Context context,Paint mPaint,AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EquilateralTriangleView);
        mBorderColor = a.getColor(R.styleable.EquilateralTriangleView_lineColor, Color.parseColor("#000000"));
        mBgColor = a.getColor(R.styleable.EquilateralTriangleView_back_ground, Color.parseColor("#FFFFFF"));
        mBorderWidth = (int) a.getDimension(R.styleable.EquilateralTriangleView_border_with, TransformUtil.convertDpToPixel(context, 5f));
        mLength = (int) a.getDimension(R.styleable.EquilateralTriangleView_border_length, TransformUtil.convertDpToPixel(context, 20f));
        startX = (int) a.getDimension(R.styleable.EquilateralTriangleView_start_x, TransformUtil.convertDpToPixel(context, 500f));
        startY = (int) a.getDimension(R.styleable.EquilateralTriangleView_start_y, TransformUtil.convertDpToPixel(context, 100f));
        mShape = a.getColor(R.styleable.EquilateralTriangleView_fb_shape, EquilateralTriangleView.THREE);
        showBorder = a.getBoolean(R.styleable.EquilateralTriangleView_showBorder,true);
        mPaint.setColor(mBorderColor);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(mBorderWidth);         //设置画笔宽度为5px
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mBgColor);
        switch (mShape){
            case THREE://三角形
                Path path = new Path();
                path.moveTo(startX,startY);
                path.lineTo(startX+(mLength/2), (float) (startY+(Math.sqrt(3)*mLength)/2));
                path.lineTo(startX-(mLength/2), (float) (startY+(Math.sqrt(3)*mLength)/2));
                path.close();
                canvas.drawPath(path,mPaint);
                break;
            case FOUR://正方形
                canvas.drawRect(startX,startY,startX+mLength,startY+mLength,mPaint);
                break;
            case FIVE://五边形
                break;
        }
        // 绘制边框
        if (showBorder) {
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(mBorderColor);
            mPaint.setStrokeWidth(mBorderWidth);
            canvas.drawPaint( mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
