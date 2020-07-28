package ru.job4j.tracker.singleton;

public class TrackerSingleFour {
    private TrackerSingleFour() {
    }

    public static TrackerSingleFour getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder{
        private static final TrackerSingleFour INSTANCE = new TrackerSingleFour();
    }
}
