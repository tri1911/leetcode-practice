package leetcodingchallenge.april2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Date: April 23, 2022
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */

// TODO: check out the better, proper solution

public class P535 {
    private final char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final int HASH_SIZE = 6; // length of hash value (can be any value)
    private final String BASE_URL = "http://tinyurl.com/";

    private Random rand = new Random();

    // the hash table with entries in the format of <key: shortUrl, value: longUrl>
    private Map<String, String> hashTable = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        // represent the longUrl by the string of characters with length of 6
        // => can cover 62^6 long urls (where 62 is the total possible characters at a certain position)
        String hashVal = null;
        // if the hash is not collided, save it into the hash table
        // otherwise, generate another hash value
        while (hashVal == null || hashTable.containsKey(hashVal)) {
            sb.setLength(0);
            for (int i = 0; i < HASH_SIZE; i++) sb.append(characters[rand.nextInt(characters.length)]);
            hashVal = sb.toString();
        }
        hashTable.put(hashVal, longUrl);
        // append the hash value into the base url to compose the short url
        String shortUrl = BASE_URL + hashVal;
        System.out.println(shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // just simply retrieve the longUrl from the hash table using the key from the shortUrl
        return hashTable.get(shortUrl.substring(shortUrl.length() - HASH_SIZE));
    }
}

/**
 * references
 * https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts
 * https://youtu.be/4cIDGXBbW34
 * <p>
 * https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/
 * https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 * http://blog.gainlo.co/index.php/2016/03/08/system-design-interview-question-create-tinyurl-system/
 * https://youtu.be/fMZMm_0ZhK4
 */
