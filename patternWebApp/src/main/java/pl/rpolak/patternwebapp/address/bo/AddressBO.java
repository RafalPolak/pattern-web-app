package pl.rpolak.patternwebapp.address.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.address.entity.Address;
import pl.rpolak.patternwebapp.address.repo.IAddressRepository;
import pl.rpolak.patternwebapp.address.snapshot.AddressSnapshot;

@Service
@Transactional
public class AddressBO implements IAddressBO {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(AddressBO.class);
    
    private final IAddressRepository addressRepository;
    
    @Autowired
    public AddressBO(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    @Override
    public AddressSnapshot add(String street, String postalCode, String city, String country) {
        Address address = new Address(street, postalCode, city, country);
        
        addressRepository.save(address);
        
        AddressSnapshot addressSnapshot = address.toAddressSnapshot();
        
        LOGGER.info("Add Address <{}> <{}> <{}> <{}>",
                addressSnapshot.getStreet(),
                addressSnapshot.getPostalCode(),
                addressSnapshot.getCity(),
                addressSnapshot.getCountry());
        
        return addressSnapshot;
    }
    
    @Override
    public AddressSnapshot edit(Long addressId, String street, String postalCode, String city, String country) {
        Address address = addressRepository.findOne(addressId);
        
        address.edit(street, postalCode, city, country);
        
        addressRepository.save(address);
        
        AddressSnapshot addressSnapshot = address.toAddressSnapshot();
        
        LOGGER.info("Edit Address <{}> <{}> <{}> <{}>",
                addressSnapshot.getStreet(),
                addressSnapshot.getPostalCode(),
                addressSnapshot.getCity(),
                addressSnapshot.getCountry());
        
        return addressSnapshot;
    }
    
    @Override
    public void remove(Long addressId) {
        Address address = addressRepository.findOne(addressId);
        
        addressRepository.delete(address);
        
        LOGGER.info("Remove Address <{}>", addressId);
    }
    
}
