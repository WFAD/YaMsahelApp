package com.abdallahmurad.the_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Desmond on 8/5/2017.
 */

public class FragmentUtils {


    public static void addFragment(FragmentActivity fragmentActivity, int layout, boolean addToBackStack, Fragment fragment) {
        FragmentManager manager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    public static void replaceFragment(FragmentActivity fragmentActivity, int layout, boolean addToBackStack, Fragment fragment) {
        FragmentManager manager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layout, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    public static void removeFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        FragmentManager manager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();

    }

}
