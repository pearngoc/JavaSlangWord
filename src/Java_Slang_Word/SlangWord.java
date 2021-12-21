package Java_Slang_Word;

import java.util.List;

public class SlangWord {
    private String slang;
    private List<String> definition;

    public SlangWord(){
        slang = "";
        definition = null;
    }

    public SlangWord(String slang, List<String> definition){
        this.slang = slang;
        this.definition = definition;
    }

    public String getSlang() {
        return slang;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }

    public List<String> getDefinition() {
        return definition;
    }

    public void setDefinition(List<String> definition) {
        this.definition = definition;
    }
}
