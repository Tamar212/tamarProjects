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
public class Volunteers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonalDetails a0 = new PersonalDetails(22221123, 34, "ron", "levi");
        Doctor a1 = new Doctor(10, Doctor.Toar.b, a0, true, 0, Volunteer.day.sunday);
        PersonalDetails a2 = new PersonalDetails(1235321, 46, "dan", "cohen");
        Visitor a3 = new Visitor(Visitor.MaritalStatus.Bachelor, a2, true, 20, Volunteer.day.friday);

        VolCollection s = new VolCollection();
        s.addvolunteer(a1);//הכנסת מתנדבים
        s.addvolunteer(a3);
        s.search(1, 34, "sunday");//בדיקה אם קיים מתנדב כזה
        s.search(2, 40, "friday");
        s.print();//הדפסת המתנדבים
        s.search(1, 34, "sunday");//בדיקה שוב למתנדב כזה אך מכיון שתפוס יחזיר null 
        System.out.println(a3.calcBonus());//בדיקת בונוס
        s.sort();
        s.print();

    }

}
