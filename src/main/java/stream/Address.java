package stream;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;
    private String index;
    private String country;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home + ", apartment=" + apartment
                + ", index='" + index + '\'' + ", country='" + country + '\'' + '}';
    }

    static class Builder {
        private String city;
        private String street;
        private int home;
        private int apartment;
        private String index;
        private String country;

        Builder buildCity(String city) {
            this.city = city;
            return this;
        }

        Builder buildStreet(String street) {
            this.street = street;
            return this;
        }

        Builder buildHome(int home) {
            this.home = home;
            return this;
        }

        Builder buildApartment(int apartment) {
            this.apartment = apartment;
            return this;
        }

        Builder buildIndex(String index) {
            this.index = index;
            return this;
        }

        Builder buildCountry(String country) {
            this.country = country;
            return this;
        }

        Address build() {
            Address address = new Address();
            address.city = city;
            address.street = street;
            address.home = home;
            address.apartment = apartment;
            address.index = index;
            address.country = country;
            return address;
        }
    }

    public static void main(String[] args) {
        Address address = new Builder().buildCity("Moscow")
                .buildStreet("Lenin street")
                .buildHome(10)
                .buildApartment(12)
                .buildIndex("142000")
                .buildCountry("Russia")
                .build();
        System.out.println(address);
    }
}
