package com.celo.anand.randomusergenerator.view.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.celo.anand.randomusergenerator.R;
import com.celo.anand.randomusergenerator.presenter.vo.UserBriefInfo;
import com.celo.anand.randomusergenerator.util.PicassoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<UserBriefInfo> usersList = new ArrayList<>();
    private Context context;


    public UsersAdapter(Context context) {
        this.context = context;
    }

    public void setUsersList(List<UserBriefInfo> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserBriefInfo userBriefInfo = usersList.get(position);
        holder.nameTextView.setText(userBriefInfo.getFullName());
        PicassoUtils.loadImage(context, userBriefInfo.getAvatarUrl(), holder.avatarImageView);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_userslist_item_user_first_last_name) TextView nameTextView;
        @BindView(R.id.imageview_userslist_item_user_avatar) ImageView avatarImageView;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }
}