export class Vehicle {
    vin: number;
    made: String;
    model: String;
    year: number;
    lease_price: number;

    constructor() {
        this.vin = 0;  // Default value for a number property
        this.made = ""; // Default value for a string property
        this.model = ""; // Default value for a string property
        this.year = 0;  // Default value for a number property
        this.lease_price = 0; // Default value for a number property
    }
}
