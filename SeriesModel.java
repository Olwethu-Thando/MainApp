/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesModel {
    private String seriesID;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;
    
    
    
    public SeriesModel(String seriesID,String seriesNmae , int seriesAge,int seriesNumberOfEpisodes ){
        this.seriesID=seriesID;
        this.seriesName=seriesName;
        this.seriesAge=seriesAge;
        this.seriesNumberOfEpisodes=seriesNumberOfEpisodes;
        }
    
    public String getseriesID(){return seriesID;}
    public String getseriesName(){return seriesName;}
    public int getseriesAge(){return seriesAge;}
    public int getseriesNumberOfEpisodes(){return seriesNumberOfEpisodes;}
    
    public void setSeriesName(String seriesName){this.seriesName=seriesName;}
    public void setSeriesID(String seriesID){this.seriesID=seriesID;}
    public void setseriesAge(int seriesAge){this.seriesAge=seriesAge;}
    public void setseriesNumberOfEpisode(int seriesNumberOfEpisode ){this.seriesNumberOfEpisodes= seriesNumberOfEpisode;}
   
    
    public String toString(){
        return"series ID:" + seriesID +", Name :" + seriesName + "Age Restriction:" + seriesAge + ", Episodes:" + seriesNumberOfEpisodes;
        
    }
    
    
}
