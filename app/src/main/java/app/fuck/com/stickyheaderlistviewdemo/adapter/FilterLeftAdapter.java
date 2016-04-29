package app.fuck.com.stickyheaderlistviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.model.FilterTwoEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Owner on 2016-4-29.
 */
public class FilterLeftAdapter extends BaseListAdapter<FilterTwoEntity>{

    private FilterTwoEntity selectedEntity;

    public FilterLeftAdapter(Context mContext) {
        super(mContext);
    }

    public FilterLeftAdapter(Context mContext, List<FilterTwoEntity> mList) {
        super(mContext, mList);
    }

    public void setSelectedEntity(FilterTwoEntity selectedEntity) {
        this.selectedEntity = selectedEntity;
        for (FilterTwoEntity entity:getData()) {
            entity.setSelected(entity.getType().equals(selectedEntity.getType()));

        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_filter_left,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        FilterTwoEntity entity = getItem(position);
        holder.tvTitle.setText(entity.getType());
        if(entity.isSelected()){
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.llRootView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }else{
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.font_black_2));
            holder.llRootView.setBackgroundColor(mContext.getResources().getColor(R.color.font_black_6));
        }
        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.ll_root_view)
        LinearLayout llRootView;
        @Bind(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
