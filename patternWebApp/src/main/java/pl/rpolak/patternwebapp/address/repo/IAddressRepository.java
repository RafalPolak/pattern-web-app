package pl.rpolak.patternwebapp.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rpolak.patternwebapp.address.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
