package pl.rpolak.patternwebapp.address.snapshot;

import java.util.Objects;

public class AddressSnapshot {

    private final Long addressId;

    private final String street;

    private final String postalCode;

    private final String city;

    private final String country;

    public AddressSnapshot(Long addressId, String street, String postalCode, String city, String country) {
        this.addressId = addressId;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.addressId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressSnapshot other = (AddressSnapshot) obj;
        if (!Objects.equals(this.addressId, other.addressId)) {
            return false;
        }
        return true;
    }

}
