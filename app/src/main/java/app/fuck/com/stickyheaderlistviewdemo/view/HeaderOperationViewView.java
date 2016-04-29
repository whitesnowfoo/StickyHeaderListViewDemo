package app.fuck.com.stickyheaderlistviewdemo.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.adapter.HeaderOperationAdapter;
import app.fuck.com.stickyheaderlistviewdemo.model.OperationEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**Header3
 * Created by Owner on 2016-4-29.
 */
public class HeaderOperationViewView extends HeaderViewInterface<List<OperationEntity>>{

    @Bind(R.id.gv_operation)
    FixedGridView gvOperation;

    public HeaderOperationViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(List<OperationEntity> list, ListView listView) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.header_operation_layout,listView,false);
        ButterKnife.bind(this,view);

        dealWithTheView(list);
        listView.addHeaderView(view);

    }

    private void dealWithTheView(List<OperationEntity> list) {
        HeaderOperationAdapter adapter = new HeaderOperationAdapter(mContext,list);
        gvOperation.setAdapter(adapter);
    }
}
