package com.abdallahmurad.the_project.Home.Profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.abdallahmurad.the_project.Home.Profile.ProfileAdapter.PROFILE_BALANCE;
import static com.abdallahmurad.the_project.Home.Profile.ProfileAdapter.PROFILE_FEATURE;
import static com.abdallahmurad.the_project.Home.Profile.ProfileAdapter.PROFILE_HEADER;


/**
 * Created by Desmond on 8/26/2017.
 */

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    CircleImageView profileImag;
    TextView profileBalance;
    TextView profileCurrancy;
    ImageView profileIimageFeature;
    TextView profileFeature;


    public ProfileViewHolder(View itemView, int viewType) {
        super(itemView);

        switch (viewType) {
            case PROFILE_HEADER:
                createHeader(itemView);
                break;
            case PROFILE_BALANCE:
                createBalance(itemView);
                break;
            case PROFILE_FEATURE:
                createFeature(itemView);
                break;
        }


    }

    private void createFeature(View itemView) {

        profileFeature = itemView.findViewById(R.id.feature_tv);
        profileIimageFeature = itemView.findViewById(R.id.feature_img);
    }

    private void createBalance(View itemView) {
        profileCurrancy = itemView.findViewById(R.id.profile_currancy);
        profileBalance = itemView.findViewById(R.id.profile_balance);
    }

    private void createHeader(View itemView) {
        profileImag = itemView.findViewById(R.id.profile_image);
    }


    public void featureBind(Profile profile) {

        profileIimageFeature.setImageResource(profile.getProfileIimageFeature());
        profileFeature.setText(profile.getProfileFeature());

    }

    public void balanceBind(Profile profile) {

        profileCurrancy.setText(profile.getProfileCurrancy());
        profileBalance.setText(profile.getProfileBalance()+"");

    }

    public void headerBind(Profile profile) {
        profileImag.setImageResource(profile.getProfileImag());
    }

}
