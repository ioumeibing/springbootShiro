//package com.how2java.springboot.Realm;
//
//import com.how2java.springboot.helper.PasswordHelper;
//import com.how2java.springboot.pojo.Permission;
//import com.how2java.springboot.pojo.Person;
//import com.how2java.springboot.pojo.Role;
//import com.how2java.springboot.service.PersonService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.crypto.hash.SimpleHash;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//public class MyShiroRealm extends AuthorizingRealm {
//    @Autowired
//    PersonService personService;
///*身份认证
//* 登录之后，用户信息将会存储在Shiro中。
//* */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("执行认证方法doGetAuthenticationInfo");
//        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
//
//        /*从Shiro中获取用户名*/
//        String username = utoken.getUsername();
//       /* String password =utoken.getPassword().toString();*/
//        /*通过用户名，查询用户拥有的角色和权限*/
//        Person person = personService.getUserByName(username);
//        /*将用户信息存储在Shiro，以便授权的时候使用*/
//        String salt = person.getSalt();
//
//        /*String password =person.getPassword();*/
//
//        Boolean b = PasswordHelper.checkCredentials("123",salt,person.getPassword());
//
//        SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(person,
//                person.getPassword(),
//                ByteSource.Util.bytes(salt),
//                this.getClass().getName());
//        return info;
//    }
//
///*授权*/
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行授权方法doGetAuthorizationInfo");
//        /*从Shiro中取出用户的所有信息，包括用户的角色和权限*/
//        Person person =(Person) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
//        /*查询用户的权限，并存储在一个集合中*/
//        List<String> permissionList = new ArrayList<>();
//        Set<Role> roles =person.getRoleList();
//        if (roles.size()>0){
//            for (Role role:roles){
//                Set<Permission> pSet=role.getPermissions();
//                if (pSet.size()>0){
//                    for (Permission p:pSet){
//                        permissionList.add(p.getUrl());
//                    }
//                }
//            }
//        }
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        /*将用户的权限交给Shiro管理*/
//        authorizationInfo.addStringPermissions(permissionList);
//        return authorizationInfo;
//    }
//}
