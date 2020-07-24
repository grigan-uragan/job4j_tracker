package ru.job4j.tracker;

public class Dentist extends Doctor {
    private String assistantName;

    public Dentist(String assistantName) {
        super();
        this.assistantName = assistantName;
    }

    public void tread(Patient patient) {
        patient.needHelp(patient.getName(), patient.getHurtBodyPart());
        System.out.println("Open your mouth ... " +  assistantName + " Hand me the Tongs!!!");
    }
}
