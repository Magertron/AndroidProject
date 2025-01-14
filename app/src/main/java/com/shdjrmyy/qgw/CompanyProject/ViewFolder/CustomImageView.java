package com.shdjrmyy.qgw.CompanyProject.ViewFolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.shdjrmyy.qgw.CompanyProject.R;


/**
     * 图片圆角实现，支持xUtils
     * 
     * @author Himan
     */
    @SuppressLint("AppCompatCustomView")
    public class CustomImageView extends ImageView {
        private Paint paint;
        private Paint paintBorder;
        /** 圆角的幅度 **/
        private float mRadius;
        /** 是否是圆形 **/
        private boolean mIsCircle;
    public CustomImageView(final Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.customImageViewStyle);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setScaleType(ScaleType.CENTER_CROP);
        // 获取自定属性配置
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.CustomImageView, defStyle, 0);
        mRadius = ta.getDimension(R.styleable.CustomImageView_radiuss, 0);
        mIsCircle = true;
        ta.recycle();
        paint = new Paint();
        paint.setAntiAlias(true);
        paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
    }





    @Override
    public void onDraw(Canvas canvas) {
        // 去点padding值
        int width = canvas.getWidth() - getPaddingLeft() - getPaddingRight();
        int height = canvas.getHeight() - getPaddingTop() - getPaddingBottom();
        // 获取iamgeView 中的drawable 并转成bitmap
        Bitmap image = drawableToBitmap(getDrawable());
        // 对获取到的bitmap 按照当前imageView的宽高进行缩放
        Bitmap reSizeImage = reSizeImage(image, width, height);
        // 判断当前需要绘制圆角还是圆
        if (mIsCircle) {
            canvas.drawBitmap(createCircleImage(reSizeImage, width, height),
                getPaddingLeft(), getPaddingTop(), null);

    } else {
        canvas.drawBitmap(createRoundImage(reSizeImage, width, height),
                getPaddingLeft(), getPaddingTop(), null);
    }
}

/** 绘制圆角 **/
private Bitmap createRoundImage(Bitmap source, int width, int height) {
    final Paint paint = new Paint();
    paint.setAntiAlias(true);
    Bitmap target = Bitmap.createBitmap(width, height, Config.ARGB_8888);
    Canvas canvas = new Canvas(target);
    RectF rect = new RectF(0, 0, width, height);
    canvas.drawRoundRect(rect, mRadius, mRadius, paint);
    // 关键代码 设置画笔的Mode 设置为获取交集 
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawBitmap(source, 0, 0, paint);
    return target;
}

private Bitmap createCircleImage(Bitmap source, int width, int height) {
    final Paint paint = new Paint();
    paint.setAntiAlias(true);
    Bitmap target = Bitmap.createBitmap(width, height, Config.ARGB_8888);
    Canvas canvas = new Canvas(target);
    canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2,
            paint);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawBitmap(source, 0, 0, paint);
    return target;
}

@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width = MeasureSpec.getSize(widthMeasureSpec);
    int height = MeasureSpec.getSize(heightMeasureSpec);
    setMeasuredDimension(width, height);
}

/**
 * drawable转bitmap
 * 
 * @param drawable
 * @return
 */
private Bitmap drawableToBitmap(Drawable drawable) {
    if (drawable == null) {
        return null;
    } else if (drawable instanceof BitmapDrawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }
    Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicHeight(),
            drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
    drawable.draw(canvas);
    return bitmap;
}

/**
 * 重设Bitmap的宽高
 * 
 * @param bitmap
 * @param newWidth
 * @param newHeight
 * @return
 */
private Bitmap reSizeImage(Bitmap bitmap, int newWidth, int newHeight) {
    int width;
    int height;
    if(bitmap!=null) {
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }else {
        Resources res=getResources();
        Bitmap bmp= BitmapFactory.decodeResource(res, R.mipmap.user);
        return bmp;
    }
    // 计算出缩放比
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;
    // 矩阵缩放bitmap
    Matrix matrix = new Matrix();
    matrix.postScale(scaleWidth, scaleHeight);
    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

}