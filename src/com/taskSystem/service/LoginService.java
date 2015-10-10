package com.taskSystem.service;

import com.taskSystem.dao.LoginDao;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yh on 2015/10/10.
 */
@Service("loginService")
public class LoginService {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private LoginDao loginDao;

    public JSONObject login(String userName,String passWord) {
        lock.writeLock().lock();
        try{
            return loginDao.login(userName, passWord);
        }finally{
            lock.writeLock().unlock();
        }
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }
    @Resource(name = "loginDao")
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
