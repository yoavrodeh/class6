public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    private Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    public double mass() { return mass; }
    public double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    
    public static void main(String[] args) {
        double earthWeight = 75;
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %.1f%n",
                             p, p.surfaceWeight(mass));
        // Your weight on MERCURY is 28.3
        // Your weight on VENUS is 67.9
        // Your weight on EARTH is 75.0
        // Your weight on MARS is 28.
    }
}
