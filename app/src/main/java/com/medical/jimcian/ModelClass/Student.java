package com.medical.jimcian.ModelClass;

public class Student {

    String name;
    String id;
    String sex;
    String phone;
    String bloodgroup;
    String country;
    String btach;

    int dateofbirth;

    public static  Student iam;

    public static Student getInstance(){
        if (iam==null)
            iam=new Student();
        return  iam;
    }

    public Student() {

    }

    public Student(String id,String name, String sex, String phone, String bloodgroup, String country, String btach, int dateofbirth) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.bloodgroup = bloodgroup;
        this.country = country;
        this.btach = btach;
        this.dateofbirth = dateofbirth;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBtach() {
        return btach;
    }

    public void setBtach(String btach) {
        this.btach = btach;
    }

    public int getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(int dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
