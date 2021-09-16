package com.adamfgcross.dropz.querying;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTagSearchTest {

    @Test
    public void getsAppleHashTag() {
        String testString = "have an #apple?";
        List<String> result = HashTagSearch.getHashTags(testString);
        assertTrue(result.contains("apple"));
    }

    @Test
    public void doesNotCaptureWordsWithoutHashTag() {
        String testString = "have an #apple or a pear?";
        List<String> result = HashTagSearch.getHashTags(testString);
        if (result.size() != 1) {
            fail();
        } else {
            assertFalse(result.contains("pear"));
        }
    }

    @Test
    public void capturesMultipleHashTags() {
        String testString = "have an #apple or a #pear?";
        List<String> result = HashTagSearch.getHashTags(testString);
        assertTrue(result.contains("pear") && result.contains("apple"));
    }

    @Test
    public void searchGetsCorrectNumberOfHashTags2() {
        String testString = "have an #apple or a #pear?";
        List<String> result = HashTagSearch.getHashTags(testString);
        assertEquals(2, result.size());
    }
}
