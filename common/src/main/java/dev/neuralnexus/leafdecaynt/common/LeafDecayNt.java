package dev.neuralnexus.leafdecaynt.common;

import dev.dejvokep.boostedyaml.YamlDocument;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LeafDecayNt {
    /**
     * Properties of the LeafDecayNt class.
     * instance: The singleton instance of the LeafDecayNt class
     * config: The config file
     * logger: The logger
     * STARTED: Whether the LeafDecayNt has been started
     */
    private static final LeafDecayNt instance = new LeafDecayNt();
    private static YamlDocument config;
    private static Object logger;
    private static String configPath;
    private static boolean STARTED = false;
    public static boolean cancelDecay = false;

    /**
     * Constructor for the LeafDecayNt class.
     */
    public LeafDecayNt() {}

    /**
     * Getter for the singleton instance of the LeafDecayNt class.
     * @return The singleton instance
     */
    public static LeafDecayNt getInstance() {
        return instance;
    }

    /**
     * Use whatever logger is being used.
     * @param message The message to log
     */
    public static void useLogger(String message) {
        if (logger instanceof java.util.logging.Logger) {
            ((java.util.logging.Logger) logger).info(message);
        } else if (logger instanceof org.slf4j.Logger) {
            ((org.slf4j.Logger) logger).info(message);
        } else {
            System.out.println(message);
        }
    }

    /**
     * Start LeafDecayNt
     * @param configPath The path to the config file
     * @param logger The logger
     */
    public static void start(String configPath, Object logger) {
        LeafDecayNt.configPath = configPath;
        LeafDecayNt.logger = logger;

        // Config
        try {
            config = YamlDocument.create(new File("." + File.separator + configPath + File.separator + "LeafDecayNt", "config.yml"),
                    Objects.requireNonNull(LeafDecayNt.class.getClassLoader().getResourceAsStream("config.yml"))
            );
            config.reload();
        } catch (IOException | NullPointerException e) {
            useLogger("Failed to load config.yml!\n" + e.getMessage());
            e.printStackTrace();
        }

        if (STARTED) {
            useLogger("[LeafDecayNt] LeafDecayNt has already started!");
            return;
        }
        STARTED = true;

        cancelDecay = config.getBoolean("preventDecay");

        useLogger("[LeafDecayNt] LeafDecayNt has been started!");
    }

    /**
     * Start LeafDecayNt
     */
    public static void start() {
        start(configPath, logger);
    }

    /**
     * Stop LeafDecayNt
     */
    public static void stop() {
        if (!STARTED) {
            useLogger("[LeafDecayNt] LeafDecayNt has already stopped!");
            return;
        }
        STARTED = false;

        useLogger("[LeafDecayNt] LeafDecayNt has been stopped!");
    }
}
