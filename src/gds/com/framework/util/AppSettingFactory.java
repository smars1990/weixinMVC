package gds.com.framework.util;


import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 文件名：微信AppsettingFactory工具类<br>
 * 版权：Copyright (c) 2017 刘云鹏<br>
 * 描述：微信测系统，主要包括微信的access_token、管理通讯录、发送微信消息、微信JS-SDK等操作。<br>
 * 修改人：Author: liuyunpeng<br>
 * 版本：Revision: 1.0
 */
public class AppSettingFactory {

	/**
	 * 静态的AppSettingFactory实例
	 */
	public  static  AppSettingFactory _instance = new  AppSettingFactory();
	
	/**
	 * Properties类
	 */
    private Properties properties = null;
	
	/**
	 * 私有的构造方法
	 */
	private AppSettingFactory(){
		try {
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * 初始化查找appSetting.properties 文件
	 */
	private  void init() throws Exception{
        String pFilename = "/config/AppSetting.properties"; // 文件名
		
		Resource resource = new ClassPathResource(pFilename);
		this.properties = PropertiesLoaderUtils.loadProperties(resource);
	}
	
	/**
	 * 
     * 于该类采用了单子模式。我们可以通过该方法得到对AppSettingFactory的唯一实例
	 */
	public  static  AppSettingFactory  getInstance(){
		if(_instance == null ){
			_instance = new AppSettingFactory();
		}
		return _instance;
	}
	
	
	/**
	 * 
	 * 通过appSetting 获取key键值对的value值
	 * @param aParamsMap 封装的查询条件
	 * <p>
	 * <li>key=entityName key值</li>
	 * <li>key=entityValue value值</li>
	 * </p>
     * @return String  返回的是appSetting中写的键值对vlaue值
	 */
	public String  getAppSetting(String entityName){
		return  ""+properties.get(entityName);
	} 
	
}
