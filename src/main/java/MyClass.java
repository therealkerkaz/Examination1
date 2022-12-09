import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {

    public boolean ValidateSolushon(String xml1){
        boolean result = true;
        ArrayList<String> allTags = new ArrayList<>();
        ArrayList<String> openTags = new ArrayList<>();
        ArrayList<String> closeTags = new ArrayList<>();

        while(xml1.contains(">") && xml1.contains("<")) {
            Pattern commonPattern = Pattern.compile("\\<.*?\\>");
            Matcher matcher = commonPattern.matcher(xml1);
            if(matcher.find())
                allTags.add((String) matcher.group().subSequence(1, matcher.group().length()-1));

            xml1 = xml1.replaceFirst("\\<.*?\\>", "");
        }

        for (int i = 0; i< allTags.size(); i++)
        {
            Pattern deleteNotEnglishPattern = Pattern.compile("[А-Яа-я]");
            Matcher matcher = deleteNotEnglishPattern.matcher(allTags.get(i));
            Character firstChar = allTags.get(i).toCharArray()[0];

            if (matcher.find()){
                result = false;
                break;
            }
            if (firstChar.equals(' '))
            {
                result = false;
                break;
            }
            if(firstChar.equals('/'))
                closeTags.add(allTags.get(i));
            else {
                openTags.add(allTags.get(i));}

            if (i == allTags.size() - 1) {
                if (closeTags.size() != openTags.size()){
                    result = false;
                    break;
                }
                int massiveLength = allTags.size();
                int counter;
                do {
                    counter = 0;
                    for (int j = 0; j < allTags.size() - 1; j++) {

                        String secondTage;
                        String firstTage = allTags.get(j);
                        secondTage = allTags.get(j + 1).replaceFirst("[/]", "");
                        if (Objects.equals(firstTage, secondTage)){
                            allTags.remove(j);
                            allTags.remove(j);
                            counter++;
                            massiveLength = massiveLength - 2;
                        }
                    }
                    if (allTags.size() == 0)
                        break;
                } while (counter !=0);
                if (allTags.size() != 0)
                    result = false;
            }
        }
        return result;
    }
}