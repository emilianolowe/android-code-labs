package com.emilianolowe.networkmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgProfile = findViewById(R.id.activity_main__img_profile);
        final Button btnLoadImage = findViewById(R.id.activity_main__btn__load_image);

        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            // anonymous class
            public void onClick(View v) {
                loadImageIntoImageView(imgProfile);
            }
        });
    }

    private void loadImageIntoImageView(ImageView imageView) {
        Glide.with(this)
                .load("https://assets.imgix.net/examples/vista_w900.png")
                .centerInside()
                .placeholder(R.drawable.ic_ph_image)
                .into(imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNetworkConnectionAndDisplayInfo();

    }

    private void checkNetworkConnectionAndDisplayInfo() {
        final ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // cm.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback());



        String networkState;
        networkState = deprecatedCheckNetworkAndDisplay(cm);

        Toast.makeText(this, networkState, Toast.LENGTH_SHORT).show();
    }
    private String deprecatedCheckNetworkAndDisplay(ConnectivityManager cm) {
        // 1st Approach
        NetworkInfo networkInfo = null;
        if (cm != null) {
            networkInfo = cm.getActiveNetworkInfo();
        }

        String networkState;
        if (networkInfo != null && networkInfo.isAvailable()) {
            networkState = "Connection Ok";
        } else {
            networkState = "Something Went Wrong";
        }
        return networkState;
    }
}
