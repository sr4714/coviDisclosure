package com.example.hospitals;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
/**
 * @author vignatiy
 */
public class NearByData extends AsyncTask<Object, String, String> {
    String GooglePlaceData;
    GoogleMap Map;
    String URL;

    @Override
    protected String doInBackground(Object... objects) {
        Map = (GoogleMap)objects[0];
        URL = (String)objects[1];
        usingUrl usingUrl = new usingUrl();
        try{
            GooglePlaceData = usingUrl.readURL(URL);
        }
        catch (IOException excp){
            excp.printStackTrace();
        }
        return GooglePlaceData;
    }
    @Override
    protected void onPostExecute(String s){

        List<HashMap<String,String>> nearByPlacesData;
        DataAnalyze analyze = new DataAnalyze();
        nearByPlacesData = analyze.analyze(s);
        Log.d("nearByPlacesData", "call the analyze");
        showNearByPlaceData(nearByPlacesData);
    }
    private void showNearByPlaceData(List<HashMap<String,String>> NearByData){
        for(int i = 0; i < NearByData.size(); i++){
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String,String> GooglePalce = NearByData.get(i);
           String nameOfThePlace = GooglePalce.get("nameOfThePlace");
           String localePlaces = GooglePalce.get("localePlaces");
           double lati = Double.parseDouble(GooglePalce.get("lati"));
           double longi= Double.parseDouble(GooglePalce.get("longi"));
           LatLng latLng = new LatLng(lati, longi);
           markerOptions.position(latLng);
           markerOptions.title(nameOfThePlace + ":" +localePlaces);
           markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
           Map.addMarker(markerOptions);
           Map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
           Map.animateCamera(CameraUpdateFactory.zoomBy(20));
//            Map.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

}
