package com.taskSystem.dao;

import com.taskSystem.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yh on 2015/10/10.
 */
@Repository("staffDao")
public class StaffDao {

    private HibernateTemplate hibernateTemplate = null;
    private JSONObject jsonObject = null;
    private JSONArray jsonArray = null;

    public JSONArray getAllUser(){

        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        List<User> userList = new ArrayList<User>();
        try {
            userList = (List<User>) this.hibernateTemplate.find("from User where userType!='1'");
            for(int i = 0;i < userList.size();i++) {
                User u = userList.get(i);
                jsonObject.put("username",u.getUserName());
                jsonObject.put("password",u.getPassWord());
                jsonObject.put("usertype",u.getUserType());
                jsonObject.put("currentloc",u.getCurrentLoc());
                jsonObject.put("updatetime",u.getUpdateTime());
                jsonObject.put("logintime",u.getLoginTime());
                jsonObject.put("status",u.getStatus());
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }





    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }
}
