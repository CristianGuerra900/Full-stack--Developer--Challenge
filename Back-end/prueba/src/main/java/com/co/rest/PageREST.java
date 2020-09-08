package com.co.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.dao.LocationDAO;
import com.co.entitys.Location;

/**
 * @author Cristian Guerra
 * @version 1.0
 * @since 1.0
*/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/locations")
public class PageREST {
	
	@Autowired
	private LocationDAO locationDao;
	
	/** Metodo que consulta y retorna lista completa de locations's.
	 *  @return location correspondiente a id
	 *  @return lista completa de location
	*/
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public ResponseEntity<List<Location>> getLocation() {
		
		List<Location> locations = locationDao.findAll();
		return ResponseEntity.ok(locations);
		
	}
	
	/** Metodo para buscar location por id.
	 * @param locationId identificador del item o registro en BD.
	 * @return location correspondiente a id
	*/
	@RequestMapping(value="/{locationId}", method=RequestMethod.GET)
	public ResponseEntity<Location> getLocationById(@PathVariable("locationId") Long locationId) {
		
		Optional<Location> locations = locationDao.findById(locationId);
		if(locations.isPresent()) {
			return ResponseEntity.ok(locations.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	/** Meto que inserta un nuevo registro de location.
	 * @param locationDAO objeto con datos a crear
	*/
	@PostMapping
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
		
		Location newLocation = locationDao.save(location);
		return ResponseEntity.ok(newLocation);
		
	}
	
	/** Metodo para eliminar un registro de location.
	 * @param locationId identificador del item o registro en BD.
	*/
	@DeleteMapping(value="/{locationId}")
	public ResponseEntity<Location> deleteLocation(@PathVariable("locationId") Long locationId) {
		
		locationDao.deleteById(locationId);
		return ResponseEntity.ok(null);
		
	}
	/** Metodo que actualiza un registro de location seleccionado.
	 * @param locationDAO objeto con datos a modificar
	 * @return location con datos modificados
	*/
	@PutMapping
	public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
		
		Optional<Location> locations = locationDao.findById(location.getId());
		if(locations.isPresent()) {
			Location upgradeLocation = locations.get();
			upgradeLocation.setName(location.getName());
			locationDao.save(upgradeLocation);
			
			Optional<Location> locationGet = locationDao.findById(location.getId());
			return ResponseEntity.ok(locationGet.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
}
