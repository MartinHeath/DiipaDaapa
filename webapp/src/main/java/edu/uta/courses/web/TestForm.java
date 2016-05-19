package edu.uta.courses.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Hannu Lohtander on 9.2.2016.
 */
public class TestForm {

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd.MM.yyyy")
    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    public DateTime test;

    public DateTime getTest() {
        return test;
    }

    public void setTest(DateTime test) {
        this.test = test;
    }
}
