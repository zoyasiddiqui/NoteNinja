// Package declaration
package data_access;

// Import statements for various classes and interfaces
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;

import javax.json.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

// Class declaration for CreateCodeSnippetDataAccessObject implementing CreateCodeSnippetDataAccessInterface
public class CreateCodeSnippetDataAccessObject implements CreateCodeSnippetDataAccessInterface {

    // Method to execute code using the Glot.io API
    public StringBuilder executeCode(String code) {

        // Parse double quotes to single quotes in the code
        String parsedCode = parseCode(code);

        // API endpoint URL for running Python code on Glot.io
        String url = "https://glot.io/api/run/python/latest";

        // Read Glot.io API key from a local properties file
        String myKey = readApiKey();
        System.out.println(myKey);

        try {
            // Create a URL object
            URL obj = new URL(url);

            // Open a connection to the Glot.io API endpoint
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Token " + myKey);
            connection.setRequestProperty("Content-type", "application/json");

            // Build the request body
            // Split the code into lines
            List<String> codeLines = Arrays.asList(code.split("\\r?\\n"));

            // Build the request body using JsonObject
            JsonArray filesArray = Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                            .add("name", "main.py")
                            .add("content", String.join("\n", codeLines)))
                    .build();

            JsonObject requestBody = Json.createObjectBuilder()
                    .add("files", filesArray)
                    .build();

            // Write the JSON payload to the request body
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream();
                 JsonWriter jsonWriter = Json.createWriter(new OutputStreamWriter(os))) {
                jsonWriter.writeObject(requestBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Get the response
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Extract the output from the response (you can modify this part based on the actual response structure)
            try (JsonReader jsonReader = Json.createReader(new StringReader(response.toString()))) {
                JsonObject jsonResponse = jsonReader.readObject();
                JsonValue output = jsonResponse.get("stdout");

                return new StringBuilder(output.toString());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ProtocolException e) {
            // Handle ProtocolException, MalformedURLException, and IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            // Handle ProtocolException, MalformedURLException, and IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Handle ProtocolException, MalformedURLException, and IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        }
    }

    // Helper method to replace double quotes with single quotes in the code
    private String parseCode(String code) {
        return code.replaceAll("\"", "'");
    }

    // Helper method to read the Glot.io API key from a local properties file
    private static String readApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("local.properties")) {
            properties.load(input);
            return properties.getProperty("glot.key");
        } catch (IOException e) {
            // Print stack trace and return null in case of IOException
            e.printStackTrace();
            return null;
        }
    }
}
