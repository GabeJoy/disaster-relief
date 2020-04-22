//package com.example.demo;
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.realm.jdbc.JdbcRealm;
//
//public class Realm extends JdbcRealm {
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
//
//        if(uToken.getUsername() == null
//                || uToken.getUsername().isEmpty()
//                || !credentials.containsKey(uToken.getUsername())) {
//            throw new UnknownAccountException("username not found!");
//        }
//
//        return new SimpleAuthenticationInfo(
//                uToken.getUsername(),
//                credentials.get(uToken.getUsername()),
//                getName());
//
//        Realm realm = new Realm();
//        DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
//    }
//}
