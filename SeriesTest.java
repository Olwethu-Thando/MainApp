package com.mycompany.mainapp;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    private Series seriesApp;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        seriesApp = new Series();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreSystem() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void testCaptureSeries() {
        String input = "S001\nMySeries\n12\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        seriesApp.CaptureSeries();

        // Search to confirm it was captured
        String searchInput = "S001\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        seriesApp.SearchSeries();

        String output = outputStream.toString();
        assertTrue(output.contains("MySeries"), "Series should be found after capture");
    }

    @Test
    void testSearchSeriesNotFound() {
        String input = "UNKNOWN\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        seriesApp.SearchSeries();

        String output = outputStream.toString();
        assertTrue(output.contains("No series found"), "Should display 'No series found'");
    }

    @Test
    void testUpdateSeries() {
        // First, capture a series
        String captureInput = "S001\nOldName\n10\n5\n";
        System.setIn(new ByteArrayInputStream(captureInput.getBytes()));
        seriesApp.CaptureSeries();

        // Update series
        String updateInput = "S001\nNewName\n15\n12\n";
        System.setIn(new ByteArrayInputStream(updateInput.getBytes()));
        seriesApp.UpdateSeries();

        // Search to confirm update
        String searchInput = "S001\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        seriesApp.SearchSeries();

        String output = outputStream.toString();
        assertTrue(output.contains("NewName"), "Series name should be updated");
        assertTrue(output.contains("15"), "Age should be updated");
        assertTrue(output.contains("12"), "Episodes should be updated");
    }

    @Test
    void testDeleteSeries() {
        // Capture a series
        String captureInput = "S001\nDeleteMe\n10\n5\n";
        System.setIn(new ByteArrayInputStream(captureInput.getBytes()));
        seriesApp.CaptureSeries();

        // Delete series
        String deleteInput = "S001\nyes\n";
        System.setIn(new ByteArrayInputStream(deleteInput.getBytes()));
        seriesApp.DeleteSeries();

        // Search to confirm deletion
        String searchInput = "S001\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        seriesApp.SearchSeries();

        String output = outputStream.toString();
        assertTrue(output.contains("No series found"), "Series should be deleted");
    }
}
