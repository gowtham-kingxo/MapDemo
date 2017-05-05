package com.example.gowthamg.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //List<String> l = Arrays.asList(h);

        ListView myListView = (ListView) findViewById(R.id.list);
    final ArrayList<String> cricketers = new ArrayList<String>();
//        cricketers.addAll(l);
       cricketers.add("Dhoni");
       cricketers.add("Dravid");
      cricketers.add("yuvi");



        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cricketers);
        myListView.setAdapter(arrayadapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MapsActivity.this,"Hello "+cricketers.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
//hellooo


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(13.088766, 80.208577);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker at Anna nagar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));

    }
}
