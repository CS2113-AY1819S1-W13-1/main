package seedu.address.security;

import seedu.address.commons.core.ComponentManager;

/***
 *  Implements a Security authentication that identifies user
 */

public class SecurityManager extends ComponentManager implements Security {
    private boolean isAuthenticated;
    private String username;
    private String password;
    //Person userPerson;


    public SecurityManager() {
        this.isAuthenticated = false; //Test for now
        this.username = "test";
        this.password = "test";
    }

    public boolean getAuthentication() {
        return this.isAuthenticated;
    }

    @Override
    public void login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            this.isAuthenticated = true;
            //TODO Implement Person class that this is linked to:
            //userPerson = user1;
            System.out.println("Correct Password");
        } else {
            //TODO Raise and exception to prompt user to type again
            System.out.println("Incorrect password");
        }
    }
}