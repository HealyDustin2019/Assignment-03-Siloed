import java.util.Scanner;

public class Siloed {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of towers available.");
        int towerNumber = scan.nextInt();
        int[] towerHeight = new int[towerNumber];
        int[] towerDiameter = new int[towerNumber];
        System.out.println("Enter population affected.");
        int pop = scan.nextInt();
        System.out.println("Enter the number of days water supply needs to last.");
        int days = scan.nextInt();
        System.out.println("Enter usual water usage per person in gallons.");
        double usage = scan.nextDouble();
        double totalVolume = 0;
        for(int x = 0; x < towerNumber; x++){
            System.out.println("Enter tower height "+(x+1)+" (in meters).");
            towerHeight[x] = scan.nextInt();
            System.out.println("Enter tower diameter "+(x+1)+" (in meters).");
            towerDiameter[x] = scan.nextInt();
            totalVolume =+ (towerHeight[x]*Math.PI)*((towerDiameter[x]/2.0)*(towerDiameter[x]/2.0));
        }
        double waterPerPerson = totalVolume/pop;
        double waterForTime = waterPerPerson/days;
        System.out.printf("Each person can only use ~%.2f",(waterForTime * 264.172));
        System.out.print(" gallons of water a day for it to last "+ days+ " days.\n");
        //264.172 represents conversion factor between cubic meters & gallons
        System.out.printf("Cut usage by ~%.2f",(usage-(waterForTime * 264.172)));
        System.out.print(" gallons per person.");
    }
}
