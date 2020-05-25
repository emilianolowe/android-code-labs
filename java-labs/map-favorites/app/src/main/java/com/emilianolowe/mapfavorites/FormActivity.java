package com.emilianolowe.mapfavorites;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    private PlaceViewModel placeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = getIntent();
                String latitude = i.getStringExtra("lat");
                String longitude = i.getStringExtra("long");

                EditText title = findViewById(R.id.titleText);
                EditText description = findViewById(R.id.descriptionText);

                String message = "Lat: " + latitude
                        + ", longitude: " + longitude
                        + ", Title: " + title.getText()
                        + ", description: " + description.getText();

                Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Place place = new Place(title.getText().toString(),
                        description.getText().toString(),
                        Double.valueOf(latitude).doubleValue(),
                        Double.valueOf(longitude).doubleValue());

                AgentAsyncTask background = new AgentAsyncTask(getBaseContext(), place);
                background.execute();

                finish();
            }
        });
    }
    private static class AgentAsyncTask extends AsyncTask<Void, Void, Integer> {

        private Place place;
        private Context ctx;

        public AgentAsyncTask(Context ctx, Place place) {
            this.ctx = ctx;
            this.place = place;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            MapsDatabase.getDatabase(ctx).placeDAO().insert(place);
            return null;
        }
    }

}
