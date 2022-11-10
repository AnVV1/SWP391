package com.c0821g1.sprint1.entity.space;


import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@NamedNativeQuery(name = "Spaces.findAllSpace",
        query = "select s.space_id as spaceId, s.space_code as spaceCode, st.space_type_name as spaceTypeName, s.space_area as spaceArea, stt.spacer_status_name as spaceStatusName, s.space_price as spacePrice, s.space_manager_fee as spaceManagerFee, f.floor_name as floorName\n" +
                "from spaces s \n" +
                "join spaces_type st on s.space_type_id = st.space_type_id\n" +
                "join spaces_status stt on s.space_status_id = stt.space_status_id\n" +
                "JOIN floors f ON s.floor_id = f.floor_id \n" +
                "where s.space_delete_flag = 0",
        resultSetMapping = "Mapping.SpaceListDTO")
@NamedNativeQuery(name = "Spaces.searchSpace",
        query = "SELECT s.space_id AS spaceId, s.space_code AS spaceCode, st.space_type_name AS spaceTypeName, s.space_area AS spaceArea, stt.spacer_status_name AS spaceStatusName, s.space_price AS spacePrice, s.space_manager_fee AS spaceManagerFee, f.floor_name as floorName\n" +
                "FROM spaces s \n" +
                "JOIN floors f ON s.floor_id = f.floor_id \n" +
                "JOIN spaces_type st ON st.space_type_id = s.space_type_id \n" +
                "JOIN spaces_status stt ON stt.space_status_id = s.space_status_id\n" +
                "WHERE f.floor_name LIKE concat('%',?1,'%') AND \n" +
                "s.space_code LIKE concat('%',?2,'%') AND\n" +
                "s.space_area LIKE concat('%',?3,'%') AND\n" +
                "st.space_type_name LIKE concat('%',?4,'%') AND\n" +
                "stt.spacer_status_name LIKE concat('%',?5,'%') AND\n" +
                "s.space_delete_flag = 0 ",
        resultSetMapping = "Mapping.SpaceListDTO")
@NamedNativeQuery(name = "Spaces.findSpaceById",
        query = "SELECT s.space_id AS spaceId, s.space_code AS spaceCode, st.space_type_name AS spaceTypeName, s.space_area AS spaceArea, stt.spacer_status_name AS spaceStatusName, s.space_price AS spacePrice, s.space_manager_fee AS spaceManagerFee, f.floor_name as floorName\n" +
                "from spaces s \n" +
                "join spaces_type st on s.space_type_id = st.space_type_id\n" +
                "join spaces_status stt on s.space_status_id = stt.space_status_id\n" +
                "JOIN floors f ON s.floor_id = f.floor_id " +
                "where s.space_id = ?1",
        resultSetMapping = "Mapping.SpaceListDTO")
@SqlResultSetMapping(name = "Mapping.SpaceListDTO",
        classes = @ConstructorResult(targetClass = SpaceListDTO.class,
                columns = {@ColumnResult(name = "spaceId"),
                        @ColumnResult(name = "spaceCode"),
                        @ColumnResult(name = "spaceTypeName"),
                        @ColumnResult(name = "spaceArea"),
                        @ColumnResult(name = "spaceStatusName"),
                        @ColumnResult(name = "spacePrice"),
                        @ColumnResult(name = "spaceManagerFee"),
                        @ColumnResult(name = "floorName")
                }))

@Entity
public class Spaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spaceId;
    private String spaceCode;
    private String spaceArea;
    private String spacePrice;
    private String spaceManagerFee;
    private String spaceNote;
    private String spaceImage;
    private Boolean spaceDeleteFlag;

    @ManyToOne
    @JoinColumn(name = "space_type_id",nullable = false)
    private SpacesType spacesType;

    @ManyToOne
    @JoinColumn(name = "space_status_id",nullable = false)
    private SpacesStatus spaceStatus;

    @ManyToOne
    @JoinColumn(name = "floor_id",nullable = false)
    private Floors floors;


    @JsonBackReference
    @OneToMany(mappedBy = "spaces")
    private List<Contract> contractList;

    public Spaces() {
    }

    public Spaces(int spaceId, String spaceCode, String spaceArea, String spacePrice, String spaceManagerFee, String spaceNote, String spaceImage, Boolean spaceDeleteFlag, SpacesType spacesType, SpacesStatus spaceStatus, Floors floors, List<Contract> contractList) {
        this.spaceId = spaceId;
        this.spaceCode = spaceCode;
        this.spaceArea = spaceArea;
        this.spacePrice = spacePrice;
        this.spaceManagerFee = spaceManagerFee;
        this.spaceNote = spaceNote;
        this.spaceImage = spaceImage;
        this.spaceDeleteFlag = spaceDeleteFlag;
        this.spacesType = spacesType;
        this.spaceStatus = spaceStatus;
        this.floors = floors;
        this.contractList = contractList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Floors getFloors() {
        return floors;
    }

    public void setFloors(Floors floors) {
        this.floors = floors;
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

    public String getSpaceArea() {
        return spaceArea;
    }

    public void setSpaceArea(String spaceArea) {
        this.spaceArea = spaceArea;
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

    public String getSpaceNote() {
        return spaceNote;
    }

    public void setSpaceNote(String spaceNote) {
        this.spaceNote = spaceNote;
    }

    public String getSpaceImage() {
        return spaceImage;
    }

    public void setSpaceImage(String spaceImage) {
        this.spaceImage = spaceImage;
    }

    public Boolean getSpaceDeleteFlag() {
        return spaceDeleteFlag;
    }

    public void setSpaceDeleteFlag(Boolean spaceDeleteFlag) {
        this.spaceDeleteFlag = spaceDeleteFlag;
    }

    public SpacesType getSpacesType() {
        return spacesType;
    }

    public void setSpacesType(SpacesType spacesType) {
        this.spacesType = spacesType;
    }

    public SpacesStatus getSpaceStatus() {
        return spaceStatus;
    }

    public void setSpaceStatus(SpacesStatus spaceStatus) {
        this.spaceStatus = spaceStatus;
    }
}
