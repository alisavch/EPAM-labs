package plane;

import model.ClassificationLevel;
import model.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private final ExperimentalTypes experimentalType;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalTypes getExperimentalPlane(){
        return  experimentalType;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MilitaryPlane)) return false;
        if (!super.equals(object)) return false;
        ExperimentalPlane experimentalPlane = (ExperimentalPlane) object;
        return this.experimentalType == ((ExperimentalPlane)object).experimentalType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType);
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
