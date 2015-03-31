package com.Picloud.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Picloud.config.SystemConfig;
import com.Picloud.hdfs.HdfsHandler;
import com.Picloud.hdfs.MapfileHandler;

@Repository
public class InfoDaoImpl {
	@Autowired
	ImageDaoImpl mImageDaoImpl;
	@Autowired
	LogDaoImpl mLogDaoImpl;
	@Autowired
	UserDaoImpl mUserDaoImpl;
	@Autowired
	SpaceDaoImpl mSpaceDaoImpl;
	@Autowired
	HdfsHandler mHdfsHandler;
	@Autowired
	MapfileHandler mMapfileHandler;
	@Autowired
	MapfileDaoImpl mMapfileDaoImpl;
	@Autowired
	SystemConfig mSystemConfig;
	
	public SystemConfig getmSystemConfig() {
		return mSystemConfig;
	}
	public void setmSystemConfig(SystemConfig mSystemConfig) {
		this.mSystemConfig = mSystemConfig;
	}
	public ImageDaoImpl getmImageDaoImpl() {
		return mImageDaoImpl;
	}
	public void setmImageDaoImpl(ImageDaoImpl mImageDaoImpl) {
		this.mImageDaoImpl = mImageDaoImpl;
	}
	public LogDaoImpl getmLogDaoImpl() {
		return mLogDaoImpl;
	}
	public void setmLogDaoImpl(LogDaoImpl mLogDaoImpl) {
		this.mLogDaoImpl = mLogDaoImpl;
	}
	public UserDaoImpl getmUserDaoImpl() {
		return mUserDaoImpl;
	}
	public void setmUserDaoImpl(UserDaoImpl mUserDaoImpl) {
		this.mUserDaoImpl = mUserDaoImpl;
	}
	public SpaceDaoImpl getmSpaceDaoImpl() {
		return mSpaceDaoImpl;
	}
	public void setmSpaceDaoImpl(SpaceDaoImpl mSpaceDaoImpl) {
		this.mSpaceDaoImpl = mSpaceDaoImpl;
	}
	public HdfsHandler getmHdfsHandler() {
		return mHdfsHandler;
	}
	public void setmHdfsHandler(HdfsHandler mHdfsHandler) {
		this.mHdfsHandler = mHdfsHandler;
	}
	public MapfileHandler getmMapfileHandler() {
		return mMapfileHandler;
	}
	public void setmMapfileHandler(MapfileHandler mMapfileHandler) {
		this.mMapfileHandler = mMapfileHandler;
	}
	public MapfileDaoImpl getmMapfileDaoImpl() {
		return mMapfileDaoImpl;
	}
	public void setmMapfileDaoImpl(MapfileDaoImpl mMapfileDaoImpl) {
		this.mMapfileDaoImpl = mMapfileDaoImpl;
	}
	
	
}
