package data_access;

import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.io.FileInputStream;
import java.util.Properties;

public class CreateCodeSnippetDataAccessObject implements CreateCodeSnippetDataAccessInterface {

    public StringBuilder executeCode(String code) {

        String parsedCode = parseCode(code);

        String url = "https://glot.io/api/run/python/latest";
//        String myKey = readApiKey();
        String myKey = "cf7085cf-9a6b-4158-9e03-4570096f87c5";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Token " + myKey);
            connection.setRequestProperty("Content-type", "application/json");

            // Build the request body
            String body = "{\"files\": [{\"name\": \"main.py\", \"content\": \"" + parsedCode + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Extract the output from the response
            String output = response.toString().split(",")[0].split(":")[1];
            return new StringBuilder(output);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseCode(String code) {
        //TODO: figure out how to implement this to take any inputted code and put it in the proper format
        return code;
    }

    private static String readApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\Users\\Zoya\\IdeaProjectsUltimate\\NoteNinja\\src\\local.properties")) {
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
