//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.model.document_management;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class Documents implements Serializable {
    @Id
    @SequenceGenerator(
            name = "Documents_sequence",
            sequenceName = "Documents_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Documents_sequence"
    )
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    public Documents() {
    }

    public Documents(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Documents(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
