package com.example.tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {
    private ArrayList<StateModel> arrayList;
     public StateAdapter(ArrayList<StateModel> arrayList){
         this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.state_case,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
         StateModel stateModel = arrayList.get(position);
        holder.stateName.setText(stateModel.getStateName());
        holder.stateCases.setText(stateModel.getStateCases());
//        holder.stateDeath.setText(stateModel.getStateDeath());
//        holder.stateDeathn.setText(stateModel.getStateRecovered());
    }

    @Override
    public int getItemCount() {

         return arrayList != null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stateName, stateCases,stateDeath,stateDeathn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stateCases = itemView.findViewById(R.id.stateCases);
            stateName = itemView.findViewById(R.id.stateName);
//            stateDeath = itemView.findViewById(R.id.stateDeath);
//            stateRecovered = itemView.findViewById(R.id.stateRecovered);
        }
    }
}
