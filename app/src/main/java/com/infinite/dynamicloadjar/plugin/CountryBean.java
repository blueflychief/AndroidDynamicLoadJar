//package com.infinite.dynamicloadjar.plugin;
//
///**
// * Email: 690797861@qq.com
// * Author: Infinite
// * Date: 2020/6/4 - 17:37
// * Description: Class description
// */
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.infinite.dynamicloadjar.bean.CountryWrap;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Email: 690797861@qq.com
// * Author: Infinite
// * Date: 2020/6/4 - 15:02
// * Description: Class description
// */
//public class CountryBean {
//
//    public CountryBean() {
//        Log.d("CountryBean", "CountryBean init");
//    }
//
//    public static CountryWrap parseBean(String json) {
//        Log.d("tag", "parseBean json is:" + json);
//        if (!TextUtils.isEmpty(json)) {
//            CountryBean countryBean = CountryBean.parseToObject(json);
//            Log.d("tag", "countryBean is\n" + countryBean);
//            if (countryBean != null) {
//                Log.d("tag", "parseBean countryBean is not null");
//                CountryWrap countryWrap = new CountryWrap();
//                countryWrap.setName(countryBean.getName());
//                if (countryBean.getProvinceBeanList() != null && countryBean.getProvinceBeanList().size() > 0) {
//                    Log.d("tag", "parseBean province size is " + countryBean.getProvinceBeanList().size());
//                    countryWrap.setProvince(new ArrayList<String>());
//                    for (ProvinceBean provinceBean : countryBean.getProvinceBeanList()) {
//                        if (provinceBean != null) {
//                            countryWrap.getProvince().add(provinceBean.getName() + ":" + provinceBean.getCode());
//                        }
//                    }
//                }
//                return countryWrap;
//            }
//        }
//        return null;
//    }
//
//    private String name;
//    private List<ProvinceBean> provinceBeanList;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<ProvinceBean> getProvinceBeanList() {
//        return provinceBeanList;
//    }
//
//    public void setProvinceBeanList(List<ProvinceBean> provinceBeanList) {
//        this.provinceBeanList = provinceBeanList;
//    }
//
//    @Override
//    public String toString() {
//        return "CountryBean{" +
//                "name='" + name + '\'' +
//                ", provinceBeanList=" + printList(provinceBeanList) +
//                '}';
//    }
//
//    private String printList(Collection collection) {
//        if (collection != null && collection.size() > 0) {
//            StringBuilder sb = new StringBuilder();
//            for (Object o : collection) {
//                if (o != null) {
//                    sb.append(o).append("\n");
//                }
//            }
//            return sb.toString();
//        }
//        return "null";
//    }
//
//    public static CountryBean parseToObject(String json) {
//        if (!TextUtils.isEmpty(json)) {
//            try {
//                JSONObject jsonObject = new JSONObject(json);
//                CountryBean countryBean = new CountryBean();
//                countryBean.setName(jsonObject.optString("name"));
//                JSONArray jsonArray = jsonObject.optJSONArray("provinceBeanList");
//                if (jsonArray != null) {
//                    countryBean.setProvinceBeanList(new ArrayList<ProvinceBean>());
//                    int len = jsonArray.length();
//                    if (len > 0) {
//                        for (int i = 0; i < len; i++) {
//                            countryBean.getProvinceBeanList()
//                                    .add(ProvinceBean.parseToObject(jsonArray.getJSONObject(i)));
//                        }
//                    }
//                }
//                return countryBean;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    public static class ProvinceBean {
//        private String name;
//        private int code;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getCode() {
//            return code;
//        }
//
//        public void setCode(int code) {
//            this.code = code;
//        }
//
//
//        @Override
//        public String toString() {
//            return "ProvinceBean{" +
//                    "name='" + name + '\'' +
//                    ", code=" + code +
//                    '}';
//        }
//
//        public static ProvinceBean parseToObject(JSONObject object) {
//            if (object != null) {
//                ProvinceBean bean = new ProvinceBean();
//                bean.setName(object.optString("name"));
//                bean.setCode(object.optInt("code"));
//                return bean;
//            }
//            return null;
//        }
//    }
//}
