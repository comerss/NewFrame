package com.donews.sdk.utils;


import android.util.Log;

import com.donews.sdk.base.JsonParseHelper;
import com.donews.sdk.base.LogUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


/**
 * 主要功能: 执行联网操作
 * Created by YJ on 2015/11/24.
 *
 */
public class HttpService {

	/**
	 * Post request (upload files)
	 * @param url
	 * @param params
	 *            form data
	 * @param filepath
	 * @return result 0 for success, 1 for fail
	 * @throws Exception 
	 */
	public static String post(String url, Map<String, String> params, String filepath) throws Exception {
		InputStream response = null;
		try {
			String lineEnd = "\r\n";
			String twoHyphens = "--";
			String boundary = "---------------------------" + System.currentTimeMillis();

			File file = new File(filepath);
			FileInputStream fileInputStream = new FileInputStream(file);
			int fileSize = (int)file.length();
//			System.out.println("\n文件大小:"+file.length());

			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);
			
			conn.setReadTimeout(10000);
 
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Charset", "UTF-8");
//			conn.setRequestProperty("User-Agent", "MyExampleApp/");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			conn.connect();
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			for (String key : params.keySet()) {
				dos.writeBytes(twoHyphens + boundary + lineEnd);
				dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd);
				dos.writeBytes(lineEnd);
				dos.writeBytes(new String(params.get(key).getBytes(), "ISO-8859-1"));
				dos.writeBytes(lineEnd);
			}

			dos.writeBytes(twoHyphens + boundary + lineEnd);
			dos.writeBytes("Content-Disposition: form-data; name=\"file1\"; filename=\"" + file.getName() + "\"" + lineEnd);
			dos.writeBytes(lineEnd);

			int bytesAvailable;

			while ((bytesAvailable = fileInputStream.available()) > 0) {
				int bufferSize = Math.min(bytesAvailable, 4096);
				byte[] buffer = new byte[bufferSize];
				int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				dos.write(buffer, 0, bytesRead);

//				if (onProgressListener != null) {
//					onProgressListener.onProgress(fileSize, fileInputStream.available());
//				}
			}

			dos.writeBytes(lineEnd);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

			fileInputStream.close();
			dos.flush();
			dos.close();
			response = conn.getInputStream();
		} catch (Exception e) {
			System.out.println("upload error: " + e.toString());
		}
		return convertStreamToString(response);
	}

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url
	 *            发送请求的URL
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent",
//					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 英诺威广告专用
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String postGzip(String url, Map<String, Object> params) throws Exception{
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection)realUrl.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);

			conn.setReadTimeout(10000);

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("User-Agent", "KeyApp/");
			conn.setRequestProperty("Content-Type",  "application/x-java-serialized-object");
//			conn.setRequestProperty("Content-Type", "application/json");
//			conn.setRequestProperty("Content-Length", URLUtils.map2json2(params).getBytes("UTF-8").length + "");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding","");

			conn.connect();
			// 获取URLConnection对象对应的输出流
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			// 发送请求参数
			out.write(JsonParseHelper.parse(params));
			// flush输出流的缓冲
//			out.flush();
			out.close();

			// 定义BufferedReader输入流来读取URL的响应
//			return  AdRequest.decompress(conn.getInputStream());
// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally{
		}
		return result;
	}

	public static String post(String url, Map<String, Object> params) throws Exception {
		String result = "";
		try {
			String json=JsonParseHelper.parse(params);
			LogUtils.i("参数",json);
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection)realUrl.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Charset", "UTF-8");
//			conn.setRequestProperty("User-Agent", "KeyApp/");
//			conn.setRequestProperty("Content-Type",  "application/x-java-serialized-object");
			conn.setRequestProperty("Content-Type", "application/json");
//			conn.setRequestProperty("Content-Length", json.getBytes("UTF-8").length + "");
			conn.setRequestProperty("Connection", "Keep-Alive");


			conn.connect();
			// 获取URLConnection对象对应的输出流
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			// 发送请求参数
			out.write(json);
			// flush输出流的缓冲
//			out.flush();
			out.close();

			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//使用finally块来关闭输出流、输入流
		finally{
		}
		return result;
	}

	/**
	 * 功能:把得到的数据流提取String字符串
	 * @param is---数据流
	 * @return ----字符串
	 * @throws Exception
	 * @annotation YJ.2015.10.28
	 */
	private static String convertStreamToString(InputStream is) throws Exception {
		InputStreamReader r;
		r = new InputStreamReader(is);
		
		BufferedReader reader = new BufferedReader(r);
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
		return sb.toString();
	}
	/**
	 * BI统计专用
	 *
	 * @param pathUrl
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 *               是否使用代理模式
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String pathUrl, Map<String,Object> param) {
		String result = "";
		try {
			URL realUrl = new URL(pathUrl);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection)realUrl.openConnection();

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);

			conn.setReadTimeout(10000);
			String json=JsonParseHelper.parse(param);

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("User-Agent", "KeyApp/");
//			conn.setRequestProperty("Content-Type",  "application/x-java-serialized-object");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Content-Length", json.getBytes("UTF-8").length + "");

			conn.connect();
			// 获取URLConnection对象对应的输出流
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			// 发送请求参数
			out.write(json);
			// flush输出流的缓冲
//			out.flush();
			out.close();

			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			Log.e("shutdown","LLL"+ result);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("shutdown","LLL"+e.getMessage()+","+e.toString());
		}
		//使用finally块来关闭输出流、输入流
		finally{
		}

		return result;
	}
}
