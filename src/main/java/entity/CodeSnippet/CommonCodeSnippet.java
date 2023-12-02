// Package declaration
package entity.CodeSnippet;

// Class declaration for CommonCodeSnippet implementing CodeSnippet interface
public class CommonCodeSnippet implements CodeSnippet {

    // Private member variables for code and output
    private String code;
    private String output;

    // Implementation of the setCode method from the CodeSnippet interface
    @Override
    public void setCode(String code) {
        // Set the code value with the provided parameter
        this.code = code;
    }

    // Implementation of the setOutput method from the CodeSnippet interface
    @Override
    public void setOutput(String output) {
        // Set the output value with the provided parameter
        this.output = output;
    }

}
