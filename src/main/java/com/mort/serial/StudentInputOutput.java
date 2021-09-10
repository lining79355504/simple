package com.mort.serial;

import java.io.File;

/**
 * Created by suoer on 1/20/17.
 */
public class StudentInputOutput {

    private Student student ;

    private File file ;


    public  StudentInputOutput(){
        student = new Student() ;
        student.setAge(23);
        student.setName("mort");
        file = new File("./serialTest.txt");
    }

    public void input(){
        try {

            //Fil

        }catch (Exception e){

        }

    }


    public void output(){

        try {

        }catch (Exception e){

        }

    }
}
