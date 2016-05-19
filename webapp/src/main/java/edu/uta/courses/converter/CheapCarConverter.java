package edu.uta.courses.converter;

import edu.uta.courses.web.CheapCar;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Hannu Lohtander on 4.3.2016.
 */

public class CheapCarConverter implements Converter<String, CheapCar> {

    public CheapCarConverter() {}

    @Override
    public CheapCar convert(String source) {
        CheapCar cc = new CheapCar();
        cc.setModel(source);
        return cc;
    }



}

