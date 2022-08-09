package com.example.hospitals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.nio.Buffer;
import java.util.List;

/**
 * @author vignatiy
 */
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap Map;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLoc;
    private Marker nowLoationMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    private View v;
    int PROXIMITY_RADIUS =10000;
    double lati, longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
             CheckLocPermission();
         }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_LOCATION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    GRANTED THE permission
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                        if(client == null){
                            buildGoogleApiClient();
                        }
                        Map.setMyLocationEnabled(true);
                    }
                    else{
                        Toast.makeText(this,"The permission is denied", Toast.LENGTH_LONG).show();
                    }
                    return;
                }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Map = googleMap;

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            buildGoogleApiClient();
            Map.setMyLocationEnabled(true);
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
    }
//    @SuppressLint("WrongViewCast")
    public void onClick(View v){
       switch (v.getId()){
        case R.id.buttonSearch:
            EditText tfLocation;
            tfLocation = (EditText)findViewById(R.id.tfLocation);
            String location = tfLocation.getText().toString();
            List<Address> addressList = null;
            MarkerOptions MO = new MarkerOptions();
            if(!location.equals("")){
                Geocoder geocoder = new Geocoder(this);
                try{
                    addressList = geocoder.getFromLocationName(location,7);
                for(int i = 0; i< addressList.size();i++){
                    Address myAddress = addressList.get(i);
                    LatLng latLng = new LatLng(myAddress.getLatitude(),myAddress.getLongitude());
                    MO.position(latLng);
                    Map.addMarker(MO);
                    Map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }break;
           case R.id.buttonHospitals:
               Map.clear();
               String hospital = "hospital";
               String url = getUrl(lati, longi, hospital);
               Object dataTran[] = new Object[2];
               dataTran[0] = Map;
               dataTran[1] = url;
               NearByData getNearByData = new NearByData();
               getNearByData.execute(dataTran);
               Toast.makeText(MapsActivity.this, "Showing hospitals nearby", Toast.LENGTH_LONG).show();
               break;
        }
    }
    private String getUrl (double lati, double longi, String placeNearby){
        StringBuilder GoogleUrlPlace = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/");
        GoogleUrlPlace.append("location="+lati+","+longi);
        GoogleUrlPlace.append("&radius="+PROXIMITY_RADIUS);
        GoogleUrlPlace.append("&type"+placeNearby);
        GoogleUrlPlace.append("&sensor=true");
        GoogleUrlPlace.append("&key="+getString(R.string.google_maps_key));
        Log.d("MapsActiviy","url: "+GoogleUrlPlace.toString());
        return GoogleUrlPlace.toString();
    }
    protected synchronized void buildGoogleApiClient(){
         client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
         client.connect();
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        longi = location.getLongitude();
        lati = location.getLatitude();
        lastLoc = location;
        if(nowLoationMarker != null){
            nowLoationMarker.remove();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
//        markerOptions.title("your current location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        nowLoationMarker = Map.addMarker(markerOptions);
        Map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        Map.animateCamera(CameraUpdateFactory.zoomBy(20));
        if(client!= null){
            LocationServices.FusedLocationApi.removeLocationUpdates(client,this);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(100);
        locationRequest.setFastestInterval(100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }
    }
    public boolean  CheckLocPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
            }
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}