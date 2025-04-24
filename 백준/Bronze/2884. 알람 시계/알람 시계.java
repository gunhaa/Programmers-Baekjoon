
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String hour = st.nextToken();
        String minute = st.nextToken();
        setAlarm(hour, minute);

        bw.write(String.valueOf(setHour));
        bw.write(" ");
        bw.write(String.valueOf(setMinute));
        bw.flush();
    }

    private static int setHour = 0;
    private static int setMinute = 0;

    private static void setAlarm(String hour, String minute){
        int intHour = Integer.parseInt(hour);
        int intMin = Integer.parseInt(minute);
        int alarmMin = intMin-45;
        if(alarmMin < 0) {
            setMinute = 60+alarmMin;
            intHour -= 1;

            if(intHour < 0) {
                setHour = 23;
            } else {
                setHour = intHour;
            }

        } else {
            setHour = intHour;
            setMinute = alarmMin;
        }
    }
}
