public class RolesAndPermissions {
    public RolesAndPermissions() {

    }



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
