package com.company.service.iservice;

public interface ReportService {
	String reportDeptInfo();//前后端分离的情况下，返回的是json字符串
	String reportAvgSalByYear();
}
