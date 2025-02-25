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

    private void blockLock() {
        for (int i = 0; i < smartDoorLock.getMaxAttempts(); i++) {
            smartDoorLock.unlock(WRONG_PIN);
        }
    }

    @Test
    public void isBlockedAfterManyWrongUnlockingAttempts() {
        smartDoorLock.lock();
        blockLock();
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void cantBeUnlockedIfBlocked(){
        smartDoorLock.lock();
        blockLock();
        smartDoorLock.unlock(PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    private void assertIsReset() {
        assertAll(
                () -> assertFalse(smartDoorLock.isBlocked()),
                () -> assertFalse(smartDoorLock.isLocked()),
                () -> assertEquals(0, smartDoorLock.getFailedAttempts())
        );
        smartDoorLock.lock();
        smartDoorLock.unlock(PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void canBeReset(){
        smartDoorLock.lock();
        blockLock();
        smartDoorLock.reset();
        assertIsReset();
    }

    @Test
    public void pinCantBeSetIfLocked(){
        int newPin = 1234;
        smartDoorLock.lock();
        smartDoorLock.setPin(newPin);
        smartDoorLock.unlock(newPin);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void cantBeLockedIfPinNotSet(){
        smartDoorLock.reset();
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }
}
