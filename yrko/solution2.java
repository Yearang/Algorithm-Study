import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class solution2 {
    static int num = 0;
    public static String[] solution(int totalTicket, String[] logs) {
        String[] answer = new String[totalTicket];

        boolean cur = false;
        SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss");
        Date end = new Date();
        Date a = new Date();

        try {
            a = transFormat.parse("09:00:00");
        } catch (Exception e) {
            System.out.println(e);
        }


//        Date to = transFormat.parse(from);
        try {
            end = transFormat.parse("10:00:00");
        } catch (Exception e) {
            System.out.println(e);
        }
        Date c = new Date();
        String[][] log = new String[logs.length][3];
        for (int i = 0; i < logs.length; i++) {
            log[i] = logs[i].split(" ");
//            이미 누가 들어가있는지 확인
            String d = log[i][2];
            try {
               c = transFormat.parse(d);
            } catch (Exception e) {
                System.out.println(e);
            }
            // 들어와 있는 사라미 없을때
            if (log[i][1].equals("request") && a.compareTo(c) < 0 && num != totalTicket) {
                String b = log[i][2];
                try {
                    a = transFormat.parse(b);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(a);
                    cal.add(Calendar.MINUTE, 1);
                    a = cal.getTime();
                    // 10시보다 넘으면 break;
                    if (a.compareTo(end) >= 0) {
                        break;
                    }
//                    System.out.println(a);
                } catch (Exception e) {
                    System.out.println(e);
                }
//                System.out.println(log[i][0]);
                answer[num] = log[i][0];
                num++;

            } else if (log[i][1].equals("leave")) {
                try {
                    a = transFormat.parse("09:00:00");
                    num--;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        String[] answer1 = new String[num];
        for (int i = 0; i < num; i++) {
            answer1[i] = answer[i];
        }
        Arrays.sort(answer1);
        return answer1;
    }

    public static void main(String[] args) {
        String[] b = {"woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44", "jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02"};
        String[] a = solution(10, b);
        for (int i = 0; i < num; i++) {
            System.out.println(a[i]);
        }


        String[] array = new String[] {"ff","bbaa","a","d","c","e","g","bc","ba"};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.err.print(array[i] + " ");
        }



    }
}
