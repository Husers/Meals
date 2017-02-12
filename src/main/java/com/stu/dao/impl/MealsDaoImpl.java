package com.stu.dao.impl;


import com.stu.dao.BaseDao;
import com.stu.dao.MealsDao;
import com.stu.model.Meals;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by huser
 * On 17/2/12.
 * 修改后的Dao层只做数据的读取和写入，涉及计算部分应放在Service层
 */
@Repository
public class MealsDaoImpl extends BaseDao implements MealsDao {
    @Override
    public String selectMealsByOwner(String owner) {
        Properties properties = new Properties();
        FileReader reader = null;
        String balance = null;
        try {
            reader = new FileReader(getPath());
            properties.load(reader);
            balance = properties.getProperty(owner);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return balance;
    }

    @Override
    public void updateMealsByOwner(Meals meals) {
        Properties properties = new Properties();
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(getPath());
            properties.load(reader);
            properties.setProperty(meals.getOwner(), meals.getBalance());
            //必须在properties修改完参数之后再读取输入流，否则写入的还是原来的内容
            writer = new FileWriter(getPath());
            properties.store(writer, meals.getOwner() + " Update properties");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean selectOwner(String owner) {
        Properties properties = new Properties();
        FileReader reader = null;
        boolean result = false;
        try {
            reader = new FileReader(getPath());
            properties.load(reader);
            result = properties.containsKey(owner);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
