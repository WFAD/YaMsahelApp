package com.abdallahmurad.the_project.Booking.BookingList;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.expandablerecyclerview.ParentViewHolder;

import static com.abdallahmurad.the_project.Booking.BookingList.RoomsAdapter.HEADER_VIEW_TYPE;
import static com.abdallahmurad.the_project.Booking.BookingList.RoomsAdapter.USER_DETAILS_VIEW_TYPE;


/**
 * Created by Desmond on 8/11/2017.
 */

public class HeaderViewHolder extends ParentViewHolder {

    // UserDetails
    TextView numRooms;
    TextView numNights;
    TextView numAdults;
    TextView numPrice;
    TextView detailsTaxes;
    //Header
    ImageView headerImage;
    TextView headerTitle;

    public HeaderViewHolder(@NonNull View itemView, int viewType) {
        super(itemView);


        switch (viewType) {
            case HEADER_VIEW_TYPE:
                createHeaderView(itemView);
                break;
            case USER_DETAILS_VIEW_TYPE:
                createUserDetailsView(itemView);
                break;
        }


    }


    public void createUserDetailsView(View itemView) {
        numRooms = itemView.findViewById(R.id.rooms_num);
        numNights = itemView.findViewById(R.id.nights_num);
        numAdults = itemView.findViewById(R.id.adults_num);
        numPrice = itemView.findViewById(R.id.price_num);
        detailsTaxes = itemView.findViewById(R.id.details_taxes);
    }

    void createHeaderView(View itemView) {
        headerImage = itemView.findViewById(R.id.header_image);
        headerTitle = itemView.findViewById(R.id.header_text);
    }

    public void headerBind(Header header) {

        headerImage.setImageResource(header.getHeaderImageData());
        headerTitle.setText(header.getHeaderTitleData());


    }

    public void userDetailsBind(UserDetails userDetails) {

        numRooms.setText(userDetails.getNumRoomsData()+"");
        numNights.setText(userDetails.getNumNightsData()+"");
        numAdults.setText(userDetails.getNumAdultsData()+"");
        numPrice.setText(userDetails.getCurrancy()+" "+userDetails.getNumPriceData());
        detailsTaxes.setText(userDetails.getDetailsTaxesData());


    }
}
