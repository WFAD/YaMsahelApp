package com.abdallahmurad.the_project.Booking.BookingList;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.expandablerecyclerview.ParentViewHolder;

/**
 * Created by Desmond on 8/6/2017.
 */

public class RoomsViewHolder extends ParentViewHolder {

    TextView roomType;
    TextView roomSomeInfo;
    ImageView arrowExpand;
    ImageView roomImage;

    public RoomsViewHolder(@NonNull View itemView) {
        super(itemView);
        roomImage = itemView.findViewById(R.id.rooms_image);
        roomSomeInfo = itemView.findViewById(R.id.rooms_some_info);
        roomType = itemView.findViewById(R.id.rooms_type);
        arrowExpand = itemView.findViewById(R.id.expand_arrow);


        arrowExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpanded()) {
                    collapseView();
                } else {
                    expandView();

                }
            }
        });

    }


    public void bind(Rooms room) {

        roomImage.setImageResource(room.getRoomImage());
        roomType.setText(room.getRoomType());
        Log.d("SomeInfo : ", room.getSomeInfo());
        roomSomeInfo.setText(room.getSomeInfo());

    }
}