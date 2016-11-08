package org.vpk.rmt.serviceproviders.buienradar.client.stub;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.xml.sax.SAXException;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;

/**
 * Created by Pieter on 8-11-2016.
 */
public class BuienradarClientStub implements BuienradarClient {

    private static final transient Logger LOG = LoggerFactory.getLogger(BuienradarClientStub.class);

    private String date;

    public BuienradarClientStub(String date) {
        this.date = date;
    }

    @Override
    public Buienradarnl getBuienradarnl() {
        return get(date);
    }

    private static Buienradarnl get(String date) {
        return unmarshalBuienradarnlXml("buienradarnl-" + date + ".xml");
    }

    private static Buienradarnl unmarshalBuienradarnlXml(String filename) {
        Buienradarnl buienradarnl = new Buienradarnl();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Buienradarnl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            InputStream fileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            buienradarnl = (Buienradarnl) unmarshaller.unmarshal(fileStream);

            InputStream schemaStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("buienradar.xsd");
            if (schemaStream != null) { // if schema present validate xml
                Source fileSource = new StreamSource(fileStream);
                Source schemaSource = new StreamSource(schemaStream);
                SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = schemaFactory.newSchema(schemaSource);
                Validator validator = schema.newValidator();
                validator.validate(fileSource);
            }

        } catch (JAXBException | SAXException | IOException e) {
            LOG.debug("Unable to parse xml data", e);
        }
        return buienradarnl;
    }
}
