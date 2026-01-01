package com.repoviewer.domain;

import jakarta.persistence.*;

@Entity
@Table(name="COMMIT_DATA")
public class CommitData {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
