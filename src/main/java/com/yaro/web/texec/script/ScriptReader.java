package com.yaro.web.texec.script;

import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author v-yshneykin
 * @since 4/3/18
 */
public class ScriptReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScriptReader.class);

    private static final String DELIMITER = "\t";
    private static final Splitter TAB_SPLITTER = Splitter.on(DELIMITER);

    private final Validator validator;

    public ScriptReader(Validator validator) {
        this.validator = validator;
    }

    public Script read(String filePath) throws IOException, ValidationException {
        LOGGER.info("Reading file: %s", filePath);
        try (Stream<String> linesStream = Files.lines(Paths.get(filePath))) {
            return buildScript(linesStream.collect(Collectors.toList()));
        }
    }

    private Script buildScript(List<String> lines) throws ValidationException {
        validator.validateConfiguration(lines);
        String[] definition = lines.get(0).split(String.valueOf(DELIMITER));
        validator.validateDefinition(definition);
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            List<String> transactionValues = TAB_SPLITTER.limit(2).splitToList(lines.get(i));
            validator.validateTransaction(transactionValues);
            transactions.add(
                    new Transaction(transactionValues.get(0), TAB_SPLITTER.splitToList(transactionValues.get(1))));
        }
        return new Script(definition[0], Long.valueOf(definition[1]), transactions);
    }
}
