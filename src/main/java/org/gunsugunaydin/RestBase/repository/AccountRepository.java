package org.gunsugunaydin.RestBase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.gunsugunaydin.RestBase.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    Optional<Account> findByEmail(String email);   
}
