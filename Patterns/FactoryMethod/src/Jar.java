// Concrete product(Jar) that should implement common interface and its methods
public class Jar implements Vessel {
    @Override
    public void pourInto() {
        System.out.println("You are pouring watter into Jar");
    }
}
