package com.sifu.security.service;

import com.sifu.security.pojo.SysUser;
import com.sifu.security.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    /**
     * 用户认证的实现，即接收用户输入的username与数据库的username对比
     * 如果没有，则抛出异常
     * 如果有，则放回该对象
     *
     * @param s 用户输入的用户名
     * @return 该用户对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("s:{}",s);
        log.info("username:{},password:{}",user.getUsername(),user.getPassword());
        return user;
    }
}
