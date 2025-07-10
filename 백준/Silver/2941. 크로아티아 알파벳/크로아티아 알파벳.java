import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        int i;
        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case 'c': {
                    if (i + 1 < input.length()) {
                        char nextC = input.charAt(i + 1);
                        if (nextC == '=' || nextC == '-') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'd': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '-') {
                            i++;
                        } else if (nextC1 == 'z') {
                            if (i + 2 < input.length()) {
                                char nextC2 = input.charAt(i + 2);
                                if (nextC2 == '=') {
                                    i += 2;
                                }
                            }
                        }
                    }
                    result++;
                }
                break;
                case 'l': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == 'j') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'n': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == 'j') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 's': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '=') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'z': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '=') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                default: {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
