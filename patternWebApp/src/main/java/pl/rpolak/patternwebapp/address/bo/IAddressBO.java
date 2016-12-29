package pl.rpolak.patternwebapp.address.bo;

import pl.rpolak.patternwebapp.address.snapshot.AddressSnapshot;

public interface IAddressBO {

    AddressSnapshot add(String street, String postalCode, String city, String country);

    AddressSnapshot edit(Long addressId, String street, String postalCode, String city, String country);

    public void remove(Long addressId);

}
