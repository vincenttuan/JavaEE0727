package com.web.ee.jdbc.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToBean {

    /**
     * 根據一個 ResultSet 結果集(當前行)生一個成相應的數據實體
     *
     * @param resultSet 結果集
     * @param objectClass 數據實體類型,一個 JavaBean 如: Book
     * @param <T>
     * @return 封裝好的 Bean 物件
     * @throws SQLException
     */
    public static <T> Object copy(ResultSet resultSet, Class<T> objectClass) {
        // 通過反射創建 objectClass 物件
        Object obj = null;
        try {
            obj = objectClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //objectClass 中所有屬性
        Field[] fields = getAllFieldName(objectClass);
        try {
            for (Field f : fields) {
                //取出屬性名稱
                System.out.println("屬性名稱: " + f);
                String fieldName = f.toString().substring(f.toString().lastIndexOf(".") + 1);
                //判斷類型
                if (f.toString().indexOf("int") != -1) {
                    invokeSet(obj, fieldName, resultSet.getInt(fieldName));
                } else if (f.toString().indexOf("Timestamp") != -1) {
                    invokeSet(obj, fieldName, resultSet.getTimestamp(fieldName));
                } else if (f.toString().indexOf("double") != -1) {
                    invokeSet(obj, fieldName, resultSet.getDouble(fieldName));
                } else if (f.toString().indexOf("float") != -1) {
                    invokeSet(obj, fieldName, resultSet.getFloat(fieldName));
                } else if (f.toString().indexOf("boolean") != -1) {
                    invokeSet(obj, fieldName, resultSet.getBoolean(fieldName));
                } else {
                    invokeSet(obj, fieldName, resultSet.getString(fieldName));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 根據屬姓名獲取get方法
     *
     * @param objectClass
     * @param fieldName 属性名
     * @return
     */
    @SuppressWarnings("unchecked")
    private static Method getSetMethod(Class objectClass, String fieldName) {
        try {
            Class[] parameterTypes = new Class[1];
            Field field = objectClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            StringBuffer sb = new StringBuffer();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            Method method = objectClass.getMethod(sb.toString(), parameterTypes);
            return method;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 獲取所有屬性
     *
     * @param objectClass
     * @return Field[]
     */
    private static Field[] getAllFieldName(Class objectClass) {
        Field[] fields = objectClass.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
        }
        return fields;
    }

    /**
     * 根據屬性名執行相對應得set方法
     *
     * @param o 執行對象
     * @param fieldName 屬性名
     * @param value 屬性值
     */
    private static void invokeSet(Object o, String fieldName, Object value) {
        Method method = getSetMethod(o.getClass(), fieldName);
        try {
            method.invoke(o, new Object[]{value});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
