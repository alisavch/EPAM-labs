const PassengerPlane = require('./planes/passengerPlane');
const MilitaryPlane = require('./planes/militaryPlane');
const MilitaryType = require('./models/militaryType');
const ExperimentalPlane = require('./planes/experimentalPlane');

class Airport {
    constructor(planes){
        this.planes = planes;
    }

    getPlanes(){
        return this.planes;
    }

    getPassengerPlanes() {
        return this.planes.filter(plane => plane instanceof PassengerPlane);
    }

    getMilitaryPlanes() {
        return this.planes.filter(plane => plane instanceof MilitaryPlane);
    }

    getPassengerPlaneWithMaxPassengersCapacity() {
        return this.getPassengerPlanes().reduce((previous, current) =>
        previous.getPassengersCapacity() > current.getPassengersCapacity() ? previous : current);
    }

    getTransportMilitaryPlanes(){
        return this.getMilitaryPlanes().filter(plane => plane.getMilitaryType() === MilitaryType.TRANSPORT);
    }

    getBomberMilitaryPlanes(){
        return this.getMiilitaruPlanes().filter(plane => plane.getMilitaryType() === MilitaryType.BOMBER)
    }

    getExperimentalPlanes() {
        return this.planes.filter(plane => plane instanceof ExperimentalPlane);
    }

    sortByMaxDistance() {
        return this.planes.sort((next, current) => (next.Get_Max_Flight_Distance() > current.Get_Max_Flight_Distance()) ? 1 : -1);
    }


    sortByMaxSpeed() {
        return this.planes.sort((next, current) => (next.getMS() > current.getMS()) ? 1 : -1);
    }

    sortByMaxLoadCapacity() {
        return this.planes.sort((next, current) => (next.getMinLoadCapacity() > current.getMinLoadCapacity()) ? 1 : -1);
    }

    getPlanes() {
        return this.planes;
    }

    static convertPlanesArrayToJSON(planes) {
        return JSON.stringify(planes);
    }
}

module.exports = Airport;
