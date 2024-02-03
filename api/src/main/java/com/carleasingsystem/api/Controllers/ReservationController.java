
package com.carleasingsystem.api.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.carleasingsystem.api.Entities.Reservation;
import com.carleasingsystem.api.Service.ReservationService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cls")
public class ReservationController 
{	
    @Autowired
	private ReservationService reservationService;

	@GetMapping("/reservation") //reservation get
	public List<Reservation> getJpa()
	{
		return reservationService.getJpa();
	}

	@PostMapping("/reservation") //reservation to reserve or store
	public Reservation saveJpa(@RequestBody Reservation reservation)
	{
		return reservationService.saveJpa(reservation);
	}

	@GetMapping("/reservation/{id}") //to get one reservation
	public Reservation getJpaById(@PathVariable("id") Long id)
	{
		
		return reservationService.getJpaById(id);
	}

	@PutMapping("/reservation/{id}") //to update one reservation
	public Reservation updateJpa(@PathVariable("id") Long Id, @RequestBody Reservation reservation)
	{	 
		return reservationService.updateJpa(Id, reservation);
	}

	@DeleteMapping("/reservation/{id}") //delete
	public String deleteJpaById(@PathVariable("id") Long id)
	{
		return reservationService.deleteJpaById(id);
	}
}