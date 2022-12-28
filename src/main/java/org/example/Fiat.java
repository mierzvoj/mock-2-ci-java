package org.example;

public class Fiat implements Car {
    private float fuelLevel;
    private float engineTemp;

    @Override
    public void setFuelLevel(float fuel) {
        this.fuelLevel = fuel;
    }
    @Override
    public void setEngineTemp(float engTemp) {
        this.engineTemp = engTemp;
    }



    @Override
    public float getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public double getEngineTemp() {
        return engineTemp;
    }


    @Override
    public boolean needsFuel() {
        if (fuelLevel > 0f) {
            return false;
        } else
            return true;
    }


    @Override
    public float getEngineTemperature() {
        if (engineTemp >= 90d) {
            System.out.println("Engine overheat");
        }
        return engineTemp;
    }

    @Override
    public String driveTo(String destination) {
        if (destination.equals("Warsaw")) {
            return "Correct route";
        } else {
            throw new RuntimeException();
        }
    }
}
