public interface DistanceCalculator {

    String[] calculateDistance(double lat1, double lon1, double lat2, double lon2);


    default double degreeToRadian(double deg) {
        return (deg * Math.PI / 180.0);
    }


    default double radianToDegree(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}