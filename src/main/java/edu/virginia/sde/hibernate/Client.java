package edu.virginia.sde.hibernate;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="ADDRESS", nullable = false)
    private String address;

    @Column(name="EMAIL", nullable = false)
    private String email;

    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts;

    public Client(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Client() {
        accounts = new ArrayList<>();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        if (contains(account)) {
            return false;
        }
        accounts.add(account);
        return true;
    }

    public boolean contains(Account account) {
        return accounts.contains(account);
    }

    public boolean remove(Account account) {
        return accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
