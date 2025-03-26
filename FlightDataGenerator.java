public interface FlightDataGenerator {
    /**
     * Generates random destinations for flights
     * @return 2D array containing origin and destination coordinates
     */
    String[][] generateDestinations();

    /**
     * Generates random number of seats for a flight
     * @return number of seats
     */
    int generateSeatCount();

    /**
     * Generates unique flight number
     * @param letterCount number of letters in flight number
     * @param divisor divisor for seat number component
     * @return generated flight number
     */
    String generateFlightNumber(int letterCount, int divisor);

    /**
     * Generates random customer ID
     * @return generated customer ID
     */
    String generateCustomerId();
}