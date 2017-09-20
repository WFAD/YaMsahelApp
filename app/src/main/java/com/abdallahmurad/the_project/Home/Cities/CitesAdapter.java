package com.abdallahmurad.the_project.Home.Cities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.Hotels.HotelsPage;
import com.abdallahmurad.the_project.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.CITY_ID;

/**
 * Created by Desmond on 8/23/2017.
 */

public class CitesAdapter extends RecyclerView.Adapter<CitesAdapter.CitesViewHolder> {

    private static final String TAG = "CitiesAdapter";
    Context context;
    List<City> cities;


    public CitesAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
    }

    @Override

    public CitesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cities_list_item, parent, false);
        return new CitesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CitesViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelsIntent = new Intent(context, HotelsPage.class);
                int cityId = holder.getAdapterPosition();
                Log.d(TAG, "onBindViewHolder:onItemClick:cityId:"+cityId);
                hotelsIntent.putExtra(CITY_ID, cityId);
                hotelsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(hotelsIntent);
            }
        });


        City city = cities.get(position);
        Picasso.with(context).load(city.getImgUrl()).into(holder.cityImage);
        holder.cityName.setText(city.getName());




    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CitesViewHolder extends RecyclerView.ViewHolder {

        ImageView cityImage;
        TextView cityName;

        public CitesViewHolder(View itemView) {
            super(itemView);

            cityImage = itemView.findViewById(R.id.cities_image);
            cityName = itemView.findViewById(R.id.cities_name);

        }
    }


}
