package com.song2.publicdata_project.adapter.Home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.song2.publicdata_project.model.Home.Banner;

import java.util.List;

public abstract class ViewPagerAdapter<T> extends PagerAdapter {

    protected Context context;
    protected List<Banner> itemList;
    protected SparseArray<View> viewCache = new SparseArray<>();

    protected boolean isInfinite = false;
    protected boolean canInfinite = true;

    private boolean dataSetChangeLock = false;

    public ViewPagerAdapter(Context context, List<Banner> itemList, boolean isInfinite) {
        this.context = context;
        this.isInfinite = isInfinite;
        setItemList(itemList);
    }

    public void setItemList(List<Banner> itemList) {
        viewCache = new SparseArray<>();
        this.itemList = itemList;
        canInfinite = itemList.size() > 1;
        notifyDataSetChanged();
    }

    protected abstract View inflateView(int viewType, int listPosition);
    protected abstract void bindView(View convertView, int listPosition, int viewType);

    public Banner getItem(int listPosition) {
        if (listPosition >= 0 && listPosition < itemList.size()) {
            return itemList.get(listPosition);
        } else {
            return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int listPosition = (isInfinite && canInfinite) ? getListPosition(position) : position;

        int viewType = getItemViewType(listPosition);

        View convertView;
        if (viewCache.get(viewType, null) == null) {
            convertView = inflateView(viewType, listPosition);
        } else {
            convertView = viewCache.get(viewType);
            viewCache.remove(viewType);
        }

        bindView(convertView, listPosition, viewType);

        container.addView(convertView);

        return convertView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int listPosition = (isInfinite && canInfinite) ? getListPosition(position) : position;

        container.removeView((View) object);
        if (!dataSetChangeLock) viewCache.put(getItemViewType(listPosition), (View) object);
    }

    @Override
    public void notifyDataSetChanged() {
        dataSetChangeLock = true;
        super.notifyDataSetChanged();
        dataSetChangeLock = false;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (itemList != null) {
            count = itemList.size();
        }
        if (isInfinite && canInfinite) {
            return count + 2;
        } else {
            return count;
        }
    }

    /**
     * Allow child to implement view type by overriding this method.
     * instantiateItem() will call this method to determine which view to recycle.
     *
     * @param listPosition Determine view type using listPosition.
     * @return a key (View type ID) in the form of integer,
     */
    protected int getItemViewType(int listPosition) {
        return 0;
    }

    public int getListCount() {
        return itemList == null ? 0 : itemList.size();
    }

    private int getListPosition(int position) {
        if (!(isInfinite && canInfinite)) return position;
        int listPosition;
        if (position == 0) {
            listPosition = getCount() - 1 - 2; //First item is a dummy of last item
            listPosition = getCount() - 1 - 2; //First item is a dummy of last item
        } else if (position > getCount() - 2) {
            listPosition = 0; //Last item is a dummy of first item
        } else {
            listPosition = position - 1;
        }
        return listPosition;
    }

    public int getLastItemPosition() {
        if (isInfinite) {
            return itemList == null ? 0 : itemList.size();
        } else {
            return itemList == null ? 0 : itemList.size() - 1;
        }
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }
}