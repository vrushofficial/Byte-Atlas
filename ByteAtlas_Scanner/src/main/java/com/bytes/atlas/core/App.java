package com.bytes.atlas.core;

import com.bytes.atlas.domain.FileHandler;
import com.bytes.atlas.model.Project;
import com.bytes.atlas.utils.ErrorMessages;
import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Optional;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);

    static void execute(Project project) {

        LOGGER.info("Analyzing project " + project.getProjectKey() + "...");
        LOGGER.info("Found source path " + project.getSourcePath());

        new FileHandler().readFiles(project);

    }

    /**
     * java -DprojectKey=ACC -DsourcePath=E:\Development\algorithemic-complexity-calculator -jar core-1.0-SNAPSHOT-jar-with-dependencies.jar
     *
     * @param args
     */
    public static void main(String[] args) {

        org.apache.log4j.PropertyConfigurator.configure("config/log4j.properties");
        LOGGER.debug("ACCScanner start analyzing...");

        Optional<String> projectKey = Optional.ofNullable(System.getProperty("projectKey"));
        Optional<String> sourcePath = Optional.ofNullable(System.getProperty("sourcePath"));

        Project project = new Project();
        if (projectKey.isPresent()) {
            project.setProjectKey(projectKey.get());
        } else {
            LOGGER.error(ErrorMessages.PK_NOT_FOUND_ERR);
            throw new NoSuchElementException(ErrorMessages.PK_NOT_FOUND_ERR);
        }
        if (sourcePath.isPresent()) {
            project.setSourcePath(sourcePath.get());
        } else {
            LOGGER.error(ErrorMessages.SP_NOT_FOUND_ERR);
            throw new NoSuchElementException(ErrorMessages.SP_NOT_FOUND_ERR);
        }

        execute(project);

    }
}
