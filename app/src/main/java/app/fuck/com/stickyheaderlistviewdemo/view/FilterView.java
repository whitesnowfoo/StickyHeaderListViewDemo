package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.adapter.FilterLeftAdapter;
import app.fuck.com.stickyheaderlistviewdemo.adapter.FilterOneAdapter;
import app.fuck.com.stickyheaderlistviewdemo.adapter.FilterRightAdapter;
import app.fuck.com.stickyheaderlistviewdemo.model.FilterData;
import app.fuck.com.stickyheaderlistviewdemo.model.FilterEntity;
import app.fuck.com.stickyheaderlistviewdemo.model.FilterTwoEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**隐藏的筛选布局
 * Created by Owner on 2016-4-29.
 */
public class FilterView extends LinearLayout implements View.OnClickListener{

    @Bind(R.id.tv_category)
    TextView tvCategory;
    @Bind(R.id.tv_sort)
    TextView tvSort;
    @Bind(R.id.tv_filter)
    TextView tvFilter;
    @Bind(R.id.iv_category_arrow)
    ImageView ivCategoryArrow;
    @Bind(R.id.iv_sort_arrow)
    ImageView ivSortArrow;
    @Bind(R.id.iv_filter_arrow)
    ImageView ivFilterArrow;
    @Bind(R.id.ll_category)
    LinearLayout llCategory;
    @Bind(R.id.ll_sort)
    LinearLayout llSort;
    @Bind(R.id.ll_filter)
    LinearLayout llFilter;
    @Bind(R.id.lv_left)
    ListView lvLeft;
    @Bind(R.id.lv_right)
    ListView lvRight;
    @Bind(R.id.view_mask_bg)
    View viewMaskBg;
    @Bind(R.id.ll_content_list_view)
    LinearLayout llContentListView;
    @Bind(R.id.ll_head_layout)
    LinearLayout llHeadLayout;

    private Context mContext;
    private Activity mActivity;
    //是否吸附在顶部
    private boolean isStickyTop = false;
    private boolean isShowing = false;
    private int filterPosition = -1;
    private int panelHeight;
    private FilterData filterData;


    //被选择的分类项
    private FilterTwoEntity selectedCategoryEntity;
    //被选择的排序项
    private FilterEntity selectedSortEntity;
    //被选择的筛选项
    private FilterEntity selectedFilterEmtity;


    private FilterLeftAdapter leftAdapter;
    private FilterRightAdapter rightAdapter;
    private FilterOneAdapter sortAdapter;
    private FilterOneAdapter filterAdapter;


    public FilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_filter_layout,this,false);
        ButterKnife.bind(this,view);

        initData();
        initView();
        inintListener();
    }

    @Override
    public void onClick(View v) {

    }
}

