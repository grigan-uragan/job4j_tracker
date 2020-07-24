package ru.job4j.tracker.profession;

import ru.job4j.tracker.profession.Doctor;
import ru.job4j.tracker.profession.Patient;

public class Therapist extends Doctor {
    private String recipe;

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getRecipe() {
        return recipe;
    }

    public void tread(Patient patient) {
        if ("Head".equals(patient.getHurtBodyPart())){
            setRecipe("Analgin");
        } else {
            setRecipe("Drink more water");
        }
        patient.needHelp(patient.getName(), patient.getHurtBodyPart());
        System.out.println("i'm write for you recipe: " + getRecipe());
    }
}
