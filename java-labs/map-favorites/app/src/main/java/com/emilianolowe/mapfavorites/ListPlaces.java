package com.emilianolowe.mapfavorites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class ListPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_places);

        Button close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final TextView view = findViewById(R.id.tv_list_places);

        // fullfill recycler view
        PlaceViewModel placeViewModel = new PlaceViewModel(this.getApplication());
        // Create places list

        placeViewModel.getAllPlaces().observe(this, new Observer<List<Place>>() {
            @Override
            public void onChanged(List<Place> places) {
                System.out.println("places: ");
                System.out.println(places);
                Iterator it = places.iterator();
                String str = "";
                while(it.hasNext()) {
                    Place place = (Place)it.next();
                    System.out.println(place.getName());
                    str = str + place.getName() + " - " + place.getDescription() + "\n";
                }

                view.setText(str);

            }
        });
    }
}
