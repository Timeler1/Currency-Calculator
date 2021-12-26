package sample;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class main {
    public static double getvalue(String value) throws java.io.IOException {
            double test = 0;
            String header = "X-CoinAPI-Key: E9049DF1-05DA-4BC3-AEBF-A277A63901E6";
            String[] commands = {"curl", "-H", header, "-X", "GET", "http://rest.coinapi.io/v1/assets/" + value};
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                if (i == 16) {
                    String[] solution = line.split(": ");
                    String integer = solution[1];
                    solution = integer.split(",");
                    integer = solution[0];
                    test = Double.parseDouble(integer);
                    return test;
                }
            }
            return test;
        }
    }


