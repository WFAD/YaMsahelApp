package com.abdallahmurad.the_project.Booking;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdallahmurad.the_project.R;

import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.HOTEL_ID;


public class BookingActivity extends AppCompatActivity {
    private static int hotelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        hotelId = getIntent().getIntExtra(HOTEL_ID, 0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        setCustomTabs(tabLayout);


        ImageView exitFragment = (ImageView) findViewById(R.id.exit_fragment);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingActivity.this.finish();
            }
        });


    }

    private void setCustomTabs(TabLayout tabLayout) {

        // TAB 1
        View tab2 = View.inflate(this, R.layout.tab_custom_view, null);
        TextView tabTv2 = tab2.findViewById(R.id.tab_tv);
        tabTv2.setText("PRE-PAID");
        tabTv2.setBackgroundResource(R.drawable.pre_paid_view);
        tabTv2.setTextColor(ContextCompat.getColor(this, R.color.tabTitle2));
        ImageView tabImage2 = tab2.findViewById(R.id.tab_img);
        tabImage2.setImageResource(R.drawable.ic_pay_now);
        TextView tabRates2 = tab2.findViewById(R.id.tab_rates);
        tabRates2.setText("rates from EUR 83");
        TextView tabTaxes2 = tab2.findViewById(R.id.tab_taxes);
        tabTaxes2.setText("Taxes not included");
        tabLayout.getTabAt(0).setCustomView(tab2);


        // TAB 2
        View tab1 = View.inflate(this, R.layout.tab_custom_view, null);
        TextView tabTv1 = tab1.findViewById(R.id.tab_tv);
        tabTv1.setText("PAY AT HOTEL");
        tabTv1.setBackgroundResource(R.drawable.pay_at_hotel_view);
        tabTv1.setTextColor(ContextCompat.getColor(this, R.color.tabTitle1));
        ImageView tabImage1 = tab1.findViewById(R.id.tab_img);
        tabImage1.setImageResource(R.drawable.ic_pay_at_hotel);
        TextView tabRates = tab1.findViewById(R.id.tab_rates);
        tabRates.setText("rates from EUR 83");
        TextView tabTaxes = tab1.findViewById(R.id.tab_taxes);
        tabTaxes.setText("Taxes not included");
        tabLayout.getTabAt(1).setCustomView(tab1);


    }


}
