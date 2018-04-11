package com.yaro.web.texec.script;

import java.util.List;

/**
 * @author v-yshneykin
 * @since 4/3/18
 */
public class Validator {

    public void validateConfiguration(List<String> lines) throws ValidationException {
        if (lines == null || lines.size() == 0) {
            throw new ValidationException("Empty script configuration.");
        }
    }

    public void validateTransaction(List<String> properties) throws ValidationException {
        if (properties == null || properties.size() == 0) {
            throw new ValidationException("Invalid transaction.");
        }
    }

    public void validateDefinition(String[] definition) throws ValidationException {
        if (definition.length < 2) {

        }
    }
}
