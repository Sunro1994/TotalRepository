package com.sunro.rest.webservices.restfulwebservices.model;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public PersonV2(String bobCharlie) {
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }
}
