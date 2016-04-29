package app.fuck.com.stickyheaderlistviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**父adapter
 * Created by Owner on 2016-4-28.
 */
public abstract class BaseListAdapter<E> extends BaseAdapter{

    protected Context mContext;
    private List<E> mList = new ArrayList<E>();
    protected LayoutInflater mInflater;

    public BaseListAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public BaseListAdapter (Context mContext,List<E> mList) {
        this(mContext);
        this.mList = mList;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public E getItem(int position) {
        return (E) mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void clearAll(){
        mList.clear();
    }

    public List<E> getData(){
        return mList;
    }

    public void add(E item){
        mList.add(item);
    }

    public  void addAll(List<E> lists){
        if(mList==null&&mList.size()==0){
            return ;
        }
        mList.addAll(lists);
    }

    public void removeEntity(E e){
        mList.remove(e);
    }

}
