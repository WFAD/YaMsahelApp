package com.abdallahmurad.the_project.BookingPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abdallahmurad.the_project.Home.HomeActivity;
import com.abdallahmurad.the_project.R;

public class BookingActivityDetl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);


        BookingCheck check = new BookingCheck("Dec 14,2017", "Fri, 2 PM", "Dec 15,2017", "Sat, 12 PM", 1);
        BookNowData bookData = new BookNowData("Swissotel hotel", "Istunbul, Turkey", "ILS", "EUR", check, 116);


        TextView hotelName = (TextView) findViewById(R.id.booked_hotel);
        TextView cityName = (TextView) findViewById(R.id.hotel_city);

        TextView checkInDate = (TextView) findViewById(R.id.check_in_date);
        TextView checkInTime = (TextView) findViewById(R.id.check_in_time);
        TextView checkOutDate = (TextView) findViewById(R.id.check_out_date);
        TextView checkOutTime = (TextView) findViewById(R.id.check_out_time);

        TextView bookingPrice = (TextView) findViewById(R.id.booked_price);
        TextView hotelCurrancy = (TextView) findViewById(R.id.hotel_currancy);


        hotelName.setText(bookData.getHotelName());
        cityName.setText(bookData.getCityName());

        checkInDate.setText(check.getCheckInDate());
        checkInTime.setText(check.getCheckInTime());
        checkOutDate.setText(check.getCheckOutDate());
        checkOutTime.setText(check.getCheckOutTime());

        bookingPrice.setText(bookData.getCurrantCurrancey() + " " + bookData.getFinalPrice());
        hotelCurrancy.setText("Hotel will request payment in "+bookData.getHotelCurrancy()+" instead of "+bookData.getCurrantCurrancey());
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookingActivityDetl.this, "All Done.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookingActivityDetl.this, HomeActivity.class));
            }
        });

    }
}
