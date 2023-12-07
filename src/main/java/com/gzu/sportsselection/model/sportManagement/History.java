package com.gzu.sportsselection.model.sportManagement;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table
public class History {
    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "property_sequence"
    )
    private Long id;

    private String title,sportName,dateAdded;

    @Column(length = 1000)
    private String desciption;

    public History() {
    }

    public History(String title, String desciption, String sportName, String dateAdded) {
        this.title = title;
        this.desciption = desciption;
        this.sportName = sportName;
        this.dateAdded = dateAdded;
    }

    public History(Long id, String title, String desciption, String sportName, String dateAdded) {
        this.id = id;
        this.title = title;
        this.desciption = desciption;
        this.sportName = sportName;
        this.dateAdded = dateAdded;
    }

    public History(Long id, String title, String desciption, String sportName) {
        this.id = id;
        this.title = title;
        this.desciption = desciption;
        this.sportName = sportName;
    }

    public History(String title, String desciption, String sportName) {
        this.title = title;
        this.desciption = desciption;
        this.sportName = sportName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
