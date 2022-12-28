package org.example;

public interface Car{
    void setFuelLevel(float fuel);
    void setEngineTemp(float engTemp);
    float getFuelLevel();
    double getEngineTemp();
    boolean needsFuel();
    float getEngineTemperature();
    String driveTo(String destination);
}
