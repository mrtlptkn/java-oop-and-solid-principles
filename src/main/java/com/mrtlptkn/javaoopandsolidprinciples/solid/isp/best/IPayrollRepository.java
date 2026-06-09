package com.mrtlptkn.javaoopandsolidprinciples.solid.isp.best;

import java.util.List;

// Payroll Repository özgü özellikler ise buradan yüklendi.
public interface IPayrollRepository {

    List<PayrollEntity> filterByDepartment(String department);


}
