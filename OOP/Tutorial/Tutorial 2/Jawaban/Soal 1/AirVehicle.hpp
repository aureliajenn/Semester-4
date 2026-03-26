#pragma once
#include "Vehicle.hpp"

class AirVehicle : public Vehicle {
    public:
        AirVehicle(string vehicleID, string brand, int maxSpeed, int maxAltitude);
        ~AirVehicle();
        string getBrandName() const;
        
        string showSpec();
        void fly(string destination) const;
        void scan(string area) const;

    private:
        int maxAltitude;
        
};