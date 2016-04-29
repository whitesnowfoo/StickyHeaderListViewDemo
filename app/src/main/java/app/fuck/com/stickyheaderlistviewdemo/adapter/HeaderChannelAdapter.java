package app.fuck.com.stickyheaderlistviewdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.fuck.com.stickyheaderlistviewdemo.R;
import app.fuck.com.stickyheaderlistviewdemo.manager.ImageManager;
import app.fuck.com.stickyheaderlistviewdemo.model.ChannelEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**header2的适配器
 * Created by Owner on 2016-4-28.
 */
public class HeaderChannelAdapter extends BaseListAdapter<ChannelEntity> {
    public HeaderChannelAdapter(Context mContext) {
        super(mContext);
    }

    public HeaderChannelAdapter(Context mContext, List<ChannelEntity> mList) {
        super(mContext, mList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_channel,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ChannelEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getTitle());
        ImageManager.getInstance().LoadCircleImage(mContext,entity.getImageUrl(),holder.ivImage);
        if(TextUtils.isEmpty(entity.getTips())){
            holder.tvTips.setVisibility(View.INVISIBLE);
        }else{
            holder.tvTips.setVisibility(View.VISIBLE);
            holder.tvTips.setText(entity.getTips());
        }

        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_tips)
        TextView tvTips;

        ViewHolder(View view){
            ButterKnife.bind(view);

        }
    }
}
