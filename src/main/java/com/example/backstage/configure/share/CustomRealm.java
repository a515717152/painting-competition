package com.example.backstage.configure.share;

import com.example.backstage.service.UserService;
import com.example.backstage.util.PublicAttribute;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取登录用户的信息
        Map<String, String> search = new HashMap<String, String>();
        search.put("user_name", username);
        search.put("delete_flag", PublicAttribute.UN_DELETE);
        search.put("stage", PublicAttribute.NOT_DISABLED);
        // 获取用户角色
        Set<String> roles = userService.getRole(search);
        info.addRoles(roles);
        // 根据 username 获取用户权限
//        Set<String> permission = userService.getPermission(search);
//        info.setStringPermissions(permission);
        return info;
    }

    /**
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        // 获取前端传递过来的用户名和登录密码
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        Map<String, String> search = new HashMap<>();
        search.put("user_name", userName);
        search.put("pass_word", userPwd);
        search.put("delete_flag", PublicAttribute.UN_DELETE);
        search.put("stage", PublicAttribute.NOT_DISABLED);
        List<Map<String, Object>> userList = userService.getUserList(search);
        if (userList != null && userList.size() > 0) {
            Map<String, Object> result = userList.get(0);
            String username = result.get("user_name").toString();
            String password = result.get("pass_word").toString();
            if (username == null) {
                throw new AccountException("用户名不正确");
            }
//            else if (!userPwd.equals(password)) {
//                throw new AccountException("密码不正确");
//            }
        } else {
            throw new AccountException("用户名不正确");
        }
        return new SimpleAuthenticationInfo(userName, userPwd, getName());
    }
}

