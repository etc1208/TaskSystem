package com.taskSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yh on 2015/10/10.
 */
@Entity(name = "Area")
@Table(name = "t_area")
public class Area {
    private int id;
    private String polygon;
    private String taskId;
    private String createTime;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
