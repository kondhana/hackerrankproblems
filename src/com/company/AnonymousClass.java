package com.company;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClass {
        List<Person> personList=new ArrayList<>();
        public static void main(String argv[]){
            AnonymousClass anonymousClass=new AnonymousClass();
            anonymousClass.populateList();
            anonymousClass.printLessThan100();
        }

    private void printLessThan100() {
            personList.forEach(this::testAndPrint);
    }

    public void testAndPrint(Person p1){
        if(p1.age<100){
            System.out.println("p = " + p1);
        }
    }


    public void populateList(){
            Person person1=new Person(10,"Aneesh");
            Person person2=new Person(71,"Spruha");
            Person person3=new Person(430,"Mithila");
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);
        }
        class Person{
            int age;
            String name;
            public Person(int age,String name){
                this.age=age;
                this.name=name;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "age=" + age +
                        ", name='" + name + '\'' +
                        '}';
            }
        }
}
