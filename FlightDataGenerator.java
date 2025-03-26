public interface FlightDataGenerator {

    String[][] generateDestinations();


    int generateSeatCount();


    String generateFlightNumber(int letterCount, int divisor);


    String generateCustomerId();
}