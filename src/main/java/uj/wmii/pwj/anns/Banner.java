package uj.wmii.pwj.anns;
import java.util.HashMap;

public class Banner {
    HashMap<Character, String[]> dictionary;

    Banner() {
        dictionary = new HashMap<>();
        initDictionary(dictionary);
    }

    public void printBanner(String input) {
        String[] lines = toBanner(input);
        for (String line : lines)
            System.out.println(line);
    }

    public String[] toBanner(String input) {
        if(input == null)
            return new String[0];

        int inputLen = input.length();
        input = input.toUpperCase();
        String[] result = new String[7];
        for(int i = 0; i < 7; i++){
            result[i] = "";
        }

        for(int i = 0; i < inputLen; i++){
            for(int j = 0; j < 7; j++){
                result[j] += dictionary.get(input.charAt(i))[j];
                if(i < inputLen - 1) {
                    result[j] += ' ';
                }
            }
        }
        return result;
    }

    private void initDictionary(HashMap<Character, String[]> dictionary) {
        dictionary.put('A', new String[] {
                "   #   ",
                "  # #  ",
                " #   # ",
                "#     #",
                "#######" ,
                "#     #",
                "#     #"});
        dictionary.put('B', new String[] {
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#     #",
                "#     #",
                "###### "});
        dictionary.put('C', new String[] {
                " ##### ",
                "#     #",
                "#      ",
                "#      ",
                "#      ",
                "#     #",
                " ##### "});
        dictionary.put('D', new String[] {
                "###### ",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "###### "});
        dictionary.put('E', new String[] {
                "#######",
                "#      ",
                "#      ",
                "#####  ",
                "#      ",
                "#      ",
                "#######"});
        dictionary.put('F', new String[] {
                "#######",
                "#      ",
                "#      ",
                "#####  ",
                "#      ",
                "#      ",
                "#      "});
        dictionary.put('G', new String[] {
                " ##### ",
                "#     #",
                "#      ",
                "#  ####",
                "#     #",
                "#     #",
                " ##### "});
        dictionary.put('H', new String[] {
                "#     #",
                "#     #",
                "#     #",
                "#######",
                "#     #",
                "#     #",
                "#     #"});
        dictionary.put('I', new String[] {
                "###",
                " # ",
                " # ",
                " # ",
                " # ",
                " # ",
                "###"});
        dictionary.put('J', new String[] {
                "      #",
                "      #",
                "      #",
                "      #",
                "#     #",
                "#     #",
                " ##### "});
        dictionary.put('K', new String[] {
                "#    #",
                "#   # ",
                "#  #  ",
                "###   ",
                "#  #  ",
                "#   # ",
                "#    #"});
        dictionary.put('L', new String[] {
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "#      ",
                "#######"});
        dictionary.put('M', new String[] {
                "#     #",
                "##   ##",
                "# # # #",
                "#  #  #",
                "#     #",
                "#     #",
                "#     #"});
        dictionary.put('N', new String[] {
                "#     #",
                "##    #",
                "# #   #",
                "#  #  #",
                "#   # #",
                "#    ##",
                "#     #"});
        dictionary.put('O', new String[] {
                "#######",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#######"});
        dictionary.put('P', new String[] {
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#      ",
                "#      ",
                "#      "});
        dictionary.put('Q', new String[]{
                " ##### ",
                "#     #",
                "#     #",
                "#     #",
                "#   # #",
                "#    # ",
                " #### #"});
        dictionary.put('R', new String[] {
                "###### ",
                "#     #",
                "#     #",
                "###### ",
                "#   #  ",
                "#    # ",
                "#     #"});
        dictionary.put('S', new String[] {
                " ##### ",
                "#     #",
                "#      ",
                " ##### ",
                "      #",
                "#     #",
                " ##### "});
        dictionary.put('T', new String[] {
                "#######",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   "});
        dictionary.put('U', new String[] {
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                " ##### "});
        dictionary.put('V',  new String[] {
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                " #   # ",
                "  # #  ",
                "   #   "});
        dictionary.put('W', new String[] {
                "#     #",
                "#  #  #",
                "#  #  #",
                "#  #  #",
                "#  #  #",
                "#  #  #",
                " ## ## "});
        dictionary.put('X', new String[] {
                "#     #",
                " #   # ",
                "  # #  ",
                "   #   ",
                "  # #  ",
                " #   # ",
                "#     #"});
        dictionary.put('Y', new String[] {
                "#     #",
                " #   # ",
                "  # #  ",
                "   #   ",
                "   #   ",
                "   #   ",
                "   #   "});
        dictionary.put('Z', new String[] {
                "#######",
                "     # ",
                "    #  ",
                "   #   ",
                "  #    ",
                " #     ",
                "#######"});
        dictionary.put(' ', new String[] {
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "});
    }
}