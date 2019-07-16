package by.epam.my_study.agrigation_coposition.task1;
/*
создать класс Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст, заголовок Текста.
 */



public class Text {
    String titel;
    String text = "";

    Text(){}
    Text(String titel){
        this.titel = titel;
    }

    public void setTitel(String titel){
        this.titel = titel;
    }

    public String getTitel(){
        return titel;
    }

    public void appendSentence(String ... sentences){
        if(sentences.length > 0){
            for(int i = 0; i < sentences.length; i++){
                text += sentences[i];
            }
        }
    }


    public void showStory(){

        StringBuilder newLine = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++){
            if(i > 0 && i % 60 == 0) {
                if(newLine.charAt(i) == ' ') {
                    newLine.insert(i, "\n");
                }else{
                    boolean findEmpty = false;
                    while (findEmpty == false){
                        if (newLine.charAt(i) == ' ') {
                            newLine.insert(i,"\n");
                            i += 60;
                            findEmpty = true;
                            break;
                        }
                        i--;
                    }
                }
            }
        }

        System.out.format("%-10s %20s\n","", titel);
        System.out.format("%-4s %60s\n","",newLine);
    }


}
