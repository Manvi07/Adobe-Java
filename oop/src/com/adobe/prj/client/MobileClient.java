package com.adobe.prj.client;

import com.adobe.prj.dao.MobileDao;
import com.adobe.prj.dao.MobileDaoMongoImpl;
import com.adobe.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile m = new Mobile(23,"some",333,"4G");

		MobileDao mobileDao = new MobileDaoMongoImpl();
		mobileDao.addMobile(m);
	
	}

}
