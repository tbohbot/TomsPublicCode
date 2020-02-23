package edu.yu.cs.com1320.project.stage1.impl;

/**
 * "HashTable Test Code" Stage 1
 *
 * @author Tom Bohbot
 *
 * STOP USING AS TEXT EDITOR:
 * Code to compile: javac -cp junit/junit-4.12.jar:TomsGit/BohbotTom/DataStructures/project/stage1/src/main/java TomsGit/BohbotTom/DataStructures/project/stage1/src/test/java/edu/yu/cs/com1320/project/HashTableTest.java
 * Code to run:     java -cp junit/junit-4.12.jar:junit/hamcrest-core-1.3.jar:TomsGit/BohbotTom/DataStructures/project/stage1/src/main/java:TomsGit/BohbotTom/DataStructures/project/stage1 org.junit.runner.JUnitCore src.test.java.edu.yu.cs.com1320.project.HashTableTest
 */


import edu.yu.cs.com1320.project.impl.HashTableImpl;
import org.junit.*;
import static org.junit.Assert.*;

public class HashTableTest {

    HashTableImpl hashTable = new HashTableImpl();



    @Test
    public void testingPut() {
        /**
         * Test Cases:
         * 1) array size should be 5.
         * 2) HashTable must be generic.
         * 3) If a new key is inputted, then return null
         * 4) If an existing key is inputted, then replace the old value with new value and return the old value.
         */
        assertEquals("testing first object in list" , null , hashTable.put("hi" , "ogValue") );
        assertEquals("changing first object in list" , "ogValue" , (hashTable.put("hi" , "value2") ) );
        assertEquals("Make sure the value is being replaced when there is a collision" , "value2" , hashTable.put("hi" , "value3"));
        assertEquals("adding second object in the list" , null , hashTable.put("c" , "cValue") );
        assertEquals("Inserting the same key again" , "cValue" , hashTable.put("c" , "newCValue"));
    }

    @Test
    public void testingGet() {
        /**
         * Test Cases:
         * 1) Return the value associated with the key.
         * 2) If there is no value associated with the key, then return null
         */
        assertEquals("Testing when a value does not exist" , null , hashTable.get("hi") );
        hashTable.put("hi" , "ogValue");
        assertEquals("Testing when a value is initially entered" , "ogValue" , hashTable.get("hi") );
        hashTable.put("hi" , "value2");
        assertEquals("Testing when a key's value is altered" , "value2" , hashTable.get("hi") );
        hashTable.put("c" , "cValue");
        assertEquals("Testing when a new object is added through separate chaining" , "cValue" , hashTable.get("c") );
        hashTable.put("c" , "cValue1");
        assertEquals("Testing when a new object is altered down the chain" , "cValue1" , hashTable.get("c") );
    }

    @Test
    public void testingNullValues() {
        /**
         * Test Cases:
         * 1) If a null value is entered then the object must be removed from the hashMap
         */

        hashTable.put("hi" , "ogValue");
        assertEquals("Testing if deleting objects works." , "ogValue" , hashTable.put("hi" , null) );
        hashTable.put("hi" , "ogValue");
        hashTable.put("c" , "cValue");
        assertEquals("Testing if deleting objects works down the chain." , "cValue" , hashTable.put("c" , null) );
        hashTable.put("hi" , "ogValue1");
        hashTable.put("c" , "cValue1");
        assertEquals("Testing if deleting two objects in a row works." , "ogValue1" , hashTable.put("hi" , null) );
        assertEquals("Testing if deleting two objects in a row works." , "cValue1", hashTable.put("c" , null) );
    }

    @Test(expected = NullPointerException.class)
    public void nullDeleteValue() {
        assertEquals("Testing if deleting an object that doesn't exist works" , null, hashTable.put("c" , null) );
    }

}