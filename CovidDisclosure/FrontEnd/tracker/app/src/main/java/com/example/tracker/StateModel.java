package com.example.tracker;

public class StateModel {
    private String stateName;
    private String stateCases;
    private String stateDeath;
    private String stateRecovered;

    public String getStateName(){
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateCases(){
        return stateCases;
    }
    public void setStateCases(String stateCases){
        this.stateCases = stateCases;
    }
//    public String getStateDeath(){
//        return stateDeath;
//    }
//    public void setStateDeath(String stateDeath) {
//        this.stateDeath = stateDeath;
//    }
//    public String getStateRecovered(){
//        return stateRecovered;
//    }
//    public void setStateRecovered(String stateRecovered) {
//        this.stateDeath = stateRecovered;
//    }
    public StateModel(String stateName, String stateCases){
        this.stateName = stateName;
        this.stateCases = stateCases;
//        this.stateDeath = stateName;
//        this.stateDeath = stateDeathn;
    }
}
