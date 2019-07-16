package by.epam.my_study.agrigation_coposition.task1;
/*
создать класс Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст, заголовок Текста.
 */

/*
test Text
Counterterrorism officers are investigating the leak of comments by the British ambassador about President Trump. The decision to call in the Metropolitan Police after Whitehall spent a week searching for the source suggests the government believes that the Official Secrets Act has been breached.
Sir Kim Darroch quit as the ambassador in Washington on Wednesday after his diplomatic dispatches had been published in The Mail on Sunday. In the messages from 2017, Sir Kim described Mr Trump’s administration as “dysfunctional” and “inept”. The day after the leak Mr Trump said that he would not deal with Sir Kim.
 */

public class Main {
    public static void main(String[] args){
        Word word = new Word("Counterterrorism officers");
        Word oneMoreWord = new Word();
        oneMoreWord.setWord("officers");

        Sentence sentence = new Sentence(word.getWord(), oneMoreWord.getWord(), "are", "investigating","the leak of comments by the British ambassador about President Trump");
        Sentence oneMoreSentense = new Sentence("The decision to call in the Metropolitan Police after Whitehall spent a week searching for the source suggests the government believes that the Official Secrets Act has been breached");

        Text text = new Text("My Story");
        text.appendSentence(sentence.getSentence(), oneMoreSentense.getSentence());

        oneMoreSentense = new Sentence("Sir Kim Darroch quit as the ambassador in Washington on Wednesday after his diplomatic dispatches had been published in The Mail on Sunday. In the messages from 2017, Sir Kim described Mr Trump’s administration as “dysfunctional” and “inept”. The day after the leak Mr Trump said that he would not deal with Sir Kim");
        text.appendSentence(oneMoreSentense.getSentence());
        text.showStory();

        text.appendSentence(sentence.getSentence());

        text.showStory();
    }
}
