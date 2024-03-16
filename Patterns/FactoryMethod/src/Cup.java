// Concrete product(Cup) that should implement common interface and its methods
public class Cup implements Vessel{
    @Override
    public void pourInto() {
        System.out.println("You are pouring watter into Cup");
    }
}
