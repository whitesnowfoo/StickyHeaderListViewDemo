package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.adapter.HeaderAdapter;
import app.fuck.com.stickyheaderlistviewdemo.util.DensityUtil;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Owner on 2016-4-27.
 */
public class HeaderAdViewView extends HeaderViewInterface<List<String>> {


    @Bind(R.id.vp_ad)
    ViewPager vpAd;
    @Bind(R.id.ll_index_container)
    LinearLayout llIndexContainer;

    private static final int TYPE_CHANGE_AD = 0;
    private Thread mThread;
    private List<ImageView> ivList;
    private List<String> adList;
    private boolean isStopThread = false;
    private int viewPagerChangeListener;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TYPE_CHANGE_AD:
                    vpAd.setCurrentItem(vpAd.getCurrentItem()+1);
                    break;
                default:
                    break;
            }
        }
    };


    public HeaderAdViewView(Activity context){
        super(context);
        ivList = new ArrayList<>();
    }

    @Override
    protected void getView(List<String> list, ListView listView) {
        adList = list;
        View view = mInflater.inflate(R.layout.header_ad_layout,listView,false);
        ButterKnife.bind(this,view);

        dealWithTheView(list);
        listView.addHeaderView(view);

    }

    private void dealWithTheView(List<String> list) {
        ivList.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ivList.add(createImage(list.get(i)));

        }

        HeaderAdapter photoAdapter = new HeaderAdapter(mContext, adList, ivList);
        vpAd.setAdapter(photoAdapter);

        addIndicatorImageViews(size);
        setViewPagerChangeListener(size);
        startADRotate();
    }

    /**
     * 创建要显示的imageView
     * @param url
     * @return
     */
    private ImageView createImage(String url) {
        ImageView imageView = new ImageView(mContext);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    /**
     * 添加指示图标
     * @param size
     */
    private void addIndicatorImageViews(int size) {
        llIndexContainer.removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView iv = new ImageView(mContext);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(DensityUtil.dip2px(mContext,5),DensityUtil.dip2px(mContext,5));
            if(i != 0){
                lp.leftMargin = DensityUtil.dip2px(mContext,7);
            }
            iv.setLayoutParams(lp);
            //选中和没被选中产生不同的颜色
            iv.setBackgroundResource(R.drawable.xml_round_orange_grey_sel);
            iv.setEnabled(false);
            if(i==0){
                iv.setEnabled(false);
            }
            llIndexContainer.addView(iv);

        }
    }

    /**
     * 为ViewPager设置监听器
     * @param size
     */
    public void setViewPagerChangeListener(final int size ) {
       vpAd.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
                if (ivList!=null&&ivList.size()>0){
                    int newPosition = position %ivList.size();
                    for (int i = 0;i<size;i++){
                        llIndexContainer.getChildAt(i).setEnabled(false);
                        if (i == newPosition){
                            llIndexContainer.getChildAt(i).setEnabled(true);
                        }
                    }
                }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }

    /**
     * 启动循环广告的线程
     */
    private void startADRotate() {
        //没有广告或者自由一个广告不要转
        if (adList==null||adList.size()<=0){
            return;
        }
        if(mThread==null){
            mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //当没离开页面时一直转
                    while(!isStopThread){
                        //每隔5秒转一次
                        SystemClock.sleep(5000);
                        mHandler.sendEmptyMessage(TYPE_CHANGE_AD);
                    }
                }
            });
            mThread.start();
        }

    }

    /**
     * 停止循环广告的线程，清空消息队列
     */
    public void stopADRotate(){
        isStopThread = true;
        if (mHandler!=null&&mHandler.hasMessages(TYPE_CHANGE_AD)){
            mHandler.removeMessages(TYPE_CHANGE_AD);
        }
    }
}
