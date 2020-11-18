import Planes.ExperimentalPlane;
import Models.MilitaryType;
import Models.ClassificationLevel;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
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
        return planes.stream().map(plane -> (PassengerPlane)plane).max(new Comparator<PassengerPlane>() {
            @Override
            public int compare(PassengerPlane  object1, PassengerPlane  object2) {
                return object1.getPassengersCapacity() - object2.getPassengersCapacity();
            }
        }).get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane)plane)
                .filter(plane -> plane.getMilitaryType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane)plane)
                .filter(plane->plane.getMilitaryType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof ExperimentalPlane).map(plane -> (ExperimentalPlane)plane).collect(Collectors.toList());

    }

    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        return planes.stream().filter(plane -> plane instanceof ExperimentalPlane).map(plane -> (ExperimentalPlane)plane)
                .filter(plane->plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED).collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxFlightDistance() - object2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxSpeed() - object2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
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
        planes.stream().forEachOrdered(plane -> System.out.println(plane.toString()));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
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
}
