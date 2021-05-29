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
public class Doctor extends Volunteer {
     private int vetek;
     private Toar toar;

    public Doctor(int vetek, Toar toar, PersonalDetails volunteer, boolean bool, int basisBonus,Volunteer.day whichDay) {
        super(volunteer, bool, basisBonus, whichDay);
        this.vetek = vetek;
        this.toar = toar;
    }
 
    public int calcBonus() {
        if(toar.equals(Toar.a)){
            return 3+vetek+this.getBasisBonus();
        }
        if(toar.equals(Toar.b)){
            return 2+vetek+this.getBasisBonus();
        }
         return 1+vetek+this.getBasisBonus();
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" + "vetek=" + vetek + ", toar=" + toar + '}';
    }
 
   public enum Toar{
         a,
         b,
         c
     }
}
