package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface iReservationServices {
    Reservation ajouterReservation (Reservation r);
    Reservation modifierReservation ( Reservation r);
    void deleteReservation(String idReservation);
    Reservation getReservation (String idReservation);

    List<Reservation> getAllReservation();
}
