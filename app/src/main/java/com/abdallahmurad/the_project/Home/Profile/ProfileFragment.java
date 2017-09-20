package com.abdallahmurad.the_project.Home.Profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdallahmurad.the_project.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);




        ArrayList<Profile> profiles = new ArrayList<>();

        profiles.add(new Profile(R.drawable.profile_img, 245, "USD"));

        profiles.add(new Profile(R.drawable.my_bookings,"My Booking"));
        profiles.add(new Profile(R.drawable.ic_credit_card,"My Credit Cards"));
        profiles.add(new Profile(R.drawable.ic_wallet,"Cashback"));
        profiles.add(new Profile(R.drawable.ic_my_coupons,"Redeem coupon"));
        profiles.add(new Profile(R.drawable.ic_profile_favorite,"My favorites"));
        profiles.add(new Profile(R.drawable.ic_profile,"Edit profile"));
        profiles.add(new Profile(R.drawable.ic_log_out,"Logout"));




        RecyclerView recyclerView = view.findViewById(R.id.profile_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        RecyclerView.Adapter adapter = new ProfileAdapter(getActivity().getApplicationContext(),profiles);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;


    }



}
