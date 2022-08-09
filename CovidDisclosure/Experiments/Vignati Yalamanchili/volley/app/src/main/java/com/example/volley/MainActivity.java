package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    String ResponseUrl="https://1213fa86-f724-4e0d-9661-8e0ded83cd04.mock.pstmn.io//SelfDescription";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.buttonS);
        textView = (TextView)findViewById(R.id.text);
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//                JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ResponseUrl, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        public void onResponse(String ResponseUrl){
//                            textView.setText(ResponseUrl);
//                            requestQueue.stop();
//                        }
//                    }
//                    , new Response.ErrorListener(){
//                        @Override
//                    public void onErrorResponse(VolleyError error) {
//                    {
//                        textView.setText("Something went wrong");
//                        error.printStackTrace();
////                        requestQueue.stop();
//                    }
//                });
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ResponseUrl, (JSONObject) null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject Response) {
                                try {
                                    textView.setText(Response.get("me").toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                requestQueue.stop();
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong");
                        error.printStackTrace();
//                        requestQueue.stop();
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }

}