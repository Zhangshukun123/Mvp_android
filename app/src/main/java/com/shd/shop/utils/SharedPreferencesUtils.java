package com.shd.shop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.util.Map;

/**
 * SharedPreferences工具类
 * Created by 陈自强 on 2017/8/14 0014.
 */

public class SharedPreferencesUtils {
    private static SharedPreferencesUtils instance;
    private static SharedPreferences sp ;
    private static SharedPreferences.Editor editor ;

    public static SharedPreferencesUtils getInstance(Context context, String fileName) {
        if (instance == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (instance == null)
                    instance = new SharedPreferencesUtils();
            }
        }
        initSP(context,fileName);
        return instance;
    }

    /**
     * 初始化
     * @param context
     * @param fileName
     */
    private static void initSP(Context context, String fileName){
        if (context == null) {
            return;
        }
        String FILE_NAME ;
        if (TextUtils.isEmpty(fileName)) {
            FILE_NAME = "share_data";
        }else {
            FILE_NAME = fileName;
        }
        sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param key
     * @param object
     */
    public  void put(String key, Object object) {
        Log.d("dfgfgfdgfasddsad","put------>"+key+"     "+editor.hashCode());
        if (object instanceof String) {
            Log.d("dfgfgfdgfasddsad","String------>"+(String) object);
            editor.putString(key, (String) object).commit();
        } else if (object instanceof Integer) {
            Log.d("dfgfgfdgfasddsad","Integer------>"+(Integer) object);
            editor.putInt(key, (Integer) object).commit();
        } else if (object instanceof Boolean) {
            Log.d("dfgfgfdgfasddsad","Boolean------>"+(Boolean) object);
            editor.putBoolean(key, (Boolean) object).commit();
        } else if (object instanceof Float) {
            Log.d("dfgfgfdgfasddsad","Float------>"+(Float) object);
            editor.putFloat(key, (Float) object).commit();
        } else if (object instanceof Long) {
            Log.d("dfgfgfdgfasddsad","Long------>"+(Long) object);
            editor.putLong(key, (Long) object).commit();
        } else {
            Log.d("dfgfgfdgfasddsad","eeeeeeeeeeeee------>"+object.toString());
            editor.putString(key, object.toString()).commit();
        }
//        apply(editor);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param key
     * @param defaultObject
     * @return
     */
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    public String getString(String key) {
        return (String) get(key, "");
    }

    public int getInt(String key) {
        return (Integer) get(key, 0);
    }

    public boolean getBoolean(String key) {
        return (Boolean) get(key, false);
    }

    public float getFloat(String key) {
        return (Float) get(key, 0f);
    }

    public long getLong(String key) {
        return (Long) get(key, 0L);
    }

    /**
     * 移除某个key值已经对应的值
     * @param key
     */
    public  void removeValue(String key) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        apply(editor);
    }

    /**
     * 清除所有数据
     *
     */
    public  void clearAll() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key
     * @return
     */
    public  boolean containsKey( String key) {
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @return
     */
    public Map<String, ?> getAll() {
        return sp.getAll();
    }


    /**
     * 如果找到则使用apply执行，否则使用commit
     *
     * @param editor
     */
    private  void apply(SharedPreferences.Editor editor) {
        boolean a = editor.commit();
        Log.d("dfgfgfdgfasddsad","apply111111------>"+a);
    }
}
