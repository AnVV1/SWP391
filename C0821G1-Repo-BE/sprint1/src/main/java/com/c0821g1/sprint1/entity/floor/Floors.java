package com.c0821g1.sprint1.entity.floor;

import com.c0821g1.sprint1.entity.space.Spaces;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.util.List;

@Entity
public class Floors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorId;
    private String floorCode;
    private String floorName;
    private String floorArea;
    private String floorCapacity;

    private Boolean floorDeleteFlag;

    @ManyToOne
    @JoinColumn(name = "floor_type_id",nullable = false)
    private FloorsType floorsType;

    @ManyToOne
    @JoinColumn(name = "floor_status_id",nullable = false)
    private FloorsStatus floorsStatus;


    @JsonBackReference
    @OneToMany(mappedBy = "floors")
    private List<Spaces> spacesList;

    public Floors() {
    }

    public Floors(int floorId, String floorCode, String floorName, String floorArea, String floorCapacity, Boolean floorDeleteFlag, FloorsType floorsType, FloorsStatus floorsStatus, List<Spaces> spacesList) {
        this.floorId = floorId;
        this.floorCode = floorCode;
        this.floorName = floorName;
        this.floorArea = floorArea;
        this.floorCapacity = floorCapacity;
        this.floorDeleteFlag = floorDeleteFlag;
        this.floorsType = floorsType;
        this.floorsStatus = floorsStatus;
        this.spacesList = spacesList;
    }

    public FloorsStatus getFloorsStatus() {
        return floorsStatus;
    }

    public void setFloorsStatus(FloorsStatus floorsStatus) {
        this.floorsStatus = floorsStatus;
    }

    public List<Spaces> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(List<Spaces> spacesList) {
        this.spacesList = spacesList;
    }

    public Boolean getFloorDeleteFlag() {
        return floorDeleteFlag;
    }

    public void setFloorDeleteFlag(Boolean floorDeleteFlag) {
        this.floorDeleteFlag = floorDeleteFlag;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea;
    }

    public String getFloorCapacity() {
        return floorCapacity;
    }

    public void setFloorCapacity(String floorCapacity) {
        this.floorCapacity = floorCapacity;
    }

    public FloorsType getFloorsType() {
        return floorsType;
    }

    public void setFloorsType(FloorsType floorsType) {
        this.floorsType = floorsType;
    }
}
