package com.abdallahmurad.the_project.Hotels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.abdallahmurad.the_project.Abdallah_util.model.Hotel;
import com.abdallahmurad.the_project.Hotels.Options.Filters;
import com.abdallahmurad.the_project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.CITY_ID;

public class HotelsPage extends AppCompatActivity {
    private static final String TAG = "ttt";
    int cityId;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_page);
        if (getIntent() != null) {
            Intent intent = getIntent();
            cityId = intent.getIntExtra(CITY_ID, 0);
        }
        Log.d(TAG, "onCreate:CityId:" + cityId);

        final List<Hotel> hotelList = new ArrayList<>();


        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mDatabaseReference.child("0/hotels").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    if (dataSnapshot.child(i + "").getValue(com.abdallahmurad.the_project.Abdallah_util.model.Hotel.class).getCityId() == cityId) {
                        Hotel hotel = dataSnapshot.child(i + "").getValue(Hotel.class);
                        Log.d(TAG, "onCreate:onDataChange:Hotel:cityId:" + hotel.getCityId());
                        hotelList.add(hotel);
                    }
                }

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hotels_list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                RecyclerView.Adapter adapter = new HotelsListAdapter(hotelList, getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCreate:onCancelled:Failed to get The Data" + databaseError.getMessage());

            }
        });




















//        List<Hotel> hotels = new ArrayList<>();
//
//
//        hotels.add(new Hotel(R.drawable.hotels, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 200", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                0, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 450", "Taxes not included\n 3 nights,1 room", 0,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 354", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels2, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 643", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels3, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 356", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels4, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 235", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                0, R.drawable.ic_favorite_grey));
//
//        hotels.add(new Hotel(R.drawable.hotels5, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 675", "Taxes not included\n 3 nights,1 room", 0,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//
//        hotels.add(new Hotel(R.drawable.hotels5, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 575", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                R.drawable.ic_pay_at_hotel, R.drawable.ic_favorite_grey));
//
//
//        hotels.add(new Hotel(R.drawable.hotels5, "Locanda La Corte", "1.16 km from city center\nHas been Booked one houer ago",
//                "EUR 487", "Taxes not included\n 3 nights,1 room", R.drawable.ic_pay_now,
//                0, R.drawable.ic_favorite_grey));








        Button filterButton = (Button) findViewById(R.id.filter_button);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filter = new Intent(HotelsPage.this, Filters.class);
                startActivity(filter);
            }
        });




    }

}
