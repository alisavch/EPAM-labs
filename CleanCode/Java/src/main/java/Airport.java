import plane.ExperimentalPlane;
import model.MilitaryType;
import model.ClassificationLevel;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane)plane)
                .filter(plane -> plane.getMilitaryType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(plane -> plane instanceof PassengerPlane).map(plane -> (PassengerPlane)plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane)plane)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public boolean comparePlanesMaxLoadCapacity(){
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                return false;
            }
        }
        return true;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
            return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane)plane)
                .filter(plane->plane.getMilitaryType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof  ExperimentalPlane).map(plane -> (ExperimentalPlane)plane).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof ExperimentalPlane).map(plane -> (ExperimentalPlane)plane)
                .filter(plane->plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED).collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxFlightDistance() - object2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxSpeed() - object2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxLoadCapacity() - object2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        planes.forEach(plane -> System.out.println(plane.toString()));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
