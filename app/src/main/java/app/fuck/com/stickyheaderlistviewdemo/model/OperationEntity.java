package app.fuck.com.stickyheaderlistviewdemo.model;

import java.io.Serializable;

/**header3实体类
 * Created by Owner on 2016-4-29.
 */
public class OperationEntity implements Serializable {
    private  String title;
    private String subtitle;
    private String  imageUrl;

    public OperationEntity(String title, String subtitle, String imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
