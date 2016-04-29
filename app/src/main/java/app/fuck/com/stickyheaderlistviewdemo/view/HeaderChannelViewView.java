package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.adapter.HeaderChannelAdapter;
import app.fuck.com.stickyheaderlistviewdemo.model.ChannelEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**header2
 * Created by Owner on 2016-4-28.
 */
public class HeaderChannelViewView extends HeaderViewInterface<List<ChannelEntity>> {

    @Bind(R.id.gv_channel)
    FixedGridView gvChannel;


    public HeaderChannelViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(List<ChannelEntity> list, ListView listView) {

        View view = mInflater.inflate(R.layout.header_channel_layout,listView,false);
        ButterKnife.bind(this,view);

        dealWithTheView(list);
        listView.addHeaderView(view);

    }

    private void dealWithTheView(List<ChannelEntity> list) {
        int size = list.size();
        if(size<=4){
            gvChannel.setNumColumns(size);
        }else if (size == 6){
            gvChannel.setNumColumns(3);
        }else if (size ==8){
            gvChannel.setNumColumns(4);
        }else{
            gvChannel.setNumColumns(4);
        }
        HeaderChannelAdapter adapter = new HeaderChannelAdapter(mContext,list);
        gvChannel.setAdapter(adapter);
    }
}
