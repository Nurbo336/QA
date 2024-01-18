public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\n"+"Имя: " + name +"\n"+ "Фамилия: " + surname +"\n"+
                "Телефон номер: " + phoneNumber +"\n"+ "Электронная почта: " + email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
