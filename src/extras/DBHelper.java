package extras;

import java.sql.*;
import java.util.Date;

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

    }

    private static void close() {
        try {
            statement.close();
            connection.close();
            System.out.println("Closed the dataBase");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertEmployee(Employee employee) {

        connection();
        SalaryInformation salaryInformation = employee.getSalaryInformation();
        int personID = insertPerson(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "");
        int jobInfoID = insertJobInformation(salaryInformation.getOverWorkTime(), salaryInformation.getHolidayWorkTime(), salaryInformation.getMorningWorkDays(), salaryInformation.getAfternoonWorkDays(), salaryInformation.getNightWorkDays(), salaryInformation.isMorningWork(), salaryInformation.isAfternoonWork(), salaryInformation.isNightWork(), salaryInformation.getVacationHour(), salaryInformation.isFullTime(), salaryInformation.getFullTimeWorks());
        String Query = "INSERT INTO Employee (IDPrson , IDJobInformation ,EmployeeNumber , Certificate , WorkExperience,EmployeeType) VALUE ('" + personID + "' , '" + jobInfoID + "' , '" + employee.getEmployeeNumber() + "','" + employee.getCertificate() + "','" + employee.getWorkExperience() + "','" + employee.getEmployeeType() + "');";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    private int insertJobInformation(double OverWorkTime, double HolidayWorkTime, int MorningWorkDays, int AfternoonWorkDays, int NightWorkDays, boolean MorningWork, boolean AfternoonWork, boolean NightWork, double VacationHour, boolean fullTime, int fullTimeWorks) {
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
    }

    public void updateEmployee(Employee employee) {
        connection();
        String Query = "SELECT IDPerson , IDJobInformation from Employee where EmployeeNumber = '" + employee.getEmployeeNumber() + "';";
        int personId = 0;
        int jobInfoId = 0;
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            personId = resultSet.getInt("IDPerson");
            jobInfoId = resultSet.getInt("IDJobInformation");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        updatePeron(employee.getName(), employee.getLastName(), employee.getFatherName(), employee.getNationalNumber(), employee.getBirthPlace() + "", employee.getBirthTime(), employee.getPhoneNumber() + "", employee.getAddress() + "", employee.getPostalCode() + "", personId);
        updateJobInformation(employee.getSalaryInformation(), jobInfoId);
        close();
    }

    private void updateJobInformation(SalaryInformation jobInformation, int id) {
        String Query = "UPDATE JobInformation set OverWorkTime = '" + jobInformation.getOverWorkTime() + "' , HolidayWorkTime = '" + jobInformation.getHolidayWorkTime() + "', MorningWorkDays = '" + jobInformation.getMorningWorkDays() + "' ,AfternoonWorkDays = '" + jobInformation.getAfternoonWorkDays() + "' , NightWorkDays = '" + jobInformation.getNightWorkDays() + "' , MorningWork = '" + jobInformation.isMorningWork() + "' , AfternoonWork = '" + jobInformation.isAfternoonWork() + "', NightWork = '" + jobInformation.isNightWork() + "'  ,VacationHour = '" + jobInformation.getVacationHour() + "' , FullTimeWorkDays = '" + jobInformation.getFullTimeWorks() + "' , FullTimeWork = '" + jobInformation.isFullTime() + "' where ID ='" + id + "';";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updatePeron(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, Date birthTime, String phoneNumber, String address, String postalCode, int id) {
        String Query = "UPDATE Person set Name = '" + name + "' , LastName = '" + lastName + "',FatherName ='" + fatherName + "', NationalNumber = '" + nationalNumber + "',BornPlace = '" + bornPlace + "' , Address = '" + address + "' , PhoneNumber ='" + phoneNumber + "' , BirthTime = '" + birthTime + "' , PostalCode= '" + postalCode + "' where ID = '" + id + "'";
        try {
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private Person selectPerson(int id) {
        String Query = "SELECT * from Person where ID = '" + id + "';";
        Person person = new Person();
        try {
            ResultSet resultSet = statement.executeQuery(Query);
            if (resultSet.next()) {
                person.setName(resultSet.getString("Name"));
                person.setLastName(resultSet.getString("LastName"));
                person.setNationalNumber(resultSet.getLong("NationalNumber"));
                person.setBirthTime(resultSet.getTime("BirthTime"));
                person.setBirthPlace(resultSet.getString("BornPlace"));
                person.setPhoneNumber(resultSet.getLong("PhoneNumber"));
                person.setPostalCode(resultSet.getInt("PostalCode"));
                person.setAddress(resultSet.getString("Address"));
                person.setFatherName(resultSet.getString("FatherName"));
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

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
                jobInformation.setFullTimeWorks(resultSet.getInt("FullTimeWorkDays"));
                return jobInformation;
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

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
                employee.setWorkExperience(resultSet.getInt("WorkExperience"));
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
    }

    public static int insertPerson(String name, String lastName, String fatherName, long nationalNumber, String bornPlace, Date birthTime, String phoneNumber, String address, String postalCode) {
        String Query = "INSERT INTO Person (Name , LastName,FatherName , NationalNumber,BornPlace , Address , PhoneNumber , BirthTime , PostalCode) VALUES ('" + name + "','" + lastName + "','" + fatherName + "','" + nationalNumber + "','" + bornPlace + "','" + address + "','" + phoneNumber + "','" + birthTime + "','" + postalCode + "'); ";
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

    }


}
