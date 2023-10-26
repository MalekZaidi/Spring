package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.iReservationServices;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationRestController {
    private final iReservationServices reservationServices;

    @GetMapping("/allreservation")
    public List<Reservation> getAllReservation() {
        return reservationServices.getAllReservation();
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationServices.ajouterReservation(r);
    }

    @PutMapping("/update/{idReservation}")
    public Reservation updateReservation(@PathVariable String idReservation, @RequestBody Reservation updatedReservation) {
        Reservation existingReservation = reservationServices.getReservation(idReservation);

        if (existingReservation != null) {
            // Mettez à jour les attributs de la réservation existante avec les nouvelles valeurs
            existingReservation.setAnneeUniversitaire(updatedReservation.getAnneeUniversitaire());
            existingReservation.setEstValide(updatedReservation.getEstValide());
            existingReservation.setEtudiants(updatedReservation.getEtudiants());

            // Enregistrez la réservation mise à jour
            return reservationServices.modifierReservation(existingReservation);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable String idReservation) {
        Reservation existingReservation = reservationServices.getReservation(idReservation);

        if (existingReservation != null) {
            // Supprimez la réservation en utilisant le service
            reservationServices.deleteReservation(idReservation);
        } else {
            log.warn("N'existe pas");
        }
    }
}

