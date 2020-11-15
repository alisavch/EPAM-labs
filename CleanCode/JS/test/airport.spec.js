const assert = require('chai').assert;

const Airport = require('../airport');
const ClassificationLevel = require('../models/classificationLevel');
const ExperimentalPlane = require('../planes/experimentalPlane');
const ExperimentalTypes = require('../models/experimentalTypes');
const MilitaryPlane = require('../planes/militaryPlane');
const MilitaryType = require('../models/ilitaryType');
const Plane = require('../planes/plane');
const PassengerPlane = require('../planes/passengerPlane');

describe('My Test', () => {
    let planes = [
        new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
        new PassengerPlane('Boeing-737-800', 940, 12300, 63870, 192),
        new PassengerPlane('Boeing-747', 980, 16100, 70500, 242),
        new PassengerPlane('Airbus A320', 930, 11800, 65500, 188),
        new PassengerPlane('Airbus A330', 990, 14800, 80500, 222),
        new PassengerPlane('Embraer 190', 870, 8100, 30800, 64),
        new PassengerPlane('Sukhoi Superjet 100', 870, 11500, 50500, 140),
        new PassengerPlane('Bombardier CS300', 920, 11000, 60700, 196),

        new MilitaryPlane('B-1B Lancer', 1050, 21000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane('B-2 Spirit', 1030, 22000, 70000, MilitaryType.BOMBER),
        new MilitaryPlane('B-52 Stratofortress', 1000, 20000, 80000, MilitaryType.BOMBER),
        new MilitaryPlane('F-15', 1500, 12000, 10000, MilitaryType.FIGHTER),
        new MilitaryPlane('F-22', 1550, 13000, 11000, MilitaryType.FIGHTER),
        new MilitaryPlane('C-130 Hercules', 650, 5000, 110000, MilitaryType.TRANSPORT),

        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    ];
        let airport = new Airport(planes);

    it('should have military planes with transport type', () => {
        assert.equal(airport.getTransportMilitaryPlanes().map(militaryPlane => militaryPlane.getMilitaryType()===MilitaryType.TYPE_TRANSPORT).filter(bool=>bool).length,
            transportMilitaryPlanes.length);
    });

    it('should check passenger plane with max capacity', () => {
        assert.isFalse(airport.getPassengerPlaneWithMaxPassengersCapacity() == planeWithMaxPassengerCapacity);
    });

    it('should check passenger plane with max load capacity is higher thar current', () => {
        assert.isTrue(airport.airport.sortByMaxLoadCapacity().reduce((next, current)=>(next == true)&&(next <= current) ? current : false, -Infinity));
    })

    it('should check that military plane has at least one bomber', () => {
        assert.ifTrue(militaryPlane.filter( militaryPlane => militaryPlane.getMilitaryType() === MilitaryType.BOMBER));
    })

    it('should check that experimentsl planes has classification level higher than unclassified', () => {
        assert.isTrue(airport.getExperimentalPlanes().filter(plane => plane.getClassificationLevel() === ClassificationLevel.UNCLASSIFIED).length === 0);
        }
    });

});



