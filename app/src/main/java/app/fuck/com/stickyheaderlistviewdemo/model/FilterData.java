package app.fuck.com.stickyheaderlistviewdemo.model;

import java.io.Serializable;
import java.util.List;

/**s三个筛选列表数据
 * Created by Owner on 2016-4-29.
 */
public class FilterData implements Serializable {
    private List<FilterTwoEntity> category;
    private List<FilterEntity> sort;
    private List<FilterEntity> filter;

    public List<FilterTwoEntity> getCategory() {
        return category;
    }

    public void setCategory(List<FilterTwoEntity> category) {
        this.category = category;
    }

    public List<FilterEntity> getSort() {
        return sort;
    }

    public void setSort(List<FilterEntity> sort) {
        this.sort = sort;
    }

    public List<FilterEntity> getFilter() {
        return filter;
    }

    public void setFilter(List<FilterEntity> filter) {
        this.filter = filter;
    }
}
