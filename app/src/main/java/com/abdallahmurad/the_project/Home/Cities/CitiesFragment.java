package com.abdallahmurad.the_project.Home.Cities;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.abdallahmurad.the_project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.abdallahmurad.the_project.Abdallah_util.AppConstants.CITIES;
import static com.miguelcatalan.materialsearchview.MaterialSearchView.REQUEST_VOICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CitiesFragment extends Fragment {
    MaterialSearchView searchView;
    Context context;

    private static final String TAG = "ttt";
    private DatabaseReference mDatabaseReference;


    public CitiesFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_cities, container, false);

        context = getActivity().getApplicationContext();


        Toolbar toolbar = view.findViewById(R.id.search_toolbar);
        ((AppCompatActivity) getContext()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getContext()).getSupportActionBar().setTitle("");


        searchView = view.findViewById(R.id.search_view);

        searchView.setVoiceIcon(context.getDrawable(R.drawable.ic_voice));
        searchView.setVoiceSearch(true);
        searchView.showVoice(true);


        final List<City> cityList = new ArrayList<>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mDatabaseReference.child("1/"+CITIES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    City city = dataSnapshot.child(i + "").getValue(City.class);
                    cityList.add(city);

                }
                Log.d(TAG, cityList.toString());
                RecyclerView recyclerView = view.findViewById(R.id.cities_recyclerview);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                RecyclerView.Adapter adapter = new CitesAdapter(context, cityList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCreate:Failed to read cityList.", databaseError.toException());

            }
        });


        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            if (matches != null && matches.size() > 0) {
                String searchWord = matches.get(0);
                if (!TextUtils.isEmpty(searchWord)) {
                    searchView.setQuery(searchWord, false);
                }
            }

            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
