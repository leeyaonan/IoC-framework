package com.leeyaonan.factory;

import com.leeyaonan.utils.ConnectionUtils;

/**
 * @Author leeyaonan
 * @Date 2020/4/13 21:40
 */
public class CreateBeanFactory {

    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }

    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}
