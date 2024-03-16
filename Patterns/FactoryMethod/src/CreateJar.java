// Concrete creator for returning concrete object(Jar vessel)
public class CreateJar extends VesselCreator{
    @Override
    public Vessel createVessel() {
        return new Jar();
    }
}
