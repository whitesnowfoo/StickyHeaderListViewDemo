package app.fuck.com.stickyheaderlistviewdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**转换成圆形图片
 * Created by Owner on 2016-4-28.
 */
public class GlideCircleTransform extends BitmapTransformation {


    public GlideCircleTransform(Context context) {
        super(context);
    }



    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool,toTransform);
    }

    private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
        if(source == null){return null;}
        int size = Math.min(source.getWidth(),source.getHeight());
        int x = (source.getWidth()-size)/2;
        int y = (source.getHeight()-size)/2;

        Bitmap squared = Bitmap.createBitmap(source,x,y,size,size);
        Bitmap result = pool.get(size,size, Bitmap.Config.ARGB_8888);
        if(result==null){
            result = Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size/2;
        canvas.drawCircle(r,r,r,paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
