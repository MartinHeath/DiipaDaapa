/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uta.courses.repository.impl;
import edu.uta.courses.repository.HelloRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Martin
 */
@Repository("helloRepository")
public class HelloRepositoryImpl implements HelloRepository {
    
    @PersistenceContext(name = "entityManager")
    EntityManager em;

        public String getNow() {
            
            DateTime d = new DateTime();
            DateTimeFormatter ftm = DateTimeFormat.forPattern("HH:mm, DD.MM.YYYY");
            return ftm.print(d);
    }
}
