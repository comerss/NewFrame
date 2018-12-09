package com.comers.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SPUtils  
{  
	/** 
	 * 保存在手机里面的文件�?
	 */  
	public static final String FILE_NAME = "share_data";
	public static final String REGIST_TIME="regist_time";//注册时间
	public static final String STARTUP_TIME="startup_time";//开启时间
	public static final String SHUTDOWN_TIME="shutdown_time";//关闭时间
	public static final String SHUTDOWN_TIME_TEMP="shutdown_time_temp";//关闭时间
	//屏幕宽高
	public static final String PHONE_WIDTH="phone_width";
	public static final String PHONE_HEIGHT="phone_height";
	//手机型号
	public static final String PHONE_MODEL="phone_model";

	//app版本
	public static final String APP_VERSION="app_version";
	public static final String OS_VERSION="os_version";
	public static final String UUID="uuid";

	//文件中是否有数据
	public static final String TAB_APPRUN="tab_apprun";
	public static final String TAB_SHUNDOWN="tab_shutdown";
	public static final String TAB_PAGEACCESS="tab_pageaccess";
	public static final String TAB_EVENTS="tab_events";

	public static final String TAB_RECHARGE="tab_recharge";
	public static final String TAB_CONSUMPTION="tab_consumption";

	public static final String TAB_ERROR="tab_error";

	public static final String TAB_ROLEUPGRADE="tab_roleupgrade";

	public static final String TAB_CONSUMPTION_COMPLETE="tab_consumption_complete";

	public static final String NET_STATE="net_state";
	public static final String CUR_IP="cur_ip";
	public static final String NET_NAME="net_name";
	/**
	 * 保存数据的方法，我们�?��拿到保存数据的具体类型，然后根据类型调用不同的保存方�?
	 *  
	 * @param context 
	 * @param key 
	 * @param object 
	 */  
	public static void put(Context context, String key, Object object){
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);  
		SharedPreferences.Editor editor = sp.edit();  
		if (object instanceof String){
			editor.putString(key, (String) object);  
		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);  
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);  
		} else if (object instanceof Float)  {
			editor.putFloat(key, (Float) object);  
		} else if (object instanceof Long){
			editor.putLong(key, (Long) object);  
		} else {
			editor.putString(key, object.toString());  
		}  
		SharedPreferencesCompat.apply(editor);
	}  

	/** 
	 * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取�?
	 *  
	 * @param context 
	 * @param key 
	 * @param defaultObject 
	 * @return 
	 */  
	public static Object get(Context context, String key, Object defaultObject){
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,  
				Context.MODE_PRIVATE);  

		if (defaultObject instanceof String){
			return sp.getString(key, (String) defaultObject);  
		} else if (defaultObject instanceof Integer){
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

	/** 
	 * 移除某个key值已经对应的�?
	 * @param context 
	 * @param key 
	 */  
	public static void remove(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,  
				Context.MODE_PRIVATE);  
		SharedPreferences.Editor editor = sp.edit();  
		editor.remove(key);  
		SharedPreferencesCompat.apply(editor);  
	}  

	/** 
	 * 清除�?��数据 
	 * @param context 
	 */  
	public static void clear(Context context) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,  
				Context.MODE_PRIVATE);  
		SharedPreferences.Editor editor = sp.edit();  
		editor.clear();  
		SharedPreferencesCompat.apply(editor);  
	}  

	/** 
	 * 查询某个key是否已经存在 
	 * @param context 
	 * @param key 
	 * @return 
	 */  
	public static boolean contains(Context context, String key)  
	{  
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,  
				Context.MODE_PRIVATE);  
		return sp.contains(key);  
	}  

	/** 
	 * 返回�?��的键值对 
	 *  
	 * @param context 
	 * @return 
	 */  
	public static Map<String, ?> getAll(Context context)  
	{  
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,  
				Context.MODE_PRIVATE);  
		return sp.getAll();  
	}  

	/** 
	 * 创建�?��解决SharedPreferencesCompat.apply方法的一个兼容类 
	 *  
	 * @author zhy 
	 *  
	 */  
	private static class SharedPreferencesCompat  
	{  
		private static final Method sApplyMethod = findApplyMethod();  

		/** 
		 * 反射查找apply的方�?
		 *  
		 * @return 
		 */  
		@SuppressWarnings({ "unchecked", "rawtypes" })  
		private static Method findApplyMethod()  
		{  
			try  
			{  
				Class clz = SharedPreferences.Editor.class;  
				return clz.getMethod("apply");  
			} catch (NoSuchMethodException e)  
			{  
			}  

			return null;  
		}  

		/** 
		 * 如果找到则使用apply执行，否则使用commit 
		 *  
		 * @param editor 
		 */  
		public static void apply(SharedPreferences.Editor editor)  
		{  
			try  
			{  
				if (sApplyMethod != null)  
				{  
					sApplyMethod.invoke(editor);  
					return;  
				}  
			} catch (IllegalArgumentException e)  
			{  
			} catch (IllegalAccessException e)  
			{  
			} catch (InvocationTargetException e)  
			{  
			}  
			editor.commit();  
		}  
	}  

}  