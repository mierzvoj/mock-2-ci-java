package org.example;

import org.easymock.EasyMock;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

import org.easymock.*;

public class CarEasyTest {
    private Car myFerrari = EasyMock.createMock(Car.class);

    @Test
    public void test_instance_car() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void test_default_behavior_needsFuel() {
        assertFalse(myFerrari.needsFuel(), "New test double should return False as boolean");
    }

    @Test
    public void test_default_behavior_temperature() {
        assertEquals(0.0, myFerrari.getEngineTemperature(), "New test double should return 0.0");
    }

    @Test
    public void test_stubbing_mock() {
        expect(myFerrari.needsFuel()).andReturn(true);
        EasyMock.replay(myFerrari);
        assertTrue(myFerrari.needsFuel());

    }

    @Test
    public void test_exception() {
        expect(myFerrari.needsFuel()).andThrow(new RuntimeException());
        EasyMock.replay(myFerrari);
        assertThrows(RuntimeException.class, () -> {
            myFerrari.needsFuel();
        });
    }

    //-------------------my tests--------------------------
    private Car myCar = EasyMock.createMock(Fiat.class);


    @Test
    public void test_stubbing_mock_mycar_fuel() {
        myCar.setFuelLevel(20);
       EasyMock.expect(myCar.getFuelLevel()).andAnswer(() -> {
            return 20f;
        }).once();
        replay(myCar);
        assertEquals(20f, myCar.getFuelLevel());
    }


    @Test
    public void test_stubbing_mock_mycar_temperature() {
        EasyMock.expect(myCar.getEngineTemp()).andAnswer(() -> {
            return 70d;
        }).once();
        replay(myCar);
        assertEquals(70d, myCar.getEngineTemp());
    }

    @Test
    public void destination_test() {
        expect(myCar.driveTo("Gdynia")).andThrow(new RuntimeException());
        EasyMock.replay(myCar);
        assertThrows(RuntimeException.class, () -> {
            myCar.driveTo("Gdynia");
        });
    }

    private Car myDreamCar = EasyMock.createMock(DreamCar.class);

    @Test
    public void test_if_dream_car_ever_needs_fuel() {
        boolean fuel = false;
        myDreamCar.setFuelLevel(20f);
        if (myDreamCar.getFuelLevel() == 0f) {
            fuel = true;
        }
        assertEquals(true, fuel);
    }

    @Test
    public void test_if_dream_car_ever_heats() {
        boolean temp = false;
        myDreamCar.setEngineTemp(90f);
        if (myDreamCar.getEngineTemperature() > 0f) {
            temp = true;
        }
        assertEquals(false, temp);
    }

    @Test
    public void test_stubbing_mock_mydreamcar_temperature() {
        myDreamCar.setEngineTemp(70);
        expectLastCall().andAnswer(() -> 0).once();
        replay(myCar);
        assertEquals(0, myDreamCar.getEngineTemp());
    }

}

