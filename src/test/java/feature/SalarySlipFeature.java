package feature;

import com.codurance.salaryslipkata.Console;
import com.codurance.salaryslipkata.Employee;
import com.codurance.salaryslipkata.SalarySlipGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SalarySlipFeature {

  private SalarySlipGenerator salarySlipGenerator;
  private Employee employee;

  @Mock
  Console console;

  @BeforeEach
  void setUp() {
    salarySlipGenerator = new SalarySlipGenerator();
    employee = new Employee();
  }

  @Test
  public void generate_monthly_salary_slip(){
    salarySlipGenerator.generateFor(employee);

    InOrder inOrder = Mockito.inOrder(console);

    inOrder.verify(console).printLine("Employee ID | Employee Name | gross_salary | monthly_gross_salary");
    inOrder.verify(console).printLine("12345 | John J Doe | £5000 | £416.67");
  }
}
