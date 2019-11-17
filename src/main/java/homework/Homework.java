package homework;

import java.util.*;

public class Homework {

    String exercise(String input) {
        if (isStringNullOrContainsOnlyWhiteSpaces(input)) {
            throw new IllegalArgumentException();
        }

        input = removeUpperCaseAndReplaceNonWordsCharactersWithSpaces(input);

        if (doesStringContainOnlyWhiteSpacesAfterRemovingSpacialCharacters(input)) {
            throw new MyExceptionForOnlySpecialCharacters();
        }

        Set<String> treeSetOfProvidedWords = new TreeSet<>(Arrays.asList(input.split(" ")));
        Map<Character, Set<String>> charWordsMap = new TreeMap<>();
        for (String word : treeSetOfProvidedWords) {
            for (Character particularLetter : word.toCharArray()) {

                if (charWordsMap.containsKey(particularLetter)) {
                    charWordsMap.get(particularLetter).add(word);
                } else {
                    Set<String> values = new TreeSet<>();
                    values.add(word);
                    charWordsMap.put(particularLetter, values);
                }

            }
        }

        StringBuilder stringBuilderForResult = new StringBuilder();

        for (Map.Entry<Character, Set<String>> entry : charWordsMap.entrySet()) {
            stringBuilderForResult.append(entry.getKey());
            stringBuilderForResult.append(": ");
            stringBuilderForResult.append(entry.getValue().toString().replaceAll(("[\\[\\]]"), ""));
            stringBuilderForResult.append("\n");
        }


        return stringBuilderForResult.toString();
    }

    private boolean doesStringContainOnlyWhiteSpacesAfterRemovingSpacialCharacters(String input) {
        return input.matches(" +");
    }

    private boolean isStringNullOrContainsOnlyWhiteSpaces(String input) {
        return input == null || input.matches(" *");
    }

    private String removeUpperCaseAndReplaceNonWordsCharactersWithSpaces(String input) {
        return input.toLowerCase()
                .replaceAll("\\W", " ");
    }
}
