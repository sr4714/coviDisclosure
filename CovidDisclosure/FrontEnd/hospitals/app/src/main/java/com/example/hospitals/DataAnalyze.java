package com.example.hospitals;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author vignatiy
 */
public class DataAnalyze {
    private HashMap<String, String> getPlace(JSONObject GooglePlacesJson) {
        HashMap<String, String> GooglePlacesMap = new HashMap<>();
        String nameOfThePlace = "-NA-";
        String longi= "";
        String lati = "";
        String refer = "";
        String localePlaces = "-NA";
        Log.d("DataAnalyze", "result:"+ GooglePlacesMap.toString());

            try {
                if(!GooglePlacesJson.isNull("name")) {
                    nameOfThePlace = GooglePlacesJson.getString("name");
                }
                if(!GooglePlacesJson.isNull("localePlaces")) {
                    localePlaces = GooglePlacesJson.getString(localePlaces);
                }
                lati = GooglePlacesJson.getJSONObject("gemometry").getJSONObject("locaton").getString("lati");
                longi =GooglePlacesJson.getJSONObject("gemometry").getJSONObject("locaton").getString("longi");
                refer =  GooglePlacesJson.getString("refer");
                GooglePlacesJson.put("name_Of_The_Place",nameOfThePlace);
                GooglePlacesJson.put("lati",lati);
                GooglePlacesJson.put("longi",longi);
                GooglePlacesJson.put("reference",refer);
                GooglePlacesJson.put("localePlaces",localePlaces);
            }catch (JSONException excep){
                excep.printStackTrace();
            }
            return GooglePlacesMap;
        }
    private List<HashMap<String,String>> getPlace(JSONArray jsonArray) {
        Log.d("c",((Integer) jsonArray.length()).toString());
        int c = jsonArray.length();
        List<HashMap<String,String>> listOfPlace = new ArrayList<>();
        HashMap<String,String> placeOnMap = null;
        for(int i = 0; i < c; i++){
            try {
                placeOnMap = getPlace((JSONObject) jsonArray.get(i));
                listOfPlace.add(placeOnMap);
            }catch (JSONException excep){
                excep.printStackTrace();
            }
        }
        return listOfPlace;
    }
    public List<HashMap<String,String>> analyze(String jsonData) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        Log.d("data", jsonData);
        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlace(jsonArray);
    }
}
