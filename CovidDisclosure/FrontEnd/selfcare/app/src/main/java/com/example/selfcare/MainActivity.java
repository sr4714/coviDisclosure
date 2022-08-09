package com.example.selfcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    TextView text;
    String InfoUrl = "https://1213fa86-f724-4e0d-9661-8e0ded83cd04.mock.pstmn.io//Self";
    RequestQueue requestTheQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.buttony);
//        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        text = (TextView)findViewById(R.id.text);
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestTheQueue = new RequestQueue(cache,network);
        requestTheQueue.start();
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, InfoUrl, (JSONObject) null,
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