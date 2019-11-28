package com.zxy.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public class AccoutUser extends Account {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "             AccoutUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
