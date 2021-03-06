package ru.job4j.tracker.profession;

public class CarMechanic extends Engineer {
    private String trouble;

    public String getTrouble() {
        return trouble;
    }

    public void setTrouble(String trouble) {
        this.trouble = trouble;
    }

    public void fix(Client client) {
        if (client.getId() % 2 == 0) {
            trouble = "You need change engine oil";
        } else {
            trouble = "In your carburator, condensate!";
        }
        System.out.println("We have one problem with your car! " + getTrouble());
    }
}
