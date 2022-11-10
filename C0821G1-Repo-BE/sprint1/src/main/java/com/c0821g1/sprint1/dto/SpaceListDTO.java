package com.c0821g1.sprint1.dto;

public class SpaceListDTO {
    private int spaceId;
    private String spaceCode;
    private String spaceTypeName;
    private String spaceArea;
    private String spaceStatusName;
    private String spacePrice;
    private String spaceManagerFee;
    private String floorName;

    public SpaceListDTO() {
    }

    public SpaceListDTO(int spaceId, String spaceCode, String spaceTypeName, String spaceArea, String spaceStatusName, String spacePrice, String spaceManagerFee, String floorName) {
        this.spaceId = spaceId;
        this.spaceCode = spaceCode;
        this.spaceTypeName = spaceTypeName;
        this.spaceArea = spaceArea;
        this.spaceStatusName = spaceStatusName;
        this.spacePrice = spacePrice;
        this.spaceManagerFee = spaceManagerFee;
        this.floorName = floorName;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode;
    }

    public String getSpaceTypeName() {
        return spaceTypeName;
    }

    public void setSpaceTypeName(String spaceTypeName) {
        this.spaceTypeName = spaceTypeName;
    }

    public String getSpaceArea() {
        return spaceArea;
    }

    public void setSpaceArea(String spaceArea) {
        this.spaceArea = spaceArea;
    }

    public String getSpaceStatusName() {
        return spaceStatusName;
    }

    public void setSpaceStatusName(String spaceStatusName) {
        this.spaceStatusName = spaceStatusName;
    }

    public String getSpacePrice() {
        return spacePrice;
    }

    public void setSpacePrice(String spacePrice) {
        this.spacePrice = spacePrice;
    }

    public String getSpaceManagerFee() {
        return spaceManagerFee;
    }

    public void setSpaceManagerFee(String spaceManagerFee) {
        this.spaceManagerFee = spaceManagerFee;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
}