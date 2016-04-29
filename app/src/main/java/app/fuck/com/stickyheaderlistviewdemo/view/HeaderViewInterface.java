package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.List;

/**定义个抽象类，来判定view的加载
 * Created by Owner on 2016-4-27.
 */
public abstract class HeaderViewInterface<T> {
    protected Activity mContext;
    protected LayoutInflater mInflater;
    protected T mEntity;

    public HeaderViewInterface(Activity context){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public boolean fillView(T t, ListView listView){
        if(t ==null){
            return false;
        }
        if((t instanceof List)&&((List)t).size()==0 ){
            return false;
        }

        this.mEntity = t;
        getView(t,listView);
        return true;
    }

    protected  abstract void getView(T t,ListView listView);

}
