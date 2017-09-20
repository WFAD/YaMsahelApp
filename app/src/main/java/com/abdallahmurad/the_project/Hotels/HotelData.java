package com.abdallahmurad.the_project.Hotels;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.abdallahmurad.the_project.Abdallah_util.model.Hotel;
import com.abdallahmurad.the_project.Abdallah_util.model.Rating;
import com.abdallahmurad.the_project.Abdallah_util.model.Review;
import com.abdallahmurad.the_project.Booking.BookingActivity;
import com.abdallahmurad.the_project.Booking.BookingList.SlidingImage;
import com.abdallahmurad.the_project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.BAD;
import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.FAIR;
import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.GOOD;
import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.HOTEL_ID;

public class HotelData extends AppCompatActivity {
    private static final String TAG = "ttt";
    private BottomNavigationView bottomNavigationView;
    private DatabaseReference mDatabaseReference;
    private ViewPager hotelsImages;

    private TextView nameTV;
    private TextView ratingTV;
    private TextView ratingAvgTV;
    private ImageView favoriteIV;

    private long phoneNumber;
    private static int hotelId;
    private static boolean localIsFavorite;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_data);

        initViews();
        initListeners();
        Intent intent = getIntent();
        hotelId = intent.getIntExtra(HOTEL_ID, 0);
        Log.d(TAG, "onCreate:onDataChange:numberOfStars:" + hotelId);

        mDatabaseReference.child("0/hotels/" + hotelId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Hotel hotel = dataSnapshot.getValue(Hotel.class);
                String name = hotel.getName();
                Rating rating = hotel.getRating();

                boolean isFavorite = hotel.getFavorite();
                boolean payWithCash = hotel.getPayWithCash();
                boolean payWithCreditCard = hotel.getPayWithCreditCard();

                //TODO: Omar
                List<String> imagesUrls = hotel.getImages();
                List<String> services = hotel.getServices();
                List<Review> userReviews = hotel.getReviews();

                int starsCount = (int) Double.parseDouble(rating.getValue().split("/")[0]);
                String fiveStarRate = rating.getFiveStarCount();
                String fourStarRate = rating.getFourStarCount();
                String threeStarRate = rating.getThreeStarCount();
                String twoStarRate = rating.getTwoStarCount();
                String oneStarRate = rating.getOneStarCount();
                phoneNumber = Long.parseLong(hotel.getPhoneNumber());

                nameTV.setText(name);
                ratingTV.setText(rating.getText());
                ratingAvgTV.setText(rating.getValue());

                initBooleans(isFavorite, payWithCash, payWithCreditCard);
                addStarsViews(starsCount);
                setSurveyIcon(rating);
                setProgressRatring(fiveStarRate, fourStarRate, threeStarRate, twoStarRate, oneStarRate);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        hotelsImages.setAdapter(new SlidingImage(this, new ArrayList<>(Arrays.asList(R.drawable.room_image1, R.drawable.room_image2, R.drawable.room_image3, R.drawable.room_image4, R.drawable.room_image5))));


    }

    private void setProgressRatring(String fiveStarRate, String fourStarRate, String threeStarRate, String twoStarRate, String oneStarRate) {
        ((TextView) findViewById(R.id.fiveStarsTextView)).setText("5/5:  " + fiveStarRate);
        ((TextView) findViewById(R.id.fourStarsTextView)).setText("4/5:  " + fourStarRate);
        ((TextView) findViewById(R.id.threeStarsTextView)).setText("3/5:  " + threeStarRate);
        ((TextView) findViewById(R.id.twoStarsTextView)).setText("2/5:  " + twoStarRate);
        ((TextView) findViewById(R.id.oneStarsTextView)).setText("1/5:  " + oneStarRate);
        //TODO : Fix the ProgressPar Equation for it values

        int totalReviews = (Integer.parseInt(fiveStarRate) + Integer.parseInt(fourStarRate) +
                Integer.parseInt(threeStarRate) + Integer.parseInt(twoStarRate) +
                Integer.parseInt(oneStarRate));
        int fiveCout = (Integer.parseInt(fiveStarRate) / totalReviews);
        ProgressBar progressBar = ((ProgressBar) findViewById(R.id.fiveStarsProgressBar));
        progressBar.setMax(totalReviews);
        progressBar.setProgress(fiveCout);
    }

    private void setSurveyIcon(Rating rating) {
        if (rating.getText().equalsIgnoreCase(BAD)) {
            ratingTV.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_survey_bad, 0, 0, 0);
        } else if (rating.getText().equalsIgnoreCase(FAIR)) {
            ratingTV.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_survey_fair, 0, 0, 0);
        } else if (rating.getText().equalsIgnoreCase(GOOD)) {
            ratingTV.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_survey_good, 0, 0, 0);
        } else {
            ratingTV.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_survey_perfect, 0, 0, 0);
        }
    }

    private void addStarsViews(int starsCount) {
        LinearLayout starsLayout = (LinearLayout) findViewById(R.id.hotel_stars);
        float factor = getApplicationContext().getResources().getDisplayMetrics().density;
        for (int i = 0; i < starsCount; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.ic_hotel_stars);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (25 * factor), (int) (25 * factor));
            imageView.setLayoutParams(params);
            starsLayout.addView(imageView);
        }
    }

    private void initBooleans(boolean isFavorite, boolean payWithCash, boolean payWithCreditCard) {
        if (payWithCash) {
            findViewById(R.id.payWithCash).setVisibility(View.VISIBLE);
        }
        if (payWithCreditCard) {
            findViewById(R.id.payWithCard).setVisibility(View.VISIBLE);
        }

        setFavorite(isFavorite);
    }

    private void setFavorite(boolean isFavorite) {
        if (isFavorite) {
            favoriteIV.setImageResource(R.drawable.ic_favorite_red);
            localIsFavorite = true;
        } else {
            favoriteIV.setImageResource(R.drawable.ic_favorite_grey);
            localIsFavorite = false;
        }
    }

    private void ChangeFavoriteLocally(boolean isFavorite) {
        if (isFavorite) {
            favoriteIV.setImageResource(R.drawable.ic_favorite_grey);
            localIsFavorite = false;
        } else {
            favoriteIV.setImageResource(R.drawable.ic_favorite_red);
            localIsFavorite = true;
        }
    }

    private void initViews() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        hotelsImages = (ViewPager) findViewById(R.id.hotel_images_vp);
        nameTV = (TextView) findViewById(R.id.hotel_data_name);
        ratingTV = (TextView) findViewById(R.id.ratingText);
        ratingAvgTV = (TextView) findViewById(R.id.ratingAvg);
        favoriteIV = (ImageView) findViewById(R.id.favoriteIV);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem("internet", ContextCompat.getColor(this, R.color.md_blue_grey_500), R.drawable.ic_prop_internet);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem("food", ContextCompat.getColor(this, R.color.md_blue_grey_500), R.drawable.ic_prop_food);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem("transpiration", ContextCompat.getColor(this, R.color.md_blue_grey_500), R.drawable.ic_prop_transp);
        BottomNavigationItem bottomNavigationItem4 = new BottomNavigationItem("swimming", ContextCompat.getColor(this, R.color.md_blue_grey_500), R.drawable.ic_prop_swimming);
        BottomNavigationItem bottomNavigationItem5 = new BottomNavigationItem("more", ContextCompat.getColor(this, R.color.md_blue_grey_500), R.drawable.ic_more_vert);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);
        bottomNavigationView.addTab(bottomNavigationItem4);
        bottomNavigationView.addTab(bottomNavigationItem5);


    }

    private void initListeners() {
        findViewById(R.id.selectRoomBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookingIntent = new Intent(HotelData.this, BookingActivity.class);
                bookingIntent.putExtra(HOTEL_ID, hotelId);
                startActivity(bookingIntent);
            }
        });

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, (Uri.parse("tel:" + phoneNumber))));
            }
        });

        favoriteIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFavoriteLocally(localIsFavorite);

            }
        });
    }

}
