package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void canBeLocked(){
        SmartDoorLock smartDoorLock = new SimpleSmartDoorLock();
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canBeUnlocked(){
        int pin = 1111;
        SmartDoorLock smartDoorLock = new SimpleSmartDoorLock();
        smartDoorLock.lock();
        smartDoorLock.unlock(pin);
        assertFalse(smartDoorLock.isLocked());
    }
}
