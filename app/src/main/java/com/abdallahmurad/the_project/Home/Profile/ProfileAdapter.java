package com.abdallahmurad.the_project.Home.Profile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdallahmurad.the_project.R;

import java.util.List;

/**
 * Created by Desmond on 8/26/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    final static int PROFILE_HEADER = 0;
    final static int PROFILE_BALANCE = 1;
    final static int PROFILE_FEATURE = 2;

    Context context;
    List<Profile> profiles;


    public ProfileAdapter(Context context, List<Profile> profiles) {
        this.context = context;
        this.profiles = profiles;
    }

    @Override

    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        switch (viewType) {

            case PROFILE_HEADER:
                view = LayoutInflater.from(context).inflate(R.layout.profile_header, parent, false);
                return new ProfileViewHolder(view, viewType);
            case PROFILE_BALANCE:
                view = LayoutInflater.from(context).inflate(R.layout.profile_mony, parent, false);
                return new ProfileViewHolder(view, viewType);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.profile_list_item, parent, false);
                return new ProfileViewHolder(view, viewType);
        }

    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        switch (viewType) {
            case PROFILE_HEADER:
                holder.headerBind(profiles.get(position));
                break;
            case PROFILE_BALANCE:
                holder.balanceBind(profiles.get(position - 1));
                break;
            case PROFILE_FEATURE:
                holder.featureBind(profiles.get(position - 1));
                break;
        }


    }

    @Override
    public int getItemCount() {
        return profiles.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                return PROFILE_HEADER;
            case 1:
                return PROFILE_BALANCE;
            default:
                return PROFILE_FEATURE;
        }

    }


}
