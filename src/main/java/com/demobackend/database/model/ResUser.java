package com.demobackend.database.model;

public class ResUser {
    private User user;
    private Boolean loggedIn;

    public ResUser(User user, Boolean loggedIn) {
        this.user = user;
        this.loggedIn = loggedIn;
    }

    public User getUser() {
        return user;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
