// Concrete creator for returning concrete object(Bottle vessel)
public class CreateBottle extends VesselCreator{

    @Override
    public Vessel createVessel() {
        return new Bottle();
    }
}
