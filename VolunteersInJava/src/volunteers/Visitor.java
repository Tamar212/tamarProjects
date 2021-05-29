/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volunteers;

/**
 *
 * @author user
 */
public class Visitor extends Volunteer {
     private MaritalStatus status;

   public Visitor(MaritalStatus status, PersonalDetails volunteer, boolean bool, int basisBonus,Volunteer.day whichDay) {
        super(volunteer, bool, basisBonus, whichDay);
        this.status = status;
    }
 
     public enum MaritalStatus {
        Bachelor,
        Married
    }

    @Override
    public String toString() {
        return " Visitor{" + super.toString() + "status= " + status + '}';
    }
    public int calcBonus() {
        if(status.equals(MaritalStatus.Bachelor)){
            return 5+this.getBasisBonus();
        }
        return 10;
    }
    
}
