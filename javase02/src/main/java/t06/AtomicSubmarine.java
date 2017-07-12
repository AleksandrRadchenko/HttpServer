package t06;

@SuppressWarnings("WeakerAccess")
public class AtomicSubmarine {
    private Engine engine;
    private int uranium;

    public AtomicSubmarine(int uranium) {
        this.uranium = uranium > 0 ? uranium : 0;
        this.engine = new Engine("Atomic");
    }

    public void headToDestination(Destination destination) {
        if (engine.start())
        System.out.printf("Heading to coordinates: y = %f, x = %f%n", destination.getY(), destination.getX());
    }

    private class Engine{
        String type;

        public Engine(String type) {
            this.type = type;
        }
        public boolean start() {
            return uranium > 0;
        }
    }
}
