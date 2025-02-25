package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    public static final int PIN = 1111;
    public static final int WRONG_PIN = 1122;
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
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void isBlockedAfterManyWrongUnlockingAttempts() {
        smartDoorLock.lock();
        for (int i = 0; i < SimpleSmartDoorLock.MAX_ATTEMPTS; i++) {
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
    }


}
