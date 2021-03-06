package Airports;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.*;

/**
 * AirportStuff class represents the employees that work in airport. Employees constist of 3 types:
 * checkIn stuff that work in Check-In place, store stuff that works in stores and gate stuff that work in gates
 * All employees have one stable work-hour program, and all of them, due to the situation of covid-19, work alone, without other employee
 */
public class AirportStuff extends Person {

    // A map that has as key one of the days of the week, and as value an arraylist which has inside an array with 2 rows
    // The first row is about the time when employee starts working this day and the second is about the time of the end of working
    private HashMap<DayOfWeek, ArrayList<LocalTime[]>> workHoursMap;

    /**
     * Constructor of the class
     * Creates an employee (storeStuff, gateStuff or checkInStuff) with the specified elements which are inherited by class Person
     * @see Person
     * @param ssn The SSN of the employee
     * @param name The first name of the employee
     * @param lastName The last name of the employee
     * @param address The address of the employee
     * @param phone The phone of the employee
     */
    public AirportStuff(String ssn, String name, String lastName, String address, String phone) {
        super(ssn, name, lastName, address, phone);
        this.workHoursMap = new  HashMap<DayOfWeek,ArrayList<LocalTime[]>>();
        setWorkHoursMap();
    }

    /**
     * Sets the work hours of the employee for everyday
     */
    public void setWorkHoursMap() {
        for(DayOfWeek day : DayOfWeek.values()){
            workHoursMap.put(day, new ArrayList<LocalTime[]>());
        }
    }

    /**
     * Gets the work hours of the employee for every day
     * @return HashMap representing the hours that each employee works
     */
    public HashMap<DayOfWeek, ArrayList<LocalTime[]>> getWorkHoursMap() {
        return workHoursMap;
    }

    /**
     * Adds the work hour of one day of the week for an employee
     * @param day DayofWeek containing a day of the week
     * @param startTime LocalTime containing the time when employee starts working
     * @param endTime LocalTime containing the time when employee ends working
     * @return HashMap representing the weekly work hours of an employee
     */
    public boolean addWorkHours(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        return this.workHoursMap.get(day).add(new LocalTime[]{startTime, endTime});
    }

    /**
     * Adds the work hour of one day of the week for an employee
     * @param day DayofWeek containing a day of the week
     * @param startTime String containing the time when employee starts working
     * @param endTime String containing the time when employee ends working
     * @return HashMap representing the weekly work hours of an employee
     */
    public boolean addWorkHours(DayOfWeek day, String startTime, String endTime) {
        // Convert String startTime to LocalTime
        LocalTime startTimeDate = LocalTime.parse(startTime);
        // Convert String endTime to LocalTime
        LocalTime endTimeDate = LocalTime.parse(endTime);
        return this.workHoursMap.get(day).add(new LocalTime[]{startTimeDate, endTimeDate});
    }

    /**
     * Gets for a date and time we search for if an employee works at that time
     * Finds the day of the dateTime and the time of the dateTime
     * @param dateTime the date and the time we want to search for
     * @return boolean depending if there is someone working the day and time we look for at the workHoursMap
     */
    public boolean isWorking(LocalDateTime dateTime){
        DayOfWeek day = dateTime.getDayOfWeek();
        LocalTime time = dateTime.toLocalTime();
        for(LocalTime[] localtimes : this.workHoursMap.get(day)){
            LocalTime time0 = localtimes[0];
            LocalTime time1 = localtimes[1];
            if(localtimes[1].equals(LocalTime.parse("00:00"))) {
                time1 =  LocalTime.parse("23:59");
            }
            //in order to include the shift change of employees 
            if(!localtimes[0].equals(LocalTime.parse("00:00"))) {
                time0 = localtimes[0].minusSeconds(1);
            }
            if(time.equals(LocalTime.parse("00:00"))) {
                if (localtimes[0].equals(LocalTime.parse("00:00"))) {
                    time = time.plusSeconds(1);
                }
            }
                if(time.isAfter(time0) && time.isBefore(time1.plusSeconds(1))) {
                    return true;
                }
        }
        return false;
    }

    /**
     * Covers the case that dateTime is 00:00 and have to take the employee that works
     * in the shift change the previoys day
     * @param dateTime the date and the time we want to search for
     * @return boolean depending if there is someone working the day and time we look for at the workHoursMap
     */
    public boolean isWorkingPreviousDay(LocalDateTime dateTime) {
        DayOfWeek day = dateTime.getDayOfWeek();
        day = day.minus(1);

        for(LocalTime[] localtimes : this.workHoursMap.get(day)) {
            if(localtimes[0].equals(LocalTime.parse("16:00"))) {
                return true;
            }
        }
        return false;
    }
}
