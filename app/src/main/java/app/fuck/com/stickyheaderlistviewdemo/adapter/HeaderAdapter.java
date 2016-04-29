package app.fuck.com.stickyheaderlistviewdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.manager.ImageManager;

/**广告位视图的适配器
 * Created by Owner on 2016-4-27.
 */
public class HeaderAdapter extends PagerAdapter{

    private Context mContext;
    //ImageView的集合
    private List<ImageView> ivList;
    //广告的链接集合
    private List<String> adList;
    //广告的数量
    private int count = 1;

    public HeaderAdapter(Context context,List<String> adList,List<ImageView> ivList){
        super();
        this.mContext = context;
        this.adList =adList;
        this.ivList = ivList;
        if(ivList!=null&&ivList.size()>0){
            count = ivList.size();
        }
    }

    @Override
    public int getCount() {
        if(count==1){
            return 1;
        }else {
            return Integer.MAX_VALUE;//why？
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position%count;
        //先移除再添加，更新图片在container中的位置（把iv放在container的末尾）
        ImageView iv = ivList.get(newPosition);
        String url = adList.get(newPosition);
        container.removeView(iv);
        ImageManager.getInstance().LoadUrlImage(mContext,url,iv);
        container.addView(iv);

        return iv;
    }
}
