public class RolesAndPermissions {
    public RolesAndPermissions() {
        // Initialize roles and permissions
    }
    //        ************************************************************ Behaviours/Methods ************************************************************

    /**
     * Checks if the admin with specified credentials is registered or not.
     * @param username of the imaginary admin
     * @param password of the imaginary admin
     * @return -1 if admin not found, else index of the admin in the array.
     */
    public int isPrivilegedUserOrNot(String username, String password) {
        int isFound = -1;
        String[][] adminCredentials = User.getAdminCredentials();
        for (int i = 0; i < adminCredentials.length; i++) {
            if (adminCredentials[i][0] != null && username.equals(adminCredentials[i][0])) {
                if (password.equals(adminCredentials[i][1])) {
                    isFound = i;
                    break;
                }
            }
        }
        return isFound;
    }

    /**
     * Checks if the passenger with specified credentials is registered or not.
     * @param email of the specified passenger
     * @param password of the specified passenger
     * @return 1 with the userID if the passenger is registered, else 0
     */
    public String isPassengerRegistered(String email, String password) {
        String isFound = "0";
        for (Customer c : Customer.customerCollection) {
            if (email.equals(c.getEmail())) {
                if (password.equals(c.getPassword())) {
                    isFound = "1-" + c.getUserID();
                    break;
                }
            }
        }
        return isFound;
    }
}
