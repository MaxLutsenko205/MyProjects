// the main creator, needed to create common product(vessel)
public abstract class VesselCreator {
    public void startPouring(){
        Vessel vessel = createVessel();
        vessel.pourInto();
    }

    public abstract Vessel createVessel();
}
