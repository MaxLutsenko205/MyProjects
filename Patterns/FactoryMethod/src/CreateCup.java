// Concrete creator for returning concrete object(Cup vessel)
public class CreateCup extends VesselCreator{
    @Override
    public Vessel createVessel() {
        return new Cup();
    }
}
