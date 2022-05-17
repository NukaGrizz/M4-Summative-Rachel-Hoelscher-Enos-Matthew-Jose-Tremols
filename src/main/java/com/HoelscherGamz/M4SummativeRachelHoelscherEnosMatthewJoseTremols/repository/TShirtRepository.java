package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Integer> {

    //Search for T-shirts by color.
    List<TShirt> findByColor(String color);

    //Search for T-shirts by size.
    List<TShirt> findBySize(String size);
}
