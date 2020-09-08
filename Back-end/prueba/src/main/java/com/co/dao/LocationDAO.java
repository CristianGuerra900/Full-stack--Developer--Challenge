package com.co.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.entitys.Location;

/**
 * @author Cristian Guerra
 * @version 1.0
 * @since 1.0
*/
public interface LocationDAO extends JpaRepository<Location, Long>{

}
