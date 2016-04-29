package app.fuck.com.stickyheaderlistviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.model.FilterEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Owner on 2016-4-29.
 */
public class FilterRightAdapter extends BaseListAdapter<FilterEntity> {

    private FilterEntity selectedEntity;

    public FilterRightAdapter(Context mContext) {
        super(mContext);
    }

    public FilterRightAdapter(Context mContext, List<FilterEntity> mList) {
        super(mContext, mList);
    }

    public void setSelectedEntity(FilterEntity selectedEntity) {
        this.selectedEntity = selectedEntity;
        for (FilterEntity entity:getData()) {
            entity.setSelected(entity.getKey().equals(selectedEntity.getKey()));

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_filter_one, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FilterEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getKey());
        if (entity.isSelected()) {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.orange));
        } else {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.font_black_3));
        }

        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.iv_image)
        ImageView ivImage;

        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
