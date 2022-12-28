package org.example;

public abstract class DreamCar implements Car {
    @Override
    public boolean needsFuel() {
        return false;
    }

    @Override
    public float getEngineTemperature() {
        return 0f;
    }



}
