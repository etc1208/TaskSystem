package com.taskSystem.controller;

import com.taskSystem.service.StaffService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yh on 2015/10/10.
 */
@Controller
public class StaffController {

    private JSONObject jsonObject = null;
    private JSONArray jsonArray = null;
    private StaffService staffService;

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public String staff(){
        return "staff";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, params = "json")
    public JSONObject getAllUser(){
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();
        try {
            jsonArray = staffService.getAllUser();
            if(jsonArray != null && jsonArray.size() > 0) {
                jsonObject.put("data",jsonArray);
                jsonObject.put("success",true);
            }else {
                jsonObject.put("message","无数据");
                jsonObject.put("success",false);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("message",e.getMessage());
            jsonObject.put("success", false);
        }
        return jsonObject;
    }

    public StaffService getStaffService() {
        return staffService;
    }
    @Resource(name = "staffService")
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
}
