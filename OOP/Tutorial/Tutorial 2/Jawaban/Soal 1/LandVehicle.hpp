#pragma once
#include "Vehicle.hpp"
class LandVehicle : public Vehicle {
    private:
        int numWheels;
    public:
        LandVehicle(string vehicleID, string brand, int maxSpeed, int numWheels);
        ~LandVehicle();
        
        void drive(string destination) const;
};