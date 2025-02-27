package Bako;
/**
 * The Personals-class holds personal information about a member,
 * like: surname, lastnam, e-mail address and password.
 * Since a member never changes his/her personals while changing membership level,
 * it is useful to use a separat class to hold this information.
 * The password can be changed, but it then needs to be different than the old
 * passowrd. The Password is not case sensitive.
 */
class Personals {
    private final String surname;
    private final String firstName;
    private final String emailAddress;
    private String password;

    /**
     * Creates an instance of Personals.
     *
     * @param firstName    first name of the person
     * @param surname      surname of the person
     * @param emailAddress email address of the person
     * @param password     the password of the person
     */
    public Personals(String firstName, String surname, String emailAddress, String password) {
        if (firstName == null
                || surname == null
                || emailAddress == null
                || password == null
                || firstName.trim().equals("")
                || surname.trim().equals("")
                || emailAddress.trim().equals("")
                || password.trim().equals("")) {
            throw new IllegalArgumentException("One or more of the parameters are invalid.");
        }
        this.firstName = firstName.trim();
        this.surname = surname.trim();
        this.emailAddress = emailAddress.trim();
        this.password = password.trim();
    }

    /**
     * Returns the persons first name.
     *
     * @return the persons first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the persons surname.
     *
     * @return the persons surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns the persons e-mail address.
     *
     * @return the persons e-mail address.
     */
    public String getEMailAddress() {
        return emailAddress;
    }

    /**
     * Checks if the password given by the parameter matches the password
     * registered on the person. Returns <code>true</code> if password is
     * correct <code>false</code> if password is wrong.
     *
     * @param password the password to test for
     * @return <code>true</code> if password is correct
     * <code>false</code> if password is wrong
     */
    public boolean okPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }

    /**
     * Changes the password. The new password must be different from the old.
     * Passwords are not case sensitive.
     * Returns <code>true</code> if the password was changed successfully,
     * <code>false</code> if not.
     *
     * @param oldPassword the old password of the person
     * @param newPassword the new password to be changed to
     * @return <code>true</code> if the password was changed successfully,
     * <code>false</code> if not.
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        // A Guard claus, hence return is allowed
        if (oldPassword == null || newPassword == null) {
            return false;
        }
        boolean changeSuccessfull;

        if (!password.equalsIgnoreCase(oldPassword.trim()))
        {
            changeSuccessfull = false;

        } else {
            password = newPassword.trim();
            changeSuccessfull = true;
        }
        return changeSuccessfull;
    }

    @Override
    public String toString() {
        return "surname: \t firstName\temailAddress\t" +
                surname +"\t" +
                firstName +"\t"  +
                emailAddress ;


    }
}
