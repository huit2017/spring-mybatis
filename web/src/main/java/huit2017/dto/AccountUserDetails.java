package huit2017.dto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AccountUserDetails extends User  {

    private static final long serialVersionUID = 1L;

    private final AccountDto accountDto;

    public AccountUserDetails(AccountDto accountDto) {
        super(accountDto.getMail(), accountDto.getPassword(), AuthorityUtils.createAuthorityList("USER"));
        this.accountDto = accountDto;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }
}
