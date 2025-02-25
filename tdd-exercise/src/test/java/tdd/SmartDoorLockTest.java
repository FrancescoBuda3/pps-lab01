package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        smartDoorLock = new SimpleSmartDoorLock();
    }

    @Test
    public void canBeLocked(){
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canBeUnlocked(){
        int pin = 1111;
        smartDoorLock.setPin(pin);
        smartDoorLock.lock();
        smartDoorLock.unlock(pin);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void cantBeUnlockedWithWrongPin(){
        int pin = 1111;
        int wrongPin = 1122;
        smartDoorLock.setPin(pin);
        smartDoorLock.lock();
        smartDoorLock.unlock(wrongPin);
        assertTrue(smartDoorLock.isLocked());
    }
}
