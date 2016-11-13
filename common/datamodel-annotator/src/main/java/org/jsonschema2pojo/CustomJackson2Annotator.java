package org.jsonschema2pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;

public class CustomJackson2Annotator extends Jackson2Annotator {

    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
        clazz.annotate(JsonInclude.class).param("value", JsonInclude.Include.NON_EMPTY);
    }
}
