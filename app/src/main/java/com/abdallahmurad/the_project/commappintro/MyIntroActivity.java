package com.abdallahmurad.the_project.commappintro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.abdallahmurad.the_project.Home.HomeActivity;
import com.abdallahmurad.the_project.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class MyIntroActivity extends AppIntro {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);

        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("Book");
        sliderPage1.setDescription("book around the world ");
        sliderPage1.setImageDrawable(R.drawable.ic_book);
        sliderPage1.setBgColor(getColor(R.color.md_blue_300));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Share");
        sliderPage2.setDescription("share with your friends");
        sliderPage2.setImageDrawable(R.drawable.ic_share_white_24dp);
        sliderPage2.setBgColor(getColor(R.color.md_green_800));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Comment");
        sliderPage3.setDescription("comment on other guys ");
        sliderPage3.setImageDrawable(R.drawable.ic_comment_black_24dp);
        sliderPage3.setBgColor(getColor(R.color.dot_dark_screen2));


        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("Chat");
        sliderPage4.setDescription("Or not !");
        sliderPage4.setImageDrawable(R.drawable.ic_message_intro);
        sliderPage4.setBgColor(getColor(R.color.dot_dark_screen1));

        SliderPage sliderPage5 = new SliderPage();
        sliderPage5.setTitle("Share");
        sliderPage5.setDescription("Share your journey on Facebook");
        sliderPage5.setImageDrawable(R.drawable.ic_share_white_24dp);
        sliderPage5.setBgColor(getColor(R.color.bg_screen2));



        addSlide(AppIntroFragment.newInstance(sliderPage1));
        addSlide(AppIntroFragment.newInstance(sliderPage2));
        addSlide(AppIntroFragment.newInstance(sliderPage3));
        addSlide(AppIntroFragment.newInstance(sliderPage4));
        addSlide(AppIntroFragment.newInstance(sliderPage5));

        setFlowAnimation();
        showSeparator(false);
        setNextArrowColor(getColor(R.color.md_black_1000));
        setColorSkipButton(getColor(R.color.md_black_1000));
    }

    @Override
    public void onNextPressed() {
        // Do something when users tap on Next button.
    }

    @Override
    public void onDonePressed() {
        //TODO: GO To the main Activity
        startActivity(new Intent(MyIntroActivity.this, HomeActivity.class));
        finish();
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged() {
        // Do something when slide is changed
    }

}
