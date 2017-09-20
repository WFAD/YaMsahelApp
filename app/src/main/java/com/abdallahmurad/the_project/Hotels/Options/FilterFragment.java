package com.abdallahmurad.the_project.Hotels.Options;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.abdallahmurad.the_project.R;

import static com.abdallahmurad.the_project.FragmentUtils.replaceFragment;


/**
 * Created by Desmond on 8/22/2017.
 */

public class FilterFragment extends Fragment {
    LinearLayout adults;

    public FilterFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);


        adults = view.findViewById(R.id.people_filter);
        adults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPeopleFilter();
            }
        });


        return view;
    }


    private void openPeopleFilter() {
        replaceFragment(getActivity(), R.id.filter_container, true, new PeopleFilter());
    }

}
