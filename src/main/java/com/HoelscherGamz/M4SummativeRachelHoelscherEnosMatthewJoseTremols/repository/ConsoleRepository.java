package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Console;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console,Long> {

    //Search for consoles by manufacturer.
    List<Console> findByManufacturer(String manufacturer);



}
