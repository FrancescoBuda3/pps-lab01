package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    public static final int PIN = 1111;
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        smartDoorLock = new SimpleSmartDoorLock();
        smartDoorLock.setPin(PIN);
    }

    @Test
    public void canBeLocked(){
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canBeUnlocked(){
        smartDoorLock.lock();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void cantBeUnlockedWithWrongPin(){
        int wrongPin = 1122;
        smartDoorLock.lock();
        smartDoorLock.unlock(wrongPin);
        assertTrue(smartDoorLock.isLocked());
    }
}
