package app.fuck.com.stickyheaderlistviewdemo.model;

import java.io.Serializable;

/**筛选二级页面的选项实体类
 * Created by Owner on 2016-4-29.
 */
public class FilterEntity implements Serializable {
    private String key;
    private String value;
    private boolean isSelected;

    public FilterEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
