package com.taskSystem.dao;

import com.taskSystem.model.User;
import net.sf.json.JSONObject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yh on 2015/10/10.
 */
@Repository("loginDao")
public class LoginDao {

    private HibernateTemplate hibernateTemplate = null;
    private JSONObject jsonObject = null;

    public JSONObject login(String userName,String passWord){
        jsonObject = new JSONObject();
        List<User> resultList = new ArrayList<User>();
        try {
            resultList = (List<User>) hibernateTemplate.find("from User where userName='"+userName+"'");
            if(resultList.size() <= 0){
                jsonObject.put("message", "用户名不存在");
                jsonObject.put("success",false);
            }else{
                User u = resultList.get(0);
                if(!u.getPassWord().equals(passWord)){
                    jsonObject.put("message", "密码不正确");
                    jsonObject.put("success",false);
                }else {
                    jsonObject.put("message", "登录成功");
                    jsonObject.put("success",true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("message", e.getMessage());
            jsonObject.put("success",false);
        }
        return jsonObject;
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
}
