package app.fuck.com.stickyheaderlistviewdemo.model;

import android.widget.ImageView;

import java.io.Serializable;

/**频道实体类
 * Created by Owner on 2016-4-28.
 */
public class ChannelEntity implements Serializable {
    private String title;
    private String tips;
    private String ImageUrl;

    public ChannelEntity(){}

    public ChannelEntity(String title, String tips, String imageUrl) {
        this.title = title;
        this.tips = tips;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
