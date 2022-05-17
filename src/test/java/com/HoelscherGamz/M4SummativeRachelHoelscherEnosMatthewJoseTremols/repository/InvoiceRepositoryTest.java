package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class InvoiceRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    TShirtRepository tShirtRepository;
    @Autowired
    SalesTaxRepository salesTaxRepository;
    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();
        gameRepository.deleteAll();
        tShirtRepository.deleteAll();
        salesTaxRepository.deleteAll();
        processingFeeRepository.deleteAll();
    }

    @Test
    public void addGetDeleteInventory() {
//
    }
    /*

        @Test
    public void addGetDeleteAlbum() {

        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Optional<Album> album1 = albumRepository.findById(album.getId());

        assertEquals(album1.get(), album);

        albumRepository.deleteById(album.getId());

        album1 = albumRepository.findById(album.getId());

        assertFalse(album1.isPresent());

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(54);
        album.setLabelId(91);
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

    }

    @Test
    public void getAllAlbums() {

        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        album = new Album();
        album.setTitle("Leftovers");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2012, 4, 5));
        album.setListPrice(new BigDecimal("18.95"));

        album = albumRepository.save(album);

        List<Album> aList = albumRepository.findAll();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateAlbum() {

        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 1));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        album.setTitle("NEW TITLE");
        album.setReleaseDate(LocalDate.of(2000, 7, 7));
        album.setListPrice(new BigDecimal("15.68"));

        albumRepository.save(album);

        Optional<Album> album1 = albumRepository.findById(album.getId());
        assertEquals(album1.get(), album);

    }
     */
}