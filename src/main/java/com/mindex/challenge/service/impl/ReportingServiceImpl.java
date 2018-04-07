package com.mindex.challenge.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingService;

@Service
public class ReportingServiceImpl implements ReportingService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReportingServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public ReportingStructure getReport(String id) {
		LOG.debug("Read report for employee with id [{}]", id);
		Employee employee = employeeRepository.findByEmployeeId(id);
		ReportingStructure report = new ReportingStructure();
		report.setEmployee(employee);
		Queue<Employee> employees = new LinkedList<Employee>();
		employees.add(employee);
		int countOfReports = 0;
		while(!employees.isEmpty()) {
			Employee employee1 = employees.poll();
			List<Employee> list = employee1.getDirectReports();
			if(list == null) {
				continue;
			}
			countOfReports += list.size();
			for(Employee emp:list) {
				Employee employeeDetails = employeeRepository.findByEmployeeId(emp.getEmployeeId());
				employees.add(employeeDetails);
			}
		}
		report.setNumberOfReports(countOfReports);
		return report;
	}

}
