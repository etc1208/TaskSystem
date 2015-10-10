package com.taskSystem.service;

import com.taskSystem.dao.StaffDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yh on 2015/10/10.
 */
@Service("staffService")
public class StaffService {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private StaffDao staffDao;

    public JSONArray getAllUser(){
        lock.writeLock().lock();
        try{
            return staffDao.getAllUser();
        }finally{
            lock.writeLock().unlock();
        }
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }
    @Resource(name="staffDao")
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
