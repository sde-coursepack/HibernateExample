package edu.virginia.sde.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "STATES")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private int id;

    @Column(name="STATE_NAME", unique = true, nullable = false, length = 32)
    private String name;

    @Column(name = "POPULATION", nullable = false)
    private int population;

    @Column(name = "CAPITOL_CITY", nullable = false)
    private String capitolCity;

    public State(String name, int population, String capitolCity) {
        this.name = name;
        this.population = population;
        this.capitolCity = capitolCity;
    }

    public State() {
        // a zero-argument constructor is required for hibernate to work correctly
        // You may have additional constructors, but hibernate will only use the
        // zero argument constructor
    }

    // all fields must have public getters and setters
    // the names must be get[VariableName] and set[VariableName] exactly
    // Just use the IntelliJ generate for Getters and setters, it will create the correct behavior

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapitolCity() {
        return capitolCity;
    }

    public void setCapitolCity(String capitolCity) {
        this.capitolCity = capitolCity;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", capitolCity='" + capitolCity + '\'' +
                '}';
    }
}
