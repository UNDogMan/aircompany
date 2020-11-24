import plane.ExperimentalPlane;
import model.MilitaryType;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane)plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane)plane)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return this.getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return this.getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getMilitaryType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return this.getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getMilitaryType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane)plane)
                .collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        this.planes = planes.stream()
                .sorted(Comparator.comparingInt(Plane::getMaxFlightDistance))
                .collect(Collectors.toList());
        return this;
    }


    public Airport sortByMaxSpeed() {
        this.planes = planes.stream()
                .sorted(Comparator.comparingInt(Plane::getMaxSpeed))
                .collect(Collectors.toList());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        this.planes = planes.stream()
                .sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity))
                .collect(Collectors.toList());
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
