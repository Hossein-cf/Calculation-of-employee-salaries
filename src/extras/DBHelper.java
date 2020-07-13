package extras;

import extras.employeeTypes.EmployeeType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBHelper {
    private static Connection connection;
    private static Statement statement;

    //[dbo].[tblReceipt]
    private static void connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=EmployeeRegistery;integratedSecurity=true;";
            connection = DriverManager.getConnection(connectionUrl);
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


        SalaryInformation salaryInformation = employee.getSalaryInformation();
        int personID = insertPerson(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "", employee.getGender());
        int jobInfoID = insertJobInformation(salaryInformation.getOverWorkTime(), salaryInformation.getHolidayWorkTime(), salaryInformation.getMorningWorkDays(), salaryInformation.getAfternoonWorkDays(), salaryInformation.getNightWorkDays(), salaryInformation.isMorningWork(), salaryInformation.isAfternoonWork(), salaryInformation.isNightWork(), salaryInformation.getVacationHour(), salaryInformation.isFullTime(), salaryInformation.getFullTimeWorksDays(), salaryInformation.getAbsenceDays());
        connection();
        System.out.println(personID + "llllllllllllll");
        String Query = "INSERT INTO [dbo].[tblEmployee] (IDPerson , IDSalaryInformation ,EmployeeNumber , Certificate , WorkExperience,EmployeeType,EmployeeLevel,BaseSalary) VALUES ('" + personID + "' , '" + jobInfoID + "' , '" + employee.getEmployeeNumber() + "','" + employee.getCertificate() + "','" + employee.getWorkExperience() + "','" + employee.getEmployeeType() + "','" + employee.getEmployeeLevel() + "','" + employee.getBaseSalary() + "');";
        try {
            statement.executeUpdate(Query);
            System.out.println("insert Employee successful");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " INSERT Employee");
        }
        close();
    }//end

    private int insertJobInformation(double OverWorkTime, double HolidayWorkTime, double MorningWorkDays, double AfternoonWorkDays, double NightWorkDays, boolean MorningWork, boolean AfternoonWork, boolean NightWork, double VacationHour, boolean fullTime, double fullTimeWorks, int numberOfAbsence) {
        connection();
        String select = "SELECT ID from [dbo].[tblSalaryInformation]";
        String Query = "INSERT INTO [dbo].[tblSalaryInformation] (OverWorkTime , HolidayWorkTime , MorningWorkDays ,AfternoonWorkDays , NightWorkDays , MorningWork , AfternoonWork , NightWork  ,VacationHour,FullTimeWork,FullTimeWorkDays,NumberOfAbsence) VALUES ('" + OverWorkTime + "' , '" + HolidayWorkTime + "' , '" + MorningWorkDays + "' ,'" + AfternoonWorkDays + "' , '" + NightWorkDays + "' , '" + MorningWork + "' , '" + AfternoonWork + "' , '" + NightWork + "'  ,'" + VacationHour + "','" + fullTime + "','" + fullTimeWorks + "','" + numberOfAbsence + "');";
        try {
            statement.executeUpdate(Query);
            System.out.println("insert Job successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " INSERT JOB INFO 1");
        }
        try {
            ResultSet resultSet = statement.executeQuery(select);
            int i = 0;
            while (resultSet.next())
                i = resultSet.getInt("ID");
            System.out.println("insert Job12 successful");

            close();
            return i;

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " INSERT JOB INFO 12");
        }
        close();
        return 0;
    }//end

    public void updateEmployee(Employee employee) {
        //[dbo].[tblSalaryInformation]
        connection();
        String Query = "SELECT IDPerson , IDSalaryInformation from [dbo].[tblEmployee] where EmployeeNumber = '" + employee.getEmployeeNumber() + "';";
        String update = "UPDATE [dbo].[tblEmployee] set EmployeeNumber = '" + employee.getEmployeeNumber() + "'  , Certificate = '" + employee.getCertificate() + "' , WorkExperience='" + employee.getWorkExperience() + "' , EmployeeType ='" + employee.getEmployeeType() + "' ,  EmployeeLevel='" + employee.getEmployeeLevel() + "' ,  BaseSalary='" + employee.getBaseSalary() + "' where EmployeeNumber = '" + employee.getEmployeeNumber() + "';";
        int personId = 0;
        int jobInfoId = 0;
        try {
            connection();
            System.out.println(statement.executeUpdate(update));
            close();
            connection();
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                personId = resultSet.getInt("IDPerson");
                jobInfoId = resultSet.getInt("IDSalaryInformation");
            }
            System.out.println(" update Employee successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "UPDATE EMPLOYEE");
        }
        close();
        System.out.println(jobInfoId+"llll"+personId);
        updatePeron(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "", personId, employee.getGender());
        updateJobInformation(employee.getSalaryInformation(), jobInfoId);
    }//end

    private void updateJobInformation(SalaryInformation jobInformation, int id) {
        connection();
        String Query = "UPDATE [dbo].[tblSalaryInformation] set OverWorkTime = '" + jobInformation.getOverWorkTime() + "' , HolidayWorkTime = '" + jobInformation.getHolidayWorkTime() + "', MorningWorkDays = '" + jobInformation.getMorningWorkDays() + "' ,AfternoonWorkDays = '" + jobInformation.getAfternoonWorkDays() + "' , NightWorkDays = '" + jobInformation.getNightWorkDays() + "' , MorningWork = '" + jobInformation.isMorningWork() + "' , AfternoonWork = '" + jobInformation.isAfternoonWork() + "', NightWork = '" + jobInformation.isNightWork() + "'  ,VacationHour = '" + jobInformation.getVacationHour() + "' , FullTimeWorkDays = '" + jobInformation.getFullTimeWorksDays() + "' , FullTimeWork = '" + jobInformation.isFullTime() + "', NumberOfAbsence = '" + jobInformation.getAbsenceDays() + "' where ID ='" + id + "';";
        try {
            statement.executeUpdate(Query);
            System.out.println("insert update job  successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "UPDATE JOB INFO");

        }
        close();
    }//end

    private void updatePeron(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, LocalDate birthTime, String phoneNumber, String address, String postalCode, int id, String Gender) {
        connection();
        String Query = "UPDATE [dbo].[tblPerson] set Name = '" + name + "' , LastName = '" + lastName + "',FatherName ='" + fatherName + "', NationalNumber = '" + nationalNumber + "',BornPlace = '" + bornPlace + "' , Address = '" + address + "' , PhoneNumber ='" + phoneNumber + "' , BirthTime = '" + birthTime + "' , PostalCode= '" + postalCode + "',Gender='" + Gender + "' where ID = '" + id + "'";
        try {
            statement.executeUpdate(Query);
            System.out.println("insert update person successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "UPDATE PERSON");
        }
        close();
    }//end

    private Person selectPerson(int id) {
        connection();
        String Query = "SELECT * from [dbo].[tblPerson] where ID = '" + id + "';";
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
                close();
                System.out.println("Select person  successful");

                return person;
            } else {
                close();
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SELECT PERSON");
        }
        close();
        return null;
    }//end

    public SalaryInformation selectJobInformation(int Id) {
        connection();
        SalaryInformation jobInformation = new SalaryInformation();
        String Query = "SELECT * from [dbo].[tblSalaryInformation] where ID = '" + Id + "';";
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                jobInformation.setAfternoonWork(resultSet.getBoolean("AfternoonWork"));
                jobInformation.setAfternoonWorkDays(resultSet.getDouble("AfternoonWorkDays"));
                jobInformation.setHolidayWorkTime(resultSet.getDouble("HolidayWorkTime"));
                jobInformation.setMorningWork(resultSet.getBoolean("MorningWork"));
                jobInformation.setMorningWorkDays(resultSet.getDouble("MorningWorkDays"));
                jobInformation.setOverWorkTime(resultSet.getDouble("OverWorkTime"));
                jobInformation.setNightWorkDays(resultSet.getDouble("NightWorkDays"));
                jobInformation.setNightWork(resultSet.getBoolean("NightWork"));
                jobInformation.setVacationHour(resultSet.getDouble("VacationHour"));
                jobInformation.setFullTime(resultSet.getBoolean("FullTimeWork"));
                jobInformation.setFullTimeWorksDays(resultSet.getDouble("FullTimeWorkDays"));
                jobInformation.setAbsenceDays(resultSet.getInt("NumberOfAbsence"));
                close();
                System.out.println("Select job  successful");

                return jobInformation;
            } else {
                close();
                return null;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SELECT JOB INFO");
        }
        close();
        return null;
    }//end

    public Employee selectEmployee(long employeeNumber) {
        connection();
        String Query = "SELECT * from [dbo].[tblEmployee] where EmployeeNumber = '" + employeeNumber + "';";
        int personID = 0;
        int jobInfoID = 0;
        Employee employee = new Employee();
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                personID = resultSet.getInt("IDPerson");
                jobInfoID = resultSet.getInt("IDSalaryInformation");
                employee.setEmployeeNumber(employeeNumber);
                employee.setEmployeeType(resultSet.getString("EmployeeType"));
                employee.setCertificate(resultSet.getString("Certificate"));
                employee.setWorkExperience(resultSet.getInt("WorkExperience"));
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
                System.out.println("select Employee successful");

                return employee;
            } else {
                close();
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SELECT EMPLOYEE");
        }
        close();
        return null;
    }//end

    private void CreateTableFoeReceipt() {
        connection();
        String sql = "CREATE TABLE IF NOT EXISTS Receipt1 (\n"
                + "	id integer PRIMARY KEY, \n"
                + "IDEmployee TEXT,\n" +
                " BaseSalary TEXT, \n" +
                "SalaryDate TEXT, \n" +
                "Tax TEXT, \n" +
                "OverTime TEXT,\n " +
                "HolidayTime TEXT,\n" +
                " NightWork TEXT, \n" +
                "MorningWork TEXT,\n" +
                "AfternoonWork TEXT,\n" +
                "FullTimeWork TEXT ,\n" +
                "RightToHousing TEXT,\n" +
                "Insurance TEXT,\n" +
                "FinalSalary TEXT,\n" +
                "Serial TEXT\n "
                + ");";

        try {
            statement.execute(sql);
            close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int insertPerson(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, LocalDate birthTime, String phoneNumber, String address, String postalCode, String gender) {
        connection();
        String Query = "INSERT INTO [dbo].[tblPerson] (Name , LastName,FatherName , NationalNumber,BornPlace , Address , PhoneNumber , BirthTime , PostalCode , Gender) VALUES ('" + name + "','" + lastName + "','" + fatherName + "','" + nationalNumber + "','" + bornPlace + "','" + address + "','" + phoneNumber + "','" + birthTime + "','" + postalCode + "','" + gender + "'); ";
        try {
            statement.executeUpdate(Query);
            System.out.println("insert person  successful");

            Query = "SELECT * from [dbo].[tblPerson] where NationalNumber = '" + nationalNumber + "';";
//        Query ="SELECT  ID from [dbo].[tblPerson]";


            ResultSet resultSet = statement.executeQuery(Query);
            int i = 0;
            while (resultSet.next())
                i = resultSet.getInt("ID");

            close();
            System.out.println("insert person 12 successful");

            return i;

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "      INSERT PERSON mmmmmmmm");
        }
        close();
        return 0;

    }//end

    public ArrayList<Receipt> selectReceipts(long employeeNumber) {
        connection();
        ArrayList<Receipt> receipts = new ArrayList<>();
        String Query = "SELECT * FROM [dbo].[tblReceipt] where IDEmployee = '" + employeeNumber + "'";
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                Receipt receipt = new Receipt();
                receipt.setBaseSalary(resultSet.getDouble("BaseSalary"));
                receipt.setSalaryDate(LocalDate.parse(resultSet.getString("SalaryDate")));
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
                receipt.setSerial(resultSet.getLong("Serial"));
                receipts.add(receipt);
                System.out.println("Select receipt successful");
                close();

                return receipts;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SELECT RECEIPT");
        }
        close();
        receipts.add(new Receipt());
        return receipts;
    }//end

    public void insertReceipt(Receipt receipt, long EmployeeNumber) {
        connection();
        String s = "SELECT ID FROM [dbo].[tblEmployee]  where EmployeeNumber = '" + EmployeeNumber + "';";
        int ID = 0;
        try {
            ResultSet resultSet = statement.executeQuery(s);
            ID = resultSet.getInt("ID");
            System.out.println("insert receipt 1 successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String Query = "INSERT INTO [dbo].[tblReceipt] (IDEmployee , BaseSalary , SalaryDate , Tax , OverTime, HolidayTime , NightWork , MorningWork,AfternoonWork,FullTimeWork ,RightToHousing,Insurance ,FinalSalary,Serial  )value ('" + ID + "','" + receipt.getBaseSalary() + "','" + receipt.getSalaryDate() + "','" + receipt.getTax() + "','" + receipt.getOverTimeSalary() + "','" + receipt.getHolidayTimeSalary() + "','" + receipt.getNightTimeSalary() + "', '" + receipt.getMorningTimeSalary() + "', '" + receipt.getAfternoonTimeSalary() + "', '" + receipt.getFullTimeSalary() + "', '" + receipt.getRightToHousing() + "', '" + receipt.getInsurance() + "', '" + receipt.getFinalSalary() + "','" + receipt.getSerial() + "');";

        try {
            statement.executeUpdate(Query);
            System.out.println("insert receipt successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SELECT RECEIPTS");
        }
        close();
    }//end

    public int numberOfEmployeeType(EmployeeType employeeType) {
        connection();
        String Query = "Select  tblEmployee where EmployeeType = '" + employeeType + "';";
        try {
            int count = 0;
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                resultSet.getString("EmployeeType");
                count++;

            }
            close();
            return count;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "NUMBER OF EMPLOYEE");
        }


        close();
        return 0;
    }
//    public DBHelper(){
//        CreateTableFoeReceipt();
//    }

}
