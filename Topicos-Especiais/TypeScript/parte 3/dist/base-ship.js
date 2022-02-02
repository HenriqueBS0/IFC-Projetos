var Spacecraft = /** @class */ (function () {
    function Spacecraft(propulsor) {
        this.propulsor = propulsor;
    }
    Spacecraft.prototype.jumpIntoHyperSpace = function () {
        console.log("Entering in to the hyperspace with " + this.propulsor);
    };
    return Spacecraft;
}());
