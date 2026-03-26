#include "WaterVehicle.hpp"

WaterVehicle::WaterVehicle(string vehicleID, string brand, int maxSpeed, int displacement)
            : Vehicle(vehicleID, brand, maxSpeed), displacement(displacement) {
    cout << "[CREATE] WaterVehicle " << brand << " with " << displacement << " tons displacement ready\n" ;
}

WaterVehicle :: ~WaterVehicle() {
    cout << "[DELETE] WaterVehicle " << brand << " destroyed\n";
}

string WaterVehicle :: showSpec() {
   return getSpec();
}

void WaterVehicle :: sail(string destination) const{
    cout << "[SAIL] " << brand << " (" << displacement << " tons) sailing to " << destination << "\n"; 
}

void WaterVehicle :: dive(int depth) const {
    cout << "[DIVE] " << brand << " diving to " << depth << "m (max: " << displacement << "m)\n";
}
