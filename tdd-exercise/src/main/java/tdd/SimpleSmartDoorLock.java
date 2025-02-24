package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private boolean isLoked;
    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {
        this.isLoked = false;
    }

    @Override
    public void lock() {
        this.isLoked = true;
    }

    @Override
    public boolean isLocked() {
        return isLoked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
