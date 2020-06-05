package extras;

public class SalaryInformation  {
    private double OverWorkTime, HolidayWorkTime, VacationHour;
    private double MorningWorkDays, AfternoonWorkDays, NightWorkDays,fullTimeWorksDays;
    private boolean MorningWork, AfternoonWork, NightWork,fullTime;

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

    public double getMorningWorkDays() {
        return MorningWorkDays;
    }

    public void setMorningWorkDays(double morningWorkDays) {
        MorningWorkDays = morningWorkDays;
    }

    public double getAfternoonWorkDays() {
        return AfternoonWorkDays;
    }

    public void setAfternoonWorkDays(double afternoonWorkDays) {
        AfternoonWorkDays = afternoonWorkDays;
    }

    public double getNightWorkDays() {
        return NightWorkDays;
    }

    public void setNightWorkDays(double nightWorkDays) {
        NightWorkDays = nightWorkDays;
    }

    public double getFullTimeWorksDays() {
        return fullTimeWorksDays;
    }

    public void setFullTimeWorksDays(double fullTimeWorksDays) {
        this.fullTimeWorksDays = fullTimeWorksDays;
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

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}
