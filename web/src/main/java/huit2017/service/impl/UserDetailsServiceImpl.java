package huit2017.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import huit2017.dto.AccountDto;
import huit2017.dto.AccountUserDetails;
import huit2017.entity.User;
import huit2017.entity.UserExample;
import huit2017.mapper.UserMapper;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("username is empty");
        }
        UserExample example = new UserExample();
        example.createCriteria().andMailEqualTo(username);
        User user = userMapper.selectByExample(example)
                .stream()
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("username is empty"));
        AccountDto accountDto = new AccountDto();
        try {
            BeanUtils.copyProperties(accountDto, user);
        } catch (IllegalAccessException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return new AccountUserDetails(accountDto);
    }
}
