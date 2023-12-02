package data_access;

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

public class CreateCodeSnippetDataAccessObject implements CreateCodeSnippetDataAccessInterface {

    public StringBuilder executeCode(String code) {

        String parsedCode = parseCode(code);

        String url = "https://glot.io/api/run/python/latest";
        String myKey = "cf7085cf-9a6b-4158-9e03-4570096f87c5";

        try {
            URL obj = new URL(url);
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
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        private String parseCode(String code) {
            //TODO: figure out how to implement this to take any inputted code and put it in the proper format

            // parse strings
            return code.replaceAll("\"", "'");


    }

    private static String readApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\Users\\Zoya\\IdeaProjectsUltimate\\NoteNinja2\\src\\local.properties")) {
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
