package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.dao.pojo.Emp;
import com.company.service.iservice.EmpService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("empAction")
@Scope("prototype")
public class EmpAction implements ModelDriven<Emp>,RequestAware{

	@Autowired
	private EmpService empService;


	// 1- 取值
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	private Emp empModel = new Emp();
	@Override
	public Emp getModel() {
		return empModel;
	}
	// 处理
	
	Map<String,Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> requestMapFromStruts2) {
		requestMap = requestMapFromStruts2;		
	}
	
	
	
	public String save() {
		return empService.save(empModel);

	}

	public String delete() {
		return empService.delete(empModel);
	}

	public String update() {
		return empService.update(empModel);
	}

	public String findAll() {
		String msg = "error";
		List<Emp> empList = empService.findAll();
		if (empList != null && empList.size() > 0) {
//			ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
			requestMap.put("empListFromServer", empList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Emp emp = empService.findById(empModel.getEmpno());
		if (emp != null) {
			
			if("update".equals(type)){
				ServletActionContext.getRequest().setAttribute("emp", emp);
				return "updateFromFindById";
			}else{
			List<Emp> empList = new ArrayList<Emp>();
			empList.add(emp);
//			ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
			requestMap.put("empListFromServer", empList);
			msg = "success";
			}
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Emp> empList = empService.findByName(empModel.getEname());
		if (empList != null && empList.size() > 0) {
//			ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
			requestMap.put("empListFromServer", empList);
			msg = "success";
		}
		return msg;
	}
}
