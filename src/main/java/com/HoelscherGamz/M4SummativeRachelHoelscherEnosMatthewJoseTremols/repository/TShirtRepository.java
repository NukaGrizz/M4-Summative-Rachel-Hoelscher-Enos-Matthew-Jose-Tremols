package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirts, Integer> {

    //Search for T-shirts by color.
    List<TShirts> findByColor(String color);

    //Search for T-shirts by size.
    List<TShirts> findBySize(String size);
}
