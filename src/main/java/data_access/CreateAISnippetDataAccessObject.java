// Package declaration
package data_access;

// Import statements for various classes and interfaces
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import entity.AISnippet.AISnippet;
import entity.AISnippet.CommonAISnippet; // Importing the CommonAISnippet entity

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.io.FileInputStream;
import java.util.Properties;

// Class declaration for CreateAISnippetDataAccessObject implementing CreateAISnippetDataAccessInterface
public class CreateAISnippetDataAccessObject implements CreateAISnippetDataAccessInterface {

    // Implementation of the getResponse method from the interface
    @Override
    public StringBuilder getResponse(String prompt) {
        // Creating an instance of AISnippet

        String prompts = parsePrompt(prompt);
        AISnippet aiSnippet = new CommonAISnippet();

        // Set the snippet question using the provided prompt
        aiSnippet.setSnippetQuestion(prompts);

        // API endpoint URL
        String url = "https://api.openai.com/v1/chat/completions";

        // Read API key from a local properties file
        String myKey = readApiKey();

        // Model type to use
        String model = "gpt-3.5-turbo";

        try {
            // Create a URL object
            URL obj = new URL(url);

            // Open a connection to the API endpoint
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + myKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // Build the request body using entity methods
            String body = "{\"model\" : \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + aiSnippet.getSnippetQuestion() + "\"}]}";
            connection.setDoOutput(true);

            // Write the request body to the connection's output stream
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response string to extract the desired content
            String[] templist = response.toString().split("\"content\":\"")[0].split("\"");

            int i = 0;
            int j = 0;
            int k = 0;
            for (String s : templist) {
                if (Objects.equals(s, "content")) {
                    j = i;
                }
                if (Objects.equals(s, "finish_reason")) {
                    k = i;
                }
                i += 1;
            }

            j += 2;
            k -= 1;
            StringBuilder output = new StringBuilder();
            while (j < k) {
                output.append(templist[j]);
                j += 1;
            }

            // Set the snippet response using the obtained output
            aiSnippet.setResponse(output.toString());

            return output;

        } catch (IOException e) {
            // Handle IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        }
    }

    private String parsePrompt(String code) {
        return code.replaceAll("\"", " ");
    }

    // Helper method to read the API key from a local properties file
    private static String readApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("local.properties")) {
            properties.load(input);
            return properties.getProperty("gpt.key");
        } catch (IOException e) {
            // Print stack trace and return null in case of IOException
            e.printStackTrace();
            return null;
        }
    }
}
