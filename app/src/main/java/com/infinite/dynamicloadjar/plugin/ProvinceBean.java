//package com.infinite.dynamicloadjar.plugin;
//
//import org.json.JSONObject;
//
///**
// * Email: 690797861@qq.com
// * Author: Infinite
// * Date: 2020/6/5 - 17:51
// * Description: Class description
// */
//public class ProvinceBean {
//    private String name;
//    private int code;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//
//    @Override
//    public String toString() {
//        return "ProvinceBean{" +
//                "name='" + name + '\'' +
//                ", code=" + code +
//                '}';
//    }
//
//    public static ProvinceBean parseToObject(JSONObject object) {
//        if (object != null) {
//            ProvinceBean bean = new ProvinceBean();
//            bean.setName(object.optString("name"));
//            bean.setCode(object.optInt("code"));
//            return bean;
//        }
//        return null;
//    }
//}
