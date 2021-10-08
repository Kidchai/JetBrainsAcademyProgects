import java.util.*;

class Main {
    public static void main(String[] args) {

        var scn = new Scanner(System.in);
        var url = scn.nextLine();
        var parts = url.split("[&?]");
        String password = null;

        for (var i = 1; i < parts.length; i++) {
            var param = parts[i].split("=");

            if (param[0].equals("pass")) {
                password = param[1];
            }

            if (param.length < 2) {
                System.out.println(param[0] + " : " + "not found");
            } else {
                System.out.println(param[0] + " : " + param[1]);
            }
        }

        if (password != null) {
            System.out.println("password : " + password);
        }
    }
}