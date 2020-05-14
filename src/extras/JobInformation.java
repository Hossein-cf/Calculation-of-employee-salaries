package extras;

import employeeTypes.EmployeeType;

public class JobInformation {
    private double OverWorkTime, HolidayWorkTime, VacationHour;
    private int MorningWorkDays, AfternoonWorkDays, NightWorkDays;
    private boolean MorningWork, AfternoonWork, NightWork;

    public double getOverWorkTime() {
        return OverWorkTime;
    }

    public void setOverWorkTime(double overWorkTime) {
        OverWorkTime = overWorkTime;
    }

    public double getHolidayWorkTime() {
        return HolidayWorkTime;
    }

    public void setHolidayWorkTime(double holidayWorkTime) {
        HolidayWorkTime = holidayWorkTime;
    }

    public double getVacationHour() {
        return VacationHour;
    }

    public void setVacationHour(double vacationHour) {
        VacationHour = vacationHour;
    }

    public int getMorningWorkDays() {
        return MorningWorkDays;
    }

    public void setMorningWorkDays(int morningWorkDays) {
        MorningWorkDays = morningWorkDays;
    }

    public int getAfternoonWorkDays() {
        return AfternoonWorkDays;
    }

    public void setAfternoonWorkDays(int afternoonWorkDays) {
        AfternoonWorkDays = afternoonWorkDays;
    }

    public int getNightWorkDays() {
        return NightWorkDays;
    }

    public void setNightWorkDays(int nightWorkDays) {
        NightWorkDays = nightWorkDays;
    }

    public boolean isMorningWork() {
        return MorningWork;
    }

    public void setMorningWork(boolean morningWork) {
        MorningWork = morningWork;
    }

    public boolean isAfternoonWork() {
        return AfternoonWork;
    }

    public void setAfternoonWork(boolean afternoonWork) {
        AfternoonWork = afternoonWork;
    }

    public boolean isNightWork() {
        return NightWork;
    }

    public void setNightWork(boolean nightWork) {
        NightWork = nightWork;
    }
}
