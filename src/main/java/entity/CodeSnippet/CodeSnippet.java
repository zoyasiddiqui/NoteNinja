package entity.CodeSnippet;

public interface CodeSnippet {

    void setCode(String code);

    void setOutput(String output);

    String getCode();

    String getOutput();

    // Additional method to execute the code and return the output
    String executeCode();
}
