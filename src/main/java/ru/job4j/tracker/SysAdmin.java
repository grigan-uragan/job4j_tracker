package ru.job4j.tracker;

public class SysAdmin extends Engineer {
    private String operationSystem;

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void fix(Client client){
        if (client.getId() % 2 == 0) {
            setOperationSystem("Windows");
        } else {
            setOperationSystem("Linux");
        }
        System.out.println("You need reinstall " + getOperationSystem());
    }
}
