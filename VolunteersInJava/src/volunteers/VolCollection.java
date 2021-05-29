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
public class VolCollection {

    private Volunteer arrVol[] = new Volunteer[5];
    private static int index = 0;  // המקום הפנוי הבא במערך

    public VolCollection() {

    }

    public void addvolunteer(Volunteer v) {
        if (index < getArrVol().length) {
            System.out.println("yes");
            arrVol[index++] = v;
        }
    }

    public Volunteer search(int t, int age, String day) {

        for (int i = 0; i < index; i++) {
            // בדיקה האם המתנדב עונה על הקריטריונים לחיפוש וגם הוא פנוי
            if (getArrVol()[i] instanceof Doctor && t == 1) {              
                if (getArrVol()[i].getVolunteer().getAge() >= age) {
                    if (getArrVol()[i].getWhichDay().toString().equals(day)) {
                        if(getArrVol()[i].isBool()==true){
                            System.out.println("המתנדב נמצא בהצלחה!!");
                         getArrVol()[i].setBool(false);
                        return getArrVol()[i];
                        }             
                    }
                }
            }
            if (getArrVol()[i] instanceof Visitor && t == 2) {
                if (getArrVol()[i].getVolunteer().getAge() >= age) {
                    if (getArrVol()[i].getWhichDay().toString().equals(day)) {
                        if(getArrVol()[i].isBool()==true){
                             System.out.println("המתנדב נמצא בהצלחה!!");
                        getArrVol()[i].setBool(false);
                        return getArrVol()[i];
                        }                      
                    }

                }
            }

        }
        System.out.println("לא נמצא!");
        return null; //למקרה שלא נמצא מתנדב מתאים
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(getArrVol()[i]);
        }

    }

    /**
     * @return the arrVol
     */
    public Volunteer[] getArrVol() {
        return arrVol;
    }

    public void sort() {
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (getArrVol()[i].getVolunteer().getFamilyName().compareTo(getArrVol()[j].getVolunteer().getFamilyName()) > 0) {
                    Volunteer temp = getArrVol()[i];
                    arrVol[i] = getArrVol()[j];
                    arrVol[j] = temp;
                }
            }
        }
        
    }
     
}
