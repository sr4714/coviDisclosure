package com.example.tracker;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class WorldcasesFragment extends Fragment {
    TextView totalCases, totalRec, totalDeath;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorldcasesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorldcasesFragment newInstance(String param1, String param2) {
        WorldcasesFragment fragment = new WorldcasesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_worldcases, container, false);
        viewInIt();
        getDataAPI();
        return view;
    }

    private void getDataAPI() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String Url ="https://1213fa86-f724-4e0d-9661-8e0ded83cd04.mock.pstmn.io//world";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, (JSONObject) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject Response) {

                        try {
                            totalCases.setText(Response.get("total_cases").toString());
                            totalRec.setText(Response.get("total_recovered").toString());
                            totalDeath.setText(Response.get("total_death").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        requestQueue.stop();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                totalCases.setText("Something went wrong");
                error.printStackTrace();
//                        requestQueue.stop();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    private void viewInIt() {
        totalCases = view.findViewById(R.id.totalcasesn);
        totalRec = view.findViewById(R.id.trecn);
        totalDeath = view.findViewById(R.id.tdeathn);
    }
}

