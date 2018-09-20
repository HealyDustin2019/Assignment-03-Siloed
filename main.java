//Used to take in user input
import java.util.Scanner;

public class Siloed {
    public static void main(String[] args){
        //Creates new object from Scanner class stored in variable "scan" which reads input stream of System
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of towers available.");
        //towerNumber used to create properly sized array
        int towerNumber = scan.nextInt();
        //Arrays used to store heights and diameters of tower
        int[] towerHeight = new int[towerNumber];
        int[] towerDiameter = new int[towerNumber];
        System.out.println("Enter population affected.");
        int pop = scan.nextInt();
        System.out.println("Enter the number of days water supply needs to last.");
        int days = scan.nextInt();
        System.out.println("Enter usual water usage per person in gallons.");
        double usage = scan.nextDouble();
        //Initializing variables meant to be used in calculations in for loop
        double towerRadiusSquared = 0;
        double totalVolume = 0;
        //for loop used to take in values of the array for each index
        for(int x = 0; x < towerNumber; x++){
            System.out.println("Enter tower height "+(x+1)+" (in meters).");
            towerHeight[x] = scan.nextInt();
            System.out.println("Enter tower diameter "+(x+1)+" (in meters).");
            towerDiameter[x] = scan.nextInt();
            //towerRadiusSquared used in volume equation V = H * pi * R^2
            towerRadiusSquared = ((towerDiameter[x]/2.0)*(towerDiameter[x]/2.0));
            //In each iteration of for loop, totalVolume adds the newest volume to sum of all previous volumes
            totalVolume += (towerHeight[x]*Math.PI*towerRadiusSquared);
        }
        //waterPerPerson distributes an equal amount of water for every person
        double waterPerPerson = totalVolume/pop;
        //waterForTime distributes an equal amount of water for each day over the period given
        double waterForTime = waterPerPerson/days;
        //printf used to round double value to two decimals & 264.172 converts between cubic meters & gallons
        System.out.printf("Each person can only use ~%.2f",(waterForTime * 264.172));
        System.out.print(" gallons of water a day for it to last "+days+" days.\n");
        System.out.printf("Cut usage by ~%.2f",(usage-(waterForTime * 264.172)));
        System.out.print(" gallons per person.");
    }
}
