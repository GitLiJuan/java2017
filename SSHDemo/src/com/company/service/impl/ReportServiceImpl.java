package com.company.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.ReportDao;
import com.company.service.dto.result.DeptInfoReport;
import com.company.service.iservice.ReportService;
import com.google.gson.Gson;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;

	@Transactional
	@Override
	public String reportDeptInfo() {
		List<DeptInfoReport> infos = null;
		String infosJsonStr = "";
		try {
			infos = reportDao.reportDeptInfo();
			Gson gson = new Gson();
			infosJsonStr = gson.toJson(infos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infosJsonStr;
	}

	@Override
	public String reportAvgSalByYear() {
		// TODO Auto-generated method stub
		return null;
	}

}
