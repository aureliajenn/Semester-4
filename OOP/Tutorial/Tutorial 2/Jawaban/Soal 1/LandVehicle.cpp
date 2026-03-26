#include "LandVehicle.hpp"

LandVehicle::LandVehicle(string vehicleID, string brand, int maxSpeed, int numWheels)
            : Vehicle(vehicleID, brand, maxSpeed), numWheels(numWheels) {
    cout << "[CREATE] LandVehicle " << brand << " with " << numWheels << " wheels ready\n";
}

LandVehicle::~LandVehicle() {
    cout << "[DELETE] LandVehicle " << brand << " destroyed\n";
}
void LandVehicle :: drive (string destination) const {
    cout << "[DRIVE] " << brand << " (" << numWheels << " wheels) driving to " << destination << "\n";
}