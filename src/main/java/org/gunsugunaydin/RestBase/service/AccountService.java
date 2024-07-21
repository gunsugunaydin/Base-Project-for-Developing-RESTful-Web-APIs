package org.gunsugunaydin.RestBase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.gunsugunaydin.RestBase.model.Account;
import org.gunsugunaydin.RestBase.repository.AccountRepository;
import org.gunsugunaydin.RestBase.util.constants.Authority;


@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Save a new account, encoding the password and setting default authorities if not provided.
    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        if (account.getAuthorities() == null){
            account.setAuthorities(Authority.USER.toString());
        }
        return accountRepository.save(account);      
    }

    //Retrieve all accounts from the repository.
    public List<Account> findAll() {
       return accountRepository.findAll();
    }

    //Find an account by its email.
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);     
    }

    //Find an account by its ID.
    public Optional<Account> findById(long id) {
        return accountRepository.findById(id);       
    }

    //Delete an account by its ID.
    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }

    //Load a user by username(email), used for authentication.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Account> optionalAccount =  accountRepository.findByEmail(email);
       if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found");
       }
       Account account = optionalAccount.get();

       List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
       grantedAuthorities.add(new SimpleGrantedAuthority(account.getAuthorities()));
       return new User(account.getEmail(), account.getPassword(), grantedAuthorities);
    }
}

