package data_access;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateAISnippetDataAccessObject implements CreateAISnippetDataAccessInterface {

    @Override
    public StringBuilder getResponse(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String myKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer "+myKey);
            connection.setRequestProperty("Content-Type", "application/json");

            //build the request body
            String body = "{\"model\" : \""+ model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            //get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            //figuring out how to parse string
            String[] templist = response.toString().split("\"content\":\"")[0].split("\"");

            int i = 0;
            int j = 0;
            int k = 0;
            for (String s : templist) {
                if (Objects.equals(s, "content")){
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

            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
