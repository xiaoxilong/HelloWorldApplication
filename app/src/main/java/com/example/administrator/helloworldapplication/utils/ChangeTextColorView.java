package com.example.administrator.helloworldapplication.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.example.administrator.helloworldapplication.R;

/**
 * project_name:HelloWorldApplication
 * Date: 2016/11/22 16:52
 * Email: xiaoxilong5201314@163.com
 * Author: Aaron Empire
 * Description:  change text
 */
public class ChangeTextColorView extends TextView {

    private String mText="太难找";
    private int mTextSize;
    private  int mColor=0xffded0da;
    private Paint mTextPain;
    Rect mTextBound = new Rect();
    private float mAlpha =0.5f;
    private Rect mIconRect;


    public ChangeTextColorView(Context context) {
        this(context,null);
    }
    public ChangeTextColorView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public ChangeTextColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ChangeTextColorView, defStyleAttr, 0);
        int indexCount = typeArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = typeArray.getIndex(i);
            switch(attr){
                case R.styleable.ChangeTextColorView_text_color:
                    mColor = typeArray.getColor(attr, mColor);
                    break;
                case R.styleable.ChangeTextColorView_text_title:
                    mText = typeArray.getString(attr);
                    break;
                case R.styleable.ChangeTextColorView_textSize:
                    mTextSize = (int) typeArray.getDimension(attr, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typeArray.recycle();
        mTextPain = new Paint();
        mTextPain.setTextSize(mTextSize);
        mTextPain.setColor(0xff445566);
        mTextPain.getTextBounds(mText,0,mText.length(),mTextBound);

    }

    @Override
    protected void onDraw(Canvas canvas) {
      //  int alpha = (int)Math.ceil((255*mAlpha));
       // drawSourceText(canvas, alpha);
       // drawTargetText(canvas,alpha);
        mTextPain.setColor(mColor);
        canvas.drawText(mText,getWidth() / 2-mTextBound.width()/2,getHeight()/2+mTextBound.height()/2,mTextPain);
    }

    private void drawTargetText(Canvas canvas, int alpha) {
        mTextPain.setColor(mColor);
        mTextPain.setAlpha(alpha);
        canvas.drawText(mText,getWidth() / 2-mTextBound.width(),getHeight() / 2-mTextBound.height(),mTextPain);
    }

    private void drawSourceText(Canvas canvas, int alpha) {
        mTextPain.setTextSize(mTextSize);
        mTextPain.setColor(0x77ff0000);
        mTextPain.setAlpha(alpha);
        canvas.drawText(mText,mTextBound.width(),mTextBound.height(),mTextPain);
    }
}
