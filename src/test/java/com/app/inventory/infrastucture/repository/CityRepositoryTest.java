package com.app.inventory.infrastucture.repository;

import com.app.inventory.infrastucture.provider.jpa.CityRepository;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;
    /*
    @Test
    public void saveTest() {

       CountryEntity country = CountryEntity.builder().name("Chile").build();
        //cityRepository.save(country);

        StateEntity state = StateEntity.builder().country(country).name("Region Metropolitana").build();
        CityEntity city = CityEntity.builder().name("test").
                city.save(student);
        Student found = studentDB.findById(student.getId()).get();
        assertEquals(student, found);
    }

    @Test
    public void findTest() {
        CityEntity city = CityEntity.builder().name("test").
                studentDB.save(student);
        Student found = studentDB.findById(student.getId()).get();
        assertEquals(student, found);
    }

    @Test
    public void updateTest() {
        CityEntity city = CityEntity.builder().name("test").
                studentDB.save(student);
        Student found = studentDB.findById(student.getId()).get();
        assertEquals(student, found);
    }

    @Test
    public void deleteTest() {
        CityEntity city = CityEntity.builder().name("test").
                studentDB.save(student);
        Student found = studentDB.findById(student.getId()).get();
        assertEquals(student, found);
    }*/



}
