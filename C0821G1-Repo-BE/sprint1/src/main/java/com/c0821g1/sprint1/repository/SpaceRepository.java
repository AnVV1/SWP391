package com.c0821g1.sprint1.repository;
import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface SpaceRepository extends JpaRepository<Spaces, Integer> {
    @Query(nativeQuery = true)
    List<SpaceListDTO> findAllSpace();

    @Query(nativeQuery = true)
    SpaceListDTO findSpaceById(Integer spaceId);

    @Modifying
    @Transactional
    @Query(value = "update  spaces\n" +
            "set spaces.space_delete_flag = 1\n" +
            "where spaces.space_id = ?1 ", nativeQuery = true)
    void deleteSpaceById(Integer id);

    @Query(nativeQuery = true)
    List<SpaceListDTO> searchSpace(String floorName, String spaceCode, String spaceArea,
                                   String spaceTypeName, String spaceStatusName);



    @Modifying
    @Transactional
    @Query(value = "insert into spaces (floor_id, space_area, space_code, space_delete_flag, space_image, " +
            "space_manager_fee, space_note, space_price, space_status_id, space_type_id) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    void saveSpace(Integer floor_id, String space_area, String space_code, Boolean space_delete_flag,
                   String space_image, String space_manager_fee, String space_note,
                   String space_price, Integer space_status_id, Integer space_type_id);


    @Modifying
    @Transactional
    @Query(value = "update spaces set floor_id=?, space_area=?, space_code=?, space_delete_flag=?, " +
            "space_image=?, space_manager_fee=?, space_note=?, space_price=?, space_status_id=?, " +
            "space_type_id=? where space_id=?", nativeQuery = true)
    void editSpace(Integer floor_id, String space_area, String space_code, Boolean space_delete_flag,
                   String space_image, String space_manager_fee, String space_note,
                   String space_price, Integer space_status_id, Integer space_type_id, Integer space_id);

    @Query(value = "SELECT * " +
            "from spaces  " +
            "where space_code =?1", nativeQuery = true)
    Spaces existsSpaceByCode(String spaceCode);
}