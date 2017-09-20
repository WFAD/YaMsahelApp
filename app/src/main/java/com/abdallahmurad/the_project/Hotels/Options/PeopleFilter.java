package com.abdallahmurad.the_project.Hotels.Options;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.abdallahmurad.the_project.R;

import static android.support.design.R.id.auto;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFilter extends Fragment {

    private int rooms_count = 1;
    private int adults_count = 1;

    public PeopleFilter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people_filter, container, false);

        Switch aSwitch = view.findViewById(auto);
        final ImageButton addRoom = view.findViewById(R.id.add_room);
        final ImageButton minRoom = view.findViewById(R.id.min_room);
        final ImageButton addAdults = view.findViewById(R.id.add_adults);
        final ImageButton minAdults = view.findViewById(R.id.min_adults);
        final Button save = view.findViewById(R.id.save);

        final TextView rooms_counr_text_view = view.findViewById(R.id.tv3);
        final TextView adults_counr_text_view = view.findViewById(R.id.tv4);

        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rooms_counr_text_view.setText(++rooms_count + " Rooms");
                save.setText("Save (" + rooms_count + " rooms ," + adults_count + " adults )");

            }
        });
        minRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rooms_count >= 1)
                    rooms_counr_text_view.setText(--rooms_count + " Rooms");
                save.setText("Save (" + rooms_count + " rooms ," + adults_count + " adults )");

            }
        });


        addAdults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adults_counr_text_view.setText(++adults_count + " Adults");
                save.setText("Save (" + rooms_count + " rooms ," + adults_count + " adults )");


            }
        });
        minAdults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adults_count >= 1)
                    adults_counr_text_view.setText(--adults_count + " Adults");
                save.setText("Save (" + rooms_count + " rooms ," + adults_count + " adults )");


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Save (" + rooms_count + " rooms ," + adults_count + " adults )", Toast.LENGTH_SHORT).show();
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (minAdults.isEnabled()) {
                    minAdults.setEnabled(false);
                    minRoom.setEnabled(false);
                    addRoom.setEnabled(false);
                    addAdults.setEnabled(false);

                } else {
                    minAdults.setEnabled(true);
                    minRoom.setEnabled(true);
                    addRoom.setEnabled(true);
                    addAdults.setEnabled(true);
                }


            }
        });


        return view;
    }

}
