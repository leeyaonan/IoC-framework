package com.leeyaonan.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author leeyaonan
 * @Date 2020/4/12 23:53
 * 工厂类，生产对象（使用反射技术）
 */
public class BeanFactory {

    /*
    * BeanFactory有两个任务
    *   1. 读取和解析beans.xml文件，通过反射技术实例化对象并且存储在map集合中待用
    *   2. 对外提供获取实例对象的接口（根据id获取）
    * */

    private static Map<String, Object> map = new HashMap<>();   // 存储对象

    static {
        // 静态代码块读取解析xml

        // 1. 加载xml配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        // 2. 解析xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            List<Element> beanList = rootElement.selectNodes("//beans");
            for (int i = 0; i < beanList.size(); i++) {
                Element element = beanList.get(i);
                // 处理每一个bean元素，获取到该元素的id和class属性
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                // 通过反射技术实例化对象
                Class<?> aClass = Class.forName(clazz);
                Object o = aClass.newInstance(); // Java9之后直接newInstance是过时的方法，推荐使用class.getDeclaredConstructor().newInstance()

                // 存储到map中待用
                map.put(id, o);
            }


        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
