package com.shopback.presentation.adapter;

import android.content.Context;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shopback.R;
import com.shopback.di.UserListResponse;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Duncan Lim on 2/6/2018.
 */

public class UserListAdapter extends BaseAdapter {

    private Context mContext;
    private List<UserListResponse> mStoryList;

    public UserListAdapter(Context mContext, List<UserListResponse> mStoryList) {
        this.mContext = mContext;
        this.mStoryList = mStoryList;
    }

    public void addListItemToAdapter(List<UserListResponse> list) {
        mStoryList.addAll(list);
        if(getCount()>101) {
            mStoryList.subList(100, mStoryList.size()).clear();
        }
        this.notifyDataSetChanged();
    }

    public void resetListItemToAdapter(List<UserListResponse> list) {
        mStoryList.clear();
        mStoryList.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mStoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = View.inflate(mContext, R.layout.item_user_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

            holder.item_name.setText(mStoryList.get(position).getLogin());
            if (mStoryList.get(position).isSiteAdmin()) {
                holder.staffBadge.setVisibility(View.VISIBLE);
            } else {
                holder.staffBadge.setVisibility(View.GONE);
            }
            Uri imageUrl = Uri.parse(mStoryList.get(position).getAvatarUrl());
            holder.avatarImageView.setImageURI(imageUrl);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_name)
        TextView item_name;
        @BindView(R.id.staffBadge)
        TextView staffBadge;
        @BindView(R.id.avatarImageView)
        SimpleDraweeView avatarImageView;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }




}
