package hexagonal_architecture.domain_layer.model;

public class Location {
    private final double latitude;
    private final double longitude; //TODO Point2D

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
