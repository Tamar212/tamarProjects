/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volunteers;

import java.util.Arrays;

/**
 *
 * @author user
 */
public abstract class Volunteer {

    private PersonalDetails volunteer;
    private boolean bool;
    private int basisBonus;
    private  day whichDay;

    public day getWhichDay() {
        return whichDay;
    }

    public void setWhichDay(day whichDay) {
        this.whichDay = whichDay;
    }
    
    public PersonalDetails getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(PersonalDetails volunteer) {
        this.volunteer = volunteer;
    }
    

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getBasisBonus() {
        return basisBonus;
    }

    public void setBasisBonus(int basisBonus) {
        this.basisBonus = basisBonus;
    }

    public enum day {

        sunday,
        monday,
        tuesday,
        wendesday,
        sursday,
        friday,
        suterday
    }

    public Volunteer(PersonalDetails volunteer, boolean bool, int basisBonus, day whichDay) {
        this.volunteer = volunteer;
        this.bool = bool;
        this.basisBonus = basisBonus;
        this.whichDay = whichDay;
    }

    @Override
    public String toString() {
        return " Volunteer{ " + "volunteer= " + volunteer + ", bool= " + bool + ", basisBonus= " + basisBonus + '}';

 
    }
        public abstract int calcBonus();
      
}
