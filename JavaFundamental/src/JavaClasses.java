import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaClasses {
    private List<? extends Train> trains;
    public List<? extends Train> getTrains(){
        return trains;
    }
    private void print(Collection<? extends Train> collection) {
        for (Train train : collection) {
            System.out.println(train);
        }
    }
    public JavaClasses(List<? extends Train> trains) {
        this.trains = trains;
    }
    List<Train> trains = Array.asList(
            new Train("Minsk", "728B","2020-11-17 18:50:00",90, Train.TypeOfCarriage.SECOND_CLASS),
            new Train("Minsk", "728B","2020-11-17 18:50:00",192, Train.TypeOfCarriage.THIRD_CLASS),
            new Train("Minsk", "738B","2020-11-17 21:41:00",192, Train.TypeOfCarriage.THIRD_CLASS),
            new Train("Brest", "726B","2020-11-17 23:25:00",180, Train.TypeOfCarriage.THIRD_CLASS),
            new Train("Brest", "6303","2020-11-09 09:49:00",200, Train.TypeOfCarriage.GENERAL),
            new Train("Brest", "661B","2020-11-17 11:56:00",90, Train.TypeOfCarriage.SECOND_CLASS),
            new Train("Brest", "661B","2020-11-17 11:56:00",90, Train.TypeOfCarriage.THIRD_CLASS),
            new Train("Brest", "737B","2020-11-17 17:00:00",190, Train.TypeOfCarriage.THIRD_CLASS),
            new Train("Minsk", "736B","2020-11-13 11:50:00",40, Train.TypeOfCarriage.FIRST_CLASS),

            );
    public static void main(String[] args) {

    }
    public static class Train {
        String destination;
        String number;
        String departureTime;
        int numberOfPlace;

        public enum TypeOfCarriage {
            FIRST_CLASS,
            SECOND_CLASS,
            THIRD_CLASS,
            GENERAL
        }

        private TypeOfCarriage typeOfCarriage;

        public Train(String _destination, String _number, String _departureTime, int _numberOfPlace, TypeOfCarriage type) {
            this.destination = _destination;
            this.number = _number;
            this.departureTime = _departureTime;
            this.numberOfPlace = _numberOfPlace;
            this.typeOfCarriage = type;
        }

        public String getDestination() {
            return destination;
        }

        public String getNumber() {
            return number;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public int getNumberOfPlaces() {
            return numberOfPlace;
        }

        public TypeOfCarriage getTypeOfCarriage() {
            return typeOfCarriage;
        }

        @Override
        public String toString() {
            return "Train {" +
                    "destination: " + destination +
                    "\nnumber: " + number +
                    "\ndeparture time: " + departureTime +
                    "\nnumber op places: " + numberOfPlace +
                    "\ntype of carriage" + typeOfCarriage +
                    " }";
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Train)) return false;
            Train train = (Train) object;
            return destination.equals(train.destination) &&
                    number.equals(train.number) &&
                    departureTime == train.departureTime &&
                    numberOfPlace == train.numberOfPlace &&
                    typeOfCarriage == train.typeOfCarriage;
        }

        @Override
        public int hashCode() {
            return Objects.hash(destination, number, departureTime, numberOfPlace, typeOfCarriage);
        }
    }
    
}
