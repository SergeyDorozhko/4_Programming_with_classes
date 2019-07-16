package by.epam.my_study.agrigation_coposition.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String word;

    Word(){}
    Word(String word){
        Pattern wordPattern = Pattern.compile("[^\\s]++"); //принимаем за слово первое совпадение с шаблоном
        Matcher findWord = wordPattern.matcher(word);

        if(findWord.find()){
            this.word = findWord.group();
        }else{
            System.out.println("Word don't find: " + word);
        }

    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        Pattern wordPattern = Pattern.compile("[^\\s]++"); //принимаем за слово первое совпадение с шаблоном
        Matcher findWord = wordPattern.matcher(word);

        if(findWord.find()){
            this.word = findWord.group();
        }else{
            System.out.println("Word don't find: " + word);
        }
    }
}
