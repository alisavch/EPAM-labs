class Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        this._model = model;
        this._maxSpeed = maxSpeed;
        this._maxFlightDistance = maxFlightDistance;
        this._maxLoadCapacity = maxLoadCapacity;
    }

    getModel() {
        return this._model;
    }

    getMaxSpeed() {
        return this._maxSpeed;
    }

    GetMaxFlightDistance() {
        return this._maxFlightDistance;
    }

    getMinLoadCapacity() {
        return this._maxLoadCapacity;
    }
}

module.exports = Plane;
