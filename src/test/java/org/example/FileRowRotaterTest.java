package org.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileRowRotaterTest {
    public static final String DATA_PATH = "src/main/resources/";
    public static final String TXT = ".txt";

    @Test
    @Order(1)
    void fileWithCorrectNameWasCreatedTest() throws IOException {
        String file = "input1";
        String inPath = DATA_PATH + file + TXT;
        String outPath = DATA_PATH + file + ".rotated" + TXT;
        deleteIfExists(outPath);
        FileRowRotater rotater = new FileRowRotater(inPath);
        rotater.rotateRows();

        File out = new File(outPath);
        assertThat(out).exists();
    }

    @Test
    @Order(2)
    void firstInputTest() throws IOException {
        String file = "input1";
        String inPath = DATA_PATH + file + TXT;
        String outPath = DATA_PATH + file + ".rotated" + TXT;
        deleteIfExists(outPath);

        FileRowRotater rotater = new FileRowRotater(inPath);
        rotater.rotateRows();

        File out = new File(outPath);
        assertThat(out)
                .exists()
                .content()
                .hasLineCount(1)
                .contains("A szőlő finom");
    }

    @Test
    @Order(3)
    void secondInputTest() throws IOException {
        String file = "input2";
        String inPath = DATA_PATH + file + TXT;
        String outPath = DATA_PATH + file + ".rotated" + TXT;
        deleteIfExists(outPath);

        FileRowRotater rotater = new FileRowRotater(inPath);
        rotater.rotateRows();

        File out = new File(outPath);
        assertThat(out)
                .exists()
                .content()
                .hasLineCount(6)
                .containsSubsequence(List.of("A szőlő finom",
                        "Kerekasztal",
                        "Ma jó napom van",
                        "A",
                        "Fekete bika pata",
                        "Boborján   a   jeti"));
    }

    @Test
    @Order(4)
    void thirdInputTest() throws IOException {
        String file = "input3";
        String inPath = DATA_PATH + file + TXT;
        String outPath = DATA_PATH + file + ".rotated" + TXT;
        deleteIfExists(outPath);

        FileRowRotater rotater = new FileRowRotater(inPath);
        rotater.rotateRows();

        File out = new File(outPath);
        assertThat(out)
                .exists()
                .content()
                .hasLineCount(5)
                .containsSubsequence(List.of("A húsleves állati eredetű húsból csontból és zöldségekből készített leves",
                        "A húsleves a magyar gasztronómia általánosan ismert vasárnapi és ünnepnapi étele",
                        "A lakodalmi vacsora első fogása",
                        "Készülhet marha sertés kacsa kakas vagy tyúkhúsból",
                        "Teljesen különálló ízvilágot képviselnek a füstölt húsból készült levesek"));
    }

    private void deleteIfExists(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) Files.delete(p);
    }
}