public interface DistanceCalculator {
    /**
     * Calculates the distance between two points on Earth using their coordinates.
     *
     * @param lat1 origin point latitude
     * @param lon1 origin point longitude
     * @param lat2 destination point latitude
     * @param lon2 destination point longitude
     * @return array containing distance in [miles, kilometers]
     */
    String[] calculateDistance(double lat1, double lon1, double lat2, double lon2);

    /**
     * Converts degrees to radians
     *
     * @param deg angle in degrees
     * @return angle in radians
     */
    default double degreeToRadian(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * Converts radians to degrees
     *
     * @param rad angle in radians
     * @return angle in degrees
     */
    default double radianToDegree(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}