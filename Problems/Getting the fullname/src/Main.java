class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getFullName() {
        if (firstName.equals("") && lastName.equals("")) {
            return "Unknown";
        } else if (firstName.equals("")) {
            return lastName;
        } else if (lastName.equals("")) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}