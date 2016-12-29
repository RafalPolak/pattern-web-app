package pl.rpolak.patternwebapp.address.finder;

import pl.rpolak.patternwebapp.address.snapshot.AddressSnapshot;

public interface IAddressSnapshotFinder {

    AddressSnapshot findById(Long addressId);

}
