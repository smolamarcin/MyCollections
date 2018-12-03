package com.smola.alghoritms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourConverterTest {
    private HourConverter hourConverter = new HourConverter();
    @Test
    void shouldConvert_midnightFromAM_to24HourFormat() {
        String input = "12:00:00AM";
        String expected = "00:00:00";
        assertEquals(expected,hourConverter.convert(input));
    }

    @Test
    void shouldConvertAM_to24HoursFormat() {
        String input = "09:43:00AM";
        String expected = "09:43:00";
        assertEquals(expected,hourConverter.convert(input));
    }

    @Test
    void shouldConvertPM_to24HorusFormat() {
        System.out.println(1%12);
        String input = "07:45:54PM";
        String expected = "19:45:54";
        assertEquals(expected,hourConverter.convert(input));
    }
}