package com.abdallahmurad.the_project.Booking.BookingList;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.expandablerecyclerview.ChildViewHolder;


/**
 * Created by Desmond on 8/6/2017.
 */

public class RoomInfoViewHolder extends ChildViewHolder {


    TextView maxAdults;
    TextView adultsPerPrice;
    TextView PricePerAdult;
    TextView earnMony;
    TextView taxesIncluding;
    ImageView addRoom;
    ImageView removeRoom;
    TextView addRoomTv;
    ViewPager images;
    TextView isRefundable;
    TextView isWirelessFree;
    TextView isParkingFree;
    Button bookNow;

    int currentRooms = 0;
    int numRooms;
    int RoomsPrice = 0;


    public RoomInfoViewHolder(@NonNull View itemView) {
        super(itemView);

        maxAdults = itemView.findViewById(R.id.max_adults);
        adultsPerPrice = itemView.findViewById(R.id.adults_per_price);
        PricePerAdult = itemView.findViewById(R.id.price_per_adults);
        earnMony = itemView.findViewById(R.id.earn_money);
        taxesIncluding = itemView.findViewById(R.id.room_taxes);
        images = itemView.findViewById(R.id.image_slider);
        isRefundable = itemView.findViewById(R.id.is_refunded);
        isWirelessFree = itemView.findViewById(R.id.wireless);
        isParkingFree = itemView.findViewById(R.id.parking);
        addRoom = itemView.findViewById(R.id.add_room);
        removeRoom = itemView.findViewById(R.id.remove_room);
        addRoomTv = itemView.findViewById(R.id.add_room_tv);

    }

    public void bind(final RoomInfo roomInfo, final Button button) {

        numRooms = roomInfo.getNumRooms();


        maxAdults.setText("Up to " + roomInfo.getMaxAdults() + " adults");
        adultsPerPrice.setText(roomInfo.getAdultsPerPrice() + " adults");
        PricePerAdult.setText(roomInfo.getCurrancey() + " " + roomInfo.getPriecPerAdult());
        earnMony.setText("Earn " + roomInfo.getCurrancey() + " " + roomInfo.getEarnMony());
        earnMony.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_small_wall, 0);
        images.setAdapter(roomInfo.getImages());


        int nights = roomInfo.getNumNights();
        if (nights == 1) {
            taxesIncluding.setText("Taxes not included " + nights + " Night");
        } else {
            taxesIncluding.setText(nights + "Nights");
        }

        // REFUNDING
        if (roomInfo.isRefundable()) {
            isRefundable.setText("REFUNDABLE");
        } else {
            isRefundable.setText("NON-REFUNDABLE");
        }

        //WIRELESS
        if (roomInfo.isWirelessFree()) {
            isWirelessFree.setText("Free Wireless Internet");
        } else {
            isWirelessFree.setText("Not Free Wireless Internet");
        }

        // PARKING

        if (roomInfo.isParkingFree()) {
            isParkingFree.setText("Free Parking");
        } else {
            isParkingFree.setText("Not Free Parking");
        }


        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentRooms < numRooms) {
                    currentRooms++;
                    RoomsPrice = roomInfo.getPriecPerAdult() * currentRooms;
                    addRoomTv.setText(currentRooms + " room (" + RoomsPrice + ")");
                }

                if (currentRooms == numRooms) {
                    addRoom.setImageResource(R.drawable.ic_blue_plus);
                    addRoom.setBackgroundResource(R.drawable.add_room_white);


                } else {
                    addRoom.setImageResource(R.drawable.ic_white_plus);
                    addRoom.setBackgroundResource(R.drawable.add_room_blue);

                    removeRoom.setImageResource(R.drawable.ic_white_minus);
                    removeRoom.setBackgroundResource(R.drawable.add_room_blue);
                    button.setVisibility(View.VISIBLE);
                }
            }
        });

        removeRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentRooms > 0) {
                    currentRooms--;

                }


                if (currentRooms == 0) {
                    removeRoom.setImageResource(R.drawable.ic_blue_minus);
                    removeRoom.setBackgroundResource(R.drawable.add_room_white);
                    addRoomTv.setText("Add Room");
                    button.setVisibility(View.GONE);
                } else {
                    removeRoom.setImageResource(R.drawable.ic_white_minus);
                    removeRoom.setBackgroundResource(R.drawable.add_room_blue);

                    addRoom.setImageResource(R.drawable.ic_white_plus);
                    addRoom.setBackgroundResource(R.drawable.add_room_blue);

                    RoomsPrice = RoomsPrice - roomInfo.getPriecPerAdult();
                    addRoomTv.setText(currentRooms + " room (" + RoomsPrice + ")");


                }

            }
        });


    }


}
