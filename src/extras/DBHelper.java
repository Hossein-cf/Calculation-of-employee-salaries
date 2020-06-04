package extras;

import extras.employeeTypes.EmployeeType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBHelper {
    private static Connection connection;
    private static Statement statement;

    private static void connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Employee.db");
            statement = connection.createStatement();
            System.out.println("Connection to DataBase");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//end

    private static void close() {
        try {
            statement.close();
            connection.close();
            System.out.println("Closed the dataBase");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//end

    public void insertEmployee(Employee employee) {

        connection();
        SalaryInformation salaryInformation = employee.getSalaryInformation();
        int personID = insertPerson(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "", employee.getGender());
        int jobInfoID = insertJobInformation(salaryInformation.getOverWorkTime(), salaryInformation.getHolidayWorkTime(), salaryInformation.getMorningWorkDays(), salaryInformation.getAfternoonWorkDays(), salaryInformation.getNightWorkDays(), salaryInformation.isMorningWork(), salaryInformation.isAfternoonWork(), salaryInformation.isNightWork(), salaryInformation.getVacationHour(), salaryInformation.isFullTime(), salaryInformation.getFullTimeWorksDays());
        String Query = "INSERT INTO Employee (IDPrson , IDJobInformation ,EmployeeNumber , Certificate , WorkExperience,EmployeeType,EmployeeLevel,BaseSalary) VALUE ('" + personID + "' , '" + jobInfoID + "' , '" + employee.getEmployeeNumber() + "','" + employee.getCertificate() + "','" + employee.getWorkExperience() + "','" + employee.getEmployeeType() + "','" + employee.getEmployeeLevel() + "','" + employee.getBaseSalary() + "');";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }//end

    private int insertJobInformation(double OverWorkTime, double HolidayWorkTime, double MorningWorkDays, double AfternoonWorkDays, double NightWorkDays, boolean MorningWork, boolean AfternoonWork, boolean NightWork, double VacationHour, boolean fullTime, double fullTimeWorks) {
        String select = "SELECT ID from JobInformation";
        String Query = "INSERT INTO JobInformation (OverWorkTime , HolidayWorkTime , MorningWorkDays ,AfternoonWorkDays , NightWorkDays , MorningWork , AfternoonWork , NightWork  ,VacationHour,FullTimeWork,FullTimeWorksDays) VALUE ('" + OverWorkTime + "' , '" + HolidayWorkTime + "' , '" + MorningWorkDays + "' ,'" + AfternoonWorkDays + "' , '" + NightWorkDays + "' , '" + MorningWork + "' , '" + AfternoonWork + "' , '" + NightWork + "'  ,'" + VacationHour + "','" + fullTime + "','" + fullTimeWorks + "');";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            ResultSet resultSet = statement.executeQuery(select);
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }//end

    public void updateEmployee(Employee employee) {
        connection();
        String Query = "SELECT IDPerson , IDJobInformation from Employee where EmployeeNumber = '" + employee.getEmployeeNumber() + "';";
        String update = "UPDATE Employee set EmployeeNumber = '" + employee.getEmployeeNumber() + "' , Certificate = '" + employee.getCertificate() + "' , WorkExperience='" + employee.getWorkExperience() + "',EmployeeType ='" + employee.getEmployeeType() + "',EmployeeLevel='" + employee.getEmployeeLevel() + "',BaseSalary='" + employee.getBaseSalary() + "' where EmployeeNumber = '" + employee.getEmployeeNumber() + "';";
        int personId = 0;
        int jobInfoId = 0;
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            statement.executeUpdate(update);
            personId = resultSet.getInt("IDPerson");
            jobInfoId = resultSet.getInt("IDJobInformation");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        updatePeron(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "", personId, employee.getGender());
        updateJobInformation(employee.getSalaryInformation(), jobInfoId);
        close();
    }//end

    private void updateJobInformation(SalaryInformation jobInformation, int id) {
        String Query = "UPDATE JobInformation set OverWorkTime = '" + jobInformation.getOverWorkTime() + "' , HolidayWorkTime = '" + jobInformation.getHolidayWorkTime() + "', MorningWorkDays = '" + jobInformation.getMorningWorkDays() + "' ,AfternoonWorkDays = '" + jobInformation.getAfternoonWorkDays() + "' , NightWorkDays = '" + jobInformation.getNightWorkDays() + "' , MorningWork = '" + jobInformation.isMorningWork() + "' , AfternoonWork = '" + jobInformation.isAfternoonWork() + "', NightWork = '" + jobInformation.isNightWork() + "'  ,VacationHour = '" + jobInformation.getVacationHour() + "' , FullTimeWorkDays = '" + jobInformation.getFullTimeWorksDays() + "' , FullTimeWork = '" + jobInformation.isFullTime() + "' where ID ='" + id + "';";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//end

    private void updatePeron(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, LocalDate birthTime, String phoneNumber, String address, String postalCode, int id, String Gender) {
        String Query = "UPDATE Person set Name = '" + name + "' , LastName = '" + lastName + "',FatherName ='" + fatherName + "', NationalNumber = '" + nationalNumber + "',BornPlace = '" + bornPlace + "' , Address = '" + address + "' , PhoneNumber ='" + phoneNumber + "' , BirthTime = '" + birthTime + "' , PostalCode= '" + postalCode + "',Gender='" + Gender + "' where ID = '" + id + "'";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }//end

    private Person selectPerson(int id) {
        String Query = "SELECT * from Person where ID = '" + id + "';";
        Person person = new Person();
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                person.setName(resultSet.getString("Name"));
                person.setLastName(resultSet.getString("LastName"));
                person.setNationalNumber(resultSet.getLong("NationalNumber"));
                person.setBirthTime(LocalDate.parse(resultSet.getString("BirthTime")));
                person.setBirthPlace(resultSet.getString("BornPlace"));
                person.setPhoneNumber(resultSet.getLong("PhoneNumber"));
                person.setPostalCode(resultSet.getInt("PostalCode"));
                person.setAddress(resultSet.getString("Address"));
                person.setFatherName(resultSet.getString("FatherName"));
                person.setGender(resultSet.getString("Gender"));
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }//end

    public SalaryInformation selectJobInformation(int Id) {
        SalaryInformation jobInformation = new SalaryInformation();
        String Query = "SELECT * from JobInformation where ID = '" + Id + "';";
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                jobInformation.setAfternoonWork(resultSet.getBoolean("AfternoonWork"));
                jobInformation.setAfternoonWorkDays(resultSet.getInt("AfternoonWorkDays"));
                jobInformation.setHolidayWorkTime(resultSet.getDouble("HolidayWorkTime"));
                jobInformation.setMorningWork(resultSet.getBoolean("MorningWork"));
                jobInformation.setMorningWorkDays(resultSet.getInt("MorningWorkDays"));
                jobInformation.setOverWorkTime(resultSet.getDouble("OverWorkTime"));
                jobInformation.setNightWorkDays(resultSet.getInt("NightWorkDays"));
                jobInformation.setNightWork(resultSet.getBoolean("NightWork"));
                jobInformation.setVacationHour(resultSet.getDouble("VacationHour"));
                jobInformation.setFullTime(resultSet.getBoolean("FullTimeWork"));
                jobInformation.setFullTimeWorksDays(resultSet.getInt("FullTimeWorkDays"));
                return jobInformation;
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }//end

    public Employee selectEmployee(long employeeNumber) {
        connection();
        String Query = "SELECT * from Employee where EmployeeNumber = '" + employeeNumber + "';";
        int personID = 0;
        int jobInfoID = 0;
        Employee employee = new Employee();
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                personID = resultSet.getInt("IDPerson");
                jobInfoID = resultSet.getInt("IDJobInformation");
                employee.setEmployeeNumber(employeeNumber);
                employee.setEmployeeType(resultSet.getString("EmployeeType"));
                employee.setCertificate(resultSet.getNString("Certificate"));
                employee.setWorkExperience(resultSet.getString("WorkExperience"));
                employee.setBaseSalary(resultSet.getDouble("BaseSalary"));
                employee.setEmployeeLevel(resultSet.getString("EmployeeLevel"));
                employee.setSalaryInformation(selectJobInformation(jobInfoID));
                Person person = selectPerson(personID);
                employee.setName(person.getName());
                employee.setLastName(person.getLastName());
                employee.setNationalNumber(person.getNationalNumber());
                employee.setFatherName(person.getFatherName());
                employee.setPhoneNumber(person.getPhoneNumber());
                employee.setAddress(person.getAddress());
                employee.setBirthPlace(person.getBirthPlace());
                employee.setBirthTime(person.getBirthTime());
                employee.setPostalCode(person.getPostalCode());
                close();
                return employee;
            } else {
                close();
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return null;
    }//end

    public static int insertPerson(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, LocalDate birthTime, String phoneNumber, String address, String postalCode, String gender) {
        String Query = "INSERT INTO Person (Name , LastName,FatherName , NationalNumber,BornPlace , Address , PhoneNumber , BirthTime , PostalCode , Gender) VALUES ('" + name + "','" + lastName + "','" + fatherName + "','" + nationalNumber + "','" + bornPlace + "','" + address + "','" + phoneNumber + "','" + birthTime + "','" + postalCode + "','" + gender + "'); ";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        Query = "SELCT ID from Person where NationalNumber = '" + nationalNumber + "';";
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }//end

    public ArrayList<Receipt> selectReceipts(long employeeNumber) {
        connection();
        ArrayList<Receipt> receipts = new ArrayList<>();
        String Query = "SELECT * FROM Reciept where IDEmployee = '" + employeeNumber + "'";
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                Receipt receipt = new Receipt();
                receipt.setBaseSalary(resultSet.getDouble("BaseSalary"));
                receipt.setSalaryDate(resultSet.getDate("SalaryDate"));
                receipt.setTax(resultSet.getDouble("Tax"));
                receipt.setOverTimeSalary(resultSet.getDouble("OverTime"));
                receipt.setHolidayTimeSalary(resultSet.getDouble("HolidayTime"));
                receipt.setNightTimeSalary(resultSet.getDouble("NightWork"));
                receipt.setMorningTimeSalary(resultSet.getDouble("MorningWork"));
                receipt.setAfternoonTimeSalary(resultSet.getDouble("AfternoonWork"));
                receipt.setFullTimeSalary(resultSet.getDouble("FullTimeWork"));
                receipt.setRightToHousing(resultSet.getDouble("RightToHousing"));
                receipt.setInsurance(resultSet.getDouble("Insurance"));
                receipt.setFinalSalary(resultSet.getDouble("FinalSalary"));
                receipts.add(receipt);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return receipts;

    }//end

    public void insertReceipt(Receipt receipt, long EmployeeNumber) {
        connection();
        String s = "SELECT ID FROM Employee where EmployeeNumber = '" + EmployeeNumber + "';";
        int ID = 0;
        try {
            ResultSet resultSet = statement.executeQuery(s);
            ID = resultSet.getInt("ID");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String Query = "INSERT INTO Receipt (IDEmployee , BaseSalary , SalaryDate , Tax , OverTime, HolidayTime , NightWork , MorningWork,AfternoonWork,FullTimeWork ,RightToHousing,Insurance ,FinalSalary  )value ('" + ID + "','" + receipt.getBaseSalary() + "','" + receipt.getSalaryDate() + "','" + receipt.getTax() + "','" + receipt.getOverTimeSalary() + "','" + receipt.getHolidayTimeSalary() + "','" + receipt.getNightTimeSalary() + "', '" + receipt.getMorningTimeSalary() + "', '" + receipt.getAfternoonTimeSalary() + "', '" + receipt.getFullTimeSalary() + "', '" + receipt.getRightToHousing() + "', '" + receipt.getInsurance() + "', '" + receipt.getFinalSalary() + "');";

        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }//end

    public int numberOfEmployeeType(EmployeeType employeeType) {
        connection();
        String Query = "Select * from Employee where EmployeeType = '"+employeeType+"';";
        try {
            int count =0;
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next())
                count++;
            return count;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        close();
        return 0;
    }
}
