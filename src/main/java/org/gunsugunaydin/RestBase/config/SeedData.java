package org.gunsugunaydin.RestBase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.gunsugunaydin.RestBase.model.Account;
import org.gunsugunaydin.RestBase.service.AccountService;
import org.gunsugunaydin.RestBase.util.constants.Authority;

@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        Account account01 = new Account();
        Account account02 = new Account();

        account01.setEmail("user@user.com");
        account01.setPassword("SomeValidPassword");
        account01.setAuthorities(Authority.USER.toString());
        accountService.save(account01);

        account02.setEmail("admin@admin.com");
        account02.setPassword("SomeValidPassword");
        account02.setAuthorities(Authority.ADMIN.toString() +" "+Authority.USER.toString() );
        accountService.save(account02);     
    }    
}
