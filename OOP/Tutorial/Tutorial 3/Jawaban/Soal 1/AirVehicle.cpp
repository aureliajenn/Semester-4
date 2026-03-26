#include "AirVehicle.hpp"

AirVehicle::AirVehicle(string VehicleID, string brand, int maxSpeed, int maxAltitude): Vehicle(VehicleID, brand, maxSpeed), maxAltitude(maxAltitude){
    cout << "[CREATE] AirVehicle " << brand << " at max altitude " << maxAltitude <<"m ready\n"; 
}

AirVehicle::~AirVehicle() {
    cout << "[DELETE] AirVehicle " << brand << " destroyed\n";
}

string AirVehicle::showSpec() {
    return getSpec();
}

string AirVehicle::getBrandName() const{
    return brand;
}

void AirVehicle::fly(string destination) const{
    cout << "[FLY] " << brand << " (max " << maxAltitude << "m) flying to " << destination << "\n";
    
}

void AirVehicle::scan(string area) const {
    cout << "[SCAN] " << brand << " " << area << " for 30 minutes\n";
}