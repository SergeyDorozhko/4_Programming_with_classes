package by.epam.my_study.agrigation_coposition.task1;

public class Sentence {
    private String sentence = "";
    Sentence (String ... words){
        if (words.length > 0){
            for(int i = 0; i < words.length; i++){
                sentence += words[i] + " ";
                if(i == words.length - 1){
                    sentence += ".";
                }
            }
        }
    }

    public String getSentence(){
        return sentence;
    }
}
