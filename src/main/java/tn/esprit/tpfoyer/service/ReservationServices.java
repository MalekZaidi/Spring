package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.iReservationRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServices implements iReservationServices{
   final iReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation modifierReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElseGet(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return (List<Reservation>)reservationRepository.findAll();
    }
}
