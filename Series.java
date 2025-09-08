/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class Series {
    private ArrayList<SeriesModel>serieslist=new ArrayList<>();
    private Scanner series=new Scanner(System.in);
    
    
    
   public void CaptureSeries(){
       System.out.print("Enter series ID: ");
       String id = series.nextLine();
       
       System.out.print("Enter series Name: ");
       String name = series.nextLine();
       
       int age =0;
       while(true){
           System.out.print("Enter age restriction(2-18): ");
           age=Integer.parseInt(series.nextLine());
           if (age >=2&&age<=18)
               break;
           else 
               System.out.print("Invalid age, please enter age between 2 and 18");
           
       }
 
       
       System.out.print("Enter number of episodes: ");
       int episodes=Integer.parseInt(series.nextLine());
       serieslist.add(new SeriesModel(id,name,age,episodes));
       System.out.print("series successfully captured");
       
       
   }
   public void SearchSeries(){
       System.out.print("Enter series ID to search :");
       String id =series.nextLine();
       for(SeriesModel s : serieslist){
           if (s.getseriesID().equals(id)){
               System.out.println(s);
               return;
           }
       }
       System.out.println("No series found with ID :"+id);
   }
   public void UpdateSeries(){
       System.out.print("Enter series ID to update: ");
       String id =series.nextLine();
       for(SeriesModel s : serieslist){
           if (s.getseriesID().equals(id)){
               System.out.print("Enter new name");
               s.setSeriesName(series.nextLine());
               
               System.out.print("Enter new Age Restriction");
               s.setseriesAge(Integer.parseInt(series.nextLine()));
               
               System.out.print("Enter new number of episodes:");
              s.setseriesNumberOfEpisode(Integer.parseInt(series.nextLine()));
              
              System.out.println("Series updated successfully");
              return;
           }
   
       }

   }
   public void DeleteSeries(){
       System.out.print("enter series ID to delete: ");
       String id =series.nextLine();
       for(SeriesModel s : serieslist){
           if (s.getseriesID().equals(id)){
               System.out.print("Are you sure you want to delete ?");
               String confirm=series.nextLine();
               if (confirm.equalsIgnoreCase("yes"))
                   serieslist.remove(s);
               System.out.println("Series deleted");
               
           }
           return;
       
   }
       
}
   public void SeriesReport(){
       if(serieslist.isEmpty()){
           System.out.println("----series report----");
           for (SeriesModel s:serieslist){
               System.out.println(s);
           }
       }
   }
   public void ExitSeriesApplication(){
       System.out.println("Existing application");
       System.exit(0);
   }
}

