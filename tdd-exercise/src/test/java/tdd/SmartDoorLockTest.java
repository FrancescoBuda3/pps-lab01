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
        smartDoorLock.lock();
        smartDoorLock.unlock(pin);
        assertFalse(smartDoorLock.isLocked());
    }
}
