package com.company;

import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */


class StudentComparator implements Comparator<Student1>{

    @Override
    public int compare(Student1 s1, Student1 s2) {
        if(s1.cgpa>s2.cgpa){
            return -1;
        }
        else if (s1.cgpa<s2.cgpa){
            return 1;
        }
        else if(s1.cgpa==s2.cgpa){
            int stCompareResult=s1.name.compareTo(s2.name);
            if(stCompareResult!=0){
                return stCompareResult;
            }
            else{
                if(s1.id>s2.id){
                    return 1;
                }
                else if(s1.id<s2.id){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
        return 0;
    }
 }

class Student1 implements Comparable<Student1>{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

    String name;
    double cgpa;
    public Student1(int id, String name, double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }


    @Override
    public int compareTo(Student1 s2) {
        Student1 s1=this;
        if(s1.cgpa>s2.cgpa){
            return -1;
        }
        else if (s1.cgpa<s2.cgpa){
            return 1;
        }
        else if(s1.cgpa==s2.cgpa){
            int stCompareResult=s1.name.compareTo(s2.name);
            if(stCompareResult!=0){
                return stCompareResult;
            }
            else{
                if(s1.id>s2.id){
                    return 1;
                }
                else if(s1.id<s2.id){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
        return 0;
    }
}

class Priorities{


    public static List<Student1> getStudents(List<String> events){
        PriorityQueue<Student1> queue=new PriorityQueue(10);
        events.forEach(event->{
            String[] eventData=event.split(" ");
            String action =eventData[0];

            if("ENTER".equals(action)){
                String name=eventData[1];
                double cgpa =Double.valueOf(eventData[2]);
                int id=Integer.valueOf(eventData[3]);
                Student1 st=new Student1(id,name,cgpa);
                queue.offer(st);
            }
            else if("SERVED".equals(action)){
                Student1 student1=queue.poll();
                System.out.println("student1 = " + student1);
            }
        });
        List<Student1> student1List=new ArrayList<>();
        while(!queue.isEmpty()){
            student1List.add(queue.poll());
        }
        return student1List;
    }
}


public class PriorityQueueProblem {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student1> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student1 st: students) {
                System.out.println(st.getName());
            }
        }
    }
}