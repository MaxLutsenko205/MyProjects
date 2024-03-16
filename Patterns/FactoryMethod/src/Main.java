// For adding new product(another vessel: glass) you need to create new ConcreteCreator(GlassCreator)
// that extends CommonCreator(VesselCreator),
// then you should create ConcreteProduct(Glass) that implements common product(Vessel)

import java.util.Scanner;
public class Main {

    // creating only one CommonCreator
    private static VesselCreator vesselCreator;


    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.print("What vessel do you prefer?: ");
        String vessel = s.nextLine();
        ChooseVessel(vessel);
        vesselCreator.startPouring();
    }

    // Choosing what concrete product will be created according to conditions (user input)
    static void ChooseVessel(String vessel){
        if (vessel.equalsIgnoreCase("jar")){
            vesselCreator = new CreateJar();
        } else if (vessel.equalsIgnoreCase("cup")){
            vesselCreator = new CreateCup();
        } else if(vessel.equalsIgnoreCase("bottle")){
            vesselCreator = new CreateBottle();
        } else {
            System.out.println("There isn't that vessel");
            System.exit(-1);
        }
    }
}
