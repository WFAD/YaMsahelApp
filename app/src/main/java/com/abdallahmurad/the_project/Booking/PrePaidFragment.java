package com.abdallahmurad.the_project.Booking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abdallahmurad.the_project.Booking.BookingList.Header;
import com.abdallahmurad.the_project.Booking.BookingList.RoomInfo;
import com.abdallahmurad.the_project.Booking.BookingList.Rooms;
import com.abdallahmurad.the_project.Booking.BookingList.RoomsAdapter;
import com.abdallahmurad.the_project.Booking.BookingList.SlidingImage;
import com.abdallahmurad.the_project.Booking.BookingList.UserDetails;
import com.abdallahmurad.the_project.R;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrePaidFragment extends Fragment {


    public PrePaidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pay_at_hotel, container, false);
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.room_image1);
        images.add(R.drawable.room_image2);
        images.add(R.drawable.room_image3);
        images.add(R.drawable.room_image4);
        images.add(R.drawable.room_image5);

        SlidingImage RoomImages = new SlidingImage(getContext(), images);


        Header header = new Header(R.drawable.best_fit, "bestfit");
        UserDetails userDetails = new UserDetails(3, 2, 4, 88, "Taxes not included", "EUR");


        RoomInfo roomInfo = new RoomInfo(2, 2, 49, userDetails.getCurrancy(), 0.59, userDetails.getNumNightsData(), 4, RoomImages, false, true, true);
        RoomInfo roomInfo2 = new RoomInfo(4, 2, 49, userDetails.getCurrancy(), 1.50, userDetails.getNumNightsData(), 3, RoomImages, true, false, true);
        RoomInfo roomInfo3 = new RoomInfo(3, 2, 49, userDetails.getCurrancy(), 0.47, userDetails.getNumNightsData(), 5, RoomImages, false, true, false);


        Rooms rooms1 = new Rooms(images.get(0), "Single classic city view", userDetails.getNumNightsData(), roomInfo.getNumRooms(), userDetails.getCurrancy(), roomInfo.getPriecPerAdult(), Arrays.asList(roomInfo));
        Rooms rooms2 = new Rooms(images.get(1), "Family Room", userDetails.getNumNightsData(), roomInfo2.getNumRooms(), userDetails.getCurrancy(), roomInfo2.getPriecPerAdult(), Arrays.asList(roomInfo2));
        Rooms rooms3 = new Rooms(images.get(2), "Triple Room", userDetails.getNumNightsData(), roomInfo3.getNumRooms(), userDetails.getCurrancy(), roomInfo3.getPriecPerAdult(), Arrays.asList(roomInfo3));




        RecyclerView recyclerView = view.findViewById(R.id.pay_at_hotel_rv);
        RecyclerView.Adapter adapter = new RoomsAdapter(getActivity().getApplicationContext(), Arrays.asList(header, userDetails, rooms1, rooms2, rooms2, rooms3), (Button) view.findViewById(R.id.book_now));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//        linearLayoutManager.scrollToPositionWithOffset();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
