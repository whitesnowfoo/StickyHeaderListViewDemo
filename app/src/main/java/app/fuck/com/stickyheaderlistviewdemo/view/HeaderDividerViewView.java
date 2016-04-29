package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import app.fuck.com.stickyheaderlistviewdemo.R;

/**Header4 分界線
 * Created by Owner on 2016-4-29.
 */
public class HeaderDividerViewView extends HeaderViewInterface<String> {


    public HeaderDividerViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(String s, ListView listView) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.header_divider_layout,listView,false);
        listView.addHeaderView(view);

    }
}
