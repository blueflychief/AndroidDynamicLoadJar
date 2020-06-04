package com.infinite.dynamicloadjar.bean;

import java.util.Collection;
import java.util.List;

/**
 * Email: 690797861@qq.com
 * Author: Infinite
 * Date: 2020/6/4 - 15:29
 * Description: Class description
 */
public class CountryWrap {
    private String name;
    private List<String> province;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProvince() {
        return province;
    }

    public void setProvince(List<String> province) {
        this.province = province;
    }

    private String printList(Collection collection) {
        if (collection != null && collection.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object o : collection) {
                if (o != null) {
                    sb.append(o).append("\n");
                }
            }
            return sb.toString();
        }
        return "null";
    }

    @Override
    public String toString() {
        return "CountryWrap{" +
                "name='" + name + '\'' +
                ", province=" + printList(province) +
                '}';
    }
}
