package com.abdallahmurad.the_project.Booking.BookingList;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abdallahmurad.the_project.BookingPage.BookingActivityDetl;
import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.abdallahmurad.the_project.expandablerecyclerview.ParentViewHolder;

import java.util.List;

/**
 * Created by Desmond on 8/6/2017.
 */


public class RoomsAdapter extends ExpandableRecyclerAdapter<Rooms, RoomInfo, ParentViewHolder, RoomInfoViewHolder> {


    public static final int HEADER_VIEW_TYPE = 0;
    public static final int USER_DETAILS_VIEW_TYPE = 1;
    public static final int ROOMS_VIEW_TYPE = 2;
    public static final int ROOMS_INFO_VIEW_TYPE = 3;

    LayoutInflater inflater;
    Button bookNow;
    int parentPosition;


    public RoomsAdapter(final Context context, @NonNull List<Rooms> roomsList, Button bookNow) {
        super(roomsList);
        inflater = LayoutInflater.from(context);

        this.bookNow = bookNow;
        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), BookingActivityDetl.class));
            }
        });
    }


    @NonNull
    @Override
    public ParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {

        View view;

        switch (viewType) {
            case ROOMS_VIEW_TYPE:
                view = inflater.inflate(R.layout.booking_recycler_rooms, parentViewGroup, false);
                return new RoomsViewHolder(view);
            case HEADER_VIEW_TYPE:
                view = inflater.inflate(R.layout.booking_recycler_header, parentViewGroup, false);
                return new HeaderViewHolder(view, HEADER_VIEW_TYPE);
            case USER_DETAILS_VIEW_TYPE:
                view = inflater.inflate(R.layout.booking_recycler_details, parentViewGroup, false);
                return new HeaderViewHolder(view, USER_DETAILS_VIEW_TYPE);
        }

        return null;
    }


    @Override
    public void onBindParentViewHolder(@NonNull ParentViewHolder parentViewHolder, int parentPosition, @NonNull Rooms rooms) {

        this.parentPosition = parentPosition;
        int viewType = getParentViewType(parentPosition);
        HeaderViewHolder headerViewHolder;

        switch (viewType) {
            case HEADER_VIEW_TYPE:
                headerViewHolder = (HeaderViewHolder) parentViewHolder;
                headerViewHolder.headerBind((Header) rooms);
                break;

            case USER_DETAILS_VIEW_TYPE:
                headerViewHolder = (HeaderViewHolder) parentViewHolder;
                headerViewHolder.userDetailsBind((UserDetails) rooms);
                break;

            case ROOMS_VIEW_TYPE:
                RoomsViewHolder roomsViewHolder = (RoomsViewHolder) parentViewHolder;
                roomsViewHolder.bind(rooms);
                break;

        }

    }


    @NonNull
    @Override
    public RoomInfoViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {

        View view = inflater.inflate(R.layout.expanded_recycler_item, childViewGroup, false);
        return new RoomInfoViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(@NonNull RoomInfoViewHolder roomInfoViewHolder, int parentPosition, int childPosition, @NonNull RoomInfo roomInfo) {

        roomInfoViewHolder.bind(roomInfo, bookNow);
    }

    @Override
    public int getParentViewType(int parentPosition) {
        if (parentPosition == 0) {
            return HEADER_VIEW_TYPE;
        } else if (parentPosition == 1) {
            return USER_DETAILS_VIEW_TYPE;
        } else {
            return ROOMS_VIEW_TYPE;
        }
    }

    @Override
    public boolean isParentViewType(int viewType) {
        return viewType == HEADER_VIEW_TYPE || viewType == USER_DETAILS_VIEW_TYPE || viewType == ROOMS_VIEW_TYPE;
    }

    @Override
    public int getChildViewType(int parentPosition, int childPosition) {
        return ROOMS_INFO_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public int getParentPosition() {
        return parentPosition;
    }
}