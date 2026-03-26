#pragma once
#include "Vehicle.hpp"

class WaterVehicle : public Vehicle {
    public:
        WaterVehicle(string vehicleID, string brand, int maxSpeed, int displacement);
        ~WaterVehicle();
        string showSpec();
        void sail(string destination) const;
        void dive(int depth) const;


    private:
        int displacement;
};