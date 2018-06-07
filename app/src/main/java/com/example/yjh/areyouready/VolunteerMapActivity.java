package com.example.yjh.areyouready;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class VolunteerMapActivity extends AppCompatActivity {
    private static final String TAG = "MapTestActivity";

    SupportMapFragment mapFragment;
    GoogleMap map;
    MarkerOptions locationMarker; // 위치 표시 마커

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_map);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d(TAG, "GoogleMap is ready.");

                map = googleMap;

                // 주소를 이용해 (위도, 경도)를 얻어온다. (Geocoder 이용)
                try{
                    MapsInitializer.initialize(getApplicationContext());
                } catch(Exception e) {
                    e.printStackTrace();
                }

                final Geocoder geocoder = new Geocoder(getApplicationContext());

                Intent intent = getIntent();

                List<Address> list = null;
                String addressStr = intent.getStringExtra("title");
                try {
                    list = geocoder.getFromLocationName(addressStr, 10);
                } catch(IOException e) {
                    e.printStackTrace();
                }

                showCurrentLocation(list.get(0).getLatitude(), list.get(0).getLongitude());
            }
        });
    }

    private void showCurrentLocation(Double latitude, Double longitude) {
        // 전달 받은 위도, 경도값을 이용해 LtLng 객체 생성
        LatLng curPoint = new LatLng(latitude, longitude);

        // 해당 위치를 지도 중심으로 표시
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));

        // 해당 위치에 마커 표시
        showLocationMarker(latitude, longitude);
    }

    private void showLocationMarker(Double latitude, Double longitude) {
        if(locationMarker == null) {
            locationMarker = new MarkerOptions();
            locationMarker.position(new LatLng(latitude, longitude));

            locationMarker.title("봉사기관");
            locationMarker.snippet("봉사기관 위치"); // 봉사기관 이름 넣어주기
            locationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.placeholder));
            map.addMarker(locationMarker);
        }
        else {
            locationMarker.position(new LatLng(latitude, longitude));
        }
    }
}
