package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock {

    private int attempts;
    private final int maxAttempts = 10;
    private boolean isLoked;
    private int pin;

    @Override
    public void setPin(int pin) {
        if (!isLoked) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if (pin == this.pin && !isBlocked()) {
            isLoked = false;
        } else {
            attempts++;
        }
    }

    @Override
    public void lock() {
        if (this.pin != 0) {
            this.isLoked = true;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isLocked() {
        return isLoked;
    }

    @Override
    public boolean isBlocked() {
        return this.attempts >= maxAttempts;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {
        this.attempts = 0;
        this.pin = 0;
        this.isLoked = false;
    }
}
