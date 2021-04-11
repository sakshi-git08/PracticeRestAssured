package RestFulBooker.extractResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WriteResponseInTextFile {

    public static void main(String[] args) throws IOException {

        // There is no need to add escape character manually. Just paste string within
        // double
        // quotes. It will automatically add escape sequence as required.
        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

        // Create a request specification
        RequestSpecification request = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        request.contentType(ContentType.JSON);
        // Adding URI
        request.baseUri("https://restful-booker.herokuapp.com/auth");
        // Adding body as string
        request.body(jsonString);

        // Calling POST method on URI. After hitting we get Response
        Response response = request.post();

        // Getting response as a string and writing in to a file
        String responseAsString = response.asString();
        // Converting in to byte array before writing
        byte[] responseAsStringByte = responseAsString.getBytes();
        // Creating a target file
        File targetFileForString = new File("src/main/resources/targetFileForString.json");
        // Writing into files
        Files.write(responseAsStringByte, targetFileForString);


        /*

In InputStreams, read() calls are said to be "blocking" method calls. That means that if no data is
 available at the time of the method call, the method will wait for data to be made available.

The available() method tells you how many bytes can be read until the read() call will block
the execution flow of your program. On most of the input streams, all call to read() are blocking,
that's why available returns 0 by default.

However, on some streams (such as BufferedInputStream, that have an internal buffer), some bytes are read and
kept in memory, so you can read them without blocking the program flow. In this case, the available() method
tells you how many bytes are kept in the buffer.
         */
        // Getting response as input stream and writing in to a file
        InputStream responseAsInputStream = response.asInputStream();
        // Creating a byte array with number of bytes of input stream (available()
        // method)
        byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
        // Reads number of bytes from the input stream and stores them into the byte
        // array responseAsInputStreamByte.
        responseAsInputStream.read(responseAsInputStreamByte);
        // Creating a target file
        File targetFileForInputStream = new File("src/main/resources/targetFileForInputStream.json");
        // Writing into files
        Files.write(responseAsInputStreamByte, targetFileForInputStream);

        // Directly getting a byte array - More optimal as it is directly getting converted to Byte
        byte[] responseAsByteArray = response.asByteArray();
        // Creating a target file
        File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
        // Writing into files
        Files.write(responseAsByteArray, targetFileForByteArray);

    }
}
