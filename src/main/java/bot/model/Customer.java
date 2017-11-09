package bot.model;

public class Customer {
    private String userAlias;
    private String userPhone;
    private String address;

    public String getUserAlias() {
        return userAlias;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
