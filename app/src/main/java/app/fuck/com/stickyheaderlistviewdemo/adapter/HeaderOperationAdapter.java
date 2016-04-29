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
import app.fuck.com.stickyheaderlistviewdemo.model.OperationEntity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**Header3的適配器
 * Created by Owner on 2016-4-29.
 */
public class HeaderOperationAdapter extends BaseListAdapter<OperationEntity>{
    public HeaderOperationAdapter(Context mContext) {
        super(mContext);
    }

    public HeaderOperationAdapter(Context mContext, List<OperationEntity> mList) {
        super(mContext, mList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_operation,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)(convertView.getTag());
        }
        OperationEntity entity = getItem(position);
        holder.tvTitle.setText(entity.getTitle());
        ImageManager.getInstance().LoadUrlImage(mContext,entity.getImageUrl(),holder.ivImage);
        if(TextUtils.isEmpty(entity.getSubtitle())){
            holder.tvSubtitle.setVisibility(View.INVISIBLE);
        }else{
            holder.tvSubtitle.setVisibility(View.VISIBLE);
            holder.tvSubtitle.setText(entity.getSubtitle());
        }
        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_subtitle)
        TextView tvSubtitle;
        @Bind(R.id.iv_image)
        ImageView ivImage;

        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
