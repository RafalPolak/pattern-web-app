package pl.rpolak.patternwebapp.address.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.address.entity.Address;
import pl.rpolak.patternwebapp.address.repo.IAddressRepository;
import pl.rpolak.patternwebapp.address.snapshot.AddressSnapshot;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Component
public class AddressSnapshotFinder implements IAddressSnapshotFinder {

    private final IAddressRepository addressRepository;

    @Autowired
    public AddressSnapshotFinder(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressSnapshot findById(Long addressId) {
        Address address = addressRepository.findOne(addressId);
        return address == null ? null : address.toAddressSnapshot();
    }

}
