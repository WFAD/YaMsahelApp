package com.abdallahmurad.the_project.Hotels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.Abdallah_util.model.Hotel;
import com.abdallahmurad.the_project.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.HOTEL_ID;

/**
 * Created by Desmond on 8/1/2017.
 */

public class HotelsListAdapter extends RecyclerView.Adapter<HotelsListAdapter.ViewHolder> {

    private List<Hotel> hotels;
    private Context context;
    private Bitmap redFav;
    private Bitmap grayFav;

    public HotelsListAdapter(List<Hotel> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;
        redFav = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.ic_favorite_red)).getBitmap();
        grayFav = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.ic_favorite_grey)).getBitmap();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Hotel hotel = hotels.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelIntent = new Intent(context, HotelData.class);
                hotelIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                hotelIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                int hotelId = holder.getAdapterPosition();
                hotelIntent.putExtra(HOTEL_ID, hotelId);
                context.startActivity(hotelIntent);

            }
        });

//        holder.hotelImage.setImageResource(hotel.getHotelImage());
        Picasso.with(context).load(hotel.getImages().get(0)).into(holder.hotelImage);

        holder.hotelName.setText(hotel.getName());
        holder.hotelDetails.setText(hotel.getDescription());
//        holder.hotelDetails.setCompoundDrawablesWithIntrinsicBounds(Integer.parseInt(hotel.getRating().getValue()), 0, 0, 0);
//        holder.hotelTaxes.setText(hotel.getHotelTaxes());
//        holder.hotelPrice.setText(hotel.getHotelPrice());
//        holder.favorite.setImageResource(hotel.getFavorite());
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFavoriteColor(hotel);
            }
        });
        if (hotel.getPayWithCash()) {
            holder.payAtHotel.setVisibility(View.GONE);
        } else {
//            holder.payAtHotel.setImageResource(hotel.getPayAtHotel());
            holder.payAtHotel.setVisibility(View.VISIBLE);
        }
//        holder.payNow.setImageResource(hotel.getPayNow());
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    private void changeFavoriteColor(Hotel hotel) {

        if (hotel.getFavorite()) {
            hotel.setFavorite(true);
        } else {
            hotel.setFavorite(false);
        }
        notifyDataSetChanged();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImage;
        TextView hotelName;
        TextView hotelDetails;
        TextView hotelPrice;
        TextView hotelTaxes;
        ImageView payNow;
        ImageView payAtHotel;
        ImageView favorite;

        public ViewHolder(View itemView) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.hotel_image);
            hotelName = itemView.findViewById(R.id.hotel_name);
            hotelDetails = itemView.findViewById(R.id.hotel_details);
            hotelPrice = itemView.findViewById(R.id.hotel_price);
            hotelTaxes = itemView.findViewById(R.id.hotel_taxes);
            payNow = itemView.findViewById(R.id.pay_now);
            payAtHotel = itemView.findViewById(R.id.pay_at_hotel);
            favorite = itemView.findViewById(R.id.fav_hotel);

        }
    }
}

