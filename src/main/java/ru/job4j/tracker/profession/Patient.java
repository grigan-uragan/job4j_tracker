package ru.job4j.tracker.profession;

public class Patient {
    private String name;
    private String hurtBodyPart;

    public Patient(String name, String hurtBodyPart) {
        this.name = name;
        this.hurtBodyPart = hurtBodyPart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHurtBodyPart() {
        return hurtBodyPart;
    }

    public void setHurtBodyPart(String hurtBodyPart) {
        this.hurtBodyPart = hurtBodyPart;
    }

    public void needHelp(String name, String hurtBodyPart) {
        System.out.println("Hello Doctor, I'm " + name + " please look on my " + hurtBodyPart
                + " it hurts a lot!!!");
    }
}
