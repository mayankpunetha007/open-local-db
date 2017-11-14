package org.opendb.java.data;


import java.io.Serializable;
import java.util.List;

/**
 * Should be a key value pair db
 * And possibly some sorting on
 * Fields having some special Annotation
 * The indexing would help in querying fast on those fields
 */
public interface DataStorage {

    /**
     * Constructor in implementing class
     * DatConstructor(String decryptionKey){
     *
     * }
     */

    /**
     * Return first entry
     * Class ABC {
     *     String a;
     *     String b;
     *     String c;
     * }
     * Match all entries having non null values
     * Return the first Matching entry
     * {"a":"123","b":null,"c":xyz}
     * Should return the first entry having a= 123 and c ="xyz";
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T read(T data);

    /**
     * Return first entry
     * Class ABC {
     *     String a;
     *     String b;
     *     String c;
     * }
     * Match all entries having non null values
     * Return the first Matching entry
     * {"a":"123","b":null,"c":"xyz"}
     * {"a":"456","b":null,"c":"ref"}
     * Should return the first entry having a= 123 or a = 456 and c =xyz  or c = ref;
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T read(T ...data);

    /**
     * Return all entries
     * Class ABC {
     *     String a;
     *     String b;
     *     String c;
     * }
     * Match all entries having non null values
     * Return the first Matching entry
     * {"a":"123","b":null,"c":"xyz"}
     * Should return the first entry having a= 123 and c =xyz ;
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> List<T> readMultiple(T data);

    /**
     * Return all entries
     * Class ABC {
     *     String a;
     *     String b;
     *     String c;
     * }
     * Match all entries having non null values
     * Return the first Matching entry
     * {"a":"123","b":null,"c":"xyz"}
     * {"a":"456","b":null,"c":"ref"}
     * Should return all entries having a= 123 or a = 456 and c =xyz  or c = ref;
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> List<T> readMultiple(T ...data);

    /**
     * As the name says
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T write(T data);

    /**
     * As the name says
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T writeMultiple(List<T> data);

    /**
     * Same as read but also deletes those entries from local db
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T take(T data);

    /**
     * Same as read but also deletes those entries from local db
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> T take(T ...data);

    /**
     * Same as read but also deletes those entries from local db
     * @param data
     * @param <T>
     * @return
     */
    <T extends Serializable> List<T> takeMultiple(List<T> data);

    /**
     * Resets the local data to use the new key
     * Should change all entries to use a new key for encryption
     */
    void resetKey(String key);


}
