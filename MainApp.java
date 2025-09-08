/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class MainApp {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Series seriesApp=new Series ();
        System.out.print("");
        
        while(true){
            System.out.println("TV series Manangement");
            System.out.println("1. Capture series");
            System.out.println("2. search series");
            System.out.println("3. update series ");
            System.out.println("4.delete series");
            System.out.println("5. view report");
            System.out.println("6. Exit");
            System.out.println("Enter choice :");
            
            int choice =input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1-> seriesApp.CaptureSeries();
                case 2-> seriesApp.SearchSeries();
                case 3-> seriesApp.UpdateSeries();
                case 4-> seriesApp.DeleteSeries();
                case 5-> seriesApp.SeriesReport();
                case 6-> seriesApp.ExitSeriesApplication();
                default-> System.out.println(":invlid option " );
            }    
        }
        
    }
}
