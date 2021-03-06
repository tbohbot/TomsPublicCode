package edu.yu.cs.com1320.project.stage2.impl;

/** "Document Store Test Code" Stage 1
 *
 * @author Tom Bohbot
 *
 */

import edu.yu.cs.com1320.project.stage2.DocumentStore;
import edu.yu.cs.com1320.project.stage2.impl.DocumentImpl;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DocumentTest {

    // Still need to test the get Doc as PDF Method!!!
    
    @Test
    public void testGetDocAsTxt () throws URISyntaxException {
        /**
         * Return the document associated with this method as a text.
         * Test Cases:
         * 1) Check if it works with a doc that is .TXT
         * 2) Check if it works with a doc that is .PDF
         */

        DocumentStoreImpl docStore = new DocumentStoreImpl();
        String inputStreamContent = "Hey, I'm Tom";
        InputStream inputStream = new ByteArrayInputStream(inputStreamContent.getBytes() );
        URI uri = new URI("Tom'sURI");
        DocumentImpl document = new DocumentImpl(uri, inputStreamContent, inputStreamContent.hashCode() );
        int testPutHashCode = docStore.putDocument(inputStream , uri , DocumentStore.DocumentFormat.TXT);
        assertEquals("Checking if getDocAsTxt works for txt docs" , inputStreamContent , document.getDocumentAsTxt());
    }

    @Test
    public void testGetDocHashCode () throws URISyntaxException {
        /**
         * Return the document associated with this method as a text.
         * Test Cases:
         * 1) Check if it works with a doc that is .TXT
         * 2) Check if it works with a doc that is .PDF
         */

        DocumentStoreImpl docStore = new DocumentStoreImpl();
        String inputStreamContent = "Hey, I'm Tom";
        int hashCode = inputStreamContent.hashCode() & 0x7fffffff;
        InputStream inputStream = new ByteArrayInputStream(inputStreamContent.getBytes() );
        URI uri = new URI("Tom'sURI");
        DocumentImpl document = new DocumentImpl(uri, inputStreamContent, inputStreamContent.hashCode());
        int testPutHashCode = docStore.putDocument(inputStream , uri , DocumentStore.DocumentFormat.TXT);
        assertEquals("Checking if getDocHashCode works for txt docs" , hashCode , document.getDocumentTextHashCode());
    }

    @Test
    public void testGetDocKey () throws URISyntaxException {
        /**
         * Return the document associated with this method as a text.
         * Test Cases:
         * 1) Check if it works with a doc that is .TXT
         * 2) Check if it works with a doc that is .PDF
         */

        DocumentStoreImpl docStore = new DocumentStoreImpl();
        String inputStreamContent = "Hey, I'm Tom";
        InputStream inputStream = new ByteArrayInputStream(inputStreamContent.getBytes() );
        URI uri = new URI("Tom'sURI");
        DocumentImpl document = new DocumentImpl(uri, inputStreamContent,inputStreamContent.hashCode());
        assertEquals("Checking if getDocHashCode works for txt docs" , uri , document.getKey());
    }
}
