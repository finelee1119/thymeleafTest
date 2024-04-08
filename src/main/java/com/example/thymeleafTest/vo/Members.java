package com.example.thymeleafTest.vo;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Members {
    private int id;
    private String name;
    private String addr;
    private LocalDateTime created_at;

    public Members(int id, String name, String addr, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.created_at = created_at;
    }

    public static Members of(int id, String name, String addr, LocalDateTime created_at) {
        return new Members(id, name, addr, created_at);
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}