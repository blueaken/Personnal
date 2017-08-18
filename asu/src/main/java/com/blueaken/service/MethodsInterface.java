package com.blueaken.service;

/**
 * Created by shenjian on 2017/8/17.
 */
public interface MethodsInterface {
    /**
     * 用户登录
     * @param username
     *            用户名
     * @param passwd
     *            密码
     * @return 登录成功返回true，失败则返回false
     */
    boolean login(String username, String passwd);

    /**
     * 用户登出
     * @param username
     *            用户名
     * @param passwd
     *            密码
     * @return 登录成功返回true，失败则返回false
     */
//    boolean logout(String username, String passwd);
}
