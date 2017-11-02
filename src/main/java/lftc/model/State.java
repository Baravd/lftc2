package lftc.model;

public class State {
    private String name;
    private Boolean isInitialState;
    private Boolean isFinalState;

    public State(String name, Boolean isInitialState, Boolean isFinalState) {
        this.name = name;
        this.isInitialState = isInitialState;
        this.isFinalState = isFinalState;
    }

    public Boolean getFinalState() {
        return isFinalState;
    }

    public void setFinalState(Boolean finalState) {
        isFinalState = finalState;
    }

    public Boolean getInitialState() {
        return isInitialState;
    }

    public void setInitialState(Boolean initialState) {
        isInitialState = initialState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    public boolean isInitialState() {
        return isInitialState;
    }


    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", isFinalState=" + isFinalState +
                ", isInitialState=" + isInitialState +
                '}'+'\n';
    }
}
