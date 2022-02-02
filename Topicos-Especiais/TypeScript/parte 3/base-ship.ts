class Spacecraft {
  propulsor : string;
  constructor (propulsor : string) {
    this.propulsor = propulsor
  }
  jumpIntoHyperSpace(){
    console.log(`Entering in to the hyperspace with ${this.propulsor}`);
  }
}
