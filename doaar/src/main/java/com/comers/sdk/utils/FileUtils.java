package com.comers.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.comers.sdk.bean.EventBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by YJ on 2015/11/28.
 */
public class FileUtils {

    public static boolean isFileExist(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }

        if (filePath.trim().length() == 0) {
            return false;
        }

        File file = new File(filePath);
        return (file.exists() && file.isFile());
    }

    public static String sdPath() {
        String rootpath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            rootpath = Environment.getExternalStorageDirectory().toString();
        }
        String parentPath = rootpath + File.separator + "Donews";
        File file = new File(parentPath);
        if (!file.exists()) {
            file.mkdirs(); // 新建一个子目录
        }
        return parentPath;
    }

    private static String getFolderName(String filePath) {

        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }

        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? "" : filePath.substring(0, filePosi);
    }

    private static boolean makeDirs(String filePath) {
        String folderName = getFolderName(filePath);
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }

        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }

    private static boolean writeFile(Context context,String filePath, String content, boolean append) {
        if (TextUtils.isEmpty(content)) {
            return false;
        }
//        PermissionUtils checker=new PermissionUtils(context);
//        if(checker.lacksPermissions(PermissionUtils.PERMISSIONS_FILE)){
        if(!PermissionUtils.checkPermission(context,PermissionUtils.PERMISSIONS_FILE)){
            return false;
        }else {
            FileWriter fileWriter = null;
            try {
                makeDirs(filePath);
                fileWriter = new FileWriter(filePath, append);
                fileWriter.write(content);
                fileWriter.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException("IOException occurred. ", e);
                    }
                }
            }
        }
    }
    /**
     * 在SD卡上创建文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File createSDFile(String fileName) throws IOException {
        File file = new File(FileUtils.sdPath() + File.separator+fileName);
        file.createNewFile();
        return file;
    }

    public static File write2SDFromInput(String fileName,InputStream input){
        File file = null;
        OutputStream output = null;

        try {
            file =createSDFile(fileName);
            output = new FileOutputStream(file);
            byte [] buffer = new byte[4 * 1024];
            while(input.read(buffer) != -1){
                output.write(buffer);
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(output!=null)
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    public static StringBuilder readFile(Context context,String filePath, String charsetName) {
        File file = new File(filePath);
        StringBuilder fileContent = new StringBuilder("");
        if (file == null || !file.isFile()) {
            return null;
        }
//        PermissionUtils checker=new PermissionUtils(context);
//        if(checker.lacksPermissions(PermissionUtils.PERMISSIONS_FILE)){
        if(!PermissionUtils.checkPermission(context,PermissionUtils.PERMISSIONS_FILE)){
            return null;
        }else {
            BufferedReader reader = null;
            try {
                InputStreamReader is = new InputStreamReader(new FileInputStream(file), charsetName);
                reader = new BufferedReader(is);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (!fileContent.toString().equals("")) {
                        fileContent.append("\r\n");
                    }
                    fileContent.append(line);
                }
                reader.close();
                return fileContent;
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new RuntimeException("IOException occurred. ", e);
                    }
                }
            }
        }
    }

    public static void saveAppRunFile(Context c,EventBean as) {
        String jsonStr = "{\"appkey\":\"" + as.getAppkey() + "\",\"appversion\":\"" +
                as.getAppversion() + "\",\"channel\":\"" + as.getChannel() + "\",\"osversion\":\"" +
                as.getOsversion() + "\",\"lang\":\"" + as.getLang() + "\",\"ip\":\"" + as.getIp() +
                "\",\"mac\":\"" + as.getMac() +"\",\"display\":\""+as.getDisplay()+"\",\"suuid\":\""+
                as.getSuuid()+"\",\"network\":\""+as.getNetwork()+"\",\"device_type\":\""+
                as.getDeviceType()+"\",\"os_type\":\""+as.getOsType()+"\",\"event\":\""+as.getEvent()
                +"\",\"register_days\":"+as.getRegister_days()+",\"use_interval\":"+as.getUse_interval()+
                ",\"device_id\":\""+as.getDevice_id()+"\",\"account\":\""+as.getAccount()+"\""+
                ",\"nettype\":\""+as.getNettype()+"\",\"timestamp\":\""+as.getTimestamp()+"\"}";
//
        String path = sdPath() + File.separator + "apprun.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr, true);
            if (flag){
                SPUtils.put(c,SPUtils.TAB_APPRUN,true);
            }
        } catch (Exception e) {
        }
    }

    public static List<EventBean> readAppRunFile(Context c) {
        String path = sdPath() + File.separator + "apprun.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps = null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getAppRunList("[" + sb.toString() + "]");
        }
        return apps;
    }

    private static List<EventBean> getAppRunList(String jsonString) {
        List<EventBean> list = null;
        try {
            JSONArray ja = JSONParser.getJSONArray(jsonString);
            list = new ArrayList<EventBean>();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jsonObject = ja.getJSONObject(i);
                EventBean appLaunchEntity = new EventBean();
                appLaunchEntity.setAppkey(jsonObject.optString("appkey"));

                appLaunchEntity.setOsversion(jsonObject.optString("osversion"));
                appLaunchEntity.setAppversion(jsonObject.optString("appversion"));
                appLaunchEntity.setChannel(jsonObject.optString("channel"));
//                appLaunchEntity.setEndtime(jsonObject.optString("endtime"));
//
//                appLaunchEntity.setStarttime(jsonObject.optString("starttime"));
                appLaunchEntity.setTimestamp(jsonObject.optString("timestamp"));
                appLaunchEntity.setLang(jsonObject.optString("lang"));
                appLaunchEntity.setDisplay(jsonObject.optString("display"));
                appLaunchEntity.setSuuid(jsonObject.optString("suuid"));
                appLaunchEntity.setNetwork(jsonObject.optString("network"));
                appLaunchEntity.setDeviceType(jsonObject.optString("device_type"));
                appLaunchEntity.setOsType(jsonObject.optString("os_type"));

                appLaunchEntity.setEvent(jsonObject.optString("event"));
                appLaunchEntity.setIp(jsonObject.optString("ip"));
                appLaunchEntity.setMac(jsonObject.optString("mac"));
                appLaunchEntity.setRegister_days(jsonObject.optInt("register_days"));
                appLaunchEntity.setUse_interval(jsonObject.optLong("use_interval"));
                appLaunchEntity.setNettype(jsonObject.optString("nettype"));
                appLaunchEntity.setDevice_id(jsonObject.optString("device_id"));
                appLaunchEntity.setAccount(jsonObject.optString("account"));
                list.add(appLaunchEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
}
    //------------------------------------------
    public static void saveShutdownFile(Context c,EventBean as) {
        String jsonStr = "{\"appkey\":\"" + as.getAppkey() + "\",\"appversion\":\"" +
                as.getAppversion() + "\",\"channel\":\"" + as.getChannel() + "\",\"osversion\":\"" +
                as.getOsversion() + "\",\"lang\":\"" + as.getLang() + "\",\"ip\":\"" + as.getIp() +
                "\",\"mac\":\"" + as.getMac() +"\",\"display\":\""+as.getDisplay()+"\",\"suuid\":\""+
                as.getSuuid()+"\",\"network\":\""+as.getNetwork()+"\",\"device_type\":\""+
                as.getDeviceType()+"\",\"os_type\":\""+as.getOsType()+"\",\"event\":\""+as.getEvent()+
                "\",\"device_id\":\""+as.getDevice_id()+"\",\"account\":\""+as.getAccount()
                +"\",\"register_days\":"+as.getRegister_days()+",\"use_duration\":"+as.getUse_duration()+
                ",\"nettype\":\""+as.getNettype()+"\",\"timestamp\":\""+as.getTimestamp()+"\"}";
//
        String path = sdPath() + File.separator + "shutdown.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c, path, jsonStr, true);
            if (flag){
                SPUtils.put(c,SPUtils.TAB_SHUNDOWN, true);
            }
        } catch (Exception e) {
        }
    }

    public static List<EventBean> readShutdownFile(Context c) {
        String path = sdPath() + File.separator + "shutdown.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps = null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getShutdownList("[" + sb.toString() + "]");
        }
        return apps;
    }

    private static List<EventBean> getShutdownList(String jsonString) {
        List<EventBean> list = null;
        try {
            JSONArray ja = JSONParser.getJSONArray(jsonString);
            list = new ArrayList<EventBean>();
            int length=ja.length();
            for (int i = 0; i < length; i++) {
                JSONObject jsonObject = ja.getJSONObject(i);
                EventBean appLaunchEntity = new EventBean();
                appLaunchEntity.setAppkey(jsonObject.optString("appkey"));

                appLaunchEntity.setOsversion(jsonObject.optString("osversion"));
                appLaunchEntity.setAppversion(jsonObject.optString("appversion"));
                appLaunchEntity.setChannel(jsonObject.optString("channel"));
                appLaunchEntity.setTimestamp(jsonObject.optString("timestamp"));
//                appLaunchEntity.setEndtime(jsonObject.optString("endtime"));
//
//                appLaunchEntity.setStarttime(jsonObject.optString("starttime"));
                appLaunchEntity.setLang(jsonObject.optString("lang"));
                appLaunchEntity.setDisplay(jsonObject.optString("display"));
                appLaunchEntity.setSuuid(jsonObject.optString("suuid"));
                appLaunchEntity.setNetwork(jsonObject.optString("network"));
                appLaunchEntity.setDeviceType(jsonObject.optString("device_type"));
                appLaunchEntity.setOsType(jsonObject.optString("os_type"));

                appLaunchEntity.setEvent(jsonObject.optString("event"));
                appLaunchEntity.setIp(jsonObject.optString("ip"));
                appLaunchEntity.setMac(jsonObject.optString("mac"));
                appLaunchEntity.setRegister_days(jsonObject.optInt("register_days"));
                appLaunchEntity.setUse_interval(jsonObject.optLong("use_duration"));
                appLaunchEntity.setNettype(jsonObject.optString("nettype"));
                appLaunchEntity.setDevice_id(jsonObject.optString("device_id"));
                appLaunchEntity.setAccount(jsonObject.optString("account"));
                list.add(appLaunchEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }
    //---------------------------------------------------------------------------------------------
    //*******************************************************************************************
public static void savePageFile(Context c,EventBean as) {
    String jsonStr="{\"appkey\":\""+as.getAppkey()+"\",\"appversion\":\""+
            as.getAppversion()+"\",\"channel\":\""+as.getChannel()+"\",\"osversion\":\""+
            as.getOsversion()+"\",\"lang\":\""+as.getLang()+"\",\"timestamp\":\""+as.getTimestamp()+
            "\",\"pagenum\":"+as.getPagenum()+",\"lastpage\":\""+as.getLastpage()+"\",\"display\":\"" +
            as.getDisplay()+"\",\"device_type\":\""+as.getDeviceType()+"\",\"os_type\":\""+as.getOsType()+
            "\",\"device_id\":\""+as.getDevice_id()+"\",\"account\":\""+as.getAccount()
            +"\",\"network\":\""+as.getNetwork()+"\",\"event\":\""+as.getEvent()+"\",\"ip\":\""+as.getIp()
            +"\",\"mac\":\""+as .getMac()+"\",\"suuid\":\""+as.getSuuid()+"\",\"register_days\":"+as.getRegister_days()+
            ",\"nettype\":\""+as.getNettype()+"\"}";
    String path = sdPath() + File.separator + "pageaccess.dn";
    if (isFileExist(path)) {
        jsonStr = "," + jsonStr;
    }
    try {
        boolean flag=writeFile(c, path, jsonStr, true);
        if (flag){
            SPUtils.put(c,SPUtils.TAB_PAGEACCESS,true);
        }
    } catch (Exception e) {
    }
}
    public  static List<EventBean> readPageFile(Context c){
        String path = sdPath() + File.separator+"pageaccess.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getPageList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getPageList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            int length=jsonArray.length();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean page=new EventBean();
                page.setAppkey(jsonObject.optString("appkey"));
                page.setOsversion(jsonObject.optString("osversion"));
                page.setAppversion(jsonObject.optString("appversion"));
                page.setChannel(jsonObject.optString("channel"));
                page.setLastpage(jsonObject.optString("lastpage"));
                page.setPagename(jsonObject.optString("pagename"));
                page.setPagenum(jsonObject.optInt("pagenum"));
                page.setTimestamp(jsonObject.optString("timestamp"));
                page.setLang(jsonObject.optString("lang"));
                page.setOsType(jsonObject.optString("os_type"));
                page.setDisplay(jsonObject.optString("display"));
                page.setDeviceType(jsonObject.optString("device_type"));
                page.setNetwork(jsonObject.optString("network"));
                page.setSuuid(jsonObject.optString("suuid"));
                page.setIp(jsonObject.optString("ip"));
                page.setMac(jsonObject.optString("mac"));
                page.setEvent(jsonObject.optString("event"));
                page.setRegister_days(jsonObject.optInt("register_days"));
                page.setNettype(jsonObject.optString("nettype"));
                page.setAccount(jsonObject.optString("account"));
                page.setDevice_id(jsonObject.optString("device_id"));
                list.add(page);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    //-----------------------------------------------------------------------------------
    //***************************************************************************************
    public static void saveEventFile(Context c,EventBean as) {
        String jsonStr="{\"appkey\":\""+as.getAppkey()+"\",\"appversion\":\""+
                as.getAppversion()+"\",\"channel\":\""+as.getChannel()+"\",\"osversion\":\""+
                as.getOsversion()+"\",\"lang\":\""+as.getLang()+"\",\"timestamp\":\""+as.getTimestamp()+
                "\",\"event_name\":\""+as.getEventname()+"\",\"event\":\""+as.getEvent()+"\",\"display\":\""+as.getDisplay()+"\",\"suuid\":\""
                +as.getSuuid()+"\",\"network\":\""+as.getNetwork()+"\",\"device_type\":\""
                +as.getDeviceType()+"\",\"os_type\":\""+as.getOsType()+"\",\"ip\":\""+as.getIp()+
                "\",\"device_id\":\""+as.getDevice_id()+"\",\"account\":\""+as.getAccount()
                +"\",\"mac\":\""+as.getMac()+"\",\"register_days\":"+as.getRegister_days()
                +",\"nettype\":\""+as.getNettype()+"\"}";
        String path = sdPath() + File.separator + "events.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_EVENTS,true);
            }
        } catch (Exception e) {
        }
    }
    public  static List<EventBean> readEventFile(Context c){
        String path = sdPath() + File.separator+"events.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getEventList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getEventList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setEventname(jsonObject.optString("event_name"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    //-----------------------------------------------------------------------------------
    //***************************************************************************************
    public static void saveRechargeFile(Context c,EventBean recharge) {
        String jsonStr="{\"appkey\":\""+recharge.getAppkey()+"\",\"appversion\":\""+
                recharge.getAppversion()+"\",\"channel\":\""+recharge.getChannel()+"\",\"osversion\":\""+
                recharge.getOsversion()+"\",\"lang\":\""+recharge.getLang()+"\",\"timestamp\":\""+recharge.getTimestamp()+
                "\",\"payment_method\":\""+recharge.getPayment_method()+"\",\"event\":\""+recharge.getEvent()+"\",\"display\":\""+recharge.getDisplay()+"\",\"suuid\":\""
                +recharge.getSuuid()+"\",\"network\":\""+recharge.getNetwork()+"\",\"device_type\":\""
                +recharge.getDeviceType()+"\",\"os_type\":\""+recharge.getOsType()+"\",\"ip\":\""+recharge.getIp()
                +"\",\"device_id\":\""+recharge.getDevice_id()+"\",\"account\":\""+recharge.getAccount()
                +"\",\"mac\":\""+recharge.getMac()+"\",\"register_days\":"+recharge.getRegister_days()
                +",\"nettype\":\""+recharge.getNettype()+"\",\"money\":"+recharge.getMoney()+"}";
        String path = sdPath() + File.separator + "recharge.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_RECHARGE, true);
            }
        } catch (Exception e) {
        }
    }
    public  static List<EventBean> readRechargeFile(Context c){
        String path = sdPath() + File.separator+"recharge.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getRechargeList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getRechargeList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setPayment_method(jsonObject.optString("payment_method"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setMoney(jsonObject.optInt("money"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    //---------------------------------------------------------
    //************************************************************
    public static void saveConsumFile(Context c,EventBean recharge) {
        String jsonStr="{\"appkey\":\""+recharge.getAppkey()+"\",\"appversion\":\""+
                recharge.getAppversion()+"\",\"channel\":\""+recharge.getChannel()+"\",\"osversion\":\""+
                recharge.getOsversion()+"\",\"lang\":\""+recharge.getLang()+"\",\"timestamp\":\""+recharge.getTimestamp()+
                "\",\"consumption_point\":\""+recharge.getConsumption_point()+"\",\"event\":\""+recharge.getEvent()+"\",\"display\":\""+recharge.getDisplay()+"\",\"suuid\":\""
                +recharge.getSuuid()+"\",\"network\":\""+recharge.getNetwork()+"\",\"device_type\":\""
                +recharge.getDeviceType()+"\",\"os_type\":\""+recharge.getOsType()+"\",\"ip\":\""+recharge.getIp()
                +"\",\"device_id\":\""+recharge.getDevice_id()+"\",\"account\":\""+recharge.getAccount()
                +"\",\"mac\":\""+recharge.getMac()+"\",\"register_days\":"+recharge.getRegister_days()
                +",\"nettype\":\""+recharge.getNettype()+"\",\"money\":"+recharge.getMoney()+"}";
        String path = sdPath() + File.separator + "consumption.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_CONSUMPTION, true);
            }
        } catch (Exception e) {
        }
    }
    public  static List<EventBean> readConsumFile(Context c){
        String path = sdPath() + File.separator+"consumption.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getConsumList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getConsumList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setConsumption_point(jsonObject.optString("consumption_point"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setMoney(jsonObject.optInt("money"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    //---------------------------------------------------------
    //************************************************************
    public static void saveErrorFile(Context c,EventBean errorEntity) {
        String jsonStr="{\"appkey\":\""+errorEntity.getAppkey()+"\",\"appversion\":\""+
                errorEntity.getAppversion()+"\",\"channel\":\""+errorEntity.getChannel()+"\",\"osversion\":\""+
                errorEntity.getOsversion()+"\",\"lang\":\""+errorEntity.getLang()+"\",\"timestamp\":\""+errorEntity.getTimestamp()+
                "\",\"error_type\":\""+errorEntity.getError_type()+"\",\"event\":\""+errorEntity.getEvent()+"\",\"display\":\""+errorEntity.getDisplay()+"\",\"suuid\":\""
                +errorEntity.getSuuid()+"\",\"network\":\""+errorEntity.getNetwork()+"\",\"device_type\":\""
                +errorEntity.getDeviceType()+"\",\"os_type\":\""+errorEntity.getOsType()+"\",\"ip\":\""+errorEntity.getIp()
                +"\",\"device_id\":\""+errorEntity.getDevice_id()+"\",\"account\":\""+errorEntity.getAccount()
                +"\",\"mac\":\""+errorEntity.getMac()+"\",\"register_days\":"+errorEntity.getRegister_days()
                +",\"nettype\":\""+errorEntity.getNettype()+"\""+"}";
        String path = sdPath() + File.separator + "error.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_ERROR, true);
            }
        } catch (Exception e) {
        }
    }
    public  static List<EventBean> readErrorFile(Context c){
        String path = sdPath() + File.separator+"error.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getErrorList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getErrorList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setError_type(jsonObject.optString("error_type"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    //-------------------------------------------------------------
    //读取游戏账号升级本地数据
    public  static List<EventBean> readRoleUpgradeFile(Context c){
        String path = sdPath() + File.separator+"roleupgrade.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getRoleUpgradeList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getRoleUpgradeList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setAccount_level(jsonObject.optString("account_level"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public static void saveRoleUpgradeFile(Context c,EventBean errorEntity) {
        String jsonStr="{\"appkey\":\""+errorEntity.getAppkey()+"\",\"appversion\":\""+
                errorEntity.getAppversion()+"\",\"channel\":\""+errorEntity.getChannel()+"\",\"osversion\":\""+
                errorEntity.getOsversion()+"\",\"lang\":\""+errorEntity.getLang()+"\",\"timestamp\":\""+errorEntity.getTimestamp()+
                "\",\"account_level\":\""+errorEntity.getAccount_level()+"\",\"event\":\""+errorEntity.getEvent()+"\",\"display\":\""+errorEntity.getDisplay()+"\",\"suuid\":\""
                +errorEntity.getSuuid()+"\",\"network\":\""+errorEntity.getNetwork()+"\",\"device_type\":\""
                +errorEntity.getDeviceType()+"\",\"os_type\":\""+errorEntity.getOsType()+"\",\"ip\":\""+errorEntity.getIp()
                +"\",\"device_id\":\""+errorEntity.getDevice_id()+"\",\"account\":\""+errorEntity.getAccount()
                +"\",\"mac\":\""+errorEntity.getMac()+"\",\"register_days\":"+errorEntity.getRegister_days()
                +",\"nettype\":\""+errorEntity.getNettype()+"\""+"}";
        String path = sdPath() + File.separator + "roleupgrade.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_ROLEUPGRADE, true);
            }
        } catch (Exception e) {
        }
    }
    //-------------------------------------------------------------
    //读取任务消费本地数据
    public  static List<EventBean> readCompleteConsumptionFile(Context c){
        String path = sdPath() + File.separator+"completeconsumption.dn";
        StringBuilder sb = FileUtils.readFile(c,path, "UTF-8");
        List<EventBean> apps=null;
        if (sb != null) {// 文件里面有没有上传的数据
            apps=getCompleteConsumptionList("[" + sb.toString() + "]");
        }
        return  apps;
    }
    private static List<EventBean> getCompleteConsumptionList(String jsonString)
    {
        List<EventBean> list = null;
        try
        {
            JSONArray jsonArray = new JSONArray(jsonString);
            int length=jsonArray.length();
            JSONObject jsonObject;
            list = new ArrayList<EventBean>();
            for (int i = 0; i < length; i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                EventBean event=new EventBean();
                event.setAppkey(jsonObject.optString("appkey"));
                event.setOsversion(jsonObject.optString("osversion"));
                event.setAppversion(jsonObject.optString("appversion"));
                event.setChannel(jsonObject.optString("channel"));
                event.setTimestamp(jsonObject.optString("timestamp"));
                event.setLang(jsonObject.optString("lang"));
                event.setDisplay(jsonObject.optString("display"));
                event.setNetwork(jsonObject.optString("network"));
                event.setDeviceType(jsonObject.optString("device_type"));
                event.setOsType(jsonObject.optString("os_type"));
                event.setSuuid(jsonObject.optString("suuid"));
                event.setIp(jsonObject.optString("ip"));
                event.setMac(jsonObject.optString("mac"));
                event.setRegister_days(jsonObject.optInt("register_days"));
                event.setEvent(jsonObject.optString("event"));
                event.setNettype(jsonObject.optString("nettype"));
                event.setPayment_method(jsonObject.optString("payment_method"));
                event.setConsumption_point(jsonObject.optString("consumption_point"));
                event.setMoney(jsonObject.optInt("money"));
                event.setEventname(jsonObject.optString("event_name"));
                event.setDevice_id(jsonObject.optString("device_id"));
                event.setAccount(jsonObject.optString("account"));
                list.add(event);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public static void saveCompleteConsumptionFile(Context c,EventBean errorEntity) {
        String jsonStr="{\"appkey\":\""+errorEntity.getAppkey()+"\",\"appversion\":\""+
                errorEntity.getAppversion()+"\",\"channel\":\""+errorEntity.getChannel()+"\",\"osversion\":\""+
                errorEntity.getOsversion()+"\",\"lang\":\""+errorEntity.getLang()+"\",\"timestamp\":\""+errorEntity.getTimestamp()+
                "\",\"payment_method\":\""+errorEntity.getPayment_method()+"\",\"event\":\""+errorEntity.getEvent()+"\",\"display\":\""+errorEntity.getDisplay()+"\",\"suuid\":\""
                +errorEntity.getSuuid()+"\",\"network\":\""+errorEntity.getNetwork()+"\",\"device_type\":\""
                +errorEntity.getDeviceType()+"\",\"os_type\":\""+errorEntity.getOsType()+"\",\"ip\":\""+errorEntity.getIp()
                +"\",\"device_id\":\""+errorEntity.getDevice_id()+"\",\"account\":\""+errorEntity.getAccount()
                +"\",\"mac\":\""+errorEntity.getMac()+"\",\"register_days\":"+errorEntity.getRegister_days()
                +",\"nettype\":\""+errorEntity.getNettype()+"\",\"money\":"+errorEntity.getMoney()
                +",\"consumption_point\":\""+errorEntity.getConsumption_point()+"\",\"event_name\":\""+errorEntity.getEventname()+"\""+"}";
        String path = sdPath() + File.separator + "completeconsumption.dn";
        if (isFileExist(path)) {
            jsonStr = "," + jsonStr;
        }
        try {
            boolean flag=writeFile(c,path, jsonStr,true);
            if(flag){
                SPUtils.put(c,SPUtils.TAB_CONSUMPTION_COMPLETE, true);
            }
        } catch (Exception e) {
        }
    }
    //------------------------------------------------------------------------------------------
    //******************************************************************************************

    public static void delFile(String fileName) {
        File file = new File(sdPath()+File.separator+fileName);
        if (file.isFile()) {
            file.delete();
            return;
        }
    }
    //------------------
    public static String getCurTime(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateStr=dateFormat.format(date);
        String[] dates=dateStr.split(" ");
        dateStr=dates[0]+"T"+dates[1]+"Z";
        return  dateStr;
    }
}
