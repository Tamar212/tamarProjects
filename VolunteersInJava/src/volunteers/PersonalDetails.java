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
public class PersonalDetails {

    private long id;
    private int age;
    private String name;
    private String familyName;

    public PersonalDetails(long id, int age, String name, String familyName) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.familyName = familyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return " PersonalDetails{" + "id= " + id + ", age= " + age + ", name= " + name + ", familyName= " + familyName + '}';
    }

}
