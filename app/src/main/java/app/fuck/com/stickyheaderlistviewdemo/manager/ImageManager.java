package app.fuck.com.stickyheaderlistviewdemo.manager;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.URL;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.view.GlideCircleTransform;

/**图片加载器
 * Created by Owner on 2016-4-27.
 */
public class ImageManager {
    public static final  String  ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private ImageManager(){}

    private static class  imagerManagerHolder{
        private static ImageManager instance= new ImageManager();
    }

    public static ImageManager getInstance(){
        return imagerManagerHolder.instance;
    }

    /**
     * 将资源id转为Uri
     * @param context
     * @param resourceId
     * @return
     */
    public Uri resourceIdToUri(Context context,int resourceId){
        return Uri.parse(ANDROID_RESOURCE+context.getPackageName()+FOREWARD_SLASH+resourceId);
    }

    /**
     * 加载网络图片
     * @param context
     * @param url
     * @param imageView
     */
    public void LoadUrlImage(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载drawable  里面的图片e
     * @param context
     * @param resId
     * @param imageView
     */
    public void LoadResImage(Context context,int resId,ImageView imageView){
        Glide.with(context)
                .load(resourceIdToUri(context,resId))
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);

    }

    /**
     * 加载本地图片
     * @param context
     * @param path
     * @param imageView
     */
    public void LoadLocalImage(Context context,String path,ImageView imageView){
        Glide.with(context)
                .load("file://"+path)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载网络圆形图片
     * @param context
     * @param url
     * @param imageView
     */
    public void LoadCircleImage(Context context,String url,ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 加载drawable中的图片并圆形处理
     * @param context
     * @param resId
     * @param imageView
     */
    public void LoadCircleResImage(Context context,int resId,ImageView imageView){
        Glide.with(context)
                .load(resourceIdToUri(context,resId))
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 加载本地种的图片并圆形处理
     * @param context
     * @param path
     * @param imageView
     */
    public void LoadCircleLocalImage(Context context,String path,ImageView imageView){
        Glide.with(context)
                .load("file://"+path)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }



}
