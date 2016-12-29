package pl.rpolak.patternwebapp.address.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import pl.rpolak.patternwebapp.address.snapshot.AddressSnapshot;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private String street;

    private String postalCode;

    private String city;

    private String country;

    protected Address() {

    }

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public void edit(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public AddressSnapshot toAddressSnapshot() {
        return new AddressSnapshot(addressId, street, postalCode, city, country);
    }

}
