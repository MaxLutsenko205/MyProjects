// Concrete product(Bottle) that should implement common interface and its methods
public class Bottle implements Vessel{
    @Override
    public void pourInto() {
        System.out.println("You are pouring into Bottle");
    }
}
